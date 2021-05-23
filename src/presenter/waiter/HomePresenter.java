/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.waiter;

import contract.waiter.HomeContract;
import exception.ExceptionPvLite;
import model.queries.product.Query;

/**
 *
 * @author pv_lite_team
 */
public class HomePresenter implements HomeContract.Presenter {

    private final HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void onError(ExceptionPvLite exceptionPvLite){
        view.onError(exceptionPvLite);
    }

    @Override
    public void onLoadProducts(String textToSearch) {
        try {
            view.onLoadProducts(Query.listProducts(textToSearch));
        } catch (ExceptionPvLite exceptionPvLite) {
            this.onError(exceptionPvLite);
        }
    }
}
