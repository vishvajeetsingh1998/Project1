package com.whatsappweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.whatsappweb.dao.WhatsappDAOInterface;
import com.whatsappweb.entity.WhatsappUser;
import com.whatsappweb.utility.ControllerFactory;

public class EditProfileServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		Object oo=ss.getAttribute("em");
		
		WhatsappUser ws=new WhatsappUser();
		ws.setEmail(oo.toString());
				
		WhatsappDAOInterface ws1 = ControllerFactory.createObjectHibernate();
		
		WhatsappUser b=ws1.viewProfile(ws);
		WhatsappUser ww = new WhatsappUser();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><center><br><br>");
			if(b!=null) {
				/*out.println("<p>Edit Profile Page</p><br>");
				out.println("<form method=post action=EditProfileServlet>");
				out.println("<br>Name     : <input type=text name=fname2  ><br>");
				out.println("<br>Email    :<input type=email name=email2 value="+b.getEmail()+" disabled><br>");
				 out.println("<br>Age      :<input type=text name=age2><br>"); 
				out.println("<br>Address  :<input type=text name=address2 ><br>");
				out.println("<br>Password :<input type=text name=password2><br>");
				out.println("<br><input type=submit value=Edit>");
				out.println("</form>");*/
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/New.html?email=" + oo.toString() + "");
				rd.include(request, response);
			}
			else
			{
				out.println("<font size=5 color=red><b>Profile Not Found</font>");
			}
			
			
		out.println("</center></body></html>");
		if(b!=null) {
		String name1 = request.getParameter("fname");
		String email1 = request.getParameter("email");
		//int age1= Integer.parseInt(request.getParameter("age2"));
		String address1 = request.getParameter("address");
		String password1 =request.getParameter("password");
		ww.setName(name1);
		ww.setPassword(password1);
		//ww.setAge(age1);
		ww.setEmail(oo.toString());
		ww.setAddress(address1);
		int i =ws1.editProfile(ww);
		response.setContentType("text/html");
		
		out.println("<html><body><center><br><br>");

		if(i>0)
		{
			out.println("<font size=5 color=green><b>Profile Edited Succesfully</font>");
			}
		else {
			out.println("your password or email is wrong..");
			
		}
		
		}
		out.println("</center></body></html>");
		
	}

}
