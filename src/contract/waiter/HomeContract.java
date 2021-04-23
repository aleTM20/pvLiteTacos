/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.waiter;

import exception.ExceptionPvLite;
import java.util.List;
import model.Product;

/**
 *
 * @author pv_lite_team
 */
public interface HomeContract {

    public interface View {
        void onError(ExceptionPvLite exceptionPvLite);
        void onDestroy();
        void onLoadProducts(List<Product> products);
    }

    public interface Presenter {
        void onError(ExceptionPvLite exceptionPvLite);
        void onLoadProducts(String textToSearch);
    }
}
