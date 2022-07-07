-- MySQL
-- Problem statement here: https://leetcode.com/problems/exchange-seats/
WITH finalStudentID AS (SELECT MAX(id) FROM Seat)
SELECT *
FROM (
    ( SELECT id, student FROM Seat
      WHERE (MOD(id,2) = 1) AND (id IN finalStudentID ) )
    UNION
    ( SELECT id+1 AS id, student FROM Seat
      WHERE (MOD(id,2) = 1) AND (id NOT IN finalStudentID) )
    UNION
    ( SELECT id-1 AS id, student FROM Seat WHERE MOD(id,2) = 0 )
) AS tempTable
ORDER BY id;