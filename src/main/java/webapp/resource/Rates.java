/*
 * Copyright 2018-2023 University of Padua, Italy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package webapp.resource;

/**
 * Represents the data about a rating.
 * @author Kejsi Bimaj
 * @version 1.00
 * @since 1.00
 */
public class Rates {

    /**
     * The ID of the movie being rated.
     */
    private final int movieId;
    /**
     * The username of the user who gave the rating.
     */
    private final String useremail;
    /**
     * The rating given by the user.
     */
    private final int score;

    /**
     * The review given by the user.
     */
    private final String review;


    /**
     * Creates a new rating.
     *
     * @param movieId the ID of the movie.
     * @param useremail the useremail of the user.
     * @param score the rating given by the user.
     * @param review the review given by the user.
     */
    public Rates(final int movieId, final String useremail, final int score, final String review) {
        this.movieId = movieId;
        this.useremail = useremail;
        this.score = score;
        this.review = review;
    }

    /**
     * Returns the username of the user who gave the rating.
     *
     * @return the username of the user.
     */
    public final String getUseremail() {
        return useremail;
    }

    /**
     * Returns the ID of the movie being rated.
     *
     * @return the ID of the movie.
     */
    public final int getMovieId() {
        return movieId;
    }

    /**
     * Returns the rating given by the user.
     *
     * @return the rating given by the user.
     */
    public final int getScore() {
        return score;
    }

    /**
     * Returns the review given by the user.
     *
     * @return the review given by the user.
     */
    public final String getReview() {
        return review;
    }
}