package webapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import webapp.resource.Award;
public class AwardDAO extends AbstractDAO<List<Award>> {

    public AwardDAO(Connection con) {
        super(con);
    }

    @Override
    protected void doAccess() throws SQLException {
        List<Award> awards = new ArrayList<>();
        PreparedStatement ps = null;
	ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT awardid, winnername, year, category, genre FROM award limit 10");
            rs = ps.executeQuery();
                while (rs.next()) {
                    Award award = new Award(rs.getInt("awardid"),
                                        0, 0, rs.getString("category"),
                                        new java.util.Date(rs.getDate("year").getTime()),
                                        rs.getString("winnername"),
					rs.getString("genre"));              
                    awards.add(award);
                }
        } finally {
			if (rs != null) {
				rs.close();
			}
	
			if (ps != null) {
                            ps.close();
			}

		} 
        outputParam = awards;
    }
}
