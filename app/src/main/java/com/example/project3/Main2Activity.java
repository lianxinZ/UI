package com.example.project3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ListView mlv1;
    private List<Map<String,Object>>lists;
    private SimpleAdapter adapter;
    Toast toast;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String[] names={"Lion","tiger","Monkey","Dog","cat","Elephant"};
        int [] images={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
        mlv1=findViewById(R.id.lv1);
        lists=new ArrayList<>();//创建数据list；
        for(int i=0;i<names.length;i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("name",names[i]);
            item.put("image",images[i]);
            lists.add(item);
        }
        adapter=new SimpleAdapter(Main2Activity.this,lists,R.layout.listview_item
                ,new String[]{"name","image"},new int[]{R.id.name,R.id.image});
        mlv1.setAdapter(adapter);
        mlv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        mlv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {//listview点击事件
            String[] names={"Lion","tiger","Monkey","Dog","cat","Elephant"};
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (toast!=null)
                    toast.cancel();//如果totast不为空则取消这次显示。
                toast= Toast.makeText(getApplicationContext(), names[position], Toast.LENGTH_SHORT);
                toast.show();

                for(int i=0;i<names.length;i++){
                    if(position==i){
                        mlv1.getChildAt(i).setBackgroundColor(Color.RED);
                    }else
                        mlv1.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);

                }
            }
        });
    }

}
