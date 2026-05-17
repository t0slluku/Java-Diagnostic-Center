import java.util.ArrayList;
import java.util.Comparator;


// prepei na allajoun oi tostring() se kathe klash ontothtwn

public class DiagnosticCenter {

    FileManager fm = new FileManager();
	

    // adders
    public void addDoctor(String name, String phone, String specialty, int yearsofExp){
        Doctor d1 = new Doctor(name, phone, specialty, yearsofExp);
        fm.getdoctors().put(d1.getID(),d1);
    }

    public void addPatient(String name, String phone, String email){
        Patient p1 = new Patient(name, phone, email);
        fm.getpatients().put(p1.getID(), p1);
    }

    public void addExam(String examCategory, String examName, int maxSlotsperDay, int cost, int idDoctor, String details){
        //details=machine type /sample type / specialty
        if (details.equals("MRI") || details.equals("CT") || details.equals("X-RAY")){
            imagingExam i1= new imagingExam(examCategory, examName, maxSlotsperDay, cost, idDoctor, details);
            fm.getexams().put(i1.getCode(), i1);
        }else if (details.equals("Blood") || details.equals("Urine") || details.equals("Swab")){
            microbiologicalExam m1 = new microbiologicalExam(examCategory, examName, maxSlotsperDay, cost, idDoctor, details);
            fm.getexams().put(m1.getCode(), m1);
        }else if (details.equals("Cardiology") || details.equals("Neurology") || details.equals("Pulmonology")){
            specializedExam s1 = new specializedExam(examCategory, examName, maxSlotsperDay, cost, idDoctor, details);
            fm.getexams().put(s1.getCode(), s1);
        }else{
            System.out.println("This exam category doesn't exist or can't be identified. Please try again!"); 
        }
        
    }

    public void addAppointment(int patientId, int examId, boolean fastResults, String examDate){
        Appointment a1 = new Appointment(patientId, examId, fastResults, examDate);
        fm.getappointments().put(a1.getAppointmentId(), a1);  
    }

    // list all //na kanw 1 gia 3

    public void listAllDoctors(){
        if (fm.getdoctors().isEmpty()){
        System.out.println("List is empty.");
        } else {
            for (Doctor d : fm.getdoctors().values()){
                System.out.println(d); 
            }
        }
    }
    
    public void listAllPatients(){
        if (fm.getpatients().isEmpty()){
            System.out.println("List is empty.");
        } else {
            for (Patient p : fm.getpatients().values()){
                System.out.println(p); 
            }
        }
    }
    
    public void listAllExams(){
        if (fm.getexams().isEmpty()){
            System.out.println("List is empty.");
        }else{
            ArrayList<Exam> sortedExams = new ArrayList<>(fm.getexams().values());
            sortedExams.sort(Comparator.comparing(Exam::getExamName));
            for (Exam e : sortedExams){
                System.out.println(e);
            }
        }
    }

    public void listAllAppointments(){
        if (fm.getappointments().isEmpty()){
            System.out.println("List is empty.");
        }else{
            for (Appointment a: fm.getappointments().values()){
				if (!a.getCancelled()){
					System.out.println(a);
				}
            }
        }
    }

    
    // show one doctor 1.3

    public void FindExamByDoctorID(int id){

        boolean flag = false;
        for (Exam e: fm.getexams().values()){
            if (e.getIdDoctor()==id){
                System.out.println(e);
                flag = true;
            }
        }
        if (!flag){
            System.out.println("No exams found ");
        }

    }
    
    

    // show appointment of a doctor 1.4

    public void FindAppointmentByDoctorID(int id){
        boolean flag=false;
        for (Exam e: fm.getexams().values()){
            if (e.getIdDoctor()==id){
                for (Appointment a: fm.getappointments().values()){
                    if (e.getCode() == a.getExamId()){
                        System.out.println(a);
                        flag=true;
                    }
                }
            }
        }
        if (!flag){
            System.out.println("No appointments found ");
        }

    }

    // show patient's appointments 2.3

    public void FindAppointmentByPatientID(int id){
        boolean flag = false;
        Patient p = fm.getpatients().get(id);
        for (Appointment a: fm.getappointments().values()){
            if (a.getPatientId() == p.getID()){
                System.out.println(a);
                flag=true;
            }
        }
        if (!flag){
            System.out.println("No appointments found ");
        }

    }

    // show appointments of a specific exam type 3.3

    public void FindAppointmentByExamID(int id){
        boolean flag = false;
        Exam e = fm.getexams().get(id);
        for (Appointment a: fm.getappointments().values()){
            if (e.getCode() == a.getExamId()){
                System.out.println(a);
                flag=true;
            }
        }
        if (!flag){
            System.out.println("No appointments found for this exam ");
        }

    }

