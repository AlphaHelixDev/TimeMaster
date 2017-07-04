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

package de.alphahelix.timemaster.instances;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSpinnerUI;
import java.awt.*;

public class BasicSpinner {

	public static void init (JSpinner spinner) {
		//		spinner.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(52, 153, 255)), BorderFactory.createEmptyBorder(2, 4, 2, 1)));

		spinner.setUI(new BasicSpinnerUI() {
			@Override
			protected Component createPreviousButton () {
				return null;
			}

			@Override
			protected Component createNextButton () {
				return null;
			}
		});

		((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);

		spinner.getEditor().setOpaque(true);
		spinner.getEditor().setBackground(new Color(52, 52, 52));
		
		spinner.getEditor().getComponent(0).setBackground(new Color(52, 153, 255));
		spinner.getEditor().getComponent(0).setForeground(Color.WHITE);
	}
}
