/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferenceproject;

import static conferenceproject.JDialogLogin.usernow;
import java.util.*;
import dao.*;
import java.awt.CardLayout;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import pojos.*;

/**
 *
 * @author LONG LIN
 */
public class JFrameMain extends javax.swing.JFrame {

    //biến lưu conference đang được trong table 
    public static Conference confNow = null;

    /**
     * Creates new form JFrameMain1
     */
    public JFrameMain() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.jButtonProfile.setVisible(false);
        this.LabelUsernow.setVisible(false);
        this.jButtonLogOut.setVisible(false);
        this.jButtonAddCon.setVisible(false);
        this.jButtonAddLoc.setVisible(false);
        this.jButtonListLoc.setVisible(false);
        this.jButtonListAcc.setVisible(false);
        this.jButtonUserCon.setVisible(false);
        this.jButtonMyCon.setVisible(false);

        if (usernow != null) {
            this.LabelUsernow.setVisible(true);
            this.jButtonMyCon.setVisible(true);
            this.LabelUsernow.setText(usernow.getName());
            //user là admin
            if (usernow.getType() == 1) {
                this.jButtonAddCon.setVisible(true);
                this.jButtonAddLoc.setVisible(true);
                this.jButtonListLoc.setVisible(true);
                this.jButtonListAcc.setVisible(true);
                this.jButtonUserCon.setVisible(true);

            }
            this.jButtonLogIn.setVisible(false);
            this.jButtonLogOut.setVisible(true);
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
        jPanel2 = new javax.swing.JPanel();
        LabelUsernow = new javax.swing.JLabel();
        jButtonProfile = new javax.swing.JButton();
        jButtonMyCon = new javax.swing.JButton();
        jButtonLogIn = new javax.swing.JButton();
        jButtonAddCon = new javax.swing.JButton();
        jButtonAddLoc = new javax.swing.JButton();
        jButtonListLoc = new javax.swing.JButton();
        jButtonListAcc = new javax.swing.JButton();
        jButtonUserCon = new javax.swing.JButton();
        jButtonSignUp = new javax.swing.JButton();
        jButtonLogOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanelHome = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButtonShowCarCon = new javax.swing.JButton();
        jButtonShowListCon = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10);
        flowLayout1.setAlignOnBaseline(true);
        jPanel2.setLayout(flowLayout1);

