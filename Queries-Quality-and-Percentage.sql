1# Write your MySQL query statement below
2
3select query_name ,
4    round(avg(rating / position), 2) as quality,
5    round(sum(case when rating < 3 then 1 else 0 end)* 100.0 
6        /count(*),
7        2) as poor_query_percentage
8from Queries 
9group by query_name;        