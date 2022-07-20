-- MAPLE SYRUP PRODUCT
INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, IMAGE, PRICE, STOCK, TYPE)
VALUES (1, 'Sirop1', 'Sirop érable numero 1', 'Image1', 1.50, 11, 'AMBER'),
       (2, 'Sirop2', 'Sirop érable numero 2', 'Image2', 2.50, 12, 'DARK'),
       (3, 'Sirop3', 'Sirop érable numero 3', 'Image3', 3.50, 13, 'CLEAR'),
       (4, 'Sirop4', 'Sirop érable numero 4', 'Image4', 4.50, 14, 'AMBER'),
       (5, 'Sirop5', 'Sirop érable numero 5', 'Image5', 5.50, 15, 'DARK'),
       (6, 'Sirop6', 'Sirop érable numero 6', 'Image6', 6.50, 16, 'CLEAR');


-- CART LINE
INSERT INTO CART_LINE (PRODUCT_ID, NAME, IMAGE, PRICE, QTY)
VALUES (1, 'Sirop1', 'Image1', 1.50, 1),
       (2, 'Sirop2', 'Image2', 5, 2);