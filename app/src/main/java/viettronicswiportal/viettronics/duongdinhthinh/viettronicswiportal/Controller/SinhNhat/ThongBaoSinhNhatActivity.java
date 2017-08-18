package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.SinhNhat;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.SinhNhat.SinhNhat;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.SinhNhat.SinhNhatAdapter;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class ThongBaoSinhNhatActivity extends AppCompatActivity {

    private ListView lvSinhNhat;
    private ArrayList<SinhNhat> listSinhNhat;
    private SinhNhatAdapter sinhNhatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao_sinh_nhat);

        customBar();
        addControls();
        addEvents();
    }

    private void addEvents() {
        addSinhNhat();
    }

    private void addSinhNhat() {
        listSinhNhat.add(new SinhNhat("Lưu Hoàng Long",
                "Tổng Giám Đốc",
                "Ban Tổng Giám Đốc",
                "13/12/1973",
                "luuhoanglong@viettronics.vn"));
        listSinhNhat.add(new SinhNhat("Hồ Thanh Nam",
                "Chuyên viên",
                "Phòng Năng lượng - Công nghiệp",
                "14/10/1984",
                "hothanhnam@viettronics.vn"));
        listSinhNhat.add(new SinhNhat("Lê Thị Thu Hương",
                "Chuyên viên",
                "Ban Tài chính - Kế toán",
                "18/10/1982",
                "lethuhuong@viettronics.vn"));
        listSinhNhat.add(new SinhNhat("Nguyễn Hữu Dũng",
                "Lái xe",
                "Phòng Hành chính - Quản trị",
                "19/10/1955",
                "---"));
        listSinhNhat.add(new SinhNhat("Bùi Tiến Đào",
                "Phó Phòng",
                "Phòng Hành chính - Quản trị",
                "20/10/1955",
                "buitiendao@viettronics.vn"));
        listSinhNhat.add(new SinhNhat("Nguyễn Đức Anh",
                "Chuyên viên",
                "Phòng Thanh tra, Pháp chế và Kiểm soát nội bộ",
                "26/10/1992",
                "nguyenducanh@viettronics.vn"));
    }

    private void addControls() {
        lvSinhNhat = (ListView) findViewById(R.id.lvSinhNhat);
        listSinhNhat = new ArrayList<>();
        sinhNhatAdapter = new SinhNhatAdapter(ThongBaoSinhNhatActivity.this,
                R.layout.custom_listview_thongbaosinhnhat
                , listSinhNhat);
        lvSinhNhat.setAdapter(sinhNhatAdapter);
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
