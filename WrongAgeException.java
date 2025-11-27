public class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}
class Father {
    int fatherAge;

    Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException("Father's age cannot be negative!");
        }
        fatherAge = age;
    }
}

class Son extends Father {
    int sonAge;

    Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge);

        if (sonAge < 0) {
            throw new WrongAgeException("Son's age cannot be negative!");
        }
        if (sonAge >= fatherAge) {
            throw new WrongAgeException("Son's age cannot be greater than or equal to father's age!");
        }

        this.sonAge = sonAge;
    }
}

public class Main {
    public static void main(String[] args) {

        try {
            Father f = new Father(50);
            Son s = new Son(50, 20);
            System.out.println("Objects created successfully!");
        } catch (WrongAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            Son s2 = new Son(40, 45);
        } catch (WrongAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}