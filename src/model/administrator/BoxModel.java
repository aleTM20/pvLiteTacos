/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.administrator;

import contract.administrator.BoxContract;
import exception.ExceptionPvLite;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.User;
import model.connection.PVLConnection;

/**
 *
 * @author pv_lite_team
 */
public class BoxModel extends PVLConnection implements BoxContract.Model {

    private final BoxContract.Presenter presenter;

    public BoxModel(BoxContract.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    @Override
    public void createInitialBalance(int idUser, float initialBalance, String comment, String day, String hour) {
        try {
            String sql = "INSERT INTO cortecaja VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setInt(1, 0);
            pst.setInt(2, idUser);
            pst.setFloat(3, initialBalance);
            pst.setFloat(4, 0);
            pst.setFloat(5, 0);
            pst.setFloat(6, 0);
            pst.setString(7, comment);
            pst.setString(8, day);
            pst.setString(9, hour);
            pst.executeUpdate();
            presenter.onShowAdministratorView();
        } catch (Exception ex) {
            presenter.onError(new ExceptionPvLite("Error en insertar saldo inicial", ex.toString()));
        }
    }


}
