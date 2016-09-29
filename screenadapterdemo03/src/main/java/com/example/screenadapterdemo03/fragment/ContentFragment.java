package com.example.screenadapterdemo03.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.screenadapterdemo03.MyApp;
import com.example.screenadapterdemo03.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {

    private TextView textView_content;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_content, container, false);
        this.textView_content = (TextView) view.findViewById(R.id.textView_content);
        assignValue();
        return view;
    }

    public void assignValue() {
        MyApp myApp= (MyApp) getActivity().getApplication();
        String content=myApp.getName();
        if(!TextUtils.isEmpty(content)){
            textView_content.setText(content);
        }
    }
}
