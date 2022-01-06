/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DTO.DanhSachPhongThiDTO;
import DTO.PhieuDangKyDTO;
import DTO.PhongThiDTO;
import DTO.ThiSinhDTO;
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
public class DanhSachPhongThiDLL {
    //Thêm

    public int Them(DanhSachPhongThiDTO dsptDTO) {
        int result = 0;
        try {
            ConnectionUtils dbUtils = new ConnectionUtils("localhost", "root", "", "ngoaingu");
            String qry = "Insert into danhsachphongthi Value(";
            qry += "'" + dsptDTO.getThisinhid() + "'";
            qry += ",'" + dsptDTO.getPhongthiid() + "'";
            qry += ",'" + dsptDTO.getSobaodanh() + "'";
            qry += ",'" + dsptDTO.getNghe() + "'";
            qry += ",'" + dsptDTO.getNoi() + "'";
            qry += ",'" + dsptDTO.getDoc() + "'";
            qry += ",'" + dsptDTO.getViet() + "'";
            qry += ")";
            result = dbUtils.executeUpdate(qry);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi thêm vào Database");
        }
        return result;
    }

    //Xem DS
    public ArrayList<DanhSachPhongThiDTO> docDuLieu() throws Exception {
        ArrayList<DanhSachPhongThiDTO> ds = new ArrayList<DanhSachPhongThiDTO>();
        ConnectionUtils my = new ConnectionUtils("localhost", "root", "", "ngoaingu");
        try {
            String qry = "select * from danhsachphongthi";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next()) {
                DanhSachPhongThiDTO dspt = new DanhSachPhongThiDTO();
                dspt.setThisinhid(rs.getInt(1));
                dspt.setPhongthiid(rs.getInt(2));
                dspt.setSobaodanh(rs.getString(3));
                dspt.setNghe(rs.getFloat(4));
                dspt.setNoi(rs.getFloat(5));
                dspt.setDoc(rs.getFloat(6));
                dspt.setViet(rs.getFloat(7));
                ds.add(dspt);
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi đọc Database");
        } finally {
            my.close();
        }
        return ds;
    }

