import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonido implements Runnable{
	
	private static int contador = 1;
	
	private String path;
	private String nombre;
	private int id;
	private Clip clip;
	private AudioInputStream audioInputStream;
	
	public Sonido(String nombre, String path) {;
		try {
			setFormatedClip(path);		
			this.id = contador++;
			this.path = path;
			this.nombre = nombre;	
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
			System.out.println("ERROR: No fue posible crear el sonido");
		}
	}


	public String getNombre() {
		return this.nombre;
	}
	

	public void setFormatedClip(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		File file = new File(path);
		this.audioInputStream = AudioSystem.getAudioInputStream(file);
		Clip clip = null;
	    AudioFormat format = new AudioFormat(
	    		AudioFormat.Encoding.PCM_SIGNED,
	            44100, //Hz
	            16, 
	            2, 
	            4,
	            AudioSystem.NOT_SPECIFIED, true);
	    DataLine.Info info = new DataLine.Info(Clip.class, format);
	    clip = (Clip) AudioSystem.getLine(info);
	    this.clip = clip;
	}
	
	public void play() throws InterruptedException, LineUnavailableException, IOException {
		if(!this.path.isEmpty()){
	        clip.open(audioInputStream);
	        long length = clip.getMicrosecondLength();
	        clip.start();
	        do {
	            Thread.sleep(length);
	        } while (clip.isRunning());
	        clip.close();
	        clip.drain();
		}
	}
	
	
	@Override 
	public void run() {
		try {
			play();
		} catch (InterruptedException | LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public String toString() {
		String info;
		if(clip == null) {
			info = "Sonido no pudo ser inicializado correctamente";
		}else {
			info = this.id + " " +this.nombre;
			info += "\nUbicación del archivo " + this.path;
			info += "\nFormato  " + this.clip.getFormat();
		}
		return info;
	}

}
