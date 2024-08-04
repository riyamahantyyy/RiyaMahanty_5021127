//Scenario 1: Group all customer-related procedures and functions into a package.
//o	Question: Create a package CustomerManagement with procedures for adding a new customer, updating customer details, and a function to get customer balance.

CREATE OR REPLACE PACKAGE CustomerManagement IS
    PROCEDURE AddNewCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    );

    PROCEDURE UpdateCustomerDetails(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    );

    FUNCTION GetCustomerBalance(p_CustomerID NUMBER) RETURN NUMBER;
END CustomerManagement;
/
CREATE OR REPLACE PACKAGE BODY CustomerManagement IS
    PROCEDURE AddNewCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);

        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_CustomerID || ' already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END AddNewCustomer;

    PROCEDURE UpdateCustomerDetails(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name, DOB = p_DOB, Balance = p_Balance, LastModified = SYSDATE
        WHERE CustomerID = p_CustomerID;

        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance(p_CustomerID NUMBER) RETURN NUMBER IS
        v_Balance NUMBER;
    BEGIN
        SELECT Balance INTO v_Balance
        FROM Customers
        WHERE CustomerID = p_CustomerID;

        RETURN v_Balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            RETURN NULL;
    END GetCustomerBalance;
END CustomerManagement;
/


//Scenario 2: Create a package to manage employee data.
//o	Question: Write a package EmployeeManagement with procedures to hire new employees, update employee details, and a function to calculate annual salary.
CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE HireEmployee(
        p_EmployeeID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2,
        p_HireDate DATE
    );

    PROCEDURE UpdateEmployeeDetails(
        p_EmployeeID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2
    );

    FUNCTION CalculateAnnualSalary(p_EmployeeID NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS
    PROCEDURE HireEmployee(
        p_EmployeeID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2,
        p_HireDate DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, p_HireDate);

        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_EmployeeID || ' already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails(
        p_EmployeeID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_Name, Position = p_Position, Salary = p_Salary, Department = p_Department
        WHERE EmployeeID = p_EmployeeID;

        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(p_EmployeeID NUMBER) RETURN NUMBER IS
        v_Salary NUMBER;
    BEGIN
        SELECT Salary INTO v_Salary
        FROM Employees
        WHERE EmployeeID = p_EmployeeID;

        RETURN v_Salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            RETURN NULL;
    END CalculateAnnualSalary;
END EmployeeManagement;
/

//Scenario 3: Group all account-related operations into a package.
//o	Question: Create a package AccountOperations with procedures for opening a new account, closing an account, and a function to get the total balance of a customer across all accounts.
CREATE OR REPLACE PACKAGE AccountOperations IS
    PROCEDURE OpenNewAccount(
        p_AccountID NUMBER,
        p_CustomerID NUMBER,
        p_AccountType VARCHAR2,
        p_Balance NUMBER
    );

    PROCEDURE CloseAccount(p_AccountID NUMBER);

    FUNCTION GetTotalCustomerBalance(p_CustomerID NUMBER) RETURN NUMBER;
END AccountOperations;
/
CREATE OR REPLACE PACKAGE BODY AccountOperations IS
    PROCEDURE OpenNewAccount(
        p_AccountID NUMBER,
        p_CustomerID NUMBER,
        p_AccountType VARCHAR2,
        p_Balance NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_AccountType, p_Balance, SYSDATE);

        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Account with ID ' || p_AccountID || ' already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END OpenNewAccount;

    PROCEDURE CloseAccount(p_AccountID NUMBER) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_AccountID;

        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END CloseAccount;

    FUNCTION GetTotalCustomerBalance(p_CustomerID NUMBER) RETURN NUMBER IS
        v_TotalBalance NUMBER := 0;
    BEGIN
        SELECT SUM(Balance) INTO v_TotalBalance
        FROM Accounts
        WHERE CustomerID = p_CustomerID;

        RETURN NVL(v_TotalBalance, 0);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            RETURN 0;
    END GetTotalCustomerBalance;
END AccountOperations;
/
