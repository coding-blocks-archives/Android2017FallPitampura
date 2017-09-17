package com.codingblocks.fragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codingblocks.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RedFragment extends Fragment {


    public RedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_red, container, false);
        rootView.findViewById(R.id.tvFragDesc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "RED Fragment Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

}
