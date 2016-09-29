package com.example.screenadapterdemo03.fragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.screenadapterdemo03.MyApp;
import com.example.screenadapterdemo03.R;
import com.example.screenadapterdemo03.activity.DetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/9/29.
 */
public class LeftFragment extends ListFragment{

    private ArrayAdapter<String> adapter;
    private List<String> data;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.data=this.getData();
        this.adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
        this.setListAdapter(adapter);

    }

    private List<String> getData() {
        this.data=new ArrayList<>();
        for (int i=0;i<30;i++){
            data.add("lebron"+i);
        }
        return this.data;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String name = data.get(position);
        Toast.makeText(this.getActivity(), "name="+name, Toast.LENGTH_SHORT).show();

        MyApp myApp= (MyApp) getActivity().getApplication();
        myApp.setName(name);

        int screenOrientation=getResources().getConfiguration().orientation;
        //Configuration.ORIENTATION_PORTRAIT:代表当前手机方向为竖屏
        if(screenOrientation== Configuration.ORIENTATION_PORTRAIT){
            Intent intent=new Intent(getActivity(), DetailActivity.class);
            startActivity(intent);

            // Configuration.ORIENTATION_LANDSCAPE:代表当前手机方向为横屏
        }else if(screenOrientation== Configuration.ORIENTATION_LANDSCAPE){
            ContentFragment contentFragment= (ContentFragment) getFragmentManager().findFragmentById(R.id.fragment_content);
            //ContentFragment contentFagment= (ContentFragment) getFragmentManager().findFragmentById(R.id.fragment_content);
            contentFragment.assignValue();
        }
    }
}
