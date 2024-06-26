package Customer;

/**
 * @author <Pham Quang Huy - s3970891>
 */

import Claim.Claim;
import InsuranceCard.InsuranceCard;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
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

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public List<Claim> getListOfClaims() {
        return listOfClaims;
    }


    public boolean addClaim(Claim claim) {
        if (listOfClaims.contains(claim) && claim.getInsuredPerson() != null) {
            return false;
        }
        claim.getClaimDate();
//        c.getInsuredPerson();
        listOfClaims.add(claim);
        claim.setInsuredPerson(this);
        return true;
    }

    public boolean removeClaim(Claim claim) {
        // Check if the claim exists in the list of claims
        if (listOfClaims.contains(claim)) {
            // Remove the claim from the list
            listOfClaims.remove(claim);
            // Update the reference to the insured person of the claim
            claim.setInsuredPerson(null);
            return true; // Claim removed successfully
        }
        return false; // Claim not found in the list
    }

    public boolean addInsuranceCard(InsuranceCard insuranceCard) {
        //if(insuranceCard.getCardHolder() != null){
        //  return false;
        // }
        this.insuranceCard = insuranceCard;
        insuranceCard.setCardHolder(this);
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusID='" + cusID + '\'' +
                ", cusName='" + cusName + '\'' +
                '}';
    }

    public void showInfo() {
        System.out.println("CusID: " + cusID +
                ", CusName: " + cusName);
        System.out.println(insuranceCard);
        for (int i = 0; i < listOfClaims.size(); i++) {
            System.out.printf("Claim %d: " + listOfClaims.get(i) + "\n", i + 1);
        }
    }

}
