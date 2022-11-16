/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author deepankumar
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    public void getstudentDetails()
    {
        int student_id=Integer.parseInt(txt_studentid.getText());
        try
        {
            Connection con=DBconnect.getConnection();
            //String sql="select* from student_details where student_id=?";
            PreparedStatement pst=con.prepareStatement("select* from student_details where student_id=?");
            pst.setInt(1, student_id);
            ResultSet r=pst.executeQuery();
            if(r.next())
            {
                lbl_studenterror.setText("");
                lbl_studentid.setText(r.getString("student_id"));
                 lbl_studentname.setText(r.getString("student_name"));
                  lbl_course.setText(r.getString("course"));
                   lbl_branch.setText(r.getString("branch"));
            }
             else
                {
                    lbl_studenterror.setText("Invalid Student Id !!");
                    txt_studentid.setText("");
                    lbl_studentid.setText("");
                 lbl_studentname.setText("");
                  lbl_course.setText("");
                   lbl_branch.setText("");
                }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void getbookDetails()
    {
        int book_id=Integer.parseInt(txt_bookid.getText());
        try
        {
            Connection con=DBconnect.getConnection();
            //String sql="select* from student_details where student_id=?";
            PreparedStatement pst=con.prepareStatement("select* from book_details where book_id=?");
            pst.setInt(1, book_id);
            ResultSet r=pst.executeQuery();
            if(r.next())
            {
                lbl_bookid.setText(r.getString("book_id"));
                 lbl_bookname.setText(r.getString("book_name"));
                  lbl_author.setText(r.getString("author"));
                   lbl_quantity.setText(r.getString("quantity"));
                   lbl_bookerror.setText("");
            }
            else
               {
                   lbl_bookerror.setText("Invalid Book Id !!");
                   txt_bookid.setText("");
                   lbl_bookid.setText("");
                 lbl_bookname.setText("");
                  lbl_author.setText("");
                   lbl_quantity.setText("");
               }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    public boolean issue_book()
    {
        boolean issue=false;
       int book_id=Integer.parseInt(txt_bookid.getText());
       int student_id=Integer.parseInt(txt_studentid.getText());
       String book_name=lbl_bookname.getText();
       String student_name=lbl_studentname.getText();
        java.util.Date uissueDate=txt_issuedate.getDatoFecha();
        java.util.Date uDuedate=txt_duedate.getDatoFecha();
        
        long l1=uissueDate.getTime();
        long l2=uDuedate.getTime();
        
       java.sql.Date sissueDate=new java.sql.Date(l1);
       java.sql.Date sDueDate=new java.sql.Date(l2);
       
       try
       {
           Connection con=DBconnect.getConnection();
           String sql="insert into issuebook_details(book_id,student_id,book_name,student_name,issue_date,due_date,status)values(?,?,?,?,?,?,?)";
           PreparedStatement pst=con.prepareStatement(sql);
               pst.setInt(1, book_id);
               pst.setInt(2, student_id);
               pst.setString(3, book_name);
               pst.setString(4, student_name);
               pst.setDate(5, sissueDate);
               pst.setDate(6, sDueDate);
               pst.setString(7, "pending");
           int rs=pst.executeUpdate();
           if(rs>0)
           {
               issue=true;
           
           }
           else
           {
               issue=false;
           }
       }catch(SQLException e)
       {
           System.out.println(e);
       }
           return issue;
    }
    public void updatecount()
    {
       
      
      int book_id=Integer.parseInt(txt_bookid.getText());
       try
       {
           Connection con=DBconnect.getConnection();
           String sql="update book_details set quantity=quantity-1 where book_id=?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setInt(1, book_id);
           int rc=pst.executeUpdate();
           if(rc>0)
           {
               JOptionPane.showMessageDialog(this, "Book Count Updated");
               int count=Integer.parseInt(lbl_quantity.getText());
               lbl_quantity.setText(Integer.toString(count-1));
               
           }
           else
           {
               JOptionPane.showMessageDialog(this,"Update Book count failure");
           }
           
       }catch(Exception e)
       {
           System.out.println(e);
       }
    }
    public boolean validateissuebook()
    {
        boolean validate=false;
        int book_id=Integer.parseInt(txt_bookid.getText());
       int student_id=Integer.parseInt(txt_studentid.getText());
       try
       {
           
           Connection con =DBconnect.getConnection();
           String sql="select*from issuebook_details where book_id=?and student_id=?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setInt(1, book_id);
           pst.setInt(2, student_id);
           ResultSet rs=pst.executeQuery();
           if(rs.next())
           {
               validate=true;
           }
           else
           {
               validate=false;
           }
       }catch(Exception e)
       {
           System.out.println();
       }
       return validate;
        
    }        
  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_quantity = new app.bolivia.swing.JCTextField();
        lbl_bookid = new app.bolivia.swing.JCTextField();
        lbl_author = new app.bolivia.swing.JCTextField();
        lbl_bookname = new app.bolivia.swing.JCTextField();
        lbl_bookerror = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lbl_branch = new app.bolivia.swing.JCTextField();
        lbl_studentid = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_course = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_studentname = new app.bolivia.swing.JCTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbl_studenterror = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        txt_bookid = new app.bolivia.swing.JCTextField();
        txt_duedate = new rojeru_san.componentes.RSDateChooser();
        txt_issuedate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_panel.setBackground(new java.awt.Color(255, 153, 102));
        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download icons/icons8-book-70.png"))); // NOI18N
        jLabel13.setText("Manage Books");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 260, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Book Id :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Book Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Author Name:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Quantity :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, -1, -1));

        lbl_quantity.setEditable(false);
        lbl_quantity.setBackground(new java.awt.Color(102, 102, 255));
        lbl_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        lbl_quantity.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_quantityActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 260, -1));

        lbl_bookid.setEditable(false);
        lbl_bookid.setBackground(new java.awt.Color(102, 102, 255));
        lbl_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        lbl_bookid.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_bookidActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 260, -1));

        lbl_author.setEditable(false);
        lbl_author.setBackground(new java.awt.Color(102, 102, 255));
        lbl_author.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        lbl_author.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_authorActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 260, -1));

        lbl_bookname.setEditable(false);
        lbl_bookname.setBackground(new java.awt.Color(102, 102, 255));
        lbl_bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        lbl_bookname.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_bookname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_booknameActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 260, -1));

        lbl_bookerror.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_bookerror.setForeground(new java.awt.Color(51, 0, 102));
        jPanel1.add(lbl_bookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, -1, 20));

        main_panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 325, 650));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download icons/icons8-mortarboard-70.png"))); // NOI18N
        jLabel12.setText("Manage Students");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 50));

        lbl_branch.setEditable(false);
        lbl_branch.setBackground(new java.awt.Color(255, 51, 51));
        lbl_branch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        lbl_branch.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_branchActionPerformed(evt);
            }
        });
        jPanel2.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 260, 30));

        lbl_studentid.setEditable(false);
        lbl_studentid.setBackground(new java.awt.Color(255, 51, 51));
        lbl_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        lbl_studentid.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_studentidActionPerformed(evt);
            }
        });
        jPanel2.add(lbl_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 260, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download icons/icons8-name-tag-woman-50.png"))); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 255, 255));
        jLabel15.setText("Course:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, 20));

        lbl_course.setEditable(false);
        lbl_course.setBackground(new java.awt.Color(255, 51, 51));
        lbl_course.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        lbl_course.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_courseActionPerformed(evt);
            }
        });
        jPanel2.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 260, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download icons/icons8-diploma-50.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, 60));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Student Id :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, 20));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download icons/icons8-course-assign-50.png"))); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, 50));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 255, 255));
        jLabel17.setText("Student Name :");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, 20));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download icons/icons8-name-50.png"))); // NOI18N
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, 50));

        lbl_studentname.setEditable(false);
        lbl_studentname.setBackground(new java.awt.Color(255, 51, 51));
        lbl_studentname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        lbl_studentname.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_studentname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_studentnameActionPerformed(evt);
            }
        });
        jPanel2.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 260, -1));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel30.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 255, 255));
        jLabel30.setText("Branch :");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, -1, 20));

        lbl_studenterror.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_studenterror.setForeground(new java.awt.Color(0, 0, 102));
        jPanel2.add(lbl_studenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, -1, 20));

        main_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 325, 650));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 480, 5));

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 27)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("Manage Books");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 480, 5));

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 27)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setText("Manage Books");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8 icons/icons8-close-window-64.png"))); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 600, 650));

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 51));
        jLabel26.setText("Due Date :");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, -1));

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 51, 51));
        jLabel27.setText("Book Id :");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 51, 51));
        jLabel28.setText("Student Id :");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 51, 51));
        jLabel29.setText("Issue Date :");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 51, 51)));
        txt_studentid.setForeground(new java.awt.Color(255, 51, 51));
        txt_studentid.setDisabledTextColor(new java.awt.Color(255, 51, 51));
        txt_studentid.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txt_studentid.setPlaceholder("Enter Due Date.....");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        jPanel4.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 360, -1));

        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 51, 51)));
        txt_bookid.setForeground(new java.awt.Color(255, 51, 51));
        txt_bookid.setCaretColor(new java.awt.Color(255, 51, 51));
        txt_bookid.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txt_bookid.setPlaceholder("Enter Book Id..........");
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        jPanel4.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 360, -1));

        txt_duedate.setColorBackground(new java.awt.Color(255, 51, 51));
        txt_duedate.setColorButtonHover(new java.awt.Color(255, 255, 255));
        txt_duedate.setColorForeground(new java.awt.Color(255, 51, 51));
        txt_duedate.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txt_duedate.setPlaceholder("Select Due date");
        jPanel4.add(txt_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 360, -1));

        txt_issuedate.setToolTipText("");
        txt_issuedate.setColorBackground(new java.awt.Color(255, 51, 51));
        txt_issuedate.setColorButtonHover(new java.awt.Color(204, 51, 0));
        txt_issuedate.setColorForeground(new java.awt.Color(255, 51, 51));
        txt_issuedate.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txt_issuedate.setPlaceholder("Select Issue date");
        jPanel4.add(txt_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 360, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("Issue Book");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel4.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 380, 80));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8 icons/icons8-close-window-64.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        main_panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 600, -1));

        getContentPane().add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        setSize(new java.awt.Dimension(1250, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
       if(txt_bookid.getText()!=null && txt_studentid.getText()!=null && txt_issuedate.getDatoFecha()!=null && txt_duedate.getDatoFecha()!=null )
       {
        if(validateissuebook()==false)
        {
                
            if(issue_book()==true)
            {
                JOptionPane.showMessageDialog(this, "Issue Details Updated ");
                updatecount();

            }
            else
            {
                JOptionPane.showMessageDialog(this, "Issue Details Updated Failure");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Student have already this book");
        }
       }
       else
       {
           JOptionPane.showMessageDialog(this, "Enter All Fields !");
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
        if(!txt_bookid.getText().equals(""))
        {
            getbookDetails();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
        if(!txt_studentid.getText().equals(""))
        {
            getstudentDetails();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidFocusLost

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lbl_studentnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_studentnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentnameActionPerformed

    private void lbl_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_courseActionPerformed

    private void lbl_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentidActionPerformed

    private void lbl_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_branchActionPerformed

    private void lbl_booknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_booknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_booknameActionPerformed

    private void lbl_authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_authorActionPerformed

    private void lbl_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookidActionPerformed

    private void lbl_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_quantityActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
                System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked
    
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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private app.bolivia.swing.JCTextField lbl_author;
    private javax.swing.JLabel lbl_bookerror;
    private app.bolivia.swing.JCTextField lbl_bookid;
    private app.bolivia.swing.JCTextField lbl_bookname;
    private app.bolivia.swing.JCTextField lbl_branch;
    private app.bolivia.swing.JCTextField lbl_course;
    private app.bolivia.swing.JCTextField lbl_quantity;
    private javax.swing.JLabel lbl_studenterror;
    private app.bolivia.swing.JCTextField lbl_studentid;
    private app.bolivia.swing.JCTextField lbl_studentname;
    private javax.swing.JPanel main_panel;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_bookid;
    private rojeru_san.componentes.RSDateChooser txt_duedate;
    private rojeru_san.componentes.RSDateChooser txt_issuedate;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}
