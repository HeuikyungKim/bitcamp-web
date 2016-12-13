package bitcamp.java89.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems.dao.impl.ContactMysqlDao;
import bitcamp.java89.ems.vo.Contact;

@WebServlet("/contact/view")
public class ContactViewServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    String email = request.getParameter("email");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>연락처관리-상세정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>연락처 정보</h1>");
    out.println("<form action='update' method='POST'>");
    
    try {
      ContactMysqlDao contactDao = ContactMysqlDao.getInstance();
      Contact contact = contactDao.getDetail(email);

      if (contact == null) {
        throw new Exception("해당 이메일의 연락처가 없습니다.");
      }
      
      out.println("<table border='1'>");
      
      out.printf("<tr><th>이름</th><td>"
          + "<input name='name' type='text' value='%s'></td></tr>\n", contact.getName());
      
      out.printf("<tr><th>직위</th><td>"
          + "<input name='position' type='text' value='%s'></td></tr>\n", contact.getPosition());
      
      out.printf("<tr><th>전화</th><td>"
          + "<input name='tel' type='text' value='%s'></td></tr>\n", contact.getTel());
      
      out.printf("<tr><th>이메일</th><td>"
          + "<input name='email' type='text' value='%s' readonly></td></tr>\n", 
          contact.getEmail());
      
      out.println("</table>");
      out.println("<button type='submit'>변경</button>");
      out.printf(" <a href='delete?email=%s'>삭제</a>", contact.getEmail());
      
    } catch (Exception e) {
      out.printf("<p>%s</p>\n", e.getMessage());
    }
    
    out.println(" <a href='list'>목록</a>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
    
  }
}




