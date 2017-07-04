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
import java.awt.*;

public class DownloadButton extends JButton {
	
	public DownloadButton () {
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setBackground(new Color(0x3399ff));
		setForeground(Color.white);
		setUI(new StyledButtonUI());
	}
	
	public DownloadButton (Icon icon) {
		super(icon);
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setBackground(new Color(0x3399ff));
		setForeground(Color.white);
		setUI(new StyledButtonUI());
	}
	
	public DownloadButton (String text) {
		super(text);
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setBackground(new Color(0x3399ff));
		setForeground(Color.white);
		setUI(new StyledButtonUI());
	}
	
	public DownloadButton (Action a) {
		super(a);
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setBackground(new Color(0x3399ff));
		setForeground(Color.white);
		setUI(new StyledButtonUI());
	}
	
	public DownloadButton (String text, Icon icon) {
		super(text, icon);
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setBackground(new Color(0x3399ff));
		setForeground(Color.white);
		setUI(new StyledButtonUI());
	}
}
