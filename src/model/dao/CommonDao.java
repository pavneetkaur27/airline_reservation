package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CommonDao {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public int getLastInsertId() {
        try {
            String query = " select last_insert_id() ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            int result=0;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result=rs.getInt(1);
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return 0;
        }
    }
}
