package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddVehicle extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtModelo_1;
	private JTextField txtCor;
	private JTextField txtPlaca;
	private JTextField txtDocumento;
	private JTextField txtSeguro;
	private JTextField txtDisponibilidade;
	private JTextField txtQuilometragem;
	private JTextField txtFilial;

	public AddVehicle() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 596, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(11, 11, 476, 19);
		txtMarca.setText("Marca");
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo_1 = new JTextField();
		txtModelo_1.setBounds(487, 11, 104, 19);
		txtModelo_1.setText("Modelo");
		contentPane.add(txtModelo_1);
		txtModelo_1.setColumns(10);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(11, 36, 476, 19);
		txtDocumento.setText("Documento");
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(487, 36, 104, 19);
		txtPlaca.setText("Placa");
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtSeguro = new JTextField();
		txtSeguro.setBounds(11, 61, 476, 19);
		txtSeguro.setText("Seguro");
		contentPane.add(txtSeguro);
		txtSeguro.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(487, 61, 104, 19);
		txtModelo.setText("Tipo");
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtQuilometragem = new JTextField();
		txtQuilometragem.setBounds(11, 86, 476, 19);
		txtQuilometragem.setText("Quilometragem");
		contentPane.add(txtQuilometragem);
		txtQuilometragem.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(487, 86, 104, 19);
		txtCor.setText("Cor");
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		txtFilial = new JTextField();
		txtFilial.setBounds(11, 111, 476, 19);
		txtFilial.setText("Filial");
		contentPane.add(txtFilial);
		txtFilial.setColumns(10);
		
		txtDisponibilidade = new JTextField();
		txtDisponibilidade.setBounds(487, 111, 104, 19);
		txtDisponibilidade.setText("Custo");
		contentPane.add(txtDisponibilidade);
		txtDisponibilidade.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(11, 161, 476, 25);
		contentPane.add(btnAdicionar);
	}

}
