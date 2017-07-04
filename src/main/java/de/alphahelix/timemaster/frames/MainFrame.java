/*
 *
 *  Copyright (C) <2017>  <AlphaHelixDev>
 *
 *        This program is free software: you can redistribute it under the
 *        terms of the GNU General Public License as published by
 *        the Free Software Foundation, either version 3 of the License.
 *
 *        This program is distributed in the hope that it will be useful,
 *        but WITHOUT ANY WARRANTY; without even the implied warranty of
 *        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *        GNU General Public License for more details.
 *
 *        You should have received a copy of the GNU General Public License
 *        along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package de.alphahelix.timemaster.frames;

import de.alphahelix.timemaster.Main;
import de.alphahelix.timemaster.files.YearFile;
import de.alphahelix.timemaster.instances.BasicSpinner;
import de.alphahelix.timemaster.instances.Information;
import de.alphahelix.timemaster.instances.YearInformation;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends AbstractFrame {
	private JPanel panel1;
	private JButton submitButton;
	private JSpinner chooseYearField;
	private JButton neuerBeitragButton;
	private JPanel chooseYear;
	private JLabel chooseYearLBL;

	public MainFrame() throws HeadlessException {
		super("Home");

		setContentPane(panel1);

		chooseYear.setBackground(new Color(51, 153, 255)); chooseYearField.setValue(1916);

		submitButton.addActionListener((e) -> {
			Main.addFile((int) chooseYearField.getValue(), new YearFile((int) chooseYearField.getValue(), new YearInformation((Integer) chooseYearField.getValue(), new Information("put in infos"), new Information("put in infos"), new Information("put in infos"), new Information("put in infos"), new Information("put in infos"), new Information("put in infos"), new Information("put in infos"))));

			YearInformation.register(Main.getFile((int) chooseYearField.getValue()).getInfo());

			YearInformation info;

			if((int) chooseYearField.getValue() > 2017) {
				info = YearInformation.getInfo(2017);
			} else {
				info = YearInformation.getInfo((int) chooseYearField.getValue());
			}

			new YearFrame(info); this.dispose();
		});

		neuerBeitragButton.addActionListener(e -> {
			this.dispose();
			if((int) chooseYearField.getValue() > 2017) new SubmitInfoFrame(YearInformation.getInfo(2017));
			else new SubmitInfoFrame(YearInformation.getInfo((Integer) chooseYearField.getValue()));
		});

		BasicSpinner.init(chooseYearField);

		chooseYearField.setOpaque(false);

		init();
	}
}
