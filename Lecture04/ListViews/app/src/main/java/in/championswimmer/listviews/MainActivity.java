package in.championswimmer.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] courses = new String[] {
            "Pandora",
            "Crux",
            "Launchpad",
            "Algo++",
            "Pandora",
            "Crux",
            "Launchpad",
            "Algo++",
            "Pandora",
            "Crux",
            "Launchpad",
            "Algo++",
            "Elixir"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> courseListAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                courses);
        listView.setAdapter(courseListAdapter);

    }
}
