package com.example.copperadmin.testnativefragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MyActivity extends ActionBarActivity implements TestFragment.Callbacks, BlankFragment.Callbacks {

    @Override
    public void onSubmitted(String data) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment oldDetail = fragmentManager.findFragmentByTag("oldDetail");
        Fragment newDetail = BlankFragment.newInstance(data);

        if(oldDetail !=null){
            ft.remove(oldDetail);

        }

        ft.add(R.id.fragment_container, newDetail, "newDetail");
        ft.addToBackStack(null);

        ft.commit();
    }

    @Override
    public void onGoTOSettings(String settings){

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment oldDetail = fragmentManager.findFragmentByTag("newDetail");
        Fragment newDetail = TestFragment.newInstance(settings);

        if(oldDetail !=null){
            ft.remove(oldDetail);

        }

        ft.add(R.id.fragment_container, newDetail, "oldDetail");
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        FragmentManager fm = getFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment==null){
            fragment = new TestFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment, "oldDetail").commit();
        }
    }


}
