package ar.com.jorgesaw.superbingo.vista.paneles;

import java.awt.Component;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

import ar.com.jorgesaw.gui.VistaCRUDImpl;
import ar.com.jorgesaw.gui.comp.CreaComp;
import ar.com.jorgesaw.gui.comp.MyJComboBox;
import ar.com.jorgesaw.gui.comp.MyJDateChooser;
import ar.com.jorgesaw.gui.comp.MyJList;
import ar.com.jorgesaw.gui.comp.MyJTextCadena;
import ar.com.jorgesaw.gui.control.CtrlGenCRUDBase;
import ar.com.jorgesaw.gui.vista.interfaces.CompBasico;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;
import ar.com.jorgesaw.superbingo.modelo.dto.enumerados.DiasSemana;
import ar.com.jorgesaw.superbingo.modelo.dto.enumerados.HoraLoteria;
import ar.com.jorgesaw.superbingo.vista.SuperBingoTheme;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.BingoNuevo;

public class BingoNuevoGUI extends VistaCRUDImpl implements BingoNuevo {

	private static final long serialVersionUID = -6203295356515469749L;
	private final int cantDatosValidar = 7;
	
	public BingoNuevoGUI() {
		super();
		super.setTotalDatosValidar(cantDatosValidar);
		initComponentes();
	}
	
