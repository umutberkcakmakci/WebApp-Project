-- Populate User table
INSERT INTO Users (email, name, surname, username, password) 
VALUES 
    ('johndoe@gmail.com', 'John', 'Doe', 'johndoe', 'J0hnD03!'),
    ('janesmith@hotmail.com', 'Jane', 'Smith', 'janesmith', 'Smithy#123'),
    ('michaeljohnson@yahoo.com', 'Michael', 'Johnson', 'mjohnson', 'Mikey!@#'),
    ('alicejohnson@gmail.com', 'Alice', 'Johnson', 'alicej', 'Alic3!@#'),
    ('bobsmith@hotmail.com', 'Bob', 'Smith', 'bobsmith', 'B0bby!@#'),
    ('emilydavis@yahoo.com', 'Emily', 'Davis', 'emilydavis', '3mily!@#'),
    ('davidbrown@gmail.com', 'David', 'Brown', 'davidbrown', 'Dav1d!@#'),
    ('emmawilson@hotmail.com', 'Emma', 'Wilson', 'emmawilson', '3mm@!@#'),
    ('jamesmartinez@yahoo.com', 'James', 'Martinez', 'jamesmartinez', 'Jam3s!@#'),
    ('oliviaanderson@gmail.com', 'Olivia', 'Anderson', 'oliviaa', 'Ol!via#123'),
    ('williamtaylor@hotmail.com', 'William', 'Taylor', 'williamt', 'Will!@#'),
    ('sophiathomas@yahoo.com', 'Sophia', 'Thomas', 'sophiat', 'Soph!@#'),
    ('benjaminhernandez@gmail.com', 'Benjamin', 'Hernandez', 'benjaminh', 'B3nj!@#'),
    ('avamoore@hotmail.com', 'Ava', 'Moore', 'avam', 'Av@!@#'),
    ('masongarcia@yahoo.com', 'Mason', 'Garcia', 'masong', 'Mas0n!@#'),
    ('charlotteyoung@gmail.com', 'Charlotte', 'Young', 'charlottey', 'Ch@rlotte#'),
    ('ethanking@hotmail.com', 'Ethan', 'King', 'ethank', 'Eth@n!@#'),
    ('ameliascott@yahoo.com', 'Amelia', 'Scott', 'amelias', 'Am3li@!@#'),
    ('alexanderrivera@gmail.com', 'Alexander', 'Rivera', 'alexanderr', 'Al3x@!@#'),
    ('harpergreen@hotmail.com', 'Harper', 'Green', 'harperg', 'Harp3r!@#'),
    ('michaell@yahoo.com', 'Michael', 'Lee', 'michaell', 'Mich@3l!@#'),
    ('evelynadams@gmail.com', 'Evelyn', 'Adams', 'evelyna', 'Ev3lyn!@#'),
    ('danielbaker@hotmail.com', 'Daniel', 'Baker', 'danielb', 'D@niel#123'),
    ('abigailgonzalez@yahoo.com', 'Abigail', 'Gonzalez', 'abigailg', 'Ab!g@!@#'),
    ('matthewnelson@gmail.com', 'Matthew', 'Nelson', 'matthewn', 'M@tt3w#123'),
    ('samanthacarter@hotmail.com', 'Samantha', 'Carter', 'samanthac', 'S@manth@#'),
    ('davidmitchell@yahoo.com', 'David', 'Mitchell', 'davidm', 'Dav!d!@#'),
    ('lillianperez@gmail.com', 'Lillian', 'Perez', 'lillianp', 'L!ll!@n#'),
    ('lucasroberts@hotmail.com', 'Lucas', 'Roberts', 'lucasr', 'Luc@s!@#'),
    ('averyhill@yahoo.com', 'Avery', 'Hill', 'averyh', 'Av3ry!@#'),
    ('jjeff@moviedb.com', 'John', 'Jefferson', 'jjeff', '12345'),
    ('ahill@mail.com', 'Avery', 'Hill', 'averyh', 'test');


