package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dandelion.eatandgo.EatAndGoApp;
import com.dandelion.eatandgo.R;

public class AuthorizationFragment extends BaseFragment {

    private EditText idField;
    private EditText passwordField;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authorization, container, false);

        idField = (EditText) view.findViewById(R.id.idField);
        passwordField = (EditText) view.findViewById(R.id.passwordField);

        Button entranceButton = (Button) view.findViewById(R.id.entranceButton);
        entranceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (idField.getText().toString().equals("11")
                        && passwordField.getText().toString().equals("11")) {
                    switchFragments(new ScheduleFragment());
                    showToolBar();
                    EatAndGoApp.getInstance().setIsAuthorized(true);
                }
            }
        });

        return view;
    }
}
