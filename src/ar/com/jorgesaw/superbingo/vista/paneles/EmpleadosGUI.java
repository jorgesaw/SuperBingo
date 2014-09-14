package ar.com.jorgesaw.superbingo.vista.paneles;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.gui.VistaCRUDTablaImpl;
import ar.com.jorgesaw.gui.comp.CreaComp;
import ar.com.jorgesaw.gui.comp.MyJComboBox;
import ar.com.jorgesaw.gui.comp.MyJDateChooser;
import ar.com.jorgesaw.gui.comp.MyJTextCadena;
import ar.com.jorgesaw.gui.comp.MyJTextCadenaCiudad;
import ar.com.jorgesaw.gui.comp.MyJTextNum;
import ar.com.jorgesaw.gui.comp.control.CtrlCiudad;
import ar.com.jorgesaw.gui.comp.control.CtrlDDN;
import ar.com.jorgesaw.gui.control.CtrlGenCRUDBase;
import ar.com.jorgesaw.gui.vista.interfaces.CompBasico;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;
import ar.com.jorgesaw.superbingo.vista.SuperBingoTheme;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelDireccTel;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelEmpleados;

public class EmpleadosGUI extends VistaCRUDTablaImpl implements IPanelEmpleados {

	private static final long serialVersionUID = -9206736654947319532L;
	private final int cantDatosValidar = 8;
	
	public EmpleadosGUI() {
		super();
		super.setTotalDatosValidar(cantDatosValidar);
		initComponentes();
		addCtrlCiudad();
		addCtrlDDN();
	}

	@Override
	public void addProvincias(DefaultComboBoxModel<Object> comboProvModelo) {
		comboProv.setModel(comboProvModelo);
		try {

			comboProv.setSelectedIndex(0);
			// Por defecto aparece el texto validado.
			comboProv.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}	
	}

	@Override
	public void mostrarDatos(HashMap<String, Object> mapDatos) {
		
	}

	@Override
	public void limpiarDatos() {
		txtDNI.resetValue();
		txtDNI.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		txtApe.resetValue();
		txtApe.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		txtNom.resetValue();
		txtNom.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		txtDir.resetValue();
		txtDir.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		txtAltura.resetValue();
		txtAltura.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		txtPiso.resetValue();
		txtPiso.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		txtDepto.resetValue();
		txtDepto.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		comboProv.resetValue();
		txtCiu.resetValue();
		txtCiu.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		txtPrefCel.resetValue();
		//txtPrefCel.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		txtCel.resetValue();
		txtCel.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		txtPrefTel.resetValue();
		//txtPrefTel.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		txtTel.resetValue();
		txtTel.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		radioVendedor.setSelected(false);
		radioCobrador.setSelected(false);
		txtAreaObserv.setText("");
		dateChooserAltaEmp.resetValue();
		dateChooserAltaEmp.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
	}

	@Override
	public void setControlador(CtrlGenCRUDBase c) {
		super.btnGuard.addActionListener(c); super.btnGuard.addKeyListener(c);
		super.btnNuevo.addActionListener(c); super.btnNuevo.addKeyListener(c);
		super.btnActual.addActionListener(c); super.btnActual.addKeyListener(c);
		super.btnCerrar.addActionListener(c); super.btnCerrar.addKeyListener(c);
		super.btnListar.addActionListener(c); super.btnListar.addKeyListener(c);
		super.btnElim.addActionListener(c); super.btnElim.addKeyListener(c);
		super.tabla.addMouseListener(c);
	}

