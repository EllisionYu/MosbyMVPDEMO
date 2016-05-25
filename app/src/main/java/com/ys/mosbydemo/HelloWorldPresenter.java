package com.ys.mosbydemo;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * Created by 10370 on 2016/5/25.
 * The Presenter that coordinates the business logic and the view.
 */
public class HelloWorldPresenter extends MvpBasePresenter<HelloWorldView> {

    private GreetingGeneratorTask greetingGeneratorTask;

    private void cancelGreetingTaskIfRunning(){
        if(greetingGeneratorTask != null){
            greetingGeneratorTask.cancel(true);
        }
    }

    public void greetHello(){
        cancelGreetingTaskIfRunning();
        greetingGeneratorTask = new GreetingGeneratorTask("Hello", new GreetingGeneratorTask.GreetingTaskListener() {
            @Override
            public void onGreetingGenerated(String greetingText) {
                if(isViewAttached())
                    getView().showHello(greetingText);
            }
        });
        greetingGeneratorTask.execute();
    }

    public void greetGoodbye(){
        cancelGreetingTaskIfRunning();
        greetingGeneratorTask = new GreetingGeneratorTask("Goodbye", new GreetingGeneratorTask.GreetingTaskListener() {
            @Override
            public void onGreetingGenerated(String greetingText) {
                if(isViewAttached())
                    getView().showGoodbye(greetingText);
            }
        });
        greetingGeneratorTask.execute();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if(!retainInstance)
            cancelGreetingTaskIfRunning();
    }
}
