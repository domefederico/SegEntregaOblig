import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.List;

public class ParaProbar {
    public static void main(String[] args) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader("data_set.csv"));
        List<String[]> datos = csvReader.readAll();
//        for (int i = 0 ; i< datos.size() ; i++){
//            for (int j=0 ; j< datos.get(i)[0].length();j++) {
//                char c = datos.get(i)[0].charAt(j);
//            }
//        }
    }
}
