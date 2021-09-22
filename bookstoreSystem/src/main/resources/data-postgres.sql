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
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login) VALUES ('isapsw123@gmail.com', '$2a$10$M3.YOtEuBCSNbgzJ3hkQv.ZgOMGNSTataYMx1UU7OnqMrlC6Osgzm', 'Misa', 'Dimitrijevic', 'ROLE_CUSTOMER', false, true, true);
--user password: 1234
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login) VALUES ('sysadmin@gmail.com', '$2a$10$Ng8dAJzSDmWjbsuQmKb7WeOl27Kc5DlySVmClnvfqaD7VAZqFW7v6', 'Marko', 'Markovic', 'ROLE_SYSTEM_ADMIN', true, true, true);
--user password: 12345
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login) VALUES ('admin1@gmail.com', '$2a$10$gpHocgjdblYRnD.O/ri.qeeIoaLm8PZuQymydhgASYijPVM2q4tH2', 'Sima', 'Simonovic', 'ROLE_BOOKSTORE_ADMIN', true, true, true);
--user password: 54321
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login) VALUES ('admin2@gmail.com', '$2a$10$qNyWkzQz63f1Q2xTqTu.Meopa.MMD9pVAie9isAhm9N6A3.xyQLoO', 'Samjuel', 'Hrubik', 'ROLE_BOOKSTORE_ADMIN', true, true, true);
--user password: 55555
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login) VALUES ('admin3@gmail.com', '$2a$10$665GOyAQmwqTkz/6HmxikOgLD1kVNnP6Yx7T1zXFECcC/kgAOh7JG', 'Aleksandar', 'Paripovic', 'ROLE_BOOKSTORE_ADMIN', true, true, true);

--user authorities
INSERT INTO user_authority(user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority(user_id, authority_id) VALUES (2, 2);
INSERT INTO user_authority(user_id, authority_id) VALUES (3, 3);
INSERT INTO user_authority(user_id, authority_id) VALUES (4, 3);
INSERT INTO user_authority(user_id, authority_id) VALUES (5, 3);

--different users
INSERT INTO customer(phone_number, date_of_birth, address, city, user_id, processed) VALUES ('+381692312321', '1995-03-05', 'Tomiceva 55', 'Beograd', 1, false);
INSERT INTO bookstore_system_administrator(user_id) VALUES (2);
INSERT INTO bookstore_administrator(user_id, bookstore_id) VALUES (3, 1);
INSERT INTO bookstore_administrator(user_id, bookstore_id) VALUES (4, 2);
INSERT INTO bookstore_administrator(user_id, bookstore_id) VALUES (5, 3);

--publishers
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Magnet', 'Dalmatinska 12', 'Beograd', '+3815435');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Matica srpska', 'Principova 98', 'Beograd', '+38134534');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Neopress', 'Sumadijska 15', 'Beograd', '+38164353');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Riznica', 'Milana Simina 12', 'Beograd', '+38143256');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Solaris', 'Mileve Simic 23', 'Beograd', '+38123426');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('SKC', 'Misarksa 52', 'Beograd', '+38167657'); 
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Darkwood', 'Mladena Leskovca 7', 'Novi Sad', '+38167546');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Edicija', 'Olge Petrov 12', 'Beograd', '+38145674');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Veseli cetvrtak', 'Pancevacka 5', 'Beograd', '+38154435');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Laguna', 'Pavla Ivica 87', 'Beograd', '+3817657'); --10
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Mali princ', 'Pedje Milosavljevica 1', 'Beograd', '+38154353');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Spektra team', 'Tosin bunar 166', 'Beograd', '+381223432');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Riznica', 'Futoski put 67', 'Novi Sad', '+38131231245');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Solaris', 'Hadzi Ruvimova', 'Novi Sad', '+381321321'); 
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Dexy Co', 'Sime Stojanovica 55', 'Beograd', '+38132155');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Edicija', 'Baranjska 61', 'Novi Sad', '+381321356');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Equilibrium', 'Backa 19', 'Novi Sad', '+381231331');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Veseli cetvrtak', 'Somborska 66', 'Beograd', '+38132133');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Laguna', 'Partizanska 2', 'Nis', '+38132131');
INSERT INTO publisher(name, address, city, phone_number) VALUES ('Mali princ', 'Radnicka 62', 'Beograd', '+381555432'); --20

