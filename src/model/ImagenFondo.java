package model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class ImagenFondo implements Border {
	public BufferedImage imagen;
	
	public ImagenFondo(BufferedImage imagen)
	{
		this.imagen=imagen;
	}

	@Override
	public Insets getBorderInsets(Component c) {
		// TODO Auto-generated method stub
		return new Insets (0,0,0,0);
	}

	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	
		int x0= x+(width-imagen.getWidth())/2;
		int y0= y+(height-imagen.getHeight())/2;
		g.drawImage(imagen, x0, y0, null);
	}

	

	
	
	
}
