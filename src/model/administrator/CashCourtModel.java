/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.administrator;

import contract.administrator.CashCourtContract;
import exception.ExceptionPvLite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Tickets;
import model.connection.PVLConnection;
import presenter.administrator.CashCourtPresenter;

/**
 *
 * @author Dell
 */
public class CashCourtModel extends PVLConnection implements CashCourtContract.Model{
    private final CashCourtContract.Presenter presenter;

    public CashCourtModel(CashCourtContract.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    @Override
    public void onLoadTickets(String dateStart, String dateEnd) {
        
        try {
            String sql = "SELECT * FROM ticket where (fecha BETWEEN '" + dateStart + "' and '" + dateEnd + "' ) ORDER by idTicket DESC";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Tickets> tickets = new ArrayList<Tickets>();
            //int idTicket, String date, float amount, String seller, String table, int status, String hour, float effective
            while (rs.next()) {
                tickets.add(new Tickets(
                        rs.getInt("idTicket"),
                        rs.getString("fecha"),                    
                        rs.getFloat("total"),
                        rs.getString("vendedor"),
                        rs.getString("mesa"),
                        Integer.parseInt(rs.getString("STATUS")),
                        rs.getString("hora"),
                        rs.getFloat("efectivo")));
            }
            this.presenter.onLoadedTickets(tickets);
        } catch (SQLException ex) {
            presenter.onError(new ExceptionPvLite("Error en consultar los tickets", ex.toString()));
        }
    }
    
}
