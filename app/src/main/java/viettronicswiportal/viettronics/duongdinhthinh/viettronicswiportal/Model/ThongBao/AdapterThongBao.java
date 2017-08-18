package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.ThongBao;

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
 * Created by thinh on 8/4/2017.
 */

public class AdapterThongBao extends ArrayAdapter<ThongBao> {
    private Activity context;
    private int resource;
    private ArrayList<ThongBao> listThongBao;
    ThongBao thongBao;
    public AdapterThongBao(@NonNull Activity context, @LayoutRes int resource, @NonNull ArrayList<ThongBao> listThongBao) {
        super(context, resource, listThongBao);
        this.context = context;
        this.resource = resource;
        this.listThongBao = listThongBao;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(resource, null);
        if (convertView == null) {
            convertView = inflater.inflate(resource, null);
        }

        TextView txtTieuDe = (TextView) convertView.findViewById(R.id.thongbao_TieuDe);
        TextView txtNguoiThongBao = (TextView) convertView.findViewById(R.id.thongbao_txt_NguoiUpload);
        TextView txtNgayThongBao  = (TextView) convertView.findViewById(R.id.thongbao_txt_NgayUpload);

        ImageView imgNguoiUpload = (ImageView) convertView.findViewById(R.id.thongbao_img_NguoiUpload);
        ImageView imgNgayUpload = (ImageView) convertView.findViewById(R.id.thongbao_img_NgayUpload);
        ImageView imgAttach = (ImageView) convertView.findViewById(R.id.thongbao_img_attach);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.thongbao_img_view);

        imgAttach.setImageResource(R.mipmap.ic_attach);
        imgNguoiUpload.setImageResource(R.mipmap.ic_personal_128);
        imgNgayUpload.setImageResource(R.mipmap.ic_clock);
        imgView.setImageResource(R.mipmap.ic_eye);

        thongBao = listThongBao.get(position);
        txtTieuDe.setText(thongBao.getTieuDe().toString());
        txtNguoiThongBao.setText(thongBao.getNguoiThongBao().toString());
        txtNgayThongBao.setText(thongBao.getNgayThongBao().toString());
        return convertView;
    }
}
