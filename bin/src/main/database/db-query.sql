-- Query to find the average rating of a movie
SELECT movieId, AVG(rating) AS average_rating
FROM movie.Rating
WHERE movieId='1003'
GROUP BY movieId;
