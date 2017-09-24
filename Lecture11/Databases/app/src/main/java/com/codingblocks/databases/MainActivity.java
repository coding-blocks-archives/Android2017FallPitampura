package com.codingblocks.databases;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.codingblocks.databases.db.TodoDbHelper;
import com.codingblocks.databases.db.tables.TodoTable;
import com.codingblocks.databases.models.Todo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvTodos;
    EditText etNewTodo;
    Button btnAddTodo;
    ArrayList<Todo> todos = new ArrayList<>();

    public static final String TAG = "DB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SQLiteDatabase todoDb = new TodoDbHelper(this).getWritableDatabase();

        rvTodos = (RecyclerView) findViewById(R.id.rvTodos);
        etNewTodo = (EditText) findViewById(R.id.etNewTodo);
        btnAddTodo = (Button) findViewById(R.id.btnAddTodo);
        todos = TodoTable.getAllTodos(todoDb);

        final TodoAdapter todoArrayAdapter = new TodoAdapter();
        rvTodos.setLayoutManager(new LinearLayoutManager(this));
        rvTodos.setAdapter(todoArrayAdapter);


        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long todoId = TodoTable.insertTodo(
                        todoDb,
                        new Todo(etNewTodo.getText().toString(), false)
                );
                Log.d(TAG, "onClick: " + todoId);

                todos = TodoTable.getAllTodos(todoDb);
                todoArrayAdapter.notifyDataSetChanged();

            }
        });



    }

    class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

        @Override
        public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TodoViewHolder(getLayoutInflater().inflate(android.R.layout.simple_list_item_1, parent, false));
        }

        @Override
        public void onBindViewHolder(TodoViewHolder holder, int position) {
            holder.text1.setText(todos.get(position).getTask());
        }

        @Override
        public int getItemCount() {
            Log.d(TAG, "getItemCount: " + todos.size());
            return todos.size();
        }

        class TodoViewHolder extends RecyclerView.ViewHolder {
            TextView text1;

            public TodoViewHolder(View itemView) {
                super(itemView);
                text1 = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
