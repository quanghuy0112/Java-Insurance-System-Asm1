package Customer;

import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer {
    private List<Dependent> listOfDependent;

    public PolicyHolder() {
        super();
        listOfDependent = new ArrayList<Dependent>();
    }

    public PolicyHolder(String cusID, String cusName) {
        super(cusID, cusName);
        listOfDependent = new ArrayList<Dependent>();
    }


    public List<Dependent> getListOfDependent() {
        return listOfDependent;
    }

    public void setListOfDependent(List<Dependent> listOfDependent) {
        this.listOfDependent = listOfDependent;
    }

    public boolean addDependent(Dependent dependent) {
        if (listOfDependent.contains(dependent)) {
            return false;
        }
        listOfDependent.add(dependent);
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusID='" + getCusID() + '\'' +
                ", cusName='" + getCusName() + '\'' +
                '}';
    }

    public void showListOfDependent() {
        System.out.println("List of dependent: " + listOfDependent + '\'');
    }

}
