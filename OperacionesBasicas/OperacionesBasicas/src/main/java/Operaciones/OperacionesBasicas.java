/*1
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import javax.swing.JOptionPane;

/**
 *
 * @author daguilae
 */
public class OperacionesBasicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        float opc=0,dato1=0,dato2=0,result=0;

        String nombre = JOptionPane.showInputDialog("Ingrese su Nombre");
        String gen = JOptionPane.showInputDialog("Ingrese su Genero, F / M");
        if (gen.equals("F")) {
            System.out.println("BIENVENIDA" + " " + nombre);
        }else{
            System.out.println("BIENVENIDO" + " " + nombre);
        }
        System.out.println("1.Sumar \n2.Restar \n3.Multiplicar \n4.Dividir \n5.Promedio \nOtro numero.-> Salir");
        System.out.println("Seleccione una opcion: ");
        opc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese opcion: "));

        if(opc>0&&opc<6){
            dato1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese primer numero: "));
            dato2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese segundo numero numero: "));
        if(opc!=0){
            if(opc==1)
                result=dato1+dato2;
            if(opc==2)
                result=dato1-dato2;
            if(opc==3)
                result=dato1*dato2;
            if(opc==4)
                result=dato1/dato2;
            if(opc==5)
                result=(dato1+dato2)/2;
            System.out.print("El resultado es: ");
            System.out.println(result);
        }
        JOptionPane.showMessageDialog(null, "El resultado es: "+result);
        }
            System.out.println("saliendo...");
            JOptionPane.showMessageDialog(null,"Gracias por Participar");        
    }
    
}