package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.RentController;
import Controller.VehicleController;
import Model.Client;
import Model.Rent;
import Model.Vehicle;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class ChooseVehicle extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JButton search;
	private JButton clear;
	
	private VehicleController controller = new VehicleController();
	private RentController rentController = new RentController();
	private JButton btnEscolher;
	

	int iSelectedIndex =-1;
	ArrayList<Object []> data;
	ArrayList<Vehicle> vehicles = controller.readAllAvailable();


	public ChooseVehicle(Client client, ClientInfo clientInfo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ChooseVehicle window = this;
		setTitle("Veículos Disponíveis");
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
				criaTabela(vehicles, client, window, clientInfo);
				contentPane.revalidate();
				contentPane.repaint();
			}
        });
		rootPane.setDefaultButton(search);
		
		clear = new JButton();
		clear.setBounds(470, 10, 104, 19);
		clear.setText("Limpar");
		contentPane.add(clear);
		clear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArrayList<Vehicle> vehicles = controller.readAll();
				for (Component c : contentPane.getComponents())
					if (c instanceof JScrollPane) {
						System.out.println("Cleared");
						contentPane.remove(c);
						break;
					}
				criaTabela(vehicles, client, window, clientInfo);
				contentPane.revalidate();
				contentPane.repaint();
			}
        });
		criaTabela(vehicles, client, this, clientInfo);
	}
	
	private void criaTabela(ArrayList<Vehicle> vehicles, Client client, ChooseVehicle window, ClientInfo clientInfo) {
		String [] columnNames = {"Marca", "Placa", "Documento"};
		ArrayList<Object []> data = new ArrayList<>();
		
		vehicles.forEach((element) -> data.add(element.getDataForTable().toArray()));
		
		table = new JTable(data.toArray(new Object[][] {}), columnNames);
		
		
		JScrollPane pane = new JScrollPane();
		pane.setBounds(12, 72, 587, 250);
		pane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pane.setViewportView(table);
		contentPane.add(pane);
		
		btnEscolher = new JButton("Alugar");
		btnEscolher.setBounds(128, 41, 326, 25);
		btnEscolher.setEnabled(false);
		contentPane.add(btnEscolher);
		btnEscolher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Rent rent = new Rent();
				rent.setClient_id(client.getId());
				rent.setVehicle_id(vehicles.get(iSelectedIndex).getId());
				rentController.start(rent);
				
				controller.rent(vehicles.get(iSelectedIndex));
				
				clientInfo.AtualizaLista(client);
				window.setVisible(false);
				
			}
			
		});
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = table.getSelectionModel();
		
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				handleSelectionEvent(e);
			}
		});
	}
	
	protected void handleSelectionEvent(ListSelectionEvent e) {
	    if (e.getValueIsAdjusting())
	        return;

	    String strSource= e.getSource().toString();
	    int start = strSource.indexOf("{")+1,
	        stop  = strSource.length()-1;
	    iSelectedIndex = Integer.parseInt(strSource.substring(start, stop));
	    btnEscolher.setEnabled(true);
	    System.out.println(vehicles.get(iSelectedIndex).getId());
		
	}
}
