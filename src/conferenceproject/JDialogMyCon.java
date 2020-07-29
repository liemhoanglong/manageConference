/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferenceproject;

import javax.swing.table.DefaultTableModel;
import dao.*;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JOptionPane;
import pojos.*;
import static conferenceproject.JDialogLogin.usernow;
import static conferenceproject.JFrameMain.confNow;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LONG LIN
 */
public class JDialogMyCon extends javax.swing.JDialog {

    private UserConferenceDao userConD = new UserConferenceDao();
    private conferenceDao ConD = new conferenceDao();

    public List<UserConference> ls;
    public int filterByMax = 0;
    public String filterByName;

    public void getDataCon() {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
//        dtm.addColumn("Id");
        dtm.addColumn("IdCon");
        dtm.addColumn("Tên hội nghị");
        dtm.addColumn("Địa điểm");
        dtm.addColumn("Thông tin");
        dtm.addColumn("Số lượng");
        ls = this.userConD.findAll();
        if (filterByName != null) {
            for (UserConference con : ls) {
                if (con.getUser().getIdUser() == usernow.getIdUser() && con.getConference().getName().indexOf(filterByName) != -1) {
                    dtm.addRow(new Object[]{con.getConference().getIdConference(), con.getConference().getName(), con.getConference().getDestination().getName(), con.getConference().getInfo(), con.getConference().getMax()});
                }
            }
            this.jLabelSearch.setText("Những hội nghị tên \"" + filterByName + "\"");
            filterByName = null;
            this.jTextFieldSearchName.setText("");
            this.jLabelSearch.setVisible(true);
        } else if (filterByMax > 0) {
            for (UserConference con : ls) {
                if (con.getUser().getIdUser() == usernow.getIdUser() && con.getConference().getMax() <= filterByMax) {
                    dtm.addRow(new Object[]{con.getConference().getIdConference(), con.getConference().getName(), con.getConference().getDestination().getName(), con.getConference().getInfo(), con.getConference().getMax()});
                }
            }
            this.jLabelSearch.setText("Những hội nghị có số lượng dưới \"" + filterByMax + "\" " + "người tham gia");
            filterByMax = 0;
            this.jSpinnerSearchMax.setValue(Integer.valueOf(0));
            this.jLabelSearch.setVisible(true);
        } else {
            for (UserConference con : ls) {
                if (con.getUser().getIdUser() == usernow.getIdUser()) {
                    dtm.addRow(new Object[]{con.getConference().getIdConference(), con.getConference().getName(), con.getConference().getDestination().getName(), con.getConference().getInfo(), con.getConference().getMax()});
                }
            }
            this.jLabelSearch.setVisible(false);
        }

//        System.out.println("test get " + ls.size());
//        for (UserConference con : ls) {
//            dtm.addRow(new Object[]{con.getConference().getIdConference(), con.getUser().getIdUser(), con.getConference().getName(), con.getConference().getMax(), con.getUser().getName(), con.getState()});
//        }
        this.jTableUserCon.setAutoCreateRowSorter(true);
        this.jTableUserCon.setModel(dtm);
        this.jTableUserCon.repaint();
        this.jTableUserCon.revalidate();
        filterByMax = 0;
    }

    /**
     * Creates new form JDialogMyCon
     */
    public JDialogMyCon(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getDataCon();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUserCon = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        nameCon = new javax.swing.JTextField();
        nameUser = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        max = new javax.swing.JTextField();
        type = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButtonSearchType = new javax.swing.JButton();
        jTextFieldSearchName = new javax.swing.JTextField();
        jButtonSearchName = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jSpinnerSearchMax = new javax.swing.JSpinner();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableUserCon.setBackground(new java.awt.Color(255, 255, 255));
        jTableUserCon.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTableUserCon.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableUserCon.setRowHeight(40);
        jTableUserCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserConMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUserCon);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Danh sách hội nghị bạn đã tham dự");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hội nghị", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Id hội nghị:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("Tên người tham gia:");

