/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dqlsv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hien
 */
public class fr_QLSV extends javax.swing.JFrame {
        private int flag = 0;
        Connect_QLSV con;
    /**
     * Creates new form fr_QLSV
     */
    public fr_QLSV() {
        initComponents();
        con = new Connect_QLSV();
        showData();
    }
    //Hàm xóa text
    public void clearText(){
        txtMasv.setText("");
        txtHoTen.setText("");
        txtNgaySinh.setText("");
        txtGioiTinh.setText("");
        txtDiaChi.setText("");
        txtMaLop.setText("");
        
    }
     //Lấy thông tin dữ liệu được chọn
     public void getSelectData(){
         int SelectedRow = TbSinhVien.getSelectedRow();
         
         txtMasv.setText(TbSinhVien.getValueAt(SelectedRow,0).toString());
         txtHoTen.setText(TbSinhVien.getValueAt(SelectedRow,1).toString());
         txtGioiTinh.setText(TbSinhVien.getValueAt(SelectedRow,2).toString());
         txtNgaySinh.setText(TbSinhVien.getValueAt(SelectedRow,3).toString());        
         txtDiaChi.setText(TbSinhVien.getValueAt(SelectedRow,4).toString());
         txtMaLop.setText(TbSinhVien.getValueAt(SelectedRow,5).toString());
     }
     public  void showData() {
        String[] columnNames = {"Mã Sinh viên","Họ và Tên","Giới Tính","Ngày Sinh","Nơi Sinh","Mã Lớp"};
         //Đối tượng này đẻ chứa dữ liệu từ sql vào jtable
        DefaultTableModel model = new DefaultTableModel();
       
        model.setColumnIdentifiers(columnNames);
        
        TbSinhVien.setModel(model);
        String MASV = "";
        String HOTENSV = "";
        String GIOITINH = "";
        String NGAYSINH = "";
        String NOISINH = "";
        String MALOP = "";
        
        ResultSet rs = con.getdata("Select * From SINHVIEN");
        
        try {
            while (rs.next()) {
                MASV= rs.getString("MASV");
                HOTENSV = rs.getString("HOTENSV");
                GIOITINH = rs.getString("GIOITINH");
                NGAYSINH = rs.getString("NGAYSINH");               
                NOISINH = rs.getString("NOISINH");
                MALOP = rs.getString("MALOP");
                
                model.addRow(new Object[] {MASV,HOTENSV,GIOITINH,NGAYSINH,NOISINH,MALOP});
            }
        } catch (SQLException ex) {
            Logger.getLogger(fr_QLSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     //Thục hiện Insert
    public void InsertData(){        
        String []StringSQL = {txtMasv.getText().toString(),txtHoTen.getText().toString(),txtGioiTinh.getText().toString(),txtNgaySinh.getText().toString(),txtDiaChi.getText().toString(),txtMaLop.getText().toString()};
        int isInsert = con.ExcuteSQLInsert(StringSQL);
        if (isInsert > 0) {
            JOptionPane.showMessageDialog(this,"Bạn đã thêm dữ liệu thành công!");
        }
        else{
            JOptionPane.showMessageDialog(this,"Bạn chưa thêm được dữ liệu!");
        }
        showData();
        clearText();
    }
    //thực hiện Update
     public void UpdateData(){
        String []StringSQL = {txtHoTen.getText().toString(),txtGioiTinh.getText().toString(),txtNgaySinh.getText().toString(),txtDiaChi.getText().toString(),txtMaLop.getText().toString(),txtMasv.getText().toString()};
        int isUpdate = con.ExcuteSQLUpdate(StringSQL);
        if (isUpdate > 0) {
            JOptionPane.showMessageDialog(this,"Bạn đã sửa dữ liệu thành công!");
        }
        else{
            JOptionPane.showMessageDialog(this,"Bạn chưa sửa được dữ liệu!");
        }
        showData();
        clearText();
    }
     
     //Thực hiện delete
      public void DeleteData(){
        String []StringSQL = {txtMasv.getText().toString()};
        int isDelete = con.ExcuteSQLDelete(StringSQL);
        if (isDelete > 0) {
            JOptionPane.showMessageDialog(this,"Bạn đã xóa dữ liệu thành công!");
        }
        else{
            JOptionPane.showMessageDialog(this,"Bạn chưa xóa được dữ liệu!");
        }
        showData();
        clearText();
    }
    public void TimMsv(){
        String[] columnNames = {"Mã SV","Họ và Tên","Giới Tính","Ngày Sinh","Nơi Sinh","Mã Lớp"};;
         //Đối tượng này đẻ chứa dữ liệu từ sql vào jtable
        DefaultTableModel model = new DefaultTableModel();
       
        model.setColumnIdentifiers(columnNames);
        
        TbSinhVien.setModel(model);
        String MASV = "";
        String HOTENSV = "";
        String GIOITINH = "";
        String NGAYSINH = "";
        String NOISINH = "";
        String MALOP = "";
        
        ResultSet rs = con.getdata("Select * From SINHVIEN where MASV ='" + txtTimMaSv.getText() + "'");
        try {
            while (rs.next()) {
                MASV= rs.getString("MASV");
                HOTENSV = rs.getString("HOTENSV");
                GIOITINH = rs.getString("GIOITINH");
                NGAYSINH = rs.getString("NGAYSINH");               
                NOISINH = rs.getString("NOISINH");
                MALOP = rs.getString("MALOP");
                
                model.addRow(new Object[] {MASV,HOTENSV,GIOITINH,NGAYSINH,NOISINH,MALOP});
            }
        } catch (SQLException ex) {
            Logger.getLogger(fr_QLSV.class.getName()).log(Level.SEVERE, null, ex);
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

        btnXoa = new javax.swing.JButton();
        txtNgaySinh = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        txtGioiTinh = new javax.swing.JTextField();
        btnThoat = new javax.swing.JButton();
        txtDiaChi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbSinhVien = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        txtMasv = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        txtHoTen = new javax.swing.JTextField();
        btnTimKiemMaSv = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTimMaSv = new javax.swing.JTextField();
        btnDanhSach = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setEnabled(false);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        txtGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã SV");

        txtMaLop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Họ và Tên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ngày Sinh");

        TbSinhVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TbSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sinh Viên", "Họ và Tên", "Giới Tính", "Ngày Sinh", "Nơi Sinh", "Mã Lớp"
            }
        ));
        TbSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbSinhVien);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Giới Tính");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Địa Chỉ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Thông tin quản lý sinh viên");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Mã Lớp");

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txtMasv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSua.setText("Sửa ");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnTimKiemMaSv.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTimKiemMaSv.setText("Tìm Kiếm");
        btnTimKiemMaSv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemMaSvActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tìm Mã SV");

