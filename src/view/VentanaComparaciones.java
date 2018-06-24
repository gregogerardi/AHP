package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Criterio;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class VentanaComparaciones extends JFrame {

	private JPanel contentPane;
	private Controller controlador;
	private List<JSlider> sliders;
	private List<Criterio> criterios;
	private JTextField textField;
	private Hashtable<Integer, String> escala;
	private JPanel panel;
	private JScrollPane scrollpane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaComparaciones(Controller c, List<Criterio> criterios, VentanaInicial v) {
		v.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		controlador = c;
		sliders = new ArrayList<>();
		this.criterios = criterios;	

		escala = new Hashtable<>();
		escala.put(1,"levemente mas importante");
		escala.put(2, "levemente mas importante");
		escala.put(3, "un poco mas importante");
		escala.put(4, "un poco mas importante");
		escala.put(5, "mas importante");
		escala.put(6, "mas importante");
		escala.put(7, "mucho mas importante");
		escala.put(8, "mucho mas importante");
		escala.put(9, "extremadamente mas importante");
	
		panel = new JPanel();
		scrollpane = new JScrollPane(panel);
		scrollpane.setBounds(100,80,626,350);
		contentPane.add(scrollpane);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		this.mostrarComparaciones(criterios);
			
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlador.setCriterios(criterios);
				controlador.buscar();
				}
		});
		btnBuscar.setBounds(611, 471, 115, 29);
		contentPane.add(btnBuscar);
		
		JLabel lblquTeParece = new JLabel("\u00BFQu\u00E9 te parece m\u00E1s importante?");
		lblquTeParece.setHorizontalAlignment(SwingConstants.CENTER);
		lblquTeParece.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblquTeParece.setBounds(0, 4, 825, 34);
		contentPane.add(lblquTeParece);		
	}
	
	private void mostrarComparaciones(List<Criterio> criterios){
		for (int i=0; i<criterios.size()-1; i++){
			for (int j=i+1; j<criterios.size(); j++){
				Criterio c1 = criterios.get(i);
				Criterio c2 = criterios.get(j);
				String crit1 = c1.getNombre();
				String crit2 = c2.getNombre();
				JLabel titulo = new JLabel(crit1+ " vs "+ crit2);
				titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
				JSlider s = new JSlider();
				c1.setComparacion(c2, s);  //CADA CRITERIO TIENE UNA REFERENCIA AL SLIDER QUE LE CORRESPONDE CON OTRO CRITERIO
			    sliders.add(s); // Faltaba agregarlo a la lista de sliders
				s.setMaximum(9);
				s.setMinimum(-9);
				s.setValue(0);
				s.setSize(10, 10);
				panel.add(titulo);
								
				JLabel descripcion = new JLabel(crit1+ " y "+ crit2+" son igual de importantes");
				descripcion.setFont(new Font("Tahoma", Font.PLAIN, 17));
				s.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent e) {
						String texto;
						int valor= s.getValue();
						if((valor<=1)&&(valor>=-1))
							texto= crit1 + " y " + crit2 +  " son igual de importantes";
						else{
							if(valor>1)
								texto= crit1+ " es "+ escala.get(valor)+" que "+crit2;
							else
								texto= crit2+ " es "+escala.get(-valor)+" que "+crit1;
						}
						descripcion.setText(texto);
					}
				});
				panel.add(descripcion);
				panel.add(s);	
				
			}	
			List<Criterio> subcriterios = criterios.get(i).getSubcriterios();
			if (subcriterios != null){
				this.mostrarComparaciones(subcriterios);
			}			
		}
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				List<Double> puntajes = new ArrayList<>();
				for (JSlider s : sliders){
					Double valor=(double) s.getValue();
					if (valor<0)
						puntajes.add(1/valor);
					else {
						if(valor==0)
							puntajes.add(1.0);
						else
							puntajes.add(valor);
					}
				}
				System.out.println(puntajes);
				controlador.setCriterios(criterios);
				controlador.buscar();
			}
		});
	}
}
