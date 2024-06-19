Obligatorio Programación II 
Domenico Federico - Juan Folle


Para cargar los datos, creamos una clase CSVReader y utilizamos una clase de Java llamada BufferedReader, la cual nos permitió leer el archivo .csv que nos fue proporcionado.
Para almacenar las canciones, decidimos utilizar varios tads distintos, teniendo en cuenta que datos de las canciones nos iban a interesar más adelante. 
También creamos una clase Song y una clase Artist para poder trabajar mejor con sus atributos. 

Por otra parte, para realizar los reportes, creamos la clase Methods, en la cuál utilizamos los tads instanciados en el CSVReader e hicimos un método para cada reporte.

Por último, creamos el menú, el cual llama a la clase CSVReader para que los datos queden almacenados en los tads y luego los instanciamos con sus debidos getters.
Para terminar creamos el bucle que permite acceder a cada método y agregamos otras cosas para que la interfaz quede más prolija.