        txtTimMaSv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnDanhSach.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDanhSach.setText("Hủy");
        btnDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtMasv, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtTimMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(1, 1, 1)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(btnThem)
                                        .addGap(52, 52, 52)
                                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnThoat)
                                                    .addGap(29, 29, 29))
                                                .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(32, 32, 32)
                                                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTimKiemMaSv)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(jLabel1)))
                        .addGap(72, 72, 72)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtMasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTimMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemMaSv)
                    .addComponent(btnDanhSach))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnThoat)
                    .addComponent(btnLuu)
                    .addComponent(btnSua))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        btnLuu.setEnabled(true);
        flag = 3;
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if (flag == 1) {
            InsertData();          
            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
            
            
        }
        else if(flag == 2){
            UpdateData();
            
            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }
        else{
            DeleteData();
            
            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }
        clearText();
        btnLuu.setEnabled(false);

    }//GEN-LAST:event_btnLuuActionPerformed

    private void TbSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbSinhVienMouseClicked
        getSelectData();
    }//GEN-LAST:event_TbSinhVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        clearText();
        btnLuu.setEnabled(true);
        flag = 1;
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        btnLuu.setEnabled(true);
        flag = 2;
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        dispose(); 
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnTimKiemMaSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemMaSvActionPerformed
        TimMsv();
    }//GEN-LAST:event_btnTimKiemMaSvActionPerformed

    private void btnDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachActionPerformed
        showData();
    }//GEN-LAST:event_btnDanhSachActionPerformed

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
            java.util.logging.Logger.getLogger(fr_QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fr_QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fr_QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fr_QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fr_QLSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbSinhVien;
    private javax.swing.JButton btnDanhSach;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiemMaSv;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtMasv;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTimMaSv;
    // End of variables declaration//GEN-END:variables
}
