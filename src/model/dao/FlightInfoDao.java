package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.FlightInfoTo;

public class FlightInfoDao {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(FlightInfoTo record) {
        try {
            String query = " insert into flightinfo ";
            query += "(airlineid ,countryid,sourcecityid ,destinationcityid ,flighttype,departuretime,journeyminute )";
            query += " values(?,?,?,?,?,?,?) ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getAirlineid());
            stmt.setString(2, record.getCountryid());
            stmt.setString(3, record.getSourcecityid());
            stmt.setString(4, record.getDestinationcityid());
            stmt.setString(5, record.getFlighttype());
            stmt.setTime(6, record.getDeparturetime());
            stmt.setInt(7, record.getJourneyminute());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(FlightInfoTo record) {
        try {
            String query = " update flightinfo set airlineid=? ,countryid=?,sourcecityid=? ,";
            query += " destinationcityid =?,flighttype=?,departuretime=?,journeyminute=? ";
            query += " where flightid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getAirlineid());
            stmt.setString(2, record.getCountryid());
            stmt.setString(3, record.getSourcecityid());
            stmt.setString(4, record.getDestinationcityid());
            stmt.setString(5, record.getFlighttype());
            stmt.setTime(6, record.getDeparturetime());
            stmt.setInt(7, record.getJourneyminute());
            stmt.setInt(8, record.getFlightid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }

    }

    public boolean deleteRecord(int flightid) {
        try {
            String query = " delete from flightinfo where flightid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, flightid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public FlightInfoTo getRecord(int flightid) {
        try {
            String query = " select flightid ,airlineid , countryid,sourcecityid , destinationcityid , ";
            query += " flighttype ,departuretime ,journeyminute from flightinfo where";
            query += " flightid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, flightid);
            FlightInfoTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new FlightInfoTo();
                result.setFlightid(rs.getInt("flightid"));
                result.setAirlineid(rs.getString("airlineid"));
                result.setCountryid(rs.getString("countryid"));
                result.setSourcecityid(rs.getString("sourcecityid"));
                result.setDestinationcityid(rs.getString("destinationcityid"));
                result.setFlighttype(rs.getString("flighttype"));
                result.setDeparturetime(rs.getTime("departuretime"));
                result.setJourneyminute(rs.getInt("journeyminute"));
            }
            stmt.close();
            return result;

        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<FlightInfoTo> getAllRecord() {
        try {
            String query = " select flightid ,fi.airlineid, airlinename ,fi.countryid,countryname, ";
            query += " fi.sourcecityid ,ct.cityname, fi.destinationcityid ,cty.cityname, ";
            query += " flighttype ,departuretime ,journeyminute from flightinfo fi";
            query += " join airlineinfo ai on ";
            query += " fi.airlineid=ai.airlineid";
            query += " join countryinfo ci on ";
            query += " fi.countryid=ci.countryid";
            query += " join cityinfo ct on ";
            query += " fi.sourcecityid=ct.cityid";
            query += " join cityinfo cty on ";
            query += " fi.destinationcityid=cty.cityid";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<FlightInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<FlightInfoTo>();
                do {
                    FlightInfoTo record = new FlightInfoTo();
                    record.setFlightid(rs.getInt("flightid"));
                    record.setAirlineid(rs.getString("airlineid"));
                    record.setCountryid(rs.getString("countryid"));
                    record.setSourcecityid(rs.getString("sourcecityid"));
                    record.setDestinationcityid(rs.getString("destinationcityid"));
                    record.setFlighttype(rs.getString("flighttype"));
                    record.setDeparturetime(rs.getTime("departuretime"));
                    record.setJourneyminute(rs.getInt("journeyminute"));
                    record.setAirlinename(rs.getString("airlinename"));
                    record.setCountryname(rs.getString("countryname"));
                    record.setSourcecityname(rs.getString("ct.cityname"));
                    record.setDestinationcityname(rs.getString("cty.cityname"));
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

    public List<FlightInfoTo> getAllRecord(String sourcecityid, String destinationcityid) {
        try {
            String query = " select flightid ,fi.airlineid, airlinename ,fi.countryid,countryname, ";
            query += " fi.sourcecityid ,ct.cityname, fi.destinationcityid ,cty.cityname, ";
            query += " flighttype ,departuretime ,journeyminute from flightinfo fi";
            query += " join airlineinfo ai on ";
            query += " fi.airlineid=ai.airlineid";
            query += " join countryinfo ci on ";
            query += " fi.countryid=ci.countryid";
            query += " join cityinfo ct on ";
            query += " fi.sourcecityid=ct.cityid";
            query += " join cityinfo cty on ";
            query += " fi.destinationcityid=cty.cityid";
            query += " where fi.sourcecityid=? and fi.destinationcityid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, sourcecityid);
            stmt.setString(2, destinationcityid);
            List<FlightInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<FlightInfoTo>();
                do {
                    FlightInfoTo record = new FlightInfoTo();
                    record.setFlightid(rs.getInt("flightid"));
                    record.setAirlineid(rs.getString("airlineid"));
                    record.setCountryid(rs.getString("countryid"));
                    record.setSourcecityid(rs.getString("sourcecityid"));
                    record.setDestinationcityid(rs.getString("destinationcityid"));
                    record.setFlighttype(rs.getString("flighttype"));
                    record.setDeparturetime(rs.getTime("departuretime"));
                    record.setJourneyminute(rs.getInt("journeyminute"));
                    record.setAirlinename(rs.getString("airlinename"));
                    record.setCountryname(rs.getString("countryname"));
                    record.setSourcecityname(rs.getString("ct.cityname"));
                    record.setDestinationcityname(rs.getString("cty.cityname"));
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

    public List<FlightInfoTo> getFlightId(String sourcecityid,String destinationcityid) {
        try {
            String query = " select flightid  from flightinfo ";
            query += " where sourcecityid=? and destinationcityid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, sourcecityid);
            stmt.setString(2,destinationcityid);
            List<FlightInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<FlightInfoTo>();
                do {
                    FlightInfoTo record = new FlightInfoTo();
                    record.setFlightid(rs.getInt("flightid"));
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

}
