package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.ThongBao;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class ThemThongBaoActivity extends AppCompatActivity {
    private Spinner spinnerChucVu;
    private ArrayAdapter<String> adapterChucVu;
    private String[] listChucVu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_thong_bao);
        customBar();
        addControls();
        addEvents();
    }
    private void addEvents() {
    }

    private void addControls() {
        spinnerChucVu = (Spinner) findViewById(R.id.themthongbao_spinner_ChucVu);
        listChucVu = getResources().getStringArray(R.array.spinner_chuc_vu);
        adapterChucVu = new ArrayAdapter<String>(ThemThongBaoActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                listChucVu);
        spinnerChucVu.setAdapter(adapterChucVu);

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
