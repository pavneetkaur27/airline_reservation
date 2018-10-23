/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.awt.Color;
import java.sql.Date;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.BookingDetailsDao;
import model.dao.BookingInfoDao;
import model.dao.ClassCategoryDao;
import model.dao.CommonDao;
import model.dao.FlightPriceDao;
import model.to.BookingDetailsTo;
import model.to.BookingInfoTo;
import model.to.ClassCategoryTo;
import model.to.FlightPriceTo;
import utility.Validations;

/**
 *
 * @author Pavneet
 */
public class BookingAvailability extends javax.swing.JInternalFrame {

    /**
     * Creates new form BookingAvailability
     */
    private List<BookingDetailsTo> alldetails;
    private List<BookingDetailsTo> bdetails;
    private List<FlightPriceTo> detail;
    private List<FlightPriceTo> pricedetail;
    private int bookingid;
    private int did;
    private static int count;
    private static int fid;
    private static Date jdate;
    private static float flightprice;
    private static int seats_book = 0;
    private static int available_seats;
    HashMap<String, Integer> table1 = new HashMap<>();
    String catname;

    public BookingAvailability() {
        initComponents();
        bindTables();
        count = 0;
        tableAddCustomer.setRowHeight(25);
        tableAddCustomer.setShowGrid(true);
        tableAddCustomer.setBackground(new Color(0, 150, 200));
        tableAddCustomer.setForeground(Color.WHITE);
        tableAddCustomer.setSelectionBackground(Color.white);
        tableAddCustomer.setSelectionForeground(new Color(0, 150, 200));
        tableAvailableSeats.setRowHeight(25);
        tableAvailableSeats.setShowGrid(true);
        tableAvailableSeats.setBackground(new Color(0, 150, 200));
        tableAvailableSeats.setForeground(Color.WHITE);
        tableAvailableSeats.setSelectionBackground(Color.white);
        tableAvailableSeats.setSelectionForeground(new Color(0, 150, 200));
        getRootPane().setDefaultButton(btnAddCustomer);
        jcbCategoryid.removeAllItems();
        jcbCategoryid.addItem("Select Class Category");
        //alldetails = new BookingDetailsDao().getAllRecord(jdate, fid);

        jcbCustomerSeats.removeAllItems();
        jcbCustomerSeats.addItem("Select Seats");
        for (int i = 1; i <= 15; i++) {
            jcbCustomerSeats.addItem(i);
        }
        jcbCustomerSeats.setEditable(false);
        jcbAge.removeAllItems();
        jcbAge.addItem("Select Age");
        for (int i = 1; i <= 90; i++) {
            jcbAge.addItem(i);
        }
    }

    public BookingAvailability(Date journeydate, int flightid) {
        this();
        fid = flightid;
        jdate = journeydate;
        bindTableDetails(journeydate, flightid);
    }

