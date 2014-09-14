package ar.com.jorgesaw.modelo.buscadores.paneles;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import ar.com.jorgesaw.gui.comp.CreaComp;
import ar.com.jorgesaw.gui.comp.MyJTextCadena;
import ar.com.jorgesaw.gui.tabla.ModeloTabla;
import ar.com.jorgesaw.gui.tabla.MyJScrollPane;
import ar.com.jorgesaw.gui.vista.abstractos.AbstractVentanaTablaImpl;
import ar.com.jorgesaw.modelo.buscadores.control.interfaces.ControlBusquedaGen;
import ar.com.jorgesaw.modelo.buscadores.interfaces.PanelBusqBingoGUI;
import ar.com.jorgesaw.modelo.buscadores.interfaces.PanelBusqGUI;
import ar.com.jorgesaw.superbingo.gui.tabla.ModeloTablaBingoBusq;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;

public class PanelBusqGUIBingoImpl extends AbstractVentanaTablaImpl implements PanelBusqBingoGUI {

	private static final long serialVersionUID = 736541888060577147L;
	private TableRowSorter<ModeloTablaBingoBusq> sorter;
	
	private boolean filtrable = true;
	
	public PanelBusqGUIBingoImpl() {
		super();
		initComponentes();
		if (this.filtrable)
			addListenerFiltro();
	}
	
	public PanelBusqGUIBingoImpl(boolean filtrable) {
		super();
		this.filtrable = filtrable;
		initComponentes();
		if (this.filtrable)
			addListenerFiltro();
	}
	
	@Override
	public boolean isFiltrable() {
		return filtrable;
	}

	@Override
	public void setFiltrable(boolean filtrable) {
		this.filtrable = filtrable;
	}

	@Override
	public void setNameBoton(String nomBoton) {
		this.btnAceptar.setName(nomBoton);
		this.btnAceptar.setActionCommand(nomBoton);
		this.btnAceptar.setText(nomBoton);
		this.btnAceptar.setMnemonic(nomBoton.charAt(0));
	}
	
	@Override
	public String getNameBoton() {
		return this.btnAceptar.getName();
	}
	@Override
	public void setTitleLabel(String titleLabel) {
		this.lblBingos.setText(titleLabel); 
	}
	
	@Override
	public void cerrarVentana() {

	}

	@Override
	public void setTabla(JTable tabla) {
		super.setTabla(tabla);
		super.tabla.setFont(new java.awt.Font("Tahoma", 0, 16));
		super.tabla.setBackground(Color.lightGray);
		super.tabla.setForeground(Color.white);
		super.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		if (filtrable) {
			sorter = new TableRowSorter<ModeloTablaBingoBusq>((ModeloTablaBingoBusq) super.tabla.getModel());
			super.tabla.setRowSorter(sorter);
		}
		
		
//		scrollTabla.addtabla(tabla);
//		addTablaAPanel();
	}
	
	/*private void addTablaAPanel() {
		panelContTabla.removeAll();
		panelContTabla.setLayout(new BorderLayout());
		panelContTabla.add(scrollTabla, BorderLayout.CENTER);
		scrollTabla.updateUI();
	}*/
	
	@Override
	public void setControlador(ControlBusquedaGen c) {
		btnAceptar.addActionListener(c);
		btnAceptar.addKeyListener(c);
		tabla.addMouseListener(c);
		tabla.addKeyListener(c);
		txtDatos.addKeyListener(c);
	}
	
	@Override
	public boolean isValidarDatos(String nomComp) {
		super.getMapDatos().put(PanelBusqGUI.TEXT_DATOS, txtDatos.getText());
		return this.txtDatos.isValidado();
	}
	
	private void addListenerFiltro() {
		txtDatos.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				nuevoFiltro();
			}

			public void insertUpdate(DocumentEvent e) {
				nuevoFiltro();
			}

			public void removeUpdate(DocumentEvent e) {
				nuevoFiltro();
			}
		});
	}
	
	private void nuevoFiltro() {
		RowFilter<ModeloTabla<Bingo>, Object> rf = null;
		try {
			rf = RowFilter.regexFilter("(?i)".concat(txtDatos.getText()), 1);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}
	
	private void initComponentes() {
		panelSuperior = new javax.swing.JPanel();
		btnAceptar = CreaComp.creaBoton("Aceptar", PanelBusqBingoGUI.ACEPTAR, KeyEvent.VK_A, null);
        txtDatos = CreaComp.creaTextCadena(PanelBusqGUI.TEXT_DATOS, 0, 30, false);
        txtDatos.setValidado(true); // Me aseguro que esté validado porque al presionar ENTER sobre el botón la validación me dá false porque aún no se ejecutó ningún evento.
        lblBingos = CreaComp.creaLabel("", new java.awt.Font("Tahoma", 0, 18));
        panelContTabla = new javax.swing.JPanel();
        scrollTabla = new MyJScrollPane();
        
        txtDatos.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 18));
        txtDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBingos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDatos)
                    .addComponent(lblBingos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelContTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout panelContTablaLayout = new javax.swing.GroupLayout(panelContTabla);
        panelContTabla.setLayout(panelContTablaLayout);
        panelContTablaLayout.setHorizontalGroup(
            panelContTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelContTablaLayout.setVerticalGroup(
            panelContTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
	}
	
	private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel lblBingos;
//    private javax.swing.JPanel panelContTabla;
    private javax.swing.JPanel panelSuperior;
    private MyJTextCadena txtDatos;
//    private MyJScrollPane scrollTabla;
}