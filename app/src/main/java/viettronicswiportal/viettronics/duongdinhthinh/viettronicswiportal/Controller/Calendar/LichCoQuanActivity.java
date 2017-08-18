package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.Calendar;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.Calendar.LichCoQuan;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.Calendar.LichCoQuanAdapter;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class LichCoQuanActivity extends AppCompatActivity {

    private ListView lvLichCoQuan;
    private LichCoQuanAdapter adapter_lichcoquan;
    private ArrayList<LichCoQuan> listCongViec;
    private FloatingActionButton fab_ThemLich;
    private int LICH_CO_QUAN_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_co_quan);
        customBar();
        addControls();
        addEvents();
    }

    private void addEvents() {
        fab_ThemLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichCoQuanActivity.this, ThemLichCoQuanActivity.class);
                startActivityForResult(intent, LICH_CO_QUAN_REQUEST_CODE);
            }
        });
        themLich();
    }

    private void themLich() {
        listCongViec.add(new LichCoQuan("Ban Lãnh Đạo làm việc tại trụ sở",
                "08:00",
                "06/08/2017",
                "16:00",
                "06/08/2017",
                "Lưu Hoàng Long",
                "Tầng 11, Mipec Tower, 229 Tây Sơn, Đống Đa, Hà Nội"));
        listCongViec.add(new LichCoQuan("Ban Lãnh Đạo làm việc tại trụ sở",
                "08:00",
                "06/08/2017",
                "16:00",
                "06/08/2017",
                "Lưu Hoàng Long",
                "Tầng 11, Mipec Tower, 229 Tây Sơn, Đống Đa, Hà Nội"));
        listCongViec.add(new LichCoQuan("Ban Lãnh Đạo làm việc tại trụ sở",
                "08:00",
                "06/08/2017",
                "16:00",
                "06/08/2017",
                "Lưu Hoàng Long",
                "Tầng 11, Mipec Tower, 229 Tây Sơn, Đống Đa, Hà Nội"));
        listCongViec.add(new LichCoQuan("Ban Lãnh Đạo làm việc tại trụ sở",
                "08:00",
                "06/08/2017",
                "16:00",
                "06/08/2017",
                "Lưu Hoàng Long",
                "Tầng 11, Mipec Tower, 229 Tây Sơn, Đống Đa, Hà Nội"));
        listCongViec.add(new LichCoQuan("Ban Lãnh Đạo làm việc tại trụ sở",
                "08:00",
                "06/08/2017",
                "16:00",
                "06/08/2017",
                "Lưu Hoàng Long",
                "Tầng 11, Mipec Tower, 229 Tây Sơn, Đống Đa, Hà Nội"));
        listCongViec.add(new LichCoQuan("Ban Lãnh Đạo làm việc tại trụ sở",
                "08:00",
                "06/08/2017",
                "16:00",
                "06/08/2017",
                "Lưu Hoàng Long",
                "Tầng 11, Mipec Tower, 229 Tây Sơn, Đống Đa, Hà Nội"));
        listCongViec.add(new LichCoQuan("Ban Lãnh Đạo làm việc tại trụ sở",
                "08:00",
                "06/08/2017",
                "16:00",
                "06/08/2017",
                "Lưu Hoàng Long",
                "Tầng 11, Mipec Tower, 229 Tây Sơn, Đống Đa, Hà Nội"));
        listCongViec.add(new LichCoQuan("Ban Lãnh Đạo làm việc tại trụ sở",
                "08:00",
                "06/08/2017",
                "16:00",
                "06/08/2017",
                "Lưu Hoàng Long",
                "Tầng 11, Mipec Tower, 229 Tây Sơn, Đống Đa, Hà Nội"));
    }

    private void addControls() {
        lvLichCoQuan = (ListView) findViewById(R.id.lvLichCoQuan);
        listCongViec = new ArrayList<>();
        adapter_lichcoquan = new LichCoQuanAdapter(LichCoQuanActivity.this, R.layout.custom_listview_lich_co_quan, listCongViec);
        lvLichCoQuan.setAdapter(adapter_lichcoquan);

        fab_ThemLich = (FloatingActionButton) findViewById(R.id.fab_ThemLichCoQuan);
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

}
