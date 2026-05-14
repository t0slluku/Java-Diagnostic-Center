
public class Patient {

private static int nextId = 0;
private int patientId;
private String name;
private String phone;
private String email;

public Patient(String name, String phone, String email){
    this.patientId=++nextId;
    this.name=name;
    this.phone=phone;
    this.email=email;
}
	
public Patient(int patientId, String name, String phone, String email){
    this.patientId=patientId;
    this.name=name;
    this.phone=phone;
    this.email=email;
	if (patientId > nextId) nextId = patientId;

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
