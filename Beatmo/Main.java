public class Main {

	public static void main(String[] args) throws Exception{
		Sonido sonido = new Sonido("platillo","../resources/crashbell.wav");
		Thread hilo = new Thread(sonido);
		hilo.start();
	}
}
