import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClaimOfCustomer {

    private Map<String, List<Claim>> claimToCustomer;

    public ClaimOfCustomer(){
        this.claimToCustomer = new HashMap<String, List<Claim>>();
    }
    public List<Claim> getAllClaim(String str){
        List<Claim> claimList = claimToCustomer.get(str);
        return claimList;
    }







}
