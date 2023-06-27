/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.SimpleCalcModel;
import View.SimpleCalcView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author menab
 */
public class SimpleCalcController {

    private SimpleCalcModel model;
    
    private final String info ="Esta es una calculadora simple por lo que tiene ciertas restriciones.\n"
            + "\n1. Solo se pueden realiazar operaciones con numeros."
            + "\n2. Las operaciones estan limitadas operacione basicas suma, resta, multiplicacion y division."
            + "\n3. No se pueden realizar operaciones cumpuestas."
            + "\n4. Para solicitar el resultado se debe presionar la tecla Entrer\n"
            + "\nSi se ignoran las indicaiones se mostrara un mensaje de error";

    public SimpleCalcController(SimpleCalcView view) {
        this.model = new SimpleCalcModel();
        view.txtOperation.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    model.setBase(view.txtOperation.getText());
                    double rs = model.executeOperation();
                    if (rs == model.FALSERETURN) {
                        JOptionPane.showMessageDialog(view, "Por favor revisar la operacion", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        view.lbResult.setText(String.valueOf(rs));
                    }
                }
            }
        });
        
        view.btnInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(view, info, "Informacion relevante", JOptionPane.INFORMATION_MESSAGE);
            }
        });
                 
    }

}
