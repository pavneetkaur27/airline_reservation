/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.dao.BookingInfoDao;
import model.dao.CityInfoDao;
import model.dao.FlightInfoDao;
import model.to.BookingInfoTo;
import model.to.CityInfoTo;
import model.to.FlightInfoTo;
import utility.AllCommonOperations;

/**
 *
 * @author Pavneet
 */
public class BookingOperations extends javax.swing.JInternalFrame {

    /**
     * Creates new form BookingOperations
     */
    private List<FlightInfoTo> alldetails;
    private int srow;
    private JPopupMenu popup;
    private int bookingid;
    private int flightid;

    public BookingOperations() {
        initComponents();
        srow = -1;
        flightid = 0;
        tableBookingOperations.setRowHeight(25);
        tableBookingOperations.setShowGrid(true);
        tableBookingOperations.setBackground(new Color(0,150,200));
        tableBookingOperations.setForeground(Color.WHITE);
        tableBookingOperations.setSelectionBackground(Color.white);
        tableBookingOperations.setSelectionForeground(new Color(0,150,200));        
        getRootPane().setDefaultButton(btnSearch);
        bindTableDetails(alldetails);
        jcbSourceCity.removeAllItems();
        jcbSourceCity.addItem("Select Source City");
        List<CityInfoTo> scitys = new CityInfoDao().getAllRecord();
        if (scitys != null && scitys.size() > 0) {
            for (CityInfoTo scity : scitys) {
                jcbSourceCity.addItem(scity);
            }
        }
        jcbDestinationCity.removeAllItems();
        jcbDestinationCity.addItem("Select Destination City");

        popup = new JPopupMenu();
        JMenuItem checkavailability = new JMenuItem(" Check Availability");
        checkavailability.setFont(new Font("Times New Roman", Font.BOLD, 25));
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/adminui/check.png"));
            checkavailability.setIcon(icon);
        } catch (Exception ex) {
        }
        popup.add(checkavailability);

        checkavailability.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                checkAvail();
            }
        });

    }

    private void checkAvail() {
        String message = "";
        boolean allvalid = true;
        if (fdjournetdate.getSelectedDate() == null) {
            allvalid = false;
            message += "\n\n Please Select the Journey Date ";
            JOptionPane.showMessageDialog(this, message);
        }
        /*BookingInfoTo record = new BookingInfoTo();
        record.setJourneydate(fdjournetdate.getSelectedDate());
        record.setFlightid(flightid);*/
        //System.out.println(fdjournetdate.getSelectedDate());
        if (allvalid && flightid != 0) {
            AllCommonOperations.openInternalFrames(getDesktopPane(), new BookingAvailability(fdjournetdate.getSelectedDate(), flightid));
            dispose();
        }
    }

    public void bindTableDetails(List<FlightInfoTo> detail) {
        alldetails = detail;
        // alldetails = new FlightInfoDao().getAllRecord();
        String[] col_names = {" Flight Id ", " Airline Name ", "Country Name", " SourceCity Name", "DestinationCity Name", "Flight Type", "Departure Time", "Journey Minutes"};
        Object[][] records = null;
        if (alldetails != null && alldetails.size() > 0) {
            records = new Object[alldetails.size()][col_names.length];
            int i = 0;
            for (FlightInfoTo ft : alldetails) {
                records[i] = new Object[]{ft.getFlightid(), ft.getAirlinename(), ft.getCountryname() + "[" + ft.getCountryid() + "]", ft.getSourcecityname(), ft.getDestinationcityname(), ft.getFlighttype(), ft.getDeparturetime(), ft.getJourneyminute()};
                i++;
            }
        } else {
            records = new Object[1][col_names.length];
            records[0] = new Object[]{"No Records", "No Records", " No Records", " No Records", "No Records", "No Records", "No Records", "No Records"};
        }

        DefaultTableModel dtm = new DefaultTableModel(records, col_names) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableBookingOperations.getTableHeader().setReorderingAllowed(false);
        tableBookingOperations.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        fdjournetdate = new adminui.FutureDatePanel1();
        jcbSourceCity = new javax.swing.JComboBox();
        jcbDestinationCity = new javax.swing.JComboBox();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBookingOperations = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText("Enter Journey Date:");

        jcbSourceCity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbSourceCity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbSourceCity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSourceCityItemStateChanged(evt);
            }
        });

        jcbDestinationCity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbDestinationCity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/search.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tableBookingOperations.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tableBookingOperations.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBookingOperations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBookingOperationsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBookingOperations);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jcbSourceCity, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(fdjournetdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jcbDestinationCity, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(fdjournetdate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSourceCity, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDestinationCity, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String message = "";
        boolean allvalid = true;
        if (jcbSourceCity.getSelectedIndex() == 0) {
            allvalid = false;
            message += "\n\n Please Select the Source City ";
        }
        if (jcbDestinationCity.getSelectedIndex() == 0) {
            allvalid = false;
            message += "\n\n Please Select the Destination City ";
        }
        
        if (allvalid) {
            if (jcbSourceCity.getSelectedIndex() > 0 && jcbDestinationCity.getSelectedIndex() > 0) {
                CityInfoTo sc = (CityInfoTo) jcbSourceCity.getSelectedItem();
                CityInfoTo dc = (CityInfoTo) jcbDestinationCity.getSelectedItem();
                List<FlightInfoTo> ft = new FlightInfoDao().getAllRecord(sc.getCityid(), dc.getCityid());
                // System.out.println(ft.size());

                bindTableDetails(ft);
            }
        } else {
            JOptionPane.showMessageDialog(this, message);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tableBookingOperationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBookingOperationsMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            int point = tableBookingOperations.rowAtPoint(evt.getPoint());
            tableBookingOperations.getSelectionModel().setSelectionInterval(point, point);
            srow = tableBookingOperations.getSelectedRow();
            flightid = Integer.parseInt(tableBookingOperations.getValueAt(srow, 0).toString());
            popup.show(tableBookingOperations, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tableBookingOperationsMouseClicked

    private void jcbSourceCityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSourceCityItemStateChanged
        jcbDestinationCity.removeAllItems();
        jcbDestinationCity.addItem("Select Destination City");
        if (jcbSourceCity.getSelectedIndex() > 0) {
            CityInfoTo ct = (CityInfoTo) jcbSourceCity.getSelectedItem();
            List<CityInfoTo> dcitys = new CityInfoDao().getDestinationCity(ct.getCityid());
            if (dcitys != null && dcitys.size() > 0) {
                for (CityInfoTo dcity : dcitys) {
                    jcbDestinationCity.addItem(dcity);
                }
            }
        }
    }//GEN-LAST:event_jcbSourceCityItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private adminui.FutureDatePanel1 fdjournetdate;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbDestinationCity;
    private javax.swing.JComboBox jcbSourceCity;
    private javax.swing.JTable tableBookingOperations;
    // End of variables declaration//GEN-END:variables
}
