/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.administrator;

import contract.administrator.CashCourtContract;
import model.administrator.CashCourtModel;
import exception.ExceptionPvLite;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Tickets;


/**
 *
 * @author Dell
 */
public class CashCourtPresenter implements CashCourtContract.Presenter{
    private final CashCourtContract.View view;
    private final CashCourtModel model;

    public CashCourtPresenter(CashCourtContract.View view) {
        this.view = view;
        this.model = new CashCourtModel(this);
    }

    @Override
    public void onError(ExceptionPvLite exceptionPvLite) {
        this.view.onError(exceptionPvLite);
    }

    @Override
    public void onLoadTickets(String dateStart, String dateEnd) {
        this.model.onLoadTickets(dateStart, dateEnd);
    }

    @Override
    public void onLoadedTickets(List<Tickets> tickets) {
       this.view.cleanTable();
       this.view.onShowTickets(tickets);
    }

    @Override
    public String getDateToday() {
        return new SimpleDateFormat("YYYY-MM-dd").format(new Date());
    }

    
    
}
