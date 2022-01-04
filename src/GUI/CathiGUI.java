/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.CaThiBLL;
import DTO.CaThiDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HAI HUONG
 */
public class CathiGUI extends javax.swing.JPanel {
    DefaultTableModel table;
    /**
     * Creates new form CathiGUI
     */
    public CathiGUI() {
        initComponents();
        jtxtma.setEnabled(false);
        doDuLieuLenBang();
    }
    
    public void cleanView() //Xóa trắng các TextField
    {
        jtxtma.setText("");
        jttxgio.setText("");

    }
    
    public void doDuLieuLenBang() {
        CaThiBLL bus = new CaThiBLL();
        try {
            bus.docDuLieu();
            table = (DefaultTableModel) jt.getModel();
            table.setRowCount(0);
            for (CaThiDTO kh : bus.ds) {
                Vector vt = new Vector();
                vt.add(kh.getCathiid());
                vt.add(kh.getGiothi());
                table.addRow(vt);
            }
            jt.setModel(table);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CaThiDTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }
    
    private void setTextFields(String toString, String toString0) {
        
        jtxtma.setText(toString);
        jttxgio.setText(toString0);
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtma = new javax.swing.JTextField();
        jttxgio = new javax.swing.JTextField();
        jbtnthem = new javax.swing.JButton();
        jbtnxoa = new javax.swing.JButton();
        jbtnsua = new javax.swing.JButton();
        jbtnquaylai = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtmaca = new javax.swing.JTextField();
        jtxtgiothi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 204));
        jLabel2.setText("CA THI");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mã Ca Thi:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Giờ thi:");

        jttxgio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jttxgioActionPerformed(evt);
            }
        });

        jbtnthem.setBackground(new java.awt.Color(153, 255, 255));
        jbtnthem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnthem.setText("Thêm");
        jbtnthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnthemMouseClicked(evt);
            }
        });
        jbtnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnthemActionPerformed(evt);
            }
        });

        jbtnxoa.setBackground(new java.awt.Color(153, 255, 255));
        jbtnxoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnxoa.setText("Xóa");
        jbtnxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnxoaMouseClicked(evt);
            }
        });

        jbtnsua.setBackground(new java.awt.Color(153, 255, 255));
        jbtnsua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnsua.setText("Sửa");
        jbtnsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnsuaMouseClicked(evt);
            }
        });

        jbtnquaylai.setBackground(new java.awt.Color(153, 255, 255));
        jbtnquaylai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnquaylai.setText("Quay lại");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("-------------TÌM KIẾM CA THI---------------");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Mã Ca Thi:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Giờ Thi:");

        jt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "MÃ CA THI", "GIỜ THI"
            }
        ));
        jt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtma)
                            .addComponent(jttxgio, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                        .addGap(197, 197, 197)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnthem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnquaylai)
                            .addComponent(jbtnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtmaca)
                            .addComponent(jtxtgiothi, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
                .addContainerGap(72, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxtma, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnthem)
                        .addComponent(jbtnxoa)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jttxgio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnsua)
                            .addComponent(jbtnquaylai))
                        .addGap(2, 2, 2)))
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtxtmaca, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtgiothi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jttxgioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jttxgioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jttxgioActionPerformed

    private void jbtnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnthemActionPerformed
         // TODO add your handling code here:
       
    }//GEN-LAST:event_jbtnthemActionPerformed

    private void jbtnthemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnthemMouseClicked
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            CaThiBLL bus = new CaThiBLL();
            jtxtma.setText(bus.remindCathiID());
            bus.docDuLieu();
            CaThiDTO cathi = new CaThiDTO();
            if(jttxgio.getText().equals("Nhập giờ thi")) 
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin Ca Thi cần thêm mới!","Thông báo",0);
            else{
                cathi.setCathiid(Integer.parseInt(jtxtma.getText()));
                cathi.setGiothi(jttxgio.getText());
                Vector head = new Vector();
                head.add(cathi.getCathiid());
                            head.add(cathi.getGiothi());
                            int rs = bus.them(cathi);
                            if (rs == 1) {
                                table.addRow(head);
                                jt.setModel(table);
                                JOptionPane.showMessageDialog(null, "Thêm thành công");
                            } else {
                                JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");
                            }
                            cleanView();
                        }    
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CaThiDTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnthemMouseClicked

    private void jtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMouseClicked
        // TODO add your handling code here:
        int i = jt.getSelectedRow();
        if (i >= 0)
            setTextFields(jt.getValueAt(i, 0).toString(), jt.getValueAt(i, 1).toString());
    }//GEN-LAST:event_jtMouseClicked

    private void jbtnxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnxoaMouseClicked
        // TODO add your handling code here:
        int i = jt.getSelectedRow();
        if (i >= 0) {
            int result = JOptionPane.showConfirmDialog(null, "Xác nhận xóa ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                CaThiBLL bll = new CaThiBLL();
                int check = bll.xoa(i);
                if (check == 1) {
                    table.removeRow(i);
                    jt.setModel(table);
                    JOptionPane.showMessageDialog(null, "Xóa thành công");

                }
                cleanView();
            }
        }
    }//GEN-LAST:event_jbtnxoaMouseClicked

    private void jbtnsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnsuaMouseClicked
        // TODO add your handling code here:
        CaThiBLL bll = new CaThiBLL();
        int i = jt.getSelectedRow();
        if (i >= 0) {

            int result = JOptionPane.showConfirmDialog(null, "Xác nhận sửa ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                CaThiDTO thisinh = new CaThiDTO();
                thisinh.setCathiid(Integer.parseInt(jtxtma.getText()));
                thisinh.setGiothi(jttxgio.getText());
                int check = bll.sua(i, thisinh);
                if (check == 1) {
                    table.setValueAt(thisinh.getGiothi(), i, 1);
                    jt.setModel(table);
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                }
                cleanView();
            }
        }
    }//GEN-LAST:event_jbtnsuaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnquaylai;
    private javax.swing.JButton jbtnsua;
    private javax.swing.JButton jbtnthem;
    private javax.swing.JButton jbtnxoa;
    private javax.swing.JTable jt;
    private javax.swing.JTextField jttxgio;
    private javax.swing.JTextField jtxtgiothi;
    private javax.swing.JTextField jtxtma;
    private javax.swing.JTextField jtxtmaca;
    // End of variables declaration//GEN-END:variables
}