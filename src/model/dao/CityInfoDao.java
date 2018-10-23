package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.CityInfoTo;

public class CityInfoDao {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(CityInfoTo record) {
        try {
            String query = " insert into cityinfo ( cityid , cityname ,countryid) values(?,?,?) ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCityid());
            stmt.setString(2, record.getCityname());
            stmt.setString(3, record.getCountryid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(CityInfoTo record) {
        try {
            String query = " update cityinfo set  cityname=? , countryid=? where cityid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCityname());
            stmt.setString(2, record.getCountryid());
            stmt.setString(3, record.getCityid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String cityid) {
        try {
            String query = " delete from cityinfo where cityid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, cityid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public CityInfoTo getRecord(String cityid) {
        try {
            String query = "select cityid ,cityname ,countryid  from cityinfo where cityid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, cityid);
            CityInfoTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new CityInfoTo();
                result.setCityid(rs.getString("cityid"));
                result.setCityname(rs.getString("cityname"));
                result.setCountryid(rs.getString("countryid"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<CityInfoTo> getAllRecord() {
        try {
            String query = " select cityname, cityid,ci.countryid,countryname from cityinfo ci";
            query += " join countryinfo c on ci.countryid=c.countryid";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<CityInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<CityInfoTo>();
                do {
                    CityInfoTo record = new CityInfoTo();
                    record.setCityid(rs.getString("cityid"));
                    record.setCityname(rs.getString("cityname"));
                    record.setCountryid(rs.getString("countryid"));
                    record.setCountryname(rs.getString("countryname"));
                    result.add(record);
                } while (rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            errormessage = ex.toString();
            return null;
        }
    }

    public List<CityInfoTo> getAllRecord(String countryid) {
        try {
            String query = " select cityname, cityid,countryid from cityinfo  where countryid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, countryid);
            List<CityInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<CityInfoTo>();
                do {
                    CityInfoTo record = new CityInfoTo();
                    record.setCityid(rs.getString("cityid"));
                    record.setCityname(rs.getString("cityname"));
                    record.setCountryid(rs.getString("countryid"));
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
    public List<CityInfoTo> getDestCity(String cityid,String countryid) {
        try {
            String query = " select cityname, cityid,countryid from cityinfo  where  not cityid=? and countryid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, cityid);
            stmt.setString(2, countryid);
            List<CityInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<CityInfoTo>();
                do {
                    CityInfoTo record = new CityInfoTo();
                    record.setCityid(rs.getString("cityid"));
                    record.setCityname(rs.getString("cityname"));
                    record.setCountryid(rs.getString("countryid"));
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
    
    public List<CityInfoTo> getDestinationCity(String cityid) {
        try {
            String query = " select cityname, cityid,countryid from cityinfo  where  not cityid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, cityid);
            List<CityInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<CityInfoTo>();
                do {
                    CityInfoTo record = new CityInfoTo();
                    record.setCityid(rs.getString("cityid"));
                    record.setCityname(rs.getString("cityname"));
                    record.setCountryid(rs.getString("countryid"));
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
