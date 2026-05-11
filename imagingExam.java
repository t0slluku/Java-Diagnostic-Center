
public class imagingExam extends Exam{

private String machineType;
private static double costIncreaseRate=0.1;
private double examCost;

public imagingExam(String examCategory, String examName, int maxSlotsperDay, int cost, int idDoctor, String machineType){
    super(examCategory, examName, maxSlotsperDay, cost, idDoctor);
    this.machineType=machineType;
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
    return super.toString() + ", MachineType: " + machineType;
}




    
}
