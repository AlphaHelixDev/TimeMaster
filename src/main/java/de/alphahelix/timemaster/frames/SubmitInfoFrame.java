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

package de.alphahelix.timemaster.frames;

import de.alphahelix.timemaster.Main;
import de.alphahelix.timemaster.instances.BasicMenuBar;
import de.alphahelix.timemaster.instances.BasicScrollPane;
import de.alphahelix.timemaster.instances.PopUpMenu;
import de.alphahelix.timemaster.instances.YearInformation;

import javax.swing.*;
import java.awt.*;

public class SubmitInfoFrame extends AbstractFrame {
	private JButton abschickenButton;
	private JPanel panel1;
	private JList list;
	private JButton backButton;
	private JLabel savedLbl;
	private JScrollPane scroller;
	private JEditorPane textPane;

	public SubmitInfoFrame(YearInformation yearInfo) throws HeadlessException {
		super("Gebe einen neuen Artikel für das Jahr " + yearInfo.getYear() + " ab!");

		setContentPane(panel1); setJMenuBar(new BasicMenuBar());

		textPane.setText("Bitte wähle eine Informationsnische"); textPane.setForeground(Color.WHITE);

		BasicScrollPane.init(scroller);

		savedLbl.setForeground(Color.WHITE); savedLbl.setFont(savedLbl.getFont().deriveFont(Font.PLAIN, 18));

		list.setBackground(new Color(51, 153, 255)); list.setForeground(Color.WHITE);

		backButton.addActionListener(e -> {
			this.dispose(); new YearFrame(yearInfo);
		});

		abschickenButton.addActionListener(e -> {
			if(list.getSelectedIndex() != -1) {
				switch(list.getSelectedIndex()) {
					case 0: yearInfo.getCulture().setDescription(textPane.getText()); break;
					case 1: yearInfo.getLiterature().setDescription(textPane.getText()); break;
					case 2: yearInfo.getLocal().setDescription(textPane.getText()); break;
					case 3: yearInfo.getPolitics().setDescription(textPane.getText()); break;
					case 4: yearInfo.getSciene().setDescription(textPane.getText()); break;
					case 5: yearInfo.getSport().setDescription(textPane.getText()); break;
					case 6: yearInfo.getWeather().setDescription(textPane.getText()); break;
				}

				Main.getFile(yearInfo.getYear()).setValue("info", yearInfo); savedLbl.setVisible(true);
			}
		});

		init();

		textPane.setEnabled(false);

		list.addListSelectionListener(e -> {
			if(list.getSelectedIndex() != -1) {
				switch(list.getSelectedIndex()) {
					case 0: textPane.setText(yearInfo.getCulture().getDescription()); break;
					case 1: textPane.setText(yearInfo.getLiterature().getDescription()); break;
					case 2: textPane.setText(yearInfo.getLocal().getDescription()); break;
					case 3: textPane.setText(yearInfo.getPolitics().getDescription()); break;
					case 4: textPane.setText(yearInfo.getSciene().getDescription()); break;
					case 5: textPane.setText(yearInfo.getSport().getDescription()); break;
					case 6: textPane.setText(yearInfo.getWeather().getDescription()); break;
				} textPane.setComponentPopupMenu(new PopUpMenu(textPane)); textPane.setEnabled(true);
			}
		});
	}
}
