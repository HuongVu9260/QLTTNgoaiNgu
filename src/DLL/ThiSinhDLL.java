/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DTO.ThiSinhDTO;
import UTILS.ConnectionUtils;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author HAI HUONG
 */
public class ThiSinhDLL {
    //Thêm
    public int Them(ThiSinhDTO thisinhDTO){
        int result=0;
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            ConnectionUtils dbUtils= new ConnectionUtils("localhost", "root", "", "ngoaingu");
            String qry = "Insert into thisinh Value(";
			qry += "'" + thisinhDTO.getThisinhid() + "'";
			qry += ",'" + thisinhDTO.getCmnd() + "'";
                        qry += ",'" + thisinhDTO.getEmail() + "'";
                        qry += ",'" + thisinhDTO.getHoten() + "'";
                        qry += ",'" + format.format(thisinhDTO.getNgaysinh()) + "'";
                        qry += ",'" + thisinhDTO.getNoisinh() + "'";
                        qry += ",'" + thisinhDTO.getSdt() + "'";
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
    public ArrayList<ThiSinhDTO> docDuLieu() throws Exception{
		ArrayList<ThiSinhDTO> ds = new ArrayList<ThiSinhDTO>();
                ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			String qry = "select * from thisinh";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				ThiSinhDTO thisinh = new ThiSinhDTO();
				thisinh.setThisinhid(rs.getInt(1));
                                thisinh.setCmnd(rs.getString(2));
                                thisinh.setEmail(rs.getString(3));
                                thisinh.setHoten(rs.getString(4));
                                thisinh.setNgaysinh(rs.getDate(5));
                                thisinh.setNoisinh(rs.getString(6));
                                thisinh.setSdt(rs.getString(7));
				ds.add(thisinh);
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
			String qry = "delete from thisinh where thi_sinh_id='" + thisinhid + "'";
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
    public int sua(ThiSinhDTO thisinhDTO) {
                int res = 0;
		try {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String qry = "Update thisinh set ";
			qry += "cmnd='"+ thisinhDTO.getCmnd() + "'";
                        qry += ",email='"+ thisinhDTO.getEmail() + "'";
                        qry += ",ho_ten='"+ thisinhDTO.getHoten() + "'";
                        qry += ",ngay_sinh='"+ dateFormat.format(thisinhDTO.getNgaysinh())+ "'";
                        qry += ",noi_sinh='"+ thisinhDTO.getNoisinh() + "'";
                        qry += ",sdt='"+ thisinhDTO.getSdt() + "'";
			qry += " where thi_sinh_id='" + thisinhDTO.getThisinhid() + "'";
			ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
                        res = my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi sửa Database");
		}
                return res;
	}
    
    //
    public List<ThiSinhDTO> getThisinh(Map<String,String> ts)throws Exception{
               List<ThiSinhDTO> ds = new ArrayList<ThiSinhDTO>();
              ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			StringBuffer query = new StringBuffer("Select * from thisinh where 1=1");
                        if(ts.get("thi_sinh_id")!= null && !ts.get("thi_sinh_id").equals("")){
                            query.append(" and thi_sinh_id = "+ts.get("thi_sinh_id"));
                        }
                        if(ts.get("ho_ten")!= null&& !ts.get("ho_ten").equals("")){
                            query.append(" and ho_ten = '"+ts.get("ho_ten")+"'");
                            
                        }
                        System.out.println(query.toString());
			ResultSet rs = my.executeQuery(query.toString());
			while(rs.next()) {
				ThiSinhDTO thisinh = new ThiSinhDTO();
				thisinh.setThisinhid(rs.getInt(1));
                                thisinh.setCmnd(rs.getString(2));
                                thisinh.setEmail(rs.getString(3));
                                thisinh.setHoten(rs.getString(4));
                                thisinh.setNgaysinh(rs.getDate(5));
                                thisinh.setNoisinh(rs.getString(6));
                                thisinh.setSdt(rs.getString(7));
				ds.add(thisinh);
			}
                        return ds;
		}catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi đọc Database");
		}
                finally{
                    my.close();
                }
                return null;
        }
}
