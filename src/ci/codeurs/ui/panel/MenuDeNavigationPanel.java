package ci.codeurs.ui.panel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuDeNavigationPanel extends JPanel{
	
	public MenuDeNavigationPanel(AccueilPanel accueilPanel, ClientPanel clientPanel, ProduitPanel produitPanel) {
		
		this.setBackground(Color.CYAN);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(new JLabel(new ImageIcon("noBack.png")));
		this.add(new JLabel("ANAGKAZO"));
		
		Button btnAccueil = new Button("ACCUEIL");
		btnAccueil.setFont(new Font("Courier New", Font.BOLD, 25));
		btnAccueil.setBackground(Color.magenta);
		
		Button btnClient = new Button("CLIENTS");
		btnClient.setFont(new Font("Courier New", Font.BOLD, 25));
		btnClient.setBackground(Color.cyan);
		
		Button btnProduit = new Button("PRODUITS");
		btnProduit.setFont(new Font("Courier New", Font.BOLD, 25));
		
		Button btnProfil = new Button("MON PROFIL");
		btnProfil.setFont(new Font("Courier New", Font.BOLD, 25));
		
		this.add(btnAccueil);
		this.add(btnClient);
		this.add(btnProduit);
		this.add(btnProfil);
		
		btnClient.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnClient.setBackground(new Color(204, 204, 204));
				btnAccueil.setBackground(Color.cyan);
				
				accueilPanel.setVisible(false);
				clientPanel.setVisible(true);
			}
		});
		
		btnAccueil.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnAccueil.setBackground(Color.magenta);
				btnClient.setBackground(Color.cyan);
				
				accueilPanel.setVisible(true);
				clientPanel.setVisible(false);
			}
		});
		
	}

}
