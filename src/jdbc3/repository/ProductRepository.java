package jdbc3.repository;

import jdbc.JDBCConnector;
import jdbc3.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {
    static public ArrayList<Product> getList(String type, String searchWord){
        ArrayList<Product> arrList = new ArrayList<>();
        Connection con = JDBCConnector.getConnection(); // 연결객체
        String sql = "select * from 제품 where "+ type +" like ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql); // 문장객체
            pstmt.setString(1, "%"+searchWord+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductNum(rs.getString("제품번호"));
                product.setProductName(rs.getString("제품명"));
                product.setProStock(rs.getInt("재고량"));
                product.setProPrice(rs.getInt("단가"));
                product.setPrduceName(rs.getString("제조업체"));
                arrList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return arrList;
    }
}
