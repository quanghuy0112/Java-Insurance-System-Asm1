import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Claim {
    private String claimID;
    private LocalDate claimDate;
    private Customer insuredPerson;
    private String cardNumber;
    private String examDate;
    private List<Document> documents;
    private double claimAmount;
    private BankInfo receiveBankInfo;

    public enum status {New, Processing, Done}

    ;

    public Claim() {
        this.claimID = null;
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

//    public Claim(int claimID, InsuranceCard cardNumber, String examDate, double claimAmount, BankInfo receiveBankInfo) {
//        this.claimID = claimID;
//        this.claimDate = null;
//        this.examDate = examDate;
//        this.insuredPerson = insuredPerson;
//        this.cardNumber = cardNumber;
//        this.receiveBankInfo = receiveBankInfo;
//        this.claimAmount = claimAmount;
//        documents = new ArrayList<Document>();
//    }

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

        public Claim(String claimID, String examDate, double claimAmount) {
        this.claimID = claimID;
        this.claimDate = null;
        this.examDate = examDate;
        //this.insuredPerson = insuredPerson;
        //this.cardNumber = cardNumber;
        this.receiveBankInfo = receiveBankInfo;
        this.claimAmount = claimAmount;
        documents = new ArrayList<Document>();
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

    public String getCardNumber() {
        return cardNumber;
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

    public void setCardNumber() {
        this.cardNumber = this.insuredPerson.getInsuranceCard();
    }

    public boolean addCustomer(Customer insuredPerson){
        return insuredPerson.addClaim(this);
    }

    public BankInfo getReceiveBankInfo() {
        return receiveBankInfo;
    }

    public void setReceiveBankInfo(BankInfo receiveBankInfo) {
        this.receiveBankInfo = receiveBankInfo;
    }


    @Override
    public String toString() {
        return "Claim{" +
                "claimID=" + claimID +
                ", claimDate=" + claimDate +
                ", insuredPerson=" + insuredPerson.getCusName() +
                ", cardNumber=" + cardNumber+
                ", examDate='" + examDate + '\'' +
                ", documents=" + documents +
                ", claimAmount=" + claimAmount +
                ", receiveBankInfo=" + receiveBankInfo +
                '}';
    }
}
