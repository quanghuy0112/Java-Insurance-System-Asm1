package Claim;

/**
 * @author <Pham Quang Huy - s3970891>
 */

import Customer.Customer;

import java.time.LocalDate;

public class Claim {
    private String claimID;
    private LocalDate claimDate;
    private Customer insuredPerson;
    private String cardNumber;
    private LocalDate examDate;
    private String documents;
    private double claimAmount;
    private BankInfo receiveBankInfo;
    public ClaimStatus status;

    ;

    public Claim() {
        this.claimID = null;
        this.claimDate = null;
        this.insuredPerson = null;
        this.examDate = null;
        this.cardNumber = null;
        this.claimAmount = 0;
        this.receiveBankInfo = null;
        this.documents = null;
    }

    public Claim(String claimID, double claimAmount) {
        this.claimID = claimID;
        this.claimDate = null;
        this.examDate = null;
        this.insuredPerson = null;
        this.cardNumber = null;
        this.receiveBankInfo = null;
        this.claimAmount = claimAmount;
        this.documents = null;
    }


    public String getClaimID() {
        return claimID;
    }

    public LocalDate getClaimDate() {
        return claimDate = LocalDate.now();
    }

    public Customer getInsuredPerson() {
        return insuredPerson;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public String setCardNumber() {
        if (insuredPerson != null) {
            this.cardNumber = this.insuredPerson.getInsuranceCard().getCardNumber();

        }
        return this.cardNumber;
    }

    public String getDocuments() {
        if (cardNumber != null) {
            documents = claimID + "_" + cardNumber + "_" + "DocumentName" + ".pdf";
        }
        return documents;
    }

    public void setStatus(ClaimStatus status) {
        this.status = status;
    }

    public void setReceiveBankInfo(BankInfo receiveBankInfo) {
        this.receiveBankInfo = receiveBankInfo;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimID= " + claimID +
                ", claimDate= " + claimDate +
                ", insuredPerson= " + insuredPerson.getCusName() +
                ", cardNumber= " + setCardNumber() +
                ", examDate= '" + examDate + '\'' +
                ", documents= " + documents +
                ", claimAmount= " + claimAmount +
                ", receiveBankInfo= " + receiveBankInfo +
                ", status= " + status +
                '}';
    }
}
