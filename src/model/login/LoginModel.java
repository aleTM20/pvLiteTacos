/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.login;

import contract.login.LoginContract;
import exception.ExceptionPvLite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;
import model.connection.PVLConnection;

/**
 *
 * @author pv_lite_team
 */
public class LoginModel extends PVLConnection implements LoginContract.Model {

    private LoginContract.Presenter presenter;

    public LoginModel(LoginContract.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    @Override
    public void checkInitialBalance(String today, User user) {
        try {
            String sql = "SELECT * FROM cortecaja WHERE fecha = '" + today + "'";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                presenter.onShowAdministratorView(user);
            } else {
                presenter.onShowInitialBalanceModal(user);
            }
        } catch (SQLException ex) {
            presenter.onError(new ExceptionPvLite("Error en consultar saldo inicial", ex.toString()));
        }
    }

    @Override
    public void login(String user, String password) {
        try {
            String sql = "SELECT * FROM usuarios WHERE usuario = '" + user + "' and password = '" + password + "' ";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                presenter.onSuccessLogin(new User(rs.getInt("idUsuario"), rs.getString("usuario"), rs.getString("tipousuario"), rs.getString("nombre")));
            } else {
                presenter.onErrorLogin();
            }
        } catch (SQLException ex) {
            presenter.onError(new ExceptionPvLite("Error al revisar credenciales", ex.toString()));
        }

    }

}
