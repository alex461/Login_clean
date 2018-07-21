package com.alex.app_clean.login.presenter;

import com.alex.app_clean.login.interactor.ImplInteractoLogin;
import com.alex.app_clean.login.interactor.IntfIteractorLogin;
import com.alex.app_clean.login.view.IntfViewLogin;


public class ImplPresenterLogin implements IntfPresenterLogin {

    IntfViewLogin intfViewLogin;
    IntfIteractorLogin intfIteractorLogin;

    public ImplPresenterLogin(IntfViewLogin intfViewLogin) {
        this.intfViewLogin = intfViewLogin;
        intfIteractorLogin = new ImplInteractoLogin(this);
    }

    @Override
    public void singIn(String username, String password) {
        intfViewLogin.disableImput();
        intfViewLogin.showProgressBar();
        intfIteractorLogin.singIn(username,password);
    }

    @Override
    public void loginSuccess() {
        intfViewLogin.goHome();
        intfViewLogin.hideProgressBar();
    }

    @Override
    public void loginError(String error) {
        intfViewLogin.enableImput();
        intfViewLogin.hideProgressBar();
        intfViewLogin.loginError(error);
    }
}
