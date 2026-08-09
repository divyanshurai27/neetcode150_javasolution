# Write your MySQL query statement below
SELECT e.name AS Employee ,d.name AS Department,e.salary AS Salary
FROM Employee e
INNER JOIN Department d
ON e.departmentId = d.id
WHERE e.salary = (
    SELECT MAX(salary)
    FROM Employee 
    WHERE departmentId = e.departmentId
)