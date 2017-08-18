package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.VanBanDen;

/**
 * Created by thinh on 7/27/2017.
 */

public class VanBanDenDaXuLy {

  private String TieuDe;
  private String NgayHoanThanh;
  private String TrangThai;
  private int SoHieu;
  private String KyHieu;

  public VanBanDenDaXuLy(String tieuDe, String ngayHoanThanh, String trangThai, int soHieu,
                         String kyHieu) {
    TieuDe = tieuDe;
    NgayHoanThanh = ngayHoanThanh;
    TrangThai = trangThai;
    SoHieu = soHieu;
    KyHieu = kyHieu;
  }

  public String getTieuDe() {
    return TieuDe;
  }

  public void setTieuDe(String tieuDe) {
    TieuDe = tieuDe;
  }

  public String getNgayHoanThanh() {
    return NgayHoanThanh;
  }

  public void setNgayHoanThanh(String ngayHoanThanh) {
    NgayHoanThanh = ngayHoanThanh;
  }

  public String getTrangThai() {
    return TrangThai;
  }

  public void setTrangThai(String trangThai) {
    TrangThai = trangThai;
  }

  public int getSoHieu() {
    return SoHieu;
  }

  public void setSoHieu(int soHieu) {
    SoHieu = soHieu;
  }

  public String getKyHieu() {
    return KyHieu;
  }

  public void setKyHieu(String kyHieu) {
    KyHieu = kyHieu;
  }
}
