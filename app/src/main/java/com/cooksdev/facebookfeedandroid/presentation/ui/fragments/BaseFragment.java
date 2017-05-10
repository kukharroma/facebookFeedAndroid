package com.cooksdev.facebookfeedandroid.presentation.ui.fragments;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

/**
 * Created by roma on 08.09.16.
 */
public abstract class BaseFragment extends Fragment{

    public abstract void initComponents(View view);

    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
