class Parent 
{
    int age, id;
    String name;

    void naming(String name) {
        System.out.println("Name: " + name);
    }
}

class Child extends Parent {
    void ageN(int age) {
        System.out.println("Age of student is: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Child student = new Child();
        student.naming("Alex");
        student.ageN(16);
    }
}

