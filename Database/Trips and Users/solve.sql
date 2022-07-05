-- MySQL
-- Problem statement here: https://leetcode.com/problems/trips-and-users/
SELECT subquery1.Day AS 'Day', IF( ISNULL(total_cancel), 0.00, ROUND(total_cancel/total_request, 2) ) AS 'Cancellation Rate'
FROM
(
    SELECT tr.request_at AS Day, COUNT(tr.id) AS total_request
    FROM Trips tr, Users u1, Users u2
    WHERE   tr.client_id = u1.users_id AND u1.banned = 'No'
            AND
            tr.driver_id = u2.users_id AND u2.banned = 'No' 
            AND
            ( tr.request_at >= '2013-10-01' AND tr.request_at <= '2013-10-03' )
    GROUP BY Day
) AS subquery1
LEFT JOIN
( 
    SELECT tr.request_at AS Day, COUNT(tr.id) AS total_cancel
    FROM Trips tr, Users u1, Users u2
    WHERE   tr.client_id = u1.users_id AND u1.banned = 'No'
            AND
            tr.driver_id = u2.users_id AND u2.banned = 'No'
            AND
            ( tr.status = 'cancelled_by_driver' OR tr.status = 'cancelled_by_client' )
    GROUP BY Day
) AS subquery2
ON subquery1.Day = subquery2.Day;