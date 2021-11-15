import java.util.Random;
/**
 *    
 */
public class PracticaBucles {
    private final char ESPACIO = ' ';
    private final char CARACTER = '\u0040';
    private Random generador;

    /**
     * Constructor  
     */
    public PracticaBucles()    {
        generador = new Random();
    }

    /**
     *  El método  genera  números aleatorios  entre -1000 y 5000 (inclusive)
     *  y calcula y escribe:
     *      - la media de todos los números
     *      - la suma de los impares
     *      - el máximo de los pares
     *        
     *  El proceso termina cuando sale un 0 o bien se han escrito n nºs
     *  
     *  Los números se escriben  en filas de 5 columnas 
     *  Cada nº aleatorio se muestra en un espacio de 12 posiciones en la pantalla  
     *  y al lado de cada nº se muestra otro nº con las mismas cifras y 
     *  en el mismo orden pero sin ceros (en 5 posiciones)
     *  
     *   Utiliza solo bucles while
     */
    public void generarNumeros(int n)   {
        int numsGenerados = 0;
        int sumaMedia = 0;
        int sumaImpares = 0;
        int max = 0;
        System.out.println("\nNº maximo de aleatorios a generar " + n + "\n" + 
            "o hasta que salga el 0\n");
        int aleatorio = generador.nextInt(6001) + (-1000);
        while(numsGenerados < n || aleatorio == 0){
            int contador = 0;
            while(contador < 5 && numsGenerados != n){
                aleatorio = generador.nextInt(6001) + (-1000);
                sumaMedia = sumaMedia + aleatorio + obtenerNumeroSinCeros(aleatorio);
                System.out.printf("%12d:%5d",aleatorio,obtenerNumeroSinCeros(aleatorio));
                if(esImpar(aleatorio) || esImpar(obtenerNumeroSinCeros(aleatorio))){
                    sumaImpares = sumaImpares + aleatorio + obtenerNumeroSinCeros(aleatorio);
                }
                if(esImpar(aleatorio) == false){
                    max = Math.max(max,aleatorio);
                }
                contador++;
                numsGenerados++;
            }
            System.out.println();
        }
        double media = sumaMedia / (n * 2);
        System.out.printf("\n%25s%10.2f\n%25s%10d\n%25s%10d","Media:",media,
            "Suma impares:",sumaImpares,"Maximo pares:",max);
    }

    /**
     *  Devuelve true si numero es impar, false en otro caso
     *  Hazlo sin utilizar if
     */
    public boolean esImpar(int numero)   {
        return numero % 2 != 0;
    }

    /**
     *  Dado un nº genera y devuelve otro nuevo 
     *  con las mismas cifras y en el mismo orden pero sin 
     *  los 0
     *  Ej - si numero = 2040 devuelve  24, si numero = 1009 devuelve  19
     *  si numero = 3000 devuelve 3
     *   
     *   
     */
    public int obtenerNumeroSinCeros(int numero)   {
        int num = 0;
        int exp = 0;
        while(numero != 0){
            int cifra = numero % 10;
            if(cifra == 0){
                numero /= 10;
            }
            else{
                num = num + (int)Math.pow(10,exp) * cifra;
                numero /= 10;
                exp++;
            }
        }
        return num;
    }

    /**
     *  Borrar la pantalla
     *
     */
    public void borrarPantalla()    {
        System.out.println('\u000C');
    }

    /**
     *  
     *  Dibuja la letra N (ver figura en el enunciado)
     *  Con bucles for
     *  
     *  Hay que usar el método escribirCaracter()
     *  
     *  
     *   
     */
    public void escribirLetraN(int altura)    {
    }

    /**
     *  escribe n veces el caracter  indicado en la misma línea
     *  con bucles for
     */
    private void escribirCaracter(char caracter, int n)    {

    }
}
