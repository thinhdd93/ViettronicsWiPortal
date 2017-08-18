package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.TaiLieuLuuTru;

/**
 * Created by thinh on 8/3/2017.
 */

public class TaiLieuLuuTru {
  private String tieuDe;
  private String donVi;
  private String loaiVanBan;
  private String ngayUpload;
  private String ngayHoanThanh;


  public TaiLieuLuuTru(String tieuDe, String donVi, String loaiVanBan, String ngayUpload,
                       String ngayHoanThanh) {
    this.tieuDe = tieuDe;
    this.donVi = donVi;
    this.loaiVanBan = loaiVanBan;
    this.ngayUpload = ngayUpload;
    this.ngayHoanThanh = ngayHoanThanh;
  }

  public String getTieuDe() {
    return tieuDe;
  }

  public void setTieuDe(String tieuDe) {
    this.tieuDe = tieuDe;
  }

  public String getDonVi() {
    return donVi;
  }

  public void setDonVi(String donVi) {
    this.donVi = donVi;
  }

  public String getLoaiVanBan() {
    return loaiVanBan;
  }

  public void setLoaiVanBan(String loaiVanBan) {
    this.loaiVanBan = loaiVanBan;
  }

  public String getNgayUpload() {
    return ngayUpload;
  }

  public void setNgayUpload(String ngayUpload) {
    this.ngayUpload = ngayUpload;
  }

  public String getNgayHoanThanh() {
    return ngayHoanThanh;
  }

  public void setNgayHoanThanh(String ngayHoanThanh) {
    this.ngayHoanThanh = ngayHoanThanh;
  }
}
