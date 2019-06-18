package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Model.Client;

import com.jgoodies.forms.layout.FormSpecs;

public class ClientInfo extends JFrame {

	private JPanel contentPane;

	public ClientInfo(Client client) {
		
		setTitle(client.getName());
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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
	}

}
