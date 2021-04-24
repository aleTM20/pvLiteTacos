/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.administrator;

import contract.administrator.BoxContract;
import exception.ExceptionPvLite;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import model.User;
import model.administrator.BoxModel;

/**
 *
 * @author pv_lite_team
 */
public class BoxPresenter implements BoxContract.Presenter {

    private BoxContract.View view;
    public BoxModel model;

    public BoxPresenter(BoxContract.View view) {
        this.view = view;
        this.model = new BoxModel(this);

    }

    @Override
    public void onError(ExceptionPvLite exceptionPvLite) {
        view.onError(exceptionPvLite);
    }

    @Override
    public void onShowAdministratorView() {
        view.onShowAdministratorView();
    }

    @Override
    public void createInitialBalance(int idUser, float initialBalance, String comment) {
        model.createInitialBalance(idUser, initialBalance, comment, this.getToday(), this.getHour());
    }

    @Override
    public String getToday() {
        return new SimpleDateFormat("YYYY-MM-dd").format(new Date());
    }

    @Override
    public String getHour() {
        Calendar calendario = new GregorianCalendar();
        String temporaryTime;
        String minute;
        String second;
        int hor = calendario.get(Calendar.HOUR);
        int min = calendario.get(Calendar.MINUTE);
        int sec = calendario.get(Calendar.SECOND);
        if (hor < 10) {
            temporaryTime = "0" + String.valueOf(hor);
        } else {
            temporaryTime = String.valueOf(hor);
        }
        if (min < 10) {
            minute = "0" + String.valueOf(min);
        } else {
            minute = String.valueOf(min);
        }
        if (sec < 10) {
            second = "0" + String.valueOf(sec);
        } else {
            second = String.valueOf(sec);
        }
        return temporaryTime + ":" + minute + ":" + second;
    }

}
