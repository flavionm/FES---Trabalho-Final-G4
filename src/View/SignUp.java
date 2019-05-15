package View;

import Model.Employee;
import Controller.EmployeeController;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	public EmployeeController controller = new EmployeeController();
	private JPasswordField passwordField;

	public SignUp(JFrame parent) {
		setTitle("Cadastro de funcionário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setBounds(125, 50, 200, 25);
		contentPane.add(username);
		username.setColumns(10);
		

		password = new JPasswordField();
		password.setBounds(125, 100, 200, 25);
		contentPane.add(password);
		password.setColumns(10);
		
		JCheckBox type = new JCheckBox("Gerente");
		type.setBounds(160, 135, 120, 25);
		contentPane.add(type);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(125, 30, 55, 15);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(125, 80, 55, 15);
		contentPane.add(lblSenha);
		
		JButton createEmployee = new JButton("Criar");
		createEmployee.setBounds(175, 175, 100, 25);
		contentPane.add(createEmployee);
		
		createEmployee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Employee employee = new Employee();
				employee.setUsername(username.getText());
				employee.setPassword(password.getText());
				if (type.isSelected()) {
					employee.setType(1);
				}
				controller.insert(employee);			
				EventQueue.invokeLater(new Runnable() {	
					public void run() {
						try {
							dispose();
							parent.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
}
