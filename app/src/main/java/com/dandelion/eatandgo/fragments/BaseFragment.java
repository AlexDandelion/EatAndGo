package com.dandelion.eatandgo.fragments;

import android.support.v4.app.Fragment;

import com.dandelion.eatandgo.MainActivity;

public class BaseFragment extends Fragment {

    void showToolBar() {
        ((MainActivity) getActivity()).showToolBar();
    }

    void hideToolBar() {
        ((MainActivity) getActivity()).hideToolBar();
    }

    void switchFragments(Fragment fragment) {
        ((MainActivity) getActivity()).switchFragments(fragment);
    }
}
