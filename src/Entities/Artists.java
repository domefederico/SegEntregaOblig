package Entities;

public class Artists {
    // H


    public String devolve(int num, String linea) {          // num es 1 si es id, 2 si es nombre
        int o = 0;
        for (char c : linea.toCharArray()) {
            if (c == '"') {
                o++;
            }
            if (o == 2*num - 1) {

            }
        }


        return null;
    }

    // id = devolve(1,datos(i))
    // nombre = devolve(2,datos(i))
}
