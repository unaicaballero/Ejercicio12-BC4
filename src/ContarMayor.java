import java.sql.*;

public class ContarMayor {
    public static void main(String[] args) {

        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        String sql = "SELECT COUNT(*) AS NUMERO " +
                " FROM EJEMPLOCONEXION " +
                " WHERE SALARIO > 3000";

        try(Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = conn.createStatement();) {

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int cuenta = rs.getInt("NUMERO");
                System.out.println("Empleados con sueldo mayor a 3000: " + cuenta);
            }

        }catch(SQLException e ){
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}