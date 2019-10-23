package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
//		out.println(JSONArray.fromObject(list));
		JSONArray ary = new JSONArray();
		for (Employee emp : list) { // 필요한 값만 가져와 배열에 담고 다시 그 값을 다른 객체에 담는다. 
			JSONObject obj = new JSONObject();
			obj.put("firstName", emp.getFirstName());
			obj.put("lastName", emp.getLastName());
			obj.put("salary", emp.getSalary());
			ary.add(obj);
		}
		JSONObject outer = new JSONObject();
		outer.put("data", ary);
		out.println(outer);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
