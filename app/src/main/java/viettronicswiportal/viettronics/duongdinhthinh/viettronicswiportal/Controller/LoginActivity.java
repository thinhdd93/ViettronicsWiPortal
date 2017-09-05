package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class LoginActivity extends AppCompatActivity {

    private Button button_DangNhap;
    private TextInputEditText edit_TenDangNhap, edit_MatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        customBar();
        addControls();
        addEvents();
    }

    private void addEvents() {
        button_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_TenDangNhap.getText().toString().equals("admin")
                        && edit_MatKhau.getText().toString().equals("admin")) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else if (!edit_MatKhau.getText().toString().equals("admin")
                        || !edit_TenDangNhap.getText().toString().equals("admin")) {
                    Toast.makeText(LoginActivity.this, "Sai thông tin đăng nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void addControls() {
        button_DangNhap = (Button) findViewById(R.id.bDangNhap);
        edit_MatKhau = (TextInputEditText) findViewById(R.id.edit_matkhau);
        edit_TenDangNhap = (TextInputEditText) findViewById(R.id.edit_username);
    }

    private void customBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

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
