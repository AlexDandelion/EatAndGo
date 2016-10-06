package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.dandelion.eatandgo.R;

public class RegistrationFragment extends BaseFragment implements View.OnClickListener {

    private EditText email;
    private EditText password;
    private EditText passwordAgain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        email = (EditText) view.findViewById(R.id.regEmail);
        password = (EditText) view.findViewById(R.id.regPass);
        passwordAgain = (EditText) view.findViewById(R.id.regPassAgain);

        TextView submit = (TextView) view.findViewById(R.id.registrationSubmit);
        submit.setOnClickListener(this);

        FloatingActionButton fab =
                (FloatingActionButton) view.findViewById(R.id.registrationFloActBut);
        fab.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registrationSubmit:
//                проверка корректности введённых данных и отправка
                break;
            case R.id.registrationFloActBut:
                switchFragments(new AuthorizationFragment());
                break;
        }
    }
}
