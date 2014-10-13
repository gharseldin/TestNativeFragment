package com.example.copperadmin.testnativefragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class TestFragment extends Fragment {

    public static final String TAG = "TestFragment";
    public static final String SETTINGS = "settings";

    private Callbacks mCallbacks;

    public interface Callbacks{
        void onSubmitted(String data);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbacks = (Callbacks)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks =null;
    }

    public static TestFragment newInstance(String settings){
        Bundle args = new Bundle();
        args.putString(SETTINGS, settings );
        TestFragment testFragment = new TestFragment();
        testFragment.setArguments(args);
        return testFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_test, container, false);


        TextView textView = (TextView)v.findViewById(R.id.testView);



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbacks.onSubmitted("THIS IS THE TEXT I WANT TO SHOW");
            }
        });

        if(getArguments()!=null){
            if(getArguments().getString(SETTINGS)!=null){
                textView.setText(getArguments().getString(SETTINGS));
            }
        }

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Test fragment Paused");
    }
}
