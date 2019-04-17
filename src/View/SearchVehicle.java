package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.VehicleController;
import Model.Client;
import Model.Vehicle;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class SearchVehicle extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	
	private VehicleController controller = new VehicleController();


	public SearchVehicle() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Veículos");
		setBounds(100, 100, 611, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBusca = new JLabel("Busca");
		lblBusca.setBounds(150, 12, 55, 15);
		contentPane.add(lblBusca);
		
		textField = new JTextField();
		textField.setBounds(229, 10, 104, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String [] columnNames = {"Marca", "Placa", "Documento"};
		ArrayList<Object []> data = new ArrayList<>();
		
		ArrayList<Vehicle> clients = controller.readAll();
		
		clients.forEach((element) -> data.add(element.getDataForTable().toArray()));
		
		table = new JTable(data.toArray(new Object[][] {}), columnNames);
		
		
		table.setBackground(Color.WHITE);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(12, 72, 587, 250);
		contentPane.add(table);
		

	}
}
