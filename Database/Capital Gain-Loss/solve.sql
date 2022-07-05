-- MySQL
-- Problem statement here: https://leetcode.com/problems/capital-gainloss/
SELECT stock_name, SUM(gain) AS capital_gain_loss
FROM (
    SELECT stock_name,
           IF( operation = 'Sell', SUM(price), -SUM(price) ) AS gain
    FROM Stocks
    GROUP BY stock_name, operation
) AS subquery1
GROUP BY stock_name;