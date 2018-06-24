package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Criterio;
import model.CriterioCompuesto;
import model.CriterioSimple;
import model.filtros.Filtro;
import model.filtros.Igual;
import model.filtros.Menor;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.VetoableChangeListener;

public class VentanaInicial extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPrecio;
	private JTextField textFieldAutonomia;
	private static Controller controlador;
	private List<Criterio> criterios;
	private static VentanaInicial vi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controlador = new Controller();
					VentanaInicial frame = new VentanaInicial();
					vi = frame;
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
	public VentanaInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		setTitle("Pc Browser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		criterios = new ArrayList<>();
		
////////////////////////////TITULO///////////////////////////////////////////////////
		JLabel lblquAndsBuscando = new JLabel("\u00BFQu\u00E9 est\u00E1s buscando?");
		lblquAndsBuscando.setHorizontalAlignment(SwingConstants.CENTER);
		lblquAndsBuscando.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblquAndsBuscando.setBounds(15, 16, 795, 29);
		contentPane.add(lblquAndsBuscando);
		
		
////////////////////////////FILTROS/////////////////////////////////////////////////		

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setBounds(50, 156, 69, 20);
		contentPane.add(lblMarca);
		
		JComboBox listMarcas = new JComboBox();
		listMarcas.setModel(new DefaultComboBoxModel(new String[] {"Cualquiera", "Acer", "Compaq", "Dell", "HP", "Lenovo", "Mac", "Samsung", "Vaio"}));
		listMarcas.setBounds(135, 154, 146, 26);
		contentPane.add(listMarcas);
		
		JLabel lblUsos = new JLabel("Usos");
		lblUsos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsos.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsos.setBounds(611, 94, 125, 20);
		contentPane.add(lblUsos);
		
		JLabel lblProgramacin = new JLabel("Programacion");
		lblProgramacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgramacin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProgramacin.setBounds(600, 130, 155, 20);
		contentPane.add(lblProgramacin);
		
		JRadioButton rdbtnNulo = new JRadioButton("Nulo");
		rdbtnNulo.setBounds(562, 153, 69, 29);
		contentPane.add(rdbtnNulo);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Medio");
		rdbtnNewRadioButton.setBounds(638, 153, 83, 29);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnAlto = new JRadioButton("Alto");
		rdbtnAlto.setBounds(728, 153, 73, 29);
		contentPane.add(rdbtnAlto);
		
		JLabel lblEdicinAudiovisual = new JLabel("Edici\u00F3n audiovisual");
		lblEdicinAudiovisual.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdicinAudiovisual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEdicinAudiovisual.setBounds(600, 197, 155, 20);
		contentPane.add(lblEdicinAudiovisual);
		
		JRadioButton rdbtnNulo_1 = new JRadioButton("Nulo");
		rdbtnNulo_1.setBounds(562, 229, 69, 29);
		contentPane.add(rdbtnNulo_1);
		
		JRadioButton rdbtnMedio = new JRadioButton("Alto");
		rdbtnMedio.setBounds(728, 229, 73, 29);
		contentPane.add(rdbtnMedio);
		
		JRadioButton rdbtnMedio_1 = new JRadioButton("Medio");
		rdbtnMedio_1.setBounds(638, 229, 75, 29);
		contentPane.add(rdbtnMedio_1);
		
		JLabel lblRedesSociales = new JLabel("Redes sociales");
		lblRedesSociales.setHorizontalAlignment(SwingConstants.CENTER);
		lblRedesSociales.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRedesSociales.setBounds(600, 273, 155, 20);
		contentPane.add(lblRedesSociales);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Nulo");
		rdbtnNewRadioButton_2.setBounds(562, 305, 69, 29);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnMedio_2 = new JRadioButton("Medio");
		rdbtnMedio_2.setBounds(638, 305, 83, 29);
		contentPane.add(rdbtnMedio_2);
		
		JRadioButton rdbtnAlto_1 = new JRadioButton("Alto");
		rdbtnAlto_1.setBounds(728, 305, 155, 29);
		contentPane.add(rdbtnAlto_1);
		
		JLabel lblOffice = new JLabel("Office");
		lblOffice.setHorizontalAlignment(SwingConstants.CENTER);
		lblOffice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOffice.setBounds(600, 340, 155, 20);
		contentPane.add(lblOffice);
		
		JRadioButton rdbtnNulo_2 = new JRadioButton("Nulo");
		rdbtnNulo_2.setBounds(562, 372, 69, 29);
		contentPane.add(rdbtnNulo_2);
		
		JRadioButton rdbtnMedio_3 = new JRadioButton("Medio");
		rdbtnMedio_3.setBounds(638, 372, 83, 29);
		contentPane.add(rdbtnMedio_3);
		
		JRadioButton rdbtnAlto_2 = new JRadioButton("Alto");
		rdbtnAlto_2.setBounds(728, 372, 155, 29);
		contentPane.add(rdbtnAlto_2);
		
/////////////////////////////CRITERIOS////////////////////////////////////////////////////////

//precio//		
		JLabel lblprecio = new JLabel("Precio");
		lblprecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprecio.setBounds(15, 94, 155, 24);
		contentPane.add(lblprecio);
		CriterioSimple precio = new CriterioSimple(lblprecio.getText().toLowerCase());
		criterios.add(precio);
		
		textFieldPrecio = new JTextField();		
		textFieldPrecio.addVetoableChangeListener(new VetoableChangeListener() {
			public void vetoableChange(PropertyChangeEvent arg0) {
				precio.setValor(Double.valueOf(textFieldPrecio.getText()));

			}
		});
		textFieldPrecio.setText("0.0");
		textFieldPrecio.setBounds(135, 94, 146, 26);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);

		
