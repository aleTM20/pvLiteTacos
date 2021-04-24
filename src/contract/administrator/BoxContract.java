/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.administrator;

import contract.waiter.*;
import exception.ExceptionPvLite;
import java.util.List;
import model.Product;
import model.User;

/**
 *
 * @author pv_lite_team
 */
public interface BoxContract {

    public interface View {
        public void onError(ExceptionPvLite exceptionPvLite);
        public void onShowAdministratorView();
    }

    public interface Presenter {
        public void onError(ExceptionPvLite exceptionPvLite);
        public void createInitialBalance(int idUser, float initialBalance, String comment);
        public void onShowAdministratorView();
        public String getHour();
        public String getToday();
    }

    public interface Model {
        public void createInitialBalance(int idUser, float initialBalance, String comment, String day, String hour);
    }
}
