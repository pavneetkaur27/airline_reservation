package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.FlightPriceTo;

public class FlightPriceDao {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(FlightPriceTo record) {
        try {
            String query = " insert into flightprice (categoryid ,flightid,price,discount ,totalseat) ";
            query += " values(?,?,?,?,?) ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCategoryid());
            stmt.setInt(2, record.getFlightid());
            stmt.setFloat(3, record.getPrice());
            stmt.setFloat(4, record.getDiscount());
            stmt.setInt(5, record.getTotalseat());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(FlightPriceTo record) {
        try {
            String query = " update flightprice set categoryid=? ,flightid=?,price=?,discount=?,totalseat=? ";
            query += " where srno=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCategoryid());
            stmt.setInt(2, record.getFlightid());
            stmt.setFloat(3, record.getPrice());
            stmt.setFloat(4, record.getDiscount());
            stmt.setInt(5, record.getTotalseat());
            stmt.setInt(6, record.getSrno());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(int srno) {
        try {
            String query = " delete from flightprice where srno=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, srno);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public FlightPriceTo getRecord(int srno) {
        try {
            String query = " select srno,categoryid,flightid ,price,discount,totalseat from flightprice ";
            query += " where srno=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, srno);
            FlightPriceTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new FlightPriceTo();
                result.setSrno(rs.getInt("srno"));
                result.setCategoryid(rs.getString("categoryid"));
                result.setFlightid(rs.getInt("flightid"));
                result.setPrice(rs.getFloat("price"));
                result.setDiscount(rs.getFloat("discount"));
                result.setTotalseat(rs.getInt("totalseat"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<FlightPriceTo> getAllRecord() {
        try {
            String query = " select srno,fp.categoryid,categoryname,flightid ,price,discount,totalseat from flightprice fp ";
            query += " join classcategory cc on fp.categoryid=cc.categoryid ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<FlightPriceTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<FlightPriceTo>();
                do {
                    FlightPriceTo record = new FlightPriceTo();
                    record.setSrno(rs.getInt("srno"));
                    record.setCategoryid(rs.getString("categoryid"));
                    record.setFlightid(rs.getInt("flightid"));
                    record.setPrice(rs.getFloat("price"));
                    record.setDiscount(rs.getFloat("discount"));
                    record.setTotalseat(rs.getInt("totalseat"));
                    record.setCategoryname(rs.getString("categoryname"));
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

    public List<FlightPriceTo> getAllRecord(int flightid) {
        try {
            //System.out.println(flightid);
            String query = " select fp.categoryid,categoryname, totalseat,price from flightprice fp ";
            query += "join classcategory cc on fp.categoryid=cc.categoryid  where flightid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, flightid);
            List<FlightPriceTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do{
                    FlightPriceTo fpt = new FlightPriceTo();
                    fpt.setTotalseat(rs.getInt("totalseat"));
                    fpt.setCategoryid(rs.getString("categoryid"));               
                    fpt.setCategoryname(rs.getString("categoryname"));
                    fpt.setPrice(rs.getFloat("price"));
                    result.add(fpt);
                }while(rs.next());
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
