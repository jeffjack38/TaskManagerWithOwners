package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.ListTask;
import model.Owner;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListTaskHelper lih = new ListTaskHelper();
		String listName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		String ownerName = request.getParameter("ownerName");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		String[] selectedTasks = request.getParameterValues("allTasksToAdd");
		List<ListTask> selectedTasksInList = new ArrayList<ListTask>();
		
		if(selectedTasks != null && selectedTasks.length > 0){
			for(int i = 0; i<selectedTasks.length; i++) {
				ListTask c = lih.searchForTaskById(Integer.parseInt(selectedTasks[i]));
				selectedTasksInList.add(c);
			}
		}
		
		Owner owner = new Owner(ownerName);
		
		ListDetails sld = new ListDetails(listName, ld, owner);
		
		sld.setListOfTasks(selectedTasksInList);
		
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}