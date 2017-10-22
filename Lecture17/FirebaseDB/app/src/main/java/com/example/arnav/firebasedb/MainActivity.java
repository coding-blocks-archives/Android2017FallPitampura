package com.example.arnav.firebasedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btnAddTodo;
    EditText etNewTodo;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        final DatabaseReference todosRef = database.getReference("todos");

        btnAddTodo = findViewById(R.id.btnAddTodo);
        etNewTodo = findViewById(R.id.etNewTodo);

        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTodo = etNewTodo.getText().toString();

                todosRef.push().setValue(newTodo);
            }
        });


    }
}
