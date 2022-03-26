package org.comp;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
class Employee {
    String name;
    int salary;

    public Employee(){}
    public Employee(String name,int salary)
    {
        this.name=name;
        this.salary=salary;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void getSalary(int salary)
    {
        this.salary=salary;
    }
    public String getName()
    {
        return name;
    }
    public int getSalary()
    {
        return salary;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append("name: ");
        sb.append(name);
        sb.append(" salary: ");
        sb.append("" + salary+">");
        return sb.toString();

    }
}
class EmployeeInfo{
    enum SortMethod {BYNAME, BYSALARY};

    class compareName implements Comparator<Employee>
    {
        @Override
        public int compare(Employee o1,Employee o2)
        {
            return o1.getName().compareTo(o2.getName());
        }
    }
    class compareSalary implements Comparator<Employee>
    {
        @Override
        public int compare(Employee o1,Employee o2)
        {
            return (o1.getSalary()-o2.getSalary());
        }
    }
    public List<Employee> sort(List<Employee> emps, final SortMethod method)
    {
        if(method == SortMethod.BYSALARY)
        {
            return emps.stream().sorted(new compareSalary()).collect(Collectors.toList());
        }
        else
        {
            return emps.stream().sorted(new compareName()).collect(Collectors.toList());
        }
    }

    public boolean isCharacterPresentInAllNames(Collection<Employee> entities, String character)
    {
        return entities.stream().anyMatch(m->m.getName().startsWith(character));
        
    }
}


public class HelloWorld
{
    public static void main(String[] args)
    {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("Mickey", 1000));
        emps.add(new Employee("Timmy", 50000));
        emps.add(new Employee("Annny", 40000));

        EmployeeInfo obj = new EmployeeInfo();
        System.out.println(obj.sort(emps,EmployeeInfo.SortMethod.BYNAME));
        System.out.println(obj.isCharacterPresentInAllNames(emps,"z"));
        System.out.println(emps);
    }
}
