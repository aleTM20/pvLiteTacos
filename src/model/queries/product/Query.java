/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.queries.product;

import exception.ExceptionPvLite;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Query {

    private final static Connection connection = new DBConnection().openConnection();

    public static List<Product> listProducts(String textToSearch) throws ExceptionPvLite {
        try {
            String sql = "selects idProducto as id,descripcion,tipoproducto,precio,nombre from producto where status=1 and (descripcion LIKE '%" + textToSearch + "%' OR nombre like '%" + textToSearch + "%');";

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
            return products;
        } catch (SQLException ex) {
            throw new ExceptionPvLite("Error al consultar los productos", ex.getMessage());
        }
    }
}
