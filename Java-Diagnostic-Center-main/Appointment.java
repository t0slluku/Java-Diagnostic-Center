
public class Appointment {

private static int nextId = 0;
private int appointmentId;
private int patientId;
private int examId;
private boolean fastResults;
private String examDate;
private boolean cancelled;

public Appointment(int patientId, int examId, boolean fastResults, String examDate, boolean cancelled){
    this.appointmentId=++nextId;
    this.patientId=patientId;
    this.examId=examId;
    this.fastResults=fastResults;
    this.examDate=examDate;
    this.cancelled = cancelled;
}

public Appointment(int appointmentId, int patientId, int examId, boolean fastResults, String examDate, boolean cancelled){
    this.appointmentId=appointmentId;
    this.patientId=patientId;
    this.examId=examId;
    this.fastResults=fastResults;
    this.examDate=examDate;
    this.cancelled = cancelled;
	if (appointmentId > nextId) nextId = appointmentId;
}


public int getAppointmentId(){
    return appointmentId;
}

public int getPatientId(){
    return patientId;
}

public int getExamId(){
    return examId;
}

public boolean getFastResults(){
    return fastResults;
}

public boolean getCancelled(){
    return cancelled;
}

void setCancelled(boolean cancelled){
    this.cancelled=cancelled;
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
