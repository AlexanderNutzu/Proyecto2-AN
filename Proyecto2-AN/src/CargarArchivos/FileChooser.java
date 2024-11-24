/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CargarArchivos;  

import java.io.File;  
import javax.swing.JFileChooser;  
import javax.swing.JFrame;  
import javax.swing.JOptionPane;  
import javax.swing.filechooser.FileNameExtensionFilter;  

/**  
 * Clase que proporciona una interfaz gráfica para seleccionar archivos.  
 * Permite al usuario elegir archivos JSON desde su sistema de archivos.  
 *   
 * Author: alexa  
 */  
public class FileChooser {  
    private JFrame ventana;  

    /**  
     * Constructor de la clase FileChooser.  
     *   
     * @param ventana el JFrame en el que se abrirá el JFileChooser.  
     */  
    public FileChooser(JFrame ventana) {  
        this.ventana = ventana;  
    }  

    /**  
     * Abre un diálogo para seleccionar un archivo JSON.  
     * Muestra un filtro que limita la selección a archivos con la extensión .json.  
     *   
     * @return la ruta absoluta del archivo seleccionado como una cadena,   
     *         o null si no se seleccionó ningún archivo.  
     */  
    public String abrirArchivo() {  
        JFileChooser fc = new JFileChooser();  
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");        
        fc.setFileFilter(filtro);  

        int seleccion = fc.showOpenDialog(ventana);  

        if (seleccion == JFileChooser.APPROVE_OPTION) {  
            File fichero = fc.getSelectedFile();  
            return fichero.getAbsolutePath();  
        } else {  
            JOptionPane.showMessageDialog(ventana, "No se ha seleccionado ningún archivo.");  
            return null;  
        }  
    }  
}  