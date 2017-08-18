package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.Calendar;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

/**
 * Created by thinh on 8/6/2017.
 */

public class LichCoQuanAdapter extends ArrayAdapter<LichCoQuan> {
    private Activity context;
    private int resource;
    private ArrayList<LichCoQuan> listCongViec;

    public LichCoQuanAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull ArrayList<LichCoQuan> listCongViec) {
        super(context, resource, listCongViec);
        this.context = context;
        this.resource = resource;
        this.listCongViec = listCongViec;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(resource, null);
        if (convertView == null) {
            convertView = inflater.inflate(resource, null);
        }
        TextView txtTieuDe = (TextView) convertView.findViewById(R.id.listview_lichcoquan_tieuDe);
        TextView txtThoiGianBatDau = (TextView) convertView.findViewById(R.id.listview_lichcoquan_thoigianbatdau);
        TextView txtNgayBatDau = (TextView) convertView.findViewById(R.id.listview_lichcoquan_ngaybatdau);
        TextView txtThoiGianKetThuc = (TextView) convertView.findViewById(R.id.listview_lichcoquan_thoigianketthuc);
        TextView txtNgayKetThuc = (TextView) convertView.findViewById(R.id.listview_lichcoquan_ngayketthuc);
        TextView txtNguoiDieuHanh = (TextView) convertView.findViewById(R.id.listview_lichcoquan_nguoidieuhanh);
        TextView txtDiaChi = (TextView) convertView.findViewById(R.id.listview_lichcoquan_diachi);

        ImageView imgAlarm = (ImageView) convertView.findViewById(R.id.img_lichcoquan_thongbao);
        ImageView imgUser = (ImageView) convertView.findViewById(R.id.img_lichcoquan_nguoidieuhanh);
        ImageView imgLocation = (ImageView) convertView.findViewById(R.id.img_lichcoquan_location);

        imgAlarm.setImageResource(R.mipmap.icon_alarm);
        imgUser.setImageResource(R.mipmap.ic_personal_128);
        imgLocation.setImageResource(R.mipmap.ic_location_128);

        LichCoQuan lichCoQuan = listCongViec.get(position);

        txtTieuDe.setText(lichCoQuan.getTieuDe().toString());
        txtThoiGianBatDau.setText(lichCoQuan.getThoiGianBatDau().toString());
        txtNgayBatDau.setText(lichCoQuan.getNgayBatDau().toString());
        txtThoiGianKetThuc.setText(lichCoQuan.getThoiGianKetThuc().toString());
        txtNgayKetThuc.setText(lichCoQuan.getNgayKetThuc().toString());
        txtNguoiDieuHanh.setText(lichCoQuan.getNguoiDieuHanh().toString());
        txtDiaChi.setText(lichCoQuan.getDiaChi().toString());
        return convertView;
    }
}