        jButton4.setBackground(new java.awt.Color(250, 99, 12));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton4.setForeground(java.awt.Color.white);
        jButton4.setText("Hủy tham gia");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        nameCon.setEditable(false);
        nameCon.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        nameCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameConActionPerformed(evt);
            }
        });

        nameUser.setEditable(false);
        nameUser.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setText("Hạn chót:");

        date.setEditable(false);
        date.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Trạng thái 0: chưa duyệt, trạng thái 1: Đã duyệt");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setText("Số lượng người tham gia:");

        max.setEditable(false);
        max.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        type.setEditable(false);
        type.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel19.setText("Trạng thái:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(264, 264, 264))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(352, 352, 352))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameCon)
                            .addComponent(nameUser)
                            .addComponent(date)
                            .addComponent(max)
                            .addComponent(type))
                        .addGap(50, 50, 50))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameCon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(max, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(25, 25, 25))
        );

        jButtonSearchType.setBackground(new java.awt.Color(250, 99, 12));
        jButtonSearchType.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonSearchType.setForeground(java.awt.Color.white);
        jButtonSearchType.setText("Lọc theo số lượng người tham gia");
        jButtonSearchType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchTypeActionPerformed(evt);
            }
        });

        jTextFieldSearchName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jButtonSearchName.setBackground(new java.awt.Color(250, 99, 12));
        jButtonSearchName.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonSearchName.setForeground(java.awt.Color.white);
        jButtonSearchName.setText("Lọc theo tên hội nghị");
        jButtonSearchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchNameActionPerformed(evt);
            }
        });

        jLabelSearch.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelSearch.setForeground(new java.awt.Color(255, 51, 51));
        jLabelSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSearch.setText(" ");

        jSpinnerSearchMax.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldSearchName, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                            .addComponent(jSpinnerSearchMax))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSearchName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSearchType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSearchType)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSpinnerSearchMax, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addGap(5, 5, 5)))
                .addGap(17, 17, 17)
                .addComponent(jLabelSearch)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableUserConMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserConMouseClicked
        String idCon = this.jTableUserCon.getValueAt(this.jTableUserCon.getSelectedRow(), 0).toString();
//        System.out.println("test co ");
//        System.out.println(idCon);
        confNow = this.ConD.find(idCon);
        //hiện thông tin chi tiết hội nghị
//        this.ConD.find(idCon);
        JDialoInfoConf fa = new JDialoInfoConf(jFrame1, rootPaneCheckingEnabled);
        fa.setVisible(true);

        //chỉnh sửa thành Hủy tham gia
        String idUser = usernow.getIdUser().toString();
        UserConference a = null;
        a = this.userConD.find(parseInt(idCon), parseInt(idUser));
        //        this.id.setText(a.getId().toString());
        this.nameCon.setText(a.getConference().getIdConference().toString());
        this.nameUser.setText(a.getUser().getName());
        this.max.setText(a.getConference().getMax().toString());
        this.date.setText(a.getConference().getDate().toString());
        this.type.setText(a.getState().toString());
        getDataCon();
    }//GEN-LAST:event_jTableUserConMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String idCon = this.nameCon.getText();
//        System.out.println(idCon);
        String idUser = usernow.getIdUser().toString();
//        System.out.println(idUser);
        UserConference a = null;
        a = this.userConD.find(parseInt(idCon), parseInt(idUser));

//        System.out.println(a.getState());
        int cf = JOptionPane.showConfirmDialog(null, "Bạn có chắc hủy tham gia", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (cf == JOptionPane.YES_OPTION) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateInString = this.date.getText();
            Date date = new Date();
            try {
                date = formatter.parse(dateInString);
                System.out.println("han chot " + date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date date1 = new Date();
            System.out.println(date1.toString());
            int check = date.compareTo(date1);
            System.out.println(check);

            if (check > 0) {
                a.setState(0);
                if (this.userConD.update(a)) {
                    JOptionPane.showMessageDialog(null, "Hủy tham gia thành công");
                    getDataCon();
                    this.nameCon.setText("");
                    this.nameUser.setText("");
                    this.max.setText("");
                    this.date.setText("");
                    this.type.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Hủy tham gia thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Hủy tham gia thất bại. Vì đã quá hạn!");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nameConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameConActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void jButtonSearchTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchTypeActionPerformed
//        int a = parseInt(this.jTextFieldSearchMax.getText());
        filterByMax = parseInt(this.jSpinnerSearchMax.getValue().toString());
        getDataCon();
    }//GEN-LAST:event_jButtonSearchTypeActionPerformed

    private void jButtonSearchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchNameActionPerformed
        filterByName = this.jTextFieldSearchName.getText();
        getDataCon();
    }//GEN-LAST:event_jButtonSearchNameActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogMyCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogMyCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogMyCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogMyCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogMyCon dialog = new JDialogMyCon(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonSearchName;
    private javax.swing.JButton jButtonSearchType;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerSearchMax;
    private javax.swing.JTable jTableUserCon;
    private javax.swing.JTextField jTextFieldSearchName;
    private javax.swing.JTextField max;
    private javax.swing.JTextField nameCon;
    private javax.swing.JTextField nameUser;
    private javax.swing.JTextField type;
    // End of variables declaration//GEN-END:variables
}