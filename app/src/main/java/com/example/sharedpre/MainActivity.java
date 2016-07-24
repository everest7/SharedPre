package com.example.sharedpre;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView buckysText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput=(EditText) findViewById(R.id.usernameInput);
        passwordInput=(EditText) findViewById(R.id.passwordInput);
        buckysText=(TextView) findViewById(R.id.buckysText);
    }

    //Save the user login info
    public void saveInfo(View view){
        SharedPreferences sharePref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString("username",usernameInput.getText().toString());
        editor.putString("password",passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();

    }

    //Print out the saved info
    public void displayData(View view){
        SharedPreferences sharePref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name = sharePref.getString("username","");
        String pw = sharePref.getString("password","");
        buckysText.setText(name+ " "+ pw);


    }
}
