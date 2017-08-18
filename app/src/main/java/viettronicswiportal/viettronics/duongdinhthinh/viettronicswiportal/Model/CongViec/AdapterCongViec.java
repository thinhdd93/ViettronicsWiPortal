package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.CongViec;

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
 * Created by thinh on 8/2/2017.
 */

public class AdapterCongViec extends ArrayAdapter<CongViec> {
  private Activity context;
  private int resource;
  private ArrayList<CongViec> listCongViec;
  public AdapterCongViec(@NonNull Activity context,
      @LayoutRes int resource,
      @NonNull ArrayList<CongViec> listCongViec) {
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
    TextView txtTieuDe = (TextView) convertView.findViewById(R.id.listview_congviec_tieuDe);
    TextView txtDiaChi = (TextView) convertView.findViewById(R.id.listview_congviec_diachi);
    TextView txtNgayHoanThanh = (TextView) convertView.findViewById(R.id.listview_congviec_ngayhoanthanh);
    TextView txtNgayGiaoViec = (TextView) convertView.findViewById(R.id.listview_congviec_ngaygiaoviec);

    ImageView imgLocation = (ImageView) convertView.findViewById(R.id.img_congviec_location);
    ImageView imgThongBao = (ImageView) convertView.findViewById(R.id.img_congviec_thongbao);

    imgLocation.setImageResource(R.mipmap.icon_location);
    imgThongBao.setImageResource(R.mipmap.icon_alarm);

    CongViec congViec = listCongViec.get(position);
    txtTieuDe.setText(congViec.getTieuDe().toString());
    txtDiaChi.setText(congViec.getDiaChi().toString());
    txtNgayGiaoViec.setText(congViec.getNgayGiaoViec().toString());
    txtNgayHoanThanh.setText(congViec.getNgayHoanThanh().toString());

    return convertView;
  }
}
