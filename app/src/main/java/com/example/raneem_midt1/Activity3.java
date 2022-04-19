package com.example.raneem_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {
    ArrayList<User> users=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        getAllUsers();
    }
    public void deletePerson(View view){
        EditText query=(EditText)findViewById(R.id.editTextTextPersonName);
        DBHelper dbHelper=new DBHelper(this);
        if(query.getText().toString().isEmpty()){
            Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            return;
        }
        dbHelper.deletePerson(query.getText().toString());
        getAllUsers();
    }
    void getAllUsers(){
        DBHelper dbHelper=new DBHelper(this);
        users=dbHelper.readUsers();
        TextView txt=(TextView)findViewById(R.id.textView2);
        String res="";
        for(int i=0;i<users.size();i++){
            User user=users.get(i);
            res+=" Id : "+user.id+" Name : "+user.name+" Surname : "+user.surname+" N-Id : "+user.nid+"\n";
        }
        txt.setText(res);
    }
    public void openActivity2(View view){
        Intent intent=new Intent(this,Activity2.class);
        startActivity(intent);
    }
}