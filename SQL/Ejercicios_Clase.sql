#Ejercicio2
SELECT * FROM orders WHERE order_date >= "2021-01-01";
#Ejemplo
SELECT * FROM customers WHERE birth_date>"1990-01-01" AND points>1000;
SELECT * FROM customers WHERE birth_date>"1990-01-01" OR points>1000;
SELECT * FROM customers WHERE birth_date>"1990-01-01" OR (points>1000 AND state="VA");
#Ejercicio3
SELECT * FROM order_items WHERE order_id = 6 AND quantity*unit_price>=30;
#EJERCICIO
SELECT *
from customers
wHERE state ="VA" OR state= "GA" OR state="FL";
#Ejemplo simplificado

wHERE state ="VA" OR wHERE state NOT IN ("VA, GA, FL");

SELECT *
FROM products
WHERE quantity_in_stock=49 OR quantity_in_stock=38 or quantity_in_stock=72;

SELECT *
FROM products
WHERE quantity_in_stock IN (49,38,72);

SELECT *
FROM customers
WHERE points BETWEEN 1000 AND 3000;

SELECT *
FROM customers
WHERE birth_date BETWEEN "1990-01-01" AND "2000-01-01";

SELECT * FROM customers WHERE last_name LIKE "b%";
#%b% contengan b
#%y acabe en y
#b% inicie con b
#____y #caracteres y

SELECT *
FROM customers
WHERE address LIKE "%TRAIN%" OR address LIKE "%AVENUE%";

SELECT *
FROM customers
WHERE phone LIKE "%9";

SELECT *
FROM customers
WHERE phone NOT LIKE "%9";

SELECT *
FROM customers
WHERE first_name REGEXP "ELKA|AMBUR";

SELECT *
FROM customers
WHERE first_name REGEXP "ELKA|AMBUR";

SELECT *
FROM customers
WHERE last_name REGEXP "EY$|ON$";

SELECT *
FROM customers
WHERE last_name REGEXP "^MY|SE";

SELECT *
FROM customers
WHERE last_name REGEXP "B[RU]";

SELECT *
FROM orders
WHERE shipped_date IS NULL;

SELECT *
FROM orders
WHERE shipped_date ORDER BY ;

SELECT *,quantity*unit_price AS total
FROM order_items
WHERE order_id=2
ORDER BY total DESC;

SELECT *
FROM customers
ORDER BY points DESC
LIMIT 3;

SELECT *
FROM orders
INNER JOIN customers;

SELECT *
FROM orders
INNER JOIN customers
    ON orders.customer_id=customers.customer_id;

#Error porque es ambiguo no sabe de que cojer
SELECT order_id, first_name, last_name, customer_id
FROM orders
INNER JOIN customers
    ON orders.customer_id=customers.customer_id;

SELECT order_id, first_name, last_name, orders.customer_id
FROM orders
INNER JOIN customers
    ON orders.customer_id=customers.customer_id;

SELECT order_id, oi.product_id, products.name, quantity,oi.unit_price
FROM order_items oi
JOIN products
    ON oi.product_id=products.product_id;

SELECT e.employee_id, e.first_name AS nombre,m.first_name AS manager
FROM employees e
JOIN employees m
    ON e.reports_to=m.employee_id;

SELECT *
FROM orders o
JOIN customers c
    ON o.customer_id=c.customer_id
JOIN order_statuses os
    ON o.status=os.order_status_id;

SELECT o.order_id,o.order_date,c.first_name,c.last_name,os.name AS estado
FROM orders o
JOIN customers c
    ON o.customer_id=c.customer_id
JOIN order_statuses os
    ON o.status=os.order_status_id;


SELECT p.date,p.invoice_id,cl.name,p.amount,pm.name AS "Metodo de pago"
FROM payments p
JOIN clients cl
    ON p.client_id=cl.client_id
JOIN payment_methods pm
    ON p.payment_method=pm.payment_method_id;

SELECT *
FROM order_items oi
JOIN order_item_notes oin
    ON oi.order_id=oin.order_id
    AND oi.product_id=oin.product_id;

SELECT *
FROM customers c
JOIN orders o
    ON c.customer_id=o.customer_id
ORDER BY c.customer_id;

SELECT *
FROM customers c
LEFT JOIN orders o
    ON c.customer_id=o.customer_id
ORDER BY c.customer_id;

SELECT oi.quantity, p.name,p.product_id
FROM products p
LEFT JOIN order_items oi
    ON p.product_id=oi.product_id
ORDER BY p.product_id;

SELECT c.customer_id,c.first_name,o.order_id AS "Order ID",s.name as "Shipper Name"
FROM customers c
LEFT JOIN orders o
    ON c.customer_id=o.customer_id
LEFT JOIN shippers s
    ON o.shipper_id=s.shipper_id
ORDER BY c.customer_id ASC;

SELECT o.order_id,o.order_date, c.first_name AS "Cliente",os.name as "Estado_orden"
FROM orders o
LEFT JOIN customers c
    ON c.customer_id=o.customer_id
LEFT JOIN order_statuses os
    ON os.order_status_id=o.order_id;


SELECT p.date,p.invoice_id,cl.name,p.amount,pm.name as "Metodo de pago"
FROM payments p
JOIN clients cl
    USING (client_id)
JOIN payment_methods pm
    ON p.payment_method=pm.payment_method_id;


SELECT
    customer_id,
    first_name,
    points,
    "BRONCE" AS tipo
FROM customers
WHERE points BETWEEN 0 AND 1999
UNION
SELECT
    customer_id,
    first_name,
    points,
    " PLATA" AS tipo
FROM customers
WHERE points BETWEEN 2000 AND 3000
UNION
SELECT
    customer_id,
    first_name,
    points,
    "ORO" AS tipo
FROM customers
WHERE points BETWEEN 2000 AND 3000;

INSERT INTO customers
VALUES(
    DEFAULT,"John","Anderson","1990-01-01",
    NULL,"calle X","ciudad","CA",DEFAULT
    )

INSERT INTO products(name,quantity_in_stock, unit_price)
VALUES
    ("A",65,3.0),
    ("B",59,3.5),
    ("C",67,7.7);


UPDATE customers
SET points = points + 50
WHERE birth_date < '1990-01-01';

UPDATE orders
SET comments = 'Cliente GOLD'
WHERE customer_id IN (SELECT customer_id FROM customers WHERE points > 3000);

SELECT MAX(invoice_total)
FROM invoices;

SELECT "Primera mitad 2019" AS rango_fecha,
SUM(invoice_total) AS "total_ventas",
SUM(payment_total) AS "total_pagos",
SUM(invoice_total-payment_total) AS "valor_esperado"
FROM invoices
WHERE invoice_date BETWEEN "2019-01-01" AND "2019-06-30"
UNION
SELECT "Segunda mitad 2019" AS rango_fecha,
SUM(invoice_total) AS "total_ventas",
SUM(payment_total) AS "total_pagos",
SUM(invoice_total-payment_total) AS "valor_esperado"
FROM invoices
WHERE invoice_date BETWEEN "2019-07-01" AND "2019-12-31"
UNION
SELECT "Total" AS rango_fecha,
SUM(invoice_total) AS "total_ventas",
SUM(payment_total) AS "total_pagos",
SUM(invoice_total-payment_total) AS "valor_esperado"
FROM invoices
WHERE invoice_date BETWEEN "2019-01-01" AND "2019-12-31";

SELECT
client_id,
SUM(invoice_total) AS total_facturacion
FROM invoices
GROUP BY (client_id)
ORDER BY total_facturacion DESC, client_id ASC
LIMIT 1;

SELECT
    client_id,
    SUM(invoice_total) AS total_facturacion
FROM invoices
GROUP BY (client_id)
ORDER BY total_facturacion DESC, client_id ASC
LIMIT 1;


SELECT
i.client_id,
c.name AS Nombre,
SUM(invoice_total) AS total_facturacion
FROM invoices i
JOIN clients c ON i.client_id=c.client_id
GROUP BY (i.client_id)
ORDER BY total_facturacion DESC, client_id ASC
LIMIT 1;

SELECT
    c.state,
    c.city,
    i.client_id,
    c.name AS Nombre,
    SUM(invoice_total) AS total_facturacion
FROM invoices i
JOIN clients c
    ON i.client_id=c.client_id
GROUP BY c.state, c.city,i.client_id
ORDER BY total_facturacion DESC, client_id ASC
LIMIT 1;

SELECT date,
    pm.name AS metodo_pago,
    SUM(p.amount) AS total_pagos
FROM payments p
JOIN payment_methods pm
    ON p.payment_method=pm.payment_method_id
GROUP BY pm.name,p.date
ORDER BY p.date ASC;

SELECT customer_id,
    c.first_name,
    c.last_name,
    SUM(oi.quantity*oi.unit_price) AS total_ventas
FROM customers c
JOIN orders o
    ON c.customer_id=o.customer_id
JOIN order_items oi
    ON o.order_id=oi.order_id
GROUP BY c.customer_id
HAVING total_ventas>100;

SELECT 
    c.customer_id,
    c.first_name,
    c.last_name,
    SUM(oi.quantity * oi.unit_price) AS total_ventas
FROM customers c
JOIN orders o
    ON c.customer_id = o.customer_id
JOIN order_items oi
    ON o.order_id = oi.order_id
WHERE c.state ="VA"
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING total_ventas > 100;

