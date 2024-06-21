--CREATE Schema

CREATE SCHEMA movie;

--CREATE a new domain


CREATE DOMAIN movie.scoredomain AS SMALLINT
CONSTRAINT evaluate_score_check CHECK ((( VALUE >= 1) AND ( VALUE <= 5)));


--Table Creation
--Rating
CREATE TABLE movie.Rating (
	movieId INTEGER NOT NULL,
	username CHARACTER VARYING (14) NOT NULL,
	rating INTEGER NOT NULL,
	review CHARACTER VARYING (250) NOT NULL,
	data  DATE NOT NULL,
	FOREIGN KEY ( movieId ) REFERENCES movie.movie1( movieId ) ,
	FOREIGN KEY ( username ) REFERENCES movie.user ( username ) ,
	PRIMARY KEY (movieId, username)
);
