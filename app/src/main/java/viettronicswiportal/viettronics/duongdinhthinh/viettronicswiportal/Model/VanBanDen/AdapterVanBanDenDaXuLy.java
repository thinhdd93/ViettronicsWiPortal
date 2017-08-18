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

public class AdapterVanBanDenDaXuLy extends ArrayAdapter<VanBanDenDaXuLy> {
  Activity context;
  int resource;
  ArrayList<VanBanDenDaXuLy> listVanBanDenDaXuLy;
  ArrayList<VanBanDenDaXuLy> list;

  public AdapterVanBanDenDaXuLy(@NonNull Activity context,
      @LayoutRes int resource,
      @NonNull ArrayList<VanBanDenDaXuLy> listVanBanDenDaXuLy) {
    super(context, resource, listVanBanDenDaXuLy);
    this.context = context;
    this.resource = resource;
    this.listVanBanDenDaXuLy = listVanBanDenDaXuLy;

  }

  /*public Filter getFilter() {
    return new Filter() {

      @Override
      protected FilterResults performFiltering(CharSequence constraint) {
        final FilterResults oReturn = new FilterResults();
        final ArrayList<VanBanDenDaXuLy> results = new ArrayList<VanBanDenDaXuLy>();
        if (list == null)
          list = listVanBanDenDaXuLy;
        if (constraint != null) {
          if (list != null && list.size() > 0) {
            for (final VanBanDenDaXuLy g : list) {
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
        listVanBanDenDaXuLy = (ArrayList<VanBanDenDaXuLy>) results.values;
        notifyDataSetChanged();
      }
    };
  }

  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
  }
*/

  @NonNull
  @Override
  public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater inflater = context.getLayoutInflater();
    convertView = inflater.inflate(resource, null);
    if (convertView == null){
      convertView = inflater.inflate(resource, null);
    }

    TextView text_TieuDe = (TextView) convertView.findViewById(R.id.daxuly_TieuDe);
    TextView text_NgayHoanThanh = (TextView) convertView.findViewById(R.id.daxuly_NgayHoanThanh);
    TextView text_SoHieu = (TextView) convertView.findViewById(R.id.daxuly_SoHieu);
    TextView text_KyHieu = (TextView) convertView.findViewById(R.id.daxuly_KyHieu);
    TextView text_TrangThai = (TextView) convertView.findViewById(R.id.daxuly_TrangThai);

    ImageView img_delete = (ImageView) convertView.findViewById(R.id.daxuly_Delete);

    VanBanDenDaXuLy vanBanDenDaXuLy = listVanBanDenDaXuLy.get(position);

    text_TieuDe.setText(vanBanDenDaXuLy.getTieuDe());
    text_NgayHoanThanh.setText(vanBanDenDaXuLy.getNgayHoanThanh());
    text_SoHieu.setText(String.valueOf(vanBanDenDaXuLy.getSoHieu()));
    text_KyHieu.setText(vanBanDenDaXuLy.getKyHieu());
    text_TrangThai.setText(vanBanDenDaXuLy.getTrangThai());
    img_delete.setImageResource(R.mipmap.icon_delete);

    img_delete.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        listVanBanDenDaXuLy.remove(position);
        notifyDataSetChanged();
      }
    });

    return convertView;
  }
}
