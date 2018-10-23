package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.BookingInfoTo;

public class BookingInfoDao {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(BookingInfoTo record) {
        try {
            String query = " insert into bookinginfo (customername ,contactno,flightid,bookingdate,journeydate,totalnumber) ";
            query += " values(?,?,?,sysdate(),?,?) ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCustomername());
            stmt.setString(2, record.getContactno());
            stmt.setInt(3, record.getFlightid());
            //stmt.setDate(4, record.getBookingdate());
            stmt.setDate(4, record.getJourneydate());
            stmt.setInt(5, record.getTotalnumber());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(BookingInfoTo record) {
        try {
            String query = " update bookinginfo set customername=? ,contactno=?,flightid=?,";
            query += "bookingdate=?,journeydate=?,totalnumber=? ";
            query += " where bookingid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCustomername());
            stmt.setString(2, record.getContactno());
            stmt.setInt(3, record.getFlightid());
            stmt.setDate(4, record.getBookingdate());
            stmt.setDate(5, record.getJourneydate());
            stmt.setInt(6, record.getTotalnumber());
            stmt.setInt(7, record.getBookingid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(int bookingid) {
        try {
            String query = " delete from bookinginfo where bookingid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, bookingid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public BookingInfoTo getRecord(int bookingid) {
        try {
            String query = " select bookingid,customername,contactno,flightid,bookingdate,journeydate,totalnumber ";
            query += "from bookinginfo where bookingid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, bookingid);
            BookingInfoTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new BookingInfoTo();
                result.setBookingid(rs.getInt("bookingid"));
                result.setCustomername(rs.getString("customername"));
                result.setContactno(rs.getString("contactno"));
                result.setFlightid(rs.getInt("flightid"));
                result.setBookingdate(rs.getDate("bookingdate"));
                result.setJourneydate(rs.getDate("journeydate"));
                result.setTotalnumber(rs.getInt("totalnumber"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<BookingInfoTo> getAllRecord() {
        try {
            String query = "select bookingid,customername,contactno,flightid,bookingdate,journeydate,totalnumber from bookinginfo";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<BookingInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<BookingInfoTo>();
                do {
                    BookingInfoTo record = new BookingInfoTo();
                    record.setBookingid(rs.getInt("bookingid"));
                    record.setCustomername(rs.getString("customername"));
                    record.setContactno(rs.getString("contactno"));
                    record.setFlightid(rs.getInt("flightid"));
                    record.setBookingdate(rs.getDate("bookingdate"));
                    record.setJourneydate(rs.getDate("journeydate"));
                    record.setTotalnumber(rs.getInt("totalnumber"));
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
