package com.isil.am2template.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isil.am2template.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ColorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ColorFragmentListener listener;
    private String[] colors={"#6fb8c5","#6b70ec","#dc6e70","#b1429f","#e3ab72"};
    private List<View> buttons;
    private int option=0;

    public ColorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ColorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ColorFragment newInstance(String param1, String param2) {
        ColorFragment fragment = new ColorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_color, container, false);
        buttons= new ArrayList<>();
        buttons.add(view.findViewById(R.id.button1));
        buttons.add(view.findViewById(R.id.button2));
        buttons.add(view.findViewById(R.id.button3));
        buttons.add(view.findViewById(R.id.button4));
        buttons.add(view.findViewById(R.id.button5));
        return view;
    }

    private void goToOptions(View view){
        option=optionsbyView(view);
        Log.d("CONSOLE","option "+option);

        if(listener!=null){
            //listener.selectedColor(colors[option]);
            listener.selectedOptionColor(option);
        }
    }

    int  optionsbyView(View view) {
        option=0;
        switch (view.getId()){
            case R.id.button1:
                option=0;
                break;
            case R.id.button2:
                option=1;
                break;
            case R.id.button3:
                option=2;
                break;
            case R.id.button4:
                option=3;
                break;
            case R.id.button5:
                option=4;
                break;
        }

        return option;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for (View view:buttons) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //goToOptions(view);
                    //Log.d("CONSOLE", "view "+view.getId());
                    option=0;
                    switch (view.getId()){
                        case R.id.button1:
                            option=0;
                            break;
                        case R.id.button2:
                            option=1;
                            break;
                        case R.id.button3:
                            option=2;
                            break;
                        case R.id.button4:
                            option=3;
                            break;
                        case R.id.button5:
                            option=4;
                            break;
                    }
                    Log.d("CONSOLE", "ColorFrag option "+option);
                    String mColor= colors[option];
                    Log.d("CONSOLE", "ColorFrag color "+mColor);

                    if(listener!=null){
                        //listener.selectedColor(mColor);
                        listener.selectedOptionColor(option);
                    }
                }
            });
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ColorFragmentListener){
            listener= (ColorFragmentListener)context;
        }
    }
}
