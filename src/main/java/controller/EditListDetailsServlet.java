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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new ListDetailsHelper();
		ListTaskHelper lih = new ListTaskHelper();
		OwnerHelper ow = new OwnerHelper();
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);

		String newListName = request.getParameter("listName");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String ownerName = request.getParameter("ownerName");
		//find our add the new shopper
		Owner newOwner = ow.findOwner(ownerName);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		try {
			//tasks are selected in list to add
			String[] selectedTasks = request.getParameterValues("allTasksToAdd");
			List<ListTask> selectedTasksInList = new ArrayList<ListTask>();

			for (int i = 0; i < selectedTasks.length; i++) {
				System.out.println(selectedTasks[i]);
				ListTask c = lih.searchForTaskById(Integer.parseInt(selectedTasks[i]));
				selectedTasksInList.add(c);

			}
			listToUpdate.setListOfTasks(selectedTasksInList);
		} catch (NullPointerException ex) {
			// no tasks selected in list - set to an empty list
			List<ListTask> selectedTasksInList = new ArrayList<ListTask>();
			listToUpdate.setListOfTasks(selectedTasksInList);
		}

		listToUpdate.setListName(newListName);
		listToUpdate.setTaskDate(ld);
		listToUpdate.setOwner(newOwner);

		dao.updateList(listToUpdate);

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}