--user authorities
INSERT INTO authority(name) VALUES ('ROLE_CUSTOMER');
INSERT INTO authority(name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO authority(name) VALUES ('ROLE_BOOKSTORE_ADMIN');
INSERT INTO authority(name) VALUES ('ROLE_SELLER');

--bookstores
INSERT INTO bookstore(address, city, name, number_of_votes, rating, contact_phone, photo) VALUES ('Frankopanova 31', 'Novi Sad', 'Agora', 0, 0, '+3819922352', 'bookstore1.webp');
INSERT INTO bookstore(address, city, name, number_of_votes, rating, contact_phone, photo) VALUES ('Mileticeva 11', 'Zrenjanin', 'Epitaf', 0, 0, '+3816677532', 'bookstore2.jpg');
INSERT INTO bookstore(address, city, name, number_of_votes, rating, contact_phone, photo) VALUES ('Apatinska 19', 'Beograd', 'Soma', 0, 0, '+3815604435', 'bookstore3.jpg');

--user password: 123
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login, phone_number, date_of_birth, address, city) VALUES ('isapsw1234@gmail.com', '$2a$10$M3.YOtEuBCSNbgzJ3hkQv.ZgOMGNSTataYMx1UU7OnqMrlC6Osgzm', 'Misa', 'Dimitrijevic', 'ROLE_CUSTOMER', true, true, false, '+381692312321', '1995-03-05', 'Tomiceva 55', 'Beograd');
--user password: 1234
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login, phone_number, date_of_birth, address, city, profile_image_name) VALUES ('sysadmin@gmail.com', '$2a$10$Ng8dAJzSDmWjbsuQmKb7WeOl27Kc5DlySVmClnvfqaD7VAZqFW7v6', 'Marko', 'Markovic', 'ROLE_SYSTEM_ADMIN', true, true, false, '+3816656213', '09/26/1994', 'Frankopanova 9', 'Novi Sad', 'sysAdmin.jpg');
--user password: 12345
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login, phone_number, date_of_birth, address, city, profile_image_name) VALUES ('admin1@gmail.com', '$2a$10$gpHocgjdblYRnD.O/ri.qeeIoaLm8PZuQymydhgASYijPVM2q4tH2', 'Sima', 'Simonovic', 'ROLE_BOOKSTORE_ADMIN', true, true, true, '+3815523213', '02/02/1954', 'Simonoviceva 1', 'Sabac', 'sysAdmin.jpg');
--user password: 54321
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login, phone_number, date_of_birth, address, city, profile_image_name) VALUES ('admin2@gmail.com', '$2a$10$qNyWkzQz63f1Q2xTqTu.Meopa.MMD9pVAie9isAhm9N6A3.xyQLoO', 'Samjuel', 'Hrubik', 'ROLE_BOOKSTORE_ADMIN', true, true, true, '+3221332132', '02/12/1988', 'Guduriceva 2', 'Pancevo', 'sysAdmin.jpg');
--user password: 55555
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login, phone_number, date_of_birth, address, city, profile_image_name) VALUES ('seller@gmail.com', '$2a$10$665GOyAQmwqTkz/6HmxikOgLD1kVNnP6Yx7T1zXFECcC/kgAOh7JG', 'Aleksandar', 'Paripovic', 'ROLE_SELLER', true, true, true, '+553213212', '12/02/1999', 'Gospodareva 52', 'Karadjordjevo', 'sysAdmin.jpg');

--user authorities
INSERT INTO user_authority(user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority(user_id, authority_id) VALUES (2, 2);
INSERT INTO user_authority(user_id, authority_id) VALUES (3, 3);
INSERT INTO user_authority(user_id, authority_id) VALUES (4, 3);
INSERT INTO user_authority(user_id, authority_id) VALUES (5, 4);

--different users
INSERT INTO customer(user_id, processed) VALUES (1, true);
INSERT INTO bookstore_system_administrator(user_id) VALUES (2);
INSERT INTO bookstore_administrator(user_id, bookstore_id) VALUES (3, 1);
INSERT INTO bookstore_administrator(user_id, bookstore_id) VALUES (4, 2);
INSERT INTO seller(user_id, bookstore_id) VALUES (5, 2);

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
INSERT INTO writer(name, description, image) VALUES ('George R. R. Martin', 
				'George R.R. Martin, in full George Raymond Richard Martin, original name George Raymond Martin, 
				(born September 20, 1948, Bayonne, New Jersey, U.S.), American writer of fantasy, best known for his Song of Ice and Fire series (1996– ), 
				a bloody saga about various factions vying for control of a fictional kingdom.', 
				'georgeMartin.jpg');
INSERT INTO writer(name, description, image) VALUES ('J. K. Rowling',
														'J.K. Rowling is the British author who created the popular and critically acclaimed Harry Potter series (seven books published between 1997 and 2007),
														 about a lonely orphan who discovers that he is actually a wizard and enrolls in the Hogwarts School of Witchcraft and Wizardry.',
														'rowling.jpg');
INSERT INTO writer(name, description, image) VALUES ('J. R. R. Tolkien', 
															'J.R.R. Tolkien, in full John Ronald Reuel Tolkien, (born January 3, 1892, Bloemfontein, South Africa—died September 2, 1973, Bournemouth, 
															Hampshire, England), 
															English writer and scholar who achieved fame with his childrenss book The Hobbit (1937) and his 
															richly inventive epic fantasy The Lord of the Rings (1954–55).', 
															'tolkien.jpg');
