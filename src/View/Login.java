package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		password = new JTextField();
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
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(330, 225, 100, 25);
		contentPane.add(btnRegistrar);
		
		
	}
}
