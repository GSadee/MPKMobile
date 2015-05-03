package com.pz.mpkmobile.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pz.mpkmobile.R;
import com.pz.mpkmobile.validator.EditTextValidator;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ChooseRouteFragment extends Fragment {

    private Context mContext;
    private OnFragmentClickListener mListener;
    @InjectView(R.id.edit_start) MaterialEditText mStartEditText;
    @InjectView(R.id.edit_destination) MaterialEditText mDestinationEditText;
    @InjectView(R.id.button_search_route) Button mSearchRouteButton;

    public static ChooseRouteFragment newInstance() {
        ChooseRouteFragment fragment = new ChooseRouteFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public ChooseRouteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_choose_route, container, false);
        ButterKnife.inject(this, rootView);
        super.onCreate(savedInstanceState);

        mContext = getActivity();

        setOnClickListeners();

        mStartEditText.addTextChangedListener(new EditTextValidator(mStartEditText, mContext));
        mDestinationEditText.addTextChangedListener(new EditTextValidator(mDestinationEditText, mContext));

        TextView mAppName = ButterKnife.findById(rootView, R.id.app_name);
        Typeface mTypeFace = Typeface.createFromAsset(getActivity().getAssets(), "fonts/AlexBrush-Regular.ttf");
        mAppName.setTypeface(mTypeFace);

        return rootView;
    }

    private void setOnClickListeners() {
        if (mSearchRouteButton != null) {
            mSearchRouteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mStartEditText.getText().toString().length() < 1) {
                        mStartEditText.setError(getString(R.string.field_required));
                        return;
                    }
                    if (mDestinationEditText.getText().toString().length() < 1) {
                        mDestinationEditText.setError(getString(R.string.field_required));
                        return;
                    }
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
        public void onSearchRouteClick();
    }
}
