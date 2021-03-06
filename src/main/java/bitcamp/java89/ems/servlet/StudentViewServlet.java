package bitcamp.java89.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems.dao.impl.StudentMysqlDao;
import bitcamp.java89.ems.vo.Student;

@WebServlet("/student/view")
public class StudentViewServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    String userId = request.getParameter("userId");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>학생관리-상세정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>학생 정보</h1>");
    out.println("<form action='update' method='POST'>");
    
    try {
      StudentMysqlDao studentDao = StudentMysqlDao.getInstance();
      Student student = studentDao.getOne(userId);
      
      if (student == null) {
        throw new Exception("해당 아이디의 학생이 없습니다.");
      }
      
      out.println("<table border='1'>");
      out.printf("<tr><th>아이디</th><td>"
          + "<input name='userId' type='text' value='%s' readonly></td></tr>\n",
          student.getUserId());
      out.printf("<tr><th>암호</th><td>"
          + "<input name='password' type='password'></td></tr>\n");
      out.printf("<tr><th>이름</th><td>"
          + "<input name='name' type='text' value='%s'></td></tr>\n", 
          student.getName());
      out.printf("<tr><th>이메일</th><td>"
          + "<input name='email' type='text' value='%s'></td></tr>\n", 
          student.getEmail());
      out.printf("<tr><th>전화</th><td>"
          + "<input name='tel' type='text' value='%s'></td></tr>\n", 
          student.getTel());
      out.printf("<tr><th>재직여부</th><td>"
          + "<input type='radio' name='working' value='true' %s>재직중"
          + " <input type='radio' name='working' value='false' %s>실업/미취업</td></tr>\n",
          (student.isWorking() ? "checked" : ""),
          (student.isWorking() ? "" : "checked"));
      out.printf("<tr><th>태어난해</th><td>"
          + "<input name='birthYear' type='number' value='%d'></td></tr>\n", 
          student.getBirthYear());
      out.printf("<tr><th>최종학교</th><td>"
          + "<input name='school' type='text' value='%s'></td></tr>\n", 
          student.getSchool());
      out.println("</table>");
      
      out.println("<button type='submit'>변경</button>");
      out.printf(" <a href='delete?userId=%s'>삭제</a>", student.getUserId());
      
    } catch (Exception e) {
      out.printf("<p>%s</p>\n", e.getMessage());
    }
    
    out.println(" <a href='list'>목록</a>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
    
  }
}



