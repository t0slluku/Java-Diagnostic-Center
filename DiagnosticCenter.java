
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;


// prepei na allajoun oi tostring() se kathe klash ontothtwn

public class DiagnosticCenter {

    private HashMap<Integer,Doctor> doctors = new HashMap<>();
    private HashMap<Integer,Patient> patients = new HashMap<>();
    private HashMap<Integer,Appointment> appointments= new HashMap<>();
    private HashMap<Integer,Exam> exams= new HashMap<>();

    // adders
    public void addDoctor(String name, String phone, String specialty, int yearsofExp){
        Doctor d1 = new Doctor(name, phone, specialty, yearsofExp);
        doctors.put(d1.getID(),d1);
    }

    public void addPatient(String name, String phone, String email){
        Patient p1 = new Patient(name, phone, email);
        patients.put(p1.getID(), p1);
    }

    public void addExam(String examCategory, String examName, int maxSlotsperDay, int cost, int idDoctor, String details){
        //details=machine type /sample type / specialty
        if (details.toLowerCase().contains("ma")| details=="machine"){
            imagingExam i1= new imagingExam(examCategory, examName, maxSlotsperDay, cost, idDoctor, details);
            exams.put(i1.getCode(), i1);
        }else if (details.toLowerCase().contains("sam")| details=="sample"){
            microbiologicalExam m1 = new microbiologicalExam(examCategory, examName, maxSlotsperDay, cost, idDoctor, details);
            exams.put(m1.getCode(), m1);
        }else if (details.toLowerCase().contains("spe")| details=="specialty"){
            specializedExam s1 = new specializedExam(examCategory, examName, maxSlotsperDay, cost, idDoctor, details);
            exams.put(s1.getCode(), s1);
        }else{
            System.out.println("This exam category doesn't exists or cant be identified.Please try again!"); 
        }
        
    }

    public void addAppointment(int patientId, int examId, boolean fastResults, String examDate){
        Appointment a1 = new Appointment(patientId, examId, fastResults, examDate);
        appointments.put(a1.getAppointmentId(), a1);  
    }

    // list all //na kanw 1 gia 3

    public void listAllDoctors(){
        if (doctors.isEmpty()){
        System.out.println("List is empty.");
        } else {
            for (Doctor d : doctors.values()){
                System.out.println(d); 
            }
        }
    }
    
    public void listAllPatients(){
        if (patients.isEmpty()){
            System.out.println("List is empty.");
        } else {
            for (Patient p : patients.values()){
                System.out.println(p); 
            }
        }
    }
    
    public void listAllExams(){
        if (exams.isEmpty()){
            System.out.println("List is empty.");
        }else{
            ArrayList<Exam> sortedExams = new ArrayList<>(exams.values());
            sortedExams.sort(Comparator.comparing(Exam::getExamName));
            for (Exam e : sortedExams){
                System.out.println(e);
            }
        }
    }

    public void listAllAppointments(){
        if (appointments.isEmpty()){
            System.out.println("List is empty.");
        }else{
            for (Appointment a: appointments.values()){
                System.out.println(a);
            }
        }
    }

    
    // show one doctor 1.3

    public void FindExamByDoctorID(int id){

        for (Exam e: exams.values()){
            if (e.getIdDoctor()==id){
                System.out.println(e);
            }
        }
    }

    // show appointment of a doctor 1.4

    public void FindAppointmentByDoctorID(int id){

        for (Exam e: exams.values()){
            if (e.getIdDoctor()==id){
                for (Appointment a: appointments.values()){
                    if (e.getCode() == a.getExamId()){
                        System.out.println(a);
                    }
                }
            }
        }

    }

    // show patient's appointments 2.3

    public void FindAppointmentByPatientID(int id){

        Patient p = patients.get(id);
        for (Appointment a: appointments.values()){
            if (a.getPatientId() == p.getID()){
                System.out.println(a);
            }
        }

    }

