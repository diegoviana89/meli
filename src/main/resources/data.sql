-- Product data with specific UUIDs for consistent testing

CREATE SCHEMA IF NOT EXISTS product_schema;

CREATE TABLE IF NOT EXISTS product (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    image_url VARCHAR(255),
    description VARCHAR(1000),
    price FLOAT,
    rating INT,
    specifications VARCHAR(1000)
);

-- Clear existing data
DELETE FROM product;

-- Sample product data with specific UUIDs
INSERT INTO product (id, name, image_url, description, price, rating, specifications) VALUES
    ('11111111-1111-1111-1111-111111111111', 'Smartphone X', 'https://example.com/phone1.jpg', 'Latest smartphone with advanced camera', 799.99, 5, '{"color": "black", "storage": "128GB", "ram": "8GB"}'),
        ('22222222-2222-2222-2222-222222222222', 'Wireless Earbuds', 'https://example.com/earbuds1.jpg', 'Noise cancelling wireless earbuds', 129.99, 4, '{"color": "white", "battery_life": "24h", "water_resistant": true}'),
    ('33333333-3333-3333-3333-333333333333', 'Gaming Laptop', 'https://example.com/laptop1.jpg', 'High-performance gaming laptop', 1499.99, 5, '{"processor": "Intel i9", "gpu": "RTX 3080", "ram": "32GB"}'),
    ('44444444-4444-4444-4444-444444444444', 'Smart Watch', 'https://example.com/watch1.jpg', 'Fitness and health tracking smartwatch', 249.99, 4, '{"display": "AMOLED", "battery_life": "7 days", "gps": true}'),
    ('55555555-5555-5555-5555-555555555555', 'Bluetooth Speaker', 'https://example.com/speaker1.jpg', 'Portable waterproof speaker', 89.99, 4, '{"power": "20W", "waterproof": true, "battery_life": "12h"}'),
    ('66666666-6666-6666-6666-666666666666', '4K Smart TV', 'https://example.com/tv1.jpg', '55-inch 4K UHD Smart TV', 699.99, 5, '{"screen_size": "55\"", "resolution": "4K", "smart_features": true}'),
    ('77777777-7777-7777-7777-777777777777', 'Mechanical Keyboard', 'https://example.com/keyboard1.jpg', 'RGB mechanical gaming keyboard', 129.99, 4, '{"switch_type": "Brown", "backlight": "RGB", "keycaps": "PBT"}'),
    ('88888888-8888-8888-8888-888888888888', 'External SSD', 'https://example.com/ssd1.jpg', '1TB Portable SSD', 129.99, 5, '{"capacity": "1TB", "interface": "USB-C", "read_speed": "1050MB/s"}'),
    ('99999999-9999-9999-9999-999999999999', 'Action Camera', 'https://example.com/camera1.jpg', '4K Action Camera', 299.99, 4, '{"resolution": "4K60fps", "waterproof": true, "wifi": true}'),
    ('00000000-0000-0000-0000-000000000000', 'Wireless Charger', 'https://example.com/charger1.jpg', '15W Fast Wireless Charger', 39.99, 4, '{"power": "15W", "devices": 1, "cable_included": true}');