        LabelUsernow.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        LabelUsernow.setForeground(new java.awt.Color(255, 255, 255));
        LabelUsernow.setText("adadd");
        LabelUsernow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelUsernowMouseClicked(evt);
            }
        });
        jPanel2.add(LabelUsernow);

        jButtonProfile.setBackground(new java.awt.Color(250, 99, 12));
        jButtonProfile.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonProfile.setForeground(new java.awt.Color(51, 51, 51));
        jButtonProfile.setText("Trang cá nhân");
        jButtonProfile.setPreferredSize(new java.awt.Dimension(240, 40));
        jButtonProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProfileActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonProfile);

        jButtonMyCon.setBackground(new java.awt.Color(250, 99, 12));
        jButtonMyCon.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonMyCon.setForeground(new java.awt.Color(51, 51, 51));
        jButtonMyCon.setText("Thống kê hội nghị");
        jButtonMyCon.setPreferredSize(new java.awt.Dimension(240, 40));
        jButtonMyCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMyConActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonMyCon);

        jButtonLogIn.setBackground(new java.awt.Color(250, 99, 12));
        jButtonLogIn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonLogIn.setForeground(new java.awt.Color(51, 51, 51));
        jButtonLogIn.setText("Đăng nhập");
        jButtonLogIn.setPreferredSize(new java.awt.Dimension(240, 40));
        jButtonLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogInActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonLogIn);

        jButtonAddCon.setBackground(new java.awt.Color(250, 99, 12));
        jButtonAddCon.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonAddCon.setForeground(new java.awt.Color(51, 51, 51));
        jButtonAddCon.setText("Thêm hội nghị");
        jButtonAddCon.setPreferredSize(new java.awt.Dimension(240, 40));
        jButtonAddCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddConActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAddCon);

        jButtonAddLoc.setBackground(new java.awt.Color(250, 99, 12));
        jButtonAddLoc.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonAddLoc.setForeground(new java.awt.Color(51, 51, 51));
        jButtonAddLoc.setText("Thêm địa điểm");
        jButtonAddLoc.setPreferredSize(new java.awt.Dimension(240, 40));
        jButtonAddLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddLocActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAddLoc);

        jButtonListLoc.setBackground(new java.awt.Color(250, 99, 12));
        jButtonListLoc.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonListLoc.setForeground(new java.awt.Color(51, 51, 51));
        jButtonListLoc.setText("Danh sách địa điểm");
        jButtonListLoc.setPreferredSize(new java.awt.Dimension(240, 40));
        jButtonListLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListLocActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonListLoc);

        jButtonListAcc.setBackground(new java.awt.Color(250, 99, 12));
        jButtonListAcc.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonListAcc.setForeground(new java.awt.Color(51, 51, 51));
        jButtonListAcc.setText("Danh sách tài khoản");
        jButtonListAcc.setPreferredSize(new java.awt.Dimension(240, 40));
        jButtonListAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListAccActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonListAcc);

        jButtonUserCon.setBackground(new java.awt.Color(250, 99, 12));
        jButtonUserCon.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonUserCon.setForeground(new java.awt.Color(51, 51, 51));
        jButtonUserCon.setText("Danh sách tham gia");
        jButtonUserCon.setPreferredSize(new java.awt.Dimension(240, 40));
        jButtonUserCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserConActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonUserCon);

        jButtonSignUp.setBackground(new java.awt.Color(250, 99, 12));
        jButtonSignUp.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonSignUp.setForeground(new java.awt.Color(51, 51, 51));
        jButtonSignUp.setText("Đăng kí");
        jButtonSignUp.setPreferredSize(new java.awt.Dimension(240, 40));
        jButtonSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignUpActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSignUp);

        jButtonLogOut.setBackground(new java.awt.Color(250, 99, 12));
        jButtonLogOut.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonLogOut.setForeground(new java.awt.Color(51, 51, 51));
        jButtonLogOut.setText("Đăng xuất");
        jButtonLogOut.setPreferredSize(new java.awt.Dimension(240, 40));
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonLogOut);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý hội nghị");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Copyright © 2020 by Long Lin");

        jPanel3.setLayout(new java.awt.CardLayout());

        jPanelHome.setBackground(new java.awt.Color(220, 220, 220));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Phần mềm này sử dụng Java Swing kết hợp Hibernate sử dụng MySQL để xây dựng");

        jButtonShowCarCon.setBackground(new java.awt.Color(250, 99, 12));
        jButtonShowCarCon.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonShowCarCon.setForeground(java.awt.Color.white);
        jButtonShowCarCon.setText("Xem danh sách hội nghị dạng card");
        jButtonShowCarCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowCarConActionPerformed(evt);
            }
        });

        jButtonShowListCon.setBackground(new java.awt.Color(250, 99, 12));
        jButtonShowListCon.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonShowListCon.setForeground(java.awt.Color.white);
        jButtonShowListCon.setText("Xem danh sách hội nghị dạng list");
        jButtonShowListCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowListConActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Trang chủ");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Chào mừng bạn đến với phần mêm quản lý hội nghị");

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jButtonShowListCon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonShowCarCon)
                .addGap(131, 131, 131))
            .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelHomeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelHomeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelHomeLayout.setVerticalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel4)
                .addGap(94, 94, 94)
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonShowListCon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonShowCarCon))
                .addGap(220, 220, 220))
            .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelHomeLayout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jLabel6)
                    .addContainerGap(508, Short.MAX_VALUE)))
            .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelHomeLayout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addComponent(jLabel7)
                    .addContainerGap(424, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanelHome, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        this.jButtonLogIn.setVisible(true);
        this.LabelUsernow.setVisible(false);
        this.jButtonLogOut.setVisible(false);
        this.jButtonAddCon.setVisible(false);
        this.jButtonAddLoc.setVisible(false);
        this.jButtonListLoc.setVisible(false);
        this.jButtonListAcc.setVisible(false);
        this.jButtonUserCon.setVisible(false);
        this.jButtonMyCon.setVisible(false);
        usernow = null;
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jButtonSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignUpActionPerformed
        JDialogSignup a = new JDialogSignup(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButtonSignUpActionPerformed

    private void jButtonListAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListAccActionPerformed
        JDialogAccount a = new JDialogAccount(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButtonListAccActionPerformed

    private void jButtonListLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListLocActionPerformed
        JDialogListDes f = new JDialogListDes(this, rootPaneCheckingEnabled);
        f.setVisible(true);
//        this.jLayeredPaneHome.add(f);
    }//GEN-LAST:event_jButtonListLocActionPerformed

    private void jButtonAddLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddLocActionPerformed
        JDialogAddDes f = new JDialogAddDes(this, rootPaneCheckingEnabled);
        f.setVisible(true);
//        this.jLayeredPaneHome.add(f);
    }//GEN-LAST:event_jButtonAddLocActionPerformed

    private void jButtonAddConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddConActionPerformed
        JDialogAddConference f = new JDialogAddConference(this, rootPaneCheckingEnabled);
        f.setVisible(true);
    }//GEN-LAST:event_jButtonAddConActionPerformed

    private void jButtonLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogInActionPerformed
        JDialogLogin a = new JDialogLogin(this, rootPaneCheckingEnabled);
        a.setVisible(true);
        if (usernow != null) {
            this.LabelUsernow.setVisible(true);
            this.jButtonMyCon.setVisible(true);
            this.LabelUsernow.setText(usernow.getName());
            //user là admin
            if (usernow.getType() == 1) {
                this.jButtonAddCon.setVisible(true);
                this.jButtonAddLoc.setVisible(true);
                this.jButtonListLoc.setVisible(true);
                this.jButtonListAcc.setVisible(true);
                this.jButtonUserCon.setVisible(true);

            }
            this.jButtonLogIn.setVisible(false);
            this.jButtonLogOut.setVisible(true);
        }
        this.setVisible(false);
        JFrameMain f = new JFrameMain();
        f.setVisible(true);
    }//GEN-LAST:event_jButtonLogInActionPerformed

    private void jButtonProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProfileActionPerformed
        JDialogProfile f = new JDialogProfile(this, rootPaneCheckingEnabled);
        f.setVisible(true);
        this.LabelUsernow.setText(usernow.getName());
    }//GEN-LAST:event_jButtonProfileActionPerformed

    private void LabelUsernowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelUsernowMouseClicked
        JDialogProfile f = new JDialogProfile(this, rootPaneCheckingEnabled);
        f.setVisible(true);
        this.LabelUsernow.setText(usernow.getName());
    }//GEN-LAST:event_LabelUsernowMouseClicked

    private void jButtonShowCarConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowCarConActionPerformed
        JOptionPane.showMessageDialog(null, "Đang tải dữ liệu lên");

        JDialogCardCon f = new JDialogCardCon(this, rootPaneCheckingEnabled);

        f.setVisible(true);

        this.setVisible(false);
        JFrameMain a = new JFrameMain();
        a.setVisible(true);
    }//GEN-LAST:event_jButtonShowCarConActionPerformed

    private void jButtonShowListConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowListConActionPerformed
        JDialogListCon f = new JDialogListCon(this, rootPaneCheckingEnabled);
        f.setVisible(true);
