package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] images = {
            R.drawable.shahrar,R.drawable.madeha,R.drawable.kai,R.drawable.eliza,
            R.drawable.adiba,R.drawable.tasnim,R.drawable.ashiqur,R.drawable.sunan
    };

    String[] names,description;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        names = getResources().getStringArray(R.array.names);
        description = getResources().getStringArray(R.array.description);
        customAdapter = new CustomAdapter(names,description,images,this);

        customAdapter.setClickListener(new CustomAdapter.ClickListener() {
            @Override
            public void OnClick(int position, View v) {
                Toast.makeText(MainActivity.this,"onclick "+position,Toast.LENGTH_LONG).show();
            }

            @Override
            public void OnLongClick(int position, View v) {
                Toast.makeText(MainActivity.this,"onLONGclick "+position,Toast.LENGTH_LONG).show();
            }
        });

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
