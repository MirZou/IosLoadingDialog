package com.example.iosloadingdialog;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_loading = findViewById(R.id.btn_loading);
        btn_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LoadingDialog loadingDialog = new LoadingDialog(MainActivity.this,"加载中...");
                loadingDialog.show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismiss();
                    }
                },1500);
            }
        });
    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    });
}
