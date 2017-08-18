package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.Settings;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.DanhSachNguoiDung.AdapterUsers;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.DanhSachNguoiDung.Users;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class DanhSachNguoiDungActivity extends AppCompatActivity {
    private ListView lvDanhSachNguoiDung;
    private ArrayList<Users> listUsers;
    private AdapterUsers adapterUsers;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_nguoi_dung);
        customBar();
        loadTabHost();
        addControls();
        addEvents();
    }

    private void addEvents() {
        themNguoiDung();
    }

    private void themNguoiDung() {
        listUsers.add(new Users("Lưu Hoàng Long",
                "Tổng Giám Đốc",
                "Ban Tổng giám đốc",
                "luuhoangloang@viettronics.vn"));
        listUsers.add(new Users("Vũ Hải Vĩnh",
                "Phó Tổng Giám Đốc",
                "Ban Tổng giám đốc",
                "vuhaivinh@viettronics.vn"));
        listUsers.add(new Users("Bùi Mạnh Hùng",
                "Phó Tổng Giám Đốc",
                "Ban Tổng giám đốc",
                "buimanhhung@viettronics.vn"));
        listUsers.add(new Users("Nguyễn Văn Đông",
                "Phó Tổng Giám Đốc",
                "Ban Tổng giám đốc",
                "nguyenvandong@viettronics.vn"));
        listUsers.add(new Users("Nguyễn Trung Dũng",
                "Kế toán trưởng",
                "Ban Tài chính - Kế toán",
                "nguyentrungdung@viettronics.vn"));
        listUsers.add(new Users("Lê Đức Minh",
                "Trưởng Ban",
                "Ban Kế hoạch đầu tư",
                "leducminh@viettronics.vn"));
        listUsers.add(new Users("Nguyễn Bích Thủy",
                "Chánh văn phòng",
                "Văn phòng",
                "nguyenbichthuy@viettronics.vn"));
        listUsers.add(new Users("Lê Anh Tuấn",
                "Trưởng ban",
                "Ban Công nghệ",
                "leanhtuan@viettronics.vn"));
        listUsers.add(new Users("Phạm Nguyên Anh",
                "Trưởng ban",
                "Ban Kinh doanh",
                "phamnguyenanh@viettronics.vn"));
        listUsers.add(new Users("Nguyễn Mạnh Hà",
                "Chuyên vien",
                "Ban Công nghệ",
                "nguyenmanhha@viettronics.vn"));
        adapterUsers.notifyDataSetChanged();
    }

    private void addControls() {
        lvDanhSachNguoiDung = (ListView) findViewById(R.id.lvDanhSachNguoiDung);
        listUsers = new ArrayList<>();
        adapterUsers = new AdapterUsers(DanhSachNguoiDungActivity.this, R.layout.custom_listview_danhsachnguoidung, listUsers);
        lvDanhSachNguoiDung.setAdapter(adapterUsers);
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
        Drawable icon1 = ContextCompat.getDrawable(DanhSachNguoiDungActivity.this, R.mipmap.ic_checked_256);
        spec1.setIndicator(getResources().getString(R.string.da_chon), icon1);
        tabHost.addTab(spec1);

        //tab2
        TabHost.TabSpec spec2;
        spec2 = tabHost.newTabSpec("t2");
        spec2.setContent(R.id.tab2);
        Drawable icon2 = ContextCompat.getDrawable(DanhSachNguoiDungActivity.this, R.mipmap.ic_user_256);
        spec2.setIndicator(getResources().getString(R.string.danh_sach), icon2);
        tabHost.addTab(spec2);

        //tab3
        TabHost.TabSpec spec3;
        spec3 = tabHost.newTabSpec("t3");
        spec3.setContent(R.id.tab3);
        Drawable icon3 = ContextCompat.getDrawable(DanhSachNguoiDungActivity.this, R.mipmap.ic_sync_256);
        spec3.setIndicator(getResources().getString(R.string.dong_bo), icon3);
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
