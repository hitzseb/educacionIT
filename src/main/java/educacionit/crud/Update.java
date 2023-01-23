package educacionit.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import educacionit.entities.Alumno;
import educacionit.entities.Curso;
import educacionit.entities.Profesor;
import educacionit.entities.Tecnologia;
import educacionit.source.MyDataSource;

public class Update {
	
	public void updateTecnologiaById(Connection con, int id, Tecnologia tecnologia) throws SQLException {
		String SQL_QUERY = "UPDATE tecnologias SET nombre_tecnologia = '"
							+ tecnologia.getNombre() +
							"' WHERE id_tecnologia = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.executeUpdate();
	}
	
	public void updateCursoById(Connection con, int id, Curso curso) throws SQLException {
		String SQL_QUERY = "UPDATE tecnologias SET nombre_curso = '"
							+ curso.getNombre() + "', id_tecnologia = " + curso.getTecnologia() +
							" WHERE id_tecnologia = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.executeUpdate();
	}
	
	public void updateProfesorById(Connection con, int id, Profesor profesor) throws SQLException {
		String SQL_QUERY = "UPDATE profesores SET nombre_profesor = '"
							+ profesor.getNombre() +
							"' WHERE id_profesor = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.executeUpdate();
	}
	
	public void updateAlumnoById(Connection con, int id, Alumno alumno) throws SQLException {
		String SQL_QUERY = "UPDATE alumnos SET nombre_alumno = '"
							+ alumno.getNombre() +
							"' WHERE id_alumno = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.executeUpdate();
	}

}
