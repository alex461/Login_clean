package com.alex.app_clean.login.presenter;

public interface IntfPresenterLogin  {

    void singIn(String username, String password); //interactor
    void loginSuccess();
    void loginError(String error);
}
