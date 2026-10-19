class Employee
{
    int empno;
    String name;
    float sal;

    Employee(){
        system.out.println("******");
        enpno = 101;
        name = 'Aashish';
        sal = 5000;
    }

    void displayDetails(){
        system.out.println(enpno + "" + name + "" + sal);
    }
}

class Main
{
    public static void main(String[] args)
    {
        Employee em1 = new employee();
        Employee em2 = new employee();
        Employee em3 = new employee();

        emp1.displayDetails();
        emp2.displayDetails();
        emp3.displayDetails();
    }
}