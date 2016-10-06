package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dandelion.eatandgo.R;

public class DialogProfileFragment extends DialogFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_profile, container, false);

        LinearLayout profileName = (LinearLayout) view.findViewById(R.id.profileName);
        profileName.setOnClickListener(this);
        LinearLayout profilePhoto = (LinearLayout) view.findViewById(R.id.profilePhoto);
        profilePhoto.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profileName:
//                изменяем имя
                break;
            case R.id.profilePhoto:
//                изменяем фото
                break;
        }
    }
}
