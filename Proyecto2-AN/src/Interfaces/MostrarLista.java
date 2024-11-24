/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;  

import ClasesPrincipales.Persona;  
import EDD.Lista;  
import EDD.Nodo;  
import javax.swing.JFrame;  
import javax.swing.JOptionPane;  
import org.graphstream.graph.Graph;  
import org.graphstream.graph.implementations.MultiGraph;  
import org.graphstream.ui.swing_viewer.ViewPanel;  
import org.graphstream.ui.view.Viewer;  

/**  
 * Clase que representa una ventana para mostrar una lista de personas utilizando GraphStream.  
 *   
 * @authour alexa  
 */  
public class MostrarLista extends JFrame {  

    private Lista lista;           // Lista de personas a visualizar  
    private Viewer visor;          // Visor de GraphStream  
    private ViewPanel panelVista;  // Panel para integrar el grafo en la ventana  
    private JFrame ventanaAnterior; // Ventana anterior a la que se debe regresar  

    /**  
     * Constructor que inicializa la ventana para mostrar la lista de personas.  
     *   
     * @param lista Lista de personas a visualizar.  
     * @param ventanaAnterior Ventana desde la que se accede a esta ventana.  
     */  
    public MostrarLista(Lista lista, JFrame ventanaAnterior) {  
        this.lista = lista;  
        this.ventanaAnterior = ventanaAnterior;  
        configurarVentana();  
        inicializarVisor();  
    }  

    /**  
     * Configura la ventana de JFrame.  
     */  
    private void configurarVentana() {  
        setTitle("Lista de Personas");  
        setSize(800, 600);  
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setLocationRelativeTo(null);  

        addWindowListener(new java.awt.event.WindowAdapter() {  
            @Override  
            public void windowClosing(java.awt.event.WindowEvent e) {  
                cerrarVisor();  
                if (ventanaAnterior != null) {  
                    ventanaAnterior.setVisible(true);  
                }  
            }  
        });  
    }  

    /**  
     * Inicializa el visor de GraphStream.  
     */  
    private void inicializarVisor() {  
        Graph grafo = new MultiGraph("Lista de Personas");  
        construirGrafo(grafo);  

        visor = grafo.display(false);  
        visor.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);  
        visor.enableAutoLayout();  

        if (panelVista == null) {  
            panelVista = (ViewPanel) visor.getDefaultView();  
            add(panelVista);  
        }  
    }  

    /**  
     * Construye el grafo a partir de la lista de personas.  
     *   
     * @param grafo El grafo a construir.  
     */  
    private void construirGrafo(Graph grafo) {  
        if (lista.isEmpty()) {  
            JOptionPane.showMessageDialog(this, "La lista está vacía.");  
            return;  
        }  

        Nodo actual = lista.getpFirst();  
        Nodo nodoAnterior = null;  

        while (actual != null) {  
            Persona persona = (Persona) actual.getDato();  
            String nodoId = persona.getNombreUnico();  

            // Crear nodo si no existe  
            if (grafo.getNode(nodoId) == null) {  
                org.graphstream.graph.Node nodoVisual = grafo.addNode(nodoId);  
                nodoVisual.setAttribute("ui.label", persona.getNombreUnico());  
            }  

            // Conectar el nodo con el anterior  
            if (nodoAnterior != null) {  
                Persona personaAnterior = (Persona) nodoAnterior.getDato();  
                String idAnterior = personaAnterior.getNombreUnico();  
                if (grafo.getEdge(idAnterior + "-" + nodoId) == null) {  
                    grafo.addEdge(idAnterior + "-" + nodoId, idAnterior, nodoId);  
                }  
            }  

            nodoAnterior = actual; // Actualizar el nodo anterior  
            actual = actual.getPnext(); // Avanzar al siguiente nodo  
        }  

        // Estilos del grafo  
        grafo.setAttribute("ui.stylesheet",  
                "node { text-size: 14px; size: 30px; text-alignment: center; fill-color: rgb(255, 182, 193); }" // Rojo claro  
                + "edge { size: 2px; }");  
    }  

    /**  
     * Cierra el visor y libera los recursos utilizados.  
     */  
    private void cerrarVisor() {  
        if (visor != null) {  
            visor.disableAutoLayout();  
            visor.close();  
        }  
        if (panelVista != null) {  
            remove(panelVista);  
            panelVista = null;  
        }  
    }  
}  
