package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.Calendar;

/**
 * Created by thinh on 8/6/2017.
 */

public class LichCoQuan {
    private String tieuDe;
    private String thoiGianBatDau;
    private String ngayBatDau;
    private String thoiGianKetThuc;
    private String ngayKetThuc;
    private String nguoiDieuHanh;
    private String diaChi;

    public LichCoQuan(String tieuDe, String thoiGianBatDau, String ngayBatDau, String thoiGianKetThuc, String ngayKetThuc, String nguoiDieuHanh, String diaChi) {
        this.tieuDe = tieuDe;
        this.thoiGianBatDau = thoiGianBatDau;
        this.ngayBatDau = ngayBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.ngayKetThuc = ngayKetThuc;
        this.nguoiDieuHanh = nguoiDieuHanh;
        this.diaChi = diaChi;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getNguoiDieuHanh() {
        return nguoiDieuHanh;
    }

    public void setNguoiDieuHanh(String nguoiDieuHanh) {
        this.nguoiDieuHanh = nguoiDieuHanh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
