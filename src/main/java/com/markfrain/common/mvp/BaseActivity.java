package com.markfrain.common.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * BaseActivity
 * mvp下的Activity。解决mvp情况下
 * view和presenter互相持有的问题
 *
 * @param <P>
 */
public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView {
    // Presenter对象
    protected P mvpPre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpPre = bindPresenter();

    }

    // 绑定Presenter
    protected abstract P bindPresenter();

    @Override
    public Activity getSelfActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 在生命周期结束时，将presenter与view之间的联系断开，防止出现内存泄露
         */
        if (mvpPre != null) {
            mvpPre.detachView();
        }
    }

    /**
     * 展示短时间的Toast
     *
     * @param str
     */
    @Override
    public void showToast(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    /**
     * 展示长时间的Toast
     *
     * @param str
     */
    @Override
    public void showLToast(String str) {
        Toast.makeText(getSelfActivity().getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
}