package ar.com.jorgesaw.superbingo.gui.tabla.renderers;

import java.awt.Component;
import java.text.DecimalFormat;

import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class NumberCellEditor extends DefaultCellEditor {
    public NumberCellEditor(){
        super(new JFormattedTextField());
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        JFormattedTextField editor = (JFormattedTextField) super.getTableCellEditorComponent(table, value, isSelected, row, column);

        if (value!=null){
            DecimalFormat numberFormat = new DecimalFormat("#,##0.00;(#,##0.00)");
            editor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(numberFormat)));
            Number num = (Number) value;  
            String text = numberFormat.format(num);
            editor.setHorizontalAlignment(SwingConstants.RIGHT);
            editor.setText(text);
        }
        return editor;
    }
}

/*public class NumberCellEditor extends DefaultCellEditor {
public NumberCellEditor(){
    super(new JFormattedTextField());
}

@Override
public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    JFormattedTextField editor = (JFormattedTextField) super.getTableCellEditorComponent(table, value, isSelected, row, column);

    if (value instanceof Number){
        Locale myLocale = Locale.getDefault(); 

        NumberFormat numberFormatB = NumberFormat.getInstance(myLocale);
        numberFormatB.setMaximumFractionDigits(2);
        numberFormatB.setMinimumFractionDigits(2);
        numberFormatB.setMinimumIntegerDigits(1);

        editor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                        new NumberFormatter(numberFormatB)));

        editor.setHorizontalAlignment(SwingConstants.RIGHT);
        editor.setValue(value);
    }
    return editor;
}

@Override
public boolean stopCellEditing() {
    try {
        // try to get the value
        this.getCellEditorValue();
        return super.stopCellEditing();
    } catch (Exception ex) {
        return false;
    }

}

@Override
public Object getCellEditorValue() {
    // get content of textField
    String str = (String) super.getCellEditorValue();
    if (str == null) {
        return null;
    }

    if (str.length() == 0) {
        return null;
    }

    // try to parse a number
    try {
        ParsePosition pos = new ParsePosition(0);
        Number n = NumberFormat.getInstance().parse(str, pos);
        if (pos.getIndex() != str.length()) {
            throw new ParseException(
                    "parsing incomplete", pos.getIndex());
        }

        // return an instance of column class
        return new Float(n.floatValue());

    } catch (ParseException pex) {
        throw new RuntimeException(pex);
    }
}
}


DecimalFormat numberFormat = new DecimalFormat("\\d*([\\.,\\,]\\d{0,2})?");*/