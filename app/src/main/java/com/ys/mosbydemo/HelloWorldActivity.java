package com.ys.mosbydemo;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

public class HelloWorldActivity extends MvpActivity<HelloWorldView, HelloWorldPresenter> implements HelloWorldView, View.OnClickListener {

    private TextView greetingTextView;
    private Button helloButton;
    private Button goodbyeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetingTextView = (TextView) findViewById(R.id.greetingTextView);
        helloButton = (Button) findViewById(R.id.helloButton);
        goodbyeButton = (Button) findViewById(R.id.goodbyeButton);
        helloButton.setOnClickListener(this);
        goodbyeButton.setOnClickListener(this);
    }

    @NonNull
    @Override
    public HelloWorldPresenter createPresenter() {
        return new HelloWorldPresenter();
    }

    @Override
    public void showHello(String greetingText) {
        greetingTextView.setText(greetingText);
        greetingTextView.setTextColor(Color.RED);
    }

    @Override
    public void showGoodbye(String greetingText) {
        greetingTextView.setText(greetingText);
        greetingTextView.setTextColor(Color.BLUE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.helloButton:
                onHelloButtonClicked();
                break;
            case R.id.goodbyeButton:
                onGoodbyeButtonClicked();
                break;
            default:
        }
    }

    private void onGoodbyeButtonClicked() {
        presenter.greetGoodbye();
    }

    private void onHelloButtonClicked() {
        presenter.greetHello();
    }
}
