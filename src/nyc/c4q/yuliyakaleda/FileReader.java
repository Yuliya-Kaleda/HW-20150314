package nyc.c4q.yuliyakaleda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olgakoleda on 3/11/15.
 */
public class FileReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.FileReader("countries.txt"));
        String line = null;
        List<String> countries = new ArrayList<String>();
        while((line = br.readLine()) != null) {
            countries.add(line);
        }
        System.out.println(countries.toArray());
    }
}
