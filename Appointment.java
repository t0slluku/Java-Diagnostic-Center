
public class Appointment {

private static int idCounter=0;
private int appointmentId;
private int patientId;
private int examId;
private boolean fastResults;
private String examDate;

public Appointment(int patientId, int examId, boolean fastResults, String examDate){
    this.appointmentId=idCounter++;
    this.patientId=patientId;
    this.examId=examId;
    this.fastResults=fastResults;
    this.examDate=examDate;
}

public int getAppointmentId(){
    return appointmentId;
}
//γεια
public int getPatientId(){
    return patientId;
}

public int getExamId(){
    return examId;
}

public boolean getFastResults(){
    return fastResults;
}

public String getExamDate(){
    return examDate;
}


public String toString(){
    return "AppointmentID: " + appointmentId +
           ", PatientID: " + patientId +
           ", ExamID: " + examId +
           ", FastResults: " + fastResults +
           ", Date: " + examDate;
}


}