//pantalla//		
		JLabel lblPantalla = new JLabel("Pantalla");
		lblPantalla.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPantalla.setBounds(50, 394, 69, 20);
		contentPane.add(lblPantalla);
		CriterioSimple pantalla = new CriterioSimple(lblPantalla.getText().toLowerCase());
		criterios.add(pantalla);

		JComboBox<Double> tamanio = new JComboBox<Double>();
		tamanio.setModel(new DefaultComboBoxModel<Double>(new Double[] {13.0, 13.5, 14.0, 14.5, 15.0, 15.5, 16.0}));
		tamanio.setBounds(135, 394, 146, 26);
		contentPane.add(tamanio);
		tamanio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				pantalla.setValor((Double)tamanio.getSelectedItem());
			}
		});


//autonomia
		JLabel lblAutonomia = new JLabel("Autonomia");
		lblAutonomia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutonomia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAutonomia.setBounds(24, 454, 95, 20);
		contentPane.add(lblAutonomia);
		CriterioSimple autonomia = new CriterioSimple(lblAutonomia.getText().toLowerCase());
		criterios.add(autonomia);
				
		textFieldAutonomia = new JTextField();
		textFieldAutonomia.setText("0.0");
		textFieldAutonomia.setBounds(135, 452, 73, 26);
		contentPane.add(textFieldAutonomia);
		textFieldAutonomia.setColumns(10);
		textFieldAutonomia.addVetoableChangeListener(new VetoableChangeListener() {
			public void vetoableChange(PropertyChangeEvent arg0) {
				autonomia.setValor(Double.valueOf(textFieldAutonomia.getText()));

			}
		});
		
		JLabel lblHs = new JLabel("hs");
		lblHs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHs.setBounds(212, 454, 38, 20);
		contentPane.add(lblHs);
		

//conectividad
		JLabel lblConectividad = new JLabel("Conectividad");
		lblConectividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblConectividad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConectividad.setBounds(381, 94, 125, 20);
		contentPane.add(lblConectividad);
		CriterioCompuesto conectividad = new CriterioCompuesto(lblConectividad.getText().toLowerCase());
		criterios.add(conectividad);
///wifi		
		JRadioButton rdbtnWifi = new JRadioButton("WiFi");
		
		rdbtnWifi.setBounds(381, 154, 155, 29);
		contentPane.add(rdbtnWifi);
		CriterioSimple wifi = new CriterioSimple(rdbtnWifi.getText().toLowerCase());
		conectividad.addSubcriterio(wifi);
		wifi.setPadre(conectividad);
		rdbtnWifi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (rdbtnWifi.isSelected())
					wifi.setValor(1.0);
			}
		});
		
///hdmi		
		JRadioButton rdbtnHdmi = new JRadioButton("HDMI");
		rdbtnHdmi.setBounds(381, 214, 83, 29);
		contentPane.add(rdbtnHdmi);
		CriterioSimple hdmi = new CriterioSimple(rdbtnHdmi.getText().toLowerCase());
		conectividad.addSubcriterio(hdmi);
		hdmi.setPadre(conectividad);
		rdbtnHdmi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (rdbtnHdmi.isSelected())
					hdmi.setValor(1.0);
			}
		});
///cd-dvd		
		JRadioButton rdbtnCddvd = new JRadioButton("CD/DVD");
		rdbtnCddvd.setBounds(381, 274, 95, 29);
		contentPane.add(rdbtnCddvd);
		CriterioSimple cd_dvd = new CriterioSimple(rdbtnCddvd.getText().toLowerCase());
		conectividad.addSubcriterio(cd_dvd);
		cd_dvd.setPadre(conectividad);
		rdbtnCddvd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (rdbtnCddvd.isSelected())
					cd_dvd.setValor(1.0);
			}
		});
