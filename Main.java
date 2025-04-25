package taskManagement;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Task> taskList = new ArrayList<>();
		boolean loopStatus = true;
		System.out.println("TASK MANAGEMENT");
		int id = 1;
		String status = "PENDING...";
		while(loopStatus) {
			System.out.println("---------------------");
			System.out.println("1.ADD TASK\n2.UPDATE TASK\n3.DELETE TASK\n4.VIEW ALL TASK");
			System.out.println("---------------------");
			int choice = sc.nextInt();
			sc.nextLine();
			System.out.println("---------------------");
			switch(choice) {
				case 1:
					System.out.print("TASK : ");
					String taskName = sc.nextLine();
					System.out.print("DESCRIPTION : ");
					String description = sc.nextLine();
					System.out.print("DUEDATE : ");
					String dueDate = sc.nextLine();
					taskList.add(new Task(id++, taskName, description, dueDate, status));
					break;
				case 2:
					if(taskList.size() == 0 ) {
						System.out.println("no task currently available");
					} else {
						System.out.print("Enter task ID to UPDATE : ");
						int taskID = sc.nextInt();
						sc.nextLine();
						System.out.println("Select field to UPDATE\n1.NAME\n2.DESCRIPTION\n3.DUE DATE\n4.STATUS");
						int opt = sc.nextInt();
						sc.nextLine();
						Task t = new Task();
						if(taskID < id && taskID > 0 && opt > 0 && opt < 5) {
							t.updateTask(taskList, taskID, opt);
						} else {
							System.out.print("Invalid option...Exiting...");
						}
					}
					break;
				case 3:
					if(taskList.size() == 0 ) {
						System.out.println("no task currently available");
					} else {
						System.out.print("Enter task ID to delete : ");
						int taskID1 = sc.nextInt();
						sc.nextLine();
						Task tM = new Task();
						boolean operation = tM.deleteTask(taskList, taskID1);
						if(operation) {
							System.out.println("DELETED SUCCESSFULLY");
						} else {
							System.out.println("Entered Task Id doesn't exist");
						}
					}
					break;
				case 4:
					Task t1 = new Task();
					t1.viewAllTask(taskList);
					break;
				default:
					System.out.print("Invalid option");
					break;
			}
		}
	}
}