INSERT INTO writer(name, description, image) VALUES ('William Shakespeare', 
													'William Shakespeare (bapt. 26 April 1564 – 23 April 1616) was an English playwright, poet, and actor, widely regarded as the greatest 
													writer in the English language and the worlds greatest dramatist. He is often called Englands national poet and the "Bard of Avon" (or simply "the Bard").', 
													'shakespeare.jpg');
INSERT INTO writer(name, description, image) VALUES ('Agatha Christie',
													'Agatha Christie was an English detective novelist and playwright. She wrote some 75 novels, including 66 detective novels and 14 short story collections. 
													Christie is perhaps the worlds most famous mystery writer and is one of the best-selling novelists of all time.', 
													'agathaChristie.jpg');
INSERT INTO writer(name, description, image) VALUES ('Edgar Allan Poe', 
													'Edgar Allan Poe was an American writer, poet, critic and editor best known for evocative short stories and poems that captured the imagination and interest of
													readers around the world. His imaginative storytelling and tales of mystery and horror gave birth to the modern detective story.', 
													'edgarAllanPoe.jpg');
INSERT INTO writer(name, description, image) VALUES ('Mark Twain', 
													'Mark Twain was an American humorist, novelist, and travel writer. Today he is best remembered as the author of The Adventures of Tom Sawyer (1876)
													and Adventures of Huckleberry Finn (1885). Twain is widely considered one of the greatest American writers of all time.', 
													'markTwain.jpg');
INSERT INTO writer(name, description, image) VALUES ('Stephen King', 
														'Mark Twain was an American humorist, novelist, and travel writer. Today he is best remembered as the author of The Adventures of Tom Sawyer (1876) and Adventures of Huckleberry Finn (1885).
														 Twain is widely considered one of the greatest American writers of all time.', 
														'stephenKing.jpg');
INSERT INTO writer(name, description, image) VALUES ('Ernest Hemingway', 
														'Ernest Hemingway served in World War I and worked in journalism before publishing his story collection In Our Time. He was renowned for novels 
														like The Sun Also Rises, A Farewell to Arms, For Whom the Bell Tolls and The Old Man and the Sea, which won the Pulitzer Prize in 1953. In 1954,
														Hemingway won the Nobel Prize.', 
														'ernestHemingway.jpg');
INSERT INTO writer(name, description, image) VALUES ('George Orwell', 
													'George Orwell, pseudonym of Eric Arthur Blair, (born June 25, 1903, Motihari, Bengal, India—died January 21, 1950, London, England), English novelist, essayist,
													 and critic famous for his novels Animal Farm (1945) and Nineteen Eighty-four (1949), the latter a profound anti-utopian novel that examines the dangers of totalitarian rule.', 
													'georgeOrwell.jpg'); --10

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
INSERT INTO other_product(id, code, name, price, description, published, type, publisher_id, cover_image) VALUES (0, '4311', 'Lego Set: Super Mario', 999, 'Lego sett1', '2019-02-01', 'TOY', 15, 'legoSet.jpg');
INSERT INTO other_product(id, code, name, price, description, published, type, publisher_id, cover_image) VALUES (42, '4312', 'Lego Set: Creator', 999, 'Lego sett2', '2019-05-01', 'TOY', 15, 'legoSet2.jpg');

