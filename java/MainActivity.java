package com.example.infinity.dailywork;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        Toast.makeText(this, titleData + " " + descData, Toast.LENGTH_SHORT).show();

    }   
}
