package Controladores;

import Modelos.autenticacionMOD;
import Vistas.sgrhFRMAUTH;
import com.mysql.cj.conf.PropertyKey;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JPasswordField;

public class autenticacionCTR implements ActionListener{
    private final ArrayList<autenticacionMOD> modelos;
    private final autenticacionMOD modelo;
    private final sgrhFRMAUTH vista;

    public autenticacionCTR(ArrayList<autenticacionMOD> modelos, autenticacionMOD modelo, sgrhFRMAUTH vista) {
        this.modelos = modelos;
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnIngresar.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("Sistema General de Recursos Humanos");
        vista.setVisible(true);
    }
    
    public void limpiar(){
        vista.txtUsuario.setText("");
        vista.txtPass.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
//        if (e.getSource() == vista.btnIngresar) {
//            if (consultarUsuario(vista.txtUsuario.getText(), vista.txtPass.getText())) {
//                JOptionPane.showMessageDialog(vista, "Bienvenido", "Exito", JOptionPane.INFORMATION_MESSAGE);
//                
//            } else {
//                JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
    }
    
    public static boolean consultarUsuario(String usuario, JPasswordField pass){
        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM autenticacion WHERE usuario = '" + usuario + "'";
        
        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                autenticacionMOD resultado = new autenticacionMOD(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
                String userPass = new String(pass.getPassword());
                if (userPass.equals(resultado.getPass())){
                    return true;
                }
            }
            return false;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            return false;
        } finally {
            conexion.desConectar();
        }
    }
    
}
