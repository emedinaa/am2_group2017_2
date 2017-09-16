package com.isil.am2template.fragments;


import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import com.isil.am2template.R;

import static android.R.attr.duration;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private final float DISABLED_ALPHA=0.5f;
    private final float ENABLED_ALPHA=1.0f;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ColorFragmentListener listener;
    private boolean editEnabled;

    private View textViewEdit,frameLayoutForm;
    private AppCompatEditText editTextViewName, editTextViewDesc,editTextViewURL;
    private String[] colors={"#6fb8c5","#6b70ec","#dc6e70","#b1429f","#e3ab72"};

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        textViewEdit= view.findViewById(R.id.textViewEdit);
        frameLayoutForm= view.findViewById(R.id.frameLayoutForm);
        editTextViewName= (AppCompatEditText) view.findViewById(R.id.editTextViewName);
        editTextViewDesc= (AppCompatEditText)view.findViewById(R.id.editTextViewDesc);
        editTextViewURL= (AppCompatEditText)view.findViewById(R.id.editTextViewURL);
        return view;
    }

    private void enabledEditText(){
        editTextViewName.setEnabled(true);
        editTextViewDesc.setEnabled(true);
        editTextViewURL.setEnabled(true);
    };

    private void disabledEditText(){
        editTextViewName.setEnabled(false);
        editTextViewDesc.setEnabled(false);
        editTextViewURL.setEnabled(false);
    };

    private void changeStateViews(){
        //editTextViewURL.setEnabled(editEnabled);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        defaultStateView();
        textViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editEnabled){
                    disabledEditText();
                    applyAlpha(textViewEdit,DISABLED_ALPHA);
                    setEditEnabled(false);
                }else{
                    enabledEditText();
                    applyAlpha(textViewEdit,ENABLED_ALPHA);
                    setEditEnabled(true);
                }
                //editEnabled= !editEnabled;
                Log.d("CONSOLE","enabled ? "+editEnabled);
            }
        });

        //getView().findViewById(R.id.viewBlocker).setVisibility(View.GONE);
    }

    private void defaultStateView() {
        disabledEditText();
        applyAlpha(textViewEdit,DISABLED_ALPHA);
    }

    public void paintBackground(String color){
        if(frameLayoutForm!=null){
            int bgColor= Color.parseColor(color);
            frameLayoutForm.setBackgroundColor(bgColor);
        }
    }

    public void paintBackgroundByOption(int option){
        Log.d("CONSOLE", "ProfileFrag option "+option);
        String mColor= colors[option];
        //paint
        frameLayoutForm.setBackgroundColor(Color.parseColor(mColor));
        //String.format("ProfileFrag option %s %S ",option,option);
        /*if(option>colors.length)return;

        int bgColor= Color.parseColor(colors[option]);
        frameLayoutForm.setBackgroundColor(bgColor);*/
    }

    public boolean isEditEnabled() {
        return editEnabled;
    }

    public void setEditEnabled(boolean editEnabled) {
        this.editEnabled = editEnabled;
    }

    /**
     * En este método es donde asocio el fragment con el listener , o con
     * la actividad que implementa la interface ColorFragmentListener
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ColorFragmentListener){
            listener= (ColorFragmentListener)context;
        }
    }

    private void applyAlpha(View view,float alpha){
        if (Build.VERSION.SDK_INT < 11) {
            final AlphaAnimation animation = new AlphaAnimation(alpha, alpha);
            animation.setDuration(duration);
            animation.setFillAfter(true);
            view.startAnimation(animation);
        } else
            view.setAlpha(alpha);
    }

}
