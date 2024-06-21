-- Delete pre-existent database instance (if any)
DROP DATABASE IF EXISTS Webedge;

-- Create the database
CREATE DATABASE Webedge ENCODING 'UTF-8';

\connect Webedge

-- Create new domains
CREATE DOMAIN passwd AS VARCHAR(254)
 CONSTRAINT properpassword CHECK (((VALUE)::text~* '[A-Za-z0-9._%!]{8,}'::text));

CREATE DOMAIN emailaddress AS VARCHAR(254)
 CONSTRAINT properemail CHECK (((VALUE)::text~* '^[A-Za-z0-9._%]+@[A-Za-z0-9.]+[.][A-Za-z]+$'::text));

CREATE TABLE Users (
    email VARCHAR(250) PRIMARY KEY,
    name VARCHAR(250),
    surname VARCHAR(250),
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);

COMMENT ON TABLE Users IS 'Represents a user.';
COMMENT ON COLUMN Users.email IS 'Unique identifier for the user.';
COMMENT ON COLUMN Users.name IS 'Name of the user.';
COMMENT ON COLUMN Users.surname IS 'Surname of the user.';
COMMENT ON COLUMN Users.username IS 'Username of the user.';
COMMENT ON COLUMN Users.password IS 'Password of the user.';


CREATE TABLE Person (
	personID serial PRIMARY KEY,
	name CHARACTER VARYING (250) NOT NULL,
	surname CHARACTER VARYING (250) NOT NULL,
	shortBio CHARACTER VARYING (500) NOT NULL,
	birthplace CHARACTER VARYING (250) NOT NULL,
	birthdate DATE NOT NULL,
	photolink CHARACTER VARYING (250),
	role CHARACTER VARYING (250) NOT NULL
);

COMMENT ON TABLE Person IS 'Represents a celebrity.';
COMMENT ON COLUMN Person.personId IS 'Unique identifier for the person.';
COMMENT ON COLUMN Person.name IS 'Name of the person.';
COMMENT ON COLUMN Person.surname IS 'Surname of the person.';
COMMENT ON COLUMN Person.shortBio IS 'Short biography of the person.';
COMMENT ON COLUMN Person.birthplace IS 'Birth place of the person.';
COMMENT ON COLUMN Person.birthdate IS 'Birth date of the person.';
COMMENT ON COLUMN Person.photolink IS 'Link to the photo of the person.';
COMMENT ON COLUMN Person.role IS 'Role of the person.';

CREATE TABLE Movie (
    movieID serial PRIMARY KEY,
    title CHARACTER VARYING(250) NOT NULL,
    director CHARACTER VARYING(250) NOT NULL,
    releasedate DATE NOT NULL,
    genre CHARACTER VARYING(250) NOT NULL, 
	trailerURL VARCHAR(255) NOT NULL
);

CREATE TABLE Award (
	awardID serial PRIMARY KEY,
	movieID serial NOT NULL,
	personID INTEGER,
	winnername CHARACTER VARYING (250) NOT NULL,
	year DATE NOT NULL,
	category CHARACTER VARYING (250) NOT NULL,
	genre CHARACTER VARYING (250) NOT NULL,
	FOREIGN KEY ( movieID ) REFERENCES Movie (movieID),
	FOREIGN KEY ( personID ) REFERENCES Person (personID)
);

CREATE TABLE Rates (
    movieID SERIAL,
    useremail VARCHAR(250), -- Use the same data type as in the Users table
    score INTEGER NOT NULL,
    review VARCHAR, -- You may want to consider the length of the review
    FOREIGN KEY (movieID) REFERENCES Movie (movieID),
    FOREIGN KEY (useremail) REFERENCES Users (email), -- Corrected foreign key reference
    PRIMARY KEY (movieID, useremail)
);

CREATE TABLE Watchlist (
    watchListID SERIAL PRIMARY KEY,
    useremail VARCHAR(250) NOT NULL, -- Change data type to VARCHAR(250)
    movielist INTEGER[],
    FOREIGN KEY (useremail) REFERENCES Users (email)
);

CREATE TABLE Belongs (
	watchlistID serial,
	movieID serial,
	FOREIGN KEY ( watchlistID ) REFERENCES Watchlist (watchlistID),
	FOREIGN KEY ( movieID ) REFERENCES Movie (movieID),
	PRIMARY KEY ( watchlistID, movieID )
);

CREATE TABLE Participates (
	movieID serial,
	personID serial,
	role VARCHAR(50) NOT NULL,
	FOREIGN KEY ( movieID ) REFERENCES Movie (movieID),
	FOREIGN KEY ( personID ) REFERENCES Person (personID),
	PRIMARY KEY ( movieID, personID )
);