--books
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (1, '115521', 'Game of Thrones', 1555, 'descrption1234', '2020-05-01', 1, 400, 'SERBIAN', 'gameOfThrones.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (2, '5551231', 'Lord of the Rings: Two Towers', 1500, 'description2222', '2020-05-01', 2, 420, 'SERBIAN', 'twoTowers.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (3, '332515', 'Lord of the Rings: Fellowship of the Ring', 1200, 'descrption3333', '2020-05-01', 2, 510, 'SERBIAN', 'fellowshipOfTheRing.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (4, '6532', 'Lord of the Rings: Return of the King', 1200, 'descrption4444', '2020-05-01', 2, 390, 'SERBIAN', 'returnOfTheKing.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (5, '54536', 'Harry Potter and the Philosophers Stone', 1500, 'descrption555', '2020-05-01', 3, 290, 'SERBIAN', 'harryPotter1.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (6, '785657', 'Harry Potter and the Half Blood Prince', 1700, 'descrption6666', '2020-05-01', 3, 320, 'SERBIAN', 'harryPotter6.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (7, '421564', 'Harry Potter and the Chamber of Secrets', 1300, 'descrption777', '2020-05-01', 3, 210, 'SERBIAN', 'harryPotter2.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (8, '987077', 'Harry Potter and the Prisoner of Azkaban', 1400, 'descrption8888', '2020-05-01', 3, 110, 'SERBIAN', 'harryPotter3.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (9, '654787', 'Harry Potter and the Goblet of Fire', 1500, 'descrption9999', '2020-05-01', 3, 400, 'SERBIAN', 'harryPotter4.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (10, '3255661', 'Harry Potter and the Order of Phoenix', 2100, 'descrption101010', '2020-05-01', 3, 280, 'SERBIAN', 'harryPotter5.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (11, '3166643', 'Harry Potter and the Deathly Hallows', 1750, 'descrption11111', '2020-05-01', 3, 350, 'SERBIAN', 'harryPotter7.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (12, '5544511', 'The Fall of Gondolin', 1100, 'descrption54321', '2020-05-01', 1, 250, 'SERBIAN', 'fallOfGondolin.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (13, '3213415', 'The Silmarillion', 1300, 'descrption5551', '2020-05-01', 1, 232, 'SERBIAN', 'silmarillion.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (14, '6546478', 'The Hobbit', 1000, 'descrption5551', '2020-05-01', 1, 400, 'SERBIAN', 'hobbit.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (15, '4234326', 'A Clash of Kings', 1300, 'descrption5551', '2020-05-01', 2, 270, 'SERBIAN', 'clashOfKings.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (16, '4277656', 'A Storm of Swords', 2500, 'descrption5551', '2020-05-01', 2, 300, 'SERBIAN', 'stormOfSwords.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (17, '8786667', 'A Feast for Crows', 2100, 'descrption5551', '2020-05-01', 2, 190, 'SERBIAN', 'feastForCrows.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (18, '7868455', 'A Dance with Dragons', 2700, 'descrption5551', '2020-05-01', 2, 360, 'SERBIAN', 'danceWithDragons.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (19, '54353767', 'The Winds of Winter', 2700, 'descrption5551', '2020-05-01', 2, 240, 'SERBIAN', 'windsOfWinter.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (20, '34363646', 'Fire & Blood', 2999, 'descrption5551', '2020-05-01', 2, 400, 'SERBIAN', 'fireAndBlood.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (21, '125512', 'The Adventures of Tom Sawyer', 900, 'descrption5551', '2020-05-01', 4, 260, 'SERBIAN', 'tomSawyer.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (22, '321556', 'Adventures of Huckleberry Finn', 900, 'descrption5551', '2020-05-01', 4, 300, 'SERBIAN', 'huckleberryFinn.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (23, '7657657', 'Animal Farm', 700, 'descrption5551', '2020-05-01', 5, 400, 'SERBIAN', 'animalFarm.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (24, '65758354', '1984', 800, 'descrption5551', '2020-05-01', 5, 320, 'SERBIAN', '1984.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (25, '54353467', 'It', 2700, 'descrption5551', '2020-05-01', 10, 400, 'SERBIAN', 'it.png');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (26, '5435', 'Misery', 900, 'descrptio49219', '2020-05-01', 10, 390, 'SERBIAN', 'misery.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (27, '4324', 'The Shining', 1100, 'descrption32135', '2020-05-01', 10, 200, 'SERBIAN', 'shining.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (28, '6642', 'Carrie', 1000, 'descrption553251', '2020-05-01', 10, 100, 'SERBIAN', 'carrie.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (29, '22131', 'Pet Sematary', 1500, 'descrption51123', '2020-05-01', 10, 90, 'SERBIAN', 'petSematary.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (30, '21556', 'Murder on the Orient Express', 2100, 'descrption66545', '2020-05-01', 11, 510, 'SERBIAN', 'orientExpress.png');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (31, '222135', 'Three Act Tragedy', 1000, 'descrption51111', '2020-05-01', 11, 330, 'SERBIAN', 'threeActTragedy.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (32, '66546', 'Sleeping Murder', 1000, 'descrption99921', '2020-05-01', 11, 310, 'SERBIAN', 'sleepingMurder.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (33, '43242', 'Passenger to Frankfurt', 900, 'descrption675756', '2020-05-01', 11, 150, 'SERBIAN', 'passengerToFrankfurt.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (38, '7652234', 'The Old Man and the Sea', 600, 'descrption696969', '2020-05-01', 14, 170, 'SERBIAN', 'oldManAndTheSea.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (39, '32166', 'The Garden of Eden', 760, 'descrption666', '2020-05-01', 14, 215, 'SERBIAN', 'gardenOfEden.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (40, '331663', 'A Farewell to Arms', 900, 'descrptio6643', '2020-05-01', 14, 175, 'SERBIAN', 'farewellToArms.jpg');
INSERT INTO book(id, code, name, price, description, published, publisher_id, number_of_pages, language, cover_image) VALUES (41, '3332156', 'For Whom the Bell Tolls', 1000, 'descrption321312', '2020-05-01', 14, 120, 'SERBIAN', 'forWhomTheBellTolls.jpg');

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

