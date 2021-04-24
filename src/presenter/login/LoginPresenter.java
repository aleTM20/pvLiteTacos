/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.login;

import contract.login.LoginContract;
import exception.ExceptionPvLite;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.User;
import model.login.LoginModel;

/**
 *
 * @author pv_lite_team
 */
public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View view;
    private final LoginModel model;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.model = new LoginModel(this);

    }

    @Override
    public void onError(ExceptionPvLite exceptionPvLite) {
        view.onError(exceptionPvLite);
    }

    @Override
    public void login(String user, String password) {
        model.login(user, password);
    }

    @Override
    public void onSuccessLogin(User user) {
        if (user.getTypeUser().equals("ADMINISTRADOR")) {
            model.checkInitialBalance(this.getToday(), user);
        } else {
            view.onShowWaiterView(user);
        }
    }

    @Override
    public void onErrorLogin() {
        view.onErrorLogin();
    }

    @Override
    public void onShowAdministratorView(User user) {
        view.onShowAdministratorView(user);
    }

    @Override
    public void onShowInitialBalanceModal(User user) {
        view.onShowInitialBalanceModal(user);
    }

    @Override
    public String getToday() {
        return new SimpleDateFormat("YYYY-MM-dd").format(new Date());
    }

}
