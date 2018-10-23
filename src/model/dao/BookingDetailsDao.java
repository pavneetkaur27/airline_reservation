package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.BookingDetailsTo;

public class BookingDetailsDao {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(BookingDetailsTo record) {
        try {
            String query = " insert into bookingdetails (bookingid,categoryid,price,passengername,age) ";
            query += " values(?,?,?,?,?) ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, record.getBookingid());
            stmt.setString(2, record.getCategoryid());
            stmt.setFloat(3, record.getPrice());
            stmt.setString(4, record.getPassengername());
            stmt.setInt(5, record.getAge());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(BookingDetailsTo record) {
        try {
            String query = " update bookingdetails set bookingid=?,categoryid=?,price=?,passengername=?,age=? ";
            query += " where did=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, record.getBookingid());
            stmt.setString(2, record.getCategoryid());
            stmt.setFloat(3, record.getPrice());
            stmt.setString(4, record.getPassengername());
            stmt.setInt(5, record.getAge());
            stmt.setInt(6, record.getDid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(int did) {
        try {
            String query = " delete from bookingdetails where did=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, did);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public BookingDetailsTo getRecord(int did) {
        try {
            String query = " select did,bookingid,categoryid,price,passengername,age ";
            query += " from bookingdetails where did=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, did);
            BookingDetailsTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new BookingDetailsTo();
                result.setDid(rs.getInt("did"));
                result.setBookingid(rs.getInt("bookingid"));
                result.setCategoryid(rs.getString("categoryid"));
                result.setPrice(rs.getFloat("price"));
                result.setPassengername(rs.getString("passengername"));
                result.setAge(rs.getInt("age"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<BookingDetailsTo> getAllRecord() {
        try {
            String query = " select did,bookingid,bd.categoryid,categoryname,price,passengername,age from bookingdetails bd ";
            query += " join classcategory cc on bd.categoryid=cc.categoryid";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<BookingDetailsTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<BookingDetailsTo>();
                do {
                    BookingDetailsTo record = new BookingDetailsTo();
                    record.setDid(rs.getInt("did"));
                    record.setBookingid(rs.getInt("bookingid"));
                    record.setCategoryid(rs.getString("categoryid"));
                    record.setPrice(rs.getFloat("price"));
                    record.setPassengername(rs.getString("passengername"));
                    record.setAge(rs.getInt("age"));
                    record.setCategoryname(rs.getString("categoryname"));
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

    public List<BookingDetailsTo> getAllRecord(Date journeydate, int flightid) {
        try {
            //System.out.println("query"+flightid);
            String query = " select categoryid,count(categoryid) as totalseat from bookingdetails ";
            query += " where bookingid in (select bookingid from bookinginfo ";
            query += "where journeydate=? and flightid=? ) group by categoryid";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setDate(1, journeydate);
            stmt.setInt(2, flightid);
            List<BookingDetailsTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<BookingDetailsTo>();
                do {
                    BookingDetailsTo record = new BookingDetailsTo();
                    record.setCategoryid(rs.getString("categoryid"));
                    record.setTotalseat(rs.getInt("totalseat"));
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
