package in.championswimmer.assignment.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by championswimmer on 27/08/17.
 */

public class GenericRecyclerAdapter<T>
        extends RecyclerView.Adapter<ItemViewHolder<T>> {
    private Context context;
    private ArrayList<T> items;
    private int layoutType;

    public GenericRecyclerAdapter(Context context, ArrayList<T> items, int layoutType) {
        this.context = context;
        this.items = items;
        this.layoutType = layoutType;
    }


    @Override
    public ItemViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(layoutType, parent, false);

        return new ItemViewHolder<>(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder<T> holder, int position) {

        T thisItem = items.get(position);
        holder.bindView(thisItem);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
