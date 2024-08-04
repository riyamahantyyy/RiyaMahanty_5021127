// Scenario 1: Calculate the age of customers for eligibility checks.
// o	Question: Write a function CalculateAge that takes a customer's date of birth as input and returns their age in years.

CREATE OR REPLACE FUNCTION CalculateAge(p_DOB DATE) 
RETURN NUMBER IS
    v_Age NUMBER;
BEGIN
    v_Age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);
    RETURN v_Age;
END CalculateAge;
/


// Scenario 2: The bank needs to compute the monthly installment for a loan.
// o	Question: Write a function CalculateMonthlyInstallment that takes the loan amount, interest rate, and loan duration in years as input and returns the monthly installment amount.

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_LoanAmount NUMBER,
    p_AnnualInterestRate NUMBER,
    p_DurationYears NUMBER
) RETURN NUMBER IS
    v_MonthlyInterestRate NUMBER;
    v_TotalMonths NUMBER;
    v_MonthlyInstallment NUMBER;
BEGIN
    v_MonthlyInterestRate := p_AnnualInterestRate / 100 / 12;
    v_TotalMonths := p_DurationYears * 12;

    IF v_MonthlyInterestRate = 0 THEN
        v_MonthlyInstallment := p_LoanAmount / v_TotalMonths;
    ELSE
        v_MonthlyInstallment := p_LoanAmount * v_MonthlyInterestRate / 
            (1 - POWER(1 + v_MonthlyInterestRate, -v_TotalMonths));
    END IF;

    RETURN v_MonthlyInstallment;
END CalculateMonthlyInstallment;
/


// Scenario 3: Check if a customer has sufficient balance before making a transaction.
// o	Question: Write a function HasSufficientBalance that takes an account ID and an amount as input and returns a boolean indicating whether the account has at least the specified amount.

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_AccountID NUMBER,
    p_Amount NUMBER
) RETURN BOOLEAN IS
    v_Balance NUMBER;
BEGIN
    -- Retrieve the balance for the given account ID
    SELECT Balance INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_AccountID;

    -- Check if the balance is sufficient
    IF v_Balance >= p_Amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        RETURN FALSE;
END HasSufficientBalance;
/
