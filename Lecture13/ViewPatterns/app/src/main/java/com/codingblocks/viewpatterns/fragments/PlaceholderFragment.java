package com.codingblocks.viewpatterns.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.viewpatterns.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlaceholderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaceholderFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_BACKGROUND_COLOR = "background_color";
    private static final String ARG_TEXT = "text";

    private int backgroundColor;
    private String text;


    public PlaceholderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param backgroundColor Parameter 1.
     * @param text Parameter 2.
     * @return A new instance of fragment PlaceholderFragment.
     */
    public static PlaceholderFragment newInstance(
            int backgroundColor, String text) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_BACKGROUND_COLOR, backgroundColor);
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            backgroundColor = getArguments().getInt(ARG_BACKGROUND_COLOR);
            text = getArguments().getString(ARG_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_placeholder, container, false);
        (fragmentView.findViewById(R.id.flFragmentBackground)).setBackgroundColor(backgroundColor);
        ((TextView) fragmentView.findViewById(R.id.tvFragmentText))
                .setText(text);
        return fragmentView;
    }

}
