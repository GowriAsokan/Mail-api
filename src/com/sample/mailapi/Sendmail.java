package com.sample.mailapi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

  public class Sendmail extends HttpServlet {  
		
	public void doPost(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException {  
	response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
      
    String to=request.getParameter("email1");  
    String subject=request.getParameter("subject");  
    String msg=request.getParameter("message");  
    
    System.out.println(to + "" + subject + " " + msg);
          
    Mail.send(to, subject, msg);  
    out.print("message has been sent successfully");  
    RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
    rd.include(request, response);  
 
    out.close();  
    }  
  
}  