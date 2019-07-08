package Controller;

import java.sql.Connection;
import java.sql.Statement;

public class BootstrapDB {

	public static Connection conn;
	public static Statement st;
	
	public static void Bootstrap() {
		conn = new ConnectionDB().getConection();
		BootstrapEmployee();
		BootstrapClient();
		BootstrapVehicle();
		BootstrapRent();
		return;
	}
	

	public static void BootstrapEmployee() {
		String sql = "CREATE TABLE IF NOT EXISTS employee ("
				+ "id SERIAL PRIMARY KEY,"
				+ "username varchar(100) NOT NULL UNIQUE CHECK (LENGTH(TRIM(username)) > 0),"
				+ "password varchar(100) NOT NULL CHECK (LENGTH(TRIM(password)) > 0),"
				+ "type integer DEFAULT 0"
				+ ");";
		try {
			st = conn.createStatement();
			st.execute(sql);
			st.close();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro no bootstrap de employee: " + e);
		}
	}
	
	public static void BootstrapClient() {
		String sql = "CREATE TABLE IF NOT EXISTS client ("
				+ "id SERIAL PRIMARY KEY,"
				+ "name varchar(100) NOT NULL CHECK (LENGTH(TRIM(name)) > 0),"
				+ "email varchar(100) NOT NULL UNIQUE CHECK (LENGTH(TRIM(email)) > 0),"
				+ "cpf varchar(100) NOT NULL UNIQUE CHECK (LENGTH(TRIM(cpf)) > 0),"
				+ "phone varchar(100) NOT NULL UNIQUE CHECK (LENGTH(TRIM(phone)) > 0),"
				+ "cnh varchar(100) UNIQUE,"
				+ "address varchar(100),"
				+ "city varchar(100),"
				+ "state varchar(100),"
				+ "vip boolean DEFAULT FALSE,"
				+ "rents integer DEFAULT 0,"
				+ "blacklist boolean DEFAULT FALSE"
				+ ");";
		try {
			st = conn.createStatement();
			st.execute(sql);
			st.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no bootstrap de client: " + e);
		}
	}
	
	public static void BootstrapVehicle() {
		String sql = "CREATE TABLE IF NOT EXISTS vehicle ("
				+ "id serial NOT NULL,"
				+ "brand varchar(100) NOT NULL,"
				+ "model varchar(100) NOT NULL,"
				+ "type varchar(11) NOT NULL,"
				+ "color varchar(100) NOT NULL,"
				+ "plate varchar(100) UNIQUE,"
				+ "document varchar(100),"
				+ "insurance varchar(100),"
				+ "cost varchar(50),"
				+ "km float DEFAULT 0,"
				+ "filial varchar(100),"
				+ "PRIMARY KEY(id)"
				+ ");";
		try {
			st = conn.createStatement();
			st.execute(sql);
			st.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no bootstrap de vehicle: " + e);
		}
	}
	
	public static void BootstrapRent() {
		String sql = "CREATE TABLE IF NOT EXISTS rent (\n"
				+ "id SERIAL PRIMARY KEY,\n"
				+ "client_id BIGINT,\n"
				+ "vehicle_id BIGINT,\n"
				+ "completed BOOLEAN DEFAULT FALSE,\n"
				+ "start_date DATE NOT NULL,\n"
				+ "end_date DATE NOT NULL CHECK (end_date > start_date),\n"
				+ "FOREIGN KEY(client_id) REFERENCES client(id),\n"
				+ "FOREIGN KEY(vehicle_id) REFERENCES vehicle(id)\n"
				+ ");\n"
				+ "CREATE OR REPLACE FUNCTION no_overlap() RETURNS trigger AS $no_overlap$\n"
				+ "BEGIN\n"
				+ "	IF (EXISTS (SELECT *\n"
				+ "	            FROM rent r\n"
				+ "	            WHERE r.vehicle_id = NEW.vehicle_id AND NOT (NEW.end_date < r.start_date OR NEW.start_date > r.end_date)\n"
				+ "	           )\n"
				+ "	   )\n"
				+ "	THEN RAISE EXCEPTION \'veiculo ja alugado nesse horario\';\n"
				+ "	ELSIF (EXISTS (SELECT *\n"
				+ "	            FROM rent r\n"
				+ "	            WHERE r.client_id = NEW.client_id AND NOT (NEW.end_date < r.start_date OR NEW.start_date > r.end_date)\n"
				+ "	           )\n"
				+ "	   )\n"
				+ "	THEN RAISE EXCEPTION \'cliente ja tem aluguel nesse intervalo\';\n"
				+ "	END IF;\n"
				+ "	RETURN NEW;\n"
				+ "END\n"
				+ "$no_overlap$ LANGUAGE plpgsql;\n"
				+ "DROP TRIGGER IF EXISTS no_overlap ON rent;"
				+ "CREATE TRIGGER no_overlap\n"
				+ "BEFORE INSERT ON rent\n"
				+ "FOR EACH ROW EXECUTE PROCEDURE no_overlap();\n";
		try {
			st = conn.createStatement();
			st.execute(sql);
			st.close();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro no bootstrap de rent: " + e);
		}
	}
}
