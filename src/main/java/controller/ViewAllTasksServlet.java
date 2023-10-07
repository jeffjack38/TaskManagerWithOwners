package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListTask;

/**
 * Servlet implementation class ViewAllItemsServlet
 */
@WebServlet("/viewAllTasksServlet")
public class ViewAllTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllTasksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListTaskHelper dao = new ListTaskHelper();
		request.setAttribute("allTasks", dao.showAllTasks());
		
		  for(ListTask lt : dao.showAllTasks()) {
		  System.out.println(lt.returnTaskDetails()); 
		 }
		
		String path = "/task-list.jsp";
		
		if(dao.showAllTasks().isEmpty()) {
			path = "/index.html";
		}
	
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}