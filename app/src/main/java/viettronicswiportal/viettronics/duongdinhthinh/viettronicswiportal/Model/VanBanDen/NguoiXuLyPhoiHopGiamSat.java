package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.VanBanDen;

/**
 * Created by thinh on 7/31/2017.
 */

public class NguoiXuLyPhoiHopGiamSat {
  private String name;
  private String chucVu;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getChucVu() {
    return chucVu;
  }

  public void setChucVu(String chucVu) {
    this.chucVu = chucVu;
  }

  public NguoiXuLyPhoiHopGiamSat(String name, String chucVu) {
    this.name = name;
    this.chucVu = chucVu;
  }

}
