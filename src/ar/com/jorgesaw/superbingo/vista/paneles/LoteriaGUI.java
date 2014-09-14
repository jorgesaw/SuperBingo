package ar.com.jorgesaw.superbingo.vista.paneles;

import java.awt.Font;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import ar.com.jorgesaw.gui.VistaCRUDTablaImpl;
import ar.com.jorgesaw.gui.comp.CreaComp;
import ar.com.jorgesaw.gui.comp.MyJTextCadena;
import ar.com.jorgesaw.gui.control.CtrlGenCRUDBase;
import ar.com.jorgesaw.gui.vista.interfaces.CompBasico;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;
import ar.com.jorgesaw.superbingo.vista.SuperBingoTheme;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.ILoteriaGUI;

public class LoteriaGUI extends VistaCRUDTablaImpl implements ILoteriaGUI{

	private static final long serialVersionUID = -398116555810066245L;
	private final int cantDatosValidar = 2;
	
	public LoteriaGUI() {
		super();
		super.setTotalDatosValidar(cantDatosValidar);
		initComponentes();
	}

	@Override
	public void mostrarDatos(HashMap<String, Object> mapDatos) {
		super.setMapDatos(mapDatos);
		super.setCantDatosValidados(2);
		txtNomLoteria.setText(mapDatos.get(ILoteriaGUI.TEXT_NOM_LOT).toString());
		txtAliasLoteria.setText(mapDatos.get(ILoteriaGUI.TEXT_ALIAS_LOT).toString());
		super.habilitarBoton(VistaCRUD.GUARDAR, false);
		super.habilitarBoton(VistaCRUD.ACTUAL, false);
	}

	@Override
	public void limpiarDatos() {
		txtNomLoteria.resetValue();
		txtNomLoteria.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		txtAliasLoteria.resetValue();
		txtAliasLoteria.getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		super.setCantDatosValidados(0);
		getMapDatos().clear();
		super.habilitarBoton(VistaCRUD.ACTUAL, false);
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
	public void avisarCambioComp(CompBasico comp) {
		super.avisarCambioComp(comp);
		super.habilitarBoton(VistaCRUD.GUARDAR, super.isValidarDatos());
	}
	
	@Override
	public void setTabla(JTable tabla) {
		super.setTabla(tabla);
		super.tabla.setFont(new java.awt.Font("Tahoma", 0, 16));
		super.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	@SuppressWarnings("deprecation")
	private void initComponentes() {
		Font fuenteLabel = new java.awt.Font("SansSerif", 0, 12);
		
		panelDatos      = new javax.swing.JPanel();
		lblNomLoteria   = CreaComp.creaLabel("Nombre breve: ", fuenteLabel);
        lblAliasLoteria = CreaComp.creaLabel("Nombre lotería: ", fuenteLabel);
        txtNomLoteria   = CreaComp.creaTextCadena(ILoteriaGUI.TEXT_NOM_LOT, 1, ILoteriaGUI.MAX_LONG_NOM, true);
        txtAliasLoteria = CreaComp.creaTextCadena(ILoteriaGUI.TEXT_ALIAS_LOT, 1, ILoteriaGUI.MAX_LONG_ALIAS, true);
        panelABM        = new javax.swing.JPanel();
        panelABM2       = new javax.swing.JPanel();
        
        txtNomLoteria.setColumns(40);
        txtNomLoteria.setMsgAsociado(lblNomLoteria);
        txtNomLoteria.setNextFocusableComponent(txtAliasLoteria);
        txtNomLoteria.addSuscriptor(this);
        txtAliasLoteria.setColumns(18);
        txtAliasLoteria.setMsgAsociado(lblAliasLoteria);
        txtAliasLoteria.setNextFocusableComponent(btnGuard);
        txtAliasLoteria.addSuscriptor(this);
        
        super.habilitarBoton(VistaCRUD.GUARDAR, false);
        super.habilitarBoton(VistaCRUD.ACTUAL, false);
        super.habilitarBoton(VistaCRUD.ELIM, false);
        // ***********************************************************
        panelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNomLoteria, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(lblAliasLoteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomLoteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAliasLoteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomLoteria)
                    .addComponent(txtNomLoteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAliasLoteria)
                    .addComponent(txtAliasLoteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelABMLayout = new javax.swing.GroupLayout(panelABM);
        panelABM.setLayout(panelABMLayout);
        panelABMLayout.setHorizontalGroup(
            panelABMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelABMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuard)
                .addContainerGap())
        );
        panelABMLayout.setVerticalGroup(
            panelABMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelABMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelABMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActual)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuard))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelContTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelContTablaLayout = new javax.swing.GroupLayout(panelContTabla);
        panelContTabla.setLayout(panelContTablaLayout);
        panelContTablaLayout.setHorizontalGroup(
            panelContTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        panelContTablaLayout.setVerticalGroup(
            panelContTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
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
            .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelABM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelContTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelABM2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelABM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelABM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
	}

    private javax.swing.JLabel lblAliasLoteria;
    private javax.swing.JLabel lblNomLoteria;
    private javax.swing.JPanel panelABM;
    private javax.swing.JPanel panelABM2;
    private javax.swing.JPanel panelDatos;
    private MyJTextCadena txtAliasLoteria;
    private MyJTextCadena txtNomLoteria;
}