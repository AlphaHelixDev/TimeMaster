/*
 *
 *  *
 *  *  * Copyright (C) <2017>  <AlphaHelixDev>
 *  *  *
 *  *  *       This program is free software: you can redistribute it under the
 *  *  *       terms of the GNU General Public License as published by
 *  *  *       the Free Software Foundation, either version 3 of the License.
 *  *  *
 *  *  *       This program is distributed in the hope that it will be useful,
 *  *  *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  *  *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  *  *       GNU General Public License for more details.
 *  *  *
 *  *  *       You should have received a copy of the GNU General Public License
 *  *  *       along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  *
 *
 */

package de.alphahelix.timemaster.instances;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class PopUpMenu extends JPopupMenu {
	public PopUpMenu(JEditorPane pane) {
		JMenuItem anItem = new JMenuItem("Einfügen");

		anItem.addActionListener(e -> paste(pane));

		add(anItem);
	}

	private void paste(JEditorPane pane) {
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard(); Transferable t = c.getContents(this);

		if(t == null) return; try {
			int caretPos = pane.getCaretPosition(); try {
				pane.getDocument().insertString(caretPos, (String) t.getTransferData(DataFlavor.stringFlavor), null);
			} catch(BadLocationException ex) {
				ex.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
