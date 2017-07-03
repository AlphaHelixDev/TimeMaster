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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TransparentTextPane extends JTextPane {

	public TransparentTextPane() {
		setOpaque(false);
		setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new LineBorder(Color.LIGHT_GRAY)));
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(255, 255, 255, 128)); Insets insets = getInsets(); int x = insets.left; int y = insets.top;
		int width = getWidth() - (insets.left + insets.right); int height = getHeight() - (insets.top + insets.bottom);
		g.fillRect(x, y, width, height); super.paintComponent(g);
	}

}
