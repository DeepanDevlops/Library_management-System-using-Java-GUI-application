/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Color;
/**
 *
 * @author deepankumar
 */
public class ManageBooks extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    DefaultTableModel model;
    public ManageBooks() {
        
        
        initComponents();
        setBookDetailsToTable();
    }
    public void setBookDetailsToTable()
    {
        try
        {
            Connection con=DBconnect.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from book_details ");
            while(rs.next())
            {
                String Bookid=rs.getString("Book_id");
                String Bookname=rs.getString("Book_name");
                String Author=rs.getString("author");
                String Qty=rs.getString("quantity");
                Object[] ob={Bookid,Bookname,Author,Qty};
                model=(DefaultTableModel)tbl_bookDetails.getModel();
                model.addRow(ob);
            } 
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public boolean addbook()
    {
        boolean add=false;
        int bookid=Integer.parseInt(txt_bookid.getText());
        String bookname=txt_bookname.getText();
        String author=txt_author.getText();
        int qty=Integer.parseInt(txt_quantity.getText());
        try
        {
            Connection con=DBconnect.getConnection();
            String sql="insert into book_details(book_id,book_name,author,quantity) values(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookid);
            pst.setString(2, bookname);
            pst.setString(3, author);
            pst.setInt(4, qty);
            int rc=pst.executeUpdate();
            if(rc>0)
            {
               add=true; 
            }
            else
            {
                add=false;
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return add;
    }
    public void clearTable()
{
    DefaultTableModel model=(DefaultTableModel) tbl_bookDetails.getModel();
    model.setRowCount(0);
}

    public boolean update_book()
            
    {
        boolean update=false;
        int book_id=Integer.parseInt(txt_bookid.getText());
        String book_name=txt_bookname.getText();
        String author=txt_author.getText();
        int quantity=Integer.parseInt(txt_quantity.getText());
        try
        {
            Connection con=DBconnect.getConnection();
            String sql="update book_details set book_name=?,author=?,quantity=? where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, book_name);
            pst.setString(2, author);
            pst.setInt(3, quantity);
            pst.setInt(4, book_id);
            int rc=pst.executeUpdate();
            if(rc>0)
            {
                update=true;
                
            }
            else
            {
                update=false;
            }
            
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return update;
        
    }
             public boolean deleteBook()
    {
        boolean isDeleted=false;
        int book_id=Integer.parseInt(txt_bookid.getText());
        try
        {
             Connection con=DBconnect.getConnection();
            String sql="delete from book_details where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,book_id);
            int rowCount=pst.executeUpdate();
            if(rowCount>0)
            {
                isDeleted=true;
            }
            else
            {
                isDeleted=false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return isDeleted;
    }
             
   public boolean validateadd()
           
   {
        String book_id=txt_bookid.getText();
        String book_name=txt_bookname.getText();
        String author=txt_author.getText();
        String quantity=txt_quantity.getText();
       if (book_id.equals(""))
       {
           JOptionPane.showMessageDialog(this, "Enter Book ID");
           return false;
       }
       if (book_name.equals(""))
       {
           JOptionPane.showMessageDialog(this, "Enter Book Name");
           return false;
       }
       if (author.equals(""))
       {
           JOptionPane.showMessageDialog(this, "Enter Author Name");
           return false;
       }
       if (quantity.equals(""))
       {
           JOptionPane.showMessageDialog(this, "Enter Quantity");
           return false;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_bookid = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_bookname = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_author = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_quantity = new app.bolivia.swing.JCTextField();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        addbook1 = new rojerusan.RSMaterialButtonRectangle();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojerusan.RSTableMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Book Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        txt_bookid.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookid.setForeground(new java.awt.Color(204, 255, 255));
        txt_bookid.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_bookid.setPlaceholder("Enter  Book ID");
        txt_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookidActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 290, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        txt_bookname.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookname.setForeground(new java.awt.Color(204, 255, 255));
        txt_bookname.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_bookname.setPlaceholder("Enter  Book Name");
        txt_bookname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_booknameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 290, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Book Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        txt_author.setBackground(new java.awt.Color(102, 102, 255));
        txt_author.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_author.setForeground(new java.awt.Color(204, 255, 255));
        txt_author.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_author.setPlaceholder("Enter  Author Name");
        jPanel1.add(txt_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 290, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Author Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Quantity ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        txt_quantity.setBackground(new java.awt.Color(102, 102, 255));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_quantity.setForeground(new java.awt.Color(204, 255, 255));
        txt_quantity.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_quantity.setPlaceholder("Enter  Quantity");
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 290, -1));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(51, 204, 0));
        rSMaterialButtonRectangle1.setText("Delete");
        rSMaterialButtonRectangle1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        rSMaterialButtonRectangle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle1MouseExited(evt);
            }
        });
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 560, 120, -1));

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(51, 204, 0));
        rSMaterialButtonRectangle3.setText("Update");
        rSMaterialButtonRectangle3.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        rSMaterialButtonRectangle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle3MouseExited(evt);
            }
        });
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, 120, -1));

        addbook1.setBackground(new java.awt.Color(51, 204, 0));
        addbook1.setText("Add");
        addbook1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        addbook1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addbook1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addbook1MouseExited(evt);
            }
        });
        addbook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbook1ActionPerformed(evt);
            }
        });
        jPanel1.add(addbook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 120, -1));

        jButton1.setBackground(new java.awt.Color(255, 102, 51));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 110, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 650));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8 icons/icons8-close-window-64.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 0, 60, 60));

        jLabel11.setBackground(new java.awt.Color(102, 102, 102));
        jLabel11.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel11.setText("Books Details");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        tbl_bookDetails.setAutoCreateRowSorter(true);
        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Qty"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookDetails.setRowHeight(45);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 680, 280));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 480, 5));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 27)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Manage Books");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 770, 650));

        setSize(new java.awt.Dimension(1250, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
                HomePage home=new HomePage();
                home.setVisible(true);
                dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
        if(validateadd()==true)
        {
        if(update_book()==true)
                {
                    JOptionPane.showMessageDialog(this, "Book Details Updated");
                    clearTable();
            setBookDetailsToTable();
            txt_bookid.setText("");
            txt_bookname.setText("");
            txt_author.setText("");
            txt_quantity.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Book Details Updated Faiulre");
            }
        }
                
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
            System.exit(0);


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
               int rowNo=tbl_bookDetails.getSelectedRow();
               TableModel model=tbl_bookDetails.getModel();
        txt_bookid.setText(model.getValueAt(rowNo,0).toString());
        txt_bookname.setText(model.getValueAt(rowNo,1).toString());
        txt_author.setText(model.getValueAt(rowNo,2).toString());
        txt_quantity.setText(model.getValueAt(rowNo,3).toString());



        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void txt_booknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_booknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_booknameActionPerformed

    private void addbook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbook1ActionPerformed
        // TODO add your handling code here:
        if(validateadd()==true)
        {
        if(addbook()==true)
        {
            JOptionPane.showMessageDialog(this, "Book Added sucessfully");
            clearTable();
             setBookDetailsToTable();
        }
       else
                {
                    JOptionPane.showMessageDialog(this, "Book Added Fauiler");
                }
        
        }
    }//GEN-LAST:event_addbook1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         txt_bookid.setText("");
         txt_bookname.setText("");
         txt_author.setText("");
         txt_quantity.setText("");
      
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed

        if(validateadd()==true)
        {
                    if(deleteBook())
                    {
                        JOptionPane.showMessageDialog(this, "Book Deleted sucessfully");
                        clearTable();
            setBookDetailsToTable();
                    }
                    else
                    {
                     JOptionPane.showMessageDialog(this, "Book Deleted Failure");  
                    }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void addbook1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbook1MouseEntered
Color c=new Color(51,51,51);
addbook1.setBackground(c);
        // TODO add your handling code here:
    }//GEN-LAST:event_addbook1MouseEntered

    private void addbook1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbook1MouseExited
                Color c=new Color(255,51,51);
                  addbook1.setBackground(c);
        // TODO add your handling code here:
    }//GEN-LAST:event_addbook1MouseExited

    private void rSMaterialButtonRectangle3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3MouseEntered
            Color c=new Color(51,51,51);
                rSMaterialButtonRectangle3.setBackground(c);
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3MouseEntered

    private void rSMaterialButtonRectangle3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3MouseExited
                    Color c=new Color(255,51,51);
                  rSMaterialButtonRectangle3.setBackground(c);
            // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3MouseExited

    private void rSMaterialButtonRectangle1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1MouseEntered
         Color c=new Color(51,51,51);
                rSMaterialButtonRectangle1.setBackground(c);
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle1MouseEntered

    private void rSMaterialButtonRectangle1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1MouseExited
      Color c=new Color(255,51,51);
                  rSMaterialButtonRectangle1.setBackground(c);
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle1MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
      Color c=new Color(51,51,51);
               jButton1.setBackground(c);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
                Color c=new Color(255,51,51);
                  jButton1.setBackground(c);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseExited

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle addbook1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_author;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_bookname;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
