
-- Query Requirements 
--1. To obtain most purchased item using number of times product id appeared -----on orders relationship and which warehouse has least quantity of that particular --product Id.

SELECT * FROM (SELECT F16_17_ORDERS.PROD_ID, F16_17_PRODUCT.PROD_NAME FROM F16_17_ORDERS
INNER JOIN F16_17_PRODUCT
ON F16_17_ORDERS.PROD_ID=F16_17_PRODUCT.PROD_ID
GROUP BY F16_17_ORDERS.PROD_ID,F16_17_PRODUCT.PROD_NAME
ORDER BY COUNT(*)DESC
) WHERE rownum <= 1;

-- PROD_ID PROD_NAME
------------ --------------------
--      5001 COVER




--2.To obtain returned orders based on delivery status on orders relationship and --to which warehouse it is returned is obtained using product Id associated with ----warehouse Id. 


SELECT ORDER_ID,DELIVERY_STATUS,PRODUCT_ID,F16_17_STORES.W_ID FROM 
(SELECT F16_17_ORDERS.DELIVERY_STATUS AS DELIVERY_STATUS, F16_17_ORDERS.ORDER_ID AS ORDER_ID, F16_17_ORDERS.PROD_ID AS PRODUCT_ID FROM F16_17_ORDERS) DELIVERY
INNER JOIN F16_17_STORES
ON F16_17_STORES.P_ID=DELIVERY.PRODUCT_ID
WHERE DELIVERY_STATUS='NOT DELIVE'
GROUP BY PRODUCT_ID,ORDER_ID,DELIVERY_STATUS,F16_17_STORES.W_ID;


-----ORDER_ID DELIVERY_S PRODUCT_ID       W_ID
------------ ---------- ---------- ----------
 --     6003 NOT DELIVE       5003          2
  --    6006 NOT DELIVE       5006          6
  --    6003 NOT DELIVE       5003          3


--3.Total profit using the difference between product price of product entity and ---seller’s product price while he delivers. 


SELECT F16_17_DELIVERS.SPROD_ID,F16_17_DELIVERS.SPROD_PRICE,F16_17_PRODUCT.PROD_PRICE ,
F16_17_PRODUCT.PROD_PRICE-F16_17_DELIVERS.SPROD_PRICE AS PROFIT
FROM F16_17_DELIVERS
INNER JOIN F16_17_PRODUCT ON F16_17_DELIVERS.SPROD_ID=F16_17_PRODUCT.PROD_ID;


-----SPROD_ID SPROD_PRICE PROD_PRICE     PROFIT
------------ ----------- ---------- ----------
--      5001          25         25          0
--      5001          20         25          5
--      5002          20         25          5
--      5003         200        250         50
--      5004        2000       2500        500
--     5005          20         29          9
--      5006          20         50         30
--      5006          19         50         31
--      5006          18         50         32
--      5006          20         50         30
--      5010          20         26          6




--4.To obtain payment type from orders relationship selected by particular -----------person of person entity. 


SELECT F16_17_ORDERS.ORDER_ID, F16_17_PERSON.FNAME, F16_17_ORDERS.PAY_TYPE FROM F16_17_ORDERS
INNER JOIN F16_17_PERSON
ON F16_17_ORDERS.P_SSN=F16_17_PERSON.P_SSN;


------ORDER_ID FNAME           PAY_TYPE
------------ --------------- ----------
--      6001 BUNNY           DEBIT
--      6002 BUNNY           DEBIT
--      6008 BUNNY           DEBIT
--      6003 SUNNY           DEBIT
--      6009 SUNNY           DEBIT
--      6004 JOHN            CREDIT
--      6010 JOHN            DEBIT
--      6005 CENA            DEBIT
--     6006 MAHESH          DEBIT
--      6007 KALYAN          CREDIT



--5.Owner selects suppliers using supplier Id based on supplier rating for    ------------products to be delivered to warehouse. 


