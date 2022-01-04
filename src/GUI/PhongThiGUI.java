/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.CaThiBLL;
import BLL.KhoaThiBLL;
import BLL.PhongThiBLL;
import DTO.CaThiDTO;
import DTO.KhoaThiDTO;
import DTO.PhongThiDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAI HUONG
 */
public class PhongThiGUI extends javax.swing.JPanel {

    /**
     * Creates new form PhongThiGUI
     */
    DefaultTableModel table;
    private ArrayList<CaThiDTO> arrayCa;
    public PhongThiGUI() throws Exception {
        initComponents();
        hienThiDuLieuCaThi();
        hienThiDuLieuKhoaThi();
        doDuLieuLenBang();
        txtmpt.setEnabled(false);
        txttpt.setEnabled(false);
    }
    
    public void hienThiDuLieuCaThi() throws Exception
    {
        ArrayList<CaThiDTO> arr = new ArrayList<CaThiDTO>();
	 CaThiBLL loaiBLL = new CaThiBLL();
	 arr = loaiBLL.getAllL_Hang();	 
	 CaThiDTO loaiDTO = new CaThiDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 loaiDTO = arr.get(i);
		 cb1.addItem(loaiDTO.getCathiid()+"");		 
	 }
    }
    
    public void hienThiDuLieuKhoaThi() throws Exception
    {
        ArrayList<KhoaThiDTO> arr = new ArrayList<KhoaThiDTO>();
	 KhoaThiBLL loaiBLL = new KhoaThiBLL();
	 arr = loaiBLL.getAllL_Hang();	 
	 KhoaThiDTO loaiDTO = new KhoaThiDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 loaiDTO = arr.get(i);
		 cb2.addItem(loaiDTO.getKhoathiid()+"-"+loaiDTO.getTenkhoathi());		 
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmpt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttpt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cb2 = new javax.swing.JComboBox<>();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cb3 = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("PHÒNG THI");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mã Phòng Thi:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tên phòng thi:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Ca thi:");

        cb1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn mã ca" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Khóa thi:");

        cb2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn khóa thi" }));

        btnthem.setBackground(new java.awt.Color(153, 255, 255));
        btnthem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnthemMouseClicked(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(153, 255, 255));
        btnxoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnxoaMouseClicked(evt);
            }
        });

        jt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Phòng thi", "Tên Phòng thi", "Ca Thi", "Khóa thi", "Trình độ"
            }
        ));
        jt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Trình độ:");

        cb3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn trình độ", "A2", "B1" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmpt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttpt)
                            .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtmpt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txttpt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(cb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel1)
                .addContainerGap(392, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void setTextFields(String toString, String toString0, String toString1,String toString2,String toString3) {
        txtmpt.setText(toString);
        txttpt.setText(toString0);
        cb1.setSelectedItem(toString1);
        cb2.setSelectedItem(toString2);
        cb3.setSelectedItem(toString3);
    }

    public void doDuLieuLenBang() {
        PhongThiBLL bus = new PhongThiBLL();
        try {
            bus.docDuLieu();
            table = (DefaultTableModel) jt.getModel();
            table.setRowCount(0);
            for (PhongThiDTO kh : bus.ds) {
                Vector vt = new Vector();
                vt.add(kh.getPhongthiid()); 
                vt.add(kh.getTenphongthi());
                vt.add(kh.getCathiid());
                vt.add(kh.getKhoathiid());
                vt.add(kh.getTrinhdo());
                table.addRow(vt);
            }
            jt.setModel(table);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(PhongThiDTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

//     public void doDuLieuSearch(Map<String,String> map)
//    {
//        KhoaThiBLL bus = new KhoaThiBLL();
//        try {
//            bus.docduLieusearch(map);
//            table = (DefaultTableModel) jt1.getModel();
//            table.setRowCount(0);
//            for(KhoaThiDTO kh : bus.ds)
//            {
//                Vector vt = new Vector();
//                vt.add(kh.getKhoathiid());
//                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                vt.add(format.format(kh.getNgaybatdau()));
//                vt.add(kh.getTenkhoathi());
//                table.addRow(vt);
//            }
//            jt1.setModel(table);
//        } catch (Exception ex) {
//            Logger.getLogger(KhoaThiDTO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
     
    public void cleanView() //Xóa trắng các TextField
    {
        txtmpt.setText("");
        txttpt.setText("");
        cb1.setSelectedIndex(0);
        cb2.setSelectedIndex(0);
        cb3.setSelectedIndex(0);

    }
    private void btnthemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthemMouseClicked
        // TODO add your handling code here:
        try {
            PhongThiBLL bus = new PhongThiBLL();

            bus.docDuLieu();
            txtmpt.setText(bus.remindPhongTHiID());
            PhongThiDTO phongthi = new PhongThiDTO();
            if (txtmpt.getText().equals("Nhập mã phòng thi") || txttpt.getText().equals("Nhập tên phòng thi")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin Phòng thi cần thêm mới!", "Thông báo", 0);
            } else {
                txttpt.setText(cb3.getSelectedItem().toString() + "P" + txtmpt.getText());
                phongthi.setPhongthiid(Integer.parseInt(txtmpt.getText()));
                phongthi.setTenphongthi(txttpt.getText());
                if (cb1.getSelectedIndex() == 0 || cb2.getSelectedIndex() == 0 || cb3.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn đầy đủ!", "Thông báo", 0);
                } else {
                    phongthi.setCathiid(Integer.parseInt(cb1.getSelectedItem().toString()));
                    StringTokenizer st = new StringTokenizer(cb2.getSelectedItem().toString(), "-");
                    String id = st.nextToken();
                    phongthi.setKhoathiid(Integer.parseInt(id));
                    phongthi.setTrinhdo(cb3.getSelectedItem().toString());
                    Vector head = new Vector();
                    head.add(phongthi.getPhongthiid());
                    head.add(phongthi.getTenphongthi());
                    head.add(phongthi.getCathiid());
                    head.add(phongthi.getKhoathiid());
                    head.add(phongthi.getTrinhdo());
                    int rs = bus.them(phongthi);
                    if (rs == 1) {
                        table.addRow(head);
                        jt.setModel(table);
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");
                    }
                    cleanView();
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(KhoaThiDTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnthemMouseClicked

    private void btnxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnxoaMouseClicked
        // TODO add your handling code here:
         int i = jt.getSelectedRow();
        if (i >= 0) {
            int result = JOptionPane.showConfirmDialog(null, "Xác nhận xóa ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                PhongThiBLL bll = new PhongThiBLL();
                int check = bll.xoa(i);
                if (check == 1) {
                    table.removeRow(i);
                    jt.setModel(table);
                    JOptionPane.showMessageDialog(null, "Xóa thành công");

                }
                cleanView();
            }
        }
    }//GEN-LAST:event_btnxoaMouseClicked

    private void jtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMouseClicked
        // TODO add your handling code here:
         int i = jt.getSelectedRow();
        if (i >= 0)
            setTextFields(jt.getValueAt(i, 0).toString(), jt.getValueAt(i, 1).toString(), jt.getValueAt(i, 2).toString(), jt.getValueAt(i, 3).toString(), jt.getValueAt(i, 4).toString());
    }//GEN-LAST:event_jtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JComboBox<String> cb3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt;
    private javax.swing.JTextField txtmpt;
    private javax.swing.JTextField txttpt;
    // End of variables declaration//GEN-END:variables
}