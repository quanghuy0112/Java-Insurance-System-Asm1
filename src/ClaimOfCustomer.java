import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClaimOfCustomer {

    private Map<String, List<Claim>> claimToCustomer;

    public ClaimOfCustomer(){
        this.claimToCustomer = new HashMap<String, List<Claim>>();
    }
    public List<Claim> getAllClaim(ClaimProcessManager customer){
        List<Claim> claimList = claimToCustomer.get(customer.getCusID());
        return claimList;
    }

    public List<Claim> addClaimToCustomer(ClaimProcessManager customer, Claim claim){
        ArrayList<Claim> claims = new ArrayList<Claim>();
        claims.add(claim);
        List<Claim> preClaim = claimToCustomer.put(customer.getCusID(), claims);

        if(preClaim == null){
            return null;
        }else{
            for(Claim c : preClaim){
                if(c.equals(claim)){
                    return preClaim;
                }
            }
            preClaim.add(claim);
            return claimToCustomer.replace(customer.getCusID(), preClaim);
        }
    }

    boolean removeClaimCustomers(ClaimProcessManager customer, Claim claim){
        boolean isDoing = false;
        List<Claim> claims = getAllClaim(customer);
        if(claims != null){
            isDoing = claims.remove(claim);
            claimToCustomer.replace(customer.getCusID(), claims);
        }
        return isDoing;
    }

    public Claim getOneClaim(ClaimProcessManager customer, int claimID) {
        List<Claim> claimList = getAllClaim(customer);
        if (claimList != null) {
            for (Claim claim : claimList) {
                if (claim.getClaimID() == claimID) {
                    return claim;
                }
            }
        }
        return null; // Claim not found
    }




}