	@Override
	public void addTipoLoterias(DefaultComboBoxModel<Object> modelTipoLot) {
		comboLoteria.setModel(modelTipoLot);
		try {
			comboLoteria.setSelectedIndex(0);
			comboLoteria.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void addHorasLot(DefaultComboBoxModel<Object> modelHorasLot) {
		comboHoraLot.setModel(modelHorasLot);
		try {
			comboHoraLot.setSelectedIndex(2);
			comboHoraLot.setValidado(true);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void addPerioJug(DefaultComboBoxModel<Object> modelPerioJug) {
		comboPerioJug.setModel(modelPerioJug);
		try {

			comboPerioJug.setSelectedIndex(0);
			// Por defecto aparece el texto validado.
			comboPerioJug.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}	
	}

	@Override
	public void addPremJug(DefaultListModel<Object> modelListPremJug) {
		listaPremJug.setModel(modelListPremJug);
		listaPremJug.setSelectedIndex(3); // Corresponde a los 20 números de la lotería.
		listaPremJug.avisarSuscriptores();
	}

	@Override
	public void addDiasJug(DefaultListModel<Object> modeListDiasJug) {
		listaDiasJug.setModel(modeListDiasJug);
		selListaDiasSemana(new int[] {0, 1, 2, 3, 4}); // Selecciona de lunes a viernes.
		listaDiasJug.avisarSuscriptores();
	}
	
	private void selListaDiasSemana(int[] dias) {
			listaDiasJug.setSelectedIndices(dias);
	}
	
	@Override
	public void setControlador(CtrlGenCRUDBase c) {
		btnGuard.addActionListener(c); btnGuard.addKeyListener(c);
		btnNuevo.addActionListener(c); btnNuevo.addKeyListener(c);
		btnCerrar.addActionListener(c); btnCerrar.addKeyListener(c);
	}
	
	private void seleccionarDiasSemana(JComboBox<Object> combo) {
		if(combo.getSelectedIndex() > 0) {
			selListaDiasSemana(new int[] {DiasSemana.SABADO.ordinal() - 2}); // Selecciona el sábado.
			listaDiasJug.setEnabled(false);
		} else {
			selListaDiasSemana(new int[] {0, 1, 2, 3, 4}); // Selecciona de lunes a viernes.
			listaDiasJug.setEnabled(true);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void avisarCambioComp(CompBasico comp) {
		super.avisarCambioComp(comp);
//		System.out.println("Elementos validados: " + super.getCantDatosValidados());
		if (comp.getNomComp().equals(BingoNuevo.PERIO_JUG)) {
			seleccionarDiasSemana((JComboBox<Object>) comp);
		}
		
		super.habilitarBoton(VistaCRUD.GUARDAR, super.isValidarDatos());
	}
	
	@Override
	public void mostrarDatos(HashMap<String, Object> mapDatos) {
		// Sin implementar.
	}

	@Override
	public void limpiarDatos() {
		txtNombre.resetValue();
		txtNombre.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		comboLoteria.resetValue();
		comboHoraLot.resetValue();
		comboPerioJug.resetValue();
		listaPremJug.resetValue();
		listaDiasJug.resetValue();
		dateChooserVence.resetValue();
		dateChooserVence.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		getMapDatos().clear();
	}
	
	@SuppressWarnings("deprecation")
	private void initComponentes() {
		
		Font fuenteLabel = new java.awt.Font("SansSerif", 0, 12);
		
		panelSup 		 	= new javax.swing.JPanel();
        btnPremios    	 	= new javax.swing.JButton();
        panelSup2   	 	= new javax.swing.JPanel();
        lblNombre 		 	= CreaComp.creaLabel("Nombre:", fuenteLabel);
        txtNombre 		 	= CreaComp.creaTextCadena(BingoNuevo.TEXT_NOM, 1, BingoNuevo.MAX_LONG_NOM, true);
        lblVence 		 	= CreaComp.creaLabel("Vencimiento:", fuenteLabel);
        dateChooserVence 	= new MyJDateChooser("HOLA", true);// new com.toedter.calendar.JDateChooser();
        lblLoteria 		 	= CreaComp.creaLabel("Lotería:", fuenteLabel);
        comboLoteria 	 	= CreaComp.creaCombo(BingoNuevo.LOTERIA, true);
        comboHoraLot 	 	= CreaComp.creaCombo(BingoNuevo.HORA_LOTERIA, true);
        lblPerioJug 	 	= CreaComp.creaLabel("Período:", fuenteLabel);
        comboPerioJug 	 	= CreaComp.creaCombo(BingoNuevo.PERIO_JUG, true);
        lblPremJug 	 	 	= CreaComp.creaLabel("Premios jugadas:", fuenteLabel);
        jScrollPanePremJug  = new javax.swing.JScrollPane();
        listaPremJug 		= CreaComp.creaLista(BingoNuevo.PREM_JUG, true);
        lblDiasJug 			= CreaComp.creaLabel("Días jugada:", fuenteLabel);
        jScrollPaneDiasJug 	= new javax.swing.JScrollPane();
        listaDiasJug 		= CreaComp.creaLista(BingoNuevo.DIAS_JUG, true);
        separador1 			= new javax.swing.JSeparator();
        panelInferior 		= new javax.swing.JPanel();

        // ********************************
        txtNombre.setColumns(50);
        txtNombre.setMsgAsociado(lblNombre);
        txtNombre.setNextFocusableComponent(comboLoteria);
        txtNombre.addSuscriptor(this);
        comboLoteria.setNextFocusableComponent(comboHoraLot);
        comboLoteria.setMsgAsociado(lblLoteria);
        comboLoteria.addSuscriptor(this);
        comboHoraLot.setNextFocusableComponent(comboPerioJug);
        comboHoraLot.addSuscriptor(this);
        ((MyJComboBox<Object>) comboHoraLot).setIndexSel(HoraLoteria.NOCTURNA.ordinal());
        comboPerioJug.setNextFocusableComponent(listaPremJug);
        comboPerioJug.setMsgAsociado(lblPerioJug);
        comboPerioJug.addSuscriptor(this);
        listaDiasJug.setNextFocusableComponent((Component) dateChooserVence.getDateEditor());
        listaDiasJug.setMsgAsociado(lblDiasJug);
        listaDiasJug.addSuscriptor(this);
        listaDiasJug.setValidado(true);
        ((MyJList<Object>) listaDiasJug).setIndexSel(new int[] {0, 1, 2, 3, 4}); // Selección de lunes a viernes.
        listaPremJug.setNextFocusableComponent(listaDiasJug);
        listaPremJug.setMsgAsociado(lblPremJug);
        listaPremJug.addSuscriptor(this);
        listaPremJug.setValidado(true);
        listaPremJug.setIndexSel(new int[] { 3 }); // Utiliza los números del 1 al 20.
        
        super.habilitarBoton(VistaCRUD.GUARDAR, false);
        
        dateChooserVence.setNextFocusableComponent(btnGuard);
        dateChooserVence.setDateFormatString("dd-MM-yyyy");
        dateChooserVence.setMsgAsociado(lblVence);
        dateChooserVence.addSuscriptor(this);
//        dateChooserVence.
        /*dateChooserVence.setMinSelectableDate(new Date());
        ((JComponent) dateChooserVence.getDateEditor()).setNextFocusableComponent(super.btnGuard);
        ((JComponent) dateChooserVence.getDateEditor()).addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) { }
			
			@Override
			public void keyReleased(KeyEvent e) { }
			
			@Override
			public void keyPressed(KeyEvent e) {
				int caracter = e.getKeyChar();
				if (caracter == (char) KeyEvent.VK_ENTER) {
					btnGuard.requestFocus();
				}
			}
		});*/
        // ********************************
        
        panelSup.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnPremios.setFont(btnPremios.getFont().deriveFont(btnPremios.getFont().getSize()+1f));
        btnPremios.setText("Premios");

        javax.swing.GroupLayout panelSupLayout = new javax.swing.GroupLayout(panelSup);
        panelSup.setLayout(panelSupLayout);
        panelSupLayout.setHorizontalGroup(
            panelSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSupLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnPremios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSupLayout.setVerticalGroup(
            panelSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPremios, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblVence.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jScrollPanePremJug.setViewportView(listaPremJug);
        jScrollPaneDiasJug.setViewportView(listaDiasJug);

        javax.swing.GroupLayout panelSup2Layout = new javax.swing.GroupLayout(panelSup2);
        panelSup2.setLayout(panelSup2Layout);
        panelSup2Layout.setHorizontalGroup(
            panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separador1)
            .addGroup(panelSup2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSup2Layout.createSequentialGroup()
                        .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSup2Layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(41, 41, 41)
                                .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboPerioJug, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelSup2Layout.createSequentialGroup()
                                        .addComponent(comboLoteria, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboHoraLot, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelSup2Layout.createSequentialGroup()
                                .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPremJug)
                                    .addComponent(jScrollPanePremJug, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDiasJug)
                                    .addComponent(jScrollPaneDiasJug, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooserVence, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblVence))))
                        .addContainerGap())
                    .addGroup(panelSup2Layout.createSequentialGroup()
                        .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPerioJug)
                            .addComponent(lblLoteria, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelSup2Layout.setVerticalGroup(
            panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSup2Layout.createSequentialGroup()
                .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboLoteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboHoraLot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLoteria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPerioJug)
                    .addComponent(comboPerioJug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDiasJug)
                        .addComponent(lblVence, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPremJug))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneDiasJug, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelSup2Layout.createSequentialGroup()
                        .addGroup(panelSup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooserVence, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPanePremJug, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );

        panelInferior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
                panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addComponent(btnCerrar)
                    .addContainerGap())
            );
            panelInferiorLayout.setVerticalGroup(
                panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelSup2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSup2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
	}


	private MyJComboBox<Object> comboHoraLot;
    private MyJComboBox<Object> comboLoteria;
    private MyJComboBox<Object> comboPerioJug;
//    private com.toedter.calendar.JDateChooser dateChooserVence;
    private MyJDateChooser dateChooserVence;
    private javax.swing.JButton btnPremios;
    private javax.swing.JScrollPane jScrollPaneDiasJug;
    private javax.swing.JScrollPane jScrollPanePremJug;
    private javax.swing.JLabel lblDiasJug;
    private javax.swing.JLabel lblLoteria;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPerioJug;
    private javax.swing.JLabel lblPremJug;
    private javax.swing.JLabel lblVence;
    private MyJList<Object> listaDiasJug;
    private MyJList<Object> listaPremJug;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelSup;
    private javax.swing.JPanel panelSup2;
    private javax.swing.JSeparator separador1;
    private MyJTextCadena txtNombre;
    
}