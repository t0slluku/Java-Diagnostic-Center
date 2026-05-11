
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;


//prepei na allajoun oi tostring() se kathe klash ontothtwn

public class DiagnosticCenter {

    private HashMap<Integer,Doctor> doctors = new HashMap<>();
    private HashMap<Integer,Patient> patients = new HashMap<>();
    private HashMap<Integer,Appointment> appointments= new HashMap<>();
    private HashMap<Integer,Exam> exams= new HashMap<>();

    //adders
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
            //πρεπει να βαλουμε κατι ωστε να τερματιζει η διαδικασια και να τον ξαναπηγαινει ωστε να κλεισει απτην αρχη νεο ραντεβου απτο σταδιο τησ ευρεσησ κατηγοριασ 
        }
    }

    public void addAppointment(int patientId, int examId, boolean fastResults, String examDate){
        Appointment a1 = new Appointment(patientId, examId, fastResults, examDate);
        appointments.put(a1.getAppointmentId(), a1);  
    }

    //list all

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
            for (Patient p : doctors.values()){
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

    
    //show one doctor 1.3

    public void FindExamByDoctorID(int id){

        for (Exam e: exams.values()){
            if (e.getIdDoctor()==id){
                System.out.println(e);
            }
        }
    }

    //show appointment of a doctor 1.4

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

    //show patient's appointments

    public void FindAppointmentByPatientID(int id){

        Patient p = patients.get(id);
        for (Appointment a: appointments.values()){
            if (a.getPatientId() == p.getID()){
                System.out.println(a);
            }
        }

    }

    //show appointments of a specific exam type

    public void FindAppointmentByExamID(int id){

        Exam e = exams.get(id);
        for (Appointment a: appointments.values()){
            if (e.getCode() == a.getExamId()){
                System.out.println(a);
            }
        }

    }

    





     
    




} 






    

