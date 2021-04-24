/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.login;

import exception.ExceptionPvLite;
import model.User;

/**
 *
 * @author pv_lite_team
 */
public interface LoginContract {

    public interface View {

        public void onError(ExceptionPvLite exceptionPvLite);

        public void onErrorLogin();

        public void onShowAdministratorView(User user);

        public void onShowWaiterView(User user);

        public void onShowInitialBalanceModal(User user);
    }

    public interface Presenter {

        public void onError(ExceptionPvLite exceptionPvLite);

        public void login(String user, String password);

        public void onSuccessLogin(User user);

        public void onErrorLogin();

        public void onShowAdministratorView(User user);

        public void onShowInitialBalanceModal(User user);

        public String getToday();
    }

    public interface Model {

        public void login(String user, String password);

        public void checkInitialBalance(String today, User user);
    }
}
