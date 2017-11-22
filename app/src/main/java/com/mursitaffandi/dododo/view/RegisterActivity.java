package com.mursitaffandi.dododo.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.mursitaffandi.dododo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;

    private EditText edt_tanggal, edt_no_hp, edt_nama, edt_email;
    private Button btn_daftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        initViewOnClick();
    }

    private void initViewOnClick() {
        edt_no_hp = (EditText) findViewById(R.id.edt_no_hp);
        edt_tanggal = (EditText) findViewById(R.id.edt_tanggal);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_nama = (EditText) findViewById(R.id.edt_nama);
        btn_daftar = (Button) findViewById(R.id.btn_daftar);

        edt_tanggal.setOnClickListener(this);
        btn_daftar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_daftar:
                String nama = edt_nama.getText().toString();
                String email = edt_email.getText().toString();
                String tanggal = edt_tanggal.getText().toString();
                String no_hp = edt_no_hp.getText().toString();

                boolean isEmptyFields= false;
                if (TextUtils.isEmpty(nama)){
                    isEmptyFields = true;
                    edt_nama.setError("Wajib diisi");
                }

                if (TextUtils.isEmpty(email)){
                    isEmptyFields = true;
                    edt_email.setError("Wajib diisi");
                }
                if (TextUtils.isEmpty(tanggal)){
                    isEmptyFields = true;
                    edt_tanggal.setError("Wajib diisi");
                }
                if (TextUtils.isEmpty(no_hp)){
                    isEmptyFields = true;
                    edt_no_hp.setError("Wajib diisi");
                }

                if (!isEmptyFields){
                    // TODO send to DB

                    // jika berhasil, konfirmasi OTP sms
                    startActivity(new Intent(RegisterActivity.this, OTPActivity.class));
                }
                break;
            case R.id.edt_tanggal:
                showDateDialog();
                break;
        }
    }

    // TODO showDatePicker
    private void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                edt_tanggal.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
}