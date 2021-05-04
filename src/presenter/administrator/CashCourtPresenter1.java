/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.administrator;

import contract.administrator.CashCourtContract;
import contract.administrator.CashCourtContract1;
import model.administrator.CashCourtModel1;
import exception.ExceptionPvLite;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Court;
import model.Spents;
import model.Tickets;

/**
 *
 * @author Dell
 */
public class CashCourtPresenter1 implements CashCourtContract1.Presenter {

    private final CashCourtContract1.View view;
    private final CashCourtModel1 model;
    private final DecimalFormat decimalFormat;

    public CashCourtPresenter1(CashCourtContract1.View view) {
        this.view = view;
        this.model = new CashCourtModel1(this);
        this.decimalFormat = new DecimalFormat("#.00");
    }

    @Override
    public void onError(ExceptionPvLite exceptionPvLite) {
        this.view.onError(exceptionPvLite);
    }

    @Override
    public String getDateToday() {
        return new SimpleDateFormat("YYYY-MM-dd").format(new Date());
    }

    @Override
    public void onLoadTicketsToday(String dateToday) {
        this.model.onloadTickets(dateToday);
    }

    @Override
    public void onLoadedTicketsToday(List<Court> court) {
        this.view.cleanTable();
        this.view.onShowTicketsToday(court);
    }

    @Override
    public void onLoadMoneyGenerated(String dateToday) {
        float moneyGenerated = this.model.onLoadMoneyGeneratedToday(dateToday);
        float expenseMoney = this.model.onLoadExpenseMoneyToday(dateToday);
        float initialBalance = this.model.onLoadInitialBalanceToday(dateToday);
        float total = (moneyGenerated + initialBalance) - expenseMoney;
        this.view.onShowResumeMoney(moneyGenerated > 0 ? "$" + decimalFormat.format(moneyGenerated) : "$0.00", 
                expenseMoney > 0 ? "$" + decimalFormat.format(expenseMoney) : "$0.00",
                initialBalance > 0 ? "$" + decimalFormat.format(initialBalance) : "$0.00",
                total > 0 ? "$" + decimalFormat.format(total) : "$0.00");
    }

    @Override
    public void onLoadSpentMoney(String dateToday) {
        this.model.onLoadSpentToday(dateToday);
    }

    @Override
    public void onLoadedSpentToday(List<Spents> spent) {
        this.view.cleanTableSpend();
        this.view.onShowSpentMoney(spent);
    }

    

}
