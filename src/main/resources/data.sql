-- Customers

INSERT INTO customers
VALUES (1, 'Hari');
INSERT INTO customers
VALUES (2, 'Nari');
INSERT INTO customers
VALUES (3, 'Mani');
INSERT INTO customers
VALUES (4, 'Tharun');
INSERT INTO customers
VALUES (5, 'Haritha');
INSERT INTO customers
VALUES (6, 'Thanu');
INSERT INTO customers
VALUES (7, 'Kaushik');
INSERT INTO customers
VALUES (8, 'Sailu');
INSERT INTO customers
VALUES (9, 'Suguna');
INSERT INTO customers
VALUES (10, 'Subbu');


-- Transactions

INSERT INTO transactions
VALUES (1, 1, 120.00, DATEADD('DAY', -10, CURRENT_DATE)),
       (2, 1, 75.00, DATEADD('DAY', -40, CURRENT_DATE)),
       (3, 1, 200.00, DATEADD('DAY', -70, CURRENT_DATE)),

       (4, 2, 110.00, DATEADD('DAY', -15, CURRENT_DATE)),
       (5, 2, 90.00, DATEADD('DAY', -45, CURRENT_DATE)),
       (6, 2, 60.00, DATEADD('DAY', -75, CURRENT_DATE)),

       (7, 3, 250.00, DATEADD('DAY', -5, CURRENT_DATE)),
       (8, 3, 80.00, DATEADD('DAY', -35, CURRENT_DATE)),
       (9, 3, 130.00, DATEADD('DAY', -65, CURRENT_DATE)),

       (10, 4, 45.00, DATEADD('DAY', -8, CURRENT_DATE)),
       (11, 4, 55.00, DATEADD('DAY', -38, CURRENT_DATE)),
       (12, 4, 105.00, DATEADD('DAY', -68, CURRENT_DATE)),

       (13, 5, 175.00, DATEADD('DAY', -12, CURRENT_DATE)),
       (14, 5, 95.00, DATEADD('DAY', -42, CURRENT_DATE)),
       (15, 5, 65.00, DATEADD('DAY', -72, CURRENT_DATE)),

       (16, 6, 300.00, DATEADD('DAY', -9, CURRENT_DATE)),
       (17, 6, 125.00, DATEADD('DAY', -39, CURRENT_DATE)),
       (18, 6, 85.00, DATEADD('DAY', -69, CURRENT_DATE)),

       (19, 7, 140.00, DATEADD('DAY', -7, CURRENT_DATE)),
       (20, 7, 70.00, DATEADD('DAY', -37, CURRENT_DATE)),
       (21, 7, 220.00, DATEADD('DAY', -67, CURRENT_DATE)),

       /*(22, 8, 180.00, DATEADD('DAY', -11, CURRENT_DATE)),
       (23, 8, 100.00, DATEADD('DAY', -41, CURRENT_DATE)),
       (24, 8, 50.00, DATEADD('DAY', -71, CURRENT_DATE)),*/


       (25, 9, 260.00, DATEADD('DAY', -13, CURRENT_DATE)),
       (26, 9, 115.00, DATEADD('DAY', -43, CURRENT_DATE)),
       (27, 9, 75.00, DATEADD('DAY', -73, CURRENT_DATE));

      /* (28, 10, 135.00, DATEADD('DAY', -14, CURRENT_DATE)),
       (29, 10, 85.00, DATEADD('DAY', -44, CURRENT_DATE)),
       (30, 10, 195.00, DATEADD('DAY', -74, CURRENT_DATE));*/