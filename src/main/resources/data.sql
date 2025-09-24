-- File generated with AI

CREATE SCHEMA product_schema;

CREATE TABLE product (
	id UUID PRIMARY KEY,
	name VARCHAR(255),
	image_url VARCHAR(255),
	description VARCHAR(1000),
	price FLOAT,
	rating INT,
	specifications VARCHAR(1000)
);

-- Sample product data
INSERT INTO product (id, name, image_url, description, price, rating, specifications) VALUES
    (RANDOM_UUID(), 'Smartphone X', 'https://example.com/phone1.jpg', 'Latest smartphone with advanced camera', 799.99, 5, '{"color": "black", "storage": "128GB", "ram": "8GB"}'),
    (RANDOM_UUID(), 'Wireless Earbuds', 'https://example.com/earbuds1.jpg', 'Noise cancelling wireless earbuds', 129.99, 4, '{"color": "white", "battery_life": "24h", "water_resistant": true}'),
    (RANDOM_UUID(), 'Gaming Laptop', 'https://example.com/laptop1.jpg', 'High-performance gaming laptop', 1499.99, 5, '{"processor": "Intel i9", "gpu": "RTX 3080", "ram": "32GB"}'),
    (RANDOM_UUID(), 'Smart Watch', 'https://example.com/watch1.jpg', 'Fitness and health tracking smartwatch', 249.99, 4, '{"display": "AMOLED", "battery_life": "7 days", "gps": true}'),
    (RANDOM_UUID(), 'Bluetooth Speaker', 'https://example.com/speaker1.jpg', 'Portable waterproof speaker', 89.99, 4, '{"power": "20W", "waterproof": true, "battery_life": "12h"}'),
    (RANDOM_UUID(), '4K Smart TV', 'https://example.com/tv1.jpg', '55-inch 4K UHD Smart TV', 699.99, 5, '{"screen_size": "55\"", "resolution": "4K", "smart_features": true}'),
    (RANDOM_UUID(), 'Mechanical Keyboard', 'https://example.com/keyboard1.jpg', 'RGB mechanical gaming keyboard', 129.99, 4, '{"switch_type": "Brown", "backlight": "RGB", "keycaps": "PBT"}'),
    (RANDOM_UUID(), 'External SSD', 'https://example.com/ssd1.jpg', '1TB Portable SSD', 129.99, 5, '{"capacity": "1TB", "interface": "USB-C", "read_speed": "1050MB/s"}'),
    (RANDOM_UUID(), 'Action Camera', 'https://example.com/camera1.jpg', '4K Action Camera', 299.99, 4, '{"resolution": "4K60fps", "waterproof": true, "wifi": true}'),
    (RANDOM_UUID(), 'Wireless Charger', 'https://example.com/charger1.jpg', '15W Fast Wireless Charger', 39.99, 4, '{"power": "15W", "devices": 1, "cable_included": true}');

