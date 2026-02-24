1
2
3
4SELECT e.name  AS Employee,
5    d.name AS Department,
6    e.salary AS Salary
7FROM Employee e
8JOIN Department d
9ON e.departmentId=d.id
10WHERE(
11    SELECT COUNT(DISTINCT e2.Salary)
12    FROM Employee e2
13    WHERE e2.departmentId=e.departmentId
14    AND e2.salary>e.salary
15)<3;