DROP TABLE movies CASCADE CONSTRAINTS
/

DROP TABLE genres CASCADE CONSTRAINTS
/

DROP TABLE movieGenres CASCADE CONSTRAINTS
/

DROP TABLE actor CASCADE CONSTRAINTS
/

DROP TABLE director CASCADE CONSTRAINTS
/

DROP TABLE acting CASCADE CONSTRAINTS
/

DROP TABLE directing CASCADE CONSTRAINTS
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

CREATE TABLE actor(
    	id INT NOT NULL PRIMARY KEY,
    	name VARCHAR2(25)
);
/

CREATE TABLE director(
    	id INT NOT NULL PRIMARY KEY,
    	name VARCHAR2(25)
);
/

CREATE TABLE acting(
	id_actor INT NOT NULL,
	id_movie INT NOT NULL,
	CONSTRAINT fk_actor_id FOREIGN KEY (id_actor) REFERENCES actor(id),
	CONSTRAINT fk_movie_role_id FOREIGN KEY (id_movie) REFERENCES movies(id),
	CONSTRAINT no_duplicates_acting_roles UNIQUE (id_actor,id_movie)
);
/

CREATE TABLE directing(
	id_director INT NOT NULL,
	id_movie INT NOT NULL,
	CONSTRAINT fk_director_id FOREIGN KEY (id_director) REFERENCES director(id),
	CONSTRAINT fk_movie_directed_id FOREIGN KEY (id_movie) REFERENCES movies(id),
	CONSTRAINT no_duplicates_directed_role UNIQUE (id_director,id_movie)
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
