import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    public static LoadDataFromFile dataLoader;
    private static List<String[]> listOfData;

    public static List<PolicyHolder> readPolicyHolderFile() {
        List<PolicyHolder> policyHolderList = new ArrayList<>();
        dataLoader = new LoadDataFromFile("C:\\RMIT Programing\\Java Programming\\asm1\\src\\customer.txt");
        listOfData = dataLoader.loadDataFromFile();

        for (String[] data : listOfData) {
            String cusID = data[0].trim();
            String cusName = data[1].trim();
            Customer cusInfo = new PolicyHolder(cusID, cusName);
            policyHolderList.add((PolicyHolder) cusInfo);
        }
       return policyHolderList;
    }

    public static List<InsuranceCard> readInsuranceFile() {
        List<InsuranceCard> insuranceCardList = new ArrayList<>();
        dataLoader = new LoadDataFromFile("C:\\RMIT Programing\\Java Programming\\asm1\\src\\insuranceCard.txt");
        listOfData = dataLoader.loadDataFromFile();

        for (String[] data : listOfData) {
            String cardNumber = data[0].trim();
            String policyOwner = data[1].trim();
            String expirationDate = data[2].trim();
            InsuranceCard insuranceInfo = new InsuranceCard(cardNumber, policyOwner, expirationDate);
            insuranceCardList.add(insuranceInfo);
        }
        return insuranceCardList;
    }

    public static List<Claim> readClaimFile() {
        List<Claim> claimList = new ArrayList<>();
        dataLoader = new LoadDataFromFile("C:\\RMIT Programing\\Java Programming\\asm1\\src\\claim.txt");
        listOfData = dataLoader.loadDataFromFile();

        for (String[] data : listOfData) {
            String claimID = data[0].trim();
            String examDate = data[1].trim();
            double claimAmount = Double.parseDouble(data[2].trim());
            Claim claimInfo = new Claim(claimID, examDate, claimAmount);
            claimList.add(claimInfo);
        }
        return claimList;
    }




}