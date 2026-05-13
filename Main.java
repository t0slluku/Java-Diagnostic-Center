import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DiagnosticCenter dc = new DiagnosticCenter();
        Scanner in = new Scanner(System.in);
        String answer1;
        String answer2;
        boolean done = false;
        boolean done2 = false;
        while (!done) {
            done2 = false;
            System.out.println("-----MENU-----");
            System.out.println("1. Doctors\n2. Patients\n3. Exams\n4. Appointments\n5. Statistics\n0. Exit");
            answer1 = in.nextLine();
            switch (answer1) {
                case "0" : 
                    done = true;
                    break;
                case "1" :
                    while (!done2) {
                        System.out.println("-----DOCTOR MENU-----");
                        System.out.println("1. Insert doctor\n2. Show all doctors\n3. Show a specific doctor\n4. Appointments for a doctor\n0. Return");
                        answer2 = in.nextLine();
                        switch (answer2) {
                            case "0" :
                                done2 = true;
                                break;
                            case "1":
                                System.out.println("Give name: ");
                                String name = in.nextLine();
                                System.out.println("Give the number of your phone: ");
                                String phone = in.nextLine();
                                System.out.println("Specialties:");
                                System.out.println("Cardiology\nRadiology\nMIcrobiology\nNeurology\nPulmonology");
                                String specialty = in.nextLine();
                                System.out.println("Years of experience: ");
                                int yearsOfExp=Integer.parseInt(in.nextLine());
                                dc.addDoctor(name,phone,specialty,yearsOfExp);
                                break;
                            case "2":
                                dc.listAllDoctors();
                                break;
                            case "3":
                                dc.listAllDoctors();
                                System.out.println("Choose the doctor based on his/her id: ");
                                int id =Integer.parseInt(in.nextLine());
                                dc.FindExamByDoctorID(id);
                                break;
                            case "4":
                                dc.listAllDoctors();
                                System.out.println("Choose the doctor based on his/her id: ");
                                int id1 =Integer.parseInt(in.nextLine());
                                dc.FindAppointmentByDoctorID(id1);
                                break;
                            default:
                                System.out.println("Wrong input, Try again");
                                break;

                        }
                    }
                    break;
                case "2" : 
                    while (!done2) {
                        System.out.println("-----PATIENT MENU-----");
                        System.out.println("1. Insert patient\n2. Show all patients\n3. Show a specific patient\n0. Return");
                        answer2 = in.nextLine();
                        switch (answer2) {
                            case "0" :
                                done2 = true;
                                break;
                            case "1" :
                                System.out.println("Give name: ");
                                String name = in.nextLine();
                                System.out.println("Give the number of your phone ");
                                String phone = in.nextLine();
                                System.out.println("Give your email adress: ");
                                String email = in.nextLine();
                                dc.addPatient(name,phone,email);
                            case "2" :
                                dc.listAllPatients();
                            case "3" :
                                dc.listAllPatients();
                                System.out.println("Choose the patient based on his/her id: ");
                                int id = Integer.parseInt(id);
                                dc.FindAppointmentByPatientID(id);
                            default:
                                System.out.println("Wrong input, Try again");
                                break;
                        }
                    }
                    break;
                case "3" : 
                    while (!done2) {
                        System.out.println("-----EXAM MENU-----");
                        System.out.println("1. Insert exam\n2. Show all exams\n3. Show a specific exam\n0. Return");
                        answer2 = in.nextLine();
                        switch (answer2) {
                            case "0" :

                                done2 = true;
                                break;

                            case "1" :

                                System.out.println("Available exam categories:\nChoose the category");
                                System.out.println("1. Imagining\n2. Microbiological\n3. Specialized");
                                String answer = in.nextLine();
                                String details;
                                if (answer=="1"){
                                    String examCategory ="Imagining";
                                    System.out.println("Choose the machine type for your exam: ");
                                    System.out.println("1. MRI\n2. CT\n3. X-RAY");
                                    String answer3 = in.nextLine();
                                   
                                    if (answer3=="1"){
                                        details="MRI";
                                    }else if(answer3=="2"){
                                        details="CT";
                                    }else{
                                        details="X-RAY";
                                    }
                                }else if (answe=="2"){
                                    String examCategory="Microbiological";
                                    System.out.println("Choose the type of sample needed: ");
                                    System.out.println("1. Blood\n2. Urine\n3. Swab");
                                    String answer3 = in.nextLine();
                                    
                                    if (answer3=="1"){
                                        details="Blood";
                                    }else if(answer3=="2"){
                                        details="Urine";
                                    }else{
                                        details="Swab";
                                    }
                                }else{
                                    String examCategory="Specialized";
                                    System.out.println("Choose the specialty neede for this exam: ");
                                    System.out.println("1. Cardiology\n2. Neurology\n3. Pulmonology");
                                    String answer3 = in.nextLine();
                                    
                                    if (answer3=="1"){
                                        details="Cardiology";
                                    }else if(answer3=="2"){
                                        details="Neurology";
                                    }else{
                                        details="Pulmonology";
                                    }
                                }  

                                System.out.println("Give the name of the exam: ");
                                String examName=in.nextLine();  

                                System.out.println("Choose the maximun number of exams of this type per day: ");
                                int maxSlotsperDay=Integer.parseInt(in.nextLine());

                                dc.listAllDoctors();
                                System.out.println("Choose the doctor for this exam based on his/her id: ");
                                int idDoctor = Integer.parseInt(in.nextLine());

                                System.out.println("Choose the cost for this exam based on its:\n1. Category\n2. Category's characteristics");
                                int cost = Integer.parseInt(in.nextLine());

                                dc.addExam(examCategory,examName,maxSlotsperDay,cost,idDoctor,details);

                            case "2" :

                                dc.listAllExams();

                            case "3" :
                                dc.listAllExams();
                                System.out.println("Choose the exam based on its id to see its appointments: ");
                                int id = Integer.parseInt(in.nextLine());
                                dc.FindAppointmentByExamID(id);

                            default:
                                System.out.println("Wrong input, Try again");
                                break;
                        }
                    }
                    break;
                case "4" :
                    while (!done2) {
                        System.out.println("-----APPOINTMENT MENU-----");
                        System.out.println("1. Insert appointment\n2. Show all appointments\n3. Show appointments of a specific patient\n4. Remove appointment\n5. Show all appointments for a specific day\n0. Return");
                        answer2 = in.nextLine();
                        switch (answer2) {
                            case "0" :
                                done2 = true;
                                break;
                            default:
                                System.out.println("Wrong input, Try again");
                                break;
                        }
                    }
                    break;
                case "5" : 
                    while (!done2) {
                        System.out.println("-----STAT MENU-----");
                        System.out.println("1. Total income from each patient\n2. Total income from each exam\n3. Total income from each exam category\n0. Return");
                        answer2 = in.nextLine();
                        switch (answer2) {
                            case "0":
                                done2 = true;
                                break;
                            default:
                                System.out.println("Wrong input, Try again");
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Wrong input, Try again");
                    break;
            }   
        }
    }
}
