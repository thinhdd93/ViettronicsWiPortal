package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.ThongBao;

/**
 * Created by thinh on 8/4/2017.
 */

public class ThongBao {
    private String tieuDe;
    private String nguoiThongBao;
    private String ngayThongBao;

    public ThongBao(String tieuDe, String nguoiThongBao, String ngayThongBao) {
        this.tieuDe = tieuDe;
        this.nguoiThongBao = nguoiThongBao;
        this.ngayThongBao = ngayThongBao;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNguoiThongBao() {
        return nguoiThongBao;
    }

    public void setNguoiThongBao(String nguoiThongBao) {
        this.nguoiThongBao = nguoiThongBao;
    }

    public String getNgayThongBao() {
        return ngayThongBao;
    }

    public void setNgayThongBao(String ngayThongBao) {
        this.ngayThongBao = ngayThongBao;
    }
}
