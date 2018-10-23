package model.to;

public class CountryInfoTo {
    private String countryid;
    private String countryname;

    public String getCountryid() {
        return countryid;
    }

    public void setCountryid(String countryid) {
        this.countryid = countryid;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
    public String toString()
    {
        return countryname +"["+countryid+"]";
    }
}
