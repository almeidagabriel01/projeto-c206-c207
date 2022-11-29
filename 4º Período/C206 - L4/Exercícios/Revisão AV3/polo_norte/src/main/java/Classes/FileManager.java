package Classes;

import java.io.*;

public abstract class FileManager {
    public static void writeTxt(String filePath, String content) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void readTxt(String filePath) {
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line + " ");
                line = br.readLine();
            }
            br.close();
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}