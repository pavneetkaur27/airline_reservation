package model.to;

import java.sql.Time;

public class FlightInfoTo {

    private int flightid;
    private String airlineid;
    private String countryid;
    private String sourcecityid;
    private String destinationcityid;
    private String flighttype;
    private Time departuretime;
    private int journeyminute;
    private String airlinename;
    private String countryname;
    private String sourcecityname;
    private String destinationcityname;

    public String getAirlinename() {
        return airlinename;
    }

    public void setAirlinename(String airlinename) {
        this.airlinename = airlinename;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getSourcecityname() {
        return sourcecityname;
    }

    public void setSourcecityname(String sourcecityname) {
        this.sourcecityname = sourcecityname;
    }

    public String getDestinationcityname() {
        return destinationcityname;
    }

    public void setDestinationcityname(String destinationcityname) {
        this.destinationcityname = destinationcityname;
    }
    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    public String getAirlineid() {
        return airlineid;
    }

    public void setAirlineid(String airlineid) {
        this.airlineid = airlineid;
    }

    public String getCountryid() {
        return countryid;
    }

    public void setCountryid(String countryid) {
        this.countryid = countryid;
    }

    public String getSourcecityid() {
        return sourcecityid;
    }

    public void setSourcecityid(String sourcecityid) {
        this.sourcecityid = sourcecityid;
    }

    public String getDestinationcityid() {
        return destinationcityid;
    }

    public void setDestinationcityid(String destinationcityid) {
        this.destinationcityid = destinationcityid;
    }

    public String getFlighttype() {
        return flighttype;
    }

    public void setFlighttype(String flighttype) {
        this.flighttype = flighttype;
    }

    public Time getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Time departuretime) {
        this.departuretime = departuretime;
    }

    public int getJourneyminute() {
        return journeyminute;
    }

    public void setJourneyminute(int journeyminute) {
        this.journeyminute = journeyminute;
    }

    public String toString() {
        return String.valueOf(flightid );
    }
}
