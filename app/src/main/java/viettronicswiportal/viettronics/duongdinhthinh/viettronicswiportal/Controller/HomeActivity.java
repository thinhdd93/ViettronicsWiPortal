package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.Calendar.LichCaNhanActivity;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.Calendar.LichCoQuanActivity;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.CongViec.CongViecActivity;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.Settings.ThietLapActivity;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.SinhNhat.ThongBaoSinhNhatActivity;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.TaiLieuLuuTru.TaiLieuLuuTruActivity;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.ThongBao.ThemThongBaoActivity;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.ThongBao.ThongBaoActivity;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.VanBanDen.VanBanDenActivity;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.VanBanDi.VanBanDiActivity;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private ImageView img_VanBanDen, img_VanBanDi, img_CongViec,
            img_TaiLieuLuuTru, img_ThongBaoNoiBo, img_LichCaNhan,
            img_LichCoQuan, img_SinhNhat, img_ThietLap;

    private TextView text_VanBanDen, text_VanBanDi, text_CongViec,
            text_TaiLieuLuuTru, text_ThongBaoNoiBo, text_LichCoQuan,
            text_LichCaNhan, text_SinhNhat, text_ThietLap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customBar();
        addControls();
        addEvents();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void addEvents() {
        img_VanBanDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyVanBanDen();
            }
        });
        text_VanBanDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyVanBanDen();
            }
        });

        img_VanBanDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyVanBanDi();
            }
        });
        text_VanBanDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyVanBanDi();
            }
        });

        img_CongViec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyManHinhCongViec();
            }
        });
        text_CongViec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyManHinhCongViec();
            }
        });

        img_TaiLieuLuuTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTaiLieuLuuTru();
            }
        });
        text_TaiLieuLuuTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTaiLieuLuuTru();
            }
        });

        img_ThongBaoNoiBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThongBao();
            }
        });
        text_ThongBaoNoiBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThongBao();
            }
        });

        img_LichCoQuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLichCoQuan();
            }
        });
        text_LichCoQuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLichCoQuan();
            }
        });

        img_LichCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLichCaNhan();
            }
        });
        text_LichCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLichCaNhan();
            }
        });

        img_SinhNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thongBaoSinhNhat();
            }
        });
        text_SinhNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thongBaoSinhNhat();
            }
        });

        img_ThietLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThietLap();
            }
        });
        text_ThietLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThietLap();
            }
        });
    }

    private void xuLyThietLap() {
        Intent intent = new Intent(HomeActivity.this, ThietLapActivity.class);
        startActivity(intent);
    }

    private void thongBaoSinhNhat() {
        Intent intent = new Intent(HomeActivity.this, ThongBaoSinhNhatActivity.class);
        startActivity(intent);
    }

    private void xuLyLichCaNhan() {
        Intent intent = new Intent(HomeActivity.this, LichCaNhanActivity.class);
        startActivity(intent);
    }

    private void xuLyLichCoQuan() {
        Intent intent = new Intent(HomeActivity.this, LichCoQuanActivity.class);
        startActivity(intent);
    }

    private void xuLyThongBao() {
        Intent intent = new Intent(HomeActivity.this, ThongBaoActivity.class);
        startActivity(intent);
    }

    private void xuLyTaiLieuLuuTru() {
        Intent intent = new Intent(HomeActivity.this, TaiLieuLuuTruActivity.class);
        startActivity(intent);
    }

    private void xuLyManHinhCongViec() {
        Intent intent = new Intent(HomeActivity.this, CongViecActivity.class);
        startActivity(intent);
    }

    private void xuLyVanBanDen() {
        Intent intent = new Intent(HomeActivity.this, VanBanDenActivity.class);
        startActivity(intent);
    }

    private void xuLyVanBanDi() {
        Intent intent = new Intent(HomeActivity.this, VanBanDiActivity.class);
        startActivity(intent);
    }

    private void addControls() {
        img_VanBanDen = (ImageView) findViewById(R.id.img_VanBanDen);
        img_VanBanDi = (ImageView) findViewById(R.id.img_VanBanDi);
        img_CongViec = (ImageView) findViewById(R.id.img_CongViec);
        img_TaiLieuLuuTru = (ImageView) findViewById(R.id.img_TaiLieuLuuTru);
        img_ThongBaoNoiBo = (ImageView) findViewById(R.id.img_ThongBaoNoiBo);
        img_LichCaNhan = (ImageView) findViewById(R.id.img_LichCaNhan);
        img_LichCoQuan = (ImageView) findViewById(R.id.img_LichCoQuan);
        img_SinhNhat = (ImageView) findViewById(R.id.img_SinhNhat);
        img_ThietLap = (ImageView) findViewById(R.id.img_ThietLap);

        text_VanBanDen = (TextView) findViewById(R.id.text_VanBanDen);
        text_VanBanDi = (TextView) findViewById(R.id.text_VanBanDi);
        text_CongViec = (TextView) findViewById(R.id.text_CongViec);
        text_TaiLieuLuuTru = (TextView) findViewById(R.id.text_TaiLieuLuuTru);
        text_ThongBaoNoiBo = (TextView) findViewById(R.id.text_ThongBaoNoiBo);
        text_LichCoQuan = (TextView) findViewById(R.id.text_LichCoQuan);
        text_LichCaNhan = (TextView) findViewById(R.id.text_LichCaNhan);
        text_SinhNhat = (TextView) findViewById(R.id.text_SinhNhat);
        text_ThietLap = (TextView) findViewById(R.id.text_ThietLap);
    }

    private void customBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(R.color.yellow_veic)));
        }
        actionBar.setCustomView(R.layout.navigation_bar_veic);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_dang_xuat:
                HomeActivity.this.finish();
                break;
            case R.id.menu_trang_chu:
                break;
            case R.id.menu_van_ban_den_cho_xu_ly:
                xuLyVanBanDen();
                break;
            case R.id.menu_van_ban_den_da_xu_ly:
                xuLyVanBanDen();
                break;
            case R.id.menu_tim_kiem_van_ban_den:
                xuLyVanBanDen();
                break;
            case R.id.menu_van_ban_di_cho_xu_ly:
                xuLyVanBanDi();
                break;
            case R.id.menu_van_ban_di_da_xu_ly:
                xuLyVanBanDi();
                break;
            case R.id.menu_tim_kiem_van_ban_di:
                xuLyVanBanDi();
                break;
            case R.id.menu_danh_sach_cong_viec:
                xuLyManHinhCongViec();
                break;
            case R.id.menu_giao_viec:
                xuLyManHinhCongViec();
                break;
            case R.id.menu_tim_kiem_cong_viec:
                xuLyManHinhCongViec();
                break;
            case R.id.menu_tim_kiem_tra_cuu:
                xuLyTaiLieuLuuTru();
                break;
            case R.id.menu_them_tai_lieu:
                break;
            case R.id.menu_thong_bao_chua_doc:
                xuLyThongBao();
                break;
            case R.id.menu_soan_thong_bao:
                Intent intentThemThongBao = new Intent(HomeActivity.this, ThemThongBaoActivity.class);
                startActivity(intentThemThongBao);
                break;
            case R.id.menu_lich_co_quan:
                xuLyLichCoQuan();
                break;
            case R.id.menu_lich_ca_nhan:
                xuLyLichCaNhan();
                break;
            case R.id.menu_vi_tri:
                break;

            default:
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
