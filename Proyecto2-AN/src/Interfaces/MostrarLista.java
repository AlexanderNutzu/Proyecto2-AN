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
 *
 * @author alexa
 */

public class MostrarLista extends JFrame {

    private Lista lista;         
    private Viewer visor;      
    private ViewPanel panelVista; 
    private JFrame ventanaAnterior; 

    
    public MostrarLista(Lista lista, JFrame ventanaAnterior) {
        this.lista = lista;
        this.ventanaAnterior = ventanaAnterior;
        configurarVentana();
        inicializarVisor();
    }

    
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

            
            if (grafo.getNode(nodoId) == null) {
                org.graphstream.graph.Node nodoVisual = grafo.addNode(nodoId);
                nodoVisual.setAttribute("ui.label", persona.getNombreUnico());
            }

            
            if (nodoAnterior != null) {
                Persona personaAnterior = (Persona) nodoAnterior.getDato();
                String idAnterior = personaAnterior.getNombreUnico();
                if (grafo.getEdge(idAnterior + "-" + nodoId) == null) {
                    grafo.addEdge(idAnterior + "-" + nodoId, idAnterior, nodoId);
                }
            }

            nodoAnterior = actual; 
            actual = actual.getPnext(); 
        }

 
        grafo.setAttribute("ui.stylesheet",
                "node { text-size: 14px; size: 30px; text-alignment: center; fill-color: rgb(255, 182, 193); }" // Rojo claro
                        + "edge { size: 2px; }");
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
