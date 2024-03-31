public class InsuranceCard {
    private int cardNumber;
    private Customer cardHolder;
    private String policyOwner;
    private String exiprationDate;

    public InsuranceCard() {
        this.cardNumber = 0;
        this.policyOwner = "Default";
        this.policyOwner = null;
    }

    public InsuranceCard(int cardNumber, Customer cardHolder, String policyOwner, String exiprationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.exiprationDate = exiprationDate;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder.getCusName();
    }

    @Override
    public String toString() {
        return "InsuranceCard{" +
                "cardNumber=" + cardNumber +
                ", cardHolder=" + cardHolder +
                ", policyOwner='" + policyOwner + '\'' +
                ", exiprationDate='" + exiprationDate + '\'' +
                '}';
    }
}
