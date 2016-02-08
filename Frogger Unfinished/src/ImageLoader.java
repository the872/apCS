import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;


public class ImageLoader {
		//loads an image that is ready for rendering
		public static BufferedImage loadCompatibleImage(String path) 
		{ 
			return getCompatibleImage(loadImage(path));
		} 
		
		//loads raw image data for manipulation before rendering
		public static BufferedImage loadImage(String path) 
		{ 
			try { 
				java.io.InputStream stream = ImageLoader.class.getResourceAsStream(path);
				BufferedImage img = javax.imageio.ImageIO.read(stream); 
				return img;
			} 	
			catch(Exception e) { 
				e.printStackTrace(); 
			} 
		 
			return null; 
		} 
		
		//creates a version of the image that is ready for rendering
		public static BufferedImage getCompatibleImage(Image img)
		{
			BufferedImage buff = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(img.getWidth(null), img.getHeight(null), BufferedImage.TRANSLUCENT);
			Graphics g = buff.getGraphics();
			
			g.drawImage(img, 0, 0, null);
			g.dispose();
			
			return buff;
		}
		
		//returns a resized version of the image
		public static BufferedImage resizeImage(BufferedImage img, int width, int height)
		{
			//if the image type is TYPE_CUSTOM, then we can't actually make a new image of that type
			//we'll make one of a "safer" type and then convert it back
			int type = img.getType();
			if(type == BufferedImage.TYPE_CUSTOM)
				type = BufferedImage.TYPE_INT_ARGB;
			
			BufferedImage resizedImage = new BufferedImage(width, height, type);
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(img, 0, 0, width, height, null);
			g.dispose();
			
			return getCompatibleImage(resizedImage);
		}
		
		public static BufferedImage getFlippedImage(Image img)
		{
			BufferedImage buff = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(img.getWidth(null), img.getHeight(null), Transparency.BITMASK);
			Graphics g = buff.getGraphics();
			
			g.drawImage(img, img.getWidth(null), 0, -img.getWidth(null), img.getHeight(null), null);
			g.dispose();
			
			return buff;
		}
		
		//splits a Sprite image into a 2D array of individual images
		//use for image files that contain rows and columns
		public static BufferedImage[][] splitImage(BufferedImage img, int rows, int cols) {
			//if the image type is TYPE_CUSTOM, then we can't actually make a new image of that type
			//we'll make one of a "safer" type and then convert it back
			int type = img.getType();
			if(type == BufferedImage.TYPE_CUSTOM)
				type = BufferedImage.TYPE_INT_ARGB;
			
			int w = img.getWidth()/cols;
			int h = img.getHeight()/rows;
			BufferedImage[][] imgs = new BufferedImage[rows][cols];
			for(int y = 0; y < rows; y++) {
				for(int x = 0; x < cols; x++) {
					imgs[y][x] = new BufferedImage(w, h, type);
					// Tell the graphics to draw only one block of the image
					Graphics g = imgs[y][x].createGraphics();
					g.drawImage(img, 0, 0, w, h, w*x, h*y, w*x+w, h*y+h, null);
					g.dispose();
					
					imgs[y][x] = getCompatibleImage(imgs[y][x]);
				}
			}
			return imgs;
		}
		
		//splits a Sprite image into a 1D array of individual images
		//use for image files that contain only a single row
		public static BufferedImage[] splitImage(BufferedImage img, int cols) {
			//if the image type is TYPE_CUSTOM, then we can't actually make a new image of that type
			//we'll make one of a "safer" type and then convert it back
			int type = img.getType();
			if(type == BufferedImage.TYPE_CUSTOM)
				type = BufferedImage.TYPE_INT_ARGB;
			
			int w = img.getWidth()/cols;
			int h = img.getHeight();
			BufferedImage[] imgs = new BufferedImage[cols];
			for(int x = 0; x < cols; x++) {
				imgs[x] = new BufferedImage(w, h, type);
				// Tell the graphics to draw only one block of the image
				Graphics g = imgs[x].createGraphics();
				g.drawImage(img, 0, 0, w, h, w*x, 0, w*x+w, h, null);
				g.dispose();
				
				imgs[x] = getCompatibleImage(imgs[x]);
			}
			return imgs;
		}
}
