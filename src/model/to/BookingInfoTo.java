package model.to;

import java.sql.Date;

public class BookingInfoTo {

    private int bookingid;
    private String customername;
    private String contactno;
    private int flightid;
    private Date bookingdate;
    private Date journeydate;
    private int totalnumber;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    public Date getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(Date bookingdate) {
        this.bookingdate = bookingdate;
    }

    public Date getJourneydate() {
        return journeydate;
    }

    public void setJourneydate(Date journeydate) {
        this.journeydate = journeydate;
    }

    public int getTotalnumber() {
        return totalnumber;
    }

    public void setTotalnumber(int totalnumber) {
        this.totalnumber = totalnumber;
    }

    @Override
    public String toString() {
        return customername+"["+String.valueOf(bookingid)+"]";
    }
}
