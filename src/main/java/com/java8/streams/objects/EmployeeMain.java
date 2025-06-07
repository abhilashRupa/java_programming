package com.java8.streams.objects;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));

        empList.add(new Employee(10, "wxy", 25, 165, "M", "IT", "Blore", 2010));
        empList.add(new Employee(11, "wxyz", 25, 160, "M", "IT", "Blore", 2010));

    /*    employeesByCity(empList);
        employeesByAge(empList);
        employeesCountByGender(empList);
        displayDepartmentName(empList);
        displayEmployeeAgeGraterThan28(empList);
        maxAgeEmployee(empList);

        //custom
        secondOldestPerson(empList);
        secondHighestSalary(empList);*/
        displayEmployeesInDescendingOrder(empList);
        maxEmployeesByDepartment(empList);
    }




    //    1. Group the Employees by city.
    private static void employeesByCity(List<Employee> employees) {
        Map<String, List<Employee>> cityWiseEmployeeList = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("displaying employees by their city: ");
        cityWiseEmployeeList.entrySet().forEach(System.out::println);
    }

    //2. Group the Employees by age.
    private static void employeesByAge(List<Employee> empList) {
        Map<Integer, List<Employee>> ageWiseEmployeesList = empList.stream().
                collect(Collectors.groupingBy(Employee::getAge));
        System.out.println("displaying employees by their age");
        ageWiseEmployeesList.entrySet().forEach(System.out::println);
    }

    //3. Find the count of male and female employees present in the organization.
    private static void employeesCountByGender(List<Employee> employees) {
        //approach 1
        Map<Boolean, List<Employee>> genderWiseCount = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getGender().equalsIgnoreCase("M")));

        System.out.println("\n \n Count of Male employee: " + genderWiseCount.get(Boolean.TRUE).size());
        System.out.println("Count of Female employee: " + genderWiseCount.get(Boolean.FALSE).size());

        Map<String, Long> genderWiseCount1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println("\n\n gender wise employee count: ");
        genderWiseCount1.entrySet().forEach(System.out::println);
    }

    //    4. Print the names of all departments in the organization.
    private static void displayDepartmentName(List<Employee> employees) {

        System.out.println("\n\n displaying the unique department Name: ");

        employees.stream()
                .map(Employee::getDeptName)
                .distinct()
                .forEach(System.out::println);
    }

    //    5. Print employee details whose age is greater than 28.
    private static void displayEmployeeAgeGraterThan28(List<Employee> employees) {
        List<Employee> employeeList = employees.stream()
                .filter(employee -> employee.getAge() > 28)
                .collect(Collectors.toList());

        System.out.println("\n\n employees list whose age grater than 28 ");

        employeeList.forEach(System.out::println);

    }

    //    6. Find maximum age of employee.
    private static void maxAgeEmployee(List<Employee> employees) {
        Optional<Integer> maxAge = employees.stream()
                .map(Employee::getAge)
                .max(Comparator.comparingInt(Integer::intValue));

        System.out.println("\n\n Max age: " + maxAge.get());

        Optional<Employee> maxAge1 = employees.stream()
                .max(Comparator.comparingInt(Employee::getAge));

        System.out.println("\n\n Max age1: " + maxAge1.get().getAge());

        OptionalInt maxAge2 = employees.stream()
                .mapToInt(Employee::getAge)
                .max();

        System.out.println("\n\n Max age2: " + maxAge2.getAsInt());

    }

    /*custom*/

    private static void secondOldestPerson(List<Employee> empList) {
        Optional<Employee> secondAge = empList.stream()
                .sorted((a, b) -> b.getAge() - a.getAge())
                .skip(1)
                .findFirst();

        System.out.println(secondAge.get().getAge());
    }

    private static void secondHighestSalary(List<Employee> empList) {
        Optional<Employee> secondHighestSalary = empList.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
        System.out.println(secondHighestSalary.get().getSalary());
    }

    private static void displayEmployeesInDescendingOrder(List<Employee> employeeList) {


        List<Employee> sortredList = employeeList.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed()
                        .thenComparing(Employee::getName, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println("/******************* approach 1 ******************************* /");
        sortredList.forEach(System.out::println);

        employeeList.sort(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder())
                .thenComparing(Comparator.comparing(Employee::getName, Comparator.reverseOrder())));
        System.out.println("/******************* approach 2 ******************************* /");
        employeeList.forEach(System.out::println);

        List<Employee> sortredList1 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println("/******************* approach 3 ******************************* /");
        sortredList1.forEach(System.out::println);


    }

    private static void maxEmployeesByDepartment(List<Employee> empList) {

        Map<String, Long> employeeByDeptCount = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));

        Optional<Map.Entry<String, Long>> maxEmployeeByDeptCount = employeeByDeptCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .findFirst();

        System.out.println(maxEmployeeByDeptCount);

    }


}
