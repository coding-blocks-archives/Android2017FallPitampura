package in.championswimmer.assignment.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import in.championswimmer.assignment.R;
import in.championswimmer.assignment.adapters.CenterRecyclerAdapter;
import in.championswimmer.assignment.models.Center;

public class CenterListActivity extends AppCompatActivity {

    RecyclerView rvCenters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);

        rvCenters = (RecyclerView) findViewById(R.id.rvCenters);
        rvCenters.setLayoutManager(new LinearLayoutManager(this));

        rvCenters.setAdapter(new CenterRecyclerAdapter(
                this,
                Center.generateCenters(50)
        ));
    }
}
