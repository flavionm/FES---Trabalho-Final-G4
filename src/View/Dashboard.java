package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.ClientController;
import Model.Client;
import Model.Employee;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblTipo;
	ClientController controller = new ClientController();
	private JButton btnAtualizar;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblCpf;
	private JButton btnVeiculos;

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
		
		Dashboard self = this;

		JButton btnAdicionarCliente = new JButton("Adicionar cliente");
		btnAdicionarCliente.setBounds(587, 12, 157, 25);
		contentPane.add(btnAdicionarCliente);
		btnAdicionarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CreateClient frame = new CreateClient(self, employee);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		ArrayList<Client> clients = AtualizaTabela(contentPane);

		int y = 106;
		
		for (Client cliente : clients) {

			JButton btn = new JButton("Editar");
			btn.setBounds(780, y, 100, 16);
			contentPane.add(btn);
			y+=16;
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								CreateClient frame = new CreateClient(self, employee, cliente);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
			                }
						}
		            });
				}
				
			});
			
		}
		
		
		if (employee.getType() == 1) {
			lblTipo = new JLabel("Gerente");
		} else {
			lblTipo = new JLabel("Funcionário");
		}
		
		lblTipo.setBounds(403, 30, 100, 15);
		contentPane.add(lblTipo);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(353, 426, 98, 25);
		contentPane.add(btnAtualizar);
		
		JButton btnAdicionarVeiculo = new JButton("Adicionar Veículo");
		btnAdicionarVeiculo.setBounds(12, 12, 139, 25);
		contentPane.add(btnAdicionarVeiculo);
		
		btnVeiculos = new JButton("Veículos");
		btnVeiculos.setBounds(40, 49, 98, 25);
		contentPane.add(btnVeiculos);
		
		btnVeiculos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SearchVehicle frame = new SearchVehicle();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
		                }
					}
	            });
			}
			
		});
		
		btnAdicionarVeiculo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddVehicle frame = new AddVehicle();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
		                }
					}
	            });
			}
			
		});
		
		btnAtualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Dashboard frame = new Dashboard(employee);
							frame.setVisible(true);
							setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
		                }
					}
	            });
			}
			
		});
		
	}

	int iSelectedIndex =-1;
	ArrayList<Object []> data;
	ArrayList<Client> clients;
	public ArrayList<Client> AtualizaTabela(Container panel) {
		String [] columns = {"Nome", "Telefone", "Cpf"};
		data = new ArrayList<>();
		
		clients = controller.readAll();
		
		clients.forEach((element) -> data.add(element.getDataForDashBoardTable().toArray()));
		
		JScrollPane pane = new JScrollPane();
		table = new JTable(data.toArray(new Object[][] {}), columns);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = table.getSelectionModel();
		
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				handleSelectionEvent(e);
			}
		});
		
		pane.setViewportView(table);
		pane.setBounds(40, 86, 734, 320);
		panel.add(pane);
		
		return clients;
	}

	protected void handleSelectionEvent(ListSelectionEvent e) {
	    if (e.getValueIsAdjusting())
	        return;

	    String strSource= e.getSource().toString();
	    int start = strSource.indexOf("{")+1,
	        stop  = strSource.length()-1;
	    iSelectedIndex = Integer.parseInt(strSource.substring(start, stop));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientInfo frame = new ClientInfo(clients.get(iSelectedIndex));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
