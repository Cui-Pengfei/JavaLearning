package cpf.learn.chapter17.music;

import org.junit.jupiter.api.Test;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * @author CPF 创建于： 2021/7/18 21:59
 * @version 1.0
 */
public class Audio{
	private String wavPath;

	@Test
	public void play(){
		wavPath = "src/cpf/learn/chapter17/music/startMusic.wav";

		File soundFile = new File(wavPath);

		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}

		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		auline.start();
		int nBytesRead = 0;
		//这是缓冲
		byte[] abData = new byte[512];

		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}
	}
}
