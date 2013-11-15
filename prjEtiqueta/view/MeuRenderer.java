package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class MeuRenderer implements TableCellRenderer {  
	  
	  public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();  
	  
	  public Component getTableCellRendererComponent(JTable table, Object value,  
	      boolean isSelected, boolean hasFocus, int row, int column) {  
	  
	    Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(  
	        table, value, isSelected, hasFocus, row, column);  
	  
	    ((JLabel) renderer).setOpaque(true);  
	  
	    Color foreground, background;  
	  
	      if (row % 2 == 0) {  
	        foreground = Color.black;  
	        background = Color.white;  
	  
	      } else {  
	        foreground = Color.black;  
	        background = Color.decode("#D6E3F0");  
	  
	      }  
	  
	    renderer.setForeground(foreground);  
	    renderer.setBackground(background);  
	    return renderer;  
	  
	  }  
	}  