
public class microbiologicalExam extends Exam {
    
private String sampleType;
private static double costIncreaseRate=0.2;
private double examCost;

public microbiologicalExam(String examCategory, String examName, int maxSlotsperDay, int cost, int idDoctor, String sampleType){
    super(examCategory,examName, maxSlotsperDay, cost, idDoctor);
    this.sampleType=sampleType;
}

public microbiologicalExam(int code, String examCategory, String examName, int maxSlotsperDay, int cost, int idDoctor, String sampleType){
    super(code, examCategory,examName, maxSlotsperDay, cost, idDoctor);
    this.sampleType=sampleType;
}


public double getCost(boolean fastResults){
    if (fastResults){
        examCost= cost() + cost()*costIncreaseRate;
    }else{
        examCost=cost();
    }
    return examCost;

}

public String getSampleType(){
	return sampleType;
}


public String toString(){
    return super.toString() + ", SampleType: " + sampleType;
}





}
