-- MySQL
-- Problem statement here: https://leetcode.com/problems/duplicate-emails/
SELECT email
FROM Person
GROUP BY email
HAVING (COUNT(id) > 1);