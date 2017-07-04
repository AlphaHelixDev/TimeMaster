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
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class StyledButtonUI extends BasicButtonUI {
	
	@Override
	public void installUI (JComponent c) {
		super.installUI(c);
		AbstractButton button = (AbstractButton) c;
		button.setOpaque(false);
		button.setBorder(new EmptyBorder(5, 15, 5, 15));
	}
	
	@Override
	public void paint (Graphics g, JComponent c) {
		AbstractButton b = (AbstractButton) c;
		paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
		super.paint(g, c);
	}
	
	private void paintBackground (Graphics g, JComponent c, int yOffset) {
		Dimension size = c.getSize();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(c.getBackground().darker());
		g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
		g.setColor(c.getBackground());
		g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
	}
}
