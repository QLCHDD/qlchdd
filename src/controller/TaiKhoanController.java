/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.List;
import model.TaiKhoanModelTable;
import model.dao.NhanVienDAO;
import model.dao.PhanQuyenDAO;
import model.dao.TaiKhoanDAO;
import model.dao.TimKiemDAO;
import model.entities.NhanVien;
import model.entities.PhanQuyen;
import model.entities.TaiKhoan;
import utils.Config;
import static utils.Config.maHoaMatKhau;
import view.interfaceView.iDangNhapView;
import view.interfaceView.iMessageView;
import view.interfaceView.iModelComBox;
import view.interfaceView.iModelTable;
import view.interfaceView.iQuanLyTaiKhoan;


/**
 *
 * @author THAITHANG
 */
public class TaiKhoanController {

    private static TaiKhoanController instance;

    public static TaiKhoanController getInstance() {
        if(instance == null) 
            instance = new TaiKhoanController();
        return instance;
    }
    
    private TaiKhoanController() {
    }
    
    public void layToanBoDuLieuLenTable(iModelTable callBack){
        List<TaiKhoan> data = TaiKhoanDAO.getDSTaiKhoan();
        TaiKhoanModelTable modelTable = new TaiKhoanModelTable(data);
        callBack.hienThiDuLieuLenTable(modelTable);
    }
    
    public void layToanBoTaiKhoanChuaCoNhanVienLenComboBox(iModelComBox callBack){
//        List data = new TimKiemDAO(TaiKhoan.class).isNull("nhanvien").equal("phanquyen", data).timKiem();
//        callBack.hienThiDuLieuLenComBox(data,new TaiKhoan());
    }
    
    public void themTaiKhoan(TaiKhoan tk, iMessageView callBack){
        if(tk.getPhanquyen().getMaPhanQuyen() == 1)
            tk.setMatkhauDangNhap("C31F804A0E4A8943A7A5577A292F2321");
        else if(tk.getPhanquyen().getMaPhanQuyen() == 2)
            tk.setMatkhauDangNhap("9B84756F9A50CC0D8223B9A03842CAC4");
        
        boolean result = TaiKhoanDAO.themTaiKhoan(tk);
        
        if(result)
            callBack.showMessageAndReloadData("Thêm Tài Khoản Thành Công", iMessageView.SUCCESS);
        else
            callBack.showMessageAndReloadData("Thêm Tài Khoản Thất Bại", iMessageView.FAIL);
    }
    
    public void resetMatKhau(TaiKhoan tk, iMessageView callBack){
        if(tk.getPhanquyen().getMaPhanQuyen() == 1)
            tk.setMatkhauDangNhap("C31F804A0E4A8943A7A5577A292F2321");
        else if(tk.getPhanquyen().getMaPhanQuyen() == 2)
            tk.setMatkhauDangNhap("9B84756F9A50CC0D8223B9A03842CAC4");
        
        boolean result = TaiKhoanDAO.capNhatTaiKhoan(tk);
        
        if(result)
            callBack.showMessageAndReloadData("Reset mật khẩu Thành Công", iMessageView.SUCCESS);
        else
            callBack.showMessageAndReloadData("Reset mật khẩu Thất Bại", iMessageView.FAIL);
    }
    
    public void thayDoiMatKhau(TaiKhoan tk, String matKhauCu, String matKhauMoi, iMessageView callBack){
        String newPass = maHoaMatKhau(matKhauMoi);
        String oldPass = maHoaMatKhau(matKhauCu);
        
        if(tk.getMatkhauDangNhap().compareTo(oldPass) != 0){
            callBack.showMessageAndReloadData("Mật khẩu cũ không trùng khớp", iMessageView.NONE);
            return;
        }
        
        tk.setMatkhauDangNhap(newPass);
        
        boolean result = TaiKhoanDAO.capNhatTaiKhoan(tk);
        
        if(result)
            callBack.showMessageAndReloadData("Thay đổi mật khẩu Thành Công", iMessageView.SUCCESS);
        else
            callBack.showMessageAndReloadData("Thay đổi mật khẩu Thất Bại", iMessageView.FAIL);
    }
    
    public void dangNhap(String tenDN, String matKhau, iDangNhapView callBack){
        String pass = maHoaMatKhau(matKhau);
        
        TaiKhoan tk = TaiKhoanDAO.login(tenDN, pass);
        
        if(null != tk)
            callBack.dangNhapThanhCong(tk);
        else
            callBack.dangNhapThatBai();
    }
}