    // show appointments of a specific exam type 3.3

    public void FindAppointmentByExamID(int id){

        Exam e = exams.get(id);
        for (Appointment a: appointments.values()){
            if (e.getCode() == a.getExamId()){
                System.out.println(a);
            }
        }

    }

    //show the dates of a patient's appointment 4.3

    public void FindAppointmentDateByPatientID(int id){

        for (Appointment a: appointments.values()){
            if (a.getPatientId() == id){
                System.out.println(a.getExamDate());
            }
        }

    }

    // remove an appointment 4.4

    public void removeAppointment(int id){

        if (appointments.containsKey(id)){
            appointments.remove(id);
            System.out.println("Appointment deleted successfully.");
        } else {
            System.out.println("Appointment not found.");
        }

    }

    //show appointment's of a specific date 4.5

    public void showDayAppointments(string date){

        for (Appointment a: appointments.values()){
            if (a.getExamDate()==date){
                for (Patient p:patients.values()){
                    if (a.getPatientId()==p.getID())
                        System.out.println("Patient's name: " + p.getName());
                }
                for (Exam e:exams.values()){
                    if (e.getCode()==a.getExamId()){
                        System.out.println("Name of the examination: " + e.getExamName());
                    }
                }
                System.out.println(a);
                
            }
        }

    }
//5.1

    public void showTotalProfitsPerPatient(){

        double totalProfitFromAllPatients=0;

        for (Patient p:patients.values()){
            System.out.println(p.getName());
            double totalprofitperPerson=0;
            for (Appointment a: appointments.values()){
                if(p.getID()==a.getPatientId()){
                    System.out.println(a);
                    for (Exam e: exams.values()){
                        if(e.getCode()==a.getExamId()){
                            totalprofitperPerson = totalprofitperPerson + e.getCost(a.getFastResults());
                            break;
                        }
                    }
                }
            }
            totalProfitFromAllPatients = totalProfitFromAllPatients + totalprofitperPerson;
            System.out.println("Total profit per patient: " + p.getName() + totalprofitperPerson);
            System.out.println("--------------------------");
        }
        System.out.println("Total profit from all patients: " + totalProfitFromAllPatients);

    }

    //5.2

    public void showTotalProfitsperExam(){

        double totalProfitFromAllExams=0;

        for (Exam e:exams.values()){
            double totalProfitperExam = 0;
            System.out.println("Exam Id: " + e.getCode() + "Exam Category: " + e.getExamCategory() + "Exam name: " + e.getExamName());
            for (Appointment a:appointments.values()){
                if(e.getCode()==a.getExamId()){
                    System.out.println(a);
                    totalProfitperExam = totalProfitperExam + e.getCost(a.getFastResults());
                }
            }
            totalProfitFromAllExams= totalProfitFromAllExams + totalProfitperExam;
            System.out.println("Total profit per exam: " + totalProfitperExam);
            System.out.println("-------------------------");

        }
        System.out.println("Total profit from all exams: " + totalProfitFromAllPatients);

    }

    //5.3

    public void revenuePerCategory(){
    String[] categories = {"Imaging", "Microbiological", "Specialized"};
    double totalProfit = 0;
    
        for (String category : categories){
            System.out.println("Category: " + category);
            double categoryProfit = 0;
        
            for (Appointment a : appointments.values()){
                Exam e = exams.get(a.getExamId());
            
                if (e.getExamCategory().equals(category)){
                    System.out.println(a); // εκτυπωνει τα χαρακτηριστικα του ραντεβου
                    double cost = e.getCost(a.getFastResults());
                    categoryProfit = categoryProfit + cost;
                }
            }
        
            System.out.println("Total profit for " + category + ": " + categoryProfit);
            System.out.println("----------------------------");
            totalProfit = totalProfit + categoryProfit;
        }
    
        System.out.println("Total profit from all categories: " + totalProfit);
    }



} 






    

