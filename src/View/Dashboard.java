package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Employee;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblTipo;

	public Dashboard(Employee employee) {
		setTitle("Voce-Aluga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem vindo, " + employee.getUsername());
		lblBemVindo.setBounds(167, 38, 124, 15);
		contentPane.add(lblBemVindo);
		
		JButton btnAdicionarCliente = new JButton("Adicionar cliente");
		btnAdicionarCliente.setBounds(587, 12, 157, 25);
		contentPane.add(btnAdicionarCliente);
		btnAdicionarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CreateClient frame = new CreateClient();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		table = new JTable();
		table.setBounds(40, 86, 734, 349);
		contentPane.add(table);
		
		if (employee.getType() == 1) {
			lblTipo = new JLabel("Gerente");
		} else {
			lblTipo = new JLabel("Funcionário");
		}
		
		lblTipo.setBounds(403, 0, 100, 15);
		contentPane.add(lblTipo);
	}
}
