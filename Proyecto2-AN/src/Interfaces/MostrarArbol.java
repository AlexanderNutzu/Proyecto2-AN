/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import ClasesPrincipales.Persona;
import EDD.Arbol;
import EDD.NodoA;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;

/**
 *
 * @author alexa
 */
public class MostrarArbol extends JFrame {

    private Arbol arbol;         // Árbol genealógico a visualizar
    private Viewer visor;       // Visor de GraphStream
    private ViewPanel panelVista; // Panel para integrar el grafo en la ventana
    private JFrame ventanaAnterior; // Ventana anterior a la que se debe regresar

   
    public MostrarArbol(Arbol arbol, JFrame ventanaAnterior) {
        this.arbol = arbol;
        this.ventanaAnterior = ventanaAnterior;
        configurarVentana();
        inicializarVisor();
    }

  
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


    private void construirGrafo(Graph grafo) {
        if (arbol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío.");
            return;
        }

       
        agregarNodoYSubarbol(arbol.getRoot(), null, grafo);

       
        grafo.setAttribute("ui.stylesheet",
                "node { text-size: 14px; size: 30px; text-alignment: center; fill-color: rgb(255, 182, 193); }" // Rojo claro
                        + "edge { size: 2px; }");
    }

   
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
