package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.VanBanDen;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.VanBanDen.AdapterVanBanDenChuaXuLy;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.VanBanDen.AdapterVanBanDenDaXuLy;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.VanBanDen.VanBanDenChoXuLy;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.VanBanDen.VanBanDenDaXuLy;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class VanBanDenActivity extends AppCompatActivity {
    private ListView listview_VanBanDenChoXuLy, listview_VanBanDenDaXuLy;
    private AdapterVanBanDenChuaXuLy adapterChuaXuLy;
    private AdapterVanBanDenDaXuLy adapterDaXuLy;
    private ArrayList<VanBanDenChoXuLy> listVanBanDenChoXuLy = new ArrayList<VanBanDenChoXuLy>();
    private ArrayList<VanBanDenDaXuLy> listVanBanDenDaXuLy = new ArrayList<VanBanDenDaXuLy>();
    private FloatingActionButton fab_ThemVanBanDenChoXuLy;
    private VanBanDenDaXuLy vanBanDenDaXuLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_ban_den);

        customBar();
        loadTabHost();

        addControls();
        addEvents();
    }

    /**
     *Khi bấm back button trên toolbar => kill activity để giải phóng ram
     **/
    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                android.os.Process.killProcess(android.os.Process.myPid());
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    private void addEvents() {
        fab_ThemVanBanDenChoXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VanBanDenActivity.this, ThemVanBanDenCanXuLyActivity.class);
                startActivity(intent);
            }
        });

        listview_VanBanDenDaXuLy.setTextFilterEnabled(true);
        listview_VanBanDenChoXuLy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(VanBanDenActivity.this, ChiTietVanBanActivity.class);
                startActivity(intent);
                Toast.makeText(VanBanDenActivity.this, "Đã chọn " + listVanBanDenChoXuLy.get(i).getTieuDe().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void addControls() {
        listview_VanBanDenChoXuLy = findViewById(R.id.lvVanBanChoXuLy);
        listview_VanBanDenDaXuLy = findViewById(R.id.lvVanBanDaXuLy);

        fab_ThemVanBanDenChoXuLy = findViewById(R.id.fab_ThemVanBanXuLy);

        addVanBanDenDaXuLy();
        addVanBanDenChuaXuLy();

        adapterChuaXuLy = new AdapterVanBanDenChuaXuLy(VanBanDenActivity.this,
                R.layout.custom_listview_congvan_choxuly, listVanBanDenChoXuLy);
        listview_VanBanDenChoXuLy.setAdapter(adapterChuaXuLy);

        adapterDaXuLy = new AdapterVanBanDenDaXuLy(VanBanDenActivity.this,
                R.layout.custom_listview_vanban_daxuly, listVanBanDenDaXuLy);
        listview_VanBanDenDaXuLy.setAdapter(adapterDaXuLy);

    }


    private void addVanBanDenDaXuLy() {
        listVanBanDenDaXuLy
                .add(new VanBanDenDaXuLy("1. Xử lý phần tồn tại thứ nhất TBA 220kV KonTum và đầu nối",
                        "27/08/2017",
                        "Đã hoàn thành",
                        728,
                        "2218/PTC2 - P8"));
        listVanBanDenDaXuLy
                .add(new VanBanDenDaXuLy("2. Xử lý phần tồn tại thứ nhất TBA 220kV KonTum và đầu nối",
                        "27/08/2017",
                        "Đã hoàn thành",
                        728,
                        "2218/PTC2 - P8"));
        listVanBanDenDaXuLy
                .add(new VanBanDenDaXuLy("3. Xử lý phần tồn tại thứ nhất TBA 220kV KonTum và đầu nối",
                        "27/08/2017",
                        "Đã hoàn thành",
                        728,
                        "2218/PTC2 - P8"));
        listVanBanDenDaXuLy
                .add(new VanBanDenDaXuLy("4. Xử lý phần tồn tại thứ nhất TBA 220kV KonTum và đầu nối",
                        "27/08/2017",
                        "Đã hoàn thành",
                        728,
                        "2218/PTC2 - P8"));
        listVanBanDenDaXuLy
                .add(new VanBanDenDaXuLy("5. Xử lý phần tồn tại thứ nhất TBA 220kV KonTum và đầu nối",
                        "27/08/2017",
                        "Đã hoàn thành",
                        728,
                        "2218/PTC2 - P8"));
    }

    private void addVanBanDenChuaXuLy() {
    /*
        * @param1: Tiêu đề
        * @param2: thông báo
        * @param3: số hiệu
        * @param4: ký hiệu
        * @param5: ngày bắt đầu
        * param6: ngày kết thúc*/
        listVanBanDenChoXuLy
                .add(new VanBanDenChoXuLy("1.Xử lý tồn tại phần thứ nhất TBA 220KV Kontum và đầu nối",
                        "01/09/2015",
                        578,
                        "2218/PCT2-P8",
                        "26/05/2017",
                        "26/06/2017"));
        listVanBanDenChoXuLy
                .add(new VanBanDenChoXuLy("2.Xử lý tồn tại phần thứ nhất TBA 220KV Kontum và đầu nối",
                        "01/09/2015",
                        578,
                        "2218/PCT2-P8",
                        "26/05/2017",
                        "26/06/2017"));
        listVanBanDenChoXuLy
                .add(new VanBanDenChoXuLy("3.Xử lý tồn tại phần thứ nhất TBA 220KV Kontum và đầu nối",
                        "01/09/2015",
                        578,
                        "2218/PCT2-P8",
                        "26/05/2017",
                        "26/06/2017"));
        listVanBanDenChoXuLy
                .add(new VanBanDenChoXuLy("4.Xử lý tồn tại phần thứ nhất TBA 220KV Kontum và đầu nối",
                        "01/09/2015",
                        578,
                        "2218/PCT2-P8",
                        "26/05/2017",
                        "26/06/2017"));
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
        spec1 = tabHost.newTabSpec("t1");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator(getResources().getString(R.string.cho_xu_ly));
        tabHost.addTab(spec1);

        //tab2
        TabHost.TabSpec spec2;
        spec2 = tabHost.newTabSpec("t2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator(getResources().getString(R.string.da_xu_ly));
        tabHost.addTab(spec2);

        //tab3
        TabHost.TabSpec spec3;
        spec3 = tabHost.newTabSpec("t3");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator(getResources().getString(R.string.tim_kiem));
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
