package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dandelion.eatandgo.MainActivity;
import com.dandelion.eatandgo.R;

public class AuthorizationFragment extends Fragment {

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
                    ((MainActivity) getActivity()).switchFragments(new ScheduleFragment());
                    ((MainActivity) getActivity()).setIsAuthorized(true);
                    ((MainActivity) getActivity()).showToolBar();
                }
            }
        });

        return view;
    }
}
