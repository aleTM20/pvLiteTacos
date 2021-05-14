/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.administrator;

import exception.ExceptionPvLite;
import java.util.List;
import java.util.Map;
import model.Court;
import model.Spents;

/**
 *
 * @author Dell
 */
public interface CashCourtContract1 {

    public interface View {

        public void onShowTicketsToday(List<Court> court);

        public void onShowResumeMoney(String moneyGenerated, String expenseMoney, String initialBalance, String total, String comment);

        public void cleanTable();
        
        public void cleanTableSpend();

        public void onError(ExceptionPvLite exceptionPvLite);

        public void onShowSpentMoney(List<Spents> spent);

    }

    public interface Presenter {

        public void onError(ExceptionPvLite exceptionPvLite);

        public void onLoadTicketsToday(String dateToday);

        public void onLoadedTicketsToday(List<Court> court);

        public void onLoadMoneyGenerated(String dateToday);

        public void onLoadSpentMoney(String dateToday);

        public String getDateToday();

        public void onLoadedSpentToday(List<Spents> spent);
    }

    public interface Model {

        public void onloadTickets(String dateToday);

        public float onLoadMoneyGeneratedToday(String dateToday);

        public float onLoadExpenseMoneyToday(String dateToday);

        public Map<String, String> onLoadInitialBalanceToday(String dateToday);

        public void onLoadSpentToday(String dateToday);

    }
}
