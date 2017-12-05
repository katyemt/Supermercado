package PRINCIPAL;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import DAO.clienteDAO;
import DAO.clienteVO;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clienteForm extends JInternalFrame {
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtRuc;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JButton btnSalir;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnGrabar;
	private JButton btnNuevo;
	private JPanel panel_1;
	private JButton btnPrimero;
	private JButton btnSiguiente;
	private JButton btnAtras;
	private JButton btnUltimo;
	
	clienteDAO objclienteDao=new clienteDAO();
	ResultSet rsCliente;
	boolean sw;
	private JButton btnCancelar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clienteForm frame = new clienteForm();
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
	public clienteForm() {
		inicializar();
		cargaRegistro();
		mostrarRegistro();
		eventos();
	}
	public void inicializar() {
		getContentPane().setBackground(new Color(128, 128, 128));
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 419, 300);
		getContentPane().setLayout(null);
		
		JLabel lblMantenimientoDeClientes = new JLabel("MANTENIMIENTO DE CLIENTES");
		lblMantenimientoDeClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMantenimientoDeClientes.setBounds(106, 11, 222, 14);
		getContentPane().add(lblMantenimientoDeClientes);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(24, 56, 46, 14);
		getContentPane().add(lblCodigo);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(24, 82, 46, 14);
		getContentPane().add(lblNombres);
		
		JLabel lblRuc = new JLabel("Ruc");
		lblRuc.setBounds(24, 107, 46, 14);
		getContentPane().add(lblRuc);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(24, 138, 46, 14);
		getContentPane().add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(24, 163, 46, 14);
		getContentPane().add(lblTelefono);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(106, 53, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(106, 79, 150, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtRuc = new JTextField();
		txtRuc.setBounds(106, 104, 86, 20);
		getContentPane().add(txtRuc);
		txtRuc.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(106, 135, 150, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(106, 160, 86, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(306, 36, 80, 171);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(6, 1, 0, 0));
		
		btnNuevo = new JButton("Nuevo");
		panel.add(btnNuevo);
		
		btnGrabar = new JButton("Grabar");
		panel.add(btnGrabar);
		
		btnEditar = new JButton("Editar");
		panel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);
		
		btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		btnSalir = new JButton("Salir");
		panel.add(btnSalir);
		
		panel_1 = new JPanel();
		panel_1.setBounds(24, 229, 304, 31);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnPrimero = new JButton("<<");
		panel_1.add(btnPrimero);
		
		btnSiguiente = new JButton(">");
		panel_1.add(btnSiguiente);
		
		btnAtras = new JButton("<");
		panel_1.add(btnAtras);
		
		btnUltimo = new JButton(">>");
		panel_1.add(btnUltimo);
	
	}
	public void eventos()
	{
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					rsCliente.first();
					mostrarRegistro();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rsCliente.next();
					if(rsCliente.isAfterLast())
					{
						rsCliente.last();
					}
					mostrarRegistro();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rsCliente.previous();
					if(rsCliente.isBeforeFirst())
					{
						rsCliente.first();
					}
					mostrarRegistro();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rsCliente.last();
					mostrarRegistro();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitaControles(true);
				limpiar();
				getRootPane().setDefaultButton(btnCancelar);
				sw=true;
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grabar();
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	private void grabar()
	{	try {
			clienteVO objclienteVO=new clienteVO();
			objclienteVO.setCodigo(txtCodigo.getText());
			objclienteVO.setNombre(txtNombres.getText());
			objclienteVO.setRuc(txtRuc.getText());
			objclienteVO.setDire(txtDireccion.getText());
			objclienteVO.setTele(txtTelefono.getText());
			
			if(sw)
				{	
				objclienteDao.insert(objclienteVO);	
				JOptionPane.showMessageDialog(null, "Registro guardado");
				limpiar();
				}
			else
			{	objclienteVO.setCodigo(txtCodigo.getText());
				objclienteDao.actual(objclienteVO);
				JOptionPane.showMessageDialog(null, "Registro actualizado");
			}
			cargaRegistro();
			mostrarRegistro();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	private void cancelar()
	{
		habilitaControles(false);
		limpiar();
		getRootPane().setDefaultButton(btnNuevo);
		cargaRegistro();
		mostrarRegistro();
	}

	private void habilitaControles(boolean b)
	{
		txtCodigo.setEditable(b);
		txtNombres.setEditable(b);
		txtRuc.setEditable(b);
		txtDireccion.setEditable(b);
		txtTelefono.setEditable(b);
		JButton[] control={btnPrimero,btnAtras,btnSiguiente,btnUltimo,
					btnEditar,btnEliminar};
		for(JButton objButton: control)
		{
			objButton.setEnabled(b);
		}
		btnGrabar.setEnabled(b);
		btnCancelar.setEnabled(b);
		txtNombres.grabFocus();
	}

