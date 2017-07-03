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

package de.alphahelix.timemaster.files;

import de.alphahelix.pojal.files.SimpleJSONFile;
import de.alphahelix.timemaster.instances.YearInformation;

public class YearFile extends SimpleJSONFile {
	public YearFile(int year, YearInformation information) {
		super(System.getProperty("user.home") + "/TimeMaster/years", year + ".json");

		if(!jsonContains("info")) {
			setValue("info", information);
		}
	}

	public YearInformation getInfo() {
		return getValue("info", YearInformation.class);
	}
}
