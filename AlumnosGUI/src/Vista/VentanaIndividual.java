/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Alumno;
import dmp.SimpleCSVReader;
import dmp.SimpleCSVWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanielPM.dev
 */
public class VentanaIndividual extends javax.swing.JDialog {

    private List<Alumno> listaAlumnos = new ArrayList();
    SimpleCSVReader lector = new SimpleCSVReader();
    SimpleCSVWriter escritor = new SimpleCSVWriter();
    private final static String RUTA_IMPORTAR = "./src/archivos/importar.csv";
    private final static String RUTA_EXPORTAR = "./src/archivos/resultado.csv";
    DefaultTableModel dtm;

    /**
     * Creates new form FichaAlumno_Individual
     */
    public VentanaIndividual(java.awt.Frame parent, boolean modal, List<Alumno> listaAlumnos) {
        super(parent, modal);
        initComponents();
        this.listaAlumnos = listaAlumnos;
        this.dtm = new DefaultTableModel();
        this.jTable1.setModel(dtm);
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellidos");
        dtm.addColumn("Población");
        dtm.addColumn("Curso");
        dtm.addColumn("Email");
        dtm.addColumn("FechaMatricula");
        dtm.addColumn("Carnet");
        mostrarContactos();
    }

    public VentanaIndividual(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.dtm = new DefaultTableModel();
        this.jTable1.setModel(dtm);
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellidos");
        dtm.addColumn("Población");
        dtm.addColumn("Curso");
        dtm.addColumn("Email");
        dtm.addColumn("FechaMatricula");
        dtm.addColumn("Carnet");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgCurso = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelApellidos = new javax.swing.JLabel();
        labelPoblacion = new javax.swing.JLabel();
        labelCurso = new javax.swing.JLabel();
        labelMatricula = new javax.swing.JLabel();
        labelCarnet = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        txfApellidos = new javax.swing.JTextField();
        txfMatricula = new javax.swing.JTextField();
        txfPoblacion = new javax.swing.JTextField();
        cbCurso = new javax.swing.JComboBox<>();
        rbTengoCarnet = new javax.swing.JRadioButton();
        rbNoTengoCarnet = new javax.swing.JRadioButton();
        labelEmail = new javax.swing.JLabel();
        txfEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btVolverPrincipal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiCargarFichero = new javax.swing.JMenuItem();
        jmiGuardarFichero = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiSalir = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                formInputMethodTextChanged(evt);
            }
        });

        labelNombre.setText("Nombre:");

        labelApellidos.setText("Apellidos:");

        labelPoblacion.setText("Población:");

        labelCurso.setText("Curso:");

        labelMatricula.setText("Fecha de la Matricula:");

        labelCarnet.setText("Carnet de Conducir:");

        cbCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1º DAM", "2º DAM" }));

        btgCurso.add(rbTengoCarnet);
        rbTengoCarnet.setText("Tengo Carnet B");

        btgCurso.add(rbNoTengoCarnet);
        rbNoTengoCarnet.setSelected(true);
        rbNoTengoCarnet.setText("NO Tengo Carnet B");

        labelEmail.setText("Email:");

        jLabel1.setText("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombre)
                    .addComponent(labelMatricula)
                    .addComponent(labelPoblacion)
                    .addComponent(labelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(txfMatricula, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfPoblacion)
                    .addComponent(txfEmail))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelApellidos)
                        .addGap(41, 41, 41)
                        .addComponent(txfApellidos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelCarnet)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rbNoTengoCarnet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbTengoCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelCurso)
                        .addGap(95, 95, 95)
                        .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombre)
                            .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPoblacion)
                            .addComponent(txfPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelApellidos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCurso)
                            .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMatricula)
                            .addComponent(txfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(labelCarnet))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbTengoCarnet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbNoTengoCarnet)))
                        .addGap(35, 35, 35))))
        );

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 8, 5));

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionAñadir(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBorrar(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionEditar(evt);
            }
        });
        jPanel2.add(jButton3);

        btVolverPrincipal.setText("Volver a Ventana Principal");
        btVolverPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverVentanaPrincial(evt);
            }
        });
        jPanel2.add(btVolverPrincipal);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Poblacion", "Curso", "Email", "Fecha Matricula", "Carnet de Conducir"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickRegistro(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Archivo");

        jmiCargarFichero.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiCargarFichero.setMnemonic('C');
        jmiCargarFichero.setText("Cargar fichero CSV");
        jmiCargarFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionCargar(evt);
            }
        });
        jMenu1.add(jmiCargarFichero);

        jmiGuardarFichero.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiGuardarFichero.setMnemonic('G');
        jmiGuardarFichero.setText("Guardar fichero CSV");
        jmiGuardarFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionGuardar(evt);
            }
        });
        jMenu1.add(jmiGuardarFichero);
        jMenu1.add(jSeparator1);

        jmiSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jmiSalir.setMnemonic('S');
        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaliraccionSalir(evt);
            }
        });
        jMenu1.add(jmiSalir);

        jMenuBar1.add(jMenu1);

        jMenu3.setMnemonic('A');
        jMenu3.setText("Ayuda");

        jmiAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jmiAcerca.setText("Acerca de...");
        jmiAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lanzarAcercaDe(evt);
            }
        });
        jMenu3.add(jmiAcerca);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_formInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formInputMethodTextChanged

    private void volverVentanaPrincial(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverVentanaPrincial
        dispose();
    }//GEN-LAST:event_volverVentanaPrincial

    private void accionAñadir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionAñadir
        String nombre = txfNombre.getText();
        String apellidos = txfApellidos.getText();
        String poblacion = txfPoblacion.getText();
        String curso = cbCurso.getItemAt(cbCurso.getSelectedIndex());
        String email = txfEmail.getText();
        String fMatricula = txfMatricula.getText();
        boolean carnet = rbTengoCarnet.isSelected();

        Alumno alumno = new Alumno(nombre, apellidos, poblacion, curso, email, fMatricula, carnet);
        listaAlumnos.add(alumno);
        mostrarContactos();
    }//GEN-LAST:event_accionAñadir

    private void accionBorrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBorrar
        String nombre = txfNombre.getText();
        int posicion = this.posicionContacto(nombre);
        if (posicion != -1) { // Si lo encuentra lo borra
            listaAlumnos.remove(posicion);
        }
        mostrarContactos();
    }//GEN-LAST:event_accionBorrar

    private void accionEditar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionEditar
        String nombre = txfNombre.getText();
        String apellidos = txfApellidos.getText();
        String poblacion = txfPoblacion.getText();
        String curso = cbCurso.getItemAt(cbCurso.getSelectedIndex());
        String email = txfEmail.getText();
        String fMatricula = txfMatricula.getText();
        boolean carnet = rbTengoCarnet.isSelected();
        Alumno a = new Alumno(nombre, apellidos, poblacion, curso, email, fMatricula, carnet);

        int posicion = this.posicionContacto(nombre);
        if (posicion != -1) {
            Alumno alumno = listaAlumnos.get(posicion);
            alumno.setNombre(a.getNombre());
            alumno.setApellidos(a.getApellidos());
            alumno.setPoblacion(a.getPoblacion());
            alumno.setCurso(a.getCurso());
            alumno.setEmail(a.getEmail());
            alumno.setFechaMatricula(a.getFechaMatricula());
            alumno.setCarnet(a.isCarnet());
        }
        mostrarContactos();

    }//GEN-LAST:event_accionEditar

    private void accionGuardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionGuardar
        boolean exportacionExitosa = escritor.exportarAlumnosACSV(listaAlumnos, RUTA_EXPORTAR);

        // Mostrar mensaje según el resultado de la exportación
        if (exportacionExitosa) {
            JOptionPane.showMessageDialog(null, "Exportación a CSV completada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al exportar a CSV.");
        }
    }//GEN-LAST:event_accionGuardar

    private void jmiSaliraccionSalir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaliraccionSalir
        System.exit(0);
    }//GEN-LAST:event_jmiSaliraccionSalir

    private void lanzarAcercaDe(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lanzarAcercaDe
        AcercaDe info = new AcercaDe(this, true);
        info.setVisible(true);
    }//GEN-LAST:event_lanzarAcercaDe

    private void accionCargar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionCargar
        this.listaAlumnos = lector.cargarAlumnosDesdeCSV(RUTA_IMPORTAR);
        mostrarContactos();

        if (!listaAlumnos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se han cargado " + listaAlumnos.size() + " alumnos correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se han podido cargar los datos. La lista está vacía.");
        }
    }//GEN-LAST:event_accionCargar

    private void clickRegistro(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickRegistro
        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada != -1) { // Asegúrate de que haya una fila seleccionada
            // Obtiene los valores de las columnas de la fila seleccionada
            String nombre = (String) jTable1.getValueAt(filaSeleccionada, 0); // Cambia el índice según la columna
            String apellidos = (String) jTable1.getValueAt(filaSeleccionada, 1);
            String poblacion = (String) jTable1.getValueAt(filaSeleccionada, 2);
            String curso = (String) jTable1.getValueAt(filaSeleccionada, 3);
            String email = (String) jTable1.getValueAt(filaSeleccionada, 4);
            String fechaMatricula = (String) jTable1.getValueAt(filaSeleccionada, 5);
            boolean carnet = (Boolean) jTable1.getValueAt(filaSeleccionada, 6); // Asumiendo que es un boolean

            // Asigna los valores a los TextFields
            txfNombre.setText(nombre);
            txfApellidos.setText(apellidos);
            txfPoblacion.setText(poblacion);
            // Asumiendo que cbCurso es un JComboBox
            cbCurso.setSelectedItem(curso); // Asegúrate de que curso esté en la lista del ComboBox
            txfEmail.setText(email);
            txfMatricula.setText(fechaMatricula);

            // Asigna el estado del RadioButton basado en el valor de carnet
            rbTengoCarnet.setSelected(carnet); // Suponiendo que `rbTengoCarnet` es un JRadioButton
        }
    }//GEN-LAST:event_clickRegistro

    public void mostrarContactos() {
        txfNombre.setText("");
        txfApellidos.setText("");
        txfPoblacion.setText("");
        txfEmail.setText("");
        txfMatricula.setText("");
        dtm.setRowCount(0);

        for (Alumno a : listaAlumnos) {
            Object[] fila = new Object[7];
            fila[0] = a.getNombre();
            fila[1] = a.getApellidos();
            fila[2] = a.getPoblacion();
            fila[3] = a.getCurso();
            fila[4] = a.getEmail();
            fila[5] = a.getFechaMatricula();
            fila[6] = a.isCarnet();
            dtm.addRow(fila);
        }
        jTable1.setModel(dtm);
    }

    private int posicionContacto(String n) {
        if (listaAlumnos == null || listaAlumnos.isEmpty()) {
            return -1; // La lista está vacía o no inicializada
        }

        // Recorremos la lista buscando el alumno por su nombre
        for (int i = 0; i < listaAlumnos.size(); i++) {
            Alumno alumno = listaAlumnos.get(i);
            if (alumno.getNombre().equals(n)) {
                return i; // Devuelve el índice si el nombre coincide
            }
        }

        return -1; // No se encontró el alumno
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaIndividual dialog = new VentanaIndividual(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVolverPrincipal;
    private javax.swing.ButtonGroup btgCurso;
    private javax.swing.JComboBox<String> cbCurso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem jmiAcerca;
    private javax.swing.JMenuItem jmiCargarFichero;
    private javax.swing.JMenuItem jmiGuardarFichero;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelCarnet;
    private javax.swing.JLabel labelCurso;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelMatricula;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPoblacion;
    private javax.swing.JRadioButton rbNoTengoCarnet;
    private javax.swing.JRadioButton rbTengoCarnet;
    private javax.swing.JTextField txfApellidos;
    private javax.swing.JTextField txfEmail;
    private javax.swing.JTextField txfMatricula;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfPoblacion;
    // End of variables declaration//GEN-END:variables
}
