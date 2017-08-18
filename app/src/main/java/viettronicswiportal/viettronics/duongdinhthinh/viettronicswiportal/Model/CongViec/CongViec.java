package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.CongViec;

/**
 * Created by thinh on 8/2/2017.
 */

public class CongViec {
  private String tieuDe;
  private String diaChi;
  private String ngayGiaoViec;
  private String ngayHoanThanh;

  public CongViec(String tieuDe, String diaChi, String ngayGiaoViec, String ngayHoanThanh) {
    this.tieuDe = tieuDe;
    this.diaChi = diaChi;
    this.ngayGiaoViec = ngayGiaoViec;
    this.ngayHoanThanh = ngayHoanThanh;
  }

  public String getTieuDe() {
    return tieuDe;
  }

  public void setTieuDe(String tieuDe) {
    this.tieuDe = tieuDe;
  }

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  public String getNgayGiaoViec() {
    return ngayGiaoViec;
  }

  public void setNgayGiaoViec(String ngayGiaoViec) {
    this.ngayGiaoViec = ngayGiaoViec;
  }

  public String getNgayHoanThanh() {
    return ngayHoanThanh;
  }

  public void setNgayHoanThanh(String ngayHoanThanh) {
    this.ngayHoanThanh = ngayHoanThanh;
  }
}
