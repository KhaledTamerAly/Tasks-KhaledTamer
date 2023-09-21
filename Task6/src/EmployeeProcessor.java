import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeProcessor
{

    public List<Employee> getEmployeesInDepartment(List<Employee> employeeList, String department)
    {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    public List<String> getEmployeeNames(List<Employee> employeeList)
    {
        return employeeList.stream()
                .map(employee -> employee.getName())
                .collect(Collectors.toList());
    }

    public double getSalarySum(List<Employee> employeeList)
    {
        return employeeList.stream()
                .mapToDouble(employee -> employee.getSalary())
                .sum();
    }
    public List<Employee> getIncrementedEmployeesSalaries(List<Employee> employeeList, double incrementPercentage)
    {
        return employeeList.stream()
                .map(employee -> {
                    Employee newEmployee = new Employee(employee.getId(), employee.getName(), employee.getDepartment(), employee.getSalary() + employee.getSalary()*(incrementPercentage/100));
                    return newEmployee;
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args)
    {
        Employee e1 = new Employee(1, "A", "D1", 100.0);
        Employee e2 = new Employee(2, "B", "D2", 100.0);
        Employee e3 = new Employee(3, "C", "D1", 100.0);
        Employee e4 = new Employee(4, "D", "D1", 100.0);

        EmployeeProcessor employeeProcessor = new EmployeeProcessor();

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4);

        System.out.println("All employees with department D1");

        employeeProcessor.getEmployeesInDepartment(employees, "D1")
                .stream().forEach(employee -> employee.print());

        System.out.println("All employees names");

        employeeProcessor.getEmployeeNames(employees)
                .stream().forEach(name -> System.out.println(name));

        System.out.println("Sum of all their salaries");

        System.out.println(employeeProcessor.getSalarySum(employees));

        System.out.println("Increase salary by 50%");

        employeeProcessor.getIncrementedEmployeesSalaries(employees, 50)
                .stream().forEach(employee -> employee.print());



    }
}
