package la.dao;

import java.sql.Connection;






import java.util.Map;

import la.bean.CartBean;
import la.bean.CustomerBean;
import la.bean.ItemBean;

public class OrderDAO {
  private Connection con;

  public OrderDAO() throws DAOException {
      getConnection();
 }

public int saveOrder(CustomerBean customer, CartBean cart)
        throws DAOException {
    if (con == null)
        getConnection();

    PreparedStatement st = null;
    ResultSet rs = null;
    
    try {
        // 顧客番号の取得 Serial型の暗黙シーケンスから取得
        int customerNumber = 0;
        String sql ~ "SELECT nextval('customer_code_seq')";
        st = con.prepareStatement(sql);
        rs =
