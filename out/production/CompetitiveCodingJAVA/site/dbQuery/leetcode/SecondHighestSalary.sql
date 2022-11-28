//M1
select max(salary) as SecondHighestSalary
from Employee
where salary < (select max(salary) from Employee)

//M2
SELECT
    (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary
;

//M3
SELECT MAX(SALARY) as SecondHighestSalary
FROM Employee
WHERE Salary NOT IN (SELECT MAX(Salary)
FROM Employee)

