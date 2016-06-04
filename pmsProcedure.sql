DELIMITER $$

CREATE
    
    PROCEDURE `productmanagementsystem`.`ProductDiscount`(IN product_name VARCHAR(20),
    IN product_description VARCHAR(20),IN manufacturing_date DATE,IN expiry_date DATE,
    IN maximum_retail_price DECIMAL(8,2),IN ratings DECIMAL(8,2),IN quantity INT,
    IN category_id INT,IN sub_categoryId INT,IN supplier_id INT,IN discount_id INT)
    
    BEGIN
    DECLARE id INT;
    INSERT INTO Product(product_name,product_description,manufacturing_date,expiry_date,
    maximum_retail_price,ratings,quantity,category_id,sub_categoryId,supplier_id)
    VALUES(product_name,product_description,manufacturing_date,expiry_date,
    maximum_retail_price,ratings,quantity,category_id,sub_categoryId,supplier_id);
    
	SELECT product_id FROM Product p WHERE p.product_name=product_name;
    
    INSERT INTO product_discount(product_id,discount_id) VALUES 

    END$$

DELIMITER ;


