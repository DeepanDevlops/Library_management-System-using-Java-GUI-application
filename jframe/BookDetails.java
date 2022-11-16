/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deepankumar
 */
public class BookDetails extends javax.swing.JFrame {

    /**
     * Creates new form BookDetails
     */
    DefaultTableModel model;
    public BookDetails() {
        initComponents();
        bookrecord();
    }
     public void bookrecord()
    {
        try{
          Connection con=DBconnect.getConnection();
          String sql="select * from issuebook_details";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                String issueid=rs.getString("id");
                String Bookname=rs.getString("Book_name");
                String studentname=rs.getString("student_name");
                String issuedate=rs.getString("issue_date");
                String duedate=rs.getString("due_date");
                String status=rs.getString("status");
                Object[] ob={issueid,Bookname,studentname,issuedate,duedate,status};
                model=(DefaultTableModel)tbl_issuebook.getModel();
                model.addRow(ob);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
     
       /** public boolean validatetable()
        {
            java.util.Date uissueDate=txt_issuedate.getDatoFecha();
        java.util.Date uDuedate=txt_duedate.getDatoFecha();
            
            if(uissueDate)
            {
                JOptionPane.showMessageDialog(this,"ENTER THE ISSUE DATE");
                return false;
            }
            if(uDuedate.equals(""))
            {
              JOptionPane.showMessageDialog(this,"ENTER THE DUE DATE"); 
              return false;
            }
                
              return true;  
        }**/
        public void search()
        {
            
            java.util.Date uissueDate=txt_issuedate.getDatoFecha();
        java.util.Date uDuedate=txt_duedate.getDatoFecha();
        
        long l1=uissueDate.getTime();
        long l2=uDuedate.getTime();
        
       java.sql.Date sissueDate=new java.sql.Date(l1);
       java.sql.Date sDueDate=new java.sql.Date(l2);
       
           
       
       try
       {
           Connection con=DBconnect.getConnection();
           String sql="select * from issuebook_details where issue_date BETWEEN ? and ?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setDate(1, sissueDate);
           pst.setDate(2, sDueDate);
           ResultSet rs=pst.executeQuery();
          if(rs.next()==false)
              
          {
              JOptionPane.showMessageDialog(this, "No Record Find");
          }
          else
          {
            while(rs.next())
           {
               
                   String issueid=rs.getString("id");
                String Bookname=rs.getString("Book_name");
                String studentname=rs.getString("student_name");
                String issuedate=rs.getString("issue_date");
                String duedate=rs.getString("due_date");
                String status=rs.getString("status");
                Object[] ob={issueid,Bookname,studentname,issuedate,duedate,status};
                model=(DefaultTableModel)tbl_issuebook.getModel();
                model.addRow(ob);
           }
             
          }
           
       }catch(Exception e)
       {
           System.out.println(e);
       }
        
        }
       
        
         public void clearTable()
{
    DefaultTableModel model=(DefaultTableModel) tbl_issuebook.getModel();
    model.setRowCount(0);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_issuedate = new rojeru_san.componentes.RSDateChooser();
        jLabel29 = new javax.swing.JLabel();
        txt_duedate = new rojeru_san.componentes.RSDateChooser();
        jLabel26 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issuebook = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Issue Books Details");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 480, 5));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 110, 100));

        txt_issuedate.setToolTipText("");
        txt_issuedate.setColorBackground(new java.awt.Color(255, 51, 51));
        txt_issuedate.setColorButtonHover(new java.awt.Color(204, 51, 0));
        txt_issuedate.setColorForeground(new java.awt.Color(255, 51, 51));
        txt_issuedate.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txt_issuedate.setPlaceholder("Select Issue date");
        jPanel2.add(txt_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 300, -1));

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel29.setText("Issue Date :");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 140, -1));

        txt_duedate.setColorBackground(new java.awt.Color(255, 51, 51));
        txt_duedate.setColorButtonHover(new java.awt.Color(255, 255, 255));
        txt_duedate.setColorForeground(new java.awt.Color(255, 51, 51));
        txt_duedate.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txt_duedate.setPlaceholder("Select Due date");
        jPanel2.add(txt_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 320, -1));

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel26.setText("Due Date :");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle1.setText("SEARCH");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 160, 140, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle3.setText("All");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 160, 130, 70));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel3.setText("Back");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8 icons/icons8-close-window-64.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 270));

        tbl_issuebook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISSUE ID", "BOOK NAME", "STUDENT NAME", "ISSUE DATE", "DUE DATE", "STATUS"
            }
        ));
        tbl_issuebook.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_issuebook.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_issuebook.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_issuebook.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_issuebook.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        tbl_issuebook.setFuenteFilas(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        tbl_issuebook.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tbl_issuebook.setFuenteHead(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        tbl_issuebook.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_issuebook.setRowHeight(45);
        jScrollPane2.setViewportView(tbl_issuebook);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 1180, 300));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        setSize(new java.awt.Dimension(1250, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if(txt_issuedate.getDatoFecha()!=null && txt_duedate.getDatoFecha()!=null)
        {
               clearTable();
                 search();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Please enter the dates");
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
              clearTable();
               bookrecord();
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSTableMetro tbl_issuebook;
    private rojeru_san.componentes.RSDateChooser txt_duedate;
    private rojeru_san.componentes.RSDateChooser txt_issuedate;
    // End of variables declaration//GEN-END:variables
}
