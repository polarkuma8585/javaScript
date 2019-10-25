package emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertEmpServ")
public class InsertEmpServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertEmpServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//한글 깨질때 사용하는 함수.
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		EmpDAO dao = new EmpDAO();
		// 사용자가 입력한 항목의 값들.
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String hireDate = request.getParameter("hireDate");
		String email = request.getParameter("email");
		String jobId = request.getParameter("jobId");
		String salary = request.getParameter("salary");
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setHireDate(hireDate);
		emp.setEmail(email);
		emp.setJobId(jobId);
		emp.setSalary(Integer.parseInt(salary)); // String type 으로 넘어온 salary를 int type 으로 변경.
		
		dao.insertEmp(emp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
