import Entities.Song;
import com.opencsv.*;
import com.opencsv.exceptions.*;

import java.io.*;
import java.util.List;

public class ParaProbar {
    public static void main(String[] args) throws IOException, CsvException {
        long startTime = System.currentTimeMillis();
        CSVReader csvReader = new CSVReader(new FileReader("data_set.csv"));
        List<String[]> datos = csvReader.readAll();
        //int i = 1;
        //while (datos.get(i)!=null){
        String[] linea;
        for(int i=1;i<10;i++){
            linea = datos.get(i)[0].split(",");
            for (int j = 0; j < linea.length; j++) {
                linea[j] = linea[j].replace("\"", "");
                linea[j] = linea[j].replace(";", "");
            }
            Song song = new Song(linea[0], linea[1], linea[2], Integer.parseInt(linea[3]), Integer.parseInt(linea[4]), Integer.parseInt(linea[5]), linea[6], linea[7], Integer.parseInt(linea[8]), Boolean.parseBoolean(linea[9]), Integer.parseInt(linea[10]), linea[11], linea[12], Float.parseFloat(linea[13]), Float.parseFloat(linea[14]), Integer.parseInt(linea[15]), Float.parseFloat(linea[16]), Integer.parseInt(linea[17]), Float.parseFloat(linea[18]), Float.parseFloat(linea[19]), Float.parseFloat(linea[20]), Float.parseFloat(linea[21]), Float.parseFloat(linea[22]), Float.parseFloat(linea[23]), Integer.parseInt(linea[24]));
            //i++;
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + duration + " ms");
    }
}

