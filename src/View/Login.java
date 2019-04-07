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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	public EmployeeController controller = new EmployeeController();

	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LoginWarning warningFrame = new LoginWarning();

		//Logo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/logo.jpg")));
		lblNewLabel.setBounds(20, 10, 40, 40);
		contentPane.add(lblNewLabel);

		//Textfield do username
		username = new JTextField();
		username.setBounds(125, 50, 200, 25);
		contentPane.add(username);
		username.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(125, 30, 55, 15);
		contentPane.add(lblNome);

		//Textfield da senha
		password = new JPasswordField();
		password.setBounds(125, 100, 200, 25);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(125, 80, 55, 15);
		contentPane.add(lblSenha);
				
		//Botões
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(175, 175, 100, 25);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Employee employee = new Employee();
				employee.setUsername(username.getText());
				employee.setPassword(password.getText());
				Employee login = controller.login(employee);
				if (login.getUsername().length()> 0) {
					System.out.println("Logou.");
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Dashboard frame = new Dashboard(login);
								frame.setVisible(true);
								setVisible(false);
							} catch (Exception e) {
								e.printStackTrace();
			                }
						}
		            });
				}else {
					warningFrame.setVisible(true);
				}
			}
		});
		getRootPane().setDefaultButton(btnLogin);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(330, 225, 100, 25);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SignUp frame = new SignUp();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});


	}
}
