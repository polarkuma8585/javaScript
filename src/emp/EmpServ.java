package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpServ") // 이 페이지의 주소.
public class EmpServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpServ() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		out.println("{\"result\":[");
		int cnt = 0;
		for (Employee emp : list) {
//			System.out.println(emp.getEmployeeId()+", "+emp.getLastName());
//			out.println("{\"firstName\":\"" + emp.getEmployeeId() + "\",\"lastName\":\"" + emp.getLastName()
//					+ "\",\"email\":\"" + emp.getEmail() + "\"}");
			out.println("{\"firstName\":\"" + emp.getFirstName() + "\",\"lastName\":\"" + emp.getLastName()
			+ "\",\"email\":\"" + emp.getEmail() + "\"}");
			cnt++;
			if (list.size() != cnt)
			out.println(",");
		}
//		out.println("{\"firstName\":\""+emp.getEmployeeId()+"\",\"lastName\":"+emp.getLastName()+",\"email\":"+ emp.getEmail()+"\"}");
		out.println("]}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
