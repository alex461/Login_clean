package com.alex.app_clean.login.interactor;

import com.alex.app_clean.login.presenter.IntfPresenterLogin;
import com.alex.app_clean.login.repository.ImplRepositoryLogin;
import com.alex.app_clean.login.repository.IntfRepositoryLogin;



public class ImplInteractoLogin implements IntfIteractorLogin {

    private IntfPresenterLogin intfPresenterLogin;
    private IntfRepositoryLogin intfRepositoryLogin;


    public ImplInteractoLogin(IntfPresenterLogin intfPresenterLogin) {
        this.intfPresenterLogin = intfPresenterLogin;
        intfRepositoryLogin= new ImplRepositoryLogin(intfPresenterLogin);

    }

    @Override
    public void singIn(String username, String password) {
        intfRepositoryLogin.singIn(username,password);
    }
}
