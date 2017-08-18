package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.VanBanDen;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

/**
 * Created by thinh on 7/31/2017.
 */

public class AdapterUsersPhoiHopXuLyGiamSat extends ArrayAdapter<NguoiXuLyPhoiHopGiamSat> {

  Activity context;
  int resource;
  ArrayList<NguoiXuLyPhoiHopGiamSat> list;
  NguoiXuLyPhoiHopGiamSat nguoiXuLyPhoiHopGiamSat;
  public AdapterUsersPhoiHopXuLyGiamSat(@NonNull Activity context,
      @LayoutRes int resource,
      @NonNull ArrayList<NguoiXuLyPhoiHopGiamSat> list) {
    super(context, resource, list);
    this.context = context;
    this.resource = resource;
    this.list = list;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater inflater = context.getLayoutInflater();
    convertView = inflater.inflate(resource, null);
    if (convertView == null){
      convertView = inflater.inflate(resource, null);
    }

    TextView text_Ten = (TextView) convertView.findViewById(R.id.item_listview_hoten);
    TextView text_ChucVu = (TextView) convertView.findViewById(R.id.item_listview_chucVu);

    nguoiXuLyPhoiHopGiamSat = list.get(position);
    text_ChucVu.setText(nguoiXuLyPhoiHopGiamSat.getChucVu().toString());
    text_Ten.setText(nguoiXuLyPhoiHopGiamSat.getName().toString());
    return convertView;
  }
}
