import java.util.*;

class WrongAge extends Exception {
    public WrongAge(String msg) {
        super(msg);
    }
}

class Father {
    Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Age cannot be negative");
        } else {
            System.out.println("Father's age is: " + age);
        }
    }
}

class Son extends Father {
    Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge);

        if (sonAge < 0) {
            throw new WrongAge("Age cannot be negative");
        } else if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age must be less than Father's age");
        } else {
            System.out.println("Son's age is: " + sonAge);
        }
    }
}

public class excep1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Father's age: ");
        int f_age = sc.nextInt();

        System.out.print("Enter Son's age: ");
        int s_age = sc.nextInt();

        try {
            Son s = new Son(f_age, s_age);
        } catch (WrongAge e) {
   
            System.out.println("Error: " + e);
        }
        
    }
 
}




