INSERT INTO USUARIO VALUES(1, 'ggg@jjj.com', '$2a$10$7fFqw56U//gZCxRSvR8DBO2KPrAf/wFPQbgrR8tZbQbZZBeV.JwKa', 'nacho');

INSERT INTO USUARIO_PRIVILEGIO VALUES(1, 'ADMIN', 1);
INSERT INTO USUARIO_PRIVILEGIO VALUES(2, 'USER', 1);

INSERT INTO MENU VALUES(1, 'Home', 1, '/', null);
INSERT INTO MENU VALUES(2, 'Admin', 2, null, null);
INSERT INTO MENU VALUES(3, 'Administracion', 3, '/admin', 2);

INSERT INTO MENU_PRIVILEGIO VALUES(1, 'USER', 1);
INSERT INTO MENU_PRIVILEGIO VALUES(2, 'ADMIN', 2);
INSERT INTO MENU_PRIVILEGIO VALUES(3, 'ADMIN', 3);