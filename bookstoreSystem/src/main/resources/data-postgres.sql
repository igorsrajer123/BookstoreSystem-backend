INSERT INTO authority(name) VALUES ('ROLE_CUSTOMER');

--user password: 123
INSERT INTO user_entity(email, password, first_name, last_name, type, activated, enabled, first_login) VALUES ('isapsw1234@gmail.com', '$2a$10$M3.YOtEuBCSNbgzJ3hkQv.ZgOMGNSTataYMx1UU7OnqMrlC6Osgzm', 'Misa', 'Dimitrijevic', 'ROLE_CUSTOMER', true, true, true);
