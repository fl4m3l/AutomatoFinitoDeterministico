package modelos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excessoes.ResultadoFuncaoTransicaoInvalidoException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTable;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import net.miginfocom.swing.MigLayout;

public class Janela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<String> alfabeto = new ArrayList<>();
	private ArrayList<String> regrasTransicao = new ArrayList<>();
	private ArrayList<String> estadoFinal = new ArrayList<>();
	private JTextField textAlfabeto;
	private JTextField textNumeroEstados;
	private JTextField textRegrasTransicao;
	private JTextField textEstadoInicial;
	private JTextField textEstadoFinal;
	private JLabel lblEntrada;
	private JTextField textEntrada;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent arg0) {
			}
		});
		setTitle("Aut\u00F4mato Finito Determin\u00EDstico.");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 261);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[124px][255px]", "[20px][20px][20px][20px][20px][1px][20px][46px]"));
		
		table = new JTable();
		contentPane.add(table, "cell 0 5,alignx center,growy");
		
		JLabel lblAlfabeto = new JLabel("Alfabeto");
		lblAlfabeto.setForeground(new Color(255, 255, 0));
		lblAlfabeto.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblAlfabeto, "cell 0 0,alignx left,aligny center");
		
		textAlfabeto = new JTextField();
		textAlfabeto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(textAlfabeto, "cell 1 0,growx,aligny center");
		textAlfabeto.setColumns(10);
		
		JLabel lblNmeroDeEstados = new JLabel("N\u00FAmero de Estados");
		lblNmeroDeEstados.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNmeroDeEstados.setForeground(new Color(255, 255, 0));
		contentPane.add(lblNmeroDeEstados, "cell 0 1,growx,aligny center");
		
		textNumeroEstados = new JTextField();
		textNumeroEstados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(textNumeroEstados, "cell 1 1,growx,aligny center");
		textNumeroEstados.setColumns(10);
		
		JLabel lblRegrasDeTransio = new JLabel("Regras de Transi\u00E7\u00E3o");
		lblRegrasDeTransio.setForeground(new Color(255, 255, 0));
		lblRegrasDeTransio.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblRegrasDeTransio, "cell 0 2,growx,aligny center");
		
		textRegrasTransicao = new JTextField();
		textRegrasTransicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(textRegrasTransicao, "cell 1 2,growx,aligny center");
		textRegrasTransicao.setColumns(10);
		
		JLabel lblEstadoInicial = new JLabel("Estado Inicial");
		lblEstadoInicial.setForeground(new Color(255, 255, 0));
		lblEstadoInicial.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblEstadoInicial, "cell 0 3,growx,aligny center");
		
		textEstadoInicial = new JTextField();
		textEstadoInicial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(textEstadoInicial, "cell 1 3,growx,aligny center");
		textEstadoInicial.setColumns(10);
		
		JLabel lblEstadoFinal = new JLabel("Estado Final");
		lblEstadoFinal.setForeground(new Color(255, 255, 0));
		lblEstadoFinal.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblEstadoFinal, "cell 0 4,alignx left,aligny center");
		
		textEstadoFinal = new JTextField();
		textEstadoFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(textEstadoFinal, "cell 1 4,growx,aligny center");
		textEstadoFinal.setColumns(10);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String str : textAlfabeto.getText().split(", "))
					alfabeto.add(str);
				for (String str : textRegrasTransicao.getText().split(", "))
					regrasTransicao.add(str);
				for (String str : textEstadoFinal.getText().split(", "))
					estadoFinal.add(str);
				AFD afd = new AFD(alfabeto, Integer.parseInt(textNumeroEstados.getText()), regrasTransicao, textEstadoInicial.getText(), estadoFinal);
				try {
					if (afd.verificar(textEntrada.getText()) == true)
						JOptionPane.showMessageDialog(null, "ACEITO");
					else
						JOptionPane.showMessageDialog(null, "REJEITADO");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ResultadoFuncaoTransicaoInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnVerificar.setBackground(new Color(230, 230, 250));
		btnVerificar.setForeground(new Color(255, 0, 0));
		btnVerificar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		contentPane.add(btnVerificar, "cell 1 7,alignx center,growy");
		
		lblEntrada = new JLabel("Entrada");
		lblEntrada.setForeground(new Color(255, 255, 0));
		lblEntrada.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblEntrada, "cell 0 6,alignx left,aligny center");
		
		textEntrada = new JTextField();
		textEntrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(textEntrada, "cell 1 6,growx,aligny center");
		textEntrada.setColumns(10);
	}
}
