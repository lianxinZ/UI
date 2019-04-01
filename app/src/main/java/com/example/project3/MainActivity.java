package com.example.project3;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private Button b1,b2,b3,b4,b5;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.SAbtn);
        b2=findViewById(R.id.ADbtn);
        b3=findViewById(R.id.OMbtn);
        b4=findViewById(R.id.AMbtn);
        OnClick onClick=new OnClick();
        b1.setOnClickListener(onClick);
        b2.setOnClickListener(onClick);
        b3.setOnClickListener(onClick);
        b4.setOnClickListener(onClick);
    }
    class OnClick implements  View.OnClickListener{
        @Override
        public  void onClick(View v){
            switch (v.getId()){
                case R.id.SAbtn:
                    Intent intent1=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent1);
                    break;
                case R.id.ADbtn:
                    Intent intent2=new Intent(MainActivity.this,Main3Activity.class);
                    startActivity(intent2);
                    break;
                case R.id.OMbtn:
                    Intent intent3=new Intent(MainActivity.this,Main4Activity.class);
                    startActivity(intent3);
                    break;
                case R.id.AMbtn:
                    Intent intent4=new Intent(MainActivity.this,Main5Activity.class);
                    startActivity(intent4);
                    break;
            }
        }
    }


}
