package org.edwinepr.purchaseapp.repositories;

import lombok.Data;
import org.edwinepr.purchaseapp.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";

        jdbc.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    public List<Purchase> getAllPurchases() {
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (rs, rowNum) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(rs.getInt("id"));
            rowObject.setProduct(rs.getString("product"));
            rowObject.setPrice(rs.getBigDecimal("price"));
            return rowObject;
        };

        return jdbc.query(sql, purchaseRowMapper);
    }
}
