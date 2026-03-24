package exception;

class Person {

    void checkAge(int age) throws AgeInvalidException {
        if (age < 0 || age > 100) {
            throw new AgeInvalidException("Age must be between 0 and 100");
        }
        System.out.println("Valid age: " + age);
    }
}

public class age {
    public static void main(String[] args) {
        Person p = new Person();

        try {
            p.checkAge(12);
        } catch (AgeInvalidException e) {
            System.out.println(e.getMessage());
        }
    }
}