CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    supplier VARCHAR(255),
    category VARCHAR(255),
    is_active BOOLEAN
);

INSERT INTO products (name, description, supplier, category, is_active) VALUES ('Producto1', 'Descripción del Producto 1', 'Proveedor 1', 1, TRUE);
INSERT INTO products (name, description, supplier, category, is_active) VALUES ('Producto2', 'Descripción del Producto 2', 'Proveedor 2', 2, TRUE);