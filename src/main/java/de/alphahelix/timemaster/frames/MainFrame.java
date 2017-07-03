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

import de.alphahelix.timemaster.instances.YearInformation;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends AbstractFrame {
	private JPanel panel1;
	private JLabel chooseYearLBL;
	private JButton submitButton;
	private JSlider chooseYearSlider;
	private JButton neuerBeitragButton;
	private JPanel chooseYear;

	public MainFrame() throws HeadlessException {
		super("Home");

		setContentPane(panel1);

		chooseYear.setBackground(new Color(51, 153, 255));

		submitButton.addActionListener((e) -> {
			if(chooseYearSlider.getValue() > 2017) new YearFrame(YearInformation.getInfo(2017));
			else new YearFrame(YearInformation.getInfo(chooseYearSlider.getValue())); this.dispose();
		});

		neuerBeitragButton.addActionListener(e -> {
			this.dispose(); if(chooseYearSlider.getValue() > 2017) new SubmitInfoFrame(YearInformation.getInfo(2017));
			else new SubmitInfoFrame(YearInformation.getInfo(chooseYearSlider.getValue()));
		});

		chooseYearSlider.setLabelTable(chooseYearSlider.createStandardLabels(5));

		init();
	}
}
