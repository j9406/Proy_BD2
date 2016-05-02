
CREATE TABLE Materia
(
	product_id           NUMBER NOT NULL ,
	product_name         VARCHAR2(30) NULL ,
	buy_price            NUMBER NULL 
);

ALTER TABLE Materia
	ADD CONSTRAINT  XPKProductos PRIMARY KEY (product_id);

CREATE TABLE Sucursal
(
	suc_id               NUMBER NOT NULL ,
	suc_nom              VARCHAR2(30) NULL ,
	suc_dir              VARCHAR2(40) NULL ,
	suc_tel              NUMBER NULL 
);

ALTER TABLE Sucursal
	ADD CONSTRAINT  XPKSucursal PRIMARY KEY (suc_id);

CREATE TABLE Materia_Sucursal
(
	product_id           NUMBER NOT NULL ,
	suc_id               NUMBER NOT NULL ,
	quantity_on_hand     NUMBER NULL 
);

ALTER TABLE Materia_Sucursal
	ADD CONSTRAINT  XPKProductos_Sucursal PRIMARY KEY (product_id,suc_id);

CREATE TABLE Clientes
(
	customer_id          NUMBER NOT NULL ,
	cust_first_name      VARCHAR(30) NULL ,
	cust_last_name       VARCHAR(30) NULL ,
	suc_id               NUMBER NULL 
);

ALTER TABLE Clientes
	ADD CONSTRAINT  XPKClientes PRIMARY KEY (customer_id);

ALTER TABLE Materia_Sucursal
	ADD (CONSTRAINT R_58 FOREIGN KEY (product_id) REFERENCES Materia (product_id));

ALTER TABLE Materia_Sucursal
	ADD (CONSTRAINT R_59 FOREIGN KEY (suc_id) REFERENCES Sucursal (suc_id));

ALTER TABLE Clientes
	ADD (CONSTRAINT R_60 FOREIGN KEY (suc_id) REFERENCES Sucursal (suc_id) ON DELETE SET NULL);