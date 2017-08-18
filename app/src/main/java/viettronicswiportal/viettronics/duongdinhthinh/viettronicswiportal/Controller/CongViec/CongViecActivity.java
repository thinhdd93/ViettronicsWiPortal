package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.CongViec;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.CongViec.AdapterCongViec;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.CongViec.CongViec;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class CongViecActivity extends AppCompatActivity {
    private ListView listview_CongViecDuocGiao;
    private ArrayList<CongViec> listCongViecDuocGiao;
    private AdapterCongViec adapterCongViec;

    private ImageView imgSend, imgAttach;
    private Spinner spinnerChucVu;
    private ArrayAdapter<String> adapterSpinner;
    private EditText editNoiDung, editTieuDe;

    private String[] listChucVu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cong_viec);
        customBar();
        loadTabHost();
        addControls();
        addEvents();
    }

    private void addEvents() {
        giaoCongViec();
        listview_CongViecDuocGiao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CongViecActivity.this, ChiTietCongViecActivity.class);
                startActivity(intent);
                Toast.makeText(CongViecActivity.this, "Đã chọn " + listCongViecDuocGiao.get(i).getTieuDe().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void giaoCongViec() {
        listCongViecDuocGiao.add(new CongViec("Xử lý tồn tại phần thứ nhất TBA 220KV KonTum và đầu nối",
                "Tầng 11, Tòa nhà Mipec, 229 Tây Sơn, Đống Đa, Hà Nội",
                "02/08/2017",
                "02/09/2017"));
        listCongViecDuocGiao.add(new CongViec("Thông báo về việc thay đổi nhân sự Tổng Công ty và HĐQT",
                "Tầng 11, Tòa nhà Mipec, 229 Tây Sơn, Đống Đa, Hà Nội",
                "02/08/2017",
                "02/09/2017"));
        listCongViecDuocGiao.add(new CongViec("Thông báo tình hình tài chính quý I, II, III năm 2017",
                "Tầng 11, Tòa nhà Mipec, 229 Tây Sơn, Đống Đa, Hà Nội",
                "02/08/2017",
                "02/09/2017"));
        listCongViecDuocGiao.add(new CongViec("Xử lý tồn tại phần thứ nhất TBA 220KV KonTum và đầu nối",
                "Tầng 11, Tòa nhà Mipec, 229 Tây Sơn, Đống Đa, Hà Nội",
                "02/08/2017",
                "02/09/2017"));
        listCongViecDuocGiao.add(new CongViec("Xử lý tồn tại phần thứ nhất TBA 220KV KonTum và đầu nối",
                "Tầng 11, Tòa nhà Mipec, 229 Tây Sơn, Đống Đa, Hà Nội",
                "02/08/2017",
                "02/09/2017"));
    }

    private void addControls() {
        editTieuDe = (EditText) findViewById(R.id.congviec_edit_TieuDe);
        editNoiDung = (EditText) findViewById(R.id.edit_congviec_noidung);
        imgAttach = (ImageView) findViewById(R.id.img_congviec_attach);
        imgSend = (ImageView) findViewById(R.id.img_congviec_Send);

        listChucVu = getResources().getStringArray(R.array.spinner_chuc_vu);

        spinnerChucVu = (Spinner) findViewById(R.id.congviec_spinner_chucvu);
        adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listChucVu);
        spinnerChucVu.setAdapter(adapterSpinner);

        listview_CongViecDuocGiao = (ListView) findViewById(R.id.listview_CongViec_DuocGiao);
        listCongViecDuocGiao = new ArrayList<>();
        adapterCongViec = new AdapterCongViec(CongViecActivity.this, R.layout.custom_listview_congviec, listCongViecDuocGiao);
        listview_CongViecDuocGiao.setAdapter(adapterCongViec);
    }

    private void customBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(R.color.yellow_veic)));
        }
        actionBar.setCustomView(R.layout.navigation_bar_veic);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Doi mau Status bar
        Window window = getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getBaseContext().getResources().getColor(R.color.text_black));
        }
    }

    private void loadTabHost() {
        final TabHost tabHost = (TabHost) this.findViewById(android.R.id.tabhost);
        tabHost.setup();

        //tab1
        TabHost.TabSpec spec1;
        spec1 = tabHost.newTabSpec("t4");
        spec1.setContent(R.id.tab4);
        spec1.setIndicator(getResources().getString(R.string.duoc_giao));
        tabHost.addTab(spec1);

        //tab2
        TabHost.TabSpec spec2;
        spec2 = tabHost.newTabSpec("t5");
        spec2.setContent(R.id.tab5);
        spec2.setIndicator(getResources().getString(R.string.CV_giao));
        tabHost.addTab(spec2);

        //tab3
        TabHost.TabSpec spec3;
        spec3 = tabHost.newTabSpec("t6");
        spec3.setContent(R.id.tab6);
        spec3.setIndicator(getResources().getString(R.string.giao_viec));
        tabHost.addTab(spec3);

        tabHost.setCurrentTab(0);

        TextView x1 = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        x1.setTextSize(12);
        x1.setAllCaps(false);
        TextView x2 = (TextView) tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
        x2.setTextSize(12);
        x2.setAllCaps(false);
        TextView x3 = (TextView) tabHost.getTabWidget().getChildAt(2).findViewById(android.R.id.title);
        x3.setTextSize(12);
        x3.setAllCaps(false);
    }
}
