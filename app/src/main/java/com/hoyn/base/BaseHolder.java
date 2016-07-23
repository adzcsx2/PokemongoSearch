package com.hoyn.base;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Hoyn
 * Created by a on 2016/6/12.
 */
public abstract class BaseHolder {
    public BaseHolder(View view) {
        ButterKnife.bind(this, view);
    }
}
