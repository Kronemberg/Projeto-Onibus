package Checking.gui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Imagem extends JPanel {
	
	//ImageIcon Marcar = new ImageIcon(getClass().getResource("image/icone nome.png"));
	
	@Override
	protected void paintComponent(Graphics g) {
		try {
			InputStream imageInputStream = getClass().getResourceAsStream("image/TelaBilhete.jpg");
			BufferedImage ImageFundo = ImageIO.read(imageInputStream);
			Image Redimencionada = ImageFundo.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
			g.drawImage(Redimencionada, 0, 0, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
	
	static class MarcarImagem extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			try {
				InputStream imageInputStream = getClass().getResourceAsStream("image/TelaMarcar.jpg");
				BufferedImage ImageFundo = ImageIO.read(imageInputStream);
				Image Redimencionada = ImageFundo.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
				g.drawImage(Redimencionada, 0, 0, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
		}
	}
	
	static class InicialImagem extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			try {
				InputStream imageInputStream = getClass().getResourceAsStream("image/TelaInicial.jpg");
				BufferedImage ImageFundo = ImageIO.read(imageInputStream);
				Image Redimencionada = ImageFundo.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
				g.drawImage(Redimencionada, 0, 0, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
		}
	}
	
	static class ProcurarImagem extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			try {
				InputStream imageInputStream = getClass().getResourceAsStream("image/TelaProcurar.jpg");
				BufferedImage ImageFundo = ImageIO.read(imageInputStream);
				Image Redimencionada = ImageFundo.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
				g.drawImage(Redimencionada, 0, 0, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
		}
	}
	
	static class AlterarImagem extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			try {
				InputStream imageInputStream = getClass().getResourceAsStream("image/TelaAlterar.jpg");
				BufferedImage ImageFundo = ImageIO.read(imageInputStream);
				Image Redimencionada = ImageFundo.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
				g.drawImage(Redimencionada, 0, 0, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
		}
	}
}

