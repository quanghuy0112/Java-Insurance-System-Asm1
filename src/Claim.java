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
    private enum status {New, Processing, Done};

    public Claim(){
        this.claimID = 0;
        this.claimDate = null;
        this.examDate = "Default";
        this.claimAmount = 0;
        documents = new ArrayList<Document>();
    }

    public Claim(int claimID, Customer insuredPerson, InsuranceCard cardNumber, String examDate, double claimAmount) {
        this.claimID = claimID;
        this.claimDate = null;
        this.examDate = examDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.claimAmount = claimAmount;
        documents = new ArrayList<Document>();
    }

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

    @Override
    public String toString() {
        return "{" +
                "claimID=" + claimID +
                ", claimDate=" + claimDate +
                ", insuredPerson=" + getInsuredPerson() +
                ", cardNumber=" + getCardNumber() +
                ", examDate=" + examDate +
                ", documents=" + documents +
                ", claimAmount=" + claimAmount +
                '}';
    }
}