--writers
INSERT INTO writer(name, description) VALUES ('George R. R. Martin', 'description');
INSERT INTO writer(name, description) VALUES ('J. K. Rowling', 'description');
INSERT INTO writer(name, description) VALUES ('J. R. R. Tolkin', 'description');
INSERT INTO writer(name, description) VALUES ('William Shakespeare', 'description');
INSERT INTO writer(name, description) VALUES ('Agatha Christie', 'description');
INSERT INTO writer(name, description) VALUES ('Edgar Allan Poe', 'description');
INSERT INTO writer(name, description) VALUES ('Mark Twain', 'description');
INSERT INTO writer(name, description) VALUES ('Stephen King', 'description');
INSERT INTO writer(name, description) VALUES ('Ernest Hemingway', 'description');
INSERT INTO writer(name, description) VALUES ('George Orwell', 'description'); --10

--book genres
INSERT INTO genre(name) VALUES ('Horror');
INSERT INTO genre(name) VALUES ('Romance');
INSERT INTO genre(name) VALUES ('Thriller');
INSERT INTO genre(name) VALUES ('Historical');
INSERT INTO genre(name) VALUES ('Mystery');
INSERT INTO genre(name) VALUES ('Action and adventure');
INSERT INTO genre(name) VALUES ('Childrens');
INSERT INTO genre(name) VALUES ('Classic');
INSERT INTO genre(name) VALUES ('Encyclopedia');
INSERT INTO genre(name) VALUES ('Crime'); --10
INSERT INTO genre(name) VALUES ('Cookbook');
INSERT INTO genre(name) VALUES ('Fantasy');
INSERT INTO genre(name) VALUES ('Humor');
INSERT INTO genre(name) VALUES ('Poetry');
INSERT INTO genre(name) VALUES ('Science fiction');
INSERT INTO genre(name) VALUES ('Western');
INSERT INTO genre(name) VALUES ('Sports and leisure');
INSERT INTO genre(name) VALUES ('Travel');
INSERT INTO genre(name) VALUES ('Suspense');
INSERT INTO genre(name) VALUES ('Drama'); --20
INSERT INTO genre(name) VALUES ('Political fiction');
INSERT INTO genre(name) VALUES ('Historical fiction');
INSERT INTO genre(name) VALUES ('Dystopian Fiction');
INSERT INTO genre(name) VALUES ('Novel');

--products
INSERT INTO product(id, code, name, price, description, published, type, publisher_id) VALUES (0, '4311', 'Lego Set', 999, 'DESCRIPTIONNNN', '2019-02-01', 'TOY', 15);

