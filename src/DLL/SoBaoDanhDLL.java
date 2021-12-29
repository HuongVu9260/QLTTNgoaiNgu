/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DTO.SoBaoDanhDTO;
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
public class SoBaoDanhDLL {
     //Thêm
    public int Them(SoBaoDanhDTO sbdDTO){
        int result=0;
        try{ 
            ConnectionUtils dbUtils= new ConnectionUtils("localhost", "root", "", "ngoaingu");
            String qry = "Insert into sobaodanh Value(";
			qry += "'" + sbdDTO.getSobaodanh() + "'";
			qry += ",'" + sbdDTO.getThisinhid() + "'";
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
    public ArrayList<SoBaoDanhDTO> docDuLieu() throws Exception{
		ArrayList<SoBaoDanhDTO> ds = new ArrayList<SoBaoDanhDTO>();
                ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			String qry = "select * from sobaodanh";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				SoBaoDanhDTO sbd = new SoBaoDanhDTO();
				sbd.setSobaodanh(rs.getString(1));
                                sbd.setThisinhid(rs.getInt(2));
				ds.add(sbd);
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
    public int xoa(int sobaodanhid) {
            int res = 0;
		try {
			String qry = "delete from sobaodanh where so_bao_danh_id'" + sobaodanhid + "'";
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
    public int sua(SoBaoDanhDTO sbdDTO) {
                int res = 0;
		try {
			String qry = "Update sobaodanh set ";
			qry += "so_bao_danh_id='"+ sbdDTO.getSobaodanh() + "'";
                        qry += "thi_sinh_id='"+ sbdDTO.getThisinhid() + "'";
			qry += " where so_bao_danh_id='" + sbdDTO.getSobaodanh() + "'";
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
    public List<SoBaoDanhDTO> getSoBaoDanh(Map<String,String> sbd)throws Exception{
               List<SoBaoDanhDTO> ds = new ArrayList<SoBaoDanhDTO>();
              ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			StringBuffer query = new StringBuffer("Select * from sobaodanh where 1=1");
                        if(sbd.get("so_bao_danh_id")!= null && !sbd.get("so_bao_danh_id").equals("")){
                            query.append(" and so_bao_danh_id = "+sbd.get("so_bao_danh_id"));
                        }
                        if(sbd.get("thi_sinh_id")!= null&& !sbd.get("thi_sinh_id").equals("")){
                            query.append(" and thi_sinh_id = '"+sbd.get("thi_sinh_id")+"'");
                            
                        }
                        System.out.println(query.toString());
			ResultSet rs = my.executeQuery(query.toString());
			while(rs.next()) {
				SoBaoDanhDTO sbdanh = new SoBaoDanhDTO();
				sbdanh.setSobaodanh(rs.getString(1));
				ds.add(sbdanh);
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
