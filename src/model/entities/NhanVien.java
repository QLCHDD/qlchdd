package model.entities;
// Generated Dec 11, 2018 1:37:51 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Nhanvien generated by hbm2java
 */
@Entity
@Table(name = "nhanvien", catalog = "qlchdd")
public class NhanVien implements java.io.Serializable {

	private int maNv;
	private String tenNv;
	private Integer soCmndNv;
	private Boolean gioitinh;
	private Date ngaysinhNv;
	private String diachiNv;
	private Integer soDtNv;
	private Date ngayVaoLam;
	private Double luongCb;
	private Integer tinhTrang;
	private Set<HoaDonBan> hoadonbans = new HashSet<HoaDonBan>(0);
	private Set<HoaHong> hoahongs = new HashSet<HoaHong>(0);
        private TaiKhoan taikhoan;
        private Set<BaoHanh> baohanhsForNhanvienTra = new HashSet<BaoHanh>(0);
	private Set<BaoHanh> baohanhsForNhanvienNhan = new HashSet<BaoHanh>(0);
        private Set<HoaDonMua> hoadonmuas = new HashSet<HoaDonMua>(0);

	public NhanVien() {
	}

	public NhanVien(String tenNv, Integer soCmndNv, Boolean gioitinh, Date ngaysinhNv, String diachiNv,
			Integer soDtNv, Date ngayVaoLam, Double luongCb, Integer tinhTrang) {
            this.tenNv = tenNv;
            this.soCmndNv = soCmndNv;
            this.gioitinh = gioitinh;
            this.ngaysinhNv = ngaysinhNv;
            this.diachiNv = diachiNv;
            this.soDtNv = soDtNv;
            this.ngayVaoLam = ngayVaoLam;
            this.luongCb = luongCb;
            this.tinhTrang = tinhTrang;
	}

        public NhanVien(int maNv, String tenNv, Integer soCmndNv, Boolean gioitinh, Date ngaysinhNv, String diachiNv, Integer soDtNv, Date ngayVaoLam, Double luongCb, Integer tinhTrang) {
            this.maNv = maNv;
            this.tenNv = tenNv;
            this.soCmndNv = soCmndNv;
            this.gioitinh = gioitinh;
            this.ngaysinhNv = ngaysinhNv;
            this.diachiNv = diachiNv;
            this.soDtNv = soDtNv;
            this.ngayVaoLam = ngayVaoLam;
            this.luongCb = luongCb;
            this.tinhTrang = tinhTrang;
        }

	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_NV", unique = true, nullable = false)
	public int getMaNv() {
		return this.maNv;
	}

	public void setMaNv(int maNv) {
		this.maNv = maNv;
	}

	@Column(name = "ten_NV")
	public String getTenNv() {
		return this.tenNv;
	}

	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}

	@Column(name = "soCMND_NV", unique = true)
	public Integer getSoCmndNv() {
		return this.soCmndNv;
	}

	public void setSoCmndNv(Integer soCmndNv) {
		this.soCmndNv = soCmndNv;
	}

	@Column(name = "gioitinh")
	public Boolean getGioitinh() {
		return this.gioitinh;
	}

	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngaysinh_NV", length = 10)
	public Date getNgaysinhNv() {
		return this.ngaysinhNv;
	}

	public void setNgaysinhNv(Date ngaysinhNv) {
		this.ngaysinhNv = ngaysinhNv;
	}

	@Column(name = "diachi_NV", length = 45)
	public String getDiachiNv() {
		return this.diachiNv;
	}

	public void setDiachiNv(String diachiNv) {
		this.diachiNv = diachiNv;
	}

	@Column(name = "soDT_NV")
	public Integer getSoDtNv() {
		return this.soDtNv;
	}

	public void setSoDtNv(Integer soDtNv) {
		this.soDtNv = soDtNv;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_VaoLam", length = 10)
	public Date getNgayVaoLam() {
		return this.ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	@Column(name = "luong_CB", precision = 22, scale = 0)
	public Double getLuongCb() {
		return this.luongCb;
	}

	public void setLuongCb(Double luongCb) {
		this.luongCb = luongCb;
	}

	@Column(name = "tinh_trang")
	public Integer getTinhTrang() {
		return this.tinhTrang;
	}

	public void setTinhTrang(Integer tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanvien")
	public Set<HoaDonBan> getHoadonbans() {
		return this.hoadonbans;
	}

	public void setHoadonbans(Set<HoaDonBan> hoadonbans) {
		this.hoadonbans = hoadonbans;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanvien")
	public Set<HoaHong> getHoahongs() {
		return this.hoahongs;
	}

	public void setHoahongs(Set<HoaHong> hoahongs) {
		this.hoahongs = hoahongs;
	}

        @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false, mappedBy = "nhanvien")
        public TaiKhoan getTaikhoan() {
            return taikhoan;
        }

        public void setTaikhoan(TaiKhoan taikhoan) {
            this.taikhoan = taikhoan;
        }

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanvienByNhanvienTra")
	public Set<BaoHanh> getBaohanhsForNhanvienTra() {
		return this.baohanhsForNhanvienTra;
	}

	public void setBaohanhsForNhanvienTra(Set<BaoHanh> baohanhsForNhanvienTra) {
		this.baohanhsForNhanvienTra = baohanhsForNhanvienTra;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanvienByNhanvienNhan")
	public Set<BaoHanh> getBaohanhsForNhanvienNhan() {
		return this.baohanhsForNhanvienNhan;
	}

	public void setBaohanhsForNhanvienNhan(Set<BaoHanh> baohanhsForNhanvienNhan) {
		this.baohanhsForNhanvienNhan = baohanhsForNhanvienNhan;
	}
        
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanvien")
	public Set<HoaDonMua> getHoadonmuas() {
		return this.hoadonmuas;
	}

	public void setHoadonmuas(Set<HoaDonMua> hoadonmuas) {
		this.hoadonmuas = hoadonmuas;
	}
        
        @Override
        public String toString() {
            return maNv +"";
        }
}
