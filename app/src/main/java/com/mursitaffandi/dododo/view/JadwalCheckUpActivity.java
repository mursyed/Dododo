package com.mursitaffandi.dododo.view;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.mursitaffandi.dododo.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class JadwalCheckUpActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener,View.OnClickListener{

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private ArrayList<String> dokter,poli,jam_praktek;
    EditText edt_tgl_checkup;
    Button btn_daftar, btn_batal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_check_up);

        dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dokter = new ArrayList<String>();
        poli = new ArrayList<String>();
        jam_praktek = new ArrayList<String>();

        initView();
    }

    private void initView() {
        edt_tgl_checkup = (EditText) findViewById(R.id.edt_tgl_checkup);
        btn_batal = (Button) findViewById(R.id.btn_batal);
        btn_daftar = (Button) findViewById(R.id.btn_daftar);

        edt_tgl_checkup.setOnClickListener(this);
        btn_daftar.setOnClickListener(this);
        btn_batal.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_batal:
                break;
            case R.id.btn_daftar:
                break;
            case R.id.edt_tgl_checkup:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    // TODO showDatePicker
    private void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                edt_tgl_checkup.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
}