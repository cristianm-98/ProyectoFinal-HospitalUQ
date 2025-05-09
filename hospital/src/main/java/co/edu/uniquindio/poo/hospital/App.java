package co.edu.uniquindio.poo.hospital;
import co.edu.uniquindio.poo.hospital.model.*;



import java.time.LocalDate;
import java.time.LocalTime;


public class App {
    public static void app (String[]args){

        Hospital hospital = new Hospital("8100","Hospital UQ");

        Persona persona1 = new Paciente("2530","Juan Linares",25,"256310","Manzana 50",null,"A+");
        Persona persona2 = new Medico("1425","Juan Perez",25,"31250","Calle 50 Norte",null,"1425",5,Especialidad.MEDICINA_GENERAL);
        Persona persona3=new Administrador("23410","Anderson Prada",30,"25301","Cra 25 Norte",null,"Jefe Sistemas","Citas");


        Usuario usuario1 = new Usuario("jlinares","1234",persona1,TipoUsuario.PACIENTE);
        persona1.setTheUsuario(usuario1);

        Usuario usuario2=new Usuario("jperez","451",persona2,TipoUsuario.MEDICO);
        persona2.setTheUsuario(usuario2);

        Usuario usuario3=new Usuario("anderprada","7412",persona3,TipoUsuario.ADMINISTRADOR);
        persona3.setTheUsuario(usuario3);

        Cita cita1=new Cita("001", LocalDate.of(2002,12,10),LocalTime.now(),LocalTime.now(),false);

        HistorialMedico historialMedico1=new HistorialMedico("001",LocalDate.of(2025,05,8),"Paciente de 25 años con antecedentes de dolor en la pierna" +
                "mas de 2 dias","dolor en parte superior",persona1);




    }
}
