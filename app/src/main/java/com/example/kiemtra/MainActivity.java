package com.example.kiemtra;

import android.app.Dialog;
import android.os.Bundle;

import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewv;
    ListViewBaseAdapter adapter;
    ArrayList<ListViewBean> arr_bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewv = (ListView) findViewById(R.id.listview);

        addControls();
        arr_bean=new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.bigbang, "Song:Love Song","Rating 5*"));
        arr_bean.add(new ListViewBean(R.drawable.bray,"Song:Do for Love","Rating 4.5*"));
        arr_bean.add(new ListViewBean(R.drawable.mtp, "Song:Run Now","Rating 5*"));
        arr_bean.add(new ListViewBean(R.drawable.sia, "Sia","Singer of USA"));
        arr_bean.add(new ListViewBean(R.drawable.sia, "Sia","Singer of USA"));
        adapter=new ListViewBaseAdapter(arr_bean,this);
        listViewv.setAdapter(adapter);
    }


    private void addControls() {
       listViewv=findViewById(R.id.listview);
       listViewv.setAdapter((ListAdapter) arr_bean);

        listViewv.setAdapter((ListAdapter) arr_bean);
       registerForContextMenu(listViewv);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arr_bean);
        listViewv.setAdapter(adapter);
        int pos=info.position;
        switch (item.getItemId()){
            case R.id.xoa:
                arr_bean.remove(pos);
                adapter.notifyDataSetChanged();
                break;
            case R.id.them:
                displayAdd();
        }
        return super.onContextItemSelected(item);
    }

    private void displayAdd() {
        final Dialog dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.layout_add);
        final EditText edtSong=dialog.findViewById(R.id.edtSong);
        final EditText edtRating=dialog.findViewById(R.id.edtRating);
        Button btn_them=dialog.findViewById(R.id.btn_them);
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListViewBean listViewBean=new ListViewBean();
                listViewBean.setLangName(edtSong.getText().toString());
                listViewBean.setTittle(edtRating.getText().toString());
                arr_bean.add(listViewBean);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_context,menu);
    }
}