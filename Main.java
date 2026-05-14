import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        
        DiagnosticCenter dc = new DiagnosticCenter();
        Scanner in = new Scanner(System.in);
        String answer1;
        String answer2;
        boolean done = false;
        boolean done2 = true;
		File file1 = new File("doctors.txt");
		File file2 = new File("exams.txt");
		File file3 = new File("appointments.txt");
		File file4 = new File("patients.txt");
	
		if (!file1.exists()) {
			System.out.println("\nFile does not exist. Creating data ...");
			dc.NoDoctors();
		}
		if (!file2.exists()) {
			System.out.println("\nFile does not exist. Creating data ...");
			dc.NoExams();
		}
		if (!file3.exists()) {
			System.out.println("\nFile does not exist. Creating data ...");
			dc.NoAppointments();
		}
		if (!file4.exists()) {
			System.out.println("\nFile does not exist. Creating data ...");
			dc.NoPatients();
		}

        while (!done) {
            done2 = false;
            System.out.println("-----MENU-----");
            System.out.println("1. Doctors\n2. Patients\n3. Exams\n4. Appointments\n5. Statistics\n0. Exit");
            answer1 = in.nextLine();
            switch (answer1) {
                case "0" : 
                    done = true;
					dc.StoreAll();
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
                                int id = Integer.parseInt(in.nextLine());
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
                                System.out.println("1. Imaging\n2. Microbiological\n3. Specialized");
                                String answer = in.nextLine();
                                String details;
                                String examCategory;
                                String answer3;

                                if (answer=="1"){
                                    examCategory ="Imaging";
                                    System.out.println("Choose the machine type for your exam: ");
                                    System.out.println("1. MRI\n2. CT\n3. X-RAY");
                                    answer3 = in.nextLine();
                                   
                                    if (answer3=="1"){
                                        details="MRI";
                                    }else if(answer3=="2"){
                                        details="CT";
                                    }else{
                                        details="X-RAY";
                                    }
                                }else if (answer1=="2"){
                                    examCategory="Microbiological";
                                    System.out.println("Choose the type of sample needed: ");
                                    System.out.println("1. Blood\n2. Urine\n3. Swab");
                                    answer3 = in.nextLine();
                                    
                                    if (answer3=="1"){
                                        details="Blood";
                                    }else if(answer3=="2"){
                                        details="Urine";
                                    }else{
                                        details="Swab";
                                    }
                                }else{
                                    examCategory="Specialized";
                                    System.out.println("Choose the specialty neede for this exam: ");
                                    System.out.println("1. Cardiology\n2. Neurology\n3. Pulmonology");
                                    answer3 = in.nextLine();
                                    
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
                            case "1" : 

                            System.out.println("Choose the patient based on his/her id: ");
                            dc.listAllPatients();
                            int patientId = Integer.parseInt(in.nextLine());

                            System.out.println("Choose the exam based on its id: ");
                            dc.listAllExams();
                            int examId = Integer.parseInt(in.nextLine());

                            String date;
                            while(true){
                                System.out.println("Give date as the example:\nDD:MM:EEEE");
                                date = in.nextLine();
                                if (!date.matches("\\d{2}:\\d{2}:\\d{4}")){
                                    System.out.println("Wrong date format. Try again.");
                                    continue;
								}
                                if (dc.isFullyBooked(examId, date)){
                                    System.out.println("No available slots for this date. Try another date.");
                                    continue;
                                }
                                break;

                            }
                            
                            boolean fastResults;
                            System.out.println("Fast results? (1=Yes, 0=No): ");
                            String answer3= in.nextLine();
                            if (answer3=="1"){
                                fastResults=true;
                            }else{
                                fastResults=false;
                            }

                            dc.addAppointment(patientId,examId,fastResults,date);
					
                            case "2" :
                                dc.listAllAppointments();

                            case "3" :

                                System.out.println("Choose the patient based on his/her id: ");
                                dc.listAllPatients();
                                int id =Integer.parseInt(in.nextLine());
                                dc.FindAppointmentDateByPatientID(id);

                            case "4":

                                System.out.println("Choose the exam you want to delete by choosing its id: ");
                                dc.listAllExams();
                                int id1 = Integer.parseInt(in.nextLine());
                                dc.removeAppointment(id1);

                            case "5" :

                                System.out.println("Give a date (HH:MM:EEEE) to see its appointments: ");
                                String date1 = in.nextLine();
                                dc.showDayAppointments(date1);

                                
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

                            case "1" :
                                dc.showTotalProfitsPerPatient();

                            case "2" :
                                dc.showTotalProfitsperExam();

                            case "3" :
                                dc.revenuePerCategory();

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
