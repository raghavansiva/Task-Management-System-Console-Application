package taskManagement;

import java.util.*;

public class Task {
	private int id;
	private String taskName;
	private String description;
	private String dueDate;
	private String status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Task(int id, String taskName, String description, String dueDate, String status) {
		this.id = id;
		this.taskName = taskName;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
	}
	
	public Task() {
		super();
	}

	public void viewAllTask(List<Task> taskList) {
		if(taskList.size() == 0 ) {
			System.out.println("no task currently available");
		}
		for(Task t : taskList) {
			System.out.println("ID : "+t.id+"\nTASK : "+t.taskName+"\nDESCRIPTION : "+t.description+"\nDUE DATE : "+t.dueDate+"\nSTATUS : "+t.status);
		}
	}
	
	public boolean deleteTask(List<Task> taskList, int id) {
		for(Task t : taskList) {
			if(t.getId() == id) {
				taskList.remove(t);
				return true;
			}
		}
		return false;
	}
	public void updateTask(List<Task> taskList, int id, int field) {
		Scanner sc = new Scanner(System.in);
		for(Task t : taskList) {
			if(t.getId() == id) {
				if(field == 1) {
					String old = t.getTaskName();
					System.out.print("Name : ");
					String name = sc.nextLine();
					t.setTaskName(name);
					System.out.println("Successfully updated name\nForm : "+old+"\nTo : "+t.getTaskName());
				} else if (field == 2) {
					String old = t.getDescription();
					System.out.print("Description : ");
					String des = sc.nextLine();
					t.setDescription(des);
					System.out.println("Successfully updated name\nForm : "+old+"\nTo : "+t.getDescription());
				} else if (field == 3) {
					String old = t.getDueDate();
					System.out.print("DueDate : ");
					String dueDate = sc.nextLine();
					t.setDueDate(dueDate);
					System.out.println("Successfully updated name\nForm : "+old+"\nTo : "+t.getDueDate());
				} else {
					String old = t.getStatus();
					System.out.println("1.Pending\n2.Partially Completed\n3.Completed");
					int opt = sc.nextInt(); 
					sc.nextLine(); 
					String status;
					if(opt == 1) {
						t.setStatus("Pending...");
					} else if (opt == 2) {
						t.setStatus("Partially Completed...");
					} else {
						t.setStatus("Completed !!!");
					}
					System.out.println("Successfully updated name\nForm : "+old+"\nTo : "+t.getStatus());
				}
			}
		}
	}
}
