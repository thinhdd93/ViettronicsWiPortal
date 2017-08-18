package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.VanBanDen;

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
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.AdapterAddUser;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.CommentUser;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class ChiTietVanBanActivity extends AppCompatActivity {

    private ImageView imgComment, imgAddUser, imgAttach;
    private Spinner dialog_spinner_ChucVu;
    private EditText edit_TenCanBo, edit_BinhLuan;
    private Button button_BinhLuan, button_Cancel;
    private CommentUser commentUser;
    private ArrayList<CommentUser> listUser;
    private ListView lvUser;
    private AdapterAddUser adapterAddUser;
    private ArrayAdapter<String> adapter_spinner_ChucVu;
    private String[] listChucVu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_van_ban);

        customBar();
        addControls();
        addEvents();
    }

    private void addEvents() {
        imgComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialogComment();
            }
        });
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
        adapter_spinner_ChucVu = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                listChucVu);
        dialog_spinner_ChucVu.setAdapter(adapter_spinner_ChucVu);
        dialog_spinner_ChucVu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ChiTietVanBanActivity.this,
                        "Chức vụ: " + dialog_spinner_ChucVu.getSelectedItem().toString(), Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button_BinhLuan = (Button) dialog.findViewById(R.id.bBinhLuan);
        button_Cancel = (Button) dialog.findViewById(R.id.bCancel);

        button_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        button_BinhLuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edit_TenCanBo.getText().toString();
                String chucVu = dialog_spinner_ChucVu.getSelectedItem().toString();
                String binhLuan = edit_BinhLuan.getText().toString();
                String thoiGian = DateFormat.getDateInstance().format(new Date());
                if (hoTen.equals("") || chucVu.equals("")) {
                    Toast.makeText(ChiTietVanBanActivity.this, "Hãy nhập đủ thông tin", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    listUser.add(new CommentUser(hoTen, chucVu, binhLuan, thoiGian));
                    adapterAddUser.notifyDataSetChanged();
                    Toast.makeText(ChiTietVanBanActivity.this, "Gửi thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }


    private void addControls() {
        listChucVu = getResources().getStringArray(R.array.spinner_chuc_vu);

        imgAddUser = (ImageView) findViewById(R.id.img_adduser);
        imgAttach = (ImageView) findViewById(R.id.img_attach);
        imgComment = (ImageView) findViewById(R.id.img_comment);

        lvUser = (ListView) findViewById(R.id.detail_YKienChiDao);
        listUser = new ArrayList<CommentUser>();
        adapterAddUser = new AdapterAddUser(ChiTietVanBanActivity.this, R.layout.custom_listview_user,
                listUser);
        lvUser.setAdapter(adapterAddUser);
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
