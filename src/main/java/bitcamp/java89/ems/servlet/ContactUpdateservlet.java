package bitcamp.java89.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems.dao.impl.ContactMysqlDao;
import bitcamp.java89.ems.vo.Contact;

// 톰캣 서버가 실행할 수 있는 클래스는 반드시 Servlet 규격에 맞추어 제작해야 한다.
// 그러나 Servlet 인터페이스의 메서드가 많아서 구현하기 번거롭다.
// 그래서 AbstractServlet이라는 추상 클래스를 만들어서, 
// 이 클래스를 상속받아 간접적으로 Servlet 인터페이스를 구현하는 방식을 취한다.
// 이 클래스를 상속받게되면 오직 service() 메서드만 만들면 되기 때문에 코드가 편리하다.
@WebServlet("/contact/update")
public class ContactUpdateservlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    try {
      ContactMysqlDao contactDao = ContactMysqlDao.getInstance();
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      if (!contactDao.existEmail(request.getParameter("email"))) {
        out.println("이메일을 찾지 못했습니다.");
        return;
      }
      
      Contact contact = new Contact();
      contact.setName(request.getParameter("name"));
      contact.setPosition(request.getParameter("position"));
      contact.setTel(request.getParameter("tel"));
      contact.setEmail(request.getParameter("email"));
      
      contactDao.update(contact);
      out.println("변경 하였습니다.");

      
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
