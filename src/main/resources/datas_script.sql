
------------------------------------------- CART LINE -------------------------------------------
create table cart_line
(
    id         INTEGER not null
        constraint cart_line_pk
            primary key autoincrement,
    name       TEXT    not null,
    image      TEXT    not null,
    price      REAL    not null,
    qty        INTEGER not null,
    product_id TEXT    not null
);

create unique index cart_line_id_uindex
    on cart_line (id);


----------------------------------------- CATALOGUE ITEM -----------------------------------------
create table catalogue_item
(
    id      TEXT    not null
        constraint catalogue_item_pk
            primary key,
    name    TEXT    not null,
    image   TEXT    not null,
    price   REAL    not null,
    max_qty INTEGER not null,
    type    TEXT    not null
);

create unique index catalogue_item_id_uindex
    on catalogue_item (id);

INSERT INTO CATALOGUE_ITEM (ID, NAME, IMAGE, PRICE, MAX_QTY, TYPE)
VALUES ('S1', 'Sirop1', 'Image1', 1.50, 11, 'A');
INSERT INTO CATALOGUE_ITEM (ID, NAME, IMAGE, PRICE, MAX_QTY, TYPE)
VALUES ('S2', 'Sirop2', 'Image2', 2.50, 12, 'D');
INSERT INTO CATALOGUE_ITEM (ID, NAME, IMAGE, PRICE, MAX_QTY, TYPE)
VALUES ('S3', 'Sirop3', 'Image3', 3.50, 13, 'C');
INSERT INTO CATALOGUE_ITEM (ID, NAME, IMAGE, PRICE, MAX_QTY, TYPE)
VALUES ('S4', 'Sirop4', 'Image4', 4.50, 14, 'A');
INSERT INTO CATALOGUE_ITEM (ID, NAME, IMAGE, PRICE, MAX_QTY, TYPE)
VALUES ('S5', 'Sirop5', 'Image5', 5.50, 15, 'D');
INSERT INTO CATALOGUE_ITEM (ID, NAME, IMAGE, PRICE, MAX_QTY, TYPE)
VALUES ('S6', 'Sirop6', 'Image6', 6.50, 16, 'C');


------------------------------------------- MAPLE SYRUP -------------------------------------------
create table maple_syrup
(
    id          TEXT    not null
        constraint maple_syrup_pk
            primary key,
    name        TEXT    not null,
    description TEXT    not null,
    image       TEXT    not null,
    price       REAL    not null,
    stock       INTEGER not null,
    type        TEXT    not null
);

create unique index maple_syrup_id_uindex
    on maple_syrup (id);

INSERT INTO MAPLE_SYRUP (ID, NAME, DESCRIPTION, IMAGE, PRICE, STOCK, TYPE)
VALUES ('S1', 'Sirop1', 'Sirop érable numero 1', 'Image1', 1.50, 11, 'A');
INSERT INTO MAPLE_SYRUP (ID, NAME, DESCRIPTION, IMAGE, PRICE, STOCK, TYPE)
VALUES ('S2', 'Sirop2', 'Sirop érable numero 2', 'Image2', 2.50, 12, 'D');
INSERT INTO MAPLE_SYRUP (ID, NAME, DESCRIPTION, IMAGE, PRICE, STOCK, TYPE)
VALUES ('S3', 'Sirop3', 'Sirop érable numero 3', 'Image3', 3.50, 13, 'C');
INSERT INTO MAPLE_SYRUP (ID, NAME, DESCRIPTION, IMAGE, PRICE, STOCK, TYPE)
VALUES ('S4', 'Sirop4', 'Sirop érable numero 4', 'Image4', 4.50, 14, 'A');
INSERT INTO MAPLE_SYRUP (ID, NAME, DESCRIPTION, IMAGE, PRICE, STOCK, TYPE)
VALUES ('S5', 'Sirop5', 'Sirop érable numero 5', 'Image5', 5.50, 15, 'D');
INSERT INTO MAPLE_SYRUP (ID, NAME, DESCRIPTION, IMAGE, PRICE, STOCK, TYPE)
VALUES ('S6', 'Sirop6', 'Sirop érable numero 6', 'Image6', 6.50, 16, 'C');


------------------------------------------- ORDER LINE -------------------------------------------
create table order_line
(
    product_id TEXT    not null,
    qty        INTEGER not null,
    id         INTEGER not null
        constraint order_line_pk
            primary key autoincrement
);

create unique index order_line_id_uindex
    on order_line (id);



