
abstract class Exam {

private static int idCounter=0;
private int code;
private String examCategory;
private String examName;
private int maxSlotsperDay;
private int cost;
private int idDoctor;

public Exam(String examCategory, String examName, int maxSlotsperDay, int cost, int idDoctor){
    this.code=idCounter++;
    this.examCategory=examCategory;
    this.examName=examName;
    this.maxSlotsperDay=maxSlotsperDay;
    this.cost=cost;
    this.idDoctor=idDoctor;

}

public int getCode(){
    return code;
}

public String getExamCategory(){
    return examCategory;
}

public String getExamName(){
    return examName;
}
 
public int getMaxSlotsperDay(){
    return maxSlotsperDay;
}

public int getIdDoctor(){
    return idDoctor;
}

abstract double getCost(boolean fastResults);

public int cost(){
    return cost;
}


public String toString(){
    return "ExamID: " + code +
           ", Name: " + examName + 
           ", Category: " + examCategory + 
           ", MaxSlots: " + maxSlotsperDay + 
           ", Cost: " + cost + 
           ", DoctorID: " + idDoctor;
}





}
