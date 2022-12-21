public class SubclaseThread extends Thread {
    //PARA CREAR UN HILO, PODEMOS HACERLO EXTENDIENDO 'SubclaseThread' DE LA CLASE 'Thread'

    //CREAMOS LOS DOS ATRIBUTOS Y SE LE PONE STATIC A CONTADOR PARA QUE SEA UN ATRIBUTO DE CLASE (SU VALOR ES EL MISMO INDEPENDIENTEMENTE DEL OBJETO QUE ACCEDA A ÉL); A CADENA NO SE LE PONE NADA PORQUE ES UN ATRIBUTO DE OBJETO
    static int contador = 0;
    String cadena;

    //EL CONSTRUCTOR DEL HILO:
    public SubclaseThread(String cadena) {
        super(cadena);
        this.cadena = cadena;
    }

    //CREAMOS EL MÉTODO RUN() QUE ESPECIFICA LO QUE HARÁ EL HILO UNA VEZ LO INICIEMOS
    //EN ESTE CASO ESCRIBE DIEZ VECES EL CONTADOR (DEL 0 AL 10) SEGUIDO DEL VALOR DE LA CADENA
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            contador++;
            System.out.println(contador +" "+ cadena);
        }
    }

    //CREAMOS UN MAIN E INICIAMOS EL HILO CON START()
    public static void main(String[] args) {
        //CREAMOS EL GRUPO DE HILOS CON ThreadGroup
        ThreadGroup grupoPSP = new ThreadGroup("Un grupo de hilos");
        //CREAMOS DOS HILOS DE NUESTRA CLASE, LA QUE EXTIENDE DE THREAD, QUE PIDE POR PARÁMETRO UNA CADENA
        SubclaseThread h1 = new SubclaseThread("SÍ");
        SubclaseThread h2 = new SubclaseThread("NO");
        //CREAMOS OTROS DOS HILOS DE CLASE THREAD (QUE NO PIDE CADENA POR PARÁMETRO) PERO INCLUYENDO LOS DOS PRIMEROS HILOS
        //EN EL GRUPO QUE HEMOS CREADO DE LA SIGUIENTE MANEERA:
        Thread hilo1 = new Thread(grupoPSP, h1, "hilo 1");
        Thread hilo2 = new Thread(grupoPSP, h2, "hilo 2");
        //INICIAMOS LOS HILOS PERTENECIENTES AL GRUPO:
        hilo1.start();
        hilo2.start();
    }


}
