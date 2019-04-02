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

public class LoginWarning extends JFrame {

	private JPanel contentPane;
	private final JLabel lblLoginOuSenha = new JLabel("Login ou senha inválido");
	public LoginWarning() {
		setTitle("Alerta");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(150, 150, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblLoginOuSenha.setBounds(100, 50, 140, 30);
		contentPane.add(lblLoginOuSenha);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(120, 100, 98, 25);
		contentPane.add(btnFechar);
		
		btnFechar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
			
		});
		
		
	}
}
