/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DTO.KetQuaThiDTO;
import UTILS.ConnectionUtils;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HAI HUONG
 */
public class KetQuaThiDLL {
     //Thêm
    public int Them(KetQuaThiDTO ketquathiDTO){
        int result=0;
        try{ 
            ConnectionUtils dbUtils= new ConnectionUtils("localhost", "root", "", "ngoaingu");
            String qry = "Insert into ketquathi Value(";
			qry += "'" + ketquathiDTO.getKetquathiid() + "'";
			qry += ",'" + ketquathiDTO.getDoc() + "'";
                        qry += ",'" + ketquathiDTO.getNghe() + "'";
                        qry += ",'" + ketquathiDTO.getNoi() + "'";
                        qry += ",'" + ketquathiDTO.getTrungbinh() + "'";
                        qry += ",'" + ketquathiDTO.getViet() + "'";
                        qry += ",'" + ketquathiDTO.getXeploai() + "'";
                        qry += ",'" + ketquathiDTO.getThisinhid() + "'";
			qry += ")";
			result = dbUtils.executeUpdate(qry);
        }
        catch(Exception e){
             System.out.println(e);
             JOptionPane.showMessageDialog(null,"Lỗi thêm vào Database");
        }
        return result;
    }
    
    //Xem DS
    public ArrayList<KetQuaThiDTO> docDuLieu() throws Exception{
		ArrayList<KetQuaThiDTO> ds = new ArrayList<KetQuaThiDTO>();
                ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			String qry = "select * from ketquathi";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				KetQuaThiDTO kqthi = new KetQuaThiDTO();
				kqthi.setKetquathiid(rs.getInt(1));
                                kqthi.setDoc(rs.getFloat(2));
                                kqthi.setNghe(rs.getFloat(3));
                                kqthi.setNoi(rs.getFloat(4));
                                kqthi.setTrungbinh(rs.getFloat(5));
                                kqthi.setViet(rs.getFloat(6));
                                kqthi.setXeploai(rs.getString(7));
                                kqthi.setThisinhid(rs.getInt(7));
				ds.add(kqthi);
			}
		}catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi đọc Database");
		}
                finally{
                    my.close();
                }
		return ds;
	}
    
    //Xóa
    public int xoa(int kqthiid) {
            int res = 0;
		try {
			String qry = "delete from phongthi where ketquathi'" + kqthiid + "'";
			ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
                        res = my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database");
		}
            return res;
	}
    //String sqlInsert="INSERT INTO thisinh(thi_sinh_id, cmnd, email, ho_ten, ngay_sinh, noi_sinh, sdt) VALUES (?,?,?,?,?,?,?)";
    //Sửa
    public int sua(KetQuaThiDTO ketquathiDTO) {
                int res = 0;
		try {
			String qry = "Update ketquathi set ";
			qry += "doc'"+ ketquathiDTO.getDoc() + "'";
                        qry += ",nghe='"+ ketquathiDTO.getNghe()+ "'";
                        qry += ",noi='"+ ketquathiDTO.getNoi() + "'";
                        qry += ",trung_binh='"+ ketquathiDTO.getTrungbinh() + "'";
                        qry += ",viet='"+ ketquathiDTO.getViet() + "'";
                        qry += ",xep_loai='"+ ketquathiDTO.getXeploai() + "'";
                        qry += ",trung_binh='"+ ketquathiDTO.getThisinhid() + "'";
			qry += " where ket_qua_thi_id='" + ketquathiDTO.getKetquathiid() + "'";
			ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
                        res = my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi sửa Database");
		}
                return res;
	}
}
