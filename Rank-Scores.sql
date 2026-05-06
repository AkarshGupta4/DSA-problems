1# Write your MySQL query statement below
2
3
4SELECT 
5    score,
6    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
7FROM Scores;