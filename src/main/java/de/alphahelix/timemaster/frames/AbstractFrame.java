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

import com.apple.eawt.Application;
import de.alphahelix.timemaster.Main;
import de.alphahelix.timemaster.OSCheck;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AbstractFrame extends JFrame {
	
	public AbstractFrame (String title) throws HeadlessException {
		super(title);
		
	}
	
	public void init () {
		getContentPane().setBackground(new Color(52, 52, 52));
		
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		if(OSCheck.getOperatingSystemType() == OSCheck.OSType.Windows)
			setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		else if(OSCheck.getOperatingSystemType() == OSCheck.OSType.MacOS) try {
			Application.getApplication().setDockIconImage(ImageIO.read(Main.class.getResourceAsStream("/icon.png")));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
