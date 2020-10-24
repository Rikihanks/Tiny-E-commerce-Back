INSERT INTO USERS (user_id, username, surname, password, dni, email) VALUES
  (999, 'John', 'Doe', '$2a$10$I9Xlsj8CUS9v6cZ2e9FkO.jkyK.wqHhdy3z6dBR9JY2QOjd5Xrn/K', '522487967R', 'johndoe@gmail.com'),
  (998, 'Richard', 'Hernandez', '$2a$10$I9Xlsj8CUS9v6cZ2e9FkO.jkyK.wqHhdy3z6dBR9JY2QOjd5Xrn/K', '1234356D', 'rhernandez@gmail.com');

INSERT INTO ROLES (role_id, name) VALUES
  (999, 'ROLE_USER'),
  (998, 'ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES
  ( 999,999 ),
  (998,998 );

INSERT INTO ITEMS(item_id, name, price, picture_url, description, category) VALUES
(999, 'Item 1', 358.81, 'https://www.kindpng.com/picc/m/198-1984876_gucci-shoes-zapatillas-lv-louisvuitton-louis-vuitton-gucci.png', 'Luis Vuiton Shoes', 'CLOTHES'),
(998, 'Item 2', 70.81, 'https://static.pullandbear.net/2/photos/2020/I/0/1/p/5713/349/982/5713349982_1_1_3.jpg', 'Pull and Bear Jacket', 'CLOTHES'),
(997, 'Item 3', 3.20, 'http://www.dakotagrowers.com/assets/images/privateLabel/PrivateLabelBox.png', 'Pasta', 'FOOD'),
(996, 'Item 4', 2.10, 'https://ak1.ostkcdn.com/images/products/20175151/Coles-Assorted-Species-Wild-Bird-Food-Sunflower-Seed-Meats-10-lb.-102e7423-6cf8-461a-a005-23e7a10c6f25.jpg', 'Various Species', 'FOOD'),
(995, 'Item 5', 30.00, 'https://www.globalbrand.com.bd/wp-content/uploads/2019/07/Untitled-1-18.jpg', 'Gaming Mouse', 'ELECTRONICS'),
(994, 'Item 6', 29.99, 'https://images-na.ssl-images-amazon.com/images/I/41u9PVk0GkL._SX466_.jpg', 'Gaming Keyboard', 'ELECTRONICS');


INSERT INTO ORDERS(order_id, address, country, credit_card_number, processed, user_user_id, postal_code)
	VALUES (999, 'p sherman calle wallaby 42 sidney', 'spain', '456891364872315749', false, 999, '38296');

INSERT INTO order_item(
	order_id, item_id)
	VALUES (999, 999), (999, 998);

