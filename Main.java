import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int answer1;
        int answer2;
        boolean done = false;
        boolean done2 = false;
        while (!done) {
            done2 = false;
            System.out.println("1. Doctors\n2. Patients\n3. Exams\n4. Appointments\n5. Statistics\n0. Exit");
            answer1 = Integer.parseInt(in.nextLine());
            switch (answer1) {
                case 0 : 
                    done = true;
                    break;
                case 1 :
                    while (!done2) {
                        System.out.println("1. Insert doctor\n2. Show all doctors\n3. Show a specific doctor\n4. Appointments for a doctor\n0. Return");
                        answer2 = Integer.parseInt(in.nextLine());
                        switch (answer2) {
                            case 0 :
                                done2 = true;
                                break;

                        }
                    }
                case 2 : 
                    while (!done2) {
                        System.out.println("1. Insert patient\n2. Show all patients\n3. Show a specific patient\n0. Return");
                        answer2 = Integer.parseInt(in.nextLine());
                        switch (answer2) {
                            case 0 :
                                done2 = true;
                                break;
                        }
                    }
                case 3 : 
                    while (!done2) {
                            System.out.println("1. Insert exam\n2. Show all exams\n3. Show a specific exam\n0. Return");
                            answer2 = Integer.parseInt(in.nextLine());
                            switch (answer2) {
                                case 0 :
                                    done2 = true;
                                    break;
                            }
                        }
                case 4 :
                    while (!done2) {
                            System.out.println("1. Insert appointment\n2. Show all appointments\n3. Show appointments of a specific patient\n4. Remove appointment\n5. Show all appointments for a specific day\n0. Return");
                            answer2 = Integer.parseInt(in.nextLine());
                            switch (answer2) {
                                case 0 :
                                    done2 = true;
                                    break;
                            }
                        }
                case 5 : 
                    while (!done2) {
                            System.out.println("1. Total income from each patient\n2. Total income from each exam\n3. Total income from each exam category\n0. Return");
                            answer2 = Integer.parseInt(in.nextLine());
                            switch (answer2) {
                                case 0 :
                                    done2 = true;
                                    break;
                            }
                        }
            } 
        }
    }
}
