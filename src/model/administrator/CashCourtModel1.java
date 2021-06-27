/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.administrator;

import contract.administrator.CashCourtContract1;
import exception.ExceptionPvLite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Court;
import model.Spents;
import model.connection.PVLConnection;

/**
 *
 * @author Dell
 */
public class CashCourtModel1 extends PVLConnection implements CashCourtContract1.Model {

    private final CashCourtContract1.Presenter presenter;

    public CashCourtModel1(CashCourtContract1.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    @Override
    public float onLoadMoneyGeneratedToday(String dateToday) {
        float total = 0;
        try {
            String sql = "SELECT SUM(total) as total FROM ticket where fecha = '" + dateToday + "'";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                total = rs.getFloat("total");
            }

        } catch (Exception ex) {
            presenter.onError(new ExceptionPvLite("Error en consultar los tickets", ex.toString()));
        }
        return total;
    }

    @Override
    public void onloadTickets(String dateToday) {
        try {
            String sql = "SELECT * FROM ticket where fecha = '" + dateToday + "' ORDER by idTicket DESC";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Court> court = new ArrayList<Court>();
            //int idTicket, String date, float amount, String seller, String table, int status, String hour, float effective
            while (rs.next()) {
                court.add(new Court(
                        rs.getInt("idTicket"),
                        rs.getString("fecha"),
                        rs.getFloat("total"),
                        rs.getString("hora")));
            }
            this.presenter.onLoadedTicketsToday(court);
        } catch (Exception ex) {
            presenter.onError(new ExceptionPvLite("Error en consultar los tickets", ex.toString()));
        }
    }

    @Override
    public float onLoadExpenseMoneyToday(String dateToday) {
        float spent = 0;
        try {
            String sql = "SELECT SUM(gastado) as spent FROM gastos where fecha_gasto = '" + dateToday + "'";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                spent = rs.getFloat("spent");
            }

        } catch (Exception ex) {
            presenter.onError(new ExceptionPvLite("Error en consultar los gastos", ex.toString()));
        }
        return spent;
    }

    @Override
    public Map<String, String> onLoadInitialBalanceToday(String dateToday) {
        Map<String, String> initialMap = new HashMap<String, String>();
        try {
            String sql = "SELECT saldoInicial as initialBalance, comentarios FROM cortecaja WHERE fecha = '" + dateToday + "'";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                initialMap.put("initialBalance", rs.getFloat("initialBalance") + "");
                initialMap.put("comment", rs.getString("comentarios"));
            } else {
                initialMap.put("initialBalance", "0.00");
                initialMap.put("comment", "");
            }
        } catch (Exception ex) {
            presenter.onError(new ExceptionPvLite("Error en consultar saldo inicial", ex.toString()));
        }
        return initialMap;
    }

    @Override
    public void onLoadSpentToday(String dateToday) {
        try {
            String sql = "SELECT * FROM gastos where fecha_gasto = '" + dateToday + "' ORDER by idgasto DESC";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Spents> spent = new ArrayList<Spents>();
            //int idTicket, String date, float amount, String seller, String table, int status, String hour, float effective
            while (rs.next()) {
                spent.add(new Spents(
                        rs.getString("descripcion"),
                        rs.getString("cantidad"),
                        rs.getFloat("gastado"),
                        rs.getString("fecha_gasto")));
            }
            this.presenter.onLoadedSpentToday(spent);
        } catch (Exception ex) {
            presenter.onError(new ExceptionPvLite("Error en consultar los gastos tabla", ex.toString()));
        }
    }

}
