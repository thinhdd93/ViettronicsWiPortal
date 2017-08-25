package viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Controller.VanBanDen;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.VanBanDen.AdapterUsersPhoiHopXuLyGiamSat;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.Model.VanBanDen.NguoiXuLyPhoiHopGiamSat;
import viettronicswiportal.viettronics.duongdinhthinh.viettronicswiportal.R;

public class ThemVanBanDenCanXuLyActivity extends AppCompatActivity {

    private Spinner sp_ChucVu;
    private TextView txtNgayGiaoViec, txtNgayHoanThanh;
    private ImageView img_Send, img_NgayGiaoViec,
            img_NgayHoanThanh, img_NguoiXuLyChinh, img_NguoiPhoiHop,
            img_NguoiGiamSat, img_DinhKemNoiDungChiDao;
    private ListView listview_NguoiXuLyChinh, listview_NguoiGiamSat, listview_NguoiPhoiHop;
    private EditText edit_NoiDungChiDao;
    private ArrayAdapter<String> adapterChucVu, adapter_spinner_ChucVuNguoiXuLy,
            adapter_spinner_chucVuNguoiPhoiHop,
            adapter_spinner_chucVuNguoiGiamSat;
    private String[] listChucVu;
    private Spinner dialog_spinner_ChucVuNguoiXuLyChinh,
            dialog_spinner_ChucVuNguoiPhoiHop,
            dialog_spinner_ChucVuNguoiGiamSat;
    private EditText dialog_name;
    private Button dialog_button_addUsers, dialog_button_HuyBo;
    private String name, chucVu;
    private AdapterUsersPhoiHopXuLyGiamSat adapterNguoiXuLy, adapterNguoiPhoiHop, adapterNguoiGiamSat;
    private ArrayList<NguoiXuLyPhoiHopGiamSat> listNguoiXuLy, listNguoiPhoiHop, listNguoiGiamSat;

