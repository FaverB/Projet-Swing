package ci.codeurs.ui.panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccueilPanel extends JPanel{
	
	public AccueilPanel() {
		setBackground(Color.magenta);
		JLabel jLabel = new JLabel("ICI C'EST L'ACCUEIL 10000Codeurs");
		jLabel.setFont(new Font("Courier New", Font.BOLD, 52));
		this.add(jLabel);
	}

}
