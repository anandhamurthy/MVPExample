package com.mvpexample;

public interface Contract {

    interface View {
        void onSuccess(String msg);
        void onError(String msg);
    }

    interface Presenter {
        void onLogin(String email_id, String password);
    }
}
