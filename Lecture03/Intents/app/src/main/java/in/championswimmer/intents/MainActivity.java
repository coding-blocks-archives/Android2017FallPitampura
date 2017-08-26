package in.championswimmer.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnIntent;
    EditText etVar1, etVar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntent = (Button) findViewById(R.id.btnIntent);
        etVar1 = (EditText) findViewById(R.id.etVar1);
        etVar2 = (EditText) findViewById(R.id.etVar2);


        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.valueOf(etVar1.getText().toString());
                int b = Integer.valueOf(etVar2.getText().toString());
                int c = a + b;


                Intent i = new Intent(MainActivity.this, SecondActivity.class);

                i.putExtra("result", c);

                startActivity(i);
            }
        });
    }
}