///usb		
		JRadioButton rdbtnUsb = new JRadioButton("USB");
		rdbtnUsb.setBounds(381, 334, 69, 29);
		contentPane.add(rdbtnUsb);
		CriterioSimple usb = new CriterioSimple(rdbtnUsb.getText().toLowerCase());
		conectividad.addSubcriterio(usb);
		usb.setPadre(conectividad);
				
		JComboBox<Integer> cantUsb = new JComboBox<Integer>();		
		cantUsb.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0,1,2,3,4,5}));
		cantUsb.setBounds(456, 334, 50, 26);
		contentPane.add(cantUsb);
		cantUsb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				usb.setValor(1.0* (Integer)cantUsb.getSelectedItem());
			}
		});
		
///bluethoot
		JRadioButton rdbtnBluethoot = new JRadioButton("Bluethoot");
		rdbtnBluethoot.setBounds(381, 394, 105, 29);
		contentPane.add(rdbtnBluethoot);
		CriterioSimple bluethoot = new CriterioSimple(rdbtnBluethoot.getText().toLowerCase());
		conectividad.addSubcriterio(bluethoot);
		bluethoot.setPadre(conectividad);
		rdbtnBluethoot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (rdbtnBluethoot.isSelected())
					bluethoot.setValor(1.0);
			}
		});
		
		
//velocidad		
		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVelocidad.setBounds(24, 214, 95, 20);
		contentPane.add(lblVelocidad);
		CriterioSimple velocidad = new CriterioSimple(lblVelocidad.getText().toLowerCase());
		criterios.add(velocidad);
		
		JSlider sliderVelocidad = new JSlider();
		sliderVelocidad.setValue(0);
		sliderVelocidad.setBounds(135, 214, 146, 26);
		contentPane.add(sliderVelocidad);
		sliderVelocidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				velocidad.setValor((double) sliderVelocidad.getValue());
			}
		});

//peso
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPeso.setBounds(50, 274, 69, 20);
		contentPane.add(lblPeso);
		CriterioSimple peso = new CriterioSimple(lblPeso.getText().toLowerCase());
		criterios.add(peso);		
		
		JSlider sliderPeso = new JSlider();
		sliderPeso.setValue(0);
		sliderPeso.setBounds(135, 274, 146, 26);
		contentPane.add(sliderPeso);
		sliderPeso.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				peso.setValor((double) sliderPeso.getValue());
			}
		});
		
//capacidad		
		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCapacidad.setBounds(14, 334, 105, 20);
		contentPane.add(lblCapacidad);
		CriterioSimple capacidad = new CriterioSimple(lblCapacidad.getText().toLowerCase());
		criterios.add(capacidad);		
		
		JSlider sliderCapacidad = new JSlider();
		sliderCapacidad.setMaximum(1000000);
		sliderCapacidad.setMinimum(150);
		sliderCapacidad.setValue(0);
		sliderCapacidad.setBounds(135, 334, 146, 26);
		contentPane.add(sliderCapacidad);
		sliderPeso.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				capacidad.setValor((double) sliderCapacidad.getValue());
			}
		});
	
		

		JButton btnBuscar = new JButton("Siguiente");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Double preciomax = Double.valueOf(textFieldPrecio.getText());
				List <Filtro> filtros = new ArrayList<>();
				if (!preciomax.equals(0.0)){
					Filtro preciomenor = new Menor ("precio", preciomax);
					filtros.add(preciomenor);
				}
				if (!listMarcas.getSelectedItem().toString().equals("Cualquiera")){
					Filtro marcaigual = new Igual ("marca",listMarcas.getSelectedItem().toString());
					filtros.add(marcaigual);
				}
				//VER FILTROS DE LOS USOS DEPENDE DE LO QUE INVESTIGUEMOS DE LOS PROGRAMAS
				
				controlador.setFiltros(filtros);
				
				//PARA PASARLE CADA DATO INGRESADO AL CONTROLADOR
				List<Object> datos = new ArrayList<>();
				datos.add(sliderVelocidad.getValue());
				datos.add(sliderPeso.getValue());
				datos.add(sliderCapacidad.getValue());
				datos.add(Double.valueOf(textFieldAutonomia.getText()));
				datos.add(tamanio.getSelectedItem());
				//VER COMO HACER LO DE LA CONECTIVIDAD CON SUBCRITERIOS, LOS PONGO EN LA LISTA
				//
				datos.add(rdbtnWifi.isSelected());
				datos.add(rdbtnHdmi.isSelected());
				datos.add(rdbtnCddvd.isSelected());
				if (rdbtnUsb.isSelected())
					datos.add(cantUsb.getSelectedItem());
				else datos.add(0);
				datos.add(rdbtnBluethoot.isSelected());
				//
				controlador.setDatos(datos);
				VentanaComparaciones vc = new VentanaComparaciones(controlador, criterios, vi);
				vc.setVisible(true);
				vi.setVisible(false);
			
			}
			
		});
		btnBuscar.setBounds(621, 451, 115, 29);
		contentPane.add(btnBuscar);
		
	}
	
	
}

