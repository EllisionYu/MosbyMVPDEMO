package com.ys.mosbydemo;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by 10370 on 2016/5/25.
 * View interface
 */
public interface HelloWorldView extends MvpView {
    void showHello(String greetingText);
    void showGoodbye(String greetingText);
}
