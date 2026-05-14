
public class Doctor {

private static int idCounter=1;
private int doctorId;
private String name;
private String phone;
private String specialty;
private int yearsofExp;

public Doctor(String name, String phone, String specialty, int yearsofExp){
    this.doctorId=idCounter++;
    this.name=name;
    this.phone=phone;
    this.specialty=specialty;
    this.yearsofExp=yearsofExp;

}

public int getID(){
    return doctorId;
}

public String getName() {
    return name;
}

public String getPhone(){
    return phone;
}

public String getSpecialty(){
    return specialty;
}

public int getYearsofExp(){
    return yearsofExp;
}


public String toString(){
    return "ID: " + doctorId + 
           ", Name: " + name + 
           ", Phone: " + phone + 
           ", Specialty: " + specialty + 
           ", Years of experience: " + yearsofExp;
}


}
