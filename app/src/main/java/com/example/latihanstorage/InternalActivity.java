package com.example.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;

public class InternalActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String FILENAME = "namafile.txt";
    private Button createFile, changeFile, readFile, deleteFile;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createFile = findViewById(R.id.btn_buat_file);
        changeFile = findViewById(R.id.btn_ubah_file);
        readFile = findViewById(R.id.btn_baca_file);
        deleteFile = findViewById(R.id.btn_hapus_file);
        result = findViewById(R.id.tv_result);

        createFile.setOnClickListener(this);
        changeFile.setOnClickListener(this);
        readFile.setOnClickListener(this);
        deleteFile.setOnClickListener(this);
    }

    void createFile() {
        String contentFile = "Coba isi Data File Text";
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(contentFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void changeFile() {
        String contentFile = "Penambahan konten dari Ubah File";
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(contentFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void deleteFile() {
        File file = new File(getFilesDir(), FILENAME);
        if (file.exists()) {
            file.delete();
        }
    }

    void readFile() {
        File file = new File(getFilesDir(), FILENAME);
        if (file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();

                while (line!=null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Error" + e.getMessage());
            }
            result.setText(text.toString());
        }
    }

    @Override
    public void onClick(View view) {
        runAction(view.getId());
    }

    public void runAction(int id) {
        switch (id) {
            case R.id.btn_buat_file:
                createFile();
                break;

            case R.id.btn_ubah_file:
                changeFile();
                break;

            case R.id.btn_baca_file:
                readFile();
                break;

            case R.id.btn_hapus_file:
                deleteFile();
                break;
        }
    }
}