SELECT S_NAME,S_RATING
FROM F16_17_SUPPLIER
WHERE S_RATING IN 
      (SELECT S_RATING 
       FROM  F16_17_SUPPLIER
        WHERE S_RATING>3
       )
ORDER BY S_RATING DESC ;



--S_NAME                 S_RATING
---------------------- ----------
--SUPP8                         5
--SUPP3                         5
--SUPP1                         4
--SUPP6                         4
--SUPP7                         4
--SUPP2                         4




--6. To retrieve product quantity of particular product in a particular warehouse. 


SELECT F16_17_WAREHOUSE.W_ID,F16_17_WAREHOUSE.W_NAME,F16_17_STORES.P_QUANTITY,F16_17_PRODUCT.PROD_ID,F16_17_PRODUCT.PROD_NAME FROM F16_17_STORES
INNER JOIN F16_17_PRODUCT
ON F16_17_STORES.P_ID=F16_17_PRODUCT.PROD_ID
INNER JOIN F16_17_WAREHOUSE
ON F16_17_STORES.W_ID=F16_17_WAREHOUSE.W_ID
WHERE F16_17_STORES.P_QUANTITY>200;



--      W_ID W_NAME     P_QUANTITY    PROD_ID PROD_NAME
------------ ---------- ---------- ---------- --------------------
--         3 FORTWORTH         250       5003 IPAD
--         4 MANSFIELD         258       5004 LADDER
--         5 COPPEL            251       5005 PIN


--7.To obtain product rating from product entity given by customer. 



SELECT F16_17_PERSON.FNAME,F16_17_ORDERS.ORDER_ID,F16_17_PRODUCT.PROD_ID,F16_17_PRODUCT.RATING FROM F16_17_ORDERS 
INNER JOIN F16_17_PERSON 
ON F16_17_PERSON.P_SSN=F16_17_ORDERS.P_SSN
INNER JOIN F16_17_PRODUCT
ON F16_17_ORDERS.PROD_ID=F16_17_PRODUCT.PROD_ID
WHERE F16_17_PRODUCT.RATING>3;


--FNAME             ORDER_ID    PROD_ID     RATING
----------------- ---------- ---------- ----------
--BUNNY                 6001       5001          4
--BUNNY                 6002       5002          4
--BUNNY                 6008       5001          4
--SUNNY                 6009       5001          4
--JOHN                  6004       5004          4
--JOHN                  6010       5001          4
--CENA                  6005       5005          4
--MAHESH                6006       5006          4
--KALYAN                6007       5007          5




--8.To obtain product id which are ordered in a particular time using repetitions in --order details.

SELECT * FROM (SELECT SPROD_ID FROM F16_17_DELIVERS
WHERE DELIVERY_TIME BETWEEN '01/NOV/2016'
AND  '30/NOV/2016'
GROUP BY SPROD_ID
ORDER BY COUNT(*) DESC
) WHERE rownum <= 1;


-- -SPROD_ID
------------
--      5006


--9. To obtain total number of orders made by both customers and employees ------using order details.

SELECT FNAME,LNAME,(SELECT COUNT(ORDER_ID)
FROM F16_17_ORDERS
WHERE F16_17_PERSON.P_SSN=F16_17_ORDERS.P_SSN) AS NO_OF_ORDERS
FROM F16_17_PERSON;



--FNAME           LNAME           NO_OF_ORDERS
----------------- --------------- ------------
--BUNNY           ALLU                       1
--BUNNY           AB                         2
--SUNNY           ABC                        2
--JOHN            ROBB                       2
--CENA            STARK                      1
--MAHESH          AMC                        1
--KALYAN          CAM                        1
--EMP1            L1                         0
--EMP2            L2                         0
--EMP3            L3                         0
--EMP4            L4                         0

--FNAME           LNAME           NO_OF_ORDERS
----------------- --------------- ------------
--EMP5            L5                         0
--EMP6            L6                         0
--EMP7            L7                         0
--EMP8            L8                         0

