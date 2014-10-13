package com.example.copperadmin.testnativefragment;



import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class BlankFragment extends Fragment {



    public static final String TAG="BlankFragment";
    public static final String DATA_PASSED="data";

    private Callbacks mCallbacks;

    public interface Callbacks{
        public void onGoTOSettings(String settings);
    }

    public static Fragment newInstance(String data){

        Bundle args = new Bundle();
        args.putString(DATA_PASSED,data);
        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(args);
        return fragment;

    }

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);


        TextView textView = (TextView) view.findViewById(R.id.blank_fragment_TextView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbacks.onGoTOSettings("This is the settings variable");
            }
        });

        if(getArguments()!=null){
            String data = getArguments().getString(DATA_PASSED);
            textView.setText(data);
        }


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Fragment Created");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbacks = (Callbacks)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }
}
