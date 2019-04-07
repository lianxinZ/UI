# 实验三 UI组件
## 1.SimpleAdapter
### 关键代码：
~~~ 
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
        })
~~~
### 结果截图：
<image width='250dp' hight='450dp' src="https://github.com/lianxinZ/UI/blob/master/READMEIMAGE/2.png">

## 2.AlertDialog
### 关键代码：
~~~ 
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
~~~
### 结果截图：
<image width='250dp' hight='450dp' src="https://github.com/lianxinZ/UI/blob/master/READMEIMAGE/3.png">

## 3.XML定义菜单
### 关键代码：
~~~ 
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
   ~~~
### 结果截图：
<image width='250dp' hight='450dp' src="https://github.com/lianxinZ/UI/blob/master/READMEIMAGE/4.png">
<image width='250dp' hight='450dp' src="https://github.com/lianxinZ/UI/blob/master/READMEIMAGE/4-1.png">
<image width='250dp' hight='450dp' src="https://github.com/lianxinZ/UI/blob/master/READMEIMAGE/4-2.png">
<image width='250dp' hight='450dp' src="https://github.com/lianxinZ/UI/blob/master/READMEIMAGE/4-3.png">

## 4.ActionMode
### 关键代码：
~~~
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
   ~~~
### 结果截图：
<image width='250dp' hight='450dp' src="https://github.com/lianxinZ/UI/blob/master/READMEIMAGE/5.png">
   
