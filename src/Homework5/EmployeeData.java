package Homework5;

public class EmployeeData {
    private static final int NUMBER_OF_EMPLOYEES = 5;
    private static final int MIN_AGE = 40;


    public static void main(String[] args) {
        Employee[] empArray = new Employee[NUMBER_OF_EMPLOYEES];
        empArray[0] = new Employee("Ivanova Olga", "iviva@mail.ru", "+795112312", "sales manager", 35000, 35);
        empArray[1] = new Employee("Petrov Ivan", "petrov@mail.ru", "+795012314", "sales manager", 40000, 38);
        empArray[2] = new Employee("Sidorov Anton", "sidorov@mailbox.com", "+798812315", "sales manager", 38000, 40);
        empArray[3] = new Employee("Sereda Nadegda", "sereda@google.com", "+798912316", "sales manager", 30000, 45);
        empArray[4] = new Employee("Filipov Vladimir", "filipov@yandex.ru", "+7950147354", "sales manager", 45000, 33);
        for (Employee employee : empArray)
            if (employee.getAge() > MIN_AGE)
                System.out.println(employee);
    }

}
