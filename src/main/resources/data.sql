-- REGISTRO DE AUTHOR
INSERT INTO AUTHOR(name,email,phone,birth_date) VALUES ('Raul Lozada','rlozada@gmail.com','993152354',TO_DATE('01-12-2019','dd-MM-yyyy'));
INSERT INTO AUTHOR(name,email,phone,birth_date) VALUES ('Cris Paredes','rlozada@gmail.com','99315353',TO_DATE('01-12-1990','dd-MM-yyyy'));

-- REGISTRO DE BLOG ASOCIADOS AL AUTHOR
INSERT INTO BLOG(description,name,status,url,author_id) values ('Blog de Harry Pother','Masha','ACTIVO','www.harrypother.com',1);
INSERT INTO BLOG(description,name,status,url,author_id) values ('Blog de Harry Pother v2','Aisha','INACTIVO','www.harrypotherv2.com',1);

-- REGISTRO DE POST POR BLOG
INSERT INTO POST(title,date,status,content,blog_id) values ('Harry Pother','2021-02-12 01:00:00', 'PUBLICADO','Este es el nuevo libro',1);
INSERT INTO POST(title,date,status,content,blog_id) values ('Harry Pother v2','2021-02-12 01:00:00', 'BORRADO','Este es el nuevo libro v2',1);