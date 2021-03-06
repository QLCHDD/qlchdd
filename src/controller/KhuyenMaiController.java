/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import model.KhuyenMaiModelTable;
import model.dao.KhuyenMaiDAO;
import model.dao.TimKiemDAO;
import model.entities.KhuyenMai;
import model.entities.SanPham;
import utils.Config;
import view.interfaceView.iBanHangView;
import view.interfaceView.iMessageView;
import view.interfaceView.iModelTable;

/**
 *
 * @author THAITHANG
 */
public class KhuyenMaiController {
    private static KhuyenMaiController instance;

    public static KhuyenMaiController getInstance() {
        if(instance == null) 
            instance = new KhuyenMaiController();
        return instance;
    }
    
    private KhuyenMaiController() {
    }
    
    public void kiemTraKhuyenMai(Date currentDay, SanPham sanPham, iBanHangView callBack){
        
        ////System.out.println(currentDay.toString());
        
//        List result = new TimKiemDAO(KhuyenMai.class)
//                            .greaterThanOrEqual("ngayKt", currentDay)
//                            .lessThanOrEqual("ngayBd", currentDay)
//                            .timKiem();
//        
//        if(result.size() != 0){
//            KhuyenMai km = (KhuyenMai) result.get(0);
//            //System.out.println(km.getTenKm());
//            
//            Object []arr =  km.getSanphams().toArray();
//            //System.out.println(km.getSanphams().size());
//            for (Object object : arr) {
//                SanPham sanPham = (SanPham)object;
//                //System.out.println(sanPham.getMaSp());
//                if(sanPham.getMaSp() == maSP){
//                    callBack.capNhatKhuyenMaiSanPham(km);
//                    return;
//                }
//            }
//            callBack.capNhatKhuyenMaiSanPham(null);
//        }
//        else
//            callBack.capNhatKhuyenMaiSanPham(null);

        //System.out.println(currentDay.toString());
        for(KhuyenMai km : sanPham.getKhuyenmais()){
            if(km.getNgayBd().before(currentDay) && km.getNgayKt().after(currentDay)){
                callBack.capNhatKhuyenMaiSanPham(km);
                return;
            }
        }
        callBack.capNhatKhuyenMaiSanPham(null);
    }
    
    public void layToanBoDuLieuLenTable(iModelTable callBack){
        List<KhuyenMai> data = KhuyenMaiDAO.getDSKhuyenMai();
        KhuyenMaiModelTable modelTable = new KhuyenMaiModelTable(data);
        callBack.hienThiDuLieuLenTable(modelTable);
    }
    
    public void capNhatKhuyenMai(KhuyenMai khuyenMai, iMessageView callBack){
        boolean result = KhuyenMaiDAO.capNhatKhuyenMai(khuyenMai);
        
        if(result)
            callBack.showMessageAndReloadData("Cập nhật khuyến mãi thành công", iMessageView.SUCCESS);
        else
            callBack.showMessageAndReloadData("Cập nhật khuyến mãi thất bại", iMessageView.FAIL);
    }
    
    public void timKiemDuLieuKhuyenMaiTheoTenLenTable(String tenKm, iModelTable callBack){
        String ten = Config.convertSignedStringToUnsignedString(tenKm);
        List<KhuyenMai> timKiem = new TimKiemDAO(KhuyenMai.class).ilike("tenKm", "%"+ten+"%").timKiem();
        List<KhuyenMai> data = new ArrayList<>();
        int maKm;
        int j;
        for(int i = 0; i < timKiem.size();i++){
            maKm = timKiem.get(i).getMaKm();
            for(j = 0; j < i;j++){
                if(maKm == timKiem.get(j).getMaKm()){
                    break;
                }
            }
            if(j == i){
                data.add(timKiem.get(i));
            }
        }
        
        KhuyenMaiModelTable modelTable = new KhuyenMaiModelTable(data);
        callBack.hienThiDuLieuLenTable(modelTable);
    }
    
    public void themKhuyenMai(KhuyenMai km, iMessageView callBack){
        boolean result = KhuyenMaiDAO.themKhuyenMai(km);
        
        if(result)
            callBack.showMessageAndReloadData("Thêm Khuyến mãi mới thành công", iMessageView.SUCCESS);
        else
            callBack.showMessageAndReloadData("Thêm Khuyến mãi mới thất bại", iMessageView.FAIL);
    }
    
    public void xoaKhuyenMai(KhuyenMai km, iMessageView callBack){
        boolean result = KhuyenMaiDAO.xoaKhuyenMai(km.getMaKm());
        
        if(result)
            callBack.showMessageAndReloadData("Xóa Khuyến mãi thành công", iMessageView.SUCCESS);
        else
            callBack.showMessageAndReloadData("Xóa Khuyến mãi thất bại", iMessageView.FAIL);
    }
}
