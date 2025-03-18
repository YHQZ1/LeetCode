# Write your MySQL query statement below
SELECT w1.id 
FROM weather w1
LEFT JOIN weather w2 
ON DATE_SUB(w1.recorddate, INTERVAL 1 DAY) = w2.recorddate
WHERE w1.temperature > w2.temperature;
