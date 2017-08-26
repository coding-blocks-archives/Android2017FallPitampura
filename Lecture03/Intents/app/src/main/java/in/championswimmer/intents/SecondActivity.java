package in.championswimmer.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResult = (TextView) findViewById(R.id.tvResult);

        int result = getIntent().getIntExtra("result", 0);
        tvResult.setText(String.valueOf(result));
    }
}
