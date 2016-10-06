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

public class ChangePassFragment extends BaseFragment implements View.OnClickListener {

    private EditText currentPassword;
    private EditText newPassword;
    private EditText newPasswordAgain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_pass, container, false);

        currentPassword = (EditText) view.findViewById(R.id.changeCurrentPass);
        newPassword = (EditText) view.findViewById(R.id.changeNewPass);
        newPasswordAgain = (EditText) view.findViewById(R.id.changeNewPassAgain);

        TextView submit = (TextView) view.findViewById(R.id.changePassSubmit);
        submit.setOnClickListener(this);

        FloatingActionButton fab =
                (FloatingActionButton) view.findViewById(R.id.changePassFloActBut);
        fab.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changePassSubmit:
//                проверка корректности введённых данных и отправка
                break;
            case R.id.changePassFloActBut:
                switchFragments(new SettingsFragment());
                break;
        }
    }
}
