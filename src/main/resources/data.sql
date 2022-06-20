INSERT INTO USERS (ADDRESS, DEPARTMENTS, EMAIL, NAME, PASSWORD, PHONE_NUMBER, SEX, SURNAME, USER_TYPE, USERNAME)
VALUES
('Buna-Ziua nr 41', 'Video-Proector,sonorizare', 'moholea.darius@gmail.com', 'Moholea', 'parolamea', '0751583188', 0, 'Darius', 0, 'Moholeaaa'),
('Mehedinti nr23', 'sonorizare', 'moholea58@gmail.com', 'Moholea', 'parolamea', '0751583188', 0, 'Darius', 0, 'Moholeaaa'),
('Mehedinti nr23', 'sonorizare', 'moholea58@gmail.com', 'Moholea', 'parolamea', '0751583188', 0, 'Darius', 0, 'Moholeaaa');

INSERT INTO NOTIFICATIONS (MESSAGE, READ_DATE, SEND_DATE, SENDER, STATUS, TITLE, USER_ID)
VALUES
('Acesta este mesajul notificarii', '2022-06-10T10:15:30', '2022-06-10T10:15:30', 'Moholea', 0, 'acesta este un titlu', 1),
('acesta este un mesaj', '2022-06-10T10:15:30', '2022-06-10T10:15:30', 'Moholea', 0, 'acesta este un titlu', 1),
('acesta este un mesaj', '2022-06-10T10:15:30', '2022-06-10T10:15:30', 'Moholea', 0, 'acesta este un titlu', 2),
('acesta este un mesaj', '2022-06-10T10:15:30', '2022-06-10T10:15:30', 'Moholea', 0, 'acesta este un titlu', 2);

INSERT INTO GROUPS (DESCRIPTION, NAME)
VALUES
('Grup de tinerii', 'Zoe'),
('Grup de lauda si inchinare', 'Band'),
('grup cu toti tinerii', 'TineriElim'),
('Grup scoala duminicala', 'Scoala Duminicala');

INSERT INTO USER_GROUP (GROUP_ID, USER_ID)
VALUES
(1, 1), (2,1), (3, 1), (4, 1), (3, 2), (3, 3), (2, 2);

INSERT INTO ROOMS (MAX_CAPACITY, NUMBER, STATUS)
VALUES
(300, 1, 0),
(50, 2, 0),
(50, 3, 0);