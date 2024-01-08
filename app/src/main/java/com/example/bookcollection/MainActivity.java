package com.example.bookcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editTitle,editGenre, editDate;
    Button btnReserve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editTitle = (EditText)findViewById(R.id.etitle);
        editGenre = (EditText)findViewById(R.id.egenre);
        editDate = (EditText)findViewById(R.id.edate);
        btnReserve = (Button) findViewById(R.id.btnreserve);
        AddData();
    }


    public void AddData(){
        btnReserve = (Button) findViewById(R.id.btnreserve);
        btnReserve.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String txtTitle = editTitle.getText().toString();
                String txtGenre = editGenre.getText().toString();
                String txtDate = editDate.getText().toString();

                boolean isInserted =  myDb.insertData(txtTitle,txtGenre,txtDate);
                if(isInserted =  true){
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    editTitle.setText(" ");
                    editGenre.setText(" ");
                    editDate.setText(" ");
                }else{
                    Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}