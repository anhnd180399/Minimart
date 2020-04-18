/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.frame;

import duyanh.dao.UserDAO;
import duyanh.dto.UserDTO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anhndSE130595
 */
public class UserManagement extends javax.swing.JFrame {

    DefaultTableModel tblmodel = null;

    /**
     * Creates new form StaffManagement
     */
    public UserManagement() {
        initComponents();
        tblmodel = (DefaultTableModel) tblStaff.getModel();
        txtUserID.setEditable(false);
        firstController();
    }

    private void firstController() {
        UserDAO dao = new UserDAO();
        try {
            List<UserDTO> result = dao.getAll();
            showList(result);
            btnNewActionPerformed(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showList(List<UserDTO> list) {
        tblmodel.setRowCount(0);
        for (UserDTO userDTO : list) {
            tblmodel.addRow(userDTO.toVector());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBackToAdmin = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaff = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        txtEmpName = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        btnEditStaff = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRole = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnResetPass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Welcome Admin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 153));
        jLabel1.setText("User Management");
        jLabel1.setToolTipText("");

        btnBackToAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBackToAdmin.setText("Back");
        btnBackToAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(396, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addComponent(btnBackToAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(btnBackToAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tblStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Employee Name", "Gender", "Phone", "Address", "Role", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStaff);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Staff Management"));

        jLabel5.setText("User ID: ");

        jLabel7.setText("Emp Name: ");

        jLabel8.setText("Gender: ");

        txtEmpName.setToolTipText("");

        btnEditStaff.setText("Edit Staff");
        btnEditStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditStaffActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        jLabel9.setText("Phone: ");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel3.setText("Address: ");

        jLabel4.setText("Role: ");

        txtRole.setToolTipText("");

        jLabel2.setText("Note: ");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnResetPass.setText("Reset Pass");
        btnResetPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNote, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                    .addComponent(txtAddress))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(btnEditStaff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResetPass, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetPass, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStaffMouseClicked
        // TODO add your handling code here:
        txtUserID.setEditable(false);
        String userID, empName, gender, phone, address, role, note;
        int row = tblStaff.getSelectedRow();
        userID = (String) tblmodel.getValueAt(row, 0);
        empName = (String) tblmodel.getValueAt(row, 1);
        gender = (String) tblmodel.getValueAt(row, 2);
        phone = (String) tblmodel.getValueAt(row, 3);
        address = (String) tblmodel.getValueAt(row, 4);
        role = (String) tblmodel.getValueAt(row, 5);
        note = (String) tblmodel.getValueAt(row, 6);
        txtUserID.setText(userID);
        txtEmpName.setText(empName);
        txtGender.setText(gender);
        txtPhone.setText(phone);
        txtAddress.setText(address);
        txtRole.setText(role);
        txtNote.setText(note);
    }//GEN-LAST:event_tblStaffMouseClicked

    private void btnEditStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditStaffActionPerformed
        // TODO add your handling code here:
        String userID, empName, gender, phone, address, role, note, valid = "";
        userID = txtUserID.getText();
        empName = txtEmpName.getText();
        gender = txtGender.getText();
        phone = txtPhone.getText();
        address = txtAddress.getText();
        role = txtRole.getText();
        note = txtNote.getText();
        if (phone.length() != 10) {
            valid += "Please enter corrected phone!\n";
        }
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")){
            valid += "Gender must be male or female! \n";
        }
        if (empName.equals("")) {
            valid += "Employee name can't be blank!\n";
        }
        if (gender.equals("")) {
            valid += "Gender can't be blank!\n";
        }
        if (address.equals("")){
            valid += "Address can't be blank! \n";
        }
        if (role.equals("")){
            valid += "Role can't be blank! \n";
        }
        try {
            Integer.parseInt(phone);
        } catch (Exception e) {
            valid += "Phone must be number! \n";
        }
        if (role.equalsIgnoreCase("admin")) {
            valid += "There's only one admin !";
        }
        if (valid.equals("")) {
            UserDAO dao = new UserDAO();
            UserDTO dto = new UserDTO(userID, empName, gender, address, phone, role, note);
            try {
                if (dao.updateUser(dto)) {
                    JOptionPane.showMessageDialog(this, "Update success!");
                    firstController();
                } else {
                    JOptionPane.showMessageDialog(this, "Update failed!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, valid);
        }
    }//GEN-LAST:event_btnEditStaffActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtUserID.setEditable(true);
        txtUserID.setText("");
        txtEmpName.setText("");
        txtGender.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        txtRole.setText("");
        txtNote.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnBackToAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToAdminActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminFrame().setVisible(true);
    }//GEN-LAST:event_btnBackToAdminActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String userID;
        userID = txtUserID.getText();
        if(userID.equals("")){
            JOptionPane.showMessageDialog(this, "Please choose an user!");
        } else {
            try {
                UserDAO dao = new UserDAO();
                if(dao.deleteUser(userID)){
                    JOptionPane.showMessageDialog(this, "Delete success!");
                    firstController();
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Delete failed!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String userID, empName, gender, phone, address, role, note, valid = "";
        userID = txtUserID.getText();
        empName = txtEmpName.getText();
        gender = txtGender.getText();
        phone = txtPhone.getText();
        address = txtAddress.getText();
        role = txtRole.getText();
        note = txtNote.getText();
        if (userID.equals("")) {
            valid += "UserID can't be blank!\n";
        }
        if (userID.length() > 20) {
            valid += "UserID is too long!\n";
        }
        if (empName.equals("")) {
            valid += "Employee name can't be blank!\n";
        }
        if (gender.equals("")) {
            valid += "Gender can't be blank!\n";
        }
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")){
            valid += "Gender must be male or female! \n";
        }
        if (phone.equals("")) {
            valid += "Phone can't be blank!\n";
        }
        if(phone.length() != 10){
            valid += "Please enter corrected phone!!\n";
        }
        try {
            Integer.parseInt(phone);
        } catch (Exception e) {
            valid += "Phone must be number! \n";
        }
        if (address.equals("")) {
            valid += "Address can't be blank!\n";
        }
        if (role.equals("")) {
            valid += "Role can't be blank!\n";
        }
        if (role.equalsIgnoreCase("admin")) {
            valid += "There's only one admin !";
        }
        if (valid.equals("")) {
            try {
                UserDAO dao = new UserDAO();
                if (dao.checkUserID(userID)) {
                    JOptionPane.showMessageDialog(this, "This ID is existed!");
                } else {
                    UserDTO dto = new UserDTO(userID, empName, gender, address, phone, role, note);
                    if (dao.addUser(dto)) {
                        JOptionPane.showMessageDialog(this, "Add success!");
                        firstController();
                    } else {
                        JOptionPane.showMessageDialog(this, "Add failed!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, valid);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPassActionPerformed
        // TODO add your handling code here:
        String userID = txtUserID.getText();
        if(userID.equals("")){
            JOptionPane.showMessageDialog(this, "Please choose an user!");
        } else {
            try {
                UserDAO dao = new UserDAO();
                if(dao.resetPassWord(userID)){
                    JOptionPane.showMessageDialog(this, "Reset success!");
                    firstController();
                } else {
                    JOptionPane.showMessageDialog(this, "Reset failed!");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnResetPassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBackToAdmin;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEditStaff;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnResetPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStaff;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmpName;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtUserID;
    // End of variables declaration//GEN-END:variables
}
