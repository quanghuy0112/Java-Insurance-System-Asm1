package System;

import Customer.Customer;
import Customer.Dependent;
import Customer.PolicyHolder;
import InsuranceCard.InsuranceCard;
import Claim.Claim;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    public static LoadDataFromFile dataLoader;
    private static List<String[]> listOfData;

    public static List<PolicyHolder> readPolicyHolderFile() {
        List<PolicyHolder> policyHolderList = new ArrayList<>();
        dataLoader = new LoadDataFromFile("src/Customer/policyHolder.txt");
        listOfData = dataLoader.loadDataFromFile();

        for (String[] data : listOfData) {
            String cusID = data[0].trim();
            String cusName = data[1].trim();
            Customer cusInfo = new PolicyHolder(cusID, cusName);
            policyHolderList.add((PolicyHolder) cusInfo);
        }
       return policyHolderList;
    }

    public static List<Dependent> readDependentFile() {
        List<Dependent> dependentList = new ArrayList<>();
        dataLoader = new LoadDataFromFile("src/Customer/dependent.txt");
        listOfData = dataLoader.loadDataFromFile();

        for (String[] data : listOfData) {
            String cusID = data[0].trim();
            String cusName = data[1].trim();
            Customer cusInfo = new Dependent(cusID, cusName);
            dependentList.add((Dependent) cusInfo);
        }
        return dependentList;
    }
    public static List<InsuranceCard> readInsuranceFile() {
        List<InsuranceCard> insuranceCardList = new ArrayList<>();
        dataLoader = new LoadDataFromFile("src/InsuranceCard/insuranceCard.txt");
        listOfData = dataLoader.loadDataFromFile();

        for (String[] data : listOfData) {
            String cardNumber = data[0].trim();
            String policyOwner = data[1].trim();
//            String expirationDate = data[2].trim();
            InsuranceCard insuranceInfo = new InsuranceCard(cardNumber, policyOwner);
            insuranceCardList.add(insuranceInfo);
        }
        return insuranceCardList;
    }

    public static List<Claim> readClaimFile() {
        List<Claim> claimList = new ArrayList<>();
        dataLoader = new LoadDataFromFile("src/Claim/claim.txt");
        listOfData = dataLoader.loadDataFromFile();
        for (String[] data : listOfData) {
            String claimID = data[0].trim();
//            String examDate = data[1].trim();
            double claimAmount = Double.parseDouble(data[1].trim());
            Claim claimInfo = new Claim(claimID, claimAmount);
            claimList.add(claimInfo);
        }
        return claimList;
    }



}
