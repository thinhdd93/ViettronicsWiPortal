package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.VanBanDi;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;
import android.widget.TextView;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class VanBanDiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_ban_di);

        customBar();
        loadTabHost();
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
        final TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
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
