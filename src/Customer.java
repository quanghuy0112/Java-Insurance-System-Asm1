import java.util.ArrayList;
import java.util.List;

public abstract class Customer implements ClaimProcessManager {
    private String cusID;
    private String cusName;
    private InsuranceCard insuranceCard;
    private List<Claim> listOfClaims;

    public Customer() {
        this.cusID = "Default";
        this.cusName = "Default";
        this.insuranceCard = null;
        listOfClaims = new ArrayList<Claim>();
    }

//    public Customer(String cusID, String cusName, InsuranceCard insuranceCard) {
//        this.cusID = cusID;
//        this.cusName = cusName;
//        this.insuranceCard = insuranceCard;
//        listOfClaims = new ArrayList<Claim>();
//    }


    public Customer(String cusID, String cusName) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.insuranceCard = null;
        listOfClaims = new ArrayList<Claim>();
    }


    public String getCusID() {
        return cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public int getInsuranceCard() {
        return insuranceCard.getCardNumber();
    }

    public List<Claim> getListOfClaims() {
        return listOfClaims;
    }



    public boolean addClaim(Claim c){
        //c.getClaimDate();
//        c.getInsuredPerson();
        listOfClaims.add(c);
        c.setInsuredPerson(this);
        return true;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "cusID='" + cusID + '\'' +
                ", cusName='" + cusName + '\'' +
                '}';
    }

//        public void showInfo(){
//        System.out.println("CusID: " + cusID +
//                            ", CusName: " + cusName);
//        for(int i = 0; i < listOfClaims.size(); i++){
//            System.out.printf("Claim %d: " + listOfClaims.get(i) + "\n", i + 1);
//        }
//        System.out.println(insuranceCard);
//    }

}
