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

package de.alphahelix.timemaster;

import de.alphahelix.timemaster.files.YearFile;
import de.alphahelix.timemaster.frames.MainFrame;
import de.alphahelix.timemaster.instances.Information;
import de.alphahelix.timemaster.instances.YearInformation;

import javax.swing.*;
import java.util.HashMap;

public class Main {

	private static final HashMap<Integer, YearFile> FILES = new HashMap<>();

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
			e.printStackTrace();
		} launch();
	}


	private static void launch() {
		new MainFrame();

		for(int i = 2000; i < 2021; i++) {
			YearFile yearFile = new YearFile(i, new YearInformation(i, new Information("put in infos"), new Information("put in infos"), new Information("put in infos"), new Information("put in infos"), new Information("put in infos"), new Information("put in infos"), new Information("put in infos")));

			FILES.put(i, yearFile); YearInformation.register(yearFile.getInfo());
		}
	}

	public static YearFile getFile(int year) {
		if(FILES.containsKey(year)) return FILES.get(year); return null;
	}
}
