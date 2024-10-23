package jdbc2.controller;

import jdbc.JDBCConnector;
import jdbc2.entity.Customer;
import jdbc2.view.CustomerView;

import java.sql.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // 연결객체 반환
        Connection con = JDBCConnector.getConnection();
        // 문장객체 반환
        String sql = "select * from 고객";
        PreparedStatement pstmt = null;
        ArrayList<Customer> customersList = new ArrayList<Customer>();
        Customer customer = null;
        try {
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                customer = new Customer();
                customer.setCustomerName(rs.getString("고객이름"));
                customer.setAge(rs.getInt("나이"));
                customer.setLevel(rs.getString("등급"));
                customer.setJob(rs.getString("직업"));
                customer.setReward(rs.getInt("적립금"));
                customersList.add(customer);
            }
            // 반복이 완료되면 모든 고객의 정보가 ArrayList에 저장
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        // View로 출력
        CustomerView view = new CustomerView();
        view.printHead();
        for (Customer custom : customersList) {
            view.printCustomer(custom);
        }
        view.printFooter();
    }
}