    //SELECT phieudangky.thi_sinh_id FROM phieudangky, phongthi WHERE phieudangky.khoa_thi_id=phongthi.khoa_thi_id AND phieudangky.trinh_do=phongthi.trinh_do AND phieudangky.trinh_do='A2';;
    //Lấy id thí sinh
    public ArrayList<PhieuDangKyDTO> getALL(int id1, String id) throws Exception {
        ArrayList<PhieuDangKyDTO> ds = new ArrayList<PhieuDangKyDTO>();
        ConnectionUtils my = new ConnectionUtils("localhost", "root", "", "ngoaingu");
        try {
            String qry = "select phieudangky.thi_sinh_id, phieudangky.khoa_thi_id, phieudangky.trinh_do, phieudangky.ngay_dang_ky from phieudangky,phongthi where phieudangky.khoa_thi_id='" + id1 + "' AND phieudangky.trinh_do=phongthi.trinh_do and phieudangky.trinh_do='" + id + "' group by phieudangky.thi_sinh_id";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next()) {
                PhieuDangKyDTO dspt = new PhieuDangKyDTO();
                dspt.setThisinhid(rs.getInt(1));
                ds.add(dspt);
            }
            System.out.println(qry);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi đọc Database");
        } finally {
            my.close();
        }
        return ds;
    }

    //SELECT thi_sinh_id FROM danhsachphongthi WHERE phong_thi_id='4'
    //lấy thí sinh theo phòng thi
    public ArrayList<DanhSachPhongThiDTO> getALLTheoPhongThi(int id1) throws Exception {
        ArrayList<DanhSachPhongThiDTO> ds = new ArrayList<DanhSachPhongThiDTO>();
        ConnectionUtils my = new ConnectionUtils("localhost", "root", "", "ngoaingu");
        try {
            String qry = "select * from danhsachphongthi where phong_thi_id='" + id1 + "'";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next()) {
                DanhSachPhongThiDTO dspt = new DanhSachPhongThiDTO();
                dspt.setThisinhid(rs.getInt(1));
                ds.add(dspt);
            }
            System.out.println(qry);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi đọc Database");
        } finally {
            my.close();
        }
        return ds;
    }

    //SELECT so_bao_danh,ten_phong_thi,nghe,noi,doc,viet from thisinh,danhsachphongthi,phongthi WHERE thisinh.thi_sinh_id=danhsachphongthi.thi_sinh_id and phongthi.phong_thi_id=danhsachphongthi.phong_thi_id and thisinh.ho_ten='C.Huyền' and thisinh.sdt='0256398426';
    //tìm kiếm theo tên và sđt
    public List<DanhSachPhongThiDTO> getThisinh(Map<String, String> ts) throws Exception {
        List<DanhSachPhongThiDTO> ds = new ArrayList<DanhSachPhongThiDTO>();
        List<PhongThiDTO> pt = new ArrayList<PhongThiDTO>();
        List<DanhSachPhongThiDTO> dspt = new ArrayList<DanhSachPhongThiDTO>();
        ConnectionUtils my = new ConnectionUtils("localhost", "root", "", "ngoaingu");
        try {
            StringBuffer query = new StringBuffer("Select so_bao_danh,danhsachphongthi.phong_thi_id,nghe,noi,doc,viet from thisinh,danhsachphongthi,phongthi where thisinh.thi_sinh_id=danhsachphongthi.thi_sinh_id and phongthi.phong_thi_id=danhsachphongthi.phong_thi_id and thisinh.ho_ten='" + ts.get("ho_ten") + "' and thisinh.so_dien_thoai='" + ts.get("sdt") + "' ");
            System.out.println(query.toString());
            ResultSet rs = my.executeQuery(query.toString());
            while (rs.next()) {
                DanhSachPhongThiDTO danhsach = new DanhSachPhongThiDTO();
                danhsach.setSobaodanh(rs.getString(1));
                danhsach.setPhongthiid(rs.getInt(2));
                danhsach.setNghe(rs.getFloat(3));
                danhsach.setNoi(rs.getFloat(4));
                danhsach.setDoc(rs.getFloat(5));
                danhsach.setViet(rs.getFloat(6));;
                dspt.add(danhsach);
            }
            return dspt;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi đọc Database");
        } finally {
            my.close();
        }
        return null;
    }

    //Xóa
    public int xoa(int thisinhid) {
        int res = 0;
        try {
            String qry = "delete from danhsachphongthi where thi_sinh_id='" + thisinhid + "'";
            ConnectionUtils my = new ConnectionUtils("localhost", "root", "", "ngoaingu");
            res = my.executeUpdate(qry);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi xóa Database");
        }
        return res;
    }

    //String sqlInsert="INSERT INTO thisinh(thi_sinh_id, cmnd, email, ho_ten, ngay_sinh, noi_sinh, sdt) VALUES (?,?,?,?,?,?,?)";
    //Sửa
    public int sua(DanhSachPhongThiDTO dsptDTO) {
        int res = 0;
        try {
            String qry = "Update danhsachphongthi set ";
            qry += "phong_thi_id='" + dsptDTO.getPhongthiid() + "'";
            qry += ",so_bao_danh='" + dsptDTO.getSobaodanh() + "'";
            qry += ",nghe='" + dsptDTO.getNghe() + "'";
            qry += ",noi='" + dsptDTO.getNoi() + "'";
            qry += ",doc='" + dsptDTO.getDoc() + "'";
            qry += ",viet='" + dsptDTO.getViet() + "'";
            qry += " where thi_sinh_id='" + dsptDTO.getThisinhid() + "'";

            ConnectionUtils my = new ConnectionUtils("localhost", "root", "", "ngoaingu");
            res = my.executeUpdate(qry);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi sửa Database");
        }
        return res;
    }

    //thêm điểm
    public int AddDataScoresDAO(DanhSachPhongThiDTO bai_thi) {
        int result = 0;
        try {
            ConnectionUtils dbUtils = new ConnectionUtils("localhost", "root", "", "ngoaingu");
            String qry = "Update danhsachphongthi set";
            qry += " nghe='" + bai_thi.getNghe() + "'";
            qry += ",noi='" + bai_thi.getNoi() + "'";
            qry += ",doc='" + bai_thi.getDoc() + "'";
            qry += ",viet='" + bai_thi.getViet() + "'";
            qry += " where so_bao_danh='" + bai_thi.getSobaodanh() + "'";
            result = dbUtils.executeUpdate(qry);
            JOptionPane.showMessageDialog(null, "Sửa Thành Công");
            System.out.println("thành công");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi sửa Database");
        }
        return result;
    }

    
    //lấy dữ liệu theo phòng
    public List<DanhSachPhongThiDTO> docdulieuphongthi(Map<String, String> ts) throws Exception {
        List<DanhSachPhongThiDTO> ds = new ArrayList<DanhSachPhongThiDTO>();
        ConnectionUtils my = new ConnectionUtils("localhost", "root", "", "ngoaingu");
        try {
            StringBuffer query = new StringBuffer("Select * from danhsachphongthi where 1=1");
            if (ts.get("maphongthi") != null && !ts.get("maphongthi").equals("")) {
                query.append(" and phong_thi_id = " + ts.get("maphongthi"));
            }
            ResultSet rs = my.executeQuery(query.toString());
            while (rs.next()) {
                DanhSachPhongThiDTO dspt = new DanhSachPhongThiDTO();
                dspt.setThisinhid(rs.getInt(1));
                dspt.setPhongthiid(rs.getInt(2));
                dspt.setSobaodanh(rs.getString(3));
                dspt.setNghe(rs.getFloat(4));
                dspt.setNoi(rs.getFloat(5));
                dspt.setDoc(rs.getFloat(6));
                dspt.setViet(rs.getFloat(7));
                ds.add(dspt);
            }
            return ds;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi đọc Database");
        } finally {
            my.close();
        }
        return null;
    }
}
