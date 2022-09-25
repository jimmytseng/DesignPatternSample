package StructuralPattern.ProxyPattern;

public class ProxyPattern {

	public static void main(String[] args) {
		Employee employee = new LoggingProxyEmployee();
		employee.meeting();
	}

}

interface Employee {
	public void meeting();
}

class EmployeeImp implements Employee {

	@Override
	public void meeting() {
		System.out.print("employee start working");
	}
}

class LoggingProxyEmployee implements Employee{
	
	private Employee employee;
	
	@Override
	public void meeting() {
		if(employee==null)
			employee = new EmployeeImp();
		System.out.println("calling employee to meet");
		this.employee.meeting();
		
	}
}