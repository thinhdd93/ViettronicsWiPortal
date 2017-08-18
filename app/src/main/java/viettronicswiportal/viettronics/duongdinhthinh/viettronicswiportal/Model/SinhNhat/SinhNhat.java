package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.SinhNhat;

/**
 * Created by thinh on 8/7/2017.
 */

public class SinhNhat {
    private String tenCanBo;
    private String chucVu;
    private String donVi;
    private String ngaySinh;
    private String mail;

    public SinhNhat(String tenCanBo, String chucVu, String donVi, String ngaySinh, String mail) {
        this.tenCanBo = tenCanBo;
        this.chucVu = chucVu;
        this.donVi = donVi;
        this.ngaySinh = ngaySinh;
        this.mail = mail;
    }

    public String getTenCanBo() {
        return tenCanBo;
    }

    public void setTenCanBo(String tenCanBo) {
        this.tenCanBo = tenCanBo;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
