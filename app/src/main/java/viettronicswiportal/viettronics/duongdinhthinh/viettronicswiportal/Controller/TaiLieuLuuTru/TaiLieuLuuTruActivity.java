package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.TaiLieuLuuTru;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.TaiLieuLuuTru.AdapterTaiLieu;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.TaiLieuLuuTru.TaiLieuLuuTru;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class TaiLieuLuuTruActivity extends AppCompatActivity {

    private Spinner spinner_LuaChon;
    private String[] listLuaChon;
    private ArrayAdapter<String> adapter;

    private ListView listView_TaiLieu;
    private TaiLieuLuuTru taiLieuLuuTru;
    private ArrayList<TaiLieuLuuTru> listTaiLieu;
    private AdapterTaiLieu adapterTaiLieu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_lieu_luu_tru);

        customBar();
        addControls();
        addEvents();
    }

    private void addEvents() {
        addTaiLieu();
    }

    private void addTaiLieu() {
        listTaiLieu.add(new TaiLieuLuuTru("Giáo trình kế toán trong đơn vị Hành chính sự nghiệp",
                "Ban Tài Chính - Kế toán",
                "Văn bản pháp luật",
                "02/08/2017",
                "03/08/2017"));
        listTaiLieu.add(new TaiLieuLuuTru("Giáo trình kế toán trong đơn vị Hành chính sự nghiệp",
                "Ban Tài Chính - Kế toán",
                "Văn bản pháp luật",
                "02/08/2017",
                "03/08/2017"));
        listTaiLieu.add(new TaiLieuLuuTru("Giáo trình kế toán trong đơn vị Hành chính sự nghiệp",
                "Ban Tài Chính - Kế toán",
                "Văn bản pháp luật",
                "02/08/2017",
                "03/08/2017"));
        listTaiLieu.add(new TaiLieuLuuTru("Giáo trình kế toán trong đơn vị Hành chính sự nghiệp",
                "Ban Tài Chính - Kế toán",
                "Văn bản pháp luật",
                "02/08/2017",
                "03/08/2017"));
        listTaiLieu.add(new TaiLieuLuuTru("Giáo trình kế toán trong đơn vị Hành chính sự nghiệp",
                "Ban Tài Chính - Kế toán",
                "Văn bản pháp luật",
                "02/08/2017",
                "03/08/2017"));
        listTaiLieu.add(new TaiLieuLuuTru("Giáo trình kế toán trong đơn vị Hành chính sự nghiệp",
                "Ban Tài Chính - Kế toán",
                "Văn bản pháp luật",
                "02/08/2017",
                "03/08/2017"));
    }

    private void addControls() {
        listLuaChon = getResources().getStringArray(R.array.spinner_luachon);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listLuaChon);
        spinner_LuaChon = (Spinner) findViewById(R.id.tailieu_spinner_luachon);
        spinner_LuaChon.setAdapter(adapter);

        listView_TaiLieu = (ListView) findViewById(R.id.listview_TaiLieu);
        listTaiLieu = new ArrayList<>();
        adapterTaiLieu = new AdapterTaiLieu(this, R.layout.custom_listview_tailieuluutru, listTaiLieu);
        listView_TaiLieu.setAdapter(adapterTaiLieu);

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
