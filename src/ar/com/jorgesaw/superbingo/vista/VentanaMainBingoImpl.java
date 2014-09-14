package ar.com.jorgesaw.superbingo.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.KeyStroke;

import ar.com.jorgesaw.gui.VentanaMain;
import ar.com.jorgesaw.superbingo.vista.control.CtrlMainBingoImpl;
import ar.com.jorgesaw.superbingo.vista.interfaces.VentanaMainBingo;

public class VentanaMainBingoImpl extends VentanaMain implements VentanaMainBingo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4675748145646327425L;
	private final String icono_app = "/recursos/iconos/diamante_64x64.png";
	
	public VentanaMainBingoImpl(String titulo) {
		super(titulo);
		initComponenentes();
	}
	
	private void initComponenentes() {
//		loterias = new ServicioLoterias<TipoLoteria>().getAllLoterias();
//		if (loterias.size() > 0)
//			subItemsLoterias = new javax.swing.JMenuItem[loterias.size()];
		setIconoAPP(icono_app);
		
		menuArchivo = new javax.swing.JMenu();
		itemOpciones = new javax.swing.JMenuItem();
		itemImprimir = new javax.swing.JMenuItem();
		itemSalir = new javax.swing.JMenuItem();
		menuDatos = new javax.swing.JMenu();
		itemNuevoBingo = new javax.swing.JMenuItem();
		itemEmpleados = new javax.swing.JMenuItem();
		itemInstituciones = new javax.swing.JMenuItem();
		itemLoterias = new javax.swing.JMenuItem();
		itemCiudades = new javax.swing.JMenuItem();
		itemCargaSorteos = new javax.swing.JMenu();
		menuBingo = new javax.swing.JMenu();
		itemListarBingo = new javax.swing.JMenuItem();
		menuConsignatario = new javax.swing.JMenu();
		itemExplorarConsig = new javax.swing.JMenuItem();
		menuCartones = new javax.swing.JMenu();
		itemCartonesGenerar = new javax.swing.JMenuItem();
		itemCartonesCargar = new javax.swing.JMenuItem();
		menuGanadores = new javax.swing.JMenu();
		itemBuscarGanadores = new javax.swing.JMenuItem();
		
		menuArchivo.setText("Archivo");
		menuArchivo.setIcon(new ImageIcon(getClass().getResource(
				"/recursos/iconos/file3_32x32.png")));
		itemOpciones.setText("Opciones");
		menuArchivo.add(itemOpciones);
		itemOpciones.setPreferredSize(new java.awt.Dimension(190, 22));
		itemOpciones.setActionCommand(OPCIONES);
		itemOpciones.setName(OPCIONES);
		itemImprimir.setText("Imprimir");
		menuArchivo.add(itemImprimir);
		itemImprimir.setActionCommand(IMPRIMIR);
		itemImprimir.setName(IMPRIMIR);
		itemSalir.setText("Salir");
		menuArchivo.add(itemSalir);
		itemSalir.setActionCommand(SALIR);
		itemSalir.setName(SALIR);

		getMenuPrincipal().add(menuArchivo);

		menuDatos.setText("Datos");
		menuDatos.setIcon(new ImageIcon(getClass().getResource(
				"/recursos/iconos/datos_32x32.png")));
		
		itemNuevoBingo.setText("Bingo");
		menuDatos.add(itemNuevoBingo);
		itemNuevoBingo.setPreferredSize(new java.awt.Dimension(190, 22));
		itemNuevoBingo.setActionCommand(NUEVO_BINGO);
		itemNuevoBingo.setName(NUEVO_BINGO);
		
		itemEmpleados.setText("Empleados");
		menuDatos.add(itemEmpleados);
		itemEmpleados.setActionCommand(EMPLEADOS);
		itemEmpleados.setName(EMPLEADOS);
		
		itemInstituciones.setText("Instituciones");
		
		menuDatos.add(itemInstituciones);
		itemInstituciones.setActionCommand(INSTITUCIONES);
		itemInstituciones.setName(INSTITUCIONES);
		
		itemLoterias.setText("Loterias");
		menuDatos.add(itemLoterias);
		itemLoterias.setActionCommand(LOTERIAS);
		itemLoterias.setName(LOTERIAS);
		
		itemCiudades.setText("Ciudades");
		menuDatos.add(itemCiudades);
		itemCiudades.setActionCommand(CIUDADES);
		itemCiudades.setName(CIUDADES);
		
		itemCargaSorteos.setText("Carga sorteos");
		menuDatos.add(itemCargaSorteos);
		itemCargaSorteos.setActionCommand(CARGA_SORTEO);
		itemCargaSorteos.setName(CARGA_SORTEO);
//		cargarItemsLoteria(itemCargaSorteos);
		
		getMenuPrincipal().add(menuDatos);
		
		menuBingo.setText("Bingo");
		menuBingo.setIcon(new ImageIcon(getClass().getResource(
				"/recursos/iconos/game_32x32.png")));

		itemListarBingo.setText("Mostrar");
		itemListarBingo.setPreferredSize(new java.awt.Dimension(190,
				22));
		menuBingo.add(itemListarBingo);
		itemListarBingo.setActionCommand(LISTAR_BINGO);
		itemListarBingo.setName(LISTAR_BINGO);

		getMenuPrincipal().add(menuBingo);

		menuConsignatario.setText("Personal");
		menuConsignatario.setIcon(new ImageIcon(getClass().getResource(
				"/recursos/iconos/persona_32x32.png")));
		itemExplorarConsig.setText("Mostrar");
		menuConsignatario.add(itemExplorarConsig);
		itemExplorarConsig.setPreferredSize(new java.awt.Dimension(190, 22));
		itemExplorarConsig.setActionCommand(CONSIG);
		itemExplorarConsig.setName(CONSIG);

		getMenuPrincipal().add(menuConsignatario);

		menuCartones.setText("Cartones");
		menuCartones.setIcon(new ImageIcon(getClass().getResource(
				"/recursos/iconos/transaccion_32x32.png")));
		itemCartonesGenerar.setText("Generar...");
		itemCartonesGenerar.setPreferredSize(new java.awt.Dimension(190,
				22));
		itemCartonesGenerar.setActionCommand(CARTONES_GENERAR);
		itemCartonesGenerar.setName(CARTONES_GENERAR);
		
		itemCartonesCargar.setText("Cargar boleta");
		itemCartonesCargar.setActionCommand(CARTONES_CARGAR_DATOS);
		itemCartonesCargar.setName(CARTONES_CARGAR_DATOS);

		menuCartones.add(itemCartonesGenerar);
		menuCartones.add(itemCartonesCargar);
		
		getMenuPrincipal().add(menuCartones);

		menuGanadores.setText("Ganadores");
		menuGanadores.setIcon(new ImageIcon(getClass().getResource(
				"/recursos/iconos/ganadores_32x32.png")));
		itemBuscarGanadores.setText("Buscar...");
		itemBuscarGanadores.setPreferredSize(new java.awt.Dimension(190,
				22));
		itemBuscarGanadores.setActionCommand(BUSCA_GANADORES);
		itemBuscarGanadores.setName(BUSCA_GANADORES);

		menuGanadores.add(itemBuscarGanadores);
		
		
		getMenuPrincipal().add(menuGanadores);
		
		menuArchivo.setMnemonic(KeyEvent.VK_A);
		menuDatos.setMnemonic(KeyEvent.VK_S);
		menuBingo.setMnemonic(KeyEvent.VK_N);
		menuConsignatario.setMnemonic(KeyEvent.VK_O);
		menuCartones.setMnemonic(KeyEvent.VK_C);
		menuGanadores.setMnemonic(KeyEvent.VK_G);

		itemImprimir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				ActionEvent.CTRL_MASK));
		itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
				ActionEvent.ALT_MASK));

		setJMenuBar(getMenuPrincipal());
		getContentPane().add(getDesktop());
		
		getDesktop().setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		getDesktop().setBackground(Color.black);
		itemImprimir.setEnabled(false);
		itemOpciones.setEnabled(false);
	}
	
	@Override
	public void setControlador(CtrlMainBingoImpl c) {
		addWindowListener(c);
		
		itemOpciones.addActionListener(c);
		itemOpciones.addKeyListener(c);
		itemImprimir.addActionListener(c);
		itemImprimir.addKeyListener(c);
		itemSalir.addActionListener(c);
		itemSalir.addKeyListener(c);

		itemNuevoBingo.addActionListener(c);
		itemNuevoBingo.addKeyListener(c);
		itemListarBingo.addActionListener(c);
		itemListarBingo.addKeyListener(c);
		itemEmpleados.addActionListener(c);
		itemEmpleados.addKeyListener(c);
		itemInstituciones.addActionListener(c);
		itemInstituciones.addKeyListener(c);
		itemLoterias.addActionListener(c);
		itemLoterias.addKeyListener(c);
		itemCiudades.addActionListener(c);
		itemCiudades.addKeyListener(c);

		itemExplorarConsig.addActionListener(c);
		itemExplorarConsig.addKeyListener(c);

		itemCartonesGenerar.addActionListener(c);
		itemCartonesGenerar.addKeyListener(c);
		itemCartonesCargar.addActionListener(c);
		itemCartonesCargar.addKeyListener(c);
		
		itemBuscarGanadores.addActionListener(c);
		itemBuscarGanadores.addKeyListener(c);
	}
	
	private javax.swing.JMenu menuArchivo;
	private javax.swing.JMenuItem itemOpciones;
	private javax.swing.JMenuItem itemImprimir;
	private javax.swing.JMenuItem itemSalir;
	
	private javax.swing.JMenu menuDatos;
	private javax.swing.JMenuItem itemNuevoBingo;
	private javax.swing.JMenuItem itemEmpleados;
	private javax.swing.JMenuItem itemInstituciones;
	private javax.swing.JMenuItem itemLoterias;
	private javax.swing.JMenuItem itemCiudades;
	private javax.swing.JMenu itemCargaSorteos;
		private javax.swing.JMenuItem[] subItemsLoterias;
	private javax.swing.JMenu menuBingo;
	private javax.swing.JMenuItem itemListarBingo;
	private javax.swing.JMenu menuConsignatario;
	private javax.swing.JMenuItem itemExplorarConsig;
	
	private javax.swing.JMenu menuCartones;
	private javax.swing.JMenuItem itemCartonesGenerar;
	private javax.swing.JMenuItem itemCartonesCargar;
	private javax.swing.JMenu menuGanadores;
		private javax.swing.JMenuItem itemBuscarGanadores;
}
