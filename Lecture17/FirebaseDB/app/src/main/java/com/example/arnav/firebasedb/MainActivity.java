package com.example.arnav.firebasedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.arnav.firebasedb.adapters.TodoRecyclerAdapter;
import com.example.arnav.firebasedb.models.Todo;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {

    Button btnAddTodo;
    EditText etNewTodo;
    FirebaseDatabase database;
    RecyclerView rvTodoList;
    TodoRecyclerAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        final DatabaseReference todosRef = database.getReference("todos");

        btnAddTodo = findViewById(R.id.btnAddTodo);
        etNewTodo = findViewById(R.id.etNewTodo);
        rvTodoList = findViewById(R.id.rvTodoList);
        rvTodoList.setLayoutManager(new LinearLayoutManager(this));

        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTodo = etNewTodo.getText().toString();

                todosRef.push().setValue(new Todo(newTodo, false));
            }
        });

        Query todoListQuery = todosRef.limitToLast(20);
        FirebaseRecyclerOptions<Todo> todoQueryOptions =
                new FirebaseRecyclerOptions.Builder<Todo>()
                        .setQuery(todoListQuery, Todo.class)
                        .build();

        todoAdapter = new TodoRecyclerAdapter(
                todoQueryOptions,
                this
        );
        rvTodoList.setAdapter(todoAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (todoAdapter != null) {
            todoAdapter.startListening();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (todoAdapter != null) {
            todoAdapter.stopListening();
        }
    }
}
