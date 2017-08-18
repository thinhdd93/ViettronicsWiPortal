package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.SinhNhat;

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
 * Created by thinh on 8/7/2017.
 */

public class SinhNhatAdapter extends ArrayAdapter<SinhNhat> {
    private Activity context;
    private int resource;
    private ArrayList<SinhNhat> listCanBo;
    public SinhNhatAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull ArrayList<SinhNhat> listCanBo) {
        super(context, resource, listCanBo);
        this.context = context;
        this.resource = resource;
        this.listCanBo = listCanBo;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(resource, null);
        if (convertView == null){
            convertView = inflater.inflate(resource, null);
        }

        TextView txtTenCanBo = (TextView) convertView.findViewById(R.id.sinhnhat_tenCanBo);
        TextView txtChucVu = (TextView) convertView.findViewById(R.id.sinhnhat_ChucVu);
        TextView txtDonVi = (TextView) convertView.findViewById(R.id.sinhnhat_donVi);
        TextView txtNgaySinh = (TextView) convertView.findViewById(R.id.sinhnhat_NgaySinh);
        TextView txtMail = (TextView) convertView.findViewById(R.id.sinhnhat_Mail);

        ImageView imgAvatar = (ImageView) convertView.findViewById(R.id.sinhnhat_img_avatar);
        ImageView imgDonVi = (ImageView) convertView.findViewById(R.id.sinhnhat_img_donVi);
        ImageView imgNgaySinh = (ImageView) convertView.findViewById(R.id.sinhnhat_img_ngaySinh);
        ImageView imgMail = (ImageView) convertView.findViewById(R.id.sinhnhat_img_mail);

        imgAvatar.setImageResource(R.mipmap.ic_avatar_square_512);
        imgDonVi.setImageResource(R.mipmap.ic_diagram);
        imgNgaySinh.setImageResource(R.mipmap.ic_birthday_128);
        imgMail.setImageResource(R.mipmap.ic_mail_128);

        SinhNhat sinhNhat = listCanBo.get(position);
        txtTenCanBo.setText(sinhNhat.getTenCanBo().toString());
        txtDonVi.setText(sinhNhat.getDonVi().toString());
        txtChucVu.setText(sinhNhat.getChucVu().toString());
        txtNgaySinh.setText(sinhNhat.getNgaySinh().toString());
        txtMail.setText(sinhNhat.getMail().toString());
        return convertView;
    }
}
