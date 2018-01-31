package com.example.dapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Food_Record_all extends AppCompatActivity implements View.OnClickListener {
    private String[] record_item = {"分析报告", "记录修改", "饮食情况"};
    private int[] record_pic = {R.drawable.reprot_a, R.drawable.reprot_re, R.drawable.report_con};
    private List<Map<String, Object>> record_list;
    private Toolbar toolbar;
    private GridView gridView;
    private SimpleAdapter sim_adapter;
    private LinearLayout add_food_LL;
    Bundle bundle_from_MA;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_record_all);
        toolbar = findViewById(R.id.food_record_all_toolbar);
        gridView = findViewById(R.id.foodRecord_gridView);
        add_food_LL = findViewById(R.id.add_food_record_LL);
        record_list = new ArrayList<>();
        getData();
        String[] from = {"image_record", "text_record"};
        int[] to = {R.id.image_record, R.id.text_record};
        sim_adapter = new SimpleAdapter(this, record_list, R.layout.record_all_item, from, to);
        gridView.setAdapter(sim_adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });

        Intent intent=getIntent();
        bundle_from_MA = intent.getExtras();

        setSupportActionBar(toolbar);
        toolbar.getBackground().setAlpha(0);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Food_Record_all.this.finish();
            }
        });


    }

    private List<Map<String, Object>> getData() {
        for (int i = 0; i < record_pic.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image_record", record_pic[i]);
            map.put("text_record", record_item[i]);
            record_list.add(map);
        }
        return record_list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_food_record_LL:
                Intent intent=new Intent(Food_Record_all.this,Food_searchToAdd.class);
                intent.putExtras(bundle_from_MA);
                startActivity(intent);
                break;
        }
    }
}
