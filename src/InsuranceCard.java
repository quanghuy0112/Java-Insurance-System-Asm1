import java.time.LocalDate;
import java.util.Date;

public class InsuranceCard {
    private int cardNumber;
    private Customer cardHolder;
    private String policyOwner;
    private LocalDate exiprationDate;

    public InsuranceCard() {
        this.cardNumber = 0;
        this.policyOwner = "Default";
        this.policyOwner = null;
    }

    public InsuranceCard(int cardNumber, String policyOwner, LocalDate exiprationDate) {
        this.cardNumber = cardNumber;
        this.policyOwner = policyOwner;
        this.exiprationDate = exiprationDate;
    }
}
