/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author deepankumar
 */
public class ManageStudent extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    DefaultTableModel model;
    public ManageStudent() {
        
        
        initComponents();
        setStudentDetailsToTable();
    }
    public void setStudentDetailsToTable()
    {
        try
        {
            Connection con=DBconnect.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from student_details ");
            while(rs.next())
            {
                String studentid=rs.getString("student_id");
                String studentname=rs.getString("student_name");
                String course=rs.getString("course");
                String branch=rs.getString("branch");
                Object[] ob={studentid,studentname,course,branch};
                model=(DefaultTableModel)tbl_StudentDetails.getModel();
                model.addRow(ob);
            } 
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public boolean addStudent()
    {
        boolean add=false;
        String studentid=(txt_studentid.getText());
        String studentname=txt_studentname.getText();
        Object course = txt_course.getSelectedItem();
        Object branch=(txt_branch.getSelectedItem());
        try
        {
            Connection con=DBconnect.getConnection();
            String sql="insert into student_details(student_id,student_name,course,branch)values(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, studentid);
            pst.setString(2, studentname);
            pst.setString(3, (String) course);
            pst.setString(4, (String) branch);
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
    DefaultTableModel model=(DefaultTableModel) tbl_StudentDetails.getModel();
    model.setRowCount(0);
}

    public boolean update_Student()
            
    {
        boolean update=false;
        String student_id=(txt_studentid.getText());
        String student_name=txt_studentname.getText();
        Object course=txt_course.getSelectedItem();
        Object branch=(txt_branch.getSelectedItem());
        try
        {
            Connection con=DBconnect.getConnection();
            String sql="update student_details set student_name=?,course=?,branch=? where student_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, student_name);
            pst.setString(2, (String) course);
            pst.setString(3, (String) branch);
            pst.setString(4, student_id);
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
             public boolean deleteStudent()
    {
        boolean isDeleted=false;
        String student_id=(txt_studentid.getText());
        try
        {
             Connection con=DBconnect.getConnection();
            String sql="delete from student_details where student_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,student_id);
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
       String student_id=(txt_studentid.getText());
        String student_name=txt_studentname.getText();
        Object course=txt_course.getSelectedItem();
        Object branch=(txt_branch.getSelectedItem());
       if (student_id.equals(""))
       {
           JOptionPane.showMessageDialog(this, "Enter Student ID");
           return false;
       }
       if (student_name.equals(""))
       {
           JOptionPane.showMessageDialog(this, "Enter Student Name");
           return false;
       }
       if (course.equals(""))
       {
           JOptionPane.showMessageDialog(this, "Enter the Course");
           return false;
       }
       if (branch.equals(""))
       {
           JOptionPane.showMessageDialog(this, "Enter Branch");
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
        txt_studentid = new app.bolivia.swing.JCTextField();
        txt_studentname = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        addbook1 = new rojerusan.RSMaterialButtonRectangle();
        jButton1 = new javax.swing.JButton();
        txt_branch = new javax.swing.JComboBox<>();
        txt_course = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_StudentDetails = new rojerusan.RSTableMetro();
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
        jLabel2.setText(" Student Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        txt_studentid.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentid.setForeground(new java.awt.Color(204, 255, 255));
        txt_studentid.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_studentid.setPlaceholder("Enter the Student ID");
        jPanel1.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 290, -1));

        txt_studentname.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentname.setForeground(new java.awt.Color(204, 255, 255));
        txt_studentname.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_studentname.setPlaceholder("Enter The Student Name");
        txt_studentname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentnameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 290, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Student Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Course");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Branch");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, -1));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(51, 204, 0));
        rSMaterialButtonRectangle1.setText("Delete");
        rSMaterialButtonRectangle1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        rSMaterialButtonRectangle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle1MouseClicked(evt);
            }
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
        jPanel1.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 560, 120, 60));

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
        jPanel1.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, 120, 60));

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
        jPanel1.add(addbook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 120, 60));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 110, 50));

        txt_branch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MECH", "EEE", "CIVIL", "CSE", "ECE", "maths", "science", "history", "geography", "english", "tamil", "Accounts", "hotel management", "doctor", "aroSpace", " " }));
        jPanel1.add(txt_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 290, 30));

        txt_course.setBackground(new java.awt.Color(102, 102, 255));
        txt_course.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arts and Science", "Engineering", "Hotel Manangement", "Bio-Technology", "Information Technolgy", "Medical", "AeroSpace", "Meraine", "Agriculture", "MBA", "Human Resourse", "Robotics", " " }));
        jPanel1.add(txt_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 290, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download icons/icons8-course-assign-50.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, 50));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download icons/icons8-name-50.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 50));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download icons/icons8-name-tag-woman-50.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download icons/icons8-diploma-50.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, 60));

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
        jLabel11.setText("Student  Details");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        tbl_StudentDetails.setAutoCreateRowSorter(true);
        tbl_StudentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_StudentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_StudentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_StudentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_StudentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_StudentDetails.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        tbl_StudentDetails.setFuenteFilas(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        tbl_StudentDetails.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tbl_StudentDetails.setFuenteHead(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        tbl_StudentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_StudentDetails.setRowHeight(45);
        tbl_StudentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_StudentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_StudentDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 710, 250));

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

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 480, 5));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 27)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Manage Students");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, 100));

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
                    
                
        if(update_Student()==true)
                {
                    JOptionPane.showMessageDialog(this, "Student Details Updated");
                    clearTable();
            setStudentDetailsToTable();
            txt_studentid.setText("");
            txt_studentname.setText("");
            txt_course.setSelectedItem("");
            txt_branch.setSelectedItem("");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Student Details Updated Faiulre");
            }
                }
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
            System.exit(0);


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void tbl_StudentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_StudentDetailsMouseClicked
               int rowNo=tbl_StudentDetails.getSelectedRow();
               TableModel model=tbl_StudentDetails.getModel();
        txt_studentid.setText(model.getValueAt(rowNo,0).toString());
        txt_studentname.setText(model.getValueAt(rowNo,1).toString());
        txt_course.setSelectedItem(model.getValueAt(rowNo,2).toString());
        txt_branch.setSelectedItem(model.getValueAt(rowNo,3).toString());



        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_StudentDetailsMouseClicked

    private void txt_studentnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameActionPerformed

    private void addbook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbook1ActionPerformed
        // TODO add your handling code here:
        if(validateadd()==true)
        {
        if(addStudent()==true)
        {
            JOptionPane.showMessageDialog(this, "Student Added sucessfully");
            clearTable();
            setStudentDetailsToTable();
        }
       else
                {
                    JOptionPane.showMessageDialog(this, "Student id Already Exits");
                }
        
        }
    }//GEN-LAST:event_addbook1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         txt_studentid.setText("");
         txt_studentname.setText("");
         txt_course.setSelectedItem("");
         txt_branch.setSelectedItem("");
      
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
                        if(validateadd()==true)
                        {
                            
                        
                    if(deleteStudent())
                    {
                        JOptionPane.showMessageDialog(this, "Student Deleted sucessfully");
                        clearTable();
            setStudentDetailsToTable();
                    }
                    else
                    {
                     JOptionPane.showMessageDialog(this, "Student Deleted Failure");  
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

    private void rSMaterialButtonRectangle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle1MouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle addbook1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSTableMetro tbl_StudentDetails;
    private javax.swing.JComboBox<String> txt_branch;
    private javax.swing.JComboBox<String> txt_course;
    private app.bolivia.swing.JCTextField txt_studentid;
    private app.bolivia.swing.JCTextField txt_studentname;
    // End of variables declaration//GEN-END:variables
}
