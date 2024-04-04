import jdk.internal.classfile.BufWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public static void main(String[] args) {

        ClaimOfCustomer claimManager = new ClaimOfCustomer();
        ArrayList<Customer> cusInfos = new ArrayList<>();
        ArrayList<Claim> claimInfos = new ArrayList<>();
        ArrayList<InsuranceCard> insuranceInfos = new ArrayList<>();
        try {

            File file = new File("C:\\RMIT Programing\\Java Programming\\asm1\\src\\customer.txt");

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("File not found.");
                return;
            }

            Scanner scanFile = new Scanner(file);
            //Customer[] cusInfos = new Customer[100];
//            ArrayList<Customer> cusInfos = new ArrayList<>();
//            int index = 0;

            while (scanFile.hasNextLine()) {
                String line = scanFile.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+", 2);
                if (parts.length < 2) {
                    continue;
                }
                String cusID = parts[0].trim();
                String cusName = parts[1].trim();

                Customer cusInfo = new PolicyHolder(cusID, cusName);
//                cusInfos[index] = cusInfo;
                cusInfos.add(cusInfo);
//                index++;
            }

            scanFile.close();

        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }

        try {

            File file = new File("C:\\RMIT Programing\\Java Programming\\asm1\\src\\claim.txt");

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("File not found.");
                return;
            }

            Scanner scanFile = new Scanner(file);
            //Customer[] cusInfos = new Customer[100];
//            ArrayList<Claim> claimInfos = new ArrayList<>();
//            int index = 0;

            while (scanFile.hasNextLine()) {
                String line = scanFile.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+", 3);
                if (parts.length < 3) {
                    continue;
                }
                String claimID = parts[0].trim();
                String examDate = parts[1].trim();
                double claimAmount = Double.parseDouble(parts[2].trim());

                Claim claimInfo = new Claim(claimID, examDate, claimAmount);
//                cusInfos[index] = cusInfo;
                claimInfos.add(claimInfo);
//                index++;
            }

            scanFile.close();

        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }


        try {

            File file = new File("C:\\RMIT Programing\\Java Programming\\asm1\\src\\insuranceCard.txt");

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("File not found.");
                return;
            }

            Scanner scanFile = new Scanner(file);

            while (scanFile.hasNextLine()) {
                String line = scanFile.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+", 3);
                if (parts.length < 3) {
                    continue;
                }
                String cardNumber = parts[0].trim();
                String policyOwner = parts[1].trim();
                String exiprationDate = parts[2].trim();

                InsuranceCard insuranceInfo = new InsuranceCard(cardNumber, policyOwner, exiprationDate);
//                cusInfos[index] = cusInfo;
                insuranceInfos.add(insuranceInfo);
//                index++;
            }

            scanFile.close();

        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }

        System.out.println("Enter the CusID: ");
        Scanner scanner = new Scanner(System.in);
        String cusID = scanner.nextLine();

        boolean foundCustomer = false;

        for (int i = 0; i < cusInfos.size(); i++) {
            if (cusID.equals(cusInfos.get(i).getCusID())) {
                foundCustomer = true;

                    System.out.println("Enter the InsuranceCard ");
                    String claimID = scanner.nextLine();

//                    if (claimID.equals("quit")) {
//                        System.out.println("Exiting claim input.");
//                        break; // Exit the claim input loop if the user types 'quit'
//
//                    }

                    boolean foundClaim = false;

                    for (int j = 0; j < insuranceInfos.size(); j++) {
                        if (claimID.equals(insuranceInfos.get(j).getCardNumber())) {
                            cusInfos.get(i).addInsuranceCard(insuranceInfos.get(j));
                            cusInfos.get(i).showInfo();
                            insuranceInfos.get(j).setCardHolder(cusInfos.get(i));
                            foundClaim = true;
//                            break; // Exit the claim search loop if claim found
                        }
                    }

                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }

            }
        }
//
//        System.out.println("Enter the customerID: ");
//        String cusID1 = scanner.nextLine();
//
//        for (int i = 0; i < cusInfos.size(); i++){
//            if(cusID1.equals(cusInfos.get(i).getCusID())){
//                cusInfos.get(i).showInfo();
//
//            }
//        }
        if (!foundCustomer) {
            System.out.println("Customer with ID " + cusID + " not found.");
        }


        System.out.println("Enter the CusID: ");
        String cusID2 = scanner.nextLine();

        boolean foundCustomer2 = false;

        for (int i = 0; i < cusInfos.size(); i++) {
            if (cusID.equals(cusInfos.get(i).getCusID())) {
                foundCustomer2 = true;

                while (true) {
                    System.out.println("Enter the claimID (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting claim input.");
                        break; // Exit the claim input loop if the user types 'quit'

                    }

                    boolean foundClaim = false;

                    for (int j = 0; j < claimInfos.size(); j++) {
                        if (claimID.equals(claimInfos.get(j).getClaimID())) {
                            cusInfos.get(i).addClaim(claimInfos.get(j));
//                            cusInfos.get(i).showInfo();
                            claimInfos.get(j).setInsuredPerson(cusInfos.get(i));
                            claimInfos.get(j).setCardNumber();
                            foundClaim = true;
//                            break; // Exit the claim search loop if claim found
                        }
                    }

                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }
                }

                break; // Exit the customer search loop once customer found
            }
        }

        System.out.println("Enter the customerID: ");
        String cusID3 = scanner.nextLine();

        for (int i = 0; i < cusInfos.size(); i++){
            if(cusID3.equals(cusInfos.get(i).getCusID())){
                cusInfos.get(i).showInfo();

            }
        }
        if (!foundCustomer) {
            System.out.println("Customer with ID " + cusID + " not found.");
        }






    }

}
