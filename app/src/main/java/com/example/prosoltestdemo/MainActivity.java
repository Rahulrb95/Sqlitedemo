package com.example.prosoltestdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtEmpName,edtEmpAddress,edtEmpPhone,edtEmpEmail;
    Button btnAddEmployee;
    Button btnShowEmployee;
    SqliteDatabase sqliteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmpName=findViewById(R.id.edtEmpName);
        edtEmpAddress=findViewById(R.id.edtEmpAddress);
        edtEmpPhone=findViewById(R.id.edtEmpPhone);
        edtEmpEmail=findViewById(R.id.edtEmpEmail);


        sqliteDatabase = new SqliteDatabase(this);
        btnAddEmployee=findViewById(R.id.btnAddEmployee);
        btnShowEmployee=findViewById(R.id.btnShowEmployee);

        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=edtEmpName.getText().toString();
                String address=edtEmpAddress.getText().toString();
                String email=edtEmpEmail.getText().toString();
                String phone=edtEmpPhone.getText().toString();

                UserModel userModel = new UserModel(name,address,email,phone);

                sqliteDatabase.AddEmployee(userModel);



            }
        });

        btnShowEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });



    }
}
