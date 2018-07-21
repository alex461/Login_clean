package com.alex.app_clean.login.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alex.app_clean.R;
import com.alex.app_clean.activity.ContainerActivity;
import com.alex.app_clean.login.presenter.ImplPresenterLogin;
import com.alex.app_clean.login.presenter.IntfPresenterLogin;

public class Login extends AppCompatActivity implements IntfViewLogin{

    private TextInputEditText edi1,edi2;
    private Button bt1;
    private ProgressBar proB1;
    private IntfPresenterLogin presenterLogin;

    private TextView bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cast();
        hideProgressBar();

        presenterLogin = new ImplPresenterLogin(this);
    }

    private void cast() {

        edi1=findViewById(R.id.ediL1ID);
        edi2=findViewById(R.id.ediL2ID);

        proB1=findViewById(R.id.progresLogin);

        bt1=findViewById(R.id.btL1Id);
        bt2= findViewById(R.id.tvL4ID);

    }


    @Override
    public void enableImput() {
        edi1.setEnabled(true);
        edi2.setEnabled(true);
        bt1.setEnabled(true);
    }

    @Override
    public void disableImput() {
        edi1.setEnabled(false);
        edi2.setEnabled(false);
        bt1.setEnabled(false);
    }

    @Override
    public void showProgressBar() {
        proB1.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        proB1.setVisibility(View.GONE);
    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this, getString(R.string.login_error)+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goCreateAccont() {
        Intent intent1 = new Intent(Login.this,Create_account.class);
        startActivity(intent1);
    }

    @Override
    public void goHome() {
        Intent intent = new Intent(Login.this,ContainerActivity.class);
        startActivity(intent);
    }


    public void next(View view) {
        presenterLogin.singIn(edi1.getText().toString(),edi2.getText().toString());
        goHome();
    }

    public void btcreateAcc(View view) {
        goCreateAccont();
    }
}
