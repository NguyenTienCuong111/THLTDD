package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvCauThu;
    ArrayList<CauThu> arrayCauThu;
    CauThuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        adapter = new CauThuAdapter(this, R.layout.thongtin_cauthu, arrayCauThu);
        lvCauThu.setAdapter(adapter);

        lvCauThu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    startActivity(new Intent(MainActivity.this, LionelMessi.class));
                }

            }
        });
        lvCauThu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int which_item = i ;
                AlertDialog.Builder alertDialogBuilder =new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage("Bán có muốn xóa item này!");
                alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // xóa item đang nhấn giữ
                        arrayCauThu.remove(which_item);
                        //cập nhật lại listview
                        adapter.notifyDataSetChanged();

                    }
                });
                alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //không làm gì
                    }
                });
                alertDialogBuilder.show();

                return false;
            }
        });
    }



    private void Anhxa() {
        lvCauThu = (ListView) findViewById(R.id.listviewCauThu);
        arrayCauThu = new ArrayList<>();

        arrayCauThu.add(new CauThu("Lionel Messi", "sinh: 24/06/1987",R.drawable.messi));
        arrayCauThu.add(new CauThu("Cristiano Ronaldo", "sinh: 5/2/1985",R.drawable.ronaldo));
        arrayCauThu.add(new CauThu("Neymar", "sinh: 5/2/1992",R.drawable.neymar));
        arrayCauThu.add(new CauThu("Mohamed Salah", "sinh: 15/6/1992",R.drawable.salah));
        arrayCauThu.add(new CauThu("Luis Suárez", "sinh: 24/1/1987",R.drawable.suarez));
    }
}