    public void bindTableDetails(Date jdate, int fid) {
        alldetails = new BookingDetailsDao().getAllRecord(jdate, fid);
        detail = new FlightPriceDao().getAllRecord(fid);

        // System.out.println(detail.size());
        String[] col_names = {" Category Name ", " Booked Seat ", "Available Seats", "Total Flight Seats", "Flight Price"};
        Object[][] records = null;
        if (detail != null && detail.size() > 0) {
            records = new Object[detail.size()][col_names.length];
            int i = 0;
            for (FlightPriceTo bt : detail) {
                int booked_seats = 0;
                jcbCategoryid.addItem(bt);
                available_seats = 0;
                if (alldetails != null && alldetails.size() > 0) {
                    for (BookingDetailsTo bdt : alldetails) {
                        //  System.out.println(bdt.getCategoryid() + "\t" + bt.getCategoryid());
                        if (bdt.getCategoryid().equals(bt.getCategoryid())) {
                            booked_seats = bdt.getTotalseat();//count the seats across a category                            
                            break;
                        }
                    }
                }
                //available_seats = bt.getTotalseat() - booked_seats;
                available_seats = 2;
                //System.out.println(available_seats);
                records[i] = new Object[]{bt.getCategoryname(), booked_seats, available_seats, bt.getTotalseat(), bt.getPrice()};
                i++;
                table1.put(bt.getCategoryname(), available_seats);
                System.out.println(table1.get(bt.getCategoryname()));
            }
        } else {
            records = new Object[1][col_names.length];
            records[0] = new Object[]{"No Records", "No Records", "No Record", "No Record", "No Record"};
        }

        DefaultTableModel dtm = new DefaultTableModel(records, col_names) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableAvailableSeats.getTableHeader().setReorderingAllowed(false);
        tableAvailableSeats.setModel(dtm);
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
        tableAvailableSeats = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtfCustomerName = new javax.swing.JTextField();
        jtfContactNo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAddCustomer = new javax.swing.JTable();
        btnAddCustomer = new javax.swing.JButton();
        jcbAge = new javax.swing.JComboBox();
        btnBooktickets = new javax.swing.JButton();
        jtfPassengerName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jcbCustomerSeats = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jtfFlightPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbCategoryid = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        lgrandtotal = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Booking Procedure");

        tableAvailableSeats.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tableAvailableSeats.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableAvailableSeats);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText("Total Seats To be Booked:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("Contact No:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Customer Name:");

        jtfCustomerName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jtfContactNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtfContactNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfContactNoKeyTyped(evt);
            }
        });

        tableAddCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableAddCustomer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableAddCustomer);

        btnAddCustomer.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnAddCustomer.setText("Click Here To Add Customer");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        jcbAge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbAge.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBooktickets.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnBooktickets.setText("Book Tickets");
        btnBooktickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookticketsActionPerformed(evt);
            }
        });

        jtfPassengerName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Enter Passsenger Name:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Enter Passenger's Age :");

        jcbCustomerSeats.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbCustomerSeats.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Flight Price:");

        jtfFlightPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Select Class Category:");

        jcbCategoryid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcbCategoryid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCategoryid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCategoryidItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Grand Total:");

        lgrandtotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(309, 309, 309))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbCustomerSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jcbAge, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfPassengerName)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcbCategoryid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfFlightPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(lgrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(299, 299, 299)
                                    .addComponent(btnBooktickets, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(jcbCustomerSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPassengerName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbCategoryid, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbAge, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFlightPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lgrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnBooktickets, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfContactNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfContactNoKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfContactNoKeyTyped

    public void bindTables() {
        //bdetails = new BookingInfoDao().getAllRecord();
        //  alldetails = new BookingDetailsDao().getAllRecord();
        String[] col_names = {" Passenger Name ", "Age", "Category Name", "Price"};
        Object[][] records = null;
        HashMap<String, Integer> table2 = new HashMap<>();
        if (bdetails != null && bdetails.size() > 0) {
            records = new Object[bdetails.size()][col_names.length];
            int i = 0;
            float gtotal = 0;
            System.out.println("size " + bdetails.size());
            for (BookingDetailsTo bd : bdetails) {
                float total = bd.getPrice();
                gtotal += total;
                records[i] = new Object[]{bd.getPassengername(), bd.getAge(), bd.getCategoryname(), bd.getPrice()};
                i++;
                System.out.println("class category " + bd.getCategoryname());
                if (table2.containsKey(bd.getCategoryname())) {
                    System.out.println("hi");
                    int val = table2.get(bd.getCategoryname());
                    System.out.println("val " + val);
                    table2.put(bd.getCategoryname(), val + 1);
                } else {
                    int s = 0;
                    System.out.println("hlo");
                    table2.put(bd.getCategoryname(), s + 1);
                }
                System.out.println(table2);
                int orgval = table1.get(bd.getCategoryname());
                System.out.println("orgval " + orgval);
                int calval = table2.get(bd.getCategoryname());
                System.out.println("calval " + calval);
                if (orgval < calval) {
                    JOptionPane.showMessageDialog(rootPane, "No More Seats for this category", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
            Formatter fmt = new Formatter();
            fmt.format("%.2f", gtotal);
            lgrandtotal.setText(fmt.toString());
        } else {
            records = new Object[1][col_names.length];
            records[0] = new Object[]{"No Records", "No Records", "No Records", "No Records"};
        }

        DefaultTableModel dtm = new DefaultTableModel(records, col_names) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableAddCustomer.getTableHeader().setReorderingAllowed(false);
        tableAddCustomer.setModel(dtm);
    }

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        String message = "";
        boolean allvalid = true;
        String cname = jtfCustomerName.getText().trim();
        String contact = jtfContactNo.getText().trim();
        String fprice = jtfFlightPrice.getText().trim();
        String pname = jtfPassengerName.getText().trim();
        if (jcbCustomerSeats.getSelectedIndex() == 0) {
            message += "\n\n Please Select the Seats To be Booked ";
            allvalid = false;
        }
        if (jcbAge.getSelectedIndex() == 0) {
            message += "\n\n Please Select the Passenger's Age ";
            allvalid = false;
        }
        if (jcbCategoryid.getSelectedIndex() == 0) {
            message += "\n\n Please Select the Seats To be Booked ";
            allvalid = false;
        }
        if (Validations.isEmpty(cname)) {
            allvalid = false;
            message += "\n\n Please Enter the Passenger's Name";
        }
        if (Validations.isEmpty(contact)) {
            allvalid = false;
            message += " \n\n Please Fill Any Value in Contact No Box";
        } else if (contact.length() != 10) {
            allvalid = false;
            message += "\n\n Please Provide Valid Contact No Box";
        }
        if (Validations.isEmpty(pname)) {
            allvalid = false;
            message += "\n\n Please Enter the Passenger's Name";
        }
        if (Validations.isEmpty(fprice)) {
            allvalid = false;
            message += "\n\n Please Enter the Price";
        } else if (Validations.isFloat(fprice)) {
            float p = Float.parseFloat(fprice);
            if (p <= 0) {
                message += "\n\nPlease Enter Valid Price";
                allvalid = false;
            }
        } else {
            message += "\n\nPlease Enter Numeric Value in Price Field";
            allvalid = false;
        }
        int seat = Integer.parseInt(jcbCustomerSeats.getSelectedItem().toString());
        if (allvalid) {
            BookingDetailsTo add = new BookingDetailsTo();
            add.setPassengername(pname);
            add.setPrice(Float.parseFloat(fprice));
            FlightPriceTo ft = (FlightPriceTo) jcbCategoryid.getSelectedItem();
            add.setCategoryid(ft.getCategoryid());
            add.setCategoryname(ft.getCategoryname());
            int age_value = Integer.parseInt(jcbAge.getSelectedItem().toString());
            add.setAge(age_value);
            if (bdetails == null) {
                bdetails = new ArrayList<>();
            }
            if (seat >= bdetails.size() + 1) {
                bdetails.add(add);
                jtfPassengerName.setText(null);
                jcbAge.setSelectedIndex(0);
                jcbCategoryid.setSelectedIndex(0);
                jtfFlightPrice.setText(null);
                bindTables();
            } else {
                allvalid = false;
                message += "\n Cannot Insert More Values";
            }
        }
        if (!allvalid) {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void jcbCategoryidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCategoryidItemStateChanged
        jtfFlightPrice.setText("0");
        if (jcbCategoryid.getSelectedIndex() > 0) {
            FlightPriceTo ft = (FlightPriceTo) jcbCategoryid.getSelectedItem();
            jtfFlightPrice.setText(String.valueOf(ft.getPrice()));
        }
    }//GEN-LAST:event_jcbCategoryidItemStateChanged

    private void btnBookticketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookticketsActionPerformed
        String message = "";
        boolean allvalid = true, bookinginfo = false;
        String cname = jtfCustomerName.getText().trim();
        String contact = jtfContactNo.getText().trim();
        String fprice = jtfFlightPrice.getText().trim();
        String pname = jtfPassengerName.getText().trim();
        if (Validations.isEmpty(contact)) {
            allvalid = false;
            message += " \n\n Please Fill Any Value in Contact No Box";
        } else if (contact.length() != 10) {
            allvalid = false;
            message += "\n\n Please Provide Valid Contact No Box";
        }
        if (Validations.isEmpty(cname)) {
            allvalid = false;
            message += "\n\n Please Enter the Customer's Name";
        }
        if (allvalid) {
            BookingInfoTo record = new BookingInfoTo();
            record.setCustomername(cname);
            record.setContactno(contact);
            record.setFlightid(fid);
            record.setJourneydate(jdate);
            int totalseat = Integer.parseInt(jcbCustomerSeats.getSelectedItem().toString());
            record.setTotalnumber(totalseat);
            BookingInfoDao action = new BookingInfoDao();
            if (action.insertRecord(record)) {
                message = "\n Booking Details Of Customer are Saved. ";
                bookinginfo = true;
                int bid = new CommonDao().getLastInsertId();
                if (bid != 0) {
                    message = "Customer with Booking id [ " + bid + " ] is Added ";
                    bookingid = bid;
                }
            } else {
                allvalid = false;
                message = "\n Failure occur cann't insert Customer Booking info of customer " + action.getErrormessage();
            }
            if (bookinginfo) {
                for (BookingDetailsTo bdetail : bdetails) {
                    BookingDetailsTo bd = new BookingDetailsTo();
                    bd.setBookingid(bookingid);
                    bd.setAge(bdetail.getAge());
                    bd.setCategoryid(bdetail.getCategoryid());
                    bd.setPassengername(bdetail.getPassengername());
                    bd.setPrice(bdetail.getPrice());
                    BookingDetailsDao bdd = new BookingDetailsDao();
                    if (bdd.insertRecord(bd)) {
                        message += "\n Details of" + bdetail.getPassengername() + "is Saved";
                        dispose();
                    } else {
                        bookinginfo = false;
                        message = "\n Failure Occur cann't insert " + bdd.getErrormessage();
                    }
                }
            }
        }
        if (allvalid) {
            JOptionPane.showMessageDialog(this, message);
        } else {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBookticketsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnBooktickets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcbAge;
    private javax.swing.JComboBox jcbCategoryid;
    private javax.swing.JComboBox jcbCustomerSeats;
    private javax.swing.JTextField jtfContactNo;
    private javax.swing.JTextField jtfCustomerName;
    private javax.swing.JTextField jtfFlightPrice;
    private javax.swing.JTextField jtfPassengerName;
    private javax.swing.JLabel lgrandtotal;
    private javax.swing.JTable tableAddCustomer;
    private javax.swing.JTable tableAvailableSeats;
    // End of variables declaration//GEN-END:variables
}
