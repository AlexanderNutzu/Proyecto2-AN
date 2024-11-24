/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;  

import ClasesPrincipales.Persona;  
import EDD.Arbol;  
import EDD.NodoA;  
import javax.swing.JFrame;  
import javax.swing.JOptionPane;  
import org.graphstream.graph.Graph;  
import org.graphstream.graph.implementations.MultiGraph;  
import org.graphstream.ui.swing_viewer.ViewPanel;  
import org.graphstream.ui.view.Viewer;  

/**  
 * Clase que representa una ventana para mostrar un árbol genealógico utilizando GraphStream.  
 *   
 * @author alexa  
 */  
public class MostrarArbol extends JFrame {  

    private Arbol arbol;          // Árbol genealógico a visualizar  
    private Viewer visor;         // Visor de GraphStream  
    private ViewPanel panelVista; // Panel para integrar el grafo en la ventana  
    private JFrame ventanaAnterior; // Ventana anterior a la que se debe regresar  

    /**  
     * Constructor que inicializa la ventana para mostrar el árbol genealógico.  
     *   
     * @param arbol Árbol genealógico a visualizar.  
     * @param ventanaAnterior Ventana desde la que se accede a esta ventana.  
     */  
    public MostrarArbol(Arbol arbol, JFrame ventanaAnterior) {  
        this.arbol = arbol;  
        this.ventanaAnterior = ventanaAnterior;  
        configurarVentana();  
        inicializarVisor();  
    }  

    /**  
     * Configura la ventana de JFrame.  
     */  
    private void configurarVentana() {  
        setTitle("Árbol Genealógico");  
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
        Graph grafo = new MultiGraph("Árbol Genealógico");  
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
     * Construye el grafo a partir del árbol genealógico.  
     *   
     * @param grafo El grafo a construir.  
     */  
    private void construirGrafo(Graph grafo) {  
        if (arbol.isEmpty()) {  
            JOptionPane.showMessageDialog(this, "El árbol está vacío.");  
            return;  
        }  

        agregarNodoYSubarbol(arbol.getRoot(), null, grafo);  

        grafo.setAttribute("ui.stylesheet",  
                "node { text-size: 14px; size: 30px; text-alignment: center; fill-color: rgb(255, 182, 193); }"  
                + "edge { size: 2px; }");  
    }  

    /**  
     * Agrega un nodo y su subárbol al grafo.  
     *   
     * @param nodoActual El nodo actual a agregar.  
     * @param padreId El ID del nodo padre.  
     * @param grafo El grafo al que se agrega el nodo.  
     */  
    private void agregarNodoYSubarbol(NodoA nodoActual, String padreId, Graph grafo) {  
        Persona persona = (Persona) nodoActual.getDato();  
        String nodoId = persona.getNombreUnico();  

        if (grafo.getNode(nodoId) == null) {  
            org.graphstream.graph.Node nodoVisual = grafo.addNode(nodoId);  
            nodoVisual.setAttribute("ui.label", persona.getNombreUnico());  
        }  

        if (padreId != null && grafo.getEdge(padreId + "-" + nodoId) == null) {  
            grafo.addEdge(padreId + "-" + nodoId, padreId, nodoId);  
        }  

        for (int i = 0; i < nodoActual.getHijos().getSize(); i++) {  
            NodoA hijo = (NodoA) nodoActual.getHijos().getValor(i);  
            agregarNodoYSubarbol(hijo, nodoId, grafo);  
        }  
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
