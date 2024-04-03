import java.util.HashMap;
import java.util.Map;

public class InsuranceOfCustomer {
    private Map<String, InsuranceCard> insuranceToCustomer;

    public InsuranceOfCustomer(){
        this.insuranceToCustomer = new HashMap<String, InsuranceCard>();
    }

    public InsuranceCard getInsuranceCard(ClaimProcessManager customer){
        return insuranceToCustomer.get(customer.getCusID());
    }

    public InsuranceCard addInsuranceToCustomer(ClaimProcessManager customer, InsuranceCard card){
            return insuranceToCustomer.put(customer.getCusID(), card);
    }







}
