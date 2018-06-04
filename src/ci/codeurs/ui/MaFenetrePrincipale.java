package ci.codeurs.ui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

import ci.codeurs.ui.panel.AccueilPanel;
import ci.codeurs.ui.panel.ClientPanel;
import ci.codeurs.ui.panel.MenuDeNavigationPanel;
import ci.codeurs.ui.panel.ProduitPanel;

public class MaFenetrePrincipale extends JFrame{
	
	public MaFenetrePrincipale() {
		
		this.setJMenuBar(new MonMenuBar(this));
		
		this.setTitle("MA FENETRE PRINCIPALE");
		
		this.setSize(1150, 525);
		
		this.setResizable(false);
		
		this.setAlwaysOnTop(true);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		
		Container container = this.getContentPane();
		container.setLayout(null);
		
		
		AccueilPanel accueilPanel = new AccueilPanel();
		accueilPanel.setBounds(163, 1, 972, 452);
		container.add(accueilPanel);
		accueilPanel.setVisible(true);
		
		ClientPanel  clientPanel  = new ClientPanel();
		clientPanel.setBackground(new Color(204, 204, 204));
		clientPanel.setBounds(163, 1, 972, 452);
		container.add(clientPanel);
		clientPanel.setVisible(false);
		
		ProduitPanel produitPanel = new ProduitPanel();
		produitPanel.setBounds(163, 1, 972, 452);
		//container.add(produitPanel);
		produitPanel.setVisible(false);
		
		
		MenuDeNavigationPanel menuDeNavigationPanel = new MenuDeNavigationPanel(accueilPanel, clientPanel, produitPanel);
		menuDeNavigationPanel.setBounds(1, 1, 160, 260);
		container.add(menuDeNavigationPanel);
		
		
		this.setVisible(true);
		
		
	}

}
