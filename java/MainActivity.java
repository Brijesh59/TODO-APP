package com.example.infinity.dailywork;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> descriptionData = new ArrayList<>();

    EditText title, description;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
    }
    
    public void addTask(View v){
        showAlert();
    }

    void showAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View view = getLayoutInflater().inflate(R.layout.user_form, null);
        builder.setView(view);
        builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                fetchData(view);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }
    
    void fetchData(View view){
        title = view.findViewById(R.id.title);
        description = view.findViewById(R.id.description);

        String titleData = title.getText().toString();
        String descData = description.getText().toString();

        titles.add(titleData);
        descriptionData.add(descData);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles);
        listView.setAdapter(adapter);

    }   
    
}
