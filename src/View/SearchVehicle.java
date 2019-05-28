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
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class SearchVehicle extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JButton search;
	
	private VehicleController controller = new VehicleController();


	public SearchVehicle() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		search = new JButton();
		search.setBounds(350, 10, 104, 19);
		search.setText("Buscar");
		contentPane.add(search);
		search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArrayList<Vehicle> vehicles = controller.search(textField.getText());
				for (Component c : contentPane.getComponents())
					if (c instanceof JScrollPane) {
						System.out.println("Here");
						contentPane.remove(c);
						break;
					}
				criaTabela(vehicles);
				contentPane.revalidate();
				contentPane.repaint();
			}
        });
		rootPane.setDefaultButton(search);
		
		ArrayList<Vehicle> vehicles = controller.readAll();
		criaTabela(vehicles);
	}
	
	private void criaTabela(ArrayList<Vehicle> vehicles) {
		String [] columnNames = {"Marca", "Placa", "Documento"};
		ArrayList<Object []> data = new ArrayList<>();
		
		vehicles.forEach((element) -> data.add(element.getDataForTable().toArray()));
		
		table = new JTable(data.toArray(new Object[][] {}), columnNames);
		
		
		JScrollPane pane = new JScrollPane();
		pane.setBounds(12, 72, 587, 250);
		pane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pane.setViewportView(table);
		contentPane.add(pane);
	}
}
