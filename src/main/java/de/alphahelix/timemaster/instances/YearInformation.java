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

import java.util.HashMap;

public class YearInformation {

	private static final HashMap<Integer, YearInformation> INFOS = new HashMap<>();

	private final int year;
	private Information culture;
	private Information literature;
	private Information local;
	private Information politics;
	private Information sciene;
	private Information sport;
	private Information weather;

	public YearInformation(int year, Information culture, Information literature, Information local, Information politics, Information sciene, Information sport, Information weather) {
		this.year = year; this.culture = culture; this.literature = literature; this.local = local;
		this.politics = politics; this.sciene = sciene; this.sport = sport; this.weather = weather; register(this);
	}

	public static void register(YearInformation info) {
		INFOS.put(info.getYear(), info);
	}

	public int getYear() {
		return year;
	}

	public static YearInformation getInfo(int year) {
		if(INFOS.containsKey(year)) return INFOS.get(year); return null;
	}

	public Information getCulture() {
		return culture;
	}

	public YearInformation setCulture(Information culture) {
		this.culture = culture; return this;
	}

	public Information getLiterature() {
		return literature;
	}

	public YearInformation setLiterature(Information literature) {
		this.literature = literature; return this;
	}

	public Information getLocal() {
		return local;
	}

	public YearInformation setLocal(Information local) {
		this.local = local; return this;
	}

	public Information getPolitics() {
		return politics;
	}

	public YearInformation setPolitics(Information politics) {
		this.politics = politics; return this;
	}

	public Information getSciene() {
		return sciene;
	}

	public YearInformation setSciene(Information sciene) {
		this.sciene = sciene; return this;
	}

	public Information getSport() {
		return sport;
	}

	public YearInformation setSport(Information sport) {
		this.sport = sport; return this;
	}

	public Information getWeather() {
		return weather;
	}

	public YearInformation setWeather(Information weather) {
		this.weather = weather; return this;
	}
}
