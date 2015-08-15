/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 *  The ButtonColumn class provides a renderer and an editor that looks like a
 *  JButton. The renderer and editor will then be used for a specified column
 *  in the table. The TableModel will contain the String to be displayed on
 *  the button.
 *
 *  The button can be invoked by a mouse click or by pressing the space bar
 *  when the cell has focus. Optionally a mnemonic can be set to invoke the
 *  button. When the button is invoked the provided Action is invoked. The
 *  source of the Action will be the table. The action command will contain
 *  the model row number of the button that was clicked.
 *
 */
public class ComboColumn extends AbstractCellEditor
	implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener
{
	private JTable table;
	private Action action;
	private Border originalBorder;
	private Border focusBorder;

	private JComboBox renderComboBox;
	private JComboBox editComboBox;
	private Object editorValue;
	private boolean isButtonColumnEditor;

	/**
	 *  Create the ButtonColumn to be used as a renderer and editor. The
	 *  renderer and editor will automatically be installed on the TableColumn
	 *  of the specified column.
	 *
	 *  @param table the table containing the button renderer/editor
	 *  @param action the Action to be invoked when the button is invoked
	 *  @param column the column to which the button renderer/editor is added
	 */
	public ComboColumn(JTable table, Action action, int column, String[] values)
	{
		this.table = table;
		this.action = action;
		renderComboBox = new JComboBox(values);
		editComboBox = new JComboBox(values);
		editComboBox.addActionListener( this );
		originalBorder = editComboBox.getBorder();
		setFocusBorder( new LineBorder(Color.BLUE) );

		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(column).setCellRenderer( this );
		columnModel.getColumn(column).setCellEditor( this );
		table.addMouseListener( this );
	}

        public Object getEditorValue()
        {
            return editorValue;
        }

	/**
	 *  Get foreground color of the button when the cell has focus
	 *
	 *  @return the foreground color
	 */
	public Border getFocusBorder()
	{
		return focusBorder;
	}

	/**
	 *  The foreground color of the button when the cell has focus
	 *
	 *  @param focusBorder the foreground color
	 */
	public void setFocusBorder(Border focusBorder)
	{
		this.focusBorder = focusBorder;
		editComboBox.setBorder( focusBorder );
	}

	@Override
	public Component getTableCellEditorComponent(
		JTable table, Object value, boolean isSelected, int row, int column)
	{
		if (value == null)
		{
			return editComboBox;
		}
		else
		{
                        // System.out.println("value at editor is" + value + "selected:" + isSelected);
			editComboBox.setSelectedItem(value);
		}

		this.editorValue = value;
		return editComboBox;
	}

	@Override
	public Object getCellEditorValue()
	{
		return editorValue;
	}

//
//  Implement TableCellRenderer interface
//
	public Component getTableCellRendererComponent(
		JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		if (isSelected)
		{
			renderComboBox.setForeground(table.getSelectionForeground());
	 		renderComboBox.setBackground(table.getSelectionBackground());
		}
		else
		{
			renderComboBox.setForeground(table.getForeground());
			renderComboBox.setBackground(UIManager.getColor("Button.background"));
		}

		if (hasFocus)
		{
			renderComboBox.setBorder( focusBorder );
		}
		else
		{
			renderComboBox.setBorder( originalBorder );
		}

//		renderButton.setText( (value == null) ? "" : value.toString() );
                
                if (value == null)
		{
			return renderComboBox;
		}
		else
		{
                        // System.out.println("value at render is:" + value);
			renderComboBox.setSelectedItem(value);
		}

		this.editorValue = value;

		return renderComboBox;
	}

//
//  Implement ActionListener interface
//
	/*
	 *	The button has been pressed. Stop editing and invoke the custom Action
	 */
	public void actionPerformed(ActionEvent e)
	{
		int row = table.convertRowIndexToModel( table.getEditingRow() );
		//fireEditingStopped();
		//  Invoke the Action
                editorValue = editComboBox.getSelectedItem();
		ActionEvent event = new ActionEvent(
			table,
			ActionEvent.ACTION_PERFORMED,
			"" + row, Integer.parseInt((String) editorValue));
		action.actionPerformed(event);
	}

//
//  Implement MouseListener interface
//
	/*
	 *  When the mouse is pressed the editor is invoked. If you then then drag
	 *  the mouse to another cell before releasing it, the editor is still
	 *  active. Make sure editing is stopped when the mouse is released.
	 */
    public void mousePressed(MouseEvent e)
    {
    	/*if (table.isEditing()
		&&  table.getCellEditor() == this)
			isButtonColumnEditor = true;*/
    }

    public void mouseReleased(MouseEvent e)
    {
    	/*if (isButtonColumnEditor
    	&&  table.isEditing())
    		table.getCellEditor().stopCellEditing();

		isButtonColumnEditor = false;*/
    }

    public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}