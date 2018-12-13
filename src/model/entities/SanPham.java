package model.entities;
// Generated Dec 11, 2018 1:37:51 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sanpham generated by hbm2java
 */
@Entity
@Table(name = "sanpham", catalog = "qlchdd")
public class SanPham implements java.io.Serializable {

	private int maSp;
	private String tenSp;
	private String loai;
	private NhaSanXuat nhasanxuat;
	private Integer sl;
	private Integer namSx;
	private Double thueVat;
	private Double giaBanRa;
	private Integer thoigianBh;
	private String xuatxu;
	private String mau;
	private String bonho;
	private String kichthuoc;
	private byte[] anh;
	private Integer tinhtrang;
	private Set<KhuyenMai> khuyenmais = new HashSet<KhuyenMai>(0);
	private Set<CthdMua> cthdMuas = new HashSet<CthdMua>(0);
	private Set<CthdBan> cthdBans = new HashSet<CthdBan>(0);
        private Set<BaoHanh> baohanhs = new HashSet<BaoHanh>(0);
	

	public SanPham() {
	}

        public SanPham(int maSp, String tenSp, String loai, NhaSanXuat nhasanxuat, Integer sl, Integer namSx, Double thueVat, Double giaBanRa, Integer thoigianBh, String xuatxu, String mau, String bonho, String kichthuoc, byte[] anh, Integer tinhtrang) {
            this.maSp = maSp;
            this.tenSp = tenSp;
            this.loai = loai;
            this.nhasanxuat = nhasanxuat;
            this.sl = sl;
            this.namSx = namSx;
            this.thueVat = thueVat;
            this.giaBanRa = giaBanRa;
            this.thoigianBh = thoigianBh;
            this.xuatxu = xuatxu;
            this.mau = mau;
            this.bonho = bonho;
            this.kichthuoc = kichthuoc;
            this.anh = anh;
            this.tinhtrang = tinhtrang;
        }
        
	@Id

	@Column(name = "ma_SP", unique = true, nullable = false)
	public int getMaSp() {
		return this.maSp;
	}

	public void setMaSp(int maSp) {
		this.maSp = maSp;
	}
	

	@Column(name = "ten_SP", length = 45)
	public String getTenSp() {
		return this.tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	@Column(name = "loai", length = 45)
	public String getLoai() {
		return this.loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

        @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_nsx")
	public NhaSanXuat getNhasanxuat() {
            return this.nhasanxuat;
	}

	public void setNhasanxuat(NhaSanXuat nhasanxuat) {
		this.nhasanxuat = nhasanxuat;
	}
        
	@Column(name = "sl")
	public Integer getSl() {
		return this.sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	@Column(name = "nam_SX")
	public Integer getNamSx() {
		return this.namSx;
	}

	public void setNamSx(Integer namSx) {
		this.namSx = namSx;
	}

	@Column(name = "thue_VAT", precision = 22, scale = 0)
	public Double getThueVat() {
		return this.thueVat;
	}

	public void setThueVat(Double thueVat) {
		this.thueVat = thueVat;
	}

	@Column(name = "gia_BanRa", precision = 22, scale = 0)
	public Double getGiaBanRa() {
		return this.giaBanRa;
	}

	public void setGiaBanRa(Double giaBanRa) {
		this.giaBanRa = giaBanRa;
	}

	@Column(name = "thoigian_BH")
	public Integer getThoigianBh() {
		return this.thoigianBh;
	}

	public void setThoigianBh(Integer thoigianBh) {
		this.thoigianBh = thoigianBh;
	}

	@Column(name = "xuatxu", length = 45)
	public String getXuatxu() {
		return this.xuatxu;
	}

	public void setXuatxu(String xuatxu) {
		this.xuatxu = xuatxu;
	}

	@Column(name = "mau", length = 45)
	public String getMau() {
		return this.mau;
	}

	public void setMau(String mau) {
		this.mau = mau;
	}

	@Column(name = "bonho", length = 45)
	public String getBonho() {
		return this.bonho;
	}

	public void setBonho(String bonho) {
		this.bonho = bonho;
	}

	@Column(name = "kichthuoc", length = 45)
	public String getKichthuoc() {
		return this.kichthuoc;
	}

	public void setKichthuoc(String kichthuoc) {
		this.kichthuoc = kichthuoc;
	}

	@Column(name = "anh")
	public byte[] getAnh() {
		return this.anh;
	}

	public void setAnh(byte[] anh) {
		this.anh = anh;
	}

	@Column(name = "tinhtrang")
	public Integer getTinhtrang() {
		return this.tinhtrang;
	}

	public void setTinhtrang(Integer tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "sanphams")
	public Set<KhuyenMai> getKhuyenmais() {
		return this.khuyenmais;
	}

	public void setKhuyenmais(Set<KhuyenMai> khuyenmais) {
		this.khuyenmais = khuyenmais;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sanpham")
	public Set<CthdMua> getCthdMuas() {
		return this.cthdMuas;
	}

	public void setCthdMuas(Set<CthdMua> cthdMuas) {
		this.cthdMuas = cthdMuas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sanpham")
	public Set<CthdBan> getCthdBans() {
		return this.cthdBans;
	}

	public void setCthdBans(Set<CthdBan> cthdBans) {
		this.cthdBans = cthdBans;
	}

	
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "sanpham")
        public Set<BaoHanh> getBaohanhs() {
            return baohanhs;
        }

        public void setBaohanhs(Set<BaoHanh> baohanhs) {
            this.baohanhs = baohanhs;
        }
        
        

}
