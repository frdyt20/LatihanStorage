package com.example.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_internal, btn_external;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_internal = findViewById(R.id.btn_internal);
        btn_external = findViewById(R.id.btn_external);

        btn_internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent internalStorage = new Intent(getApplicationContext(),InternalActivity.class);
                startActivity(internalStorage);
            }
        });

        btn_external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent externalStorage = new Intent(getApplicationContext(),ExternalActivity.class);
                startActivity(externalStorage);
            }
        });
    }
}