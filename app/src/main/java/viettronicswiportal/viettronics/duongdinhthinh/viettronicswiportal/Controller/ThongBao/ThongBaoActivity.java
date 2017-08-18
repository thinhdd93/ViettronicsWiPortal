package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.ThongBao;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.ThongBao.AdapterThongBao;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.ThongBao.ThongBao;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class ThongBaoActivity extends AppCompatActivity {

    private Spinner spinner_DonVi;
    private SearchView searchView;
    private ListView listview_thongBao;
    private ArrayList<ThongBao> listThongBao;
    private AdapterThongBao adapterThongBao;
    private String[] listDonVi;
    private ArrayAdapter<String> adapterSpinner;
    private FloatingActionButton fab_ThemThongBao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);

        customBar();
        addControls();
        addEvents();
    }

    private void addEvents() {
        addThongBao();
        listview_thongBao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ThongBaoActivity.this, NoiDungThongBaoActivity.class);
                startActivity(intent);
                Toast.makeText(ThongBaoActivity.this, "Đã chọn " + listThongBao.get(i).getTieuDe().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        /*THIẾT LẬP SỰ KIỆN BUTTON THÊM THÔNG BÁO*/
        fab_ThemThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThongBaoActivity.this, ThemThongBaoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addThongBao() {
        listThongBao.add(new ThongBao("Thông báo về phiếu đăng ký đi công tác",
                "Tô Điệu Hương",
                "04/08/2017"));
        listThongBao.add(new ThongBao("Bảo dưỡng điều hòa",
                "Tô Điệu Hương",
                "04/08/2017"));
        listThongBao.add(new ThongBao("Phân công lịch trực ban",
                "Tô Điệu Hương",
                "04/08/2017"));
        listThongBao.add(new ThongBao("Thông báo về phiếu đăng ký đi công tác",
                "Tô Điệu Hương",
                "04/08/2017"));
        listThongBao.add(new ThongBao("Thông báo về phiếu đăng ký đi công tác",
                "Tô Điệu Hương",
                "04/08/2017"));
        listThongBao.add(new ThongBao("Thông báo về phiếu đăng ký đi công tác",
                "Tô Điệu Hương",
                "04/08/2017"));
        listThongBao.add(new ThongBao("Thông báo về phiếu đăng ký đi công tác",
                "Tô Điệu Hương",
                "04/08/2017"));
        adapterThongBao.notifyDataSetChanged();
    }

    private void addControls() {
        /*THIẾT LẬP SPINNER*/
        listDonVi = getResources().getStringArray(R.array.spinner_luachon);
        spinner_DonVi = (Spinner) findViewById(R.id.thongbao_spinner_chucVu);
        adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listDonVi);
        spinner_DonVi.setAdapter(adapterSpinner);

        /*THIẾT LẬP HIỂN THỊ LISTVIEW*/
        listview_thongBao = (ListView) findViewById(R.id.listview_thongBao);
        listThongBao = new ArrayList<>();
        adapterThongBao = new AdapterThongBao(this, R.layout.custom_listview_thongbao, listThongBao);
        listview_thongBao.setAdapter(adapterThongBao);

        fab_ThemThongBao = (FloatingActionButton) findViewById(R.id.themthongbao_fab_ThemThongBao);
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
