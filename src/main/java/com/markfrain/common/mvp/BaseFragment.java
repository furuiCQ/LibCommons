package com.markfrain.common.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;



public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView {
    // Presenter对象
    protected P mvpPre;
    public View rootView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mvpPre = bindPresenter();
        super.onViewCreated(view, savedInstanceState);
    }

    // 绑定Presenter
    protected abstract P bindPresenter();

    @Override
    public Activity getSelfActivity() {
        return getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mvpPre != null) {
            mvpPre.detachView();
        }
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getSelfActivity().getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLToast(String str) {
        Toast.makeText(getSelfActivity().getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }



}