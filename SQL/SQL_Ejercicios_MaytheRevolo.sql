#Ejercicio 1.1
SELECT DISTINCT name
FROM products;

#Ejercicio 1.2
SELECT name, unit_price
FROM products;

#Ejercicio 1.3
SELECT product_id, name,unit_price
FROM products
WHERE unit_price<=10;

#Ejercicio 1.4
#CON AND
SELECT product_id, name, unit_price
FROM products
WHERE unit_price>= 2 AND unit_price<=99;
#CON BETWEEN
SELECT product_id, name, unit_price
FROM products
WHERE unit_price BETWEEN 2 AND 99;

#Ejercicio 1.5
SELECT name, unit_price/0.88 AS "Precio en dolares"
FROM products;

#Ejercicio 1,6
SELECT COUNT(*) AS "Número de productos"
FROM products
WHERE unit_price>=3;

#Ejercicio 1.7
SELECT name, unit_price
FROM products
WHERE unit_price>=3
ORDER BY unit_price DESC, name ASC;

#Ejercicio 1.8
#Explicito
SELECT p.*, oi.order_id
FROM order_items oi
JOIN products p
    ON p.product_id=oi.product_id;
#Implicito
SELECT p.*, oi.order_id
FROM products p, order_items oi
WHERE p.product_id=oi.product_id;

#Ejercicio 1.9
SELECT *
FROM customers
WHERE birth_date>=1974-01-01 AND points>=200;

#Ejercicio 1.10
SELECT *
FROM customers
WHERE state IN ("TX","FL","IL");

#Ejercicio 1.11
SELECT *
FROM products
WHERE unit_price BETWEEN 3 AND 29.99;

#Ejercicio 1.12
#LIKE
SELECT *
FROM shippers
WHERE name LIKE "%ett%" OR name LIKE "%att%";
#REGEXT
SELECT *
FROM shippers
WHERE name REGEXP "ett|att";

#Ejercicio 1.13
SELECT *
FROM shippers
WHERE name REGEXP "LLC$";

#Ejercicio 1.14
SELECT order_id, order_date, comments
FROM orders
WHERE comments IS NOT NULL;

#Ejercicio 1.15
#Con orders
SELECT *
FROM orders
WHERE order_date >= "2019-01-01" AND comments IS NULL
ORDER BY order_date DESC;
#Con orders_archivo
SELECT *
FROM orders_archivo
WHERE order_date >= "2019-01-01" AND comments IS NULL
ORDER BY order_date DESC;

#Ejercicio 1.16
SELECT first_name AS "Nombre",
    last_name AS "Apellido",
    points AS "Puntos",
    (points*0.20) AS Cheque_regalo
FROM customers
ORDER BY Cheque_regalo DESC;

#Ejercicio 1.17
SELECT first_name AS "Nombre",
    last_name AS "Apellido",
    points AS "Puntos",
    (points*0.20) AS Cheque_regalo
FROM customers
ORDER BY Cheque_regalo DESC
LIMIT 3;

#Ejercicio 1.18
SELECT order_id,
order_date,
os.name,
c.first_name,
c.last_name,
s.name
FROM orders o
JOIN customers c
    ON c.customer_id=o.customer_id
JOIN order_statuses os
    ON o.order_id=os.order_status_id
JOIN shippers s
    ON s.shipper_id=o.shipper_id
WHERE os.name="Shipped";

#Ejercicio 1.19
SELECT p.payment_id,p.date, i.number,
    i.payment_total,
    c.name,
    c.state,
    pm.name AS "Metodo de pago"
FROM payments p
JOIN invoices i
    USING(invoice_id)
JOIN clients c
    ON c.client_id=p.client_id
JOIN payment_methods pm
    ON p.payment_method=pm.payment_method_id
ORDER BY p.date DESC;

#Ejercicio 1.20
SELECT invoice_id,
invoice_date,
payment_total,
"PAGO PARCIAL" AS "pago"
FROM invoices
WHERE payment_date IS NOT NULL
UNION
SELECT invoice_id,
invoice_date,
payment_total,
"SIN COBRAR" AS "pago"
FROM invoices
WHERE payment_date IS NULL;

#Ejercicio con WITH ROLLUP
SELECT client_id,
    SUM(invoice_total) AS "Venta total"
FROM invoices
GROUP BY client_id WITH ROLLUP;
# Total de ventas en la fila NULL