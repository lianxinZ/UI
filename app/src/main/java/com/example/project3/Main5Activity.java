package com.example.project3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class Main5Activity extends Activity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        final String[] strings = new String[]{"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX"};
        int imgId = R.mipmap.launch;
        listView = (ListView)findViewById(R.id.lv2);
        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i=0;i<strings.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("img",imgId);
            listItem.put("text",strings[i]);
            listItems.add(listItem);
        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItems,R.layout.listview_item2,new String[]{"img","text"},new int[]{R.id.image,R.id.name});
        listView.setAdapter(mSimpleAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            int selectnum=0;
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                MenuInflater inflater=actionMode.getMenuInflater();
                inflater.inflate(R.menu.action_menu,menu);
                return true;
            }
            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }
            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
            }
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int position, long id, boolean checked) {
                if(checked) {
                    selectnum++;
                    listView.getChildAt(position).setBackgroundColor(Color.BLUE);//选中时背景色设为红色
                }
                else {
                    selectnum--;
                    listView.getChildAt(position).setBackgroundColor(Color.TRANSPARENT);//取消选中
                }
                actionMode.setTitle(selectnum + " selected");


            }
        });
    }




}