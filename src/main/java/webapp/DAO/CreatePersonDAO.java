/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webapp.DAO;
import webapp.resource.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Vladislav Tikhonov
 */
public class CreatePersonDAO extends AbstractDAO {
    
    private static final String STATEMENT = 
            "INSERT INTO Person (name, surname, shortBio, birthplace, birthdate, photolink, role) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING personid;";
    
    private final Person person;
    
    public CreatePersonDAO(final Connection con, final Person person) {
        super(con);

        if (person == null) {
            LOGGER.error("The person cannot be null.");
            throw new NullPointerException("The person cannot be null.");
        }

        this.person = person;
    }
    
    @Override
    protected final void doAccess() throws SQLException {

        PreparedStatement pstmt = null;
        int personid = -1;

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getSurname());
            pstmt.setString(3, person.getShortBio());
            pstmt.setString(4, person.getBirthplace());
            pstmt.setDate(5, person.getBirthdate());
            pstmt.setString(6, person.getPhotolink());
            pstmt.setString(7, person.getRole());

            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){

                personid = rs.getInt("personid");
                        }

            LOGGER.info("Person %d successfully stored in the database.", person.getName(), person.getSurname());
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
        this.outputParam = personid;

    }
    
}
