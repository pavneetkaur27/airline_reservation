package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.CountryInfoTo;

public class CountryInfoDao {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(CountryInfoTo record) {
        try {
            String query = " insert into countryinfo ( countryid,countryname) values(?,?) ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCountryid());
            stmt.setString(2, record.getCountryname());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(CountryInfoTo record) {
        try {
            String query = " update countryinfo set countryname=? where countryid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCountryname());
            stmt.setString(2, record.getCountryid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;

        }
    }

    public boolean deleteRecord(String countryid) {
        try {
            String query = " delete from countryinfo where countryid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, countryid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public CountryInfoTo getRecord(String countryid) {
        try {
            String query = "select countryid ,countryname from countryinfo where countryid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, countryid);
            CountryInfoTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new CountryInfoTo();
                result.setCountryid(rs.getString("countryid"));
                result.setCountryname(rs.getString("countryname"));

            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<CountryInfoTo> getAllRecord() {
        try {
            String query = " select countryname, countryid from countryinfo";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<CountryInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<CountryInfoTo>();
                do {
                    CountryInfoTo record = new CountryInfoTo();
                    record.setCountryid(rs.getString("countryid"));
                    record.setCountryname(rs.getString("countryname"));
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
    public List<CountryInfoTo> getAllRecord(String countryid) {
        try {
            String query = " select countryname, countryid from countryinfo where not countryid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1,countryid);
            List<CountryInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<CountryInfoTo>();
                do {
                    CountryInfoTo record = new CountryInfoTo();
                    record.setCountryid(rs.getString("countryid"));
                    record.setCountryname(rs.getString("countryname"));
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
