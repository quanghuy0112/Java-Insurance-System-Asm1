package System;

import InsuranceCard.InsuranceCard;
import Claim.BankInfo;
import Claim.ClaimStatus;
import Customer.Dependent;
import Customer.PolicyHolder;
import Claim.Claim;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SystemManager implements ClaimProcessManager {
    static Scanner scanner = new Scanner(System.in);
    static List<PolicyHolder> policyHolderList = FileSystem.readPolicyHolderFile();
    static List<Dependent> dependentList = FileSystem.readDependentFile();
    static List<InsuranceCard> insuranceCardList = FileSystem.readInsuranceFile();
    static List<Claim> claimList = FileSystem.readClaimFile();

    public void addInsurance() {
        for (int i = 0; i < policyHolderList.size(); i++) {
            for (int j = 0; j < insuranceCardList.size(); j++) {
                if (i == j) {
                    policyHolderList.get(i).addInsuranceCard(insuranceCardList.get(j));
                    insuranceCardList.get(j).setCardHolder(policyHolderList.get(i));
//                    policyHolderList.get(i).showInfo();
                }
            }
        }
    }

    @Override
    public void addClaimToCustomer() {

        System.out.println("Enter the customer ID you want to add claim: ");
        String cusID = scanner.nextLine();

        boolean foundCustomer = false;

        for (int i = 0; i < policyHolderList.size(); i++) {

            if (cusID.equals(policyHolderList.get(i).getCusID())) {
                foundCustomer = true;
                viewClaimId();
                while (true) {
                    System.out.println("Enter the claim ID you want to add (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting claim input.");
                        break; // Exit the claim input loop if the user types 'quit'

                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < claimList.size(); j++) {
                        if (claimID.equals(claimList.get(j).getClaimID())) {
                            foundClaim = true;

                            if (policyHolderList.get(i).getInsuranceCard() == null) {
                                System.out.println("Please add the insuranceCard for this customer.");
                                break;
                            }
                            policyHolderList.get(i).addClaim(claimList.get(j));
                            claimList.get(j).setInsuredPerson(policyHolderList.get(i));
                            claimList.get(j).setCardNumber();
                            claimList.get(j).getDocuments();
                            System.out.println("Add Claim successfully");
                            policyHolderList.get(i).showInfo();
//                           break; // Exit the claim search loop if claim found
                        }
                    }

                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }
                }

            }


        }
        for (int i = 0; i < dependentList.size(); i++) {

            if (cusID.equals(dependentList.get(i).getCusID())) {
                foundCustomer = true;
                viewClaimId();
                while (true) {
                    System.out.println("Enter the claim ID you want to add (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting claim input.");
                        break; // Exit the claim input loop if the user types 'quit'

                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < claimList.size(); j++) {
                        if (claimID.equals(claimList.get(j).getClaimID())) {
                            foundClaim = true;
                            if (dependentList.get(i).getInsuranceCard() == null) {
                                System.out.println("This customer (Customer.Dependent) have not added to any Policy Holder! Please add him/her to Policy Holder first");
                                break;
                            }
                            dependentList.get(i).addClaim(claimList.get(j));
                            claimList.get(j).setInsuredPerson(dependentList.get(i));
                            claimList.get(j).setCardNumber();
                            claimList.get(j).getDocuments();
                            System.out.println("Add Claim successfully");
                            dependentList.get(i).showInfo();
//                           break; // Exit the claim search loop if claim found
                        }
                    }

                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }
                }

            }


        }
        if (!foundCustomer) {
            System.out.println("Customer with ID " + cusID + " not found.");
        }
    }

    @Override
    public void removeClaimFromCustomer() {
        viewAllPolicyHolder();
        viewAllDependent();
        System.out.println("Enter the Customer ID you want to remove claim: ");
        String cusID = scanner.nextLine();

        boolean foundCustomer = false;
        viewClaimId();
        for (int i = 0; i < policyHolderList.size(); i++) {
            if (cusID.equals(policyHolderList.get(i).getCusID())) {
                foundCustomer = true;

                while (true) {
                    System.out.println("Enter the claimID you want to remove (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting claim input.");
                        break; // Exit the claim input loop if the user types 'quit'

                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < claimList.size(); j++) {
                        if (claimID.equals(claimList.get(j).getClaimID())) {
                            if (claimList.get(j).getInsuredPerson() == null) {
                                foundClaim = true;
                                System.out.println("This claim is not owned by this customer");
                                break;
                            }
                            foundClaim = true;

                            policyHolderList.get(i).removeClaim(claimList.get(j));
                            claimList.get(j).setInsuredPerson(policyHolderList.get(i));
                            claimList.get(j).setCardNumber();
                            policyHolderList.get(i).showInfo();

//                            break; // Exit the claim search loop if claim found
                        }
                    }

                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }
                }

            }
        }
        for (int i = 0; i < dependentList.size(); i++) {
            if (cusID.equals(dependentList.get(i).getCusID())) {
                foundCustomer = true;

                while (true) {
                    System.out.println("Enter the claimID you want to remove (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting claim input.");
                        break; // Exit the claim input loop if the user types 'quit'

                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < claimList.size(); j++) {
                        if (claimID.equals(claimList.get(j).getClaimID())) {
                            foundClaim = true;

                            dependentList.get(i).removeClaim(claimList.get(j));
                            claimList.get(j).setInsuredPerson(dependentList.get(i));
                            claimList.get(j).setCardNumber();
                            dependentList.get(i).showInfo();

//                            break; // Exit the claim search loop if claim found
                        }
                    }

                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }
                }

            }
        }
        if (!foundCustomer) {
            System.out.println("Customer with ID " + cusID + " not found.");
        }
    }

    @Override
    public void viewAllClaim() {
        viewAllPolicyHolder();
        viewAllDependent();
        Boolean foundCustomer = false;
        while (true) {
            System.out.println("Enter the CusID (or type 'quit' to exit): ");
            String cusID = scanner.nextLine();
            if (cusID.equals("quit")) {
                System.out.println("Exiting CusID input.");
                break; // Exit the claim input loop if the user types 'quit'
            }

            for (int i = 0; i < policyHolderList.size(); i++) {
                if (cusID.equals(policyHolderList.get(i).getCusID())) {
                    if (!policyHolderList.get(i).getListOfClaims().isEmpty()) {
//
                        policyHolderList.get(i).showInfo();
                    }
                }
            }

            for (int i = 0; i < dependentList.size(); i++) {
                if (cusID.equals(dependentList.get(i).getCusID())) {
                    if (!dependentList.get(i).getListOfClaims().isEmpty()) {
                        dependentList.get(i).showInfo();
                    }
                }
            }

        }
    }

    @Override
    public void viewOneClaim() {
        viewAllPolicyHolder();
        viewAllDependent();
        System.out.println("Enter the customer ID you want to view claim: ");
        String cusID = scanner.nextLine();

        boolean foundCustomer = false;
        viewClaimId();
        for (int i = 0; i < policyHolderList.size(); i++) {
            if (cusID.equals(policyHolderList.get(i).getCusID())) {
                foundCustomer = true;

                while (true) {
                    System.out.println("Enter the claim ID you want to view (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting claim input.");
                        break; // Exit the claim input loop if the user types 'quit'

                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < claimList.size(); j++) {
                        if (claimID.equals(claimList.get(j).getClaimID())) {
                            foundClaim = true;
                            if (claimList.get(j).getInsuredPerson() == null) {
                                System.out.println("This claim is not owned by this customer!");
                                break;
                            }

                            System.out.println(claimList.get(j));

//                            break; // Exit the claim search loop if claim found
                        }
                    }
                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }
                }

            }
        }
        for (int i = 0; i < dependentList.size(); i++) {
            if (cusID.equals(dependentList.get(i).getCusID())) {
                foundCustomer = true;

                while (true) {
                    System.out.println("Enter the claim ID you want to view (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting claim input.");
                        break; // Exit the claim input loop if the user types 'quit'

                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < claimList.size(); j++) {
                        if (claimID.equals(claimList.get(j).getClaimID())) {
                            foundClaim = true;
                            if (claimList.get(j).getInsuredPerson() == null) {
                                System.out.println("This claim is not owned by this customer!");
                                break;
                            }

                            System.out.println(claimList.get(j));

//                            break; // Exit the claim search loop if claim found
                        }
                    }
                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }
                }

            }
        }
        if (!foundCustomer) {
            System.out.println("Customer with ID " + cusID + " not found.");
        }
    }

    @Override
    public void setExamDateToClaim() {

        viewClaimId();
        while (true) {
            System.out.println("Enter the claimID you want to set exam date (or type 'quit' to exit): ");
            String claimID = scanner.nextLine();

            if (claimID.equals("quit")) {
                System.out.println("Exiting claim input.");
                break; // Exit the claim input loop if the user types 'quit'
            }
            boolean foundClaim = false;
            for (int j = 0; j < claimList.size(); j++) {
                if (claimID.equals(claimList.get(j).getClaimID())) {
                    if (claimList.get(j).getInsuredPerson() == null) {
                        foundClaim = true;
                        System.out.println("This claim have not added to any Customer! Please add claim to customer first");
                        break;
                    }
                    foundClaim = true;
                    try {
                        System.out.println("Enter the year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the month: ");
                        int month = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the day: ");
                        int day = scanner.nextInt();
                        scanner.nextLine();
                        LocalDate date = LocalDate.of(year, month, day);
                        claimList.get(j).setExamDate(date);
                        System.out.println(claimList.get(j));

                    } catch (DateTimeException | InputMismatchException e) {
                        System.out.println("Invalid input! Please enter valid integer values for year, month, and day.");
                        scanner.nextLine();
                    }
                }

            }
            if (!foundClaim) {
                System.out.println("Claim with ID " + claimID + " not found.");
            }
        }
    }

    @Override
    public void setStatus() {
        viewClaimId();
        while (true) {

            System.out.println("Enter the claimID you want to set status (or type 'quit' to exit): ");
            String claimID = scanner.nextLine();
            if (claimID.equals("quit")) {
                System.out.println("Exiting claim input.");
                break; // Exit the claim input loop if the user types 'quit'
            }
            boolean foundClaim = false;
            for (int j = 0; j < claimList.size(); j++) {
                if (claimID.equals(claimList.get(j).getClaimID())) {
                    if (claimList.get(j).getInsuredPerson() == null) {
                        foundClaim = true;
                        System.out.println("This claim have not added to any Customer! Please add claim to customer first");
                        break;
                    } else {
                        foundClaim = true;
                        System.out.println("Enter the status (new, processing, done): ");
                        String status = scanner.nextLine();
                        if (status.equals("new")) {
                            claimList.get(j).setStatus(ClaimStatus.NEW);
                            System.out.println(claimList.get(j));
                        } else if (status.equals("processing")) {
                            claimList.get(j).setStatus(ClaimStatus.PROCESSING);
                            System.out.println(claimList.get(j));
                        } else if (status.equals("done")) {
                            claimList.get(j).setStatus(ClaimStatus.DONE);
                            System.out.println(claimList.get(j));
                        } else {
                            System.out.println("Invalid Value!");
                        }
                    }
                }
            }
            if (!foundClaim) {
                System.out.println("Claim with ID " + claimID + " not found.");
            }
        }
    }

    @Override
    public void setBank() {
        viewClaimId();
        while (true) {
            System.out.println("Enter the claimID you want to set bank (or type 'quit' to exit): ");
            String claimID = scanner.nextLine();

            if (claimID.equals("quit")) {
                System.out.println("Exiting claim input.");
                break; // Exit the claim input loop if the user types 'quit'
            }
            boolean foundClaim = false;
            for (int j = 0; j < claimList.size(); j++) {
                if (claimID.equals(claimList.get(j).getClaimID())) {
                    if (claimList.get(j).getInsuredPerson() == null) {
                        foundClaim = true;
                        System.out.println("This claim have not added to any Customer! Please add claim to customer first");
                        break;
                    }
                    foundClaim = true;
                    System.out.println("Enter the bank: ");
                    String bank = scanner.nextLine();
                    System.out.println("Enter the name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the number: ");
                    String number = scanner.nextLine();
                    claimList.get(j).setReceiveBankInfo(new BankInfo(bank, name, number));
                    System.out.println(claimList.get(j));
                }
            }

            if (!foundClaim) {
                System.out.println("Claim with ID " + claimID + " not found.");
            }

        }
    }

    public void addDependentToPolicyHolder() {
        System.out.println("Enter the policy holder ID you want to add dependent: ");
        String cusID = scanner.nextLine();

        boolean foundCustomer = false;

        for (int i = 0; i < policyHolderList.size(); i++) {

            if (cusID.equals(policyHolderList.get(i).getCusID())) {
                foundCustomer = true;
                viewAllDependent();
                while (true) {
                    System.out.println("Enter the dependent ID you want to add (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting dependent input.");
                        break; // Exit the claim input loop if the user types 'quit'
                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < dependentList.size(); j++) {
                        if (claimID.equals(dependentList.get(j).getCusID())) {
                            foundClaim = true;
                            policyHolderList.get(i).addDependent(dependentList.get(j));
                            dependentList.get(j).addInsuranceCard(policyHolderList.get(i).getInsuranceCard());
                            System.out.printf("Add dependent successfully to " + policyHolderList.get(i) + "\n");
                            policyHolderList.get(i).showListOfDependent();
//                            break; // Exit the claim search loop if claim found
                        }
                    }

                    if (!foundClaim) {
                        System.out.println("Customer.Dependent with ID " + claimID + " not found.");
                    }
                }

            }

        }
        if (!foundCustomer) {
            System.out.println("Policy holder with ID " + cusID + " not found.");
        }
    }

    public void setExpirationDate() {
        System.out.println("Enter the insurance number you want to set expiration date: ");
        String insuranceNumber = scanner.nextLine();
        Boolean foundInsuranceCard = false;
        for (int j = 0; j < insuranceCardList.size(); j++) {
            if (insuranceNumber.equals(insuranceCardList.get(j).getCardNumber())) {
                try {
                    System.out.println("Enter the year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the month: ");
                    int month = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the day: ");
                    int day = scanner.nextInt();
                    scanner.nextLine();
                    LocalDate date = LocalDate.of(year, month, day);
                    insuranceCardList.get(j).setExiprationDate(date);
                    System.out.println(insuranceCardList.get(j));
                    System.out.println("Set the expiration date successfully");
                    foundInsuranceCard = true;
                } catch (DateTimeException | InputMismatchException e) {
                    System.out.println("Invalid input! Please enter valid integer values for year, month, and day.");
                    scanner.nextLine();
                }
            }
        }
        if (!foundInsuranceCard) {
            System.out.println("The insurance number is invalid!");
        }
    }

    public void showAllInsuranceCard() {
        for (int j = 0; j < insuranceCardList.size(); j++) {
            System.out.println(insuranceCardList.get(j));
        }
    }

    public void viewAllPolicyHolder() {
        System.out.println("Policy Holder:");
        for (int i = 0; i < policyHolderList.size(); i++) {
            System.out.println(policyHolderList.get(i));
        }
    }

    public void viewAllDependent() {
        System.out.println("Customer.Dependent:");
        for (int i = 0; i < dependentList.size(); i++) {
            System.out.println(dependentList.get(i));
        }
    }

    public void viewClaimId() {
        System.out.println("All Claim ID: ");
        for (int j = 0; j < claimList.size(); j++) {
            System.out.println(claimList.get(j).getClaimID());
        }
    }


}



