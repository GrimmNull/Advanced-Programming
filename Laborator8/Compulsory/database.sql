DROP TABLE movies CASCADE CONSTRAINTS
/

DROP TABLE genres CASCADE CONSTRAINTS
/

DROP TABLE movieGenres CASCADE CONSTRAINTS
/

DROP CONSTRAINT fk_movie_id
/

DROP CONSTRAINT fk_genre_id
/

DROP CONSTRAINT no_duplicates_movies
/


CREATE TABLE movies(
	id INT NOT NULL PRIMARY KEY,
	title VARCHAR2(25),
	release_date DATE,
	durata INT,
	score INT
);
/

CREATE TABLE genres(
	id INT NOT NULL PRIMARY KEY,
	name VARCHAR2(25)
);
/

CREATE TABLE movieGenres(
	id_movie INT NOT NULL,
	id_genre INT NOT NULL,
	CONSTRAINT fk_movie_id FOREIGN KEY (id_movie) REFERENCES movies(id),
	CONSTRAINT fk_genre_id FOREIGN KEY (id_genre) REFERENCES genres(id),
	CONSTRAINT no_duplicates_movies UNIQUE (id_movie,id_genre)
);
/

INSERT INTO movies (id, title, release_date, durata, score) VALUES (1,'Flash',TO_DATE('3-OCT-2002','DD-MON-YYYY'),130,68);
/

INSERT INTO movies (id, title, release_date, durata, score) VALUES (2,'Barbie',TO_DATE('4-OCT-2002','DD-MON-YYYY'),132,67);
/

INSERT INTO movies (id, title, release_date, durata, score) VALUES (3,'Garfield',TO_DATE('5-OCT-2002','DD-MON-YYYY'),140,100);
/

INSERT INTO movies (id, title, release_date, durata, score) VALUES (4,'Shrek',TO_DATE('6-OCT-2002','DD-MON-YYYY'),180,101);
/
