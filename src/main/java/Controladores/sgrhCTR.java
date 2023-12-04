package Controladores;

import Vistas.sgrhFRM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sgrhCTR implements ActionListener{
    private final sgrhFRM vista;

    public sgrhCTR(sgrhFRM vista) {
        this.vista = vista;
        
        this.vista.btnMIP.addActionListener(this);
        this.vista.btnMF.addActionListener(this);
        this.vista.btnMED.addActionListener(this);
        this.vista.btnNOM.addActionListener(this);
        this.vista.btnVAC.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("Sistema General de Recursos Humanos");
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnMIP) {
            
            return;
        }
    }
    
}
