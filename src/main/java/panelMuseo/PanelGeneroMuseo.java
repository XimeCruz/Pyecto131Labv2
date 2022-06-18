/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panelMuseo;

import MainWindow.MainWindow;
import estruc.museo.LSMuseo;
import estruc.museo.Museo;
import estruc.museo.NodoM;
import estruc.persona.NodoV;
import estruc.produccion.NodoP;
import estruc.sala.NodoS;

/**
 *
 * @author Jeloska Chavez
 */
public class PanelGeneroMuseo extends javax.swing.JPanel {

    /**
     * Creates new form PanelGeneroMuseo
     */
    private MainWindow mainWidnow;
    private LSMuseo museos;

    public PanelGeneroMuseo(MainWindow mainWindow) {
        initComponents();
        museos = mainWindow.getListaMuseos();
        museos = ordenar(museos, "F");
        System.out.println("Ordenando");
        museos.mostrar();
        datosATabla();
    }

    public int contarGenero(Museo m, String g) {
        NodoS r = m.getListaSalas().getP();
        int c = 0;
        while (r != null) {
            NodoP s = r.getSala().getListaProducciones().getP();
            while (s != null) {
                NodoV w = s.getProduccion().getListaVisitantes().getP();
                while (w != null) {
                    if (g.equals("all")) {
                        c++;
                    } else {
                        if (w.getDato().getGenero().equals(g)) {
                            c++;
                        }

                    }

                    w = w.getSig();
                }
                s = s.getSig();
            }
            r = r.getSig();
        }

        return c;
    }

    public Museo buscarMayor(LSMuseo a, String g) {
        NodoM r = a.getP();
        int may = contarGenero(r.getMuseo(), g);
        NodoM nodoM = r;
        while (r != null) {
            int vis = contarGenero(r.getMuseo(), g);

            if (vis > may) {
                may = vis;
                nodoM = r;
            }
            r = r.getSig();
        }

        r = a.getP();
        NodoM w = r;

        while (r != null) {
            if (r.equals(nodoM)) {
                if (r.equals(a.getP())) {
                    a.setP(r.getSig());
                } else {
                    w.setSig(r.getSig());
                }
                return r.getMuseo();

            }
            w = r;
            r = r.getSig();
        }
        return null;
    }

    public LSMuseo ordenar(LSMuseo a, String g) {
        int nNodos = a.nroNodos();

        LSMuseo aux = new LSMuseo();
        for (int i = 1; i <= nNodos; i++) {
            Museo may = buscarMayor(a, g);
            aux.adiFinal(may);
        }

        a = aux;

        return a;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new componentes.CustomTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        comboBoxGenero = new javax.swing.JComboBox<>();

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Tipo", "Circuito", "Nro. Asistentes", "F", "M"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 104));
        jLabel16.setText("Género");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 104));
        jLabel17.setText("Museos");

        comboBoxGenero.setBackground(new java.awt.Color(218, 228, 232));
        comboBoxGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M", " " }));
        comboBoxGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxGeneroItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(comboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(566, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(comboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jLabel17)
                    .addContainerGap(498, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
     public void datosATabla() {
        tabla.clearTable();

        NodoM q = museos.getP();
        while (q != null) {
            Museo museo = (Museo) q.getMuseo();
            int cf = contarGenero(museo, "F");
            int ct = contarGenero(museo, "all");
            MuseoAFila(museo, cf, ct - cf, ct);
            q = q.getSig();
        }
    }//nombre, tipo, direccion, circuito

    private void MuseoAFila(Museo x, int cf, int cm, int t) {
        Object[] arr = new Object[]{x.getId(), x.getNombre(), x.getTipo(), x.getCircuito(), t, cf, cm};
        tabla.addRow(arr);

    }
    private void comboBoxGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxGeneroItemStateChanged
        // TODO add your handling code here:
        museos = ordenar(museos, comboBoxGenero.getSelectedItem().toString());
        datosATabla();


    }//GEN-LAST:event_comboBoxGeneroItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxGenero;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.CustomTable tabla;
    // End of variables declaration//GEN-END:variables
}
