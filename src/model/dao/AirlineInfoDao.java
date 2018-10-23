package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.AirlineInfoTo;

public class AirlineInfoDao {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }
    
    public boolean insertRecord(AirlineInfoTo record) {
        try {
            String query = " insert into airlineinfo ( airlineid,airlinename) values(?,?) ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getAirlineid());
            stmt.setString(2, record.getAirlinename());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(AirlineInfoTo record) {
        try {
            String query = " update airlineinfo set airlinename=? where airlineid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getAirlinename());
            stmt.setString(2, record.getAirlineid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;

        }
    }

    public boolean deleteRecord(String airlineid) {
        try {
            String query = " delete from airlineinfo where airlineid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, airlineid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public AirlineInfoTo getRecord(String airlineid) {
        try {
            String query = "select airlineid ,airliename from airlineinfo where airlineid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, airlineid);
            AirlineInfoTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result =new AirlineInfoTo();
                result.setAirlineid(rs.getString("airlineid"));
                result.setAirlinename(rs.getString("airlinename"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<AirlineInfoTo> getAllRecord() {
        try {
            String query = " select airlinename, airlineid from airlineinfo";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<AirlineInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<AirlineInfoTo>();
                do {
                    AirlineInfoTo record = new AirlineInfoTo();
                    record.setAirlineid(rs.getString("airlineid"));
                    record.setAirlinename(rs.getString("airlinename"));
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
