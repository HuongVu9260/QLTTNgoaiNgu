/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DTO.PhieuDangKyDTO;
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
public class PhieuDangKyDLL {
    //Thêm
    public int Them(PhieuDangKyDTO phieudangkyDTO){
        int result=0;
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            ConnectionUtils dbUtils= new ConnectionUtils("localhost", "root", "", "ngoaingu");
            String qry = "Insert into phieudangky Value(";
			qry += "'" + phieudangkyDTO.getThisinhid() + "'";
			qry += ",'" + phieudangkyDTO.getKhoathiid()+ "'";
                        qry += ",'" + phieudangkyDTO.getTrinhdo()+ "'";
                        qry += ",'" + format.format(phieudangkyDTO.getNgaydangky()) + "'";
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
    public ArrayList<PhieuDangKyDTO> docDuLieu() throws Exception{
		ArrayList<PhieuDangKyDTO> ds = new ArrayList<PhieuDangKyDTO>();
                ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			String qry = "select * from phieudangky";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				PhieuDangKyDTO phieudangky = new PhieuDangKyDTO();
				phieudangky.setThisinhid(rs.getInt(1));
                                phieudangky.setKhoathiid(rs.getInt(2));
                                phieudangky.setTrinhdo(rs.getString(3));
                                phieudangky.setNgaydangky(rs.getDate(4));
				ds.add(phieudangky);
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
			String qry = "delete from phieudangky where thi_sinh_id='" + thisinhid + "'";
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
    public int sua(PhieuDangKyDTO phieudangkyDTO) {
                int res = 0;
		try {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String qry = "Update phieudangky set ";
			qry += "khoa_thi_id='"+ phieudangkyDTO.getKhoathiid()+ "'";
                        qry += ",trinh_do='"+ phieudangkyDTO.getTrinhdo()+ "'";
                        qry += ",ngay_dang_ky='"+ dateFormat.format(phieudangkyDTO.getNgaydangky())+ "'";
			qry += " where thi_sinh_id='" + phieudangkyDTO.getThisinhid() + "'";
			ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
                        res = my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi sửa Database");
		}
                return res;
	}
    
    //Tìm kiếm theo id
    public List<PhieuDangKyDTO> getThisinh(Map<String,String> ts)throws Exception{
               List<PhieuDangKyDTO> ds = new ArrayList<PhieuDangKyDTO>();
              ConnectionUtils my = new ConnectionUtils("localhost","root","","ngoaingu");
		try {
			StringBuffer query = new StringBuffer("Select * from phieudangky where 1=1");
                        if(ts.get("thi_sinh_id")!= null && !ts.get("thi_sinh_id").equals("")){
                            query.append(" and thi_sinh_id = "+ts.get("thi_sinh_id"));
                        }
                        if(ts.get("khoa_thi_id")!= null&& !ts.get("khoa_thi_id").equals("")){
                            query.append(" and khoa_thi_id = '"+ts.get("khoa_thi_id")+"'");
                            
                        }
                        System.out.println(query.toString());
			ResultSet rs = my.executeQuery(query.toString());
			while(rs.next()) {
				PhieuDangKyDTO phieudangky = new PhieuDangKyDTO();
				phieudangky.setThisinhid(rs.getInt(1));
                                phieudangky.setKhoathiid(rs.getInt(2));
                                phieudangky.setTrinhdo(rs.getString(3));
                                phieudangky.setNgaydangky(rs.getDate(4));
				ds.add(phieudangky);
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
