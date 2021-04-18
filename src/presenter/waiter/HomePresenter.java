/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.waiter;

import java.sql.PreparedStatement;
import contract.waiter.HomeContract;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.connection.DBConnection;

/**
 *
 * @author pv_lite_team
 */
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private Connection connection;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        connection = new DBConnection().openConnection();
    }

    @Override
    public void onError(String error) {
        view.onError(error);
    }

    @Override
    public void onLoadProducts(String textToSearch) {
        try {
            String sql = "select idProducto as id,descripcion,tipoproducto,precio,nombre from producto where status=1 and (descripcion LIKE '%" + textToSearch + "%' OR nombre like '%" + textToSearch + "%');";

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            List<Product> products = new ArrayList<Product>();
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("tipoproducto"),
                        rs.getFloat("precio")));
            }
            view.onLoadProducts(products);
        } catch (SQLException ex) {
            view.onError(ex.toString());
        }   
    }

}
