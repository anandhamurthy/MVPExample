package com.mvpexample;

public class Presenter implements Contract.Presenter{

    Contract.View view;

    public Presenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void onLogin(String email_id, String password) {

        if (email_id.equals("admin@adt.com") && password.equals("admin")) {
            view.onSuccess("Successfully Logged In.");
        }else {
            view.onError("Login Failed!");
        }
    }


}
