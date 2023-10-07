package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListTask;



/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addTaskServlet")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddTaskServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//store user input
		String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
	
        
		ListTask lt = new ListTask(title, description, status);
		ListTaskHelper dao = new ListTaskHelper();
		dao.insertTask(lt);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}