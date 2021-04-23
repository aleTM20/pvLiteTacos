/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.waiter;

import java.sql.PreparedStatement;
import contract.waiter.HomeContract;
import exception.ExceptionPvLite;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.connection.DBConnection;
import model.queries.product.Query;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author pv_lite_team
 */
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;

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
