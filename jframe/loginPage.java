/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author deepankumar
 */
public class loginPage extends javax.swing.JFrame {

    /**
     * Creates new form signin
     */
    public loginPage() {
        initComponents();
    }
    public boolean validateSignup()
    {
          String uname=unametxt.getText();
         String pass=passtxt.getText();
        
           
           if(uname.equals(""))
           {
               JOptionPane.showMessageDialog(this,"Please Enter the User Name");
               return false;
           }
            if(pass.equals(""))
           {
               JOptionPane.showMessageDialog(this,"Please Enter the password");
               return false;
           }
           
              return true;
        
    }
    public boolean login()
    {
        String uname=unametxt.getText();
        String pass=passtxt.getText();
        try
        {
            Connection con=DBconnect.getConnection();
          PreparedStatement  pst=con.prepareStatement("select*from users where username=? and password=?");
          pst.setString(1, uname);
          pst.setString(2,pass);
          ResultSet rs=pst.executeQuery();
          if(rs.next())
          {
           
            return true;
          }
          else
          {
               JOptionPane.showMessageDialog(this,"Invalid user name and password"); 
               return false;
          }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return true;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        unametxt = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        passtxt = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        inserSignupDetails = new rojerusan.RSMaterialButtonCircle();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-3.png.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 830));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 830));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login Page");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 190, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome, To Your Login  Account");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, 20));

        unametxt.setBackground(new java.awt.Color(102, 102, 255));
        unametxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        unametxt.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        unametxt.setPlaceholder("Enter User Name");
        unametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unametxtActionPerformed(evt);
            }
        });
        jPanel2.add(unametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 300, 40));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 120, 20));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 120, 20));

        passtxt.setBackground(new java.awt.Color(102, 102, 255));
        passtxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        passtxt.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        passtxt.setPlaceholder("Enter Password");
        passtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtxtActionPerformed(evt);
            }
        });
        jPanel2.add(passtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 300, 40));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle1.setForeground(new java.awt.Color(0, 51, 204));
        rSMaterialButtonCircle1.setText("SignUp");
        rSMaterialButtonCircle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle1MouseClicked(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 640, 320, 70));

        inserSignupDetails.setBackground(new java.awt.Color(255, 51, 0));
        inserSignupDetails.setText("Login");
        inserSignupDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserSignupDetailsActionPerformed(evt);
            }
        });
        inserSignupDetails.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inserSignupDetailsKeyPressed(evt);
            }
        });
        jPanel2.add(inserSignupDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 320, 70));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 50));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8 icons/icons8-close-window-64.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 470, 830));

        setSize(new java.awt.Dimension(1249, 741));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void unametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unametxtActionPerformed

    private void passtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passtxtActionPerformed

    private void inserSignupDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserSignupDetailsActionPerformed

     if(validateSignup()== true)
     {
      if(login()==true)
      {
          
          HomePage hp=new HomePage();
           hp.setVisible(true);
           dispose();
           loginPage l=new loginPage();
           l.setVisible(false);
          // loginPage l= new loginPage();
          //l.setVisible(false);
      }
     }
     
        // TODO add your handling code here:
    }//GEN-LAST:event_inserSignupDetailsActionPerformed

    private void rSMaterialButtonCircle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseClicked

                signin sign=new signin();
                
                sign.setVisible(true);
                dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void inserSignupDetailsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inserSignupDetailsKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_inserSignupDetailsKeyPressed

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
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginPage().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle inserSignupDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private app.bolivia.swing.JCTextField passtxt;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField unametxt;
    // End of variables declaration//GEN-END:variables
}
