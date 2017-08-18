package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model;

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
 * Created by thinh on 7/28/2017.
 */

public class AdapterAddUser extends ArrayAdapter<CommentUser> {

  Activity context;
  int resource;
  ArrayList<CommentUser> listUser;

  public AdapterAddUser(@NonNull Activity context,
      @LayoutRes int resource,
      @NonNull ArrayList<CommentUser> listUser) {
    super(context, resource, listUser);
    this.context = context;
    this.resource = resource;
    this.listUser = listUser;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater inflater = context.getLayoutInflater();
    convertView = inflater.inflate(resource, null);
    if (convertView == null) {
      convertView = inflater.inflate(resource, null);
    }
    ImageView imgAvatar = (ImageView) convertView.findViewById(R.id.detail_Avatar);
    TextView text_hoTen = (TextView) convertView.findViewById(R.id.detail_TenCanBo);
    TextView text_chucVu = (TextView) convertView.findViewById(R.id.detail_ChucVu);
    TextView text_thoiGian = (TextView) convertView.findViewById(R.id.detail_ThoiGian);
    TextView text_binhLuan = (TextView) convertView.findViewById(R.id.detail_Comment);

    CommentUser user = listUser.get(position);

    imgAvatar.setImageResource(R.mipmap.ic_avatar_square);
    text_hoTen.setText(user.getHoTen().toString());
    text_chucVu.setText(user.getChucVu().toString());
    text_thoiGian.setText(user.getThoiGian().toString());
    text_binhLuan.setText(user.getBinhLuan().toString());
    return convertView;
  }
}
