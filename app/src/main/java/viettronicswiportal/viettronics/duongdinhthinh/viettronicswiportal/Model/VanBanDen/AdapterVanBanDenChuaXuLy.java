package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.VanBanDen;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

/**
 * Created by thinh on 7/27/2017.
 */

public class AdapterVanBanDenChuaXuLy extends ArrayAdapter<VanBanDenChoXuLy> {

  Activity context;
  int resource;
  ArrayList<VanBanDenChoXuLy> listVanBanDenChoXuLy;

  public AdapterVanBanDenChuaXuLy(@NonNull Activity context,
      @LayoutRes int resource,
      @NonNull ArrayList<VanBanDenChoXuLy> listVanBanDenChoXuLy) {
    super(context, resource, listVanBanDenChoXuLy);
    this.context = context;
    this.resource = resource;
    this.listVanBanDenChoXuLy = listVanBanDenChoXuLy;
  }

  @NonNull
  @Override
  public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater inflater = context.getLayoutInflater();
    convertView = inflater.inflate(resource, null);

    if (convertView == null){
      convertView = inflater.inflate(resource, null);
    }

    TextView text_TieuDe = (TextView) convertView.findViewById(R.id.txtTieuDe);
    TextView text_NgayThongBao = (TextView) convertView.findViewById(R.id.txtNgayThongBao);
    TextView text_NgayHoanThanh = (TextView) convertView.findViewById(R.id.txtNgayHoanThanh);
    TextView text_NgayBatDau = (TextView) convertView.findViewById(R.id.txtNgayBatDau);
    TextView text_SoHieu = (TextView) convertView.findViewById(R.id.txtSoHieu);
    TextView text_KyHieu = (TextView) convertView.findViewById(R.id.txtKyHieu);

    ImageView img_Delete = (ImageView) convertView.findViewById(R.id.imgIconDelete);

    VanBanDenChoXuLy vanBanDenChoXuLy = listVanBanDenChoXuLy.get(position);

    text_KyHieu.setText(vanBanDenChoXuLy.getKyHieu());
    text_NgayBatDau.setText(vanBanDenChoXuLy.getNgayBatDau());
    text_NgayHoanThanh.setText(vanBanDenChoXuLy.getNgayHoanThanh());
    text_NgayThongBao.setText(vanBanDenChoXuLy.getNgayThongBao());
    text_SoHieu.setText(String.valueOf(vanBanDenChoXuLy.getSoHieu()));
    text_TieuDe.setText(vanBanDenChoXuLy.getTieuDe());

    img_Delete.setImageResource(R.mipmap.icon_delete);
    img_Delete.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        listVanBanDenChoXuLy.remove(position);
        notifyDataSetChanged();
      }
    });

    return convertView;
  }


}
