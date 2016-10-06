package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dandelion.eatandgo.EatAndGoApp;
import com.dandelion.eatandgo.R;

public class AuthorizationFragment extends BaseFragment implements View.OnClickListener {

    private EditText idField;
    private EditText passwordField;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authorization, container, false);

        idField = (EditText) view.findViewById(R.id.idField);
        passwordField = (EditText) view.findViewById(R.id.passwordField);

        TextView registration = (TextView) view.findViewById(R.id.registrationTextView);
        registration.setOnClickListener(this);

        ImageButton entranceButton = (ImageButton) view.findViewById(R.id.entranceButton);
        entranceButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.entranceButton:
                if (idField.getText().toString().equals("11")
                        && passwordField.getText().toString().equals("11")) {
                    switchFragments(new ScheduleFragment());
                    showToolBar();
                    EatAndGoApp.getInstance().setIsAuthorized(true);
                }
                break;
            case R.id.registrationTextView:
                switchFragments(new RegistrationFragment());
                break;
        }
    }
}
