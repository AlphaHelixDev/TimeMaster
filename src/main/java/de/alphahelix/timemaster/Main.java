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

package de.alphahelix.timemaster;

import de.alphahelix.timemaster.files.YearFile;
import de.alphahelix.timemaster.frames.MainFrame;

import java.util.HashMap;

public class Main {

	private static final HashMap<Integer, YearFile> FILES = new HashMap<>();

	public static void main (String[] args) {
		launch();
	}

	private static void launch () {
		new MainFrame();
	}

	public static YearFile getFile (int year) {
		if(FILES.containsKey(year)) return FILES.get(year);
		return null;
	}

	public static void addFile (int year, YearFile yf) {
		FILES.put(year, yf);
	}
}
