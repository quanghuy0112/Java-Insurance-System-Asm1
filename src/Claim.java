import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Claim {
    private int claimID;
    private LocalDate claimDate;
    private Customer insuredPerson;
    private InsuranceCard cardNumber;
    private String examDate;
    private List<Document> documents;
    private double claimAmount;
    private BankInfo receiveBankInfo;

    public enum status {New, Processing, Done}

    ;

    public Claim() {
        this.claimID = 0;
        this.claimDate = null;
        this.examDate = "Default";
        this.claimAmount = 0;
        this.receiveBankInfo = null;
        documents = new ArrayList<Document>();
    }

//    public Claim(int claimID, Customer insuredPerson, InsuranceCard cardNumber, String examDate, double claimAmount, BankInfo receiveBankInfo) {
//        this.claimID = claimID;
//        this.claimDate = null;
//        this.examDate = examDate;
//        this.insuredPerson = insuredPerson;
//        this.cardNumber = cardNumber;
//        this.receiveBankInfo = receiveBankInfo;
//        this.claimAmount = claimAmount;
//        documents = new ArrayList<Document>();
//    }

    public Claim(int claimID, InsuranceCard cardNumber, String examDate, double claimAmount, BankInfo receiveBankInfo) {
        this.claimID = claimID;
        this.claimDate = null;
        this.examDate = examDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.receiveBankInfo = receiveBankInfo;
        this.claimAmount = claimAmount;
        documents = new ArrayList<Document>();
    }

//    public Claim(int claimID, String examDate, double claimAmount, BankInfo receiveBankInfo) {
//        this.claimID = claimID;
//        this.claimDate = null;
//        this.examDate = examDate;
//        this.insuredPerson = insuredPerson;
//        this.cardNumber = cardNumber;
//        this.receiveBankInfo = receiveBankInfo;
//        this.claimAmount = claimAmount;
//        documents = new ArrayList<Document>();
//    }
//


    public int getClaimID() {
        return claimID;
    }

    public LocalDate getClaimDate() {
        return claimDate = LocalDate.now();
    }

    public String getInsuredPerson() {
        return insuredPerson.getCusName();
    }

    public int getCardNumber() {
        return cardNumber.getCardNumber();
    }

    public String getExamDate() {
        return examDate;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public boolean addCustomer(Customer insuredPerson){
        return insuredPerson.addClaim(this);
    }

    public BankInfo getReceiveBankInfo() {
        return receiveBankInfo;
    }


    @Override
    public String toString() {
        return "Claim{" +
                "claimID=" + claimID +
                ", claimDate=" + getClaimDate() +
                ", insuredPerson=" + getInsuredPerson() +
                ", cardNumber=" + getCardNumber() +
                ", examDate='" + examDate + '\'' +
                ", documents=" + documents +
                ", claimAmount=" + claimAmount +
                ", receiveBankInfo=" + getReceiveBankInfo() +
                '}';
    }
}
