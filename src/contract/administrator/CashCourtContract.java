/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.administrator;

import exception.ExceptionPvLite;
import java.util.List;
import model.Tickets;

/**
 *
 * @author Dell
 */
public interface CashCourtContract {

    public interface View {

        public void onShowTickets(List<Tickets> tickets);

        public void cleanTable();

        public void onError(ExceptionPvLite exceptionPvLite);
        
    }

    public interface Presenter {

        public void onError(ExceptionPvLite exceptionPvLite);
        
        public void onLoadTickets(String dateStart,String dateEnd);
        
        public void onLoadedTickets(List<Tickets> tickets);
        
        public String getDateToday();
    }

    public interface Model {

        public void onLoadTickets(String dateStart,String dateEnd);
    }
}
