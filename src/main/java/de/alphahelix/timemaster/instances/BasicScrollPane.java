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
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

import static sun.swing.SwingUtilities2.*;

public class BasicScrollPane {
	
	public static void init (JScrollPane scroller) {
		scroller.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(52, 153, 255)), BorderFactory.createEmptyBorder(2, 4, 2, 1)));
		
		scroller.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors () {
				this.thumbColor = new Color(51, 153, 255);
				this.trackColor = new Color(52, 52, 52);
			}
			
			@Override
			protected JButton createDecreaseButton (int orientation) {
				return createZeroButton();
			}
			
			@Override
			protected JButton createIncreaseButton (int orientation) {
				return createZeroButton();
			}
			
			@Override
			protected void paintThumb (Graphics g, JComponent c, Rectangle trackBounds) {
				if(trackBounds.isEmpty() || !scrollbar.isEnabled()) {
					return;
				}
				
				int w = trackBounds.width;
				int h = 10;
				
				g.translate(trackBounds.x, trackBounds.y);
				
				g.setColor(thumbDarkShadowColor);
				drawRect(g, 0, 0, w - 1, h - 1);
				g.setColor(thumbColor);
				g.fillRect(0, 0, w - 1, h - 1);
				
				g.setColor(thumbHighlightColor);
				drawVLine(g, 1, 1, h - 2);
				drawHLine(g, 2, w - 3, 1);
				
				g.setColor(thumbLightShadowColor);
				drawHLine(g, 2, w - 2, h - 2);
				drawVLine(g, w - 2, 1, h - 3);
				
				g.translate(-trackBounds.x, -trackBounds.y);
			}
		});
		
		scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors () {
				this.thumbColor = new Color(51, 153, 255);
				this.trackColor = new Color(52, 52, 52);
			}
			
			@Override
			protected JButton createDecreaseButton (int orientation) {
				return createZeroButton();
			}
			
			@Override
			protected JButton createIncreaseButton (int orientation) {
				return createZeroButton();
			}
			
			@Override
			protected void paintThumb (Graphics g, JComponent c, Rectangle trackBounds) {
				if(trackBounds.isEmpty() || !scrollbar.isEnabled()) {
					return;
				}
				
				int w = 10;
				int h = trackBounds.height;
				
				g.translate(trackBounds.x, trackBounds.y);
				
				g.setColor(thumbDarkShadowColor);
				drawRect(g, 0, 0, w - 1, h - 1);
				g.setColor(thumbColor);
				g.fillRect(0, 0, w - 1, h - 1);
				
				g.setColor(thumbHighlightColor);
				drawVLine(g, 1, 1, h - 2);
				drawHLine(g, 2, w - 3, 1);
				
				g.setColor(thumbLightShadowColor);
				drawHLine(g, 2, w - 2, h - 2);
				drawVLine(g, w - 2, 1, h - 3);
				
				g.translate(-trackBounds.x, -trackBounds.y);
			}
		});
	}
	
	private static JButton createZeroButton () {
		JButton jbutton = new JButton();
		jbutton.setPreferredSize(new Dimension(0, 0));
		jbutton.setMinimumSize(new Dimension(0, 0));
		jbutton.setMaximumSize(new Dimension(0, 0));
		return jbutton;
	}
}
