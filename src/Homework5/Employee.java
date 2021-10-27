package Homework5;

public  class Employee {

    private String firstName;

    private String email;
    private String phoneNumber;

    private String post;
    private int wages;
    private int age;

    public Employee(String firstName,String email, String phoneNumber,String post,int wages, int age) {
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.post = post;
        this.wages = wages;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo(){
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", post='" + post + '\'' +
                ", wages=" + wages +
                ", age=" + age +
                '}';
    }
}
