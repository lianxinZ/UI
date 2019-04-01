package com.example.project3;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    private Button b1;
    Context context;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b1=findViewById(R.id.d_button);
        context=Main3Activity.this;



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//创建一个自定义View
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.view_dialog, null);
                builder.setView(view);
//创建一个AlertDialog对象
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
}
