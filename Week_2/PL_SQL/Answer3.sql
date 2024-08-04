/*Exercise 3: Stored Procedures

Scenario 1: The bank needs to process monthly interest for all savings accounts.
o	Question: Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.

Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
o	Question: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.

Scenario 3: Customers should be able to transfer funds between their accounts.
o	Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.*/

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR account IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings')
    LOOP
        UPDATE Accounts
        SET Balance = Balance + (Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = account.AccountID;
    END LOOP;

    COMMIT;
END ProcessMonthlyInterest;
/
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_Department VARCHAR2,
    p_BonusPercentage NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercentage / 100)
    WHERE Department = p_Department;

    COMMIT;
END UpdateEmployeeBonus;
/
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_FromAccountID NUMBER,
    p_ToAccountID NUMBER,
    p_Amount NUMBER
) IS
    InsufficientFunds EXCEPTION;
    v_FromBalance NUMBER;
BEGIN
    -- Check the balance of the source account
    SELECT Balance INTO v_FromBalance
    FROM Accounts
    WHERE AccountID = p_FromAccountID
    FOR UPDATE;

    -- Ensure there are sufficient funds
    IF v_FromBalance < p_Amount THEN
        RAISE InsufficientFunds;
    END IF;

    -- Deduct the amount from the source account
    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccountID;

    -- Add the amount to the destination account
    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccountID;

    COMMIT;
EXCEPTION
    WHEN InsufficientFunds THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in the source account.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/
