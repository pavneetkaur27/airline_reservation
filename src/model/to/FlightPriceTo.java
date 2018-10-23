package model.to;

public class FlightPriceTo {
    private int srno;
    private String categoryid;
    private int flightid;
    private float price;
    private float discount;
    private int totalseat;
    private String categoryname;

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
    public int getSrno() {
        return srno;
    }

    public void setSrno(int srno) {
        this.srno = srno;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getTotalseat() {
        return totalseat;
    }

    public void setTotalseat(int totalseat) {
        this.totalseat = totalseat;
    }
    
    public String toString()
    {
        return categoryname+"["+categoryid+"]";
    }
}
