package com.alex.app_clean.login.view;

public interface IntfViewLogin {

    void enableImput();
    void disableImput();

    void showProgressBar();
    void hideProgressBar();

    void loginError(String error);

    void goCreateAccont();
    void goHome();
}
