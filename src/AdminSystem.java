public class AdminSystem {

    public static void main(String[] args){

        Customer cus1 = new PolicyHolder("123", "Huy");

        Claim claim1 = new Claim(123, 500, "2023-10-01", cus1);
        Claim claim2 = new Claim(234, 1000, "2024-01-01", cus1);

        cus1.addClaim(claim1);
        cus1.addClaim(claim2);
        cus1.showInfo();





    }
}