//        if (usernow != null) {
//            this.setVisible(false);
//            JFrameMain a = new JFrameMain();
//            a.setVisible(true);
//        }
        this.setVisible(false);
        JFrameMain a = new JFrameMain();
        a.setVisible(true);
    }//GEN-LAST:event_jButtonShowListConActionPerformed

    private void jButtonUserConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserConActionPerformed
        JDialogUserCon f = new JDialogUserCon(this, rootPaneCheckingEnabled);
        f.setVisible(true);
    }//GEN-LAST:event_jButtonUserConActionPerformed

    private void jButtonMyConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMyConActionPerformed
        JDialogMyCon f = new JDialogMyCon(this, rootPaneCheckingEnabled);
        f.setVisible(true);
    }//GEN-LAST:event_jButtonMyConActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelUsernow;
    private javax.swing.JButton jButtonAddCon;
    private javax.swing.JButton jButtonAddLoc;
    private javax.swing.JButton jButtonListAcc;
    private javax.swing.JButton jButtonListLoc;
    private javax.swing.JButton jButtonLogIn;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonMyCon;
    private javax.swing.JButton jButtonProfile;
    private javax.swing.JButton jButtonShowCarCon;
    private javax.swing.JButton jButtonShowListCon;
    private javax.swing.JButton jButtonSignUp;
    private javax.swing.JButton jButtonUserCon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelHome;
    // End of variables declaration//GEN-END:variables
}