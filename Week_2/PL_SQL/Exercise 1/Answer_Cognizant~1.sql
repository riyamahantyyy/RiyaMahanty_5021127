//Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.
BEGIN
    FOR customer IN (SELECT CustomerID, TRUNC(MONTHS_BETWEEN(SYSDATE, DOB)/12) AS Age FROM Customers)
    LOOP
        IF customer.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer.CustomerID;
        END IF;
    END LOOP;
END;
/
// A customer can be promoted to VIP status based on their balance.
ALTER TABLE Customers ADD (IsVIP VARCHAR2(3));
//Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.
BEGIN
    FOR customer IN (SELECT CustomerID, Balance FROM Customers)
    LOOP
        IF customer.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'YES'
            WHERE CustomerID = customer.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP = 'NO'
            WHERE CustomerID = customer.CustomerID;
        END IF;
    END LOOP;
END;
/
//The bank wants to send reminders to customers whose loans are due within the next 30 days.
//Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.
BEGIN
    FOR loan IN (SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate
                 FROM Loans l
                 JOIN Customers c ON l.CustomerID = c.CustomerID
                 WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan.LoanID || ' for customer ' || loan.Name || ' is due on ' || TO_CHAR(loan.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/
