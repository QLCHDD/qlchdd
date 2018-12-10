package model.entities;
// Generated Dec 7, 2018 9:42:19 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CthdMua generated by hbm2java
 */
@Entity
@Table(name = "cthd_mua", catalog = "qlchdd")
public class CthdMua implements java.io.Serializable {

	private CthdMuaId id;
	private HoaDonMua hoadonmua;
	private SanPham sanpham;
	private Integer sl;
	private Double thanhtien;

	public CthdMua() {
	}

	public CthdMua(CthdMuaId id, HoaDonMua hoadonmua, SanPham sanpham) {
		this.id = id;
		this.hoadonmua = hoadonmua;
		this.sanpham = sanpham;
	}

	public CthdMua(CthdMuaId id, HoaDonMua hoadonmua, SanPham sanpham, Integer sl, Double thanhtien) {
		this.id = id;
		this.hoadonmua = hoadonmua;
		this.sanpham = sanpham;
		this.sl = sl;
		this.thanhtien = thanhtien;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "sohdMua", column = @Column(name = "sohd_Mua", nullable = false)),
			@AttributeOverride(name = "maSp", column = @Column(name = "ma_SP", nullable = false)) })
	public CthdMuaId getId() {
		return this.id;
	}

	public void setId(CthdMuaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sohd_Mua", nullable = false, insertable = false, updatable = false)
	public HoaDonMua getHoadonmua() {
		return this.hoadonmua;
	}

	public void setHoadonmua(HoaDonMua hoadonmua) {
		this.hoadonmua = hoadonmua;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_SP", nullable = false, insertable = false, updatable = false)
	public SanPham getSanpham() {
		return this.sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	@Column(name = "sl")
	public Integer getSl() {
		return this.sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	@Column(name = "thanhtien", precision = 22, scale = 0)
	public Double getThanhtien() {
		return this.thanhtien;
	}

	public void setThanhtien(Double thanhtien) {
		this.thanhtien = thanhtien;
	}

}