package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;

    private static List<Employee> duplicateEmployees;

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1,"ahmet","yılmaz"));
        employees.add(new Employee(1,"ahmet","yılmaz"));
        employees.add(new Employee(1,"ahmet","yılmaz"));
        employees.add(new Employee(2,"zeynep","türk"));
        employees.add(new Employee(2,"zeynep","türk"));
        employees.add(new Employee(3,"emin","yıldız"));
        employees.add(new Employee(4,"tülin","çiçek"));
        employees.add(new Employee(5,"gökberk","perem"));
    }

    public static List<Employee> findDuplicates(List<Employee> employees){
        employeeMap = new HashMap<>();
        duplicateEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee == null){
                System.out.println("null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())){
                duplicateEmployees.add(employee);
            }
            else {
                employeeMap.put(employee.getId(),employee);
            }
        }
        return duplicateEmployees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer,Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }
}