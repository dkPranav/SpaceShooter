package spaceshooterpkg.src;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.io.InputStream;

import javax.imageio.ImageIO;



public class BufferedImageLoader {
	public BufferedImage image;
	
	public BufferedImage loadImage(String path) throws IOException {
		//java.net.URL fileUrl = getClass().getResource("/spritesheet.png");
		//InputStream fileInputStream = getClass().getResourceAsStream("/spritesheet.png");
		image =ImageIO.read(new File(path));
		return image;
	} 
	
}
