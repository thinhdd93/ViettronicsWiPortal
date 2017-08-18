package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.DanhSachNguoiDung;

/**
 * Created by thinh on 8/9/2017.
 */

public class Users {
    private String hoTen;
    private String chucVu;
    private String donVi;
    private String emai;

    public Users(String hoTen, String chucVu, String donVi, String emai) {
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.donVi = donVi;
        this.emai = emai;
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

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }
}
