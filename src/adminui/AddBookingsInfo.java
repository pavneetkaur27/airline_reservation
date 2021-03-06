/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.dao.BookingInfoDao;
import model.dao.CommonDao;
import model.dao.FlightInfoDao;
import model.to.BookingInfoTo;
import model.to.FlightInfoTo;
import utility.Validations;

/**
 *
 * @author Pavneet
 */
public class AddBookingsInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddBookings
     */
    private int bookingid;
    private int tseat;

    public AddBookingsInfo() {
        initComponents();
        getRootPane().setDefaultButton(btnAddBookingInfo);
        jcbflightid.removeAllItems();;
        jcbflightid.addItem("Select Flight Id ");
        List<FlightInfoTo> flights = new FlightInfoDao().getAllRecord();
        if (flights != null & flights.size() > 0) {
            for (FlightInfoTo flight : flights) {
                jcbflightid.addItem(flight);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jcbMonth1 = new javax.swing.JComboBox();
        jcbDate1 = new javax.swing.JComboBox();
        jcbYear1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jtfcontact = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfname = new javax.swing.JTextField();
        jtftotalNo = new javax.swing.JTextField();
        jcbflightid = new javax.swing.JComboBox();
        btnAddBookingInfo = new javax.swing.JButton();
        futureDatePanel = new adminui.FutureDatePanel1();

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Enter Customer Name:");

        jcbMonth1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbMonth1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbMonth1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMonth1ItemStateChanged(evt);
            }
        });

        jcbDate1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbDate1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbYear1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbYear1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbYear1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbYear1ItemStateChanged(evt);
            }
        });

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Flight Bookings");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Enter Customer Name:");

        jtfcontact.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtfcontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfcontactActionPerformed(evt);
            }
        });
        jtfcontact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfcontactKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Enter Total No of Seats Booked: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Select Flight Id:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Enter Contact No:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText("Enter Journey Date:");

        jtfname.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jtftotalNo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtftotalNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtftotalNoKeyTyped(evt);
            }
        });

        jcbflightid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddBookingInfo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnAddBookingInfo.setText("Add Booking Info");
        btnAddBookingInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookingInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 48, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jtftotalNo, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbflightid, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(futureDatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(btnAddBookingInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbflightid, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(futureDatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtftotalNo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(btnAddBookingInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbMonth1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMonth1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMonth1ItemStateChanged

    private void jcbYear1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYear1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbYear1ItemStateChanged

    private void jtftotalNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtftotalNoKeyTyped
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_jtftotalNoKeyTyped

    private void jtfcontactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfcontactKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfcontactKeyTyped

    private void btnAddBookingInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookingInfoActionPerformed
        String message = "";
        String name = jtfname.getText().trim();
        String contact = jtfcontact.getText().trim();
        String totalno = jtftotalNo.getText().trim();
        boolean allvalid = true;        
        if (Validations.isEmpty(name)) {
            allvalid = false;
            message += " \n\n Please Enter the Customer Name ";
        }
        if (Validations.isEmpty(contact)) {
            allvalid = false;
            message += " \n\n Please Fill Any Value in Contact No Box";
        } else if (contact.length() != 10) {
            allvalid = false;
            message += "\n\n Please Provide Valid Contact No Box";
        }
        if (jcbflightid.getSelectedIndex() == 0) {
            allvalid = false;
            message += "\n\n Please Choose Any Flight Id";
        }
        if (futureDatePanel.getSelectedDate() == null) {
            allvalid = false;
            message += "\n\n Please enter the Date ";
        }
        if (Validations.isEmpty(totalno)) {
            allvalid = false;
            message += " \n\n Please Enter Total number of Seats Booked ";
        } else if (!Validations.isNumeric(totalno)) {
            allvalid = false;
            message += "\n\n Please Enter Numeric Value";
        } else {
            int tseat = Integer.parseInt(totalno);
            if (tseat < 1) {
                allvalid = false;
                message += " \n Please Enter Valid Amount of seats";
            }
        }
        
        if (allvalid) {
            BookingInfoTo record = new BookingInfoTo();
            record.setCustomername(name);
            record.setContactno(contact);
            FlightInfoTo ft = (FlightInfoTo) jcbflightid.getSelectedItem();
            record.setFlightid(ft.getFlightid());
            int tseat = Integer.parseInt(totalno);
            record.setTotalnumber(tseat);
            record.setJourneydate(futureDatePanel.getSelectedDate());            
            BookingInfoDao action = new BookingInfoDao();
            if (action.insertRecord(record)) {
                message = "\n Booking Details Of Customer are Saved. ";
                int bid = new CommonDao().getLastInsertId();
                if (bid != 0) {
                    message = "Customer with Booking id [ " + bid + " ] is Added ";
                }
            } else {
                allvalid = false;
                message = "\n Failure occur cann't insert Customer Booking Details "+action.getErrormessage();
            }
        }
        if (allvalid) {
            JOptionPane.showMessageDialog(this, message);
        } else {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddBookingInfoActionPerformed

    private void jtfcontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfcontactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfcontactActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBookingInfo;
    private adminui.FutureDatePanel1 futureDatePanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox jcbDate1;
    private javax.swing.JComboBox jcbMonth1;
    private javax.swing.JComboBox jcbYear1;
    private javax.swing.JComboBox jcbflightid;
    private javax.swing.JTextField jtfcontact;
    private javax.swing.JTextField jtfname;
    private javax.swing.JTextField jtftotalNo;
    // End of variables declaration//GEN-END:variables
}
