package com.pz.mpkmobile.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pz.mpkmobile.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ChooseFragment extends Fragment {

    private OnFragmentClickListener mListener;
    @InjectView(R.id.choose_route) Button mChooseRouteButton;
    @InjectView(R.id.shedules) Button mShedulesButton;

    public static ChooseFragment newInstance() {
        ChooseFragment fragment = new ChooseFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public ChooseFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_choose, container, false);
        ButterKnife.inject(this, rootView);
        super.onCreate(savedInstanceState);

        setOnClickListeners();

        TextView mAppName = ButterKnife.findById(rootView, R.id.app_name);
        Typeface mTypeFace = Typeface.createFromAsset(getActivity().getAssets(), "fonts/AlexBrush-Regular.ttf");
        mAppName.setTypeface(mTypeFace);

        return rootView;
    }

    private void setOnClickListeners() {
        if (mChooseRouteButton != null) {
            mChooseRouteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onChooseRouteClick();
                }
            });
        }
        if (mShedulesButton!= null) {
            mShedulesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onShedulesClick();
                }
            });
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentClickListener) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentClickListener {
        public void onChooseRouteClick();
        public void onShedulesClick();
    }
}