    private Calendar calendar;
    private Date ngayGiaoViec, ngayHoanThanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_van_ban_den_can_xu_ly);
        customBar();
        addControls();
        addEvents();
    }

    private void addEvents() {
        getDateDefault();
        img_NguoiXuLyChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialogThemNguoiXyLy();
            }
        });

        img_NguoiPhoiHop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creatDialogThemNguoiPhoiHop();
            }
        });

        img_NguoiGiamSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creatDialogThemNguoiGiamSat();
            }
        });

        img_NgayGiaoViec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonNgayGiaoViec();
            }
        });
        img_NgayHoanThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonNgayHoanThanh();
            }
        });
    }

    private void addControls() {
        sp_ChucVu = (Spinner) findViewById(R.id.spinner_ChucVu);

    /*LẤY DANH SÁCH CHỨC VỤ TỪ FILE string.xml*/
        listChucVu = getResources().getStringArray(R.array.spinner_chuc_vu);
    /*TẠO ADAPTER CHO SPINNER HIỂN THỊ CHỨC VỤ NGƯỜI TẠO VĂN BẢN*/
        adapterChucVu = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                listChucVu);
        sp_ChucVu.setAdapter(adapterChucVu);

    /*TẠO LISTVIEW HIỂN THỊ DANH SÁCH NGƯỜI XỬ LÝ CHÍNH*/
        img_NguoiXuLyChinh = (ImageView) findViewById(R.id.themVanBan_img_xuLyChinh);
        listview_NguoiXuLyChinh = (ListView) findViewById(R.id.listview_nguoiXuLyChinh);
        listNguoiXuLy = new ArrayList<>();
        adapterNguoiXuLy = new AdapterUsersPhoiHopXuLyGiamSat(ThemVanBanDenCanXuLyActivity.this,
                R.layout.custom_listview_nguoi_xuly_phoihop_giamsat, listNguoiXuLy);
        listview_NguoiXuLyChinh.setAdapter(adapterNguoiXuLy);

    /*TẠO LISTVIEW HIỂN THỊ DANH SÁCH NGƯỜI PHỐI HỢP XỬ LÝ*/
        img_NguoiPhoiHop = (ImageView) findViewById(R.id.themVanBan_img_nguoiPhoiHop);
        listview_NguoiPhoiHop = (ListView) findViewById(R.id.listview_nguoiPhoiHop);
        listNguoiPhoiHop = new ArrayList<>();
        adapterNguoiPhoiHop = new AdapterUsersPhoiHopXuLyGiamSat(ThemVanBanDenCanXuLyActivity.this,
                R.layout.custom_listview_nguoi_xuly_phoihop_giamsat, listNguoiPhoiHop);
        listview_NguoiPhoiHop.setAdapter(adapterNguoiPhoiHop);

    /*TẠO LISTVIEW HIỂN THỊ DANH SÁCH NGƯỜI GIÁM SÁT*/
        img_NguoiGiamSat = (ImageView) findViewById(R.id.themVanBan_img_nguoiGiamSat);
        listview_NguoiGiamSat = (ListView) findViewById(R.id.listview_nguoiGiamSat);
        listNguoiGiamSat = new ArrayList<>();
        adapterNguoiGiamSat = new AdapterUsersPhoiHopXuLyGiamSat(ThemVanBanDenCanXuLyActivity.this,
                R.layout.custom_listview_nguoi_xuly_phoihop_giamsat, listNguoiGiamSat);
        listview_NguoiGiamSat.setAdapter(adapterNguoiGiamSat);


        /*Ngày giao việc và hoàn thành*/
        txtNgayGiaoViec = findViewById(R.id.themVanBan_NgayGiao);
        txtNgayHoanThanh = findViewById(R.id.themVanBan_NgayHoanThanh);
        img_NgayGiaoViec = findViewById(R.id.themVanBan_img_NgayGiao);
        img_NgayHoanThanh = findViewById(R.id.themVanBan_img_NgayHoanThanh);

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

    private void getDateDefault() {
        calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = null;
        /*Định dạng ngày tháng năm */
        dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String dateDefault = dateFormat.format(calendar.getTime());
        txtNgayHoanThanh.setText(dateDefault);
        txtNgayGiaoViec.setText(dateDefault);
        ngayHoanThanh = calendar.getTime();
        ngayGiaoViec = calendar.getTime();
    }


    private void chonNgayGiaoViec() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dateOfMonth) {
                txtNgayGiaoViec.setText(dateOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                calendar.set(year, monthOfYear, dateOfMonth);
                ngayGiaoViec = calendar.getTime();
            }
        };

        String s = txtNgayGiaoViec.getText() + "";
        String strArr[] = s.split("/");
        int ngay = Integer.parseInt(strArr[0]);
        int thang = Integer.parseInt(strArr[1]) - 1;
        int nam = Integer.parseInt(strArr[2]);
        DatePickerDialog dialog = new DatePickerDialog(ThemVanBanDenCanXuLyActivity.this,
                dateSetListener,
                nam,
                thang,
                ngay);
        dialog.setTitle("Ngày bắt đầu");
        dialog.show();
    }

    private void chonNgayHoanThanh() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dateOfMonth) {
                txtNgayHoanThanh.setText(dateOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                calendar.set(year, monthOfYear, dateOfMonth);
                ngayHoanThanh = calendar.getTime();
            }
        };
        String s = txtNgayGiaoViec.getText() + "";
        String strArr[] = s.split("/");
        int ngay = Integer.parseInt(strArr[0]);
        int thang = Integer.parseInt(strArr[1]) - 1;
        int nam = Integer.parseInt(strArr[2]);
        DatePickerDialog dialog = new DatePickerDialog(ThemVanBanDenCanXuLyActivity.this,
                dateSetListener,
                nam,
                thang,
                ngay);
        dialog.setTitle("Ngày hoàn thành");
        dialog.show();
    }

    /*Tạo Custom Dialog thêm người xử lý*/
    private void createDialogThemNguoiXyLy() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_nguoi_xuly_phoihop_giamsat);
        dialog.setTitle("Thêm người xử lý chính");
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(params);

    /*Khai báo View*/
        dialog_spinner_ChucVuNguoiXuLyChinh = (Spinner) dialog
                .findViewById(R.id.spinner_ChucVuXuLyGiamSatPhoiHop);
        dialog_name = (EditText) dialog.findViewById(R.id.dialog_hoTen_xuly_giamsat_phoihop);
        dialog_button_addUsers = (Button) dialog.findViewById(R.id.dialog_button_addUser);
        dialog_button_HuyBo = (Button) dialog.findViewById(R.id.dialog_button_HuyBo);

    /*Cài đặt Adapter cho Spinner*/
        adapter_spinner_ChucVuNguoiXuLy = new ArrayAdapter<String>(ThemVanBanDenCanXuLyActivity.this,
                android.R.layout.simple_spinner_dropdown_item, listChucVu);
        dialog_spinner_ChucVuNguoiXuLyChinh.setAdapter(adapter_spinner_ChucVuNguoiXuLy);

    /*XỬ LÝ SỰ KIỆN KHI CHỌN ITEM TRONG SPINNER*/
        dialog_spinner_ChucVuNguoiXuLyChinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dialog_button_HuyBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });



    /*Khi bấm Button "Thêm" thì thêm vào Listview*/
        dialog_button_addUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog_name.getText().toString().equals("")) {
                    Toast.makeText(ThemVanBanDenCanXuLyActivity.this, "Hãy nhập đủ thông tin",
                            Toast.LENGTH_SHORT).show();
                } else {
                    name = dialog_name.getText().toString();
                    chucVu = dialog_spinner_ChucVuNguoiXuLyChinh.getSelectedItem().toString();
                    listNguoiXuLy.add(new NguoiXuLyPhoiHopGiamSat(name, chucVu));
                    adapterNguoiXuLy.notifyDataSetChanged();
                    Toast.makeText(ThemVanBanDenCanXuLyActivity.this, "Thêm thành công", Toast.LENGTH_SHORT)
                            .show();
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }

    private void creatDialogThemNguoiPhoiHop() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_nguoi_xuly_phoihop_giamsat);
        dialog.setTitle("Thêm người phối hợp");
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(params);

    /*Khai báo View*/
        dialog_spinner_ChucVuNguoiPhoiHop = (Spinner) dialog
                .findViewById(R.id.spinner_ChucVuXuLyGiamSatPhoiHop);
        dialog_name = (EditText) dialog.findViewById(R.id.dialog_hoTen_xuly_giamsat_phoihop);
        dialog_button_addUsers = (Button) dialog.findViewById(R.id.dialog_button_addUser);
        dialog_button_HuyBo = (Button) dialog.findViewById(R.id.dialog_button_HuyBo);

 /*Cài đặt Adapter cho Spinner*/
        adapter_spinner_chucVuNguoiPhoiHop = new ArrayAdapter<String>(ThemVanBanDenCanXuLyActivity.this,
                android.R.layout.simple_spinner_dropdown_item, listChucVu);
        dialog_spinner_ChucVuNguoiPhoiHop.setAdapter(adapter_spinner_chucVuNguoiPhoiHop);
    /*Button Hủy bỏ*/
        dialog_button_HuyBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    /*Khi bấm Button "Thêm" thì thêm vào Listview*/
        dialog_button_addUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog_name.getText().toString().equals("")) {
                    Toast.makeText(ThemVanBanDenCanXuLyActivity.this, "Hãy nhập đủ thông tin",
                            Toast.LENGTH_SHORT).show();
                } else {
                    name = dialog_name.getText().toString();
                    chucVu = dialog_spinner_ChucVuNguoiPhoiHop.getSelectedItem().toString();
                    listNguoiPhoiHop.add(new NguoiXuLyPhoiHopGiamSat(name, chucVu));
                    adapterNguoiPhoiHop.notifyDataSetChanged();
                    Toast.makeText(ThemVanBanDenCanXuLyActivity.this, "Thêm thành công", Toast.LENGTH_SHORT)
                            .show();
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }

    private void creatDialogThemNguoiGiamSat() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_nguoi_xuly_phoihop_giamsat);
        dialog.setTitle("Thêm người giám sát");
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(params);

    /*Khai báo View*/
        dialog_spinner_ChucVuNguoiGiamSat = (Spinner) dialog
                .findViewById(R.id.spinner_ChucVuXuLyGiamSatPhoiHop);
        dialog_name = (EditText) dialog.findViewById(R.id.dialog_hoTen_xuly_giamsat_phoihop);
        dialog_button_addUsers = (Button) dialog.findViewById(R.id.dialog_button_addUser);
        dialog_button_HuyBo = (Button) dialog.findViewById(R.id.dialog_button_HuyBo);

 /*Cài đặt Adapter cho Spinner*/
        adapter_spinner_chucVuNguoiGiamSat = new ArrayAdapter<String>(ThemVanBanDenCanXuLyActivity.this,
                android.R.layout.simple_spinner_dropdown_item, listChucVu);
        dialog_spinner_ChucVuNguoiGiamSat.setAdapter(adapter_spinner_chucVuNguoiGiamSat);
    /*Button Hủy bỏ*/
        dialog_button_HuyBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    /*Khi bấm Button "Thêm" thì thêm vào Listview*/
        dialog_button_addUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog_name.getText().toString().equals("")) {
                    Toast.makeText(ThemVanBanDenCanXuLyActivity.this, "Hãy nhập đủ thông tin",
                            Toast.LENGTH_SHORT).show();
                } else {
                    name = dialog_name.getText().toString();
                    chucVu = dialog_spinner_ChucVuNguoiGiamSat.getSelectedItem().toString();
                    listNguoiGiamSat.add(new NguoiXuLyPhoiHopGiamSat(name, chucVu));
                    adapterNguoiGiamSat.notifyDataSetChanged();
                    Toast.makeText(ThemVanBanDenCanXuLyActivity.this, "Thêm thành công", Toast.LENGTH_SHORT)
                            .show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
}
