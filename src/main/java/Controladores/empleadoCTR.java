package Controladores;

import Modelos.empleadoMOD;
import Vistas.sgrhFRMINFO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class empleadoCTR implements ActionListener{
    private final ArrayList<empleadoMOD> modelos;
    private final empleadoMOD modelo;
    private final sgrhFRMINFO vista;

    public empleadoCTR(ArrayList<empleadoMOD> modelos, empleadoMOD modelo, sgrhFRMINFO vista) {
        this.modelos = modelos;
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnAgregarEmp.addActionListener(this);
        this.vista.btnEditarEmp.addActionListener(this);
        this.vista.btnEliminarEmp.addActionListener(this);
        this.vista.btnLimpiarEmp.addActionListener(this);
        
        this.vista.tbEmpleados.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me){
                int fila = vista.tbEmpleados.getSelectedRow();
                
                vista.txtId.setText(vista.tbEmpleados.getValueAt(fila, 0).toString());
                vista.txtNombre.setText(vista.tbEmpleados.getValueAt(fila, 1).toString());
                vista.txtApellido1.setText(vista.tbEmpleados.getValueAt(fila, 2).toString());
                vista.txtApellido2.setText(vista.tbEmpleados.getValueAt(fila, 3).toString());
                vista.txtCedula.setText(vista.tbEmpleados.getValueAt(fila, 4).toString());
                vista.txtEdad.setText(vista.tbEmpleados.getValueAt(fila, 5).toString());                
            }
        });
    }

    public void iniciar(){
        vista.setTitle("Modulo Informacion Personal");
        vista.txtId.setText("0");
        vista.setVisible(true);
        cargarEmpleados();
    }
    
    public void cargarEmpleados(){
        modelos.clear();
        
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("ID");
        modelTable.addColumn("NOMBRE");
        modelTable.addColumn("PRIMER APELLIDO");
        modelTable.addColumn("SEGUNDO APELLIDO");
        modelTable.addColumn("CEDULA");
        modelTable.addColumn("EDAD");
        
        if (consultar(modelos)){
            if (!modelos.isEmpty()){
                for (empleadoMOD empleado : modelos) {
                    modelTable.addRow(new String[]{
                        String.valueOf(empleado.getId()),
                        empleado.getNombre(),
                        empleado.getApellido1(),
                        empleado.getApellido2(),
                        String.valueOf(empleado.getCedula()),
                        String.valueOf(empleado.getEdad())});
                }
            } else {
                JOptionPane.showMessageDialog(vista, "No hay registros",
                        "Sin empleados", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Error al cargar los empleados\n"
                    + "Consulte el error con Soporte Tecnico", "Error", JOptionPane.ERROR_MESSAGE);
        }
        vista.tbEmpleados.setModel(modelTable);
    }
    
    public void limpiar() {
        vista.txtId.setText("0");
        vista.txtNombre.setText("");
        vista.txtApellido1.setText("");
        vista.txtApellido2.setText("");
        vista.txtCedula.setText("");
        vista.txtEdad.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    private static boolean consultar(ArrayList<empleadoMOD> modelos){
        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM empleados";
        
        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                empleadoMOD empleado = new empleadoMOD(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5), 
                        rs.getInt(6));
                modelos.add(empleado);
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            return false;
        } finally {
            conexion.desConectar();
        }
    }
    
}
