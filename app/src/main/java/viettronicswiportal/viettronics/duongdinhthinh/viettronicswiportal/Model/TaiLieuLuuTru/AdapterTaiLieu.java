package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.TaiLieuLuuTru;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

/**
 * Created by thinh on 8/3/2017.
 */

public class AdapterTaiLieu extends ArrayAdapter<TaiLieuLuuTru> implements Filterable {
  private Activity context;
  private int resource;
  private ArrayList<TaiLieuLuuTru> listTaiLieu;
  private TaiLieuLuuTru taiLieuLuuTru;
  private ArrayList<TaiLieuLuuTru> list;

  public AdapterTaiLieu(@NonNull Activity context,
      @LayoutRes int resource,
      @NonNull ArrayList<TaiLieuLuuTru> listTaiLieu) {
    super(context, resource, listTaiLieu);
    this.context = context;
    this.resource = resource;
    this.listTaiLieu = listTaiLieu;
  }

  public Filter getFilter() {
    return new Filter() {

      @Override
      protected FilterResults performFiltering(CharSequence constraint) {
        final FilterResults oReturn = new FilterResults();
        final ArrayList<TaiLieuLuuTru> results = new ArrayList<TaiLieuLuuTru>();
        if (list == null)
          list = listTaiLieu;
        if (constraint != null) {
          if (list != null && list.size() > 0) {
            for (final TaiLieuLuuTru g : list) {
              if (g.getTieuDe().toLowerCase()
                  .contains(constraint.toString()))
                results.add(g);
            }
          }
          oReturn.values = results;
        }
        return oReturn;
      }

      @SuppressWarnings("unchecked")
      @Override
      protected void publishResults(CharSequence constraint,
          FilterResults results) {
        listTaiLieu = (ArrayList<TaiLieuLuuTru>) results.values;
        notifyDataSetChanged();
      }
    };
  }

  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater inflater = context.getLayoutInflater();
    convertView = inflater.inflate(resource, null);
    if (convertView == null){
      convertView = inflater.inflate(resource, null);
    }

    TextView txtTieuDe = (TextView) convertView.findViewById(R.id.tailieu_TieuDe);
    TextView txtDonVi = (TextView) convertView.findViewById(R.id.tailieu_txt_DonVi);
    TextView txtLoaiVanBan = (TextView) convertView.findViewById(R.id.tailieu_txt_LoaiVanBan);
    TextView txtNgayUpload = (TextView) convertView.findViewById(R.id.tailieu_txt_NgayUpload);
    TextView txtHoanThanh = (TextView) convertView.findViewById(R.id.tailieu_txt_HoanThanh);

    ImageView imgDonVi = (ImageView) convertView.findViewById(R.id.tailieu_img_DonVi);
    ImageView imgLoaiVanBan = (ImageView) convertView.findViewById(R.id.tailieu_img_LoaiVanBan);
    ImageView imgNgayUpload = (ImageView) convertView.findViewById(R.id.tailieu_img_NgayUpload);
    ImageView imgHoanThanh = (ImageView) convertView.findViewById(R.id.tailieu_img_HoanThanh);
    ImageView imgUncheck = (ImageView) convertView.findViewById(R.id.tailieu_img_uncheck);
    ImageView imgView = (ImageView) convertView.findViewById(R.id.tailieu_img_View);

    imgDonVi.setImageResource(R.mipmap.ic_diagram);
    imgLoaiVanBan.setImageResource(R.mipmap.ic_finger);
    imgNgayUpload.setImageResource(R.mipmap.ic_clock);
    imgHoanThanh.setImageResource(R.mipmap.ic_checked);
    imgUncheck.setImageResource(R.mipmap.ic_red_checked);
    imgView.setImageResource(R.mipmap.ic_eye);

    taiLieuLuuTru = listTaiLieu.get(position);
    txtDonVi.setText(taiLieuLuuTru.getDonVi().toString());
    txtTieuDe.setText(taiLieuLuuTru.getTieuDe().toString());
    txtLoaiVanBan.setText(taiLieuLuuTru.getLoaiVanBan().toString());
    txtNgayUpload.setText(taiLieuLuuTru.getNgayUpload().toString());
    txtHoanThanh.setText(taiLieuLuuTru.getNgayHoanThanh().toString());

    return convertView;
  }
}
