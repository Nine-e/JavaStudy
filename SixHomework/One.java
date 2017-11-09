package SixHomework;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
/**
 * Created by del on 2017/11/4.
 */
public class One {
    public static void main (String[] args)throws Exception{
        File infile = new File("plaintext.txt");
        FileReader inFile = new FileReader(infile);
        File outfile = new File("ciphertext.txt");
        FileWriter outputFile = new  FileWriter(outfile);
        int ch = inFile.read();

        while (ch!=-1){
            outputFile.write(ch+2);
            ch = inFile.read();
        }

        inFile.close();
        outputFile.close();
    }
}
