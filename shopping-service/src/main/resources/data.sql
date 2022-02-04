CREATE TABLE tlb_invoices (
    id int,
    number_invoice varchar(255),
    description varchar(255),
    customer_id varchar(255),
    create_at datetime,
    state varchar(50)
    
    
);

CREATE TABLE tbl_invoce_items (
    invoice_id int,
    product_id int,
    quantity int,
    price double
);

INSERT INTO tlb_invoices (id, number_invoice, description, customer_id, create_at, state) VALUES(1, '0001', 'invoice office items', 1, NOW(),'CREATED');
INSERT INTO tbl_invoce_items ( invoice_id, product_id, quantity, price ) VALUES(1, 1 , 1, 178.89);
INSERT INTO tbl_invoce_items ( invoice_id, product_id, quantity, price)  VALUES(1, 2 , 2, 12.5);
INSERT INTO tbl_invoce_items ( invoice_id, product_id, quantity, price)  VALUES(1, 3 , 1, 40.06);