INSERT INTO Person (personID, name, surname, shortBio, birthplace, birthdate, photolink, role)
VALUES
    (100001, 'Steven', 'Spielberg', 'One of the most influential personalities in the history of cinema, Steven Spielberg is Hollywoods best known director and one of the wealthiest filmmakers in the world. ', 'Cincinnati, Ohio, USA', '1946-12-18', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/MKr25425_Steven_Spielberg_%28Berlinale_2023%29.jpg/1024px-MKr25425_Steven_Spielberg_%28Berlinale_2023%29.jpg', 'Director, Producer'),
    (100002, 'Leonardo', 'DiCaprio', 'Few actors in the world have had a career quite as diverse as Leonardo DiCaprios. DiCaprio has gone from relatively humble beginnings, as a supporting cast member of the sitcom', 'Los Angeles, California, USA', '1974-11-11', NULL, 'Actor'),
    (100003, 'Meryl', 'Streep', 'Considered by many critics to be the greatest living actress, Meryl Streep has been nominated for the Academy Award an astonishing 21 times, and has won it three times.', 'Summit, New Jersey, USA', '1949-06-22', NULL, 'Actor'),
    (100004, 'Tom', 'Hanks', 'Thomas Jeffrey Hanks was born in Concord, California, to Janet Marylyn (Frager), a hospital worker, and Amos Mefford Hanks, an itinerant cook. ', 'Concord, California, USA', '1956-07-09', NULL, 'Actor'),
    (100005, 'Christopher', 'Nolan', 'Best known for his cerebral, often nonlinear, storytelling, acclaimed Academy Award winner writer/director/producer Sir Christopher Nolan CBE was born in London, England. ', 'London, England', '1970-07-30', NULL, 'Director, Writer'),
    (100006, 'Emma', 'Watson', 'Emma Charlotte Duerre Watson was born in Paris, France, to British parents, Jacqueline Luesby and Chris Watson, both lawyers.', 'Paris, France', '1990-04-15', NULL, 'Actor'),
    (100007, 'Brad', 'Pitt', 'William Bradley "Brad" Pitt was born on December 18, 1963 in Shawnee, Oklahoma and raised in Springfield, Missouri to Jane Etta Pitt (née Hillhouse), a school counselor & William Alvin "Bill" Pitt, a truck company manager. ', 'Shawnee, Oklahoma, USA', '1963-12-18', NULL, 'Actor'),
    (100008, 'Angelina', 'Jolie', 'Angelina Jolie is an Academy Award-winning actress who rose to fame after her role in Girl, Interrupted (1999), playing the title role in the "Lara Croft" blockbuster movies, as well as Mr. & Mrs. Smith (2005), Wanted (2008), Salt (2010) and Maleficent (2014). ', 'Los Angeles, California, USA', '1975-06-04', NULL, 'Actor'),
    (100009, 'Quentin', 'Tarantino', 'Quentin Jerome Tarantino was born in Knoxville, Tennessee. His father, Tony Tarantino, is an Italian-American actor and musician from New York, and his mother, Connie (McHugh), is a nurse from Tennessee.', 'Knoxville, Tennessee, USA', '1963-03-27', NULL, 'Director, Writer'),
    (100010, 'Natalie', 'Portman', 'Natalie Portman is the first person born in the 1980s to have won the Academy Award for Best Actress (for Black Swan (2010)).', 'Jerusalem, Israel', '1981-06-09', NULL, 'Actor'),
    (100011, 'Johnny', 'Depp', 'John Christopher "Johnny" Depp II was born on June 9, 1963 in Owensboro, Kentucky, to Betty Sue Palmer (née Wells), a waitress, and John Christopher Depp, a civil engineer.', 'Owensboro, Kentucky, USA', '1963-06-09', NULL, 'Actor'),
    (100012, 'Martin', 'Scorsese', 'Martin Charles Scorsese was born on November 17, 1942 in Queens, New York City, to Catherine Scorsese (née Cappa) and Charles Scorsese, who both worked in Manhattans garment district, and whose families both came from Palermo, Sicily.', 'Queens, New York City, New York, USA', '1942-11-17', NULL, 'Director'),
    (100013, 'Scarlett', 'Johansson', 'Scarlett Ingrid Johansson was born on November 22, 1984 in Manhattan, New York City, New York. Her mother, Melanie Sloan is from a Jewish family from the Bronx and her father, Karsten Johansson is a Danish-born architect from Copenhagen. ', 'New York City, New York, USA', '1984-11-22', NULL, 'Actor'),
    (100014, 'Bradley', 'Cooper', 'Bradley Charles Cooper was born on January 5, 1975 in Philadelphia, Pennsylvania. His mother, Gloria (Campano), is of Italian descent, and worked for a local NBC station. His father, Charles John Cooper, who was of Irish descent, was a stockbroker.', 'Philadelphia, Pennsylvania, USA', '1975-01-05', NULL, 'Actor'),
    (100015, 'Alfred', 'Hitchcock', 'Alfred Joseph Hitchcock was born in Leytonstone, Essex, England. He was the son of Emma Jane (Whelan; 1863 - 1942) and East End greengrocer William Hitchcock (1862 - 1914). ', 'Leytonstone, London, England', '1899-08-13', NULL, 'Director'),
    (100016, 'Jennifer', 'Lawrence', 'As the highest-paid actress in the world in 2015 and 2016, and with her films grossing over $5.5 billion worldwide, Jennifer Lawrence is often cited as the most successful actress of her generation. ', 'Indian Hills, Kentucky, USA', '1990-08-15', NULL, 'Actor'),
    (100017, 'Woody', 'Allen', 'Woody Allen was born on November 30, 1935, as Allen Konigsberg, in The Bronx, NY, the son of Martin Konigsberg and Nettie Konigsberg.', 'The Bronx, New York City, New York, USA', '1935-12-01', NULL, 'Director'),
    (100018, 'Emma', 'Stone', 'Emily Jean "Emma" Stone was born on November 6, 1988 in Scottsdale, Arizona to Krista Jean Stone (née Yeager), a homemaker & Jeffrey Charles "Jeff" Stone, a contracting company founder and CEO.', 'Scottsdale, Arizona, USA', '1988-11-06', NULL, 'Actor'),
    (100019, 'Robert', 'De Niro', 'One of the greatest actors of all time, Robert De Niro was born on August 17, 1943 in Manhattan, New York City, to artists Virginia (Admiral) and Robert De Niro Sr. ', 'New York City, New York, USA', '1943-08-17', NULL, 'Actor'),
    (100020, 'Steven', 'Soderbergh', 'Steven Andrew Soderbergh was born on January 14, 1963 in Atlanta, Georgia, USA, the second of six children of Mary Ann (Bernard) and Peter Soderbergh.', 'Atlanta, Georgia, USA', '1963-01-14', NULL, 'Director'),
    (100021, 'Cate', 'Blanchett', 'Cate Blanchett was born on May 14, 1969 in Melbourne, Victoria, Australia, to June (Gamble), an Australian teacher and property developer, and Robert DeWitt Blanchett, Jr., an American advertising executive, originally from Texas. ', 'Melbourne, Victoria, Australia', '1969-05-14', NULL, 'Actor'),
    (100022, 'George', 'Clooney', 'George Timothy Clooney was born on May 6, 1961, in Lexington, Kentucky, to Nina Bruce (née Warren), a former beauty pageant queen, and Nick Clooney, a former anchorman and television host (who was also the brother of singer Rosemary Clooney).', 'Lexington, Kentucky, USA', '1961-05-06', NULL, 'Actor'),
    (100023, 'James', 'Cameron', 'James Francis Cameron was born on August 16, 1954 in Kapuskasing, Ontario, Canada. He moved to the United States in 1971.', 'Kapuskasing, Ontario, Canada', '1954-08-16', NULL, 'Director'),
    (100024, 'Charlize', 'Theron', ' Oscar-winning South African actress known for her versatile roles, from intense dramas to action-packed blockbusters.', 'Benoni, Transvaal Province, South Africa', '1975-08-07', NULL, 'Actor'),
    (100025, 'Tim', 'Burton', ' Iconic filmmaker celebrated for his dark and whimsical style, creating memorable worlds in movies like "Edward Scissorhands" and "The Nightmare Before Christmas."', 'Burbank, California, USA', '1958-08-25', NULL, 'Director'),
    (100026, 'Nicole', 'Kidman', 'Academy Award-winning Australian actress recognized for her captivating performances in films ranging from dramas like "Moulin Rouge!" to psychological thrillers like "The Others."', 'Honolulu, Hawaii, USA', '1967-06-20', NULL, 'Actor'),
    (100027, 'Ridley', 'Scott', 'Visionary director renowned for his groundbreaking work in science fiction with films like "Blade Runner" and "Alien," as well as epic historical dramas like "Gladiator."', 'South Shields, County Durham, England', '1937-11-30', NULL, 'Director'), -- Gladiator, Blade Runner
    (100028, 'Julia', 'Roberts', 'Americas sweetheart and Academy Award-winning actress known for her roles in romantic comedies like "Pretty Woman" and critically acclaimed dramas such as "Erin Brockovich."', 'Smyrna, Georgia, USA', '1967-10-28', NULL, 'Actor'),
    (100029, 'Francis', 'Ford Coppola', 'Legendary filmmaker behind masterpieces like "The Godfather" trilogy and "Apocalypse Now," influencing generations with his storytelling prowess.', 'Detroit, Michigan, USA', '1939-04-07', NULL, 'Director'),
    (100030, 'Anne', 'Hathaway', 'Versatile actress recognized for her range in roles, from her breakthrough performance in "The Princess Diaries" to her Oscar-winning portrayal in "Les Misérables."', 'Brooklyn, New York City, New York, USA', '1982-11-12', NULL, 'Actor'),
    (100031, 'Aaron', 'Sorkin', 'Emmy and Oscar-winning screenwriter known for his sharp dialogue and politically charged dramas, including "The West Wing" and "The Social Network."', 'New York City, New York, USA', '1961-06-09', NULL, 'Writer'),
    (100032, 'Emma', 'Thompson', 'Academy Award-winning British actress celebrated for her wit and versatility in roles ranging from period dramas like "Sense and Sensibility" to contemporary comedies like "Love Actually."', 'Paddington, London, England', '1959-04-15', NULL, 'Writer'),
    (100034, 'Greta', 'Gerwig', 'Acclaimed filmmaker known for her distinctive voice in movies like "Lady Bird" and "Little Women," capturing the complexities of female experiences with nuance and authenticity.', 'Sacramento, California, USA', '1983-08-04', NULL, 'Writer'),
    (100036, 'Kathleen', 'Kennedy', 'Esteemed film producer and current president of Lucasfilm, overseeing the revitalization of the "Star Wars" franchise and championing diverse storytelling in Hollywood.', 'Berkeley, California, USA', '1953-06-05', NULL, 'Producer'),
    (100038, 'Scott', 'Rudin', 'Prolific producer known for his involvement in award-winning films and Broadway shows.', 'Baldwin, New York, USA', '1958-07-14', NULL, 'Producer'),
    (100039, 'Denise', 'Di Novi', 'Respected film producer behind a diverse range of projects, from romantic dramas like "Crazy, Stupid, Love" to psychological thrillers like "The Devils Advocate."', 'Los Angeles, California, USA', '1956-05-21', NULL, 'Producer'),
    (100040, 'Brian', 'Grazer', 'Academy Award-winning producer recognized for his collaboration with director Ron Howard on films like "A Beautiful Mind," showcasing his knack for bringing compelling stories to the screen', 'Los Angeles, California, USA', '1951-07-12', NULL, 'Producer'),
    (100041, 'Hayao', 'Miyazaki', 'Renowned Japanese animator and co-founder of Studio Ghibli, revered for his imaginative storytelling and visually stunning animated films such as "Spirited Away" and "My Neighbor Totoro."', 'Tokyo, Japan', '1941-01-01', NULL, 'Director'), 
    (100042, 'Bong', 'Joon-ho', 'Award-winning South Korean filmmaker known for his genre-defying films like "Parasite," exploring social issues with dark humor and sharp commentary.', 'Daegu, South Korea', '1969-09-13', NULL, 'Director'),  -- Parasite
    (100043, 'Sidney', 'Lumet', 'Esteemed director celebrated for his gritty portrayals of urban life and complex character studies in films like "12 Angry Men" and "Dog Day Afternoon."', 'Philadelphia, Pennsylvania, USA', '1924-06-25', NULL, 'Director'),  -- 12 Angry Men
    (100044, 'John', 'Hughes', 'Iconic filmmaker and screenwriter whose teen comedies of the 1980s, including "The Breakfast Club" and "Ferris Buellers Day Off," continue to resonate with audiences.', 'Northbrook, Illinois, USA', '1950-02-18', NULL, 'Director'),  -- The Breakfast Club
    (100045, 'David', 'Fincher', 'Visionary director recognized for his meticulous craftsmanship and dark, atmospheric storytelling in films like "Fight Club," "Se7en," and "The Social Network."', 'Denver, Colorado, USA', '1962-08-29', NULL, 'Director'),  -- Fight Club, Se7en
    (100046, 'Frank', 'Darabont', 'Acclaimed filmmaker known for his powerful adaptations of Stephen Kings works, including "The Shawshank Redemption" and "The Green Mile."', 'New Jersey, USA', '1959-01-28', NULL, 'Director'),  -- The Shawshank Redemption, The Green Mile
    (100047, 'Stanley', 'Kubrick', 'Visionary director behind some of cinemas most influential and enigmatic films, including "2001: A Space Odyssey," "A Clockwork Orange," and "The Shining."', 'New York City, New York, USA', '1928-07-26', NULL, 'Director'),  -- The Shining, 2001: A Space Odyssey
    (100049, 'Clint', 'Eastwood', 'Legendary actor and director known for his iconic roles in Westerns and gritty dramas, as well as his masterful work behind the camera with films like "Unforgiven" and "Million Dollar Baby."', 'San Francisco, California, USA', '1930-05-31', NULL, 'Director'),
    (100050, 'Morgan', 'Freeman', 'Academy Award-winning actor celebrated for his commanding presence and powerful performances in films like "The Shawshank Redemption" and "Driving Miss Daisy."', 'Memphis, Tennessee, USA', '1937-06-01', NULL, 'Actor'),
    (100051, 'Tom', 'Cruise', 'A-list actor and producer known for his charismatic performances and high-octane action films like the "Mission: Impossible" series, as well as dramatic roles in movies like "Jerry Maguire" and "Top Gun."', 'Syracuse, New York, USA', '1962-07-03', NULL, 'Actor');
    
-- Populate Movie table
INSERT INTO Movie (movieID, title, director, releasedate, genre, trailerURL) 
VALUES 
    (200001, 'Inception', 'Christopher Nolan', '2010-07-16', 'Action, Sci-Fi, Thriller', 'https://www.youtube.com/watch?v=YoHD9XEInc0'),
    (200002, 'Titanic', 'James Cameron', '1997-12-19', 'Drama, Romance', 'https://www.youtube.com/watch?v=CHekzSiZjrY'),
    (200003, 'The Shawshank Redemption', 'Frank Darabont', '1994-10-14', 'Drama', 'https://www.youtube.com/watch?v=PLl99DlL6b4'),
    (200004, 'The Godfather', 'Francis Ford Coppola', '1972-03-24', 'Crime, Drama', 'https://www.youtube.com/watch?v=UaVTIH8mujA'),
    (200005, 'The Dark Knight', 'Christopher Nolan', '2008-07-18', 'Action, Crime, Drama', 'https://www.youtube.com/watch?v=EXeTwQWrcwY'),
    (200006, 'Pulp Fiction', 'Quentin Tarantino', '1994-10-14', 'Crime, Drama', 'https://www.youtube.com/watch?v=s7EdQ4FqbhY'),
    (200007, 'Forrest Gump', 'Robert Zemeckis', '1994-07-06', 'Drama, Romance', 'https://www.youtube.com/watch?v=bLvqoHBptjg'),
    (200008, 'The Lord of the Rings: The Return of the King', 'Peter Jackson', '2003-12-17', 'Adventure, Drama, Fantasy', 'https://www.youtube.com/watch?v=r5X-hFf6Bwo'),
    (200009, 'Fight Club', 'David Fincher', '1999-10-15', 'Drama', 'https://www.youtube.com/watch?v=BdJKm16Co6M'),
    (200010, 'The Matrix', 'Lana Wachowski, Lilly Wachowski', '1999-03-31', 'Action, Sci-Fi', 'https://www.youtube.com/watch?v=vKQi3bBA1y8'),
    (200011, 'Goodfellas', 'Martin Scorsese', '1990-09-21', 'Biography, Crime, Drama', 'https://www.youtube.com/watch?v=2ilzidi_J8Q'),
    (200012, 'The Lord of the Rings: The Fellowship of the Ring', 'Peter Jackson', '2001-12-19', 'Adventure, Drama, Fantasy', 'https://www.youtube.com/watch?v=V75dMMIW2B4'),
    (200013, 'The Silence of the Lambs', 'Jonathan Demme', '1991-02-14', 'Crime, Drama, Thriller', 'https://www.youtube.com/watch?v=6iB21hsprAQ'),
    (200014, 'The Departed', 'Martin Scorsese', '2006-10-06', 'Crime, Drama, Thriller', 'https://www.youtube.com/watch?v=r-MiSNsCdQ4'),
    (200015, 'Schindlers List', 'Steven Spielberg', '1993-12-15', 'Biography, Drama, History', 'https://www.youtube.com/watch?v=mxphAlJID9U'),
    (200016, 'Inglourious Basterds', 'Quentin Tarantino', '2009-08-21', 'Adventure, Drama, War', 'https://www.youtube.com/watch?v=KnrRy6kSFF0'),
    (200017, 'The Lord of the Rings: The Two Towers', 'Peter Jackson', '2002-12-18', 'Adventure, Drama, Fantasy', 'https://www.youtube.com/watch?v=LbfMDwc4azU'),
    (200018, 'The Green Mile', 'Frank Darabont', '1999-12-10', 'Crime, Drama, Fantasy', 'https://www.youtube.com/watch?v=Ki4haFrqSrw'),
    (200019, 'The Dark Knight Rises', 'Christopher Nolan', '2012-07-20', 'Action, Thriller', 'https://www.youtube.com/watch?v=z5Humz3ONgk'),
    (200020, 'Se7en', 'David Fincher', '1995-09-22', 'Crime, Drama, Mystery', 'https://www.youtube.com/watch?v=SpKbZ_3zlb0'),
    (200021, 'Gladiator', 'Ridley Scott', '2000-05-05', 'Action, Adventure, Drama', 'https://www.youtube.com/watch?v=P5ieIbInFpg'),
    (200022, 'The Godfather: Part II', 'Francis Ford Coppola', '1974-12-20', 'Crime, Drama', 'https://www.youtube.com/watch?v=Lxp4c0hqu9w'),
    (200023, 'Saving Private Ryan', 'Steven Spielberg', '1998-07-24', 'Drama, War', 'https://www.youtube.com/watch?v=9CiW_DgxCnQ'),
    (200024, 'The Prestige', 'Christopher Nolan', '2006-10-20', 'Drama, Mystery, Sci-Fi', 'https://www.youtube.com/watch?v=ObGVA1WOqyE'),
    (200025, 'The Shawshank Redemption', 'Frank Darabont', '1994-10-14', 'Drama', 'https://www.youtube.com/watch?v=PLl99DlL6b4'), -- duplicate of 200003
    (200026, 'The Usual Suspects', 'Bryan Singer', '1995-09-15', 'Crime, Mystery, Thriller', 'https://www.youtube.com/watch?v=x3t0Nc6fg7w'),
    (200027, 'American History X', 'Tony Kaye', '1998-10-30', 'Drama', 'https://www.youtube.com/watch?v=XfQYHqsiN5g'),
    (200028, 'The Godfather: Part III', 'Francis Ford Coppola', '1990-12-25', 'Crime, Drama', 'https://www.youtube.com/watch?v=nWxDwvLhkDw'),
    (200029, 'The Sixth Sense', 'M. Night Shyamalan', '1999-08-06', 'Drama, Mystery, Thriller', 'https://www.youtube.com/watch?v=3-ZP95NF_Wk'),
    (200030, 'The Truman Show', 'Peter Weir', '1998-06-05', 'Comedy, Drama, Sci-Fi', 'https://www.youtube.com/watch?v=dlnmQbPGuls'),
    (200031, 'Whiplash', 'Damien Chazelle', '2014-10-10', 'Drama, Music', 'https://www.youtube.com/watch?v=7d_jQycdQGo'),
    (200032, '12 Angry Men', 'Sidney Lumet', '1957-04-11', 'Drama', 'https://www.youtube.com/watch?v=TEN-2uTi2c0'),
    (200033, 'The Big Lebowski', 'Joel Coen, Ethan Coen', '1998-03-06', 'Comedy, Crime', 'https://www.youtube.com/watch?v=cd-go0oBF4Y'),
    (200034, 'Blade Runner', 'Ridley Scott', '1982-06-25', 'Neo-Noir, Sci-Fi', 'https://www.youtube.com/watch?v=eogpIG53Cis'),
    (200035, 'Spirited Away', 'Hayao Miyazaki', '2001-07-20', 'Animation, Adventure, Family', 'https://www.youtube.com/watch?v=ByXuk9QqQkk'),
    (200036, 'Parasite', 'Bong Joon-ho', '2019-05-30', 'Black Comedy, Crime, Thriller', 'https://www.youtube.com/watch?v=5xH0HfJHsaY'),
    (200037, 'Good Will Hunting', 'Gus Van Sant', '1997-12-10', 'Drama', 'https://www.youtube.com/watch?v=ReIJ1lbL-Q8'),
    (200038, 'The Princess Bride', 'Rob Reiner', '1987-09-25', 'Adventure, Comedy, Fantasy', 'https://www.youtube.com/watch?v=WNNUcHRiPS8'),
    (200039, 'The Shining', 'Stanley Kubrick', '1980-05-23', 'Horror, Mystery, Psychological', 'https://www.youtube.com/watch?v=S014oGZiSdI'),
    (200040, 'Raiders of the Lost Ark', 'Steven Spielberg', '1981-06-12', 'Action, Adventure', 'https://www.youtube.com/watch?v=0xQSIdSRlAk'),
    (200041, 'The Grand Budapest Hotel', 'Wes Anderson', '2014-02-21', 'Comedy, Crime', 'https://www.youtube.com/watch?v=1Fg5iWmQjwk'),
    (200042, 'Kill Bill: Vol. 1', 'Quentin Tarantino', '2003-10-10', 'Action, Crime', 'https://www.youtube.com/watch?v=7kSuas6mRpk'),
    (200043, 'Casablanca', 'Michael Curtiz', '1942-01-23', 'Drama, Romance, War', 'https://www.youtube.com/watch?v=MF7JH_54d8c'),
    (200044, '2001: A Space Odyssey', 'Stanley Kubrick', '1968-04-02', 'Sci-Fi', 'https://www.youtube.com/watch?v=oR_e9y-bka0'),
    (200045, 'The Breakfast Club', 'John Hughes', '1985-02-15', 'Comedy, Drama', 'https://www.youtube.com/watch?v=kGuWbVb1210'),
    (200046, 'The Thing', 'John Carpenter', '1982-06-25', 'Horror, Sci-Fi', 'https://www.youtube.com/watch?v=Txjm94GnrPA'),
    (200047, 'Back to the Future', 'Robert Zemeckis', '1985-07-03', 'Adventure, Comedy, Sci-Fi', 'https://www.youtube.com/watch?v=qvsgGtivCgs'),
    (200048, 'The Big Lebowski', 'Joel Coen, Ethan Coen', '1998-03-06', 'Comedy, Crime', 'https://www.youtube.com/watch?v=cd-go0oBF4Y'),  -- Duplicate entry for demonstration purposes
    (200049, 'The Big Lebowski (Special Edition)', 'Joel Coen, Ethan Coen', '1998-03-06', 'Comedy, Crime', 'https://www.youtube.com/watch?v=Q3l1cC7SRHs'),  -- Variation to show handling duplicates
    (200050, 'Inception (Directors Cut)', 'Christopher Nolan', '2010-07-16', 'Action, Sci-Fi, Thriller', 'https://www.youtube.com/watch?v=YoHD9XEInc0'),  -- Variation to show handling duplicates
    (200051, 'The Good, the Bad and the Ugly', 'Sergio Leone', '1966-12-16', 'Western', 'https://www.youtube.com/watch?v=IFNUGzCOQoI'),
    (200052, 'Seven Samurai', 'Akira Kurosawa', '1954-04-26', 'Drama, Historical, War', 'https://www.youtube.com/watch?v=wJ1TOratCTo');
    
   
INSERT INTO Award (awardID, movieID, personID, winnername, year, category, genre)
VALUES
    (300001, 200001, 100002, 'Leonardo DiCaprio', '2011-01-01', 'Best Actor', 'Action, Sci-Fi, Thriller'),
    (300002, 200002, 100003, 'Meryl Streep', '1998-01-01', 'Best Actress', 'Drama, Romance'),
    (300003, 200001, NULL, 'Inception', '2011-01-01', 'Best Picture', 'Action, Sci-Fi, Thriller'),
    (300004, 200002, NULL, 'Titanic', '1998-01-01', 'Best Picture', 'Drama, Romance'),
    (300005, 200003, NULL, 'The Shawshank Redemption', '1995-01-01', 'Best Picture', 'Drama'),
    (300006, 200004, NULL, 'The Godfather', '1973-01-01', 'Best Picture', 'Crime, Drama'),
    (300007, 200005, NULL, 'The Dark Knight', '2009-01-01', 'Best Picture', 'Action, Crime, Drama'),
    (300008, 200006, NULL, 'Pulp Fiction', '1995-01-01', 'Best Picture', 'Crime, Drama'),
    (300009, 200007, NULL, 'Forrest Gump', '1995-01-01', 'Best Picture', 'Drama, Romance'),
    (300010, 200008, NULL, 'The Lord of the Rings: The Return of the King', '2004-01-01', 'Best Picture', 'Adventure, Drama, Fantasy'),
    (300011, 200009, NULL, 'Fight Club', '2000-01-01', 'Best Picture', 'Drama'),
    (300012, 200010, NULL, 'The Matrix', '2000-01-01', 'Best Visual Effects', 'Action, Sci-Fi'),
    (300013, 200011, NULL, 'Goodfellas', '1991-01-01', 'Best Picture', 'Biography, Crime, Drama'),
    (300014, 200012, NULL, 'The Lord of the Rings: The Fellowship of the Ring', '2002-01-01', 'Best Picture', 'Adventure, Drama, Fantasy'),
    (300015, 200013, NULL, 'The Silence of the Lambs', '1992-01-01', 'Best Picture', 'Crime, Drama, Thriller'),
    (300016, 200014, NULL, 'The Departed', '2007-01-01', 'Best Picture', 'Crime, Drama, Thriller'),
    (300017, 200015, NULL, 'Schindler''s List', '1994-01-01', 'Best Picture', 'Biography, Drama, History'),
    (300018, 200016, NULL, 'Inglourious Basterds', '2010-01-01', 'Best Picture', 'Adventure, Drama, War'),
    (300019, 200017, NULL, 'The Lord of the Rings: The Two Towers', '2003-01-01', 'Best Picture', 'Adventure, Drama, Fantasy'),
    (300020, 200018, NULL, 'The Green Mile', '2000-01-01', 'Best Picture', 'Crime, Drama, Fantasy'),
    (300021, 200019, NULL, 'The Dark Knight Rises', '2013-01-01', 'Best Picture', 'Action, Thriller'),
    (300022, 200020, NULL, 'Se7en', '1996-01-01', 'Best Picture', 'Crime, Drama, Mystery'),
    (300023, 200021, NULL, 'Gladiator', '2001-01-01', 'Best Picture', 'Action, Adventure, Drama'),
    (300024, 200022, NULL, 'The Godfather: Part II', '1975-01-01', 'Best Picture', 'Crime, Drama'),
    (300025, 200023, NULL, 'Saving Private Ryan', '1999-01-01', 'Best Picture', 'Drama, War'),
    (300026, 200024, NULL, 'The Prestige', '2007-01-01', 'Best Picture', 'Drama, Mystery, Sci-Fi'),
    (300027, 200025, NULL, 'The Shawshank Redemption', '1995-01-01', 'Best Picture', 'Drama'),
    (300028, 200026, NULL, 'The Usual Suspects', '1996-01-01', 'Best Picture', 'Crime, Mystery, Thriller'),
    (300029, 200001, NULL, 'Inception', '2011-01-01', 'Best Visual Effects', 'Action, Sci-Fi, Thriller'),
    (300030, 200010, NULL, 'The Matrix', '2000-01-01', 'Best Visual Effects', 'Action, Sci-Fi'),
    (300031, 200007, 100004, 'Tom Hanks', '1995-01-01', 'Best Actor', 'Drama, Romance'),
    (300032, 200021, 100007, 'Brad Pitt', '2001-01-01', 'Best Supporting Actor', 'Action, Adventure, Drama'),
    (300033, 200015, 100001, 'Steven Spielberg', '1994-01-01', 'Best Director', 'Biography, Drama, History'),
    (300034, 200020, 100008, 'Angelina Jolie', '1996-01-01', 'Best Actress', 'Crime, Drama, Mystery'),
    (300035, 200006, 100009, 'Quentin Tarantino', '1995-01-01', 'Best Director', 'Crime, Drama'),
    (300036, 200019, 100006, 'Emma Watson', '2014-01-01', 'Best Supporting Actress', 'Action, Thriller'),
    (300037, 200015, 100015, 'Alfred Hitchcock', '1994-01-01', 'Best Director', 'Biography, Drama, History'),
    (300038, 200008, 100010, 'Natalie Portman', '2004-01-01', 'Best Actress', 'Adventure, Drama, Fantasy'),
    (300039, 200011, 100011, 'Johnny Depp', '1992-01-01', 'Best Actor', 'Biography, Crime, Drama'),
    (300040, 200014, 100012, 'Martin Scorsese', '2007-01-01', 'Best Director', 'Crime, Drama, Thriller'),
    (300041, 200001, 100013, 'Scarlett Johansson', '2011-01-01', 'Best Actress', 'Action, Sci-Fi, Thriller'),
    (300042, 200020, 100014, 'Bradley Cooper', '1996-01-01', 'Best Actor', 'Crime, Drama, Mystery'),
    (300043, 200026, 100016, 'Jennifer Lawrence', '1997-01-01', 'Best Actress', 'Crime, Drama, Mystery'),
    (300044, 200024, 100018, 'Emma Stone', '2007-01-01', 'Best Actress', 'Drama, Mystery, Sci-Fi'),
    (300045, 200004, 100019, 'Robert De Niro', '1973-01-01', 'Best Actor', 'Crime, Drama'),
    (300046, 200022, 100021, 'Cate Blanchett', '1975-01-01', 'Best Actress', 'Crime, Drama'),
    (300047, 200027, 100022, 'George Clooney', '1999-01-01', 'Best Actor', 'Drama'),
    (300048, 200002, 100023, 'James Cameron', '1998-01-01', 'Best Director', 'Drama, Romance'),
    (300049, 200027, 100024, 'Charlize Theron', '1999-01-01', 'Best Actress', 'Drama'),
    (300050, 200010, 100025, 'Tim Burton', '2000-01-01', 'Best Director', 'Action, Sci-Fi');
	
   
-- Populate Rates table (assuming some user rates some movies)
INSERT INTO Rates (movieID, useremail, score, review) 
VALUES 
    (200001, 'johndoe@gmail.com', 5, 'Mind-blowing!'),
    (200001, 'janesmith@hotmail.com', 4, 'Stunning!'),
    (200003, 'michaeljohnson@yahoo.com', 5, NULL),
    (200003, 'alicejohnson@gmail.com', 5, 'Brilliant!'),
    (200004, 'bobsmith@hotmail.com', 4, 'Awesome!'),
    (200004, 'emilydavis@yahoo.com', 5, NULL),
    (200005, 'oliviaanderson@gmail.com', 5, 'Iconic!'),
    (200005, 'williamtaylor@hotmail.com', 4, 'Wonderful!'),
    (200007, 'sophiathomas@yahoo.com', 5, 'Epic!'),
    (200007, 'benjaminhernandez@gmail.com', 4, 'Fantastic!'),
    (200018, 'avamoore@hotmail.com', 1, NULL),
    (200018, 'masongarcia@yahoo.com', 4, 'Impressive!'),
    (200009, 'charlotteyoung@gmail.com', 5, 'Spectacular!'),
    (200009, 'johndoe@gmail.com', 2, NULL),
    (200010, 'janesmith@hotmail.com', 5, 'Excellent!'),
    (200001, 'michaeljohnson@yahoo.com', 4, 'Phenomenal!'),
    (200011, 'alicejohnson@gmail.com', 5, NULL),
    (200011, 'bobsmith@hotmail.com', 4, 'Gripping!'),
    (200012, 'emilydavis@yahoo.com', 5, 'Terrific!'),
    (200012, 'oliviaanderson@gmail.com', 4, NULL),
    (200013, 'williamtaylor@hotmail.com', 5, 'Awe-inspiring!'),
    (200013, 'sophiathomas@yahoo.com', 4, 'Brilliant!'),
    (200015, 'benjaminhernandez@gmail.com', 5, NULL),
    (200015, 'avamoore@hotmail.com', 4, 'Iconic!'),
    (200003, 'masongarcia@yahoo.com', 5, 'Awesome!'),
    (200003, 'charlotteyoung@gmail.com', 4, 'Brilliant!'),
    (200018, 'johndoe@gmail.com', 5, NULL),
    (200018, 'janesmith@hotmail.com', 4, 'Wonderful!'),
    (200021, 'michaeljohnson@yahoo.com', 5, 'Epic!'),
    (200021, 'alicejohnson@gmail.com', 2, NULL),
    (200024, 'bobsmith@hotmail.com', 5, 'Impressive!'),
    (200024, 'emilydavis@yahoo.com', 4, 'Spectacular!'),
    (200026, 'oliviaanderson@gmail.com', 5, NULL),
    (200026, 'williamtaylor@hotmail.com', 4, 'Phenomenal!'),
    (200009, 'sophiathomas@yahoo.com', 5, 'Superb!'),
    (200001, 'benjaminhernandez@gmail.com', 4, 'Gripping!');
	

-- Populate Watchlist table
INSERT INTO Watchlist (watchlistID, useremail, movielist) 
VALUES 
    (400001, 'johndoe@gmail.com', '{200001, 200002, 200003}'),
    (400002, 'janesmith@hotmail.com', '{200004, 200005}'),
    (400003, 'michaeljohnson@yahoo.com', '{200006, 200007}'),
    (400004, 'alicejohnson@gmail.com', '{200008, 200009, 200010}'),
    (400005, 'bobsmith@hotmail.com', '{200011}'),
    (400006, 'emilydavis@yahoo.com', '{200012, 200013, 200014}'),
    (400007, 'davidbrown@gmail.com', '{200015}'),
    (400008, 'emmawilson@hotmail.com', '{200016, 200017}'),
    (400009, 'jamesmartinez@yahoo.com', '{200018, 200019}'),
    (400010, 'oliviaanderson@gmail.com', '{200020, 200021, 200022}'),
    (400011, 'williamtaylor@hotmail.com', '{200023, 200024}'),
    (400012, 'sophiathomas@yahoo.com', '{200025}'),
    (400013, 'benjaminhernandez@gmail.com', '{200026, 200027, 200028}'),
    (400014, 'avamoore@hotmail.com', '{200029}'),
    (400015, 'masongarcia@yahoo.com', '{200030, 200031}'),
    (400016, 'charlotteyoung@gmail.com', '{200032, 200033}'),
    (400017, 'ethanking@hotmail.com', '{200034, 200035, 200036}'),
    (400018, 'ameliascott@yahoo.com', '{200037}'),
    (400019, 'alexanderrivera@gmail.com', '{200038, 200039}'),
    (400020, 'harpergreen@hotmail.com', '{200040, 200041}'),
    (400021, 'michaell@yahoo.com', '{200042, 200043, 200044}'),
    (400022, 'evelynadams@gmail.com', '{200045}'),
    (400023, 'danielbaker@hotmail.com', '{200046, 200047}'),
    (400024, 'abigailgonzalez@yahoo.com', '{200048, 200049}'),
    (400025, 'matthewnelson@gmail.com', '{200050, 200051}'),
    (400026, 'samanthacarter@hotmail.com', '{200052}'),
    (400027, 'davidmitchell@yahoo.com', '{200001, 200002, 200003}'),
    (400028, 'lillianperez@gmail.com', '{200004, 200005}'),
    (400029, 'lucasroberts@hotmail.com', '{200006, 200007}'),
    (400030, 'averyhill@yahoo.com', '{200008, 200009, 200010}'),
    (400031, 'johndoe@gmail.com', '{200011}'),
    (400032, 'janesmith@hotmail.com', '{200012, 200013, 200014}'),
    (400033, 'michaeljohnson@yahoo.com', '{200015}'),
    (400034, 'alicejohnson@gmail.com', '{200016, 200017}'),
    (400035, 'bobsmith@hotmail.com', '{200018, 200019}'),
    (400036, 'emilydavis@yahoo.com', '{200020, 200021, 200022}'),
    (400037, 'davidbrown@gmail.com', '{200023, 200024}'),
    (400038, 'emmawilson@hotmail.com', '{200025}'),
    (400039, 'jamesmartinez@yahoo.com', '{200026, 200027, 200028}'),
    (400040, 'oliviaanderson@gmail.com', '{200029}');


-- Populate Belongs table (assigning movies to watchlists)
INSERT INTO Belongs (watchlistID, movieID) 
VALUES
    (400001, 200001),
    (400001, 200002),
    (400001, 200003),
    (400002, 200004),
    (400002, 200005),
    (400003, 200006),
    (400003, 200007),
    (400004, 200008),
    (400004, 200009),
    (400004, 200010),
    (400005, 200011),
    (400006, 200012),
    (400006, 200013),
    (400006, 200014),
    (400007, 200015),
    (400008, 200016),
    (400008, 200017),
    (400009, 200018),
    (400009, 200019),
    (400010, 200020),
    (400010, 200021),
    (400010, 200022),
    (400011, 200023),
    (400011, 200024),
    (400012, 200025),
    (400013, 200026),
    (400013, 200027),
    (400013, 200028),
    (400014, 200029),
    (400015, 200030),
    (400015, 200031),
    (400016, 200032),
    (400016, 200033),
    (400017, 200034),
    (400017, 200035),
    (400017, 200036),
    (400018, 200037),
    (400019, 200038),
    (400019, 200039),
    (400020, 200040),
    (400020, 200041),
    (400021, 200042),
    (400021, 200043),
    (400021, 200044),
    (400022, 200045),
    (400023, 200046),
    (400023, 200047),
    (400024, 200048),
    (400024, 200049),
    (400025, 200050),
    (400025, 200051),
    (400026, 200052);
	

-- Populate Participates table (assigning persons to movies)
INSERT INTO Participates (movieID, personID, role)
VALUES
    (200021, 100027, 'Director'), -- Ridley Scott directed Gladiator
    (200021, 100007, 'Actor'), -- Brad Pitt acted in Gladiator
    (200022, 100004, 'Director'), -- Francis Ford Coppola directed The Godfather: Part II
    (200022, 100019, 'Actor'), -- Robert De Niro acted in The Godfather: Part II
    (200023, 100015, 'Director'), -- Steven Spielberg directed Saving Private Ryan
    (200023, 100004, 'Actor'), -- Tom Hanks acted in Saving Private Ryan
    (200024, 100005, 'Director'), -- Christopher Nolan directed The Prestige
    (200024, 100002, 'Actor'), -- Leonardo DiCaprio acted in The Prestige
    (200025, 100007, 'Director'), -- Robert Zemeckis directed The Shawshank Redemption
    (200025, 100004, 'Actor'), -- Tom Hanks acted in The Shawshank Redemption
    (200026, 100027, 'Director'), -- Bryan Singer directed The Usual Suspects
    (200026, 100011, 'Actor'), -- Johnny Depp acted in The Usual Suspects
    (200027, 100028, 'Director'), -- Tony Kaye directed American History X
    (200027, 100024, 'Actor'), -- Charlize Theron acted in American History X
    (200028, 100027, 'Director'), -- Francis Ford Coppola directed The Godfather: Part III
    (200028, 100019, 'Actor'), -- Robert De Niro acted in The Godfather: Part III
    (200029, 100029, 'Director'), -- M. Night Shyamalan directed The Sixth Sense
    (200029, 100026, 'Actor'), -- Nicole Kidman acted in The Sixth Sense
    (200030, 100030, 'Director'), -- Peter Weir directed The Truman Show
    (200030, 100028, 'Actor'); -- Julia Roberts acted in The Truman Show