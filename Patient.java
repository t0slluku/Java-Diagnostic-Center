
public class Patient {

private static int idCounter=1;
private int patientId;
private String name;
private String phone;
private String email;

public Patient(String name, String phone, String email){
    this.patientId=idCounter++;
    this.name=name;
    this.phone=phone;
    this.email=email;

}

public int getID(){
    return patientId;
}

public String getName(){
    return name;
}

public String getPhone(){
    return phone;
}
    
public String getEmail(){
    return email;
}


public String toString(){
    return "PatientID: " + patientId +
           ", Name: " + name +
           ", Phone: " + phone +
           ", Email: " + email;
}

}
