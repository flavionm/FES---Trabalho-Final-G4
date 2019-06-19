package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Controller.RentController;
import Controller.VehicleController;
import Model.Client;
import Model.Rent;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JList;
import javax.swing.JButton;

public class ClientInfo extends JFrame {

	private JPanel contentPane;
	private VehicleController vehicleController = new VehicleController();
	int rentedIndex = -1;

	public ClientInfo(Client client) {
		
		setTitle(client.getName());
		
		RentController rentController = new RentController();
		
		ArrayList<Rent> rentsList = rentController.readAllFromClient(client);
		
		boolean rented = false;
		
		for (int i = 0; i < rentsList.size(); i++) {
			if(!rentsList.get(i).isCompleted())
				rented = true;
				rentedIndex = i;
		}
		
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(140, 70, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Cliente");
		lblName.setBounds(12, 11, 40, 15);
		contentPane.add(lblName);
		
		JLabel lblNome = new JLabel("Nome: " + client.getName());
		lblNome.setBounds(59, 32, 220, 15);
		contentPane.add(lblNome);
		
		JLabel lblCnh_1 = new JLabel("CNH: " + client.getCnh());
		lblCnh_1.setBounds(300, 32, 220, 15);
		contentPane.add(lblCnh_1);
		
		JLabel lblCnh = new JLabel("Emai: " + client.getEmail());
		lblCnh.setBounds(59, 53, 220, 15);
		contentPane.add(lblCnh);
		
		JLabel lblCpf = new JLabel("CPF: " + client.getCpf());
		lblCpf.setBounds(300, 53, 220, 15);
		contentPane.add(lblCpf);
		
		JLabel lblId = new JLabel("Telefone: " + client.getPhone());
		lblId.setBounds(59, 74, 220, 15);
		contentPane.add(lblId);
		
		String rents[] = new String[20];
		
		for (int i = 0; i < rentsList.size() && i < 20 ; i++) {
			rents[i] = "Carro " + rentsList.get(i).getVehicle_id() + " desde " + rentsList.get(i).getStart_date();
			if (rentsList.get(i).getEnd_date() != null) rents[i] += " até " + rentsList.get(i).getEnd_date();
			else rents[i] += " ainda alugado...";
		}
		
		
		JList list = new JList(rents);
		list.setBounds(74, 174, 398, 306);
		contentPane.add(list);
		
		JLabel lblAgendamentos = new JLabel("Histórico de aluguéis");
		lblAgendamentos.setBounds(224, 141, 122, 15);
		contentPane.add(lblAgendamentos);
		
		JButton btnNewButton = new JButton("Alugar veículo");
		btnNewButton.setBounds(508, 188, 240, 76);
		contentPane.add(btnNewButton);
		if (rented) btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ChooseVehicle frame = new ChooseVehicle(client);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
		                }
					}
	            });
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Finalizar aluguel");
		btnNewButton_1.setBounds(508, 350, 240, 76);
		contentPane.add(btnNewButton_1);
		if (!rented) btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rentController.end(rentsList.get(rentedIndex));
				vehicleController.returnVehicle(rentsList.get(rentedIndex).getVehicle_id());
			}
		});
		
	}
}
