package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.LoginInfoTo;

public class LoginInfoDao {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }
   
    public boolean insertRecord(LoginInfoTo record) {
        try {
            String query = "insert into logininfo (username,password,rolename,lastlogin) values (?,?,?,null) ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getUsername());
            stmt.setString(2, record.getPassword());
            stmt.setString(3, record.getRolename());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;

        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(LoginInfoTo record) {
        try {
            String query = " update logininfo set password=?,rolename=?,lastlogin=?  where username=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getPassword());
            stmt.setString(2, record.getRolename());
            stmt.setTimestamp(3, record.getLastlogin());
            stmt.setString(4, record.getUsername());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;

        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String username) {
        try {
            String query = " delete from logininfo where username=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, username);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public LoginInfoTo getRecord(String username) {
        try {
            String query = " select username,password , rolename, lastlogin from logininfo where username=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, username);
            LoginInfoTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new LoginInfoTo();
                result.setUsername(rs.getString("username"));
                result.setPassword(rs.getString("password"));
                result.setRolename(rs.getString("rolename"));
                result.setLastlogin(rs.getTimestamp("lastlogin"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<LoginInfoTo> getAllRecord() {
        try {
            String query = " select username ,password ,rolename,lastlogin from logininfo";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<LoginInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<LoginInfoTo>();
                do {
                    LoginInfoTo record = new LoginInfoTo();
                    record.setUsername(rs.getString("username"));
                    record.setPassword(rs.getString("password"));
                    record.setRolename(rs.getString("rolename"));
                    record.setLastlogin(rs.getTimestamp("lastlogin"));
                    result.add(record);
                } while (rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }
}