    public boolean isFullyBooked(int examId, String date){
        int count = 0;
        Exam e = fm.getexams().get(examId);
    
        for (Appointment a : fm.getappointments().values()){
            if (a.getExamId() == examId && a.getExamDate().equals(date)){
                count++;
            }
        }
    
        return count >= e.getMaxSlotsperDay();
    }

    //show the dates of a patient's appointment 4.3

    public void FindAppointmentDateByPatientID(int id){

        for (Appointment a: fm.getappointments().values()){
            if (a.getPatientId() == id){
                System.out.println(a.getExamDate());
            }
        }

    }

    // remove an appointment 4.4

    public void removeAppointment(int id){

        if (fm.getappointments().containsKey(id)){
            fm.getappointments().get(id).setCancelled(true);
            System.out.println("Appointment removed successfully.");
        } else {
            System.out.println("Appointment not found.");
        }

    }

    //show appointment's of a specific date 4.5

    public void showDayAppointments(String date){

        if (date.matches("\\d{2}:\\d{2}:\\d{4}")){
            for (Appointment a: fm.getappointments().values()){
                if (a.getExamDate().equals(date)){
                    for (Patient p:fm.getpatients().values()){
                        if (a.getPatientId()==p.getID())
                            System.out.println("Patient's name: " + p.getName());
                    }
                    for (Exam e:fm.getexams().values()){
                        if (e.getCode()==a.getExamId()){
                            System.out.println("Name of the examination: " + e.getExamName());
                        }
                    }
                    System.out.println(a);
                
                }
            }
        }else{
            System.out.println("Wrong date type input, try again: ");
        }
    }
//5.1

    public void showTotalProfitsPerPatient(){

        double totalProfitFromAllPatients=0;

        for (Patient p:fm.getpatients().values()){
            System.out.println("--------------------------");
            System.out.println(p.getName());
            double totalprofitperPerson=0;
            for (Appointment a: fm.getappointments().values()){
                if(p.getID()==a.getPatientId()){
                    System.out.println(a);
                    for (Exam e: fm.getexams().values()){
                        if(e.getCode()==a.getExamId()){
                            totalprofitperPerson = totalprofitperPerson + e.getCost(a.getFastResults());
                            break;
                        }
                    }
                }
            }
            totalProfitFromAllPatients = totalProfitFromAllPatients + totalprofitperPerson;
            System.out.println("\nTotal profit from patient " + p.getName() + ": " + totalprofitperPerson);
        }
        System.out.println("--------------------------");
        System.out.println("\nTotal profit from all patients: " + totalProfitFromAllPatients);

    }

    //5.2

    public void showTotalProfitsperExam(){

        double totalProfitFromAllExams=0;

        for (Exam e:fm.getexams().values()){
            double totalProfitperExam = 0;
            System.out.println("-------------------------");
            System.out.println("Exam ID: " + e.getCode() + " Exam Category: " + e.getExamCategory() + " Exam name: " + e.getExamName());
            for (Appointment a:fm.getappointments().values()){
                if(e.getCode()==a.getExamId()){
                    System.out.println(a);
                    totalProfitperExam = totalProfitperExam + e.getCost(a.getFastResults());
                }
            }
            totalProfitFromAllExams= totalProfitFromAllExams + totalProfitperExam;
            System.out.println("\nTotal profit per exam: " + totalProfitperExam);

        }
        System.out.println("-------------------------");
        System.out.println("\nTotal profit from all exams: " + totalProfitFromAllExams);

    }

    //5.3

    public void revenuePerCategory(){
        String[] categories = {"Imaging", "Microbiological", "Specialized"};
        double totalProfit = 0;
    
        for (String category : categories){
            System.out.println("----------------------------");
            System.out.println("Category: " + category);
            double categoryProfit = 0;
        
            for (Appointment a : fm.getappointments().values()){
                Exam e = fm.getexams().get(a.getExamId());
            
                if (e.getExamCategory().equals(category)){
                    System.out.println(a); 
                    double cost = e.getCost(a.getFastResults());
                    categoryProfit = categoryProfit + cost;
                }
            }
        
            System.out.println("\nTotal profit for " + category + ": " + categoryProfit);
            totalProfit = totalProfit + categoryProfit;
        }
        System.out.println("----------------------------");
        System.out.println("\nTotal profit from all categories: " + totalProfit);
    }
	
	public void StoreAll(){
		fm.storeFile("doctors.txt");
		fm.storeFile("patients.txt");
		fm.storeFile("exams.txt");
		fm.storeFile("appointments.txt");
	}
	
	


}




    

