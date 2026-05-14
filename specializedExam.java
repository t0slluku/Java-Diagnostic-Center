
public class specializedExam extends Exam {
    
private String specialty;
private static double costIncreaseRate=0.3;
private double examCost;

public specializedExam(String examCategory, String examName, int maxSlotsperDay, int cost, int idDoctor, String specialty){
    super(examCategory, examName, maxSlotsperDay, cost, idDoctor);
    this.specialty=specialty;
}

public double getCost(boolean fastResults){
    if (fastResults){
        examCost= cost() + cost()*costIncreaseRate;
    }else{
        examCost=cost();
    }
    return examCost;

}


public String toString(){
    return super.toString() + ", Specialty: " + specialty;
}





}
