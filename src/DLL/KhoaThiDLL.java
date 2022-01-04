/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DTO.KhoaThiDTO;
import UTILS.ConnectionUtils;
import java.sql.ResultSet;
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
public class KhoaThiDLL {
     //Thêm
    public int Them(KhoaThiDTO khoathiDTO){
        int result=0;
        try{ 
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            ConnectionUtils dbUtils= new ConnectionUtils("localhost", "root", "", "ngoaingu");
            String qry = "Insert into khoathi Value(";
			qry += "'" + khoathiDTO.getKhoathiid() + "'";
			qry += ",'" + format.format(khoathiDTO.getNgaybatdau()) + "'";
                        qry += ",'" + khoathiDTO.getTenkhoathi() + "'";
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
    public ArrayList<KhoaThiDTO> docDuLieu() throws Exception{
		ArrayList<KhoaThiDTO> ds = new ArrayList<KhoaThiDTO>();
                ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			String qry = "select * from khoathi";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				KhoaThiDTO kthi = new KhoaThiDTO();
				kthi.setKhoathiid(rs.getInt(1));
                                kthi.setNgaybatdau(rs.getDate(2));
                                kthi.setTenkhoathi(rs.getString(3));
				ds.add(kthi);
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
    public int xoa(int khoathiid) {
            int res = 0;
		try {
			String qry = "delete from khoathi where khoa_thi_id'" + khoathiid + "'";
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
    public int sua(KhoaThiDTO khoathiDTO) {
                int res = 0;
		try {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String qry = "Update khoathi set ";
			qry += "khoa_thi_id='"+ khoathiDTO.getKhoathiid() + "'";
                        qry += ",ngay_bat_dau='"+ dateFormat.format(khoathiDTO.getNgaybatdau()) + "'";
                        qry += ",ten_khoa='"+ khoathiDTO.getTenkhoathi() + "'";
			qry += " where khoa_thi_id='" + khoathiDTO.getKhoathiid() + "'";
			ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
                        res = my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi sửa Database");
		}
                return res;
	}
    
    public List<KhoaThiDTO> getThisinh(Map<String,String> ts)throws Exception{
               List<KhoaThiDTO> ds = new ArrayList<KhoaThiDTO>();
              ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			StringBuffer query = new StringBuffer("Select * from khoathi where");
                        /*f(ts.get("ma_khoa_thi_id")!= null && !ts.get("ma_khoa_thi_id").equals("")){
                            query.append("ma_khoa_thi_id = "+ts.get("ma_khoa_thi_id"));
                        }*/
                        if(ts.get("ten_khoa")!= null&& !ts.get("ten_khoa").equals("")){
                            query.append(" ten_khoa = '"+ts.get("ten_khoa")+"'");
                            
                        }
                        System.out.println(query.toString());
			ResultSet rs = my.executeQuery(query.toString());
			while(rs.next()) {
				KhoaThiDTO khoathi = new KhoaThiDTO();
				khoathi.setKhoathiid(rs.getInt(1));
                                khoathi.setNgaybatdau(rs.getDate(2));
                                khoathi.setTenkhoathi(rs.getString(3));
				ds.add(khoathi);
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