	@Override
	public void setTabla(JTable tabla) {
		super.setTabla(tabla);
		super.tabla.setFont(new java.awt.Font("Tahoma", 0, 16));
		super.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	@Override
	public void avisarCambioComp(CompBasico comp) {
		super.avisarCambioComp(comp);
		
		// Si no se eligió ninguna provincia se borra la ciudad posiblemente seleccionada.
		if (comp.getNomComp().equals(IPanelEmpleados.COMBO_PROV) && comp.isValidado() == false) {
				txtCiu.resetValue();
				//super.setCantDatosValidados(super.getCantDatosValidados() - 1);
//				super.getMapDatos().put(IPanelDireccTel.TEXT_CIU, null);
		} else if (comp.getNomComp().equals(IPanelEmpleados.TEXT_CIU)) {
			// Seleccionada la ciudad si el celular o teléfono están vacíos se completa con el DDN de la ciudad.
			if (txtCel.getText().length() == 0 && comp.getValue() != null) {  
				txtPrefCel.setCiudad((Ciudad) comp.getValue());
				txtPrefCel.setText( ((Ciudad) comp.getValue()).getDDN() );
			}
			if (txtTel.getText().length() == 0 && comp.getValue() != null) {
				txtPrefTel.setText( ((Ciudad) comp.getValue()).getDDN() );
				txtPrefTel.setCiudad((Ciudad) comp.getValue());
			}
		}
		
		super.habilitarBoton(VistaCRUD.GUARDAR, super.isValidarDatos());
//		System.out.println("CANT Validados: " + super.getCantDatosValidados() + 
//				" de un total de: " + this.cantDatosValidar);
	}
	
	private void addCtrlCiudad() {
		CtrlCiudad control = new CtrlCiudad(txtCiu, comboProv);
		txtCiu.addKeyListener(control);
		comboProv.addActionListener(control);
	}
	
	private void addCtrlDDN() {
		HashMap<String, MyJTextCadenaCiudad> mapText = new HashMap<String, MyJTextCadenaCiudad>();
		mapText.put(IPanelEmpleados.TEXT_DDN_TEL, txtPrefTel);
		mapText.put(IPanelEmpleados.TEXT_DDN_CEL, txtPrefCel);
		
		CtrlDDN control = new CtrlDDN(mapText);
		txtPrefTel.addFocusListener(control);
		txtPrefCel.addFocusListener(control);
	}
	
	@SuppressWarnings("deprecation")
	private void initComponentes() {
		Font fuenteLabel = new java.awt.Font("SansSerif", 0, 12);
		
		panelDatos          = new javax.swing.JPanel();
        panelDatosBasicos   = new javax.swing.JPanel();
        txtAreaObserv       = new JTextArea();
        txtDNI              = CreaComp.creaTextNum(IPanelEmpleados.TEXT_DNI, 1, 
        		IPanelEmpleados.MAX_LONG_DNI, true);
        lblDNI              = CreaComp.creaLabel("DNI:", fuenteLabel);
        lblApe              = CreaComp.creaLabel("Apellido:", fuenteLabel);
        txtApe              = CreaComp.creaTextCadena(IPanelEmpleados.TEXT_APE, 1, 
        		IPanelEmpleados.MAX_LONG_APE, true);
        txtNom              = CreaComp.creaTextCadena(IPanelEmpleados.TEXT_NOM, 1, 
        		IPanelEmpleados.MAX_LONG_NOMBRE, true);
        lblNom              = CreaComp.creaLabel("Nombre:", fuenteLabel);
        lblDir              = CreaComp.creaLabel("Dirección:", fuenteLabel);
        txtDir              = CreaComp.creaTextCadena(IPanelEmpleados.TEXT_DIR, 1, 
        		IPanelEmpleados.MAX_LONG_DIRECCION, true);
        lblAltura           = CreaComp.creaLabel("Altura:", fuenteLabel);
        txtAltura           = CreaComp.creaTextNum(IPanelEmpleados.TEXT_ALTURA, 1, 
        		IPanelEmpleados.MAX_LONG_ALTURA, true);
        lblObserv           = CreaComp.creaLabel("Observaciones:", fuenteLabel);
        lblPiso             = CreaComp.creaLabel("Piso:", fuenteLabel);
        txtPiso             = CreaComp.creaTextCadena(IPanelEmpleados.TEXT_PISO, 1, 
        		IPanelEmpleados.MAX_LONG_PISO, false);
        lblDepto            = CreaComp.creaLabel("Depto.:", fuenteLabel);
        txtDepto            = CreaComp.creaTextCadena(IPanelEmpleados.TEXT_DEPTO, 1, 
        		IPanelEmpleados.MAX_LONG_DEPTO, false);
        panelDatosBasico2   = new javax.swing.JPanel();
        lblCel              = CreaComp.creaLabel("Celular:", fuenteLabel);
        lblTel              = CreaComp.creaLabel("Teléfono:", fuenteLabel);
        txtCel          	= CreaComp.creaTextNum(IPanelEmpleados.TEXT_CEL, 1, 
        		IPanelEmpleados.MAX_LONG_CEL, false);
        txtTel          	= CreaComp.creaTextNum(IPanelEmpleados.TEXT_TEL, 1, 
        		IPanelEmpleados.MAX_LONG_TEL, false);
        lblFechIng          = CreaComp.creaLabel("Fecha de ingreso:", fuenteLabel);
        panelCategoria      = new javax.swing.JPanel();
        radioVendedor       = new javax.swing.JRadioButton();
        radioCobrador       = new javax.swing.JRadioButton();
        lblCiu              = CreaComp.creaLabel("Ciudad:", fuenteLabel);
        txtCiu             = new MyJTextCadenaCiudad(IPanelEmpleados.TEXT_CIU, 1, 
        		IPanelEmpleados.MAX_LONG_CEL, true);
        lblProv             = CreaComp.creaLabel("Provincia:", fuenteLabel);
        txtPrefCel          = new MyJTextCadenaCiudad(IPanelEmpleados.TEXT_DDN_CEL, 1, 
        		IPanelEmpleados.MAX_LONG_DDN, false);
        txtPrefTel          = new MyJTextCadenaCiudad(IPanelEmpleados.TEXT_DDN_TEL, 1, 
        		IPanelEmpleados.MAX_LONG_DDN, false);
        dateChooserAltaEmp  = new MyJDateChooser(IPanelEmpleados.FECHA_ALTA, true);// new com.toedter.calendar.JDateChooser();
        comboProv           = CreaComp.creaCombo(IPanelDireccTel.COMBO_PROV, true);
        panelABM            = new javax.swing.JPanel();
        panelABM2           = new javax.swing.JPanel();
        scrollObserv        = new javax.swing.JScrollPane();

        // ***********************************************************
        txtAreaObserv.setName(IPanelEmpleados.TEXT_OBSERV);
        txtDNI.setMsgAsociado(lblDNI);
        txtDNI.setNextFocusableComponent(txtApe);
        txtDNI.addSuscriptor(this);
        txtApe.setMsgAsociado(lblApe);
        txtApe.setNextFocusableComponent(txtNom);
        txtApe.addSuscriptor(this);
        txtNom.setMsgAsociado(lblNom);
        txtNom.setNextFocusableComponent(txtDir);
        txtNom.addSuscriptor(this);
        txtDir.setMsgAsociado(lblDir);
        txtDir.setNextFocusableComponent(txtAltura);
        txtDir.addSuscriptor(this);
        txtAltura.setMsgAsociado(lblAltura);
        txtAltura.setNextFocusableComponent(txtPiso);
        txtAltura.addSuscriptor(this);
        txtPiso.setMsgAsociado(lblPiso);
        txtPiso.setNextFocusableComponent(txtDepto);
        txtPiso.addSuscriptor(this);
        txtDepto.setMsgAsociado(lblDepto);
        txtDepto.setNextFocusableComponent(comboProv);
        txtDepto.addSuscriptor(this);
        comboProv.setMsgAsociado(lblProv);
        comboProv.setNextFocusableComponent(txtCiu);
        comboProv.addSuscriptor(this);
        txtCiu.setMsgAsociado(lblCiu);
        txtCiu.setNextFocusableComponent(txtCel);
        txtCiu.addSuscriptor(this);
//        txtCiu.setEditable(false);
        txtCel.setMsgAsociado(lblCel);
        txtCel.setNextFocusableComponent(txtTel);
        txtCel.addSuscriptor(this);
//        txtPrefCel.setMsgAsociado(lblCel);
        txtPrefCel.setNextFocusableComponent(txtCel);
        txtPrefCel.addSuscriptor(this);
        txtTel.setMsgAsociado(lblCel);
        txtTel.setNextFocusableComponent((Component) dateChooserAltaEmp.getDateEditor());
        txtTel.addSuscriptor(this);
//        txtPrefTel.setMsgAsociado(lblTel);
        txtPrefTel.setNextFocusableComponent(txtTel);
        txtPrefTel.addSuscriptor(this);
        dateChooserAltaEmp.setDateFormatString("dd-MM-yyyy");
        dateChooserAltaEmp.setMsgAsociado(lblFechIng);
        dateChooserAltaEmp.setNextFocusableComponent(radioVendedor);
        dateChooserAltaEmp.addSuscriptor(this);
        
        radioVendedor.setText("Vendedor");
        radioCobrador.setText("Cobrador");
        
        radioCobrador.setMnemonic(KeyEvent.VK_C);
        radioCobrador.setNextFocusableComponent(txtAreaObserv);
        radioVendedor.setMnemonic(KeyEvent.VK_V);
        radioVendedor.setNextFocusableComponent(txtAreaObserv);
        ButtonGroup grupoRadio = new ButtonGroup();
        grupoRadio.add(radioCobrador); grupoRadio.add(radioVendedor);
        radioVendedor.setSelected(true);

        txtAreaObserv.setColumns(20);
        txtAreaObserv.setRows(5);
        scrollObserv.setViewportView(txtAreaObserv);
        
        super.habilitarBoton(VistaCRUD.GUARDAR, false);
        super.habilitarBoton(VistaCRUD.ACTUAL, false);
        super.habilitarBoton(VistaCRUD.ELIM, false);
        // ***********************************************************

        panelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelDatosBasicosLayout = new javax.swing.GroupLayout(panelDatosBasicos);
        panelDatosBasicos.setLayout(panelDatosBasicosLayout);
        panelDatosBasicosLayout.setHorizontalGroup(
            panelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosBasicosLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosBasicosLayout.createSequentialGroup()
                        .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosBasicosLayout.createSequentialGroup()
                        .addGroup(panelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblApe, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDatosBasicosLayout.createSequentialGroup()
                                .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPiso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDepto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtApe, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNom, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2))
        );
        panelDatosBasicosLayout.setVerticalGroup(
            panelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosBasicosLayout.createSequentialGroup()
                .addGroup(panelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNI)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApe)
                    .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDir)
                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAltura)
                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPiso)
                    .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepto)
                    .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoría", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 11))); // NOI18N

        javax.swing.GroupLayout panelCategoriaLayout = new javax.swing.GroupLayout(panelCategoria);
        panelCategoria.setLayout(panelCategoriaLayout);
        panelCategoriaLayout.setHorizontalGroup(
            panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCategoriaLayout.createSequentialGroup()
                .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioVendedor)
                    .addComponent(radioCobrador))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelCategoriaLayout.setVerticalGroup(
            panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCategoriaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(radioVendedor)
                .addGap(18, 18, 18)
                .addComponent(radioCobrador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelDatosBasico2Layout = new javax.swing.GroupLayout(panelDatosBasico2);
        panelDatosBasico2.setLayout(panelDatosBasico2Layout);
        panelDatosBasico2Layout.setHorizontalGroup(
            panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosBasico2Layout.createSequentialGroup()
                .addGroup(panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCel)
                    .addComponent(lblCiu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProv, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDatosBasico2Layout.createSequentialGroup()
                        .addGroup(panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTel)
                            .addComponent(lblFechIng))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrefTel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrefCel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCiu)
                    .addComponent(txtCel)
                    .addComponent(txtTel)
                    .addComponent(dateChooserAltaEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboProv, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelDatosBasico2Layout.setVerticalGroup(
            panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosBasico2Layout.createSequentialGroup()
                .addGroup(panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDatosBasico2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProv)
                            .addComponent(comboProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCiu)
                            .addComponent(txtCiu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCel)
                            .addComponent(txtPrefCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTel)
                            .addComponent(txtPrefTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosBasico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosBasico2Layout.createSequentialGroup()
                                .addComponent(lblFechIng)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosBasico2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dateChooserAltaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addComponent(panelDatosBasicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatosBasico2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObserv, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollObserv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblObserv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollObserv)
                        .addContainerGap())
                    .addComponent(panelDatosBasicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDatosBasico2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnNuevo.setText("Nuevo");

        btnGuard.setText("Guardar");

        btnActual.setText("Actualizar");

        javax.swing.GroupLayout panelABMLayout = new javax.swing.GroupLayout(panelABM);
        panelABM.setLayout(panelABMLayout);
        panelABMLayout.setHorizontalGroup(
            panelABMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelABMLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnNuevo)
                .addGap(29, 29, 29)
                .addComponent(btnActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuard)
                .addGap(43, 43, 43))
        );
        panelABMLayout.setVerticalGroup(
            panelABMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelABMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelABMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelABMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnActual)
                        .addComponent(btnNuevo))
                    .addComponent(btnGuard))
                .addContainerGap())
        );

        panelContTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelContTablaLayout = new javax.swing.GroupLayout(panelContTabla);
        panelContTabla.setLayout(panelContTablaLayout);
        panelContTablaLayout.setHorizontalGroup(
            panelContTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelContTablaLayout.setVerticalGroup(
            panelContTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelABM2Layout = new javax.swing.GroupLayout(panelABM2);
        panelABM2.setLayout(panelABM2Layout);
        panelABM2Layout.setHorizontalGroup(
            panelABM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelABM2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListar)
                .addGap(18, 18, 18)
                .addComponent(btnElim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );
        panelABM2Layout.setVerticalGroup(
            panelABM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelABM2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelABM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListar)
                    .addComponent(btnElim)
                    .addComponent(btnCerrar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelABM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelContTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelABM2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelABM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelContTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelABM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
	}
	
	private MyJComboBox<Object> comboProv;
	private MyJDateChooser dateChooserAltaEmp;
    private MyJTextNum txtCel;
    private MyJTextNum txtTel;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblApe;
    private javax.swing.JLabel lblCel;
    private javax.swing.JLabel lblCiu;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDepto;
    private javax.swing.JLabel lblDir;
    private javax.swing.JLabel lblFechIng;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblObserv;
    private javax.swing.JLabel lblPiso;
    private javax.swing.JLabel lblProv;
    private javax.swing.JLabel lblTel;
    private javax.swing.JPanel panelABM;
    private javax.swing.JPanel panelABM2;
    private javax.swing.JPanel panelCategoria;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelDatosBasico2;
    private javax.swing.JPanel panelDatosBasicos;
    private javax.swing.JRadioButton radioCobrador;
    private javax.swing.JRadioButton radioVendedor;
    private javax.swing.JTextArea txtAreaObserv;
    private MyJTextCadena txtAltura;
    private MyJTextCadena txtApe;
    private MyJTextNum txtDNI;
    private MyJTextCadena txtDepto;
    private MyJTextCadena txtDir;
    private MyJTextCadena txtNom;
    private MyJTextCadena txtPiso;
    private MyJTextCadenaCiudad txtPrefCel;
    private MyJTextCadenaCiudad txtPrefTel;
    private MyJTextCadenaCiudad txtCiu;
    private javax.swing.JScrollPane scrollObserv;
}