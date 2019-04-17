package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.VehicleController;
import Model.Vehicle;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddVehicle extends JFrame {

	private JPanel contentPane;
	private JTextField txtTipo;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtDocumento;
	private JTextField txtSeguro;
	private JTextField txtFilial;
	private JTextField txtCusto;
	private JTextField txtCor;
	private JTextField txtPlaca;
	
	private VehicleController controller = new VehicleController();

	public AddVehicle() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Adicionar veículo");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(12, 13, 66, 15);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(80, 11, 145, 19);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(292, 13, 24, 15);
		contentPane.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(323, 11, 89, 19);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 38, 66, 15);
		contentPane.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(80, 36, 145, 19);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(295, 38, 21, 15);
		contentPane.add(lblCor);
		
		txtCor = new JTextField();
		txtCor.setBounds(323, 36, 89, 19);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(12, 63, 66, 15);
		contentPane.add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(80, 61, 145, 19);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(284, 63, 32, 15);
		contentPane.add(lblPlaca);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(323, 61, 89, 19);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JLabel lblSeguro = new JLabel("Seguro");
		lblSeguro.setBounds(12, 88, 66, 15);
		contentPane.add(lblSeguro);
		
		txtSeguro = new JTextField();
		txtSeguro.setBounds(80, 86, 145, 19);
		contentPane.add(txtSeguro);
		txtSeguro.setColumns(10);
		
		JLabel lblFilial = new JLabel("Filial");
		lblFilial.setBounds(12, 113, 66, 15);
		contentPane.add(lblFilial);
		
		txtFilial = new JTextField();
		txtFilial.setBounds(80, 111, 145, 19);
		contentPane.add(txtFilial);
		txtFilial.setColumns(10);
		
		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setBounds(12, 138, 66, 15);
		contentPane.add(lblCusto);
		
		txtCusto = new JTextField();
		txtCusto.setBounds(80, 136, 145, 19);
		contentPane.add(txtCusto);
		txtCusto.setColumns(10);
		
		JButton btnAdic = new JButton("Adicionar");
		btnAdic.setBounds(169, 201, 98, 25);
		contentPane.add(btnAdic);
		btnAdic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Vehicle vehicle = new Vehicle();
				vehicle.setBrand(txtMarca.getText());
				vehicle.setType(txtTipo.getText());
				vehicle.setModel(txtModelo.getText());
				vehicle.setColor(txtCor.getText());
				vehicle.setPlate(txtPlaca.getText());
				vehicle.setDocument(txtDocumento.getText());
				vehicle.setInsurance(txtSeguro.getText());
				vehicle.setCost(txtCusto.getText());
				vehicle.setFilial(txtFilial.getText());
				controller.insert(vehicle);
				setVisible(false);
			}
			
		});
	}
}
