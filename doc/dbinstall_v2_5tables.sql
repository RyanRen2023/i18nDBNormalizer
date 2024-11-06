create user 'cst8276'@'localhost' identified by 'cst8276';
grant all privilege from cst8276.* to 'cst8276'@'localhost';
privilege flush;


-- Drop the database if it exists
DROP DATABASE IF EXISTS cst8276;

-- Create the database
CREATE DATABASE cst8276;
USE cst8276;

-- Create the Products table to store basic product information
CREATE TABLE Products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    default_name VARCHAR(100)  -- Default product name (e.g., in English)
);

-- Create the Languages table to store supported languages
CREATE TABLE Languages (
    language_code VARCHAR(10) PRIMARY KEY,  -- e.g., 'en', 'fr', 'zh'
    language_name VARCHAR(50)               -- e.g., 'English', 'French', 'Chinese'
);

-- Create the Currencies table to store currency information
CREATE TABLE Currencies (
    currency_code VARCHAR(3) PRIMARY KEY,  -- e.g., 'USD', 'EUR', 'CNY'
    currency_name VARCHAR(50)              -- e.g., 'US Dollar', 'Euro', 'Chinese Yuan'
);

-- Create the Product_Translations table to store product names, descriptions, and categories in different languages
CREATE TABLE Product_Translations (
    translation_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    language_code VARCHAR(10),
    product_name VARCHAR(100),
    description TEXT,
    category VARCHAR(50),
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (language_code) REFERENCES Languages(language_code)
);

-- Create the Product_Prices table to store product prices in different currencies
CREATE TABLE Product_Prices (
    price_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    currency_code VARCHAR(3),
    price DECIMAL(10, 2),
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (currency_code) REFERENCES Currencies(currency_code)
);



-- Insert sample data into Languages table
INSERT INTO Languages (language_code, language_name) VALUES
('en', 'English'),
('fr', 'French'),
('zh', 'Chinese');

-- Insert sample data into Currencies table
INSERT INTO Currencies (currency_code, currency_name) VALUES
('USD', 'US Dollar'),
('EUR', 'Euro'),
('CNY', 'Chinese Yuan');

-- Insert sample data into Products table
INSERT INTO Products (default_name) VALUES
('Sample Product 1'),
('Sample Product 2'),
('Sample Product 3');

-- Insert sample data into Product_Translations table
INSERT INTO Product_Translations (product_id, language_code, product_name, description, category) VALUES
(1, 'en', 'Sample Product 1', 'Description for Sample Product 1 in English', 'Category A'),
(1, 'fr', 'Produit d\'échantillon 1', 'Description du produit d\'échantillon 1 en français', 'Catégorie A'),
(1, 'zh', '样品产品1', '样品产品1的描述（中文）', '类别A'),
(2, 'en', 'Sample Product 2', 'Description for Sample Product 2 in English', 'Category B'),
(2, 'fr', 'Produit d\'échantillon 2', 'Description du produit d\'échantillon 2 en français', 'Catégorie B'),
(3, 'en', 'Sample Product 3', 'Description for Sample Product 3 in English', 'Category C');

-- Insert sample data into Product_Prices table
INSERT INTO Product_Prices (product_id, currency_code, price) VALUES
(1, 'USD', 19.99),
(1, 'EUR', 17.50),
(2, 'CNY', 130.00),
(3, 'USD', 29.99),
(3, 'EUR', 25.00);
