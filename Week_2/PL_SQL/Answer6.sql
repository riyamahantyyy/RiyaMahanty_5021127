/*Exercise 6: Cursors

Scenario 1: Generate monthly statements for all customers.
o	Question: Write a PL/SQL block using an explicit cursor GenerateMonthlyStatements that retrieves all transactions for the current month and prints a statement for each customer.
Scenario 2: Apply annual fee to all accounts.
o	Question: Write a PL/SQL block using an explicit cursor ApplyAnnualFee that deducts an annual maintenance fee from the balance of all accounts.
Scenario 3: Update the interest rate for all loans based on a new policy.
o	Question: Write a PL/SQL block using an explicit cursor UpdateLoanInterestRates that fetches all loans and updates their interest rates based on the new policy.*/

DECLARE
    CURSOR c_Transactions IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
    
    v_CustomerID Customers.CustomerID%TYPE;
    v_Name Customers.Name%TYPE;
    v_TransactionDate Transactions.TransactionDate%TYPE;
    v_Amount Transactions.Amount%TYPE;
    v_TransactionType Transactions.TransactionType%TYPE;
BEGIN
    OPEN c_Transactions;
    LOOP
        FETCH c_Transactions INTO v_CustomerID, v_Name, v_TransactionDate, v_Amount, v_TransactionType;
        EXIT WHEN c_Transactions%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_CustomerID);
        DBMS_OUTPUT.PUT_LINE('Name: ' || v_Name);
        DBMS_OUTPUT.PUT_LINE('Date: ' || TO_CHAR(v_TransactionDate, 'YYYY-MM-DD'));
        DBMS_OUTPUT.PUT_LINE('Amount: ' || v_Amount);
        DBMS_OUTPUT.PUT_LINE('Type: ' || v_TransactionType);
        DBMS_OUTPUT.PUT_LINE('------------------------');
    END LOOP;
    CLOSE c_Transactions;
END;
/
DECLARE
    CURSOR c_Accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_AccountID Accounts.AccountID%TYPE;
    v_Balance Accounts.Balance%TYPE;
    v_AnnualFee CONSTANT NUMBER := 50; -- Example annual fee
BEGIN
    OPEN c_Accounts;
    LOOP
        FETCH c_Accounts INTO v_AccountID, v_Balance;
        EXIT WHEN c_Accounts%NOTFOUND;

        -- Deduct annual fee
        UPDATE Accounts
        SET Balance = Balance - v_AnnualFee
        WHERE AccountID = v_AccountID;
    END LOOP;
    CLOSE c_Accounts;

    COMMIT;
END;
/
DECLARE
    CURSOR c_Loans IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_LoanID Loans.LoanID%TYPE;
    v_InterestRate Loans.InterestRate%TYPE;
BEGIN
    OPEN c_Loans;
    LOOP
        FETCH c_Loans INTO v_LoanID, v_InterestRate;
        EXIT WHEN c_Loans%NOTFOUND;

        -- Apply new policy: for example, increase all interest rates by 0.5%
        UPDATE Loans
        SET InterestRate = v_InterestRate + 0.5
        WHERE LoanID = v_LoanID;
    END LOOP;
    CLOSE c_Loans;

    COMMIT;
END;
/
