package educacionit.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import educacionit.source.MyDataSource;

public class Delete {
	
	public void deleteTecnologiaById(Connection con, int id) throws SQLException {
		String SQL_QUERY = "DELETE FROM tecnologias WHERE id_tecnologia = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}
	
	public void deleteCursoById(Connection con, int id) throws SQLException {
		String SQL_QUERY = "DELETE FROM cursos WHERE id_curso = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}
	
	public void deleteProfesorById(Connection con, int id) throws SQLException {
		String SQL_QUERY = "DELETE FROM profesores WHERE id_profesor = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}
	
	public void deleteAlumnoById(Connection con, int id) throws SQLException {
		String SQL_QUERY = "DELETE FROM alumnos WHERE id_alumno = " + id;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}
	
	public void desasignarProfesorACurso(Connection con, int id_curso, int id_profesor) throws SQLException {
		String SQL_QUERY = "DELETE FROM cursos_profesores WHERE id_curso = " + id_curso
				+ " and id_profesor = " + id_profesor;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}
	
	public void desinscribirAlumnoEnCurso(Connection con, int id_curso, int id_alumno) throws SQLException {
		String SQL_QUERY = "DELETE FROM cursos_alumnos WHERE id_curso = " + id_curso
				+ " and id_alumno = " + id_alumno;

		PreparedStatement pst = con.prepareStatement(SQL_QUERY);
		pst.execute();
	}

}
