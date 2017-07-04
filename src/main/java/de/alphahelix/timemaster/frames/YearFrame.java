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

import com.google.gson.JsonObject;
import de.alphahelix.pojal.utils.JSONUtil;
import de.alphahelix.timemaster.Main;
import de.alphahelix.timemaster.instances.BasicButton;
import de.alphahelix.timemaster.instances.YearInformation;
import org.apache.commons.io.IOUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class YearFrame extends AbstractFrame {
	
	private YearInformation info;
	
	private BasicButton wetterButton;
	private JPanel panel1;
	private BasicButton sportBasicButton;
	private BasicButton politikBasicButton;
	private BasicButton lokalesBasicButton;
	private BasicButton wissenschaftBasicButton;
	private BasicButton literaturBasicButton;
	private BasicButton kulturBasicButton;
	private JButton backButton;
	private JButton downloadInfosButton;
	private JPanel infos;
	
	public YearFrame (YearInformation info) throws HeadlessException {
		super("Jahr: " + info.getYear());
		this.info = info;
		
		setContentPane(panel1);
		
		infos.setBackground(new Color(51, 153, 255));
		
		init();
		
		backButton.addActionListener(e -> {
			this.dispose();
			new MainFrame();
		});
		
		wetterButton.addActionListener(e -> {
			this.dispose();
			new InfoFrame("Wetter im Jahr: " + info.getYear(), this.info, this.info.getWeather(), "Wetter");
		});
		
		sportBasicButton.addActionListener(e -> {
			this.dispose();
			new InfoFrame("Sport im Jahr: " + info.getYear(), this.info, this.info.getSport(), "Sport");
		});
		
		politikBasicButton.addActionListener(e -> {
			this.dispose();
			new InfoFrame("Politisches im Jahr: " + info.getYear(), this.info, this.info.getPolitics(), "Politik");
		});
		
		lokalesBasicButton.addActionListener(e -> {
			this.dispose();
			new InfoFrame("Lokales im Jahr: " + info.getYear(), this.info, this.info.getLocal(), "Lokales");
		});
		
		wissenschaftBasicButton.addActionListener(e -> {
			this.dispose();
			new InfoFrame("Wissenschaftliches im Jahr: " + info.getYear(), this.info, this.info.getSciene(), "Wissenschaft");
		});
		
		literaturBasicButton.addActionListener(e -> {
			this.dispose();
			new InfoFrame("Literarisches im Jahr: " + info.getYear(), this.info, this.info.getLiterature(), "Literatur");
		});
		
		kulturBasicButton.addActionListener(e -> {
			this.dispose();
			new InfoFrame("Kulturelles im Jahr: " + info.getYear(), this.info, this.info.getCulture(), "Kultur");
		});
		
		downloadInfosButton.addActionListener(e -> {
			try {
				URL infoURL = new URL("http://localhost/timemasters/years/" + this.info.getYear() + ".json");
				String json = IOUtils.toString(infoURL, Charset.defaultCharset());
				
				JsonObject header = JSONUtil.getValue(json, JsonObject.class);
				YearInformation temp = JSONUtil.getGson().fromJson(header.getAsJsonObject("info"), YearInformation.class);
				
				this.info = temp;
				Main.getFile(this.info.getYear()).setValue("info", this.info);
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		});
	}
}
