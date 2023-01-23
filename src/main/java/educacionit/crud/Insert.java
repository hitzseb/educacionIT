package educacionit.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import educacionit.entities.Alumno;
import educacionit.entities.Curso;
import educacionit.entities.Profesor;
import educacionit.entities.Tecnologia;
import educacionit.source.MyDataSource;

public class Insert {
	
	//Todos los metodos para insertar datos en la base de datos
	
	public void insertTecnologia(Connection con, Tecnologia tecnologia) throws SQLException {
		int id_tecnologia = tecnologia.getId();
		String nombre_tecnologia = tecnologia.getNombre();
		String SQL_QUERY = "insert into tecnologias (id_tecnologia, nombre_tecnologia) values ("
	                       + id_tecnologia + ", '" + nombre_tecnologia + "');";
		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}
	
	public void insertCurso(Connection con, Curso curso) throws SQLException {
		int id_curso = curso.getId();
		String nombre_curso = curso.getNombre();
		String SQL_QUERY = "insert into cursos (id_curso, nombre_curso) values ("
	                       + id_curso + ", '" + nombre_curso + "');";
		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}
	
	public void insertProfesor(Connection con, Profesor profesor) throws SQLException {
		int id_profesor = profesor.getId();
		String nombre_profesor = profesor.getNombre();
		String SQL_QUERY = "insert into profesores (id_profesor, nombre_profesor) values ("
	                       + id_profesor + ", '" + nombre_profesor + "');";
		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}
	
	public void insertAlumno(Connection con, Alumno alumno) throws SQLException {
		int id_alumno = alumno.getId();
		String nombre_alumno = alumno.getNombre();
		String SQL_QUERY = "insert into alumnos (id_alumno, nombre_alumno) values ("
	                       + id_alumno + ", '" + nombre_alumno + "');";
		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}
	
	public void asignarProfesorACurso(Connection con, int id_curso, int id_profesor) throws SQLException {
		String SQL_QUERY = "insert into cursos_profesores(id_curso, id_profesor) "
				+ "values(" + id_curso + "," + id_profesor + ")";
		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}
	
	public void inscribirAlumnoEnCurso(Connection con, int id_curso, int id_alumno) throws SQLException {
		String SQL_QUERY = "insert into cursos_alumnos(id_curso, id_alumno) "
				+ "values(" + id_curso + "," + id_alumno + ")";
		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}

}
