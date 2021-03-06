/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.dao.AirlineInfoDao;
import model.to.AirlineInfoTo;
import utility.AllCommonOperations;

/**
 *
 * @author Pavneet
 */
 
public class ViewAirlineInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewAirlineInfo
     */
    private List<AirlineInfoTo> alldetails;
    private int srow;
    private JPopupMenu popup;

    

    public ViewAirlineInfo() {
        initComponents();
        bindTableDetails();
        tableAirlineInfo.setRowHeight(25);
        tableAirlineInfo.setShowGrid(true);
        tableAirlineInfo.setBackground(new Color(0,150,200));
        tableAirlineInfo.setForeground(Color.WHITE);
        tableAirlineInfo.setSelectionBackground(Color.white);
        tableAirlineInfo.setSelectionForeground(new Color(0,150,200));
        //tableAirlineInfo.setRowHeight(1, 100);
        srow = -1;
        popup = new JPopupMenu();
        JMenuItem deleterecord = new JMenuItem(" Delete Record");
        deleterecord.setFont(new Font("Times New Roman", Font.BOLD, 25));
        JMenuItem editrecord = new JMenuItem(" Edit Record");
        editrecord.setFont(new Font("Times New Roman", Font.BOLD, 25));
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/adminui/delete1.png"));
            deleterecord.setIcon(icon);
        } catch (Exception ex) {
        }
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/adminui/add.png"));
            editrecord.setIcon(icon);
        } catch (Exception ex) {
        }
        popup.add(deleterecord);
        popup.add(editrecord);
        deleterecord.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });

        editrecord.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editRecord();
            }
        });
    }

    private void deleteRecord() {
        if (srow != -1 && alldetails != null && srow < alldetails.size()) {
            int result = JOptionPane.showConfirmDialog(this, "Do You Really Want to Delete this record ?", "Message From System", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                AirlineInfoTo at = alldetails.get(srow);
                AirlineInfoDao action = new AirlineInfoDao();
                String message = "";
                if (action.deleteRecord(at.getAirlineid())) {
                    message = " Your Desired Record is Deleted. ";
                    bindTableDetails();
                } else {
                    message = " Sorry, Cann't Delete this Record " + action.getErrormessage();
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        srow = -1;
    }

    private void editRecord() {
        if (srow != -1 && alldetails != null && srow < alldetails.size()) {
            AllCommonOperations.openInternalFrames(getDesktopPane(), new AddAirlineInfo(alldetails.get(srow)));
            dispose();

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAirlineInfo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Available Airlines");

        tableAirlineInfo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tableAirlineInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAirlineInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAirlineInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAirlineInfo);
        tableAirlineInfo.getAccessibleContext().setAccessibleName("");
        tableAirlineInfo.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableAirlineInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAirlineInfoMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            int point = tableAirlineInfo.rowAtPoint(evt.getPoint());
            tableAirlineInfo.getSelectionModel().setSelectionInterval(point, point);
            srow = tableAirlineInfo.getSelectedRow();
            //System.out.println(srow);
            popup.show(tableAirlineInfo, evt.getX(), evt.getY());

        }
    }//GEN-LAST:event_tableAirlineInfoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAirlineInfo;
    // End of variables declaration//GEN-END:variables

    public void bindTableDetails() {
        alldetails = new AirlineInfoDao().getAllRecord();
        String[] col_names = {"Airline Id", "Airline Name"};
        Object[][] records = null;
        if (alldetails != null && alldetails.size() > 0) {
            records = new Object[alldetails.size()][col_names.length];
            int i = 0;
            for (AirlineInfoTo at : alldetails) {
                records[i] = new Object[]{at.getAirlineid(), at.getAirlinename()};
                i++;
            }
        } else {
            records = new Object[1][col_names.length];
            records[0] = new Object[]{"No Records", "No Records"};
        }
        DefaultTableModel dtm = new DefaultTableModel(records, col_names) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableAirlineInfo.getTableHeader().setReorderingAllowed(false);
        tableAirlineInfo.setModel(dtm);
    }

}
