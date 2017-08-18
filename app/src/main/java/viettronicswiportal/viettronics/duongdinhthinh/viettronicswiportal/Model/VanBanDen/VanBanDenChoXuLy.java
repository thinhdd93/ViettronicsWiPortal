package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.VanBanDen;

/**
 * Created by thinh on 7/27/2017.
 */

public class VanBanDenChoXuLy {

  private String tieuDe;
  private String ngayThongBao;
  private int soHieu;
  private String kyHieu;
  private String ngayBatDau;

  public String getNgayBatDau() {
    return ngayBatDau;
  }

  public void setNgayBatDau(String ngayBatDau) {
    this.ngayBatDau = ngayBatDau;
  }

  private String ngayHoanThanh;

  public String getTieuDe() {
    return tieuDe;
  }

  public void setTieuDe(String tieuDe) {
    this.tieuDe = tieuDe;
  }

  public String getNgayThongBao() {
    return ngayThongBao;
  }

  public void setNgayThongBao(String ngayThongBao) {
    this.ngayThongBao = ngayThongBao;
  }

  public int getSoHieu() {
    return soHieu;
  }

  public void setSoHieu(int soHieu) {
    this.soHieu = soHieu;
  }

  public String getKyHieu() {
    return kyHieu;
  }

  public void setKyHieu(String kyHieu) {
    this.kyHieu = kyHieu;
  }

  public String getNgayHoanThanh() {
    return ngayHoanThanh;
  }

  public void setNgayHoanThanh(String ngayHoanThanh) {
    this.ngayHoanThanh = ngayHoanThanh;
  }

  public VanBanDenChoXuLy(String tieuDe, String ngayThongBao, int soHieu, String kyHieu,
                          String ngayBatDau, String ngayHoanThanh) {

    this.tieuDe = tieuDe;
    this.ngayThongBao = ngayThongBao;
    this.soHieu = soHieu;
    this.kyHieu = kyHieu;
    this.ngayBatDau = ngayBatDau;
    this.ngayHoanThanh = ngayHoanThanh;
  }
}

