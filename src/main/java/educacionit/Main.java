package educacionit;

import java.sql.Connection;
import java.sql.SQLException;

import educacionit.crud.Delete;
import educacionit.crud.Fetch;
import educacionit.crud.Insert;
import educacionit.crud.Update;
import educacionit.entities.Alumno;
import educacionit.entities.Curso;
import educacionit.entities.Profesor;
import educacionit.entities.Tecnologia;
import educacionit.source.MyDataSource;

public class Main {

	public static void main(String[] args) {
		
		
		Fetch fetch = new Fetch();
		Insert insert = new Insert();
		Update update = new Update();
		Delete delete = new Delete();
		
		Tecnologia tecnologia = new Tecnologia(1,"Java");
		Curso curso = new Curso(1,"Bootcamp Java Developer",1);
		Profesor profesor = new Profesor(1,"Mario");
		Alumno alumno1 = new Alumno(1,"Ariadna");
		Alumno alumno2 = new Alumno(2,"Diego");
		Alumno alumno3 = new Alumno(3,"Facundo");
		Alumno alumno4 = new Alumno(4,"Sebastian");
		
		try {
			Connection con = MyDataSource.getConnection();
			
			//Test de inserts
			System.out.println("Insert:\n" + tecnologia + "\n" + curso
					+ "\n" + profesor + "\n" + alumno1 + "\n" + alumno2
					+ "\n" + alumno3 + "\n" + alumno4);
			insert.insertTecnologia(con, tecnologia);
			insert.insertCurso(con, curso);
			insert.insertProfesor(con, profesor);
			insert.insertAlumno(con, alumno1);
			insert.insertAlumno(con, alumno2);
			insert.insertAlumno(con, alumno3);
			insert.insertAlumno(con, alumno4);
			System.out.println("Insert profesor en la Join Table cursos_profesores\n");
			insert.asignarProfesorACurso(con, 1, 1);
			System.out.println("Insert alumnos en la Join Table cursos_alumnos\n");
			insert.inscribirAlumnoEnCurso(con, 1, 1);
			insert.inscribirAlumnoEnCurso(con, 1, 2);
			insert.inscribirAlumnoEnCurso(con, 1, 3);
			insert.inscribirAlumnoEnCurso(con, 1, 4);
			
			//Test de fetches
			System.out.println("Fetch tecnologia con id = 1");
			fetch.fetchTecnologiaById(con, 1);
			System.out.println("Fetch curso con id = 1");
			fetch.fetchCursoById(con, 1);
			System.out.println("Fetch profesor con id = 1");
			fetch.fetchProfesorById(con, 1);
			System.out.println("Fetch alumno con id = 1");
			fetch.fetchAlumnoById(con, 1);
			System.out.println("Fetch todos los alumnos");
			fetch.fetchAlumnos(con);
			System.out.println("Fetch profesor del curso con id = 1 (aka Bootcamp Java Developer)");
			fetch.fetchProfesorByCursoId(con, 1);
			System.out.println("Fetch alumnos del curso con id = 1 (aka Bootcamp Java Developer)");
			fetch.fetchAlumnosByCursoId(con, 1);
			
			//Test de updates
			System.out.println("Editando al profesor");
			profesor.setNombre("MARIO");
			update.updateProfesorById(con, 1, profesor);
			fetch.fetchProfesorById(con, 1);
			
			//Test de delete
			System.out.println("Desasignando al profesor");
			delete.desasignarProfesorACurso(con, 1, 1);
			System.out.println("Fetch profesor del curso con id 1...\nNo hay nada");
			fetch.fetchProfesorByCursoId(con, 1);
			System.out.println("Reasignando al profesor");
			insert.asignarProfesorACurso(con, 1, 1);
			System.out.println("Fetch profesor del curso con id = 1 (aka Bootcamp Java Developer)");
			fetch.fetchProfesorByCursoId(con, 1);
			
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		

	}


}
