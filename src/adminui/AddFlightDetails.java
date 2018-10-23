/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import model.dao.AirlineInfoDao;
import model.dao.CityInfoDao;
import model.dao.CommonDao;
import model.dao.CountryInfoDao;
import model.dao.FlightInfoDao;
import model.to.AirlineInfoTo;
import model.to.CityInfoTo;
import model.to.CountryInfoTo;
import model.to.FlightInfoTo;
import utility.AllCommonOperations;
import utility.Validations;

/**
 *
 * @author Pavneet
 */
public class AddFlightDetails extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddFlightDetails
     */
    private int flightid;
    private int jmin;
    JRadioButton selectedButton = null;
    private static String countryid;

    public AddFlightDetails() {
        initComponents();
        jlblcountry.setVisible(false);
        jcbCountry.setVisible(false);
        jlblsoucecountry.setVisible(false);
        jcbSourceCountry.setVisible(false);
        jlbdestcountry.setVisible(false);
        jcbDestinationCountry.setVisible(false);
        jlbsourcecity.setVisible(false);
        jcbSourceid.setVisible(false);
        jlbdestcity.setVisible(false);
        jcbdestid.setVisible(false);
        jlbsourcecityint.setVisible(false);
        jcbSourceidint.setVisible(false);
        jlbdestcityint.setVisible(false);
        jcbdestidint.setVisible(false);
        getRootPane().setDefaultButton(btnFlightDetails);
        jcbAirlineid.removeAllItems();
        jcbAirlineid.addItem("Select Airline");
        List<AirlineInfoTo> ids = new AirlineInfoDao().getAllRecord();
        if (ids != null && ids.size() > 0) {
            for (AirlineInfoTo id : ids) {
                jcbAirlineid.addItem(id);
            }
        }
        jcbCountry.removeAllItems();
        jcbCountry.addItem("Select Country");
        List<CountryInfoTo> countries = new CountryInfoDao().getAllRecord();
        if (countries != null && countries.size() > 0) {
            for (CountryInfoTo country : countries) {
                jcbCountry.addItem(country);
            }
        }
        jcbSourceCountry.removeAllItems();
        jcbSourceCountry.addItem("Select Source Country");
        List<CountryInfoTo> scountries = new CountryInfoDao().getAllRecord();
        if (scountries != null && scountries.size() > 0) {
            for (CountryInfoTo country : scountries) {
                jcbSourceCountry.addItem(country);
            }
        }

        jcbDestinationCountry.removeAllItems();
        jcbDestinationCountry.addItem("Select Destination Country");

        jcbSourceid.removeAllItems();
        jcbSourceid.addItem("Select Source City");

        jcbdestid.removeAllItems();
        jcbdestid.addItem("Select Destination City");

        jcbSourceidint.removeAllItems();
        jcbSourceidint.addItem("Select Source City");

        jcbdestidint.removeAllItems();
        jcbdestidint.addItem("Select Destination City");
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrbInternational);
        bg.add(jrbDomestic);
        bg.getSelection();
    }

    public AddFlightDetails(int flightid) {
        this();
        FlightInfoTo record = new FlightInfoDao().getRecord(flightid);
        if (record != null) {
            this.flightid = flightid;
            for (int i = 1; i < jcbAirlineid.getItemCount(); i++) {
                AirlineInfoTo at = (AirlineInfoTo) jcbAirlineid.getItemAt(i);
                if (at.getAirlineid().equals(record.getAirlineid())) {
                    jcbAirlineid.setSelectedIndex(i);
                }
            }
            for (int i = 1; i < jcbCountry.getItemCount(); i++) {
                CountryInfoTo ct = (CountryInfoTo) jcbCountry.getItemAt(i);
                if (ct.getCountryid().equals(record.getCountryid())) {
                    jcbCountry.setSelectedIndex(i);
                }
            }
            for (int i = 1; i < jcbSourceid.getItemCount(); i++) {
                CityInfoTo scy = (CityInfoTo) jcbSourceid.getItemAt(i);
                if (scy.getCityid().equals(record.getSourcecityid())) {
                    jcbSourceid.setSelectedIndex(i);
                }
            }
            for (int i = 1; i < jcbdestid.getItemCount(); i++) {
                CityInfoTo dcy = (CityInfoTo) jcbdestid.getItemAt(i);
                if (dcy.getCityid().equals(record.getDestinationcityid())) {
                    jcbdestid.setSelectedIndex(i);
                }
            }
            for (int i = 1; i < jcbSourceCountry.getItemCount(); i++) {
                CountryInfoTo ct = (CountryInfoTo) jcbSourceCountry.getItemAt(i);
                if (ct.getCountryid().equals(record.getCountryid())) {
                    jcbSourceCountry.setSelectedIndex(i);
                }
            }
            for (int i = 1; i < jcbSourceidint.getItemCount(); i++) {
                CityInfoTo scy = (CityInfoTo) jcbSourceidint.getItemAt(i);
                if (scy.getCityid().equals(record.getSourcecityid())) {
                    jcbSourceidint.setSelectedIndex(i);
                }
            }
            for (int i = 1; i < jcbdestidint.getItemCount(); i++) {
                CityInfoTo dcy = (CityInfoTo) jcbdestidint.getItemAt(i);
                if (dcy.getCityid().equals(record.getDestinationcityid())) {
                    jcbdestidint.setSelectedIndex(i);
                }
            }
            
            jcbSourceid.addItem(record.getSourcecityid());
            jcbdestid.addItem(record.getDestinationcityid());
            jdtime.setTime(record.getDeparturetime());
            jtfJmin.setText(String.valueOf(record.getJourneyminute()));
            if (record.getFlighttype().equalsIgnoreCase("domestic")) {
                jrbDomestic.setSelected(true);
            } else if (record.getFlighttype().equalsIgnoreCase("international")) {
                jrbInternational.setSelected(true);
            }
            setTitle("Edit Records in Database");
            btnFlightDetails.setText("Update Records");

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlbdestcity = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlblcountry = new javax.swing.JLabel();
        btnFlightDetails = new javax.swing.JButton();
        jcbdestid = new javax.swing.JComboBox();
        jcbSourceid = new javax.swing.JComboBox();
        jcbAirlineid = new javax.swing.JComboBox();
        jrbInternational = new javax.swing.JRadioButton();
        jrbDomestic = new javax.swing.JRadioButton();
        jtfJmin = new javax.swing.JTextField();
        jdtime = new adminui.TimePanel1();
        jlbsourcecity = new javax.swing.JLabel();
        jcbCountry = new javax.swing.JComboBox();
        jlbdestcountry = new javax.swing.JLabel();
        jcbDestinationCountry = new javax.swing.JComboBox();
        jlblsoucecountry = new javax.swing.JLabel();
        jcbSourceCountry = new javax.swing.JComboBox();
        jlbsourcecityint = new javax.swing.JLabel();
        jcbSourceidint = new javax.swing.JComboBox();
        jlbdestcityint = new javax.swing.JLabel();
        jcbdestidint = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Add Flight Details");
        setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Select Airline :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Enter Departure Time");

        jlbdestcity.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlbdestcity.setText("Select Destination City :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Enter Flight Type :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Enter Journey Minutes");

        jlblcountry.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlblcountry.setText("Select  Country :");

        btnFlightDetails.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnFlightDetails.setText("Add Flight Details");
        btnFlightDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlightDetailsActionPerformed(evt);
            }
        });

        jcbdestid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbSourceid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbSourceid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSourceidItemStateChanged(evt);
            }
        });
        jcbSourceid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSourceidActionPerformed(evt);
            }
        });

        jcbAirlineid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jrbInternational.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jrbInternational.setText("International");
        jrbInternational.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbInternationalItemStateChanged(evt);
            }
        });

        jrbDomestic.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jrbDomestic.setText("Domestic");
        jrbDomestic.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbDomesticItemStateChanged(evt);
            }
        });

        jtfJmin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jlbsourcecity.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlbsourcecity.setText("Select SourceCity:");

        jcbCountry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCountryItemStateChanged(evt);
            }
        });

        jlbdestcountry.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlbdestcountry.setText("Select Destination Country");

        jcbDestinationCountry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbDestinationCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbDestinationCountryItemStateChanged(evt);
            }
        });

        jlblsoucecountry.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlblsoucecountry.setText("Select Source Country");

        jcbSourceCountry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbSourceCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSourceCountryItemStateChanged(evt);
            }
        });

        jlbsourcecityint.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlbsourcecityint.setText("Select Source City");

        jcbSourceidint.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbSourceidint.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSourceidintItemStateChanged(evt);
            }
        });

        jlbdestcityint.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlbdestcityint.setText("Select Destination City");

        jcbdestidint.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(jlblcountry, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jrbInternational)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbDomestic)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfJmin))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlbdestcity)
                                            .addComponent(jlbdestcountry)
                                            .addComponent(jlbdestcityint))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbAirlineid, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblsoucecountry)
                                    .addComponent(jlbsourcecityint, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbSourceCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbSourceidint, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbsourcecity, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbSourceid, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(391, 391, 391)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbdestidint, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbdestid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 15, Short.MAX_VALUE)
                                .addComponent(jcbDestinationCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFlightDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbAirlineid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdtime, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbInternational, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbDomestic, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfJmin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblsoucecountry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSourceCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbdestcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDestinationCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbsourcecity, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbSourceid, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbdestcity, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbdestid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbdestcityint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbsourcecityint, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbSourceidint, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbdestidint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(btnFlightDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFlightDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlightDetailsActionPerformed
        String message = "";
        boolean allvalid = true;
        String journeymin = jtfJmin.getText().trim();
        if (jcbAirlineid.getSelectedIndex() == 0) {
            message += "\n Please Select the Airline  ";
            allvalid = false;
        }
        if (!jrbInternational.isSelected() && !jrbDomestic.isSelected()) {
            allvalid = false;
            message += " \n Please Select any Flighttype";
        }
        if (jrbInternational.isSelected()) {
            if (jcbSourceCountry.getSelectedIndex() == 0) {
                message += "\n Please Select the Source Country  ";
                allvalid = false;
            }
            if (jcbDestinationCountry.getSelectedIndex() == 0) {
                message += "\n Please Select the Destination Country  ";
                allvalid = false;
            }
            if (jcbSourceidint.getSelectedIndex() == 0) {
                message += "\n Please Select the Source City  ";
                allvalid = false;
            }
            if (jcbdestidint.getSelectedIndex() == 0) {
                message += "\n Please Select the Destination City  ";
                allvalid = false;
            }
        }
        if (jrbDomestic.isSelected()) {
            if (jcbCountry.getSelectedIndex() == 0) {
                message += "\n Please Select the Country ";
                allvalid = false;
            }
            if (jcbSourceid.getSelectedIndex() == 0) {
                message += "\n Please Select the Source City Id ";
                allvalid = false;
            }
            if (jcbdestid.getSelectedIndex() == 0) {
                message += "\n Please Select the Destination City Id ";
                allvalid = false;
            }
        }
        if (jdtime.getSelectedTime() == null) {
            allvalid = false;
            message += "\n Please Select the Time ";
        }
        if (Validations.isEmpty(journeymin)) {
            allvalid = false;
            message += "\n Please Fill the Journey Time ";
        } else if (!Validations.isNumeric(journeymin)) {
            allvalid = false;
            message += " \n Please Fill the numeric value in Journey Time ";
        } else {
            int jmin = Integer.parseInt(journeymin);
            if (jmin < 0) {
                allvalid = false;
                message += " \n Please Fill the Valid Journey Time ";
            }
        }
        if (allvalid) {
            FlightInfoTo record = new FlightInfoTo();
            AirlineInfoTo at = (AirlineInfoTo) jcbAirlineid.getSelectedItem();
            record.setAirlineid(at.getAirlineid());
            if (jrbInternational.isSelected()) {
                selectedButton = jrbInternational;
                CountryInfoTo sct = (CountryInfoTo) jcbSourceCountry.getSelectedItem();
                record.setCountryid(sct.getCountryid());
                CityInfoTo scy = (CityInfoTo) jcbSourceidint.getSelectedItem();
                record.setSourcecityid(scy.getCityid());
                CityInfoTo dct = (CityInfoTo) jcbdestidint.getSelectedItem();
                record.setDestinationcityid(dct.getCityid());
            } else if (jrbDomestic.isSelected()) {
                selectedButton = jrbDomestic;
                CountryInfoTo ct = (CountryInfoTo) jcbCountry.getSelectedItem();
                record.setCountryid(ct.getCountryid());
                CityInfoTo cit = (CityInfoTo) jcbSourceid.getSelectedItem();
                record.setSourcecityid(cit.getCityid());
                CityInfoTo ctt = (CityInfoTo) jcbdestid.getSelectedItem();
                record.setDestinationcityid(ctt.getCityid());
            }
            record.setFlighttype(selectedButton.getText());
            int jmin = Integer.parseInt(journeymin);
            record.setJourneyminute(jmin);
            record.setDeparturetime(jdtime.getSelectedTime());
            FlightInfoDao action = new FlightInfoDao();
            if (btnFlightDetails.getText().contains("Add")) {
                if (action.insertRecord(record)) {
                    message = "\n Flight Details are saved.Thanku!! ";
                    jcbAirlineid.setSelectedIndex(0);
                    jcbCountry.setSelectedIndex(0);
                    jcbdestid.setSelectedIndex(0);
                    jtfJmin.setText(null);
                    if (record.getFlighttype().equalsIgnoreCase("domestic")) {
                        jrbDomestic.setSelected(false);
                    } else if (record.getFlighttype().equalsIgnoreCase("international")) {
                        jrbInternational.setSelected(false);
                    }
                    jdtime.setTime(null);
                    int fid = new CommonDao().getLastInsertId();
                    if (fid != 0) {
                        message = "New flight With Flight Id ( " + fid + " ) is Added in System";
                    }
                } else {
                    allvalid = false;
                    message = "\n Failure occur cann't insert Flight Details " + action.getErrormessage();
                }
            } else if (btnFlightDetails.getText().contains("Update")) {
                record.setFlightid(flightid);
                if (action.updateRecord(record)) {
                    message = "Flight Details are Updated in System";
                } else {
                    message = "Updation Failure :: " + action.getErrormessage();
                    allvalid = false;
                }
                AllCommonOperations.openInternalFrames(getDesktopPane(), new ViewFlightInfo());
                dispose();
            }
        }
        if (allvalid) {
            JOptionPane.showMessageDialog(this, message);
        } else {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFlightDetailsActionPerformed

    private void jcbCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCountryItemStateChanged
        jcbSourceid.removeAllItems();
        jcbSourceid.addItem("Select Source City");
        if (jcbCountry.getSelectedIndex() > 0) {
            CountryInfoTo ct = (CountryInfoTo) jcbCountry.getSelectedItem();
            countryid = ct.getCountryid();
            List<CityInfoTo> scitys = new CityInfoDao().getAllRecord(ct.getCountryid());
            if (scitys != null && scitys.size() > 0) {
                for (CityInfoTo scity : scitys) {
                    jcbSourceid.addItem(scity);
                }
            }
        }
    }//GEN-LAST:event_jcbCountryItemStateChanged

    private void jcbSourceidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSourceidItemStateChanged
        jcbdestid.removeAllItems();
        jcbdestid.addItem("Select Destination City");
        if (jcbSourceid.getSelectedIndex() > 0) {
            CityInfoTo ct = (CityInfoTo) jcbSourceid.getSelectedItem();
            List<CityInfoTo> dcitys = new CityInfoDao().getDestCity(ct.getCityid(), countryid);
            if (dcitys != null && dcitys.size() > 0) {
                for (CityInfoTo dcity : dcitys) {
                    jcbdestid.addItem(dcity);
                }
            }
        }
    }//GEN-LAST:event_jcbSourceidItemStateChanged

    private void jrbInternationalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbInternationalItemStateChanged
        jlblsoucecountry.setVisible(true);
        jcbSourceCountry.setVisible(true);
        jlbdestcountry.setVisible(true);
        jcbDestinationCountry.setVisible(true);
        jlbsourcecityint.setVisible(true);
        jcbSourceidint.setVisible(true);
        jlbdestcityint.setVisible(true);
        jcbdestidint.setVisible(true);
        jlblcountry.setVisible(false);
        jcbCountry.setVisible(false);
        jlbsourcecity.setVisible(false);
        jcbSourceid.setVisible(false);
        jlbdestcity.setVisible(false);
        jcbdestid.setVisible(false);

    }//GEN-LAST:event_jrbInternationalItemStateChanged

    private void jcbSourceCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSourceCountryItemStateChanged
        jcbSourceidint.removeAllItems();
        jcbSourceidint.addItem("Select Source City");
        if (jcbSourceCountry.getSelectedIndex() > 0) {
            CountryInfoTo ct = (CountryInfoTo) jcbSourceCountry.getSelectedItem();
            List<CityInfoTo> scitys = new CityInfoDao().getAllRecord(ct.getCountryid());
            if (scitys != null && scitys.size() > 0) {
                for (CityInfoTo scity : scitys) {
                    jcbSourceidint.addItem(scity);
                }
            }
        }
        jcbDestinationCountry.removeAllItems();
        jcbDestinationCountry.addItem("Select Destination Country");
        if (jcbSourceCountry.getSelectedIndex() > 0) {
            CountryInfoTo ct = (CountryInfoTo) jcbSourceCountry.getSelectedItem();
            List<CountryInfoTo> dcountries = new CountryInfoDao().getAllRecord(ct.getCountryid());
            if (dcountries != null && dcountries.size() > 0) {
                for (CountryInfoTo country : dcountries) {
                    jcbDestinationCountry.addItem(country);
                }
            }
        }
    }//GEN-LAST:event_jcbSourceCountryItemStateChanged

    private void jrbDomesticItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbDomesticItemStateChanged
        jlblcountry.setVisible(true);
        jcbCountry.setVisible(true);
        jlbsourcecity.setVisible(true);
        jcbSourceid.setVisible(true);
        jlbdestcity.setVisible(true);
        jcbdestid.setVisible(true);
        jlblsoucecountry.setVisible(false);
        jcbSourceCountry.setVisible(false);
        jlbdestcountry.setVisible(false);
        jcbDestinationCountry.setVisible(false);
        jlbsourcecityint.setVisible(false);
        jcbSourceidint.setVisible(false);
        jlbdestcityint.setVisible(false);
        jcbdestidint.setVisible(false);
    }//GEN-LAST:event_jrbDomesticItemStateChanged

    private void jcbDestinationCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbDestinationCountryItemStateChanged
        jcbdestidint.removeAllItems();
        jcbdestidint.addItem("Select Destination City");
        if (jcbDestinationCountry.getSelectedIndex() > 0) {
            CountryInfoTo ct = (CountryInfoTo) jcbDestinationCountry.getSelectedItem();
            List<CityInfoTo> dcitys = new CityInfoDao().getAllRecord(ct.getCountryid());
            if (dcitys != null && dcitys.size() > 0) {
                for (CityInfoTo dcity : dcitys) {
                    jcbdestidint.addItem(dcity);
                }
            }
        }
    }//GEN-LAST:event_jcbDestinationCountryItemStateChanged

    private void jcbSourceidintItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSourceidintItemStateChanged

    }//GEN-LAST:event_jcbSourceidintItemStateChanged

    private void jcbSourceidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSourceidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSourceidActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFlightDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox jcbAirlineid;
    private javax.swing.JComboBox jcbCountry;
    private javax.swing.JComboBox jcbDestinationCountry;
    private javax.swing.JComboBox jcbSourceCountry;
    private javax.swing.JComboBox jcbSourceid;
    private javax.swing.JComboBox jcbSourceidint;
    private javax.swing.JComboBox jcbdestid;
    private javax.swing.JComboBox jcbdestidint;
    private adminui.TimePanel1 jdtime;
    private javax.swing.JLabel jlbdestcity;
    private javax.swing.JLabel jlbdestcityint;
    private javax.swing.JLabel jlbdestcountry;
    private javax.swing.JLabel jlblcountry;
    private javax.swing.JLabel jlblsoucecountry;
    private javax.swing.JLabel jlbsourcecity;
    private javax.swing.JLabel jlbsourcecityint;
    private javax.swing.JRadioButton jrbDomestic;
    private javax.swing.JRadioButton jrbInternational;
    private javax.swing.JTextField jtfJmin;
    // End of variables declaration//GEN-END:variables
}
