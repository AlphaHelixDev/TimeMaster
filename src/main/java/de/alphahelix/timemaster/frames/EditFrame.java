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
import de.alphahelix.timemaster.instances.*;

import javax.swing.*;
import java.awt.*;

public class EditFrame extends AbstractFrame {
	private JScrollPane scroller;
	private JEditorPane textPane;
	private BackButton backButton;
	private JPanel pane1;
	private JLabel savedLbl;
	private DownloadButton abschickenButton;

	public EditFrame(String title, YearInformation info, Information toEdit) {
		super(title);

		setContentPane(pane1); setJMenuBar(new BasicMenuBar());

		BasicScrollPane.init(scroller);

		textPane.setForeground(Color.WHITE); textPane.setText(toEdit.getDescription());

		savedLbl.setForeground(Color.WHITE); savedLbl.setFont(savedLbl.getFont().deriveFont(Font.PLAIN, 18));

		abschickenButton.addActionListener(e -> {
			toEdit.setDescription(textPane.getText());

			if(title.contains("Wetter")) info.setWeather(toEdit);
			else if(title.contains("Sport")) info.setSport(toEdit);
			else if(title.contains("Politik")) info.setPolitics(toEdit);
			else if(title.contains("Lokales")) info.setLocal(toEdit);
			else if(title.contains("Wissenschaft")) info.setSciene(toEdit);
			else if(title.contains("Literatur")) info.setLiterature(toEdit);
			else if(title.contains("Kultur")) info.setCulture(toEdit);

			Main.getFile(info.getYear()).setValue("info", info); savedLbl.setVisible(true);
		});

		init();

		backButton.addActionListener(e -> {
			this.dispose(); new YearFrame(info);
		});
	}
}
