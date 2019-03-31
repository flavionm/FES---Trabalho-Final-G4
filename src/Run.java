import java.awt.EventQueue;

import View.Login;
import Controller.BootstrapDB;

public class Run {

	public static void main(String[] args) {	
		
		BootstrapDB.Bootstrap();
		
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

}
