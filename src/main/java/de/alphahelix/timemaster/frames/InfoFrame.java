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

import de.alphahelix.timemaster.instances.*;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends AbstractFrame {

	private YearInformation yearInfo;
	private JPanel panel1;
	private BackButton backButton;
	private JEditorPane textPane;
	private JScrollPane scroller;
	private DownloadButton editButton;

	public InfoFrame(String title, YearInformation yearInfo, Information info, String name) throws HeadlessException {
		super(title); this.yearInfo = yearInfo;

		setContentPane(panel1); setJMenuBar(new BasicMenuBar());

		BasicScrollPane.init(scroller);

		textPane.setForeground(Color.WHITE); textPane.setText(info.getDescription());


		init();

		backButton.addActionListener(e -> {
			this.dispose(); new YearFrame(getYearInfo());
		});

		editButton.addActionListener(e -> {
			this.dispose(); new EditFrame(name + " editieren im Jahre " + yearInfo.getYear(), yearInfo, info);
		});
	}

	public YearInformation getYearInfo() {
		return yearInfo;
	}
}
