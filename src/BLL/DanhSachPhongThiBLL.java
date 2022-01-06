/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DLL.DanhSachPhongThiDLL;
import DTO.DanhSachPhongThiDTO;
import DTO.PhieuDangKyDTO;
import DTO.ThiSinhDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HAI HUONG
 */
public class DanhSachPhongThiBLL {

    public static List<DanhSachPhongThiDTO> ds;

    public void docDuLieu() throws Exception {
        DanhSachPhongThiDLL dao = new DanhSachPhongThiDLL();
        if (ds == null) {
            ds = dao.docDuLieu();
        }
    }
    
    public ArrayList<DanhSachPhongThiDTO> getDocDuLieu() throws Exception {
        DanhSachPhongThiDLL dao = new DanhSachPhongThiDLL();
        return dao.docDuLieu();
    }
    
    public ArrayList<PhieuDangKyDTO> getALL(int id1, String id) throws Exception {
        DanhSachPhongThiDLL dao = new DanhSachPhongThiDLL();
        return dao.getALL(id1, id);
    }

    public ArrayList<DanhSachPhongThiDTO> getALLTheoPhongThi(int id1) throws Exception {
        DanhSachPhongThiDLL dao = new DanhSachPhongThiDLL();
        return dao.getALLTheoPhongThi(id1);
    }

    public int them(DanhSachPhongThiDTO dd) {
        DanhSachPhongThiDLL dao = new DanhSachPhongThiDLL();
        int rs = dao.Them(dd);
        if (rs == 1) {
            ds.add(dd);
        }
        return rs;
    }

    public int AddDataScoresBUS(int vitri, DanhSachPhongThiDTO bai_thi) {
        DanhSachPhongThiDLL data = new DanhSachPhongThiDLL();
        int rs = data.AddDataScoresDAO(bai_thi);
        if (rs == 1) {
            ds.set(vitri, bai_thi);
        }
        return rs;
    }

    public int xoa(int vitri) {
        DanhSachPhongThiDLL dao = new DanhSachPhongThiDLL();
        int rs = dao.xoa(ds.get(vitri).getThisinhid());
        if (rs == 1) {
            ds.remove(vitri);
        }
        return rs;
    }

    public int sua(int vitri, DanhSachPhongThiDTO dd) {
        DanhSachPhongThiDLL dao = new DanhSachPhongThiDLL();
        int rs = dao.sua(dd);
        if (rs == 1) {
            ds.set(vitri, dd);
        }
        return rs;
    }

    public DanhSachPhongThiDTO getDSPT(int ts_id) {
        for (DanhSachPhongThiDTO nv : ds) {
            if (nv.getThisinhid() == ts_id) {
                return nv;
            }
        }
        return null;
    }

    public void docduLieusearch(Map<String, String> nv) throws Exception {
        DanhSachPhongThiDLL dao = new DanhSachPhongThiDLL();
        ds = dao.getThisinh(nv);

    }
    
    public void docdulieuPhong (Map<String, String> nv) throws Exception{
        DanhSachPhongThiDLL dao = new DanhSachPhongThiDLL();
        ds = dao.docdulieuphongthi(nv);
    }
}
