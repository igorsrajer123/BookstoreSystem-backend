--user authorities
INSERT INTO authority(name) VALUES ('ROLE_CUSTOMER');
INSERT INTO authority(name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO authority(name) VALUES ('ROLE_BOOKSTORE_ADMIN');
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

--publishers
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Alma', 'Zmaj Jovina 1', 'Novi Sad', '+381555333');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Aruna', 'Djure Jaksica 61', 'Beograd', '+381111223');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Albatros plus', 'Visnjiceva 67', 'Beograd', '+381321321');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Magnet', 'Dalmatinska 12', 'Beograd', '+3815435');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Matica srpska', 'Principova 98', 'Beograd', '+38134534');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Neopress', 'Sumadijska 15', 'Beograd', '+38164353');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Nukleus', 'Kosovska 2', 'Beograd', '+38176575');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Orion art', 'Niksiceva 18', 'Novi Sad', '+381234262');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Novi glas', 'Alberta Ajnstajna 8', 'Novi Sad', '+381543534');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Riznica', 'Milana Simina 12', 'Beograd', '+38143256'); --10
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Solaris', 'Mileve Simic 23', 'Beograd', '+38123426');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('SKC', 'Misarksa 52', 'Beograd', '+38167657');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Srpska književna zadruga, Partenon', 'Mite Ruzica 81', 'Novi Sad', '+381543524');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Darkwood', 'Mladena Leskovca 7', 'Novi Sad', '+38167546');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Edicija', 'Olge Petrov 12', 'Beograd', '+38145674');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Equilibrium', 'Paje Jovanovic 64', 'Novi Sad', '+38186745');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Veseli cetvrtak', 'Pancevacka 5', 'Beograd', '+38154435');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Laguna', 'Pavla Ivica 87', 'Beograd', '+3817657');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Mali princ', 'Pedje Milosavljevica 1', 'Beograd', '+38154353');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Spektra team', 'Tosin bunar 166', 'Beograd', '+381223432'); --20
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Riznica', 'Futoski put 67', 'Novi Sad', '+38131231245');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Solaris', 'Hadzi Ruvimova', 'Novi Sad', '+381321321');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('SKC', 'Auto put 20', 'Beograd', '+381355512');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Srpska književna zadruga, Partenon', 'Hazarska 25', 'Beograd', '+381543543');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Dexy Co', 'Sime Stojanovica 55', 'Beograd', '+38132155');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Edicija', 'Baranjska 61', 'Novi Sad', '+381321356');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Equilibrium', 'Backa 19', 'Novi Sad', '+381231331');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Veseli cetvrtak', 'Somborska 66', 'Beograd', '+38132133');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Laguna', 'Partizanska 2', 'Nis', '+38132131');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Mali princ', 'Radnicka 62', 'Beograd', '+381555432'); --30

--writers
INSERT INTO writer(name, description) VALUES ('George R. R. Martin', 'description');
INSERT INTO writer(name, description) VALUES ('J. K. Rowling', 'description');
INSERT INTO writer(name, description) VALUES ('J. R. R. Tolkin', 'description');
INSERT INTO writer(name, description) VALUES ('William Shakespeare', 'description');
INSERT INTO writer(name, description) VALUES ('Barbara Cartland', 'description');
INSERT INTO writer(name, description) VALUES ('Agatha Christie', 'description');
INSERT INTO writer(name, description) VALUES ('Leo Tolstoy', 'description');
INSERT INTO writer(name, description) VALUES ('Jin Yong', 'description');
INSERT INTO writer(name, description) VALUES ('Edgar Allan Poe', 'description');
INSERT INTO writer(name, description) VALUES ('Mark Twain', 'description');
INSERT INTO writer(name, description) VALUES ('Charles Dickens', 'description');
INSERT INTO writer(name, description) VALUES ('Stephen King', 'description');
INSERT INTO writer(name, description) VALUES ('Ernest Hemingway', 'description');
INSERT INTO writer(name, description) VALUES ('George Orwell', 'description');
INSERT INTO writer(name, description) VALUES ('Jane Austen', 'description');

--products
INSERT INTO product(id, code, name, price, description, published, type, publisher_id) VALUES (1, '4311', 'Lego Set', 999, 'DESCRIPTIONNNN', '2019-02-01', 'TOY', 25);

--books
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (1, '115521', 'Game of Thrones', 1555, 'descrption1234', '2020-05-01', 'BOOK', 1, 55, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (2, '5551231', 'Lord of the Rings: Two Towers', 2100, 'descrption5551', '2020-05-01', 'BOOK', 1, 21, 'SERBIAN');

--writers' books
INSERT INTO writer_books(writer_id, book_id) VALUES (1, 1);