--books
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (1, '115521', 'Game of Thrones', 1555, 'descrption1234', '2020-05-01', 'BOOK', 1, 400, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (2, '5551231', 'Lord of the Rings: Two Towers', 1500, 'description2222', '2020-05-01', 'BOOK', 2, 420, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (3, '332515', 'Lord of the Rings: Fellowship of the Ring', 1200, 'descrption3333', '2020-05-01', 'BOOK', 2, 510, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (4, '6532', 'Lord of the Rings: Return of the King', 1200, 'descrption4444', '2020-05-01', 'BOOK', 2, 390, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (5, '54536', 'Harry Potter and the Philosophers Stone', 1500, 'descrption555', '2020-05-01', 'BOOK', 3, 290, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (6, '785657', 'Harry Potter and the Half Blood Prince', 1700, 'descrption6666', '2020-05-01', 'BOOK', 3, 320, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (7, '421564', 'Harry Potter and the Chamber of Secrets', 1300, 'descrption777', '2020-05-01', 'BOOK', 3, 210, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (8, '987077', 'Harry Potter and the Prisoner of Azkaban', 1400, 'descrption8888', '2020-05-01', 'BOOK', 3, 110, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (9, '654787', 'Harry Potter and the Goblet of Fire', 1500, 'descrption9999', '2020-05-01', 'BOOK', 3, 400, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (10, '3255661', 'Harry Potter and the Order of Phoenix', 2100, 'descrption101010', '2020-05-01', 'BOOK', 3, 280, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (11, '3166643', 'Harry Potter and the Deathly Hallows', 1750, 'descrption11111', '2020-05-01', 'BOOK', 3, 350, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (12, '5544511', 'The Fall of Gondolin', 1100, 'descrption54321', '2020-05-01', 'BOOK', 1, 250, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (13, '3213415', 'The Silmarillion', 1300, 'descrption5551', '2020-05-01', 'BOOK', 1, 232, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (14, '6546478', 'The Hobbit', 1000, 'descrption5551', '2020-05-01', 'BOOK', 1, 400, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (15, '4234326', 'A Clash of Kings', 1300, 'descrption5551', '2020-05-01', 'BOOK', 2, 270, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (16, '4277656', 'A Storm of Swords', 2500, 'descrption5551', '2020-05-01', 'BOOK', 2, 300, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (17, '8786667', 'A Feast for Crows', 2100, 'descrption5551', '2020-05-01', 'BOOK', 2, 190, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (18, '7868455', 'A Dance with Dragons', 2700, 'descrption5551', '2020-05-01', 'BOOK', 2, 360, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (19, '54353767', 'The Winds of Winter', 2700, 'descrption5551', '2020-05-01', 'BOOK', 2, 240, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (20, '34363646', 'Fire & Blood', 2999, 'descrption5551', '2020-05-01', 'BOOK', 2, 400, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (21, '125512', 'The Adventures of Tom Sawyer', 900, 'descrption5551', '2020-05-01', 'BOOK', 4, 260, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (22, '321556', 'Adventures of Huckleberry Finn', 900, 'descrption5551', '2020-05-01', 'BOOK', 4, 300, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (23, '7657657', 'Animal Farm', 700, 'descrption5551', '2020-05-01', 'BOOK', 5, 400, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (24, '65758354', '1984', 800, 'descrption5551', '2020-05-01', 'BOOK', 5, 320, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (25, '54353467', 'It', 2700, 'descrption5551', '2020-05-01', 'BOOK', 10, 400, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (26, '5435', 'Misery', 900, 'descrptio49219', '2020-05-01', 'BOOK', 10, 390, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (27, '4324', 'The Shining', 1100, 'descrption32135', '2020-05-01', 'BOOK', 10, 200, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (28, '6642', 'Carrie', 1000, 'descrption553251', '2020-05-01', 'BOOK', 10, 100, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (29, '22131', 'Pet Sematary', 1500, 'descrption51123', '2020-05-01', 'BOOK', 10, 90, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (30, '21556', 'Murder on the Orient Express', 2100, 'descrption66545', '2020-05-01', 'BOOK', 11, 510, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (31, '222135', 'Three Act Tragedy', 1000, 'descrption51111', '2020-05-01', 'BOOK', 11, 330, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (32, '66546', 'Sleeping Murder', 1000, 'descrption99921', '2020-05-01', 'BOOK', 11, 310, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (33, '43242', 'Passenger to Frankfurt', 900, 'descrption675756', '2020-05-01', 'BOOK', 11, 150, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (38, '7652234', 'The Old Man and the Sea', 600, 'descrption696969', '2020-05-01', 'BOOK', 14, 170, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (39, '32166', 'The Garden of Eden', 760, 'descrption666', '2020-05-01', 'BOOK', 14, 215, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (40, '331663', 'A Farewell to Arms', 900, 'descrptio6643', '2020-05-01', 'BOOK', 14, 175, 'SERBIAN');
INSERT INTO book(id, code, name, price, description, published, type, publisher_id, number_of_pages, language) VALUES (41, '3332156', 'For Whom the Bell Tolls', 1000, 'descrption321312', '2020-05-01', 'BOOK', 14, 120, 'SERBIAN');

--book's genres
INSERT INTO genre_books(book_Id, genre_id) VALUES (1, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (2, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (3, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (4, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (5, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (6, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (7, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (8, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (9, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (10, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (11, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (12, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (13, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (14, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (15, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (16, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (17, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (18, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (19, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (20, 12);
INSERT INTO genre_books(book_Id, genre_id) VALUES (15, 21);
INSERT INTO genre_books(book_Id, genre_id) VALUES (16, 21);
INSERT INTO genre_books(book_Id, genre_id) VALUES (17, 21);
INSERT INTO genre_books(book_Id, genre_id) VALUES (18, 21);
INSERT INTO genre_books(book_Id, genre_id) VALUES (19, 21);
INSERT INTO genre_books(book_Id, genre_id) VALUES (20, 21);
INSERT INTO genre_books(book_Id, genre_id) VALUES (2, 6);
INSERT INTO genre_books(book_Id, genre_id) VALUES (3, 6);
INSERT INTO genre_books(book_Id, genre_id) VALUES (4, 6);
INSERT INTO genre_books(book_Id, genre_id) VALUES (12, 6);
INSERT INTO genre_books(book_Id, genre_id) VALUES (13, 6);
INSERT INTO genre_books(book_Id, genre_id) VALUES (14, 6);
INSERT INTO genre_books(book_Id, genre_id) VALUES (14, 7);
INSERT INTO genre_books(book_Id, genre_id) VALUES (21, 6);
INSERT INTO genre_books(book_Id, genre_id) VALUES (22, 6);
INSERT INTO genre_books(book_Id, genre_id) VALUES (21, 7);
INSERT INTO genre_books(book_Id, genre_id) VALUES (22, 7);
INSERT INTO genre_books(book_Id, genre_id) VALUES (21, 13);
INSERT INTO genre_books(book_Id, genre_id) VALUES (22, 13);
INSERT INTO genre_books(book_Id, genre_id) VALUES (21, 22);
INSERT INTO genre_books(book_Id, genre_id) VALUES (22, 22);
INSERT INTO genre_books(book_Id, genre_id) VALUES (23, 15);
INSERT INTO genre_books(book_Id, genre_id) VALUES (24, 15);
INSERT INTO genre_books(book_Id, genre_id) VALUES (23, 23);
INSERT INTO genre_books(book_Id, genre_id) VALUES (24, 23);
INSERT INTO genre_books(book_Id, genre_id) VALUES (25, 1);
INSERT INTO genre_books(book_Id, genre_id) VALUES (26, 1);
INSERT INTO genre_books(book_Id, genre_id) VALUES (27, 1);
INSERT INTO genre_books(book_Id, genre_id) VALUES (28, 1);
INSERT INTO genre_books(book_Id, genre_id) VALUES (29, 1);
INSERT INTO genre_books(book_Id, genre_id) VALUES (25, 19);
INSERT INTO genre_books(book_Id, genre_id) VALUES (26, 19);
INSERT INTO genre_books(book_Id, genre_id) VALUES (27, 19);
INSERT INTO genre_books(book_Id, genre_id) VALUES (28, 19);
INSERT INTO genre_books(book_Id, genre_id) VALUES (29, 19);
INSERT INTO genre_books(book_Id, genre_id) VALUES (25, 3);
INSERT INTO genre_books(book_Id, genre_id) VALUES (26, 3);
INSERT INTO genre_books(book_Id, genre_id) VALUES (27, 3);
INSERT INTO genre_books(book_Id, genre_id) VALUES (28, 3);
INSERT INTO genre_books(book_Id, genre_id) VALUES (29, 3);
INSERT INTO genre_books(book_Id, genre_id) VALUES (26, 20);
INSERT INTO genre_books(book_Id, genre_id) VALUES (30, 5);
INSERT INTO genre_books(book_Id, genre_id) VALUES (31, 5);
INSERT INTO genre_books(book_Id, genre_id) VALUES (32, 5);
INSERT INTO genre_books(book_Id, genre_id) VALUES (33, 5);
INSERT INTO genre_books(book_Id, genre_id) VALUES (30, 3);
INSERT INTO genre_books(book_Id, genre_id) VALUES (31, 3);
INSERT INTO genre_books(book_Id, genre_id) VALUES (32, 3);
INSERT INTO genre_books(book_Id, genre_id) VALUES (33, 3);
INSERT INTO genre_books(book_Id, genre_id) VALUES (38, 24);
INSERT INTO genre_books(book_Id, genre_id) VALUES (39, 24);
INSERT INTO genre_books(book_Id, genre_id) VALUES (40, 24);
INSERT INTO genre_books(book_Id, genre_id) VALUES (41, 24);

--writer's books
INSERT INTO writer_books(writer_id, book_id) VALUES (1, 1);
INSERT INTO writer_books(writer_id, book_id) VALUES (3, 2);
INSERT INTO writer_books(writer_id, book_id) VALUES (3, 3);
INSERT INTO writer_books(writer_id, book_id) VALUES (3, 4);
INSERT INTO writer_books(writer_id, book_id) VALUES (2, 5);
INSERT INTO writer_books(writer_id, book_id) VALUES (2, 6);
INSERT INTO writer_books(writer_id, book_id) VALUES (2, 7);
INSERT INTO writer_books(writer_id, book_id) VALUES (2, 8);
INSERT INTO writer_books(writer_id, book_id) VALUES (2, 9);
INSERT INTO writer_books(writer_id, book_id) VALUES (2, 10);
INSERT INTO writer_books(writer_id, book_id) VALUES (2, 11);
INSERT INTO writer_books(writer_id, book_id) VALUES (3, 12);
INSERT INTO writer_books(writer_id, book_id) VALUES (3, 13);
INSERT INTO writer_books(writer_id, book_id) VALUES (3, 14);
INSERT INTO writer_books(writer_id, book_id) VALUES (1, 15);
INSERT INTO writer_books(writer_id, book_id) VALUES (1, 16);
INSERT INTO writer_books(writer_id, book_id) VALUES (1, 17);
INSERT INTO writer_books(writer_id, book_id) VALUES (1, 18);
INSERT INTO writer_books(writer_id, book_id) VALUES (1, 19);
INSERT INTO writer_books(writer_id, book_id) VALUES (1, 20);
INSERT INTO writer_books(writer_id, book_id) VALUES (7, 21);
INSERT INTO writer_books(writer_id, book_id) VALUES (7, 22);
INSERT INTO writer_books(writer_id, book_id) VALUES (10, 23);
INSERT INTO writer_books(writer_id, book_id) VALUES (10, 24);
INSERT INTO writer_books(writer_id, book_id) VALUES (8, 25);
INSERT INTO writer_books(writer_id, book_id) VALUES (8, 26);
INSERT INTO writer_books(writer_id, book_id) VALUES (8, 27);
INSERT INTO writer_books(writer_id, book_id) VALUES (8, 28);
INSERT INTO writer_books(writer_id, book_id) VALUES (8, 29);
INSERT INTO writer_books(writer_id, book_id) VALUES (5, 30);
INSERT INTO writer_books(writer_id, book_id) VALUES (5, 31);
INSERT INTO writer_books(writer_id, book_id) VALUES (5, 32);
INSERT INTO writer_books(writer_id, book_id) VALUES (5, 33);
INSERT INTO writer_books(writer_id, book_id) VALUES (9, 38);
INSERT INTO writer_books(writer_id, book_id) VALUES (9, 39);
INSERT INTO writer_books(writer_id, book_id) VALUES (9, 40);
INSERT INTO writer_books(writer_id, book_id) VALUES (9, 41);

