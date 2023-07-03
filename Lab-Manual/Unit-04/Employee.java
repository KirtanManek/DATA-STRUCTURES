import java.util.Scanner;

class Employee_Detail{
	int Employee_id;
	String Name;
	String Designation;
	double Salary;

	//read Details
	public void readData(){
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter Employee id:");
		Employee_id=sc.nextInt();

		System.out.println("Enter Name of Employee:");
		Name=sc.next();

		System.out.println("Enter Designation:");
		Designation=sc.next();

		System.out.println("Enter Salary:");
		Salary=sc.nextDouble();
	}

	//print Details
	public void printDetails(){
		System.out.println("Employee id: "+Employee_id);
		System.out.println("Name of Employee: "+Name);
		System.out.println("Designation of Employee: "+Designation);
		System.out.println("Salary: "+Salary);
	}
}

public class Employee{
	public static void main(String[] args){
		Employee_Detail ed=new Employee_Detail();

		ed.readData();
		ed.printDetails();
	}
}