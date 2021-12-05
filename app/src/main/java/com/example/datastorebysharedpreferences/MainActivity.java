package com.example.datastorebysharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN); //Hide Key-Board on Start a Activity
        //Display Data, Fetch from SharedPreferences Database
        SharedPreferences sharedPreferences=getSharedPreferences("database1",MODE_PRIVATE);
        String output1=sharedPreferences.getString("key1","....No..Notes..Found....\n....Your..SAVE..Notes..Show..Here....");
        ((TextView) findViewById(R.id.textView2)).setText(output1);
        //Store Data into SharedPreferences Database
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((EditText) findViewById(R.id.editTextTextMultiLine)).getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Please Do Not input Empty Notes", Toast.LENGTH_SHORT).show();
                } else {
                    String value1 = ((EditText) findViewById(R.id.editTextTextMultiLine)).getText().toString().trim();
                    SharedPreferences sharedPreferences = getSharedPreferences("database1", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("key1", value1);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Notes SAVE Successfully", Toast.LENGTH_SHORT).show();
                    ((TextView) findViewById(R.id.textView2)).setText(value1);
                }
            }
        });
        //Reset Button Code Below
        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EditText) findViewById(R.id.editTextTextMultiLine)).setText("");
                Toast.makeText(MainActivity.this, "RESET Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        //Delete Button Code Below
        ((Button) findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1 = "....No..Notes..Found....\n....Your..SAVE..Notes..Show..Here....";
                SharedPreferences sharedPreferences = getSharedPreferences("database1", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("key1", value1);
                editor.apply();
                Toast.makeText(MainActivity.this, "Notes DELETE Successfully", Toast.LENGTH_SHORT).show();
                ((TextView) findViewById(R.id.textView2)).setText(value1);
            }
        });
        //Update Button Code Below
        ((Button) findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((TextView) findViewById(R.id.textView2)).getText().toString().trim().equals("....No..Notes..Found....\n....Your..SAVE..Notes..Show..Here....")) {
                    Toast.makeText(MainActivity.this, "Nothing For UPDATE\nNo Notes Found", Toast.LENGTH_SHORT).show();
                } else {
                    String value1=((TextView) findViewById(R.id.textView2)).getText().toString().trim();
                    ((EditText) findViewById(R.id.editTextTextMultiLine)).setText(value1);
                    Toast.makeText(MainActivity.this, "Tap On the SAVE Button", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
