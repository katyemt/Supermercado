package PRINCIPAL;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ImagenFondo;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class menu extends JFrame {

	private JPanel contentPane;
	public InputStream imagen= this.getClass().getResourceAsStream("/imagenes/imagen.jpg");
	clienteForm fr1=new clienteForm();
	private JMenuItem mntmCliente;
	private JMenuItem mntmSalir;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menu() {
		inicializar();
		cargarImagen(desktopPane,imagen);
		eventos();
	}
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmCliente = new JMenuItem("Cliente");
		mnMantenimiento.add(mntmCliente);
		
		mntmSalir = new JMenuItem("Salir");
		mnMantenimiento.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
	public void eventos()
	{
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fr1.isShowing())
				{
					
				}
				else
				{
					desktopPane.add(fr1);
					Dimension desktopSize = desktopPane.getSize();
			        Dimension FrameSize = fr1.getSize();
			        fr1.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
					fr1.show();
				}
			}
		});
		
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
	}
	public void salir()
	{
		int n=JOptionPane.showConfirmDialog(rootPane, "Desea salir?","Salir",JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION)
				{
					dispose();
				}
	}
	
	public void cargarImagen(javax.swing.JDesktopPane desktopPane, InputStream fileImagen)
	{
		try
		{		
			BufferedImage  image= ImageIO.read(fileImagen);
			desktopPane.setBorder(new ImagenFondo (image));
		}
		catch(Exception e)
		{
			System.out.println("imagen no disponible");
		}
		
		
	}
}
