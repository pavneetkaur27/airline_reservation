/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.dao.BookingInfoDao;
import model.to.BookingInfoTo;

/**
 *
 * @author Pavneet
 */
public class ViewBookingInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewBookingInfo
     */
    private List<BookingInfoTo> alldetails;

    public ViewBookingInfo() {
        initComponents();
        bindTableDetails();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableBookingInfo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Booking Info");

        tableBookingInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableBookingInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBookingInfo;
    // End of variables declaration//GEN-END:variables

    private void bindTableDetails() {
        alldetails = new BookingInfoDao().getAllRecord();
        String[] col_names = {" Booking Id ", " Customer Name ", " Contact No", " Flight Id", " Booking Date", "Journey Date", "Seat Reserved"};
        Object[][] records = null;
        if (alldetails != null && alldetails.size() > 0) {
            records = new Object[alldetails.size()][col_names.length];
            int i = 0;
            for (BookingInfoTo bt : alldetails) {
                records[i] = new Object[]{bt.getBookingid(), bt.getCustomername(), bt.getContactno(), bt.getFlightid(), bt.getBookingdate(), bt.getJourneydate(), bt.getTotalnumber()};
                i++;
            }
        } else {
            records = new Object[1][col_names.length];
            records[0] = new Object[]{"No Records", "No Records", "No Records", "No Records", "No Records", "No Records", "No Records", "No Records"};
        }

        DefaultTableModel dtm = new DefaultTableModel(records, col_names) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableBookingInfo.getTableHeader().setReorderingAllowed(false);
        tableBookingInfo.setModel(dtm);

    }
}