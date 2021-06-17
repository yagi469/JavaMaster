package la.servlet;

import java.io.IOException;
import java.util.list;

import javax.servlet.RequestDispatcher;




import javax.servlet.http.HttpServletResponse;

import la.bean.CategoryBean;


import la.dao.ItemDAO;

@WebServlet("/ShowItemServlet")
public class ShowItemServlet extends HttpServlet {
  
  protected void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
    try {
      // パラメータの解析
      String action = request.getParameter("action");
      // topまたはパラメータなしの場合はトップページを表示
      if (action == null || action.length() == 0 || action.equals("top")) {
        gotoPage(request, response, "/top.jsp");
      } else if (action.equals("list")) {
        int categoryCode = Integer.parseInt(request.getParameter("code"));
        ItemDAO dao = new ItemDAO();
        List<ItemBean> list = dao.findByCategory(categoryCode);
        // Listをリクエストスコープに入れてJSPへフォワードする
        request.setAttribute("items", list);
        gotoPage(request, response, "/list.jsp");
      } else {
        request.setAttribute("message", "正しく操作してください。");
        gotoPage(request, response, "/errInternal.jsp");
      }
    } catch (DAOException e) {
      e.printStackTrace();
      request.setAttribute("message", "内部エラーが発生しました。");
      gotoPage(request, response, "/errInternal.jsp");
    }
  }
  
  private void gotoPage(HttpServletRequest request,
                       HttpServletResponse response, String page) throws ServletException,
                       IOException {
    Request Dispatcher rd = request.getRequestDispatcher(page);
    rd.forward(request, response);
  }
  
  public void init() throws ServletException {
    try {
      // カテゴリ一覧は最初にアプリケーションスコープへ入れる
      ItemDAO dao = new ItemDAO();
      List<CategoryBean> list = dao.findAllCategory();
      getServletContext().setAttribute("categories", list);
    } catch (DAOException e) {
      e.printStackTrace();
      throw new ServletException();
    }
  }
  
  protected coid doPost(HttpServletRequest request.
                       HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
                         
