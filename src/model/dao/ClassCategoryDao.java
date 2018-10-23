package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.ClassCategoryTo;

public class ClassCategoryDao {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(ClassCategoryTo record) {
        try {
            String query = " insert into classcategory ( categoryid , categoryname ) values(?,?) ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCategoryid());
            stmt.setString(2, record.getCategoryname());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(ClassCategoryTo record) {
        try {
            String query = " update classcategory set categoryname=? where categoryid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCategoryname());
            stmt.setString(2, record.getCategoryid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String categoryid) {
        try {
            String query = " delete from classcategory where categoryid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, categoryid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public ClassCategoryTo getRecord(String categoryid) {
        try {
            String query = "select categoryid ,categoryname from classcategory where categoryid=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, categoryid);
            ClassCategoryTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result=new ClassCategoryTo();
                result.setCategoryid(rs.getString("categoryid"));
                result.setCategoryname(rs.getString("categoryname"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<ClassCategoryTo> getAllRecord() {
        try {
            String query = " select categoryid,categoryname from classcategory";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<ClassCategoryTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<ClassCategoryTo>();
                do {
                    ClassCategoryTo record = new ClassCategoryTo();
                    record.setCategoryid(rs.getString("categoryid"));
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
}
