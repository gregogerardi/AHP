package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Score;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class VentanaResultados extends JFrame {

	private JPanel contentPane;
	private JLabel lblResultadosObtenidos;
	private JTextPane textoSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaResultados frame = new VentanaResultados();
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
	public VentanaResultados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblResultadosObtenidos = new JLabel("Resultados obtenidos");
		lblResultadosObtenidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadosObtenidos.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblResultadosObtenidos.setBounds(0, 16, 722, 20);
		contentPane.add(lblResultadosObtenidos);
		
		textoSalida = new JTextPane();
		textoSalida.setBounds(120, 68, 491, 352);
		contentPane.add(textoSalida);
		
	}
	
	public void mostrarResultados(List<Score> resultados){
		textoSalida.setText("hola");
	}
}
