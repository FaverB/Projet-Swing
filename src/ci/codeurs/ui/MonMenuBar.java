package ci.codeurs.ui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MonMenuBar extends JMenuBar{
	
	JMenu jmenuAutre = new JMenu("OPTION");
	JMenuItem itemAide = new JMenuItem("Aide");
	JMenuItem itemQuitter = new JMenuItem("Quitter");
	
	
	public MonMenuBar(JFrame frame) {
		
      // jmenu de ACTION
		jmenuAutre.add(itemAide);
		jmenuAutre.add(itemQuitter);
		this.add(jmenuAutre);
		itemQuitter.addActionListener(e -> {
			frame.dispose();
		});
	
	}

}
