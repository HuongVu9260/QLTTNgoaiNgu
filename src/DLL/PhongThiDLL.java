/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DTO.PhongThiDTO;
import UTILS.ConnectionUtils;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author HAI HUONG
 */
public class PhongThiDLL {
     //Thêm
    public int Them(PhongThiDTO phongthiDTO){
        int result=0;
        try{ 
            ConnectionUtils dbUtils= new ConnectionUtils("localhost", "root", "", "ngoaingu");
            String qry = "Insert into phongthi Value(";
			qry += "'" + phongthiDTO.getPhongthiid() + "'";
			qry += ",'" + phongthiDTO.getTenphongthi() + "'";
                        qry += ",'" + phongthiDTO.getCathiid() + "'";
                        qry += ",'" + phongthiDTO.getKhoathiid()+ "'";
                        qry += ",'" + phongthiDTO.getTrinhdo()+ "'";
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
    public ArrayList<PhongThiDTO> docDuLieu() throws Exception{
		ArrayList<PhongThiDTO> ds = new ArrayList<PhongThiDTO>();
                ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			String qry = "select * from phongthi";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				PhongThiDTO pthi = new PhongThiDTO();
				pthi.setPhongthiid(rs.getInt(1));
                                pthi.setTenphongthi(rs.getString(2));
                                pthi.setCathiid(rs.getInt(3));
                                pthi.setKhoathiid(rs.getInt(4));
                                pthi.setTrinhdo(rs.getString(5));
				ds.add(pthi);
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
    public int xoa(int phongthiid) {
            int res = 0;
		try {
			String qry = "delete from phongthi where phong_thi_id='" + phongthiid + "'";
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
    public int sua(PhongThiDTO phongthiDTO) {
                int res = 0;
		try {
			String qry = "Update phongthi set ";
			qry += "phong_thi_id='"+ phongthiDTO.getPhongthiid() + "'";
                        qry += ",ten_phong_thi='"+ phongthiDTO.getTenphongthi() + "'";
                        qry += ",ca_thi_id='"+ phongthiDTO.getCathiid() + "'";
                        qry += ",khoa_thi_id='"+ phongthiDTO.getKhoathiid()+ "'";
                        qry += ",trinh_do='"+ phongthiDTO.getTrinhdo()+ "'";
			qry += " where phong_thi_id='" + phongthiDTO.getPhongthiid() + "'";
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
