import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer{
    private List<Dependent> listOfDependent;

    public PolicyHolder(){
        super();
        listOfDependent = new ArrayList<Dependent>();
    }

//    public PolicyHolder(String cusID, String cusName, InsuranceCard insuranceCard) {
//        super(cusID, cusName, insuranceCard);
//        listOfDependent = new ArrayList<Dependent>();
//    }

    public PolicyHolder(String cusID, String cusName) {
        super(cusID, cusName);
        listOfDependent = new ArrayList<Dependent>();
    }


    public List<Dependent> getListOfDependent() {
        return listOfDependent;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusID='" + getCusID() + '\'' +
                ", cusName='" + getCusName() + '\'' +
                '}';
    }

}
