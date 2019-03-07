package clases;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JOptionPane;

public class BDAssistance {
	public static String url = "C:/sqlite/db/", actualDB = "Test";
	public static SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy"), timeformat = dateformat = new SimpleDateFormat("hh:mm");
	public static void main(String[] args) {
		try {
			connectDB("Nueva3");
			showUsuario();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void prepADB(String dbname) { //preparar y limpiar BD de Asistencia
		String sql = "" +
/*Table definitions*/	"create table if not exists Usuario(id integer primary key autoincrement, nombre varchar(62) not NULL, correo varchar(30) unique not NULL, contras varchar(30) not null, tipo integer default 0, faltas int, estado integer DEFAULT 0, permiso_modif_horario boolean default 0);create table if not exists Horario(id integer primary key AUTOINCREMENT, usuario int, dia int not null, horainicio time not null, horafin time not null, foreign key(usuario) references Usuario(id));create table if not exists Asistencia(id Integer primary key AUTOINCREMENT, usuario int, hora time not null, tipo boolean not null, estado int default 0, fecha date not null, foreign key(usuario) references Usuario(id));";
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:"+url+dbname+".db");){
			if(con!=null) {
				System.out.println("Conexión exitosa a " + dbname);
				actualDB = dbname;
				Statement state = con.createStatement();
				state.execute(sql);
				System.out.println("Definición exitosa");
			}
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("BD: " + dbname);
		}
	}
	public static Statement connectDB() throws SQLException {
		Connection con = null;
		try{
			con = DriverManager.getConnection("jdbc:sqlite:"+url+actualDB+".db");
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("BD: " + actualDB);
		}
		return (con==null)?null:con.createStatement();
	}
	public static Statement connectDB(String dbname) throws SQLException {
		File DbUrl = new File(url); //Dirección de la BD
		if(!DbUrl.exists()) { //Si no existe la URL
			DbUrl.mkdirs(); //Crear los directorios
		}
		Connection con = null;
		try{
			con = DriverManager.getConnection("jdbc:sqlite:"+url+actualDB+".db"); //Hacer conexión o crear si no existe
			actualDB = dbname;
			if (!(new File(url+dbname+".db").exists())) {
				System.out.println("Se creó una nueva BD");
				prepADB(dbname);
			}
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("BD: " + actualDB);
		}
		return (con==null)?null:con.createStatement();
	}
	private static void showUsuario() {
		String sql = "select * from usuario";
		try(Statement st = connectDB()){
			if(st!=null) { //La conexión es exitosa
				ResultSet res = st.executeQuery(sql); //Ejecutar Query
				System.out.println("Extracción exitosa:");
				while(res.next()) {
					System.out.println("ID: " + res.getInt("id") + " Nombre: " + res.getString("nombre")+" "+"Correo: " + res.getString("correo")+" "+
							"Faltas: " + res.getInt("faltas") + " Contras: " + res.getString("contras") + " Estado: " + res.getInt("estado") +
							" Permiso: " + res.getBoolean("permiso_modif_horario"));
				}
			}
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("BD: " + actualDB);
		}
	}
	private static void testInfoInsertion() {
		String sql = "insert into usuario(nombre, correo, tipo, contras) values('Pedro','algo@gmail.com',0,'algocorto');\r\n" + 
				"insert into horario(usuario, dia, horainicio, horafin) values(1,3,'03:12','04:30');\r\n" + 
				"insert into asistencia(usuario, hora, tipo, estado,fecha) values(1,'03:11',0, 1, '03-12-2019');";
		try(Statement st = connectDB()){
			if(st!=null) { //La conexión es exitosa
				st.execute(sql); //Ejecutar Query
				System.out.println("Insersión exitosa");
			}
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("BD: " + actualDB);
		}
	}
	public static boolean CreaUsuario(String nom, String corr, String con) { //Crear un nuevo usuario: 0=no se creó, 1=éxito
		if(UsuarioQuery(corr, con) != null) return false;
		try(Statement st = connectDB();) {
			st.execute("insert into Usuario(nombre,correo,contras) values("+comma(nom)+","+comma(corr)+","+comma(con)+")");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("BD: " + actualDB);
		}
		return false;
	}
	public static boolean CreaUsuario(Usuario us) {
		if(UsuarioQuery(us.getCorreo(), us.getContras()) != null) return false;
		try(Statement st = connectDB();) {
			st.execute("insert into Usuario(nombre,correo,contras,tipo,faltas,estado,permiso_modif_horario)"
					+ " values("+us.sqlValue()+")");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("BD: " + actualDB);
		}
		return true;
	}
	public static Usuario UsuarioQuery(String correo, String contras) { //Encontrar usuario con correo y contras
		Usuario us = null;
		try(Statement st = connectDB();){
			ResultSet rs = st.executeQuery("select * from usuario where correo=" + comma(correo) + " and contras="+comma(contras));
			if(rsLenght(rs)==0) us = null;
			else {
				us = new Usuario(rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getBoolean(8));
				us.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("BD: "+ actualDB);
		}
		return us;
	}
	public static Usuario UsuarioQuery(int id) { //Encontrar Usuario con id
		Usuario us = null;
		try(Statement st = connectDB();){
			ResultSet rs = st.executeQuery("select * from usuario where id = " + comma(""+id));
			if(rsLenght(rs)==0) us = null;
			else {
				us = new Usuario(rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getBoolean(8));
				us.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("BD: "+ actualDB);
		}
		return us;
	}
	public static boolean EliminaUsuario(int idus) { //Eliminar un usuario
		Usuario us = UsuarioQuery(idus);
		if(us==null) return false;
		try(Statement st = connectDB();){
			st.execute("delete from asistencia where usuario="+idus+";");
			st.execute("delete from horario where usuario="+idus+";");
			st.execute("delete from usuario where id="+idus+";");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("BD: "+ actualDB);
			return false;
		}
		return true;
	}
	public static boolean ActualizaUsuario(Usuario us) { //actualizar los valores cambiados de usuario
		if(us.getId()==0) {
			CreaUsuario(us);
			return false;
		}
		try(Statement st = connectDB();){
			st.execute("update usuario set " + us.sqlValueUpdate() +" where id="+us.getId()+";");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("BD: "+ actualDB);
		}
		return false;
	}
	public static Horario HorarioQuery(int idus) { //Extraer el horario de un Usuario
		Horario hor = null;
		try(Statement st = connectDB();){
			ResultSet rs = st.executeQuery("select * from horario where usuario= " + idus);
			if(rsLenght(rs)==0) hor = null; //si no hay registros
			else {
				hor = new Horario(rs.getInt(2),null); //Crear horario con el usuario
				Vector<Hora> horas=new Vector<Hora>();
				while(rs.next()) {
					horas.add(new Hora(rs.getInt(1),rs.getInt(3), rs.getString(4),rs.getString(5))); //Importar la Hora
				}
				hor.setHoras(horas);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("BD: "+ actualDB);
		}
		return hor;
	}
	public static boolean ActualizaHorario(Horario hor) {
		if(!hor.modificado && hor.getUsuario()!=0) return false; //si no es nuevo y no ha sido modificado no hay que actualizar
		Vector<Hora> horas = hor.getHoras();
		try(Statement st = connectDB();){
			for(Hora i:horas) {
				if(i.eliminar) st.execute("delete from horario where id="+i.getId()); //Para eliminar una hora
				else if(!i.actualizada && i.getId()!=0) st.execute("update horario set dia="+i.getDia()+ //actualizar valor de una hora registrada
						" ,horainicio="+comma(i.getStrHorainicio())+" , horafin="+comma(i.getStrHorafin())+" where id="+i.getId());
				else if(i.nueva) st.execute("insert into horario(usuario,dia,horainicio,horafin) values("+hor.getUsuario()+", "+i.getDia()+", "+
						i.getStrHorainicio()+", "+i.getStrHorainicio()+");");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("BD: "+ actualDB);
			return false;
		}
		return true;
	}
	public static void RegistraAsistencia(Usuario us) {
		
	}
	
	/*Utilidades para manejo de SQL*/
	private static String comma(String s) {
		return "'" + s + "'";
	}
	private static int rsLenght(ResultSet rs) { //saber las filas de un set
		if (rs != null) 
		{
		  try {
			  rs.last();
			  int size = rs.getRow();
			  rs.first();
			  return size;
		  } catch (SQLException e) {
			  e.printStackTrace();
			  return 0;
		  }
		}
		return 0;
	}
	
}