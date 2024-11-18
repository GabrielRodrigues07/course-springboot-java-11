delete from tb_order_item;
delete from tb_product_category;
delete from tb_product;
delete from tb_category;
delete from tb_payment;
delete from tb_order;
delete from tb_user;

INSERT INTO public.tb_category (id, name) VALUES (1, 'Computers');
INSERT INTO public.tb_category (id, name) VALUES (2, 'Books');
INSERT INTO public.tb_category (id, name) VALUES (3, 'Electronics');

INSERT INTO public.tb_product (id, name, description, price, img_url) VALUES (1, 'The Lord of the Rings', 'Lorem ipsum dolor sit amet, consectetur.', 90.5, '');
INSERT INTO public.tb_product (id, name, description, price, img_url) VALUES (2, 'Smart TV', 'Nulla eu imperdiet purus. Maecenas ante.', 2190.0, '');
INSERT INTO public.tb_product (id, name, description, price, img_url) VALUES (3, 'Macbook Pro', 'Nam eleifend maximus tortor, at mollis.', 1250.0, '');
INSERT INTO public.tb_product (id, name, description, price, img_url) VALUES (4, 'PC Gamer', 'Donec aliquet odio ac rhoncus cursus.', 1200.0, '');
INSERT INTO public.tb_product (id, name, description, price, img_url) VALUES (5, 'Rails for Dummies', 'Cras fringilla convallis sem vel faucibus.', 100.99, '');

INSERT INTO public.tb_product_category (product_id, category_id) VALUES(1, 2);
INSERT INTO public.tb_product_category (product_id, category_id) VALUES(2, 1);
INSERT INTO public.tb_product_category (product_id, category_id) VALUES(2, 3);
INSERT INTO public.tb_product_category (product_id, category_id) VALUES(3, 3);
INSERT INTO public.tb_product_category (product_id, category_id) VALUES(4, 3);
INSERT INTO public.tb_product_category (product_id, category_id) VALUES(5, 2);

INSERT INTO public.tb_user (id, name, email, phone, password) VALUES (1, 'Maria Brown', 'maria@gmail.com', '988888888', '123456');
INSERT INTO public.tb_user (id, name, email, phone, password) VALUES (2, 'Alex Green', 'alex@gmail.com', '977777777', '123456');

INSERT INTO public.tb_order (id, moment, order_status, client_id) VALUES (1, '2019-06-20T19:53:07Z', 2, 1);
INSERT INTO public.tb_order (id, moment, order_status, client_id) VALUES (2, '2019-07-21T03:42:10Z', 1, 2);
INSERT INTO public.tb_order (id, moment, order_status, client_id) VALUES (3, '2019-07-22T15:21:22Z', 1, 1);

INSERT INTO public.tb_order_item (price, quantity, product_id, order_id) VALUES(90.5, 2, 1, 1);
INSERT INTO public.tb_order_item (price, quantity, product_id, order_id) VALUES(1250.0, 1, 3, 1);
INSERT INTO public.tb_order_item (price, quantity, product_id, order_id) VALUES(1250.0, 2, 3, 2);
INSERT INTO public.tb_order_item (price, quantity, product_id, order_id) VALUES(100.99, 2, 5, 3);

INSERT INTO public.tb_payment (moment, order_id) VALUES('2019-06-20T21:53:07Z', 1);