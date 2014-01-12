package test.guilingwang.github;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class helloworld
 */
public class helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    Map map =new HashMap();
	
	public void init() throws ServletException {
		  // TODO Auto-generated method stub
		  super.init();
				
		  Employee emp0 =new Employee("David","Finance");
		  Employee emp1 =new Employee("Smith","HealthCare");
		  Employee emp2 =new Employee("Adam","Information technology");
		  Employee emp3 =new Employee("Stephan","Life Sciences");
				
		  map.put("00345",emp0);
		  map.put("00346",emp1);
		  map.put("00347",emp2);
		  map.put("00348",emp3);
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helloworld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 arg1.setContentType("text/xml");
		  PrintWriter out=arg1.getWriter();
		  System.out.println(map);
		  if(arg0.getPathInfo()!= null){
		  String EmpId=arg0.getPathInfo().substring(1,arg0.getPathInfo().length());
		  System.out.println(EmpId);
				
		  out.write("<?xml version='1.0' encoding='UTF-8'?>"+"\n");
		   out.write("<p:EmpDetail xmlns:p='http://www.employee-details.com'>"+"\n");
		   out.write("<Emp-ID>"+EmpId+" </Emp-ID>"+"\n");
		   out.write("<Name>"+((Employee)map.get(EmpId)).name+" </Name>"+"\n");
		   out.write("<Department>"+((Employee)map.get(EmpId)).dept+" </Department>"+"\n");
		   out.write("</p:EmpDetail>"+"\n");
		   out.flush();
		  }else{
		   out.write("<?xml version='1.0' encoding='UTF-8'?>"+"\n");
		   out.write("<p:Employees xmlns:p='http://www.employee-details.com'>"+"\n");
		   out.write("<Employee id='00345' href='http://localhost:8400/helloworld/helloworld/employees/00345'/>"+"\n");
		   out.write("<Employee id='00346' href='http://localhost:8400/helloworld/helloworld/employees/00346'/>"+"\n");
		   out.write("<Employee id='00347' href='http://localhost:8400/helloworld/helloworld/employees/00347'/>"+"\n");
		   out.write("<Employee id='00348' href='http://localhost:8400/helloworld/helloworld/employees/00348'/>"+"\n");
		   out.write("</p:Employees>");
		   out.flush();
		  }
	}

}
