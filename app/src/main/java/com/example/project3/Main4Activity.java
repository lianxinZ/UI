package com.example.project3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class Main4Activity extends AppCompatActivity {
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        t1 = findViewById(R.id.Test);
    }

    public boolean onCreateOptionsMenu(Menu menu) {//得到菜单加载器
        MenuInflater menuInflater = getMenuInflater();//将menu中的xml资源文件中的菜单选项加载到 menu对象上
        menuInflater.inflate(R.menu.options_menu, menu);//return super.onCreateOptionsMenu(menu);
//返回值改成true
        return true;
    }
   // 为菜单选项设置监听器，重写onOptionsItemSelected
    public boolean onOptionsItemSelected(MenuItem item) {
        int red = R.id.red;
        int black = R.id.black;
        int pt=R.id.pt;
        int min = R.id.min;
        int mid = R.id.mid;
        int max = R.id.max;
//判断点击的按钮是哪个
        if (item.getItemId() == red) {
            t1.setTextColor(Color.RED);
        }
        if (item.getItemId() == black) {
            t1.setTextColor(Color.BLACK);
        }

        if (item.getItemId() == min) {
            t1.setTextSize(TypedValue.COMPLEX_UNIT_PX, 100);
        }
        if (item.getItemId() == mid) {
            t1.setTextSize(TypedValue.COMPLEX_UNIT_PX, 160);
        }
        if (item.getItemId() == max) {
            t1.setTextSize(TypedValue.COMPLEX_UNIT_PX, 200);
        }

        if (item.getItemId() == pt) {
          Toast  toast= Toast.makeText(getApplicationContext(), "你点击了普通菜单选项", Toast.LENGTH_SHORT);
            toast.show();
        }
//返回值不用修改
        return super.onOptionsItemSelected(item);
    }

}
