package in.championswimmer.assignment.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import in.championswimmer.assignment.R;
import in.championswimmer.assignment.models.Center;

/**
 * Created by championswimmer on 27/08/17.
 */

public class CenterRecyclerAdapter extends RecyclerView.Adapter<CenterRecyclerAdapter.CenterViewHolder> {
    public static final String TAG = "CoRA";

    private Context context;
    private ArrayList<Center> centers;

    public CenterRecyclerAdapter(Context context, ArrayList<Center> centers) {
        this.context = context;
        this.centers = centers;
    }

    @Override
    public CenterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_center_card, parent, false);
        return new CenterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CenterViewHolder holder, int position) {
        Center thisCenter = centers.get(position);
        holder.tvLocation.setText(thisCenter.getLocation());
        holder.tvCity.setText(thisCenter.getCity());
        holder.tvContact.setText(thisCenter.getContactNumber());
    }

    @Override
    public int getItemCount() {
        return centers.size();
    }

    class CenterViewHolder extends RecyclerView.ViewHolder {
        TextView tvLocation, tvCity, tvContact;

        public CenterViewHolder(View itemView) {
            super(itemView);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvCity = itemView.findViewById(R.id.tvCity);
            tvContact = itemView.findViewById(R.id.tvContact);
        }
    }
}
