--user authorities
INSERT INTO authority(name) VALUES ('ROLE_CUSTOMER');
INSERT INTO authority(name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO authority(name) VALUES ('ROLE_BOOKSTORE_ADMIN');
INSERT INTO authority(name) VALUES ('ROLE__MANAGER');
INSERT INTO authority(name) VALUES ('ROLE_WAREHOUSEMAN');
INSERT INTO authority(name) VALUES ('ROLE_SELLER');

--bookstores
INSERT INTO bookstore(address, city, description, bookstore_name, number_of_votes, rating) VALUES ('Frankopanova 31', 'Novi Sad', 'Prva knjizara ikada nastala', 'Agora', 0, 0);
INSERT INTO bookstore(address, city, description, bookstore_name, number_of_votes, rating) VALUES ('Mileticeva 11', 'Zrenjanin', 'Knjizara za penzionere', 'Epitaf', 0, 0);
INSERT INTO bookstore(address, city, description, bookstore_name, number_of_votes, rating) VALUES ('Apatinska 19', 'Beograd', 'Knjizara specijalizovana za fantastiku', 'Soma', 0, 0);

--user password: 123
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login) VALUES ('isapsw1234@gmail.com', '$2a$10$M3.YOtEuBCSNbgzJ3hkQv.ZgOMGNSTataYMx1UU7OnqMrlC6Osgzm', 'Misa', 'Dimitrijevic', 'ROLE_CUSTOMER', true, true, true);
--user password: 1234
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login) VALUES ('sysadmin@gmail.com', '$2a$10$Ng8dAJzSDmWjbsuQmKb7WeOl27Kc5DlySVmClnvfqaD7VAZqFW7v6', 'Marko', 'Markovic', 'ROLE_SYSTEM_ADMIN', true, true, true);
--user password: 12345
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login) VALUES ('admin1@gmail.com', '$2a$10$gpHocgjdblYRnD.O/ri.qeeIoaLm8PZuQymydhgASYijPVM2q4tH2', 'Sima', 'Simonovic', 'ROLE_BOOKSTORE_ADMIN', true, true, true);
--user password: 54321
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login) VALUES ('admin2@gmail.com', '$2a$10$qNyWkzQz63f1Q2xTqTu.Meopa.MMD9pVAie9isAhm9N6A3.xyQLoO', 'Samjuel', 'Hrubik', 'ROLE_BOOKSTORE_ADMIN', true, true, true);
--user password: 55555
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login) VALUES ('admin3@gmail.com', '$2a$10$665GOyAQmwqTkz/6HmxikOgLD1kVNnP6Yx7T1zXFECcC/kgAOh7JG', 'Aleksandar', 'Paripovic', 'ROLE_BOOKSTORE_ADMIN', true, true, true);


INSERT INTO customer(phone_number, date_of_birth, address, city, user_id) VALUES ('+381692312321', '1995-03-05', 'Tomiceva 55', 'Beograd', 1);
INSERT INTO bookstore_system_administrator(user_id) VALUES (2);
INSERT INTO bookstore_administrator(user_id, bookstore_id) VALUES (3, 1);
INSERT INTO bookstore_administrator(user_id, bookstore_id) VALUES (4, 2);
INSERT INTO bookstore_administrator(user_id, bookstore_id) VALUES (5, 3);
