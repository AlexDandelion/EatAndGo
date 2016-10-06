package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dandelion.eatandgo.Constants;
import com.dandelion.eatandgo.R;

public class SettingsFragment extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        LinearLayout password = (LinearLayout) view.findViewById(R.id.settingsPasswordLayout);
        password.setOnClickListener(this);
        LinearLayout profile = (LinearLayout) view.findViewById(R.id.settingsProfileLayout);
        profile.setOnClickListener(this);
        LinearLayout info = (LinearLayout) view.findViewById(R.id.settingsInfoLayout);
        info.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.settingsPasswordLayout:
                switchFragments(new ChangePassFragment());
                break;
            case R.id.settingsProfileLayout:
                new DialogProfileFragment().show(getActivity().getSupportFragmentManager(),
                        Constants.DIALOG_PROFILE);
                break;
            case R.id.settingsInfoLayout:
                new DialogInfoFragment().show(getActivity().getSupportFragmentManager(),
                        Constants.DIALOG_INFO);
                break;
        }
    }
}
