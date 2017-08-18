package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model;

/**
 * Created by thinh on 7/28/2017.
 */

public class CommentUser {
  private String hoTen;
  private String chucVu;
  private String binhLuan;
  private String thoiGian;

  public CommentUser(String hoTen, String chucVu, String binhLuan, String thoiGian) {
    this.hoTen = hoTen;
    this.chucVu = chucVu;
    this.binhLuan = binhLuan;
    this.thoiGian = thoiGian;
  }

  public CommentUser() {
  }

  public String getHoTen() {
    return hoTen;
  }

  public void setHoTen(String hoTen) {
    this.hoTen = hoTen;
  }

  public String getChucVu() {
    return chucVu;
  }

  public void setChucVu(String chucVu) {
    this.chucVu = chucVu;
  }

  public String getBinhLuan() {
    return binhLuan;
  }

  public void setBinhLuan(String binhLuan) {
    this.binhLuan = binhLuan;
  }

  public String getThoiGian() {
    return thoiGian;
  }

  public void setThoiGian(String thoiGian) {
    this.thoiGian = thoiGian;
  }
}
