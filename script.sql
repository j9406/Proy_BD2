CREATE TABLE Clientes
(
	costumer_id          NUMBER NOT NULL ,
	cust_first_name      VARCHAR2(30) NULL ,
	cust_last_name       VARCHAR2(30) NULL 
);

ALTER TABLE Clientes
	ADD CONSTRAINT  XPKClientes PRIMARY KEY (costumer_id);

CREATE TABLE Productos
(
	product_id           NUMBER NOT NULL ,
	product_name         VARCHAR2(30) NULL ,
	product_description  VARCHAR2(40) NULL ,
	buy_price            NUMBER NULL ,
	sell_price           NUMBER NULL 
);

ALTER TABLE Productos
	ADD CONSTRAINT  XPKProductos PRIMARY KEY (product_id);

CREATE TABLE Inventario
(
	product_id           NUMBER NOT NULL ,
	quantity_on_hand     NUMBER NULL 
);

ALTER TABLE Inventario
	ADD CONSTRAINT  XPKInventario PRIMARY KEY (product_id);

CREATE TABLE Proveedores
(
	prov_id              NUMBER NOT NULL ,
	prov_name            VARCHAR2(30) NULL ,
	prov_address         VARCHAR2(30) NULL ,
	prov_phone           NUMBER NULL ,
	product_id           NUMBER NULL 
);

ALTER TABLE Proveedores
	ADD CONSTRAINT  XPKProveedores PRIMARY KEY (prov_id);

CREATE TABLE Clientes_Productos
(
	costumer_id          NUMBER NOT NULL ,
	product_id           NUMBER NOT NULL ,
	quantity_prod        NUMBER NOT NULL 
);

ALTER TABLE Clientes_Productos
	ADD CONSTRAINT  XPKClientes_Productos PRIMARY KEY (costumer_id,product_id);

ALTER TABLE Inventario
	ADD (CONSTRAINT R_11 FOREIGN KEY (product_id) REFERENCES Productos (product_id));

ALTER TABLE Proveedores
	ADD (CONSTRAINT R_16 FOREIGN KEY (product_id) REFERENCES Productos (product_id) ON DELETE SET NULL);

ALTER TABLE Clientes_Productos
	ADD (CONSTRAINT R_31 FOREIGN KEY (costumer_id) REFERENCES Clientes (costumer_id));

ALTER TABLE Clientes_Productos
	ADD (CONSTRAINT R_32 FOREIGN KEY (product_id) REFERENCES Productos (product_id));
