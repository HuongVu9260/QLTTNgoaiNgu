/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DTO.DanhSachPhongThiDTO;
import UTILS.ConnectionUtils;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HAI HUONG
 */
public class DanhSachPhongThiDLL {
     //Thêm
    public int Them(DanhSachPhongThiDTO dsptDTO){
        int result=0;
        try{ 
            ConnectionUtils dbUtils= new ConnectionUtils("localhost", "root", "", "ngoaingu");
            String qry = "Insert into danhsachphongthi Value(";
			qry += "'" + dsptDTO.getThisinhid()+ "'";
                        qry += ",'" + dsptDTO.getPhongthiid()+ "'";
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
    public ArrayList<DanhSachPhongThiDTO> docDuLieu() throws Exception{
		ArrayList<DanhSachPhongThiDTO> ds = new ArrayList<DanhSachPhongThiDTO>();
                ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			String qry = "select * from danhsachphongthi";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				DanhSachPhongThiDTO dspt = new DanhSachPhongThiDTO();
				dspt.setThisinhid(rs.getInt(1));
                                dspt.setPhongthiid(rs.getString(2));
				ds.add(dspt);
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
    public int xoa(int thisinhid) {
            int res = 0;
		try {
			String qry = "delete from danhsachphongthi where thi_sinh_id'" + thisinhid + "'";
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
    public int sua(DanhSachPhongThiDTO dsptDTO) {
                int res = 0;
		try {
			String qry = "Update danhsachphongthi set ";
			qry += "phong_thi_id='"+ dsptDTO.getPhongthiid()+ "'";
			qry += " where thi_sinh_id='" + dsptDTO.getThisinhid()+ "'";
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
