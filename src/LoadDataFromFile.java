import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadDataFromFile {
    private String fileName;
    public LoadDataFromFile(String fileName) {
        this.fileName = fileName;
    }

    public List<String[]> loadDataFromFile(){
        List<String[]> listOfData = new ArrayList<>();

        try {
            File file = new File(fileName);

            if(!file.exists()){
                System.out.println("The file is not found");

            }
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()){
                String line = fileScanner.nextLine().trim();
                if(!line.isEmpty()) {
                    String[] parts = line.split(",");
                    listOfData.add(parts);
                }
            }

            fileScanner.close();
        }

        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return listOfData;

    }




}
