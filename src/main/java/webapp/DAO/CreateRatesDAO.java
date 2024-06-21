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

package webapp.DAO;

import webapp.resource.Rates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new rate into the database.
 * @author Kejsi Bimaj
 * @version 1.00
 * @since 1.00
 */
public final class CreateRatesDAO extends AbstractDAO {

    /**
     * The SQL statement to be executed
     */
    private static final String STATEMENT = "INSERT INTO Rates (useremail, movieId, score, review) VALUES (?, ?, ?, ?)";

    /**
     /**
     * The employee to be stored into the database
     */
    private final Rates rates;

    /**
     * Creates a new object for storing an employee into the database.
     *
     * @param con
     *            the connection to the database.
     * @param rates
     *            the employee to be stored into the database.
     */
    public CreateRatesDAO(final Connection con, final Rates rates) {
        super(con);

        if (rates == null) {
            LOGGER.error("The rating cannot be null.");
            throw new NullPointerException("The rating cannot be null.");
        }

        this.rates = rates;
    }

    @Override
    protected final void doAccess() throws SQLException {

        PreparedStatement pstmt = null;

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, rates.getUseremail());
            pstmt.setInt(2, rates.getMovieId());
            pstmt.setInt(3, rates.getScore());
            pstmt.setString(4, rates.getReview());
            pstmt.execute();

            LOGGER.info("Rating %d successfully stored in the database.", rates.getMovieId(), rates.getUseremail());
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }

    }
}