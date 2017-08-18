package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.CongViec;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.AdapterAddUser;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.CommentUser;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class ChiTietCongViecActivity extends AppCompatActivity {
    private ImageView imgDinhKemFile, imgBinhLuan, imgXoa;
    private TextView txtTieuDe, txtDiaChi, txtNoiDung, txtNgayGiaoViec, txtNgayHoanThanh;
    private TextView txtNguoiXyLyChinh, txtNguoiPhoiHop, txtNguoiGiamSat;

    /*View in Dialog*/
    private EditText edit_TenCanBo, edit_BinhLuan;
    private Spinner dialog_spinner_ChucVu;
    private ArrayAdapter<String> adapterSpinner;
    private String[] listChucVu;
    private Button dialog_button_BinhLuan, dialog_button_HuyBo;

    /*List Người Bình luận*/
    private ListView listview_BinhLuan;
    private AdapterAddUser adapterAddUser;
    private ArrayList<CommentUser> listUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_cong_viec);
        customBar();
        addControls();
        addEvents();
    }

    private void addEvents() {
        imgBinhLuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialogComment();
            }
        });
    }

    private void addControls() {
        imgBinhLuan = (ImageView) findViewById(R.id.chitiet_congviec_BinhLuan);

        listChucVu = getResources().getStringArray(R.array.spinner_chuc_vu);
    /*Listview và adapter người Bình luận*/
        listview_BinhLuan = (ListView) findViewById(R.id.chitiet_listview_BinhLuan);
        listUsers = new ArrayList<>();
        adapterAddUser = new AdapterAddUser(ChiTietCongViecActivity.this, R.layout.custom_listview_user, listUsers);
        listview_BinhLuan.setAdapter(adapterAddUser);
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

    private void createDialogComment() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_comment);
        dialog.setTitle("Bình luận");
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(params);

        edit_TenCanBo = (EditText) dialog.findViewById(R.id.edit_TenCanBo);
        dialog_spinner_ChucVu = (Spinner) dialog.findViewById(R.id.dialog_spinner_ChucVu);
        edit_BinhLuan = (EditText) dialog.findViewById(R.id.edit_BinhLuan);

        dialog_spinner_ChucVu = (Spinner) dialog.findViewById(R.id.dialog_spinner_ChucVu);
        adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                listChucVu);
        dialog_spinner_ChucVu.setAdapter(adapterSpinner);
        dialog_spinner_ChucVu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ChiTietCongViecActivity.this,
                        "Chức vụ: " + dialog_spinner_ChucVu.getSelectedItem().toString(), Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dialog_button_BinhLuan = (Button) dialog.findViewById(R.id.bBinhLuan);
        dialog_button_HuyBo = (Button) dialog.findViewById(R.id.bCancel);

        dialog_button_HuyBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog_button_BinhLuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edit_TenCanBo.getText().toString();
                String chucVu = dialog_spinner_ChucVu.getSelectedItem().toString();
                String binhLuan = edit_BinhLuan.getText().toString();
                String thoiGian = DateFormat.getDateInstance().format(new Date());
                if (hoTen.equals("") || chucVu.equals("")) {
                    Toast.makeText(ChiTietCongViecActivity.this, "Hãy nhập đủ thông tin", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    listUsers.add(new CommentUser(hoTen, chucVu, binhLuan, thoiGian));
                    adapterAddUser.notifyDataSetChanged();
                    Toast.makeText(ChiTietCongViecActivity.this, "Gửi thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }

}
