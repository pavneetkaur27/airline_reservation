package model.to;

public class AirlineInfoTo {
    private String airlineid;
    private String airlinename;

    public String getAirlineid() {
        return airlineid;
    }

    public void setAirlineid(String airlineid) {
        this.airlineid = airlineid;
    }

    public String getAirlinename() {
        return airlinename;
    }

    public void setAirlinename(String airlinename) {
        this.airlinename = airlinename;
    }
    
    public String toString()
    {
        return airlinename +"["+airlineid+"]";
    }
}
