package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.PersonDao;
import dto.Person;

public class InsertPerson extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String email=req.getParameter("email");
		String dob=req.getParameter("date");
		
		Person person=new Person();
		person.setPersonName(name);
		person.setPersonEmail(email);
		person.setPersonAge(age);
		person.setPersonDOB(dob);
		
		PersonDao personDao=new PersonDao();
		personDao.savePerson(person);
		
		PrintWriter printWriter=res.getWriter();
		printWriter.print("sucessfully inserted into DataBase");
	}


			

}
