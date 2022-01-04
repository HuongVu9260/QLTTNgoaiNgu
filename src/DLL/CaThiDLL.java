/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DTO.CaThiDTO;
import UTILS.ConnectionUtils;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HAI HUONG
 */
public class CaThiDLL {
     //Thêm
    public int Them(CaThiDTO cathiDTO){
        int result=0;
        try{ 
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            ConnectionUtils dbUtils= new ConnectionUtils("localhost", "root", "", "ngoaingu");
            String qry = "Insert into cathi Value(";
			qry += "'" + cathiDTO.getCathiid()+ "'";
                        qry += ",'" + cathiDTO.getGiothi()+ "'";
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
    public ArrayList<CaThiDTO> docDuLieu() throws Exception {
		ArrayList<CaThiDTO> ds = new ArrayList<CaThiDTO>();
                ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			String qry = "select * from cathi";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				CaThiDTO cathi = new CaThiDTO();
				cathi.setCathiid(rs.getInt(1));
                                cathi.setGiothi(rs.getString(2));
				ds.add(cathi);
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
    public int xoa(int cathiid) {
            int res = 0;
		try {
			String qry = "delete from cathi where ca_thi_id'" + cathiid + "'";
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
    public int sua(CaThiDTO cathiDTO) {
                int res = 0;
		try {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String qry = "Update cathi set ";
			qry += "gio_thi='"+ cathiDTO.getGiothi()+ "'";
			qry += " where ca_thi_id='" + cathiDTO.getCathiid()+ "'";
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
