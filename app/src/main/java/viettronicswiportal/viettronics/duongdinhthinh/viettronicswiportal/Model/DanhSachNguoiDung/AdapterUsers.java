package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.DanhSachNguoiDung;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

/**
 * Created by thinh on 8/9/2017.
 */

public class AdapterUsers extends ArrayAdapter<Users> {
    private Activity context;
    private int resource;
    private ArrayList<Users> listUsers;
    public AdapterUsers(@NonNull Activity context, @LayoutRes int resource, @NonNull ArrayList<Users> listUsers) {
        super(context, resource, listUsers);
        this.context = context;
        this.resource = resource;
        this.listUsers = listUsers;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(resource, null);
        if (convertView == null) {
            convertView = inflater.inflate(resource, null);
        }

        TextView txtTenNguoiDung = (TextView) convertView.findViewById(R.id.nguoidung_hoTen);
        TextView txtChucVu = (TextView) convertView.findViewById(R.id.nguoidung_chucVu);
        TextView txtDonVi = (TextView) convertView.findViewById(R.id.nguoidung_donVi);
        TextView txtEmail = (TextView) convertView.findViewById(R.id.nguoidung_email);

        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.nguoidung_checkbox_check);
        checkBox.isChecked();

        ImageView imgAvatar = (ImageView) convertView.findViewById(R.id.nguoidung_avatar);
        imgAvatar.setImageResource(R.mipmap.ic_avatar_square_512);

        Users users = listUsers.get(position);
        txtChucVu.setText(users.getChucVu().toString());
        txtDonVi.setText(users.getDonVi().toString());
        txtEmail.setText(users.getEmai().toString());
        txtTenNguoiDung.setText(users.getHoTen().toString());

        return convertView;


    }
}
