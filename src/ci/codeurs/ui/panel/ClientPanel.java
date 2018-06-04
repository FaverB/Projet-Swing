package ci.codeurs.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import ci.codeurs.domaine.Client;
import ci.codeurs.ui.model.ModelClient;

public class ClientPanel extends JPanel {
	
	JTextField txtNom;
	JTextField txtPrenom;
	JTextField txtContact;
	JTextField txtFonction;
	ButtonGroup buttonGroup;

	public ClientPanel() {
		
		JLabel labelNom = new JLabel("NOM");
		JLabel labelPrenom = new JLabel("PRENOM");
		JLabel labelContact = new JLabel("CONTACT");
		JLabel labelFonction = new JLabel("FONCTION");
		JLabel labelSexe = new JLabel("SEXE");

		txtNom = new JTextField();
		txtPrenom = new JTextField();
		txtContact = new JTextField();
		txtFonction = new JTextField();
		
		JRadioButton radioH = new JRadioButton("Homme");
		radioH.setBackground(new Color(204, 204, 204));
		
		JRadioButton radioF = new JRadioButton("Femme");
		radioF.setBackground(new Color(204, 204, 204));
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioH);
		buttonGroup.add(radioF);

		JButton btnValider = new JButton("VALIDER");
		JButton btnAnnuller = new JButton("ANNULER");
		JButton btnSupr = new JButton("SUPRIMER");
		JButton btnModif = new JButton("MODIFIER");
		
		JPanel formPanel = new JPanel();
		formPanel.setBackground(new Color(204, 204, 204));
		formPanel.setLayout(new GridLayout(7, 2, 0, 5));
		formPanel.add(labelNom);
		formPanel.add(txtNom);
		
		formPanel.add(labelPrenom);
		formPanel.add(txtPrenom);
		
		formPanel.add(labelContact);
		formPanel.add(txtContact);
		
		formPanel.add(labelFonction);
		formPanel.add(txtFonction);
		
		formPanel.add(radioF);
		formPanel.add(radioH);
		
		formPanel.add(btnAnnuller);
		formPanel.add(btnValider);
		formPanel.add(btnModif);
		formPanel.add(btnSupr);
		
		JPanel txtAndBtnPanel = new JPanel();
		txtAndBtnPanel.setLayout(new BoxLayout(txtAndBtnPanel,BoxLayout.Y_AXIS));
		txtAndBtnPanel.setBounds(3, 3, 300, 445);
		txtAndBtnPanel.setBackground(new Color(204, 204, 204));
		
		ImageIcon icon = new ImageIcon("salut.gif");
		txtAndBtnPanel.add(new JLabel(icon));
		txtAndBtnPanel.add(new JLabel("ZONE DE SAISIE"));
		
		
		this.setLayout(null); // absoluteLayout
		this.add(txtAndBtnPanel);
		
		txtAndBtnPanel.add(formPanel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(310, 3, 669, 545);
		tablePanel.setBackground(new Color(204, 204, 204));
		
		
		ModelClient modelClient = new ModelClient();
		JTable tableClient = new JTable(modelClient);
		JScrollPane jScrollPane = new JScrollPane(tableClient);
		jScrollPane.setPreferredSize(new Dimension(665, 544));
		tablePanel.add(jScrollPane);
		this.add(tablePanel);
		
		// action sur "btnAnnuler"
		btnAnnuller.addActionListener(e -> {
			this.viderLesChamps();
		});
		
		// action sur "btnValider"
		btnValider.addActionListener( e -> {
			String sexe = "";
			if(radioH.isSelected()) sexe = "MALE";
			else if(radioF.isSelected()) sexe = "FEMELLE";
			
			Client c = new Client(txtNom.getText(), txtPrenom.getText(), txtContact.getText(), txtFonction.getText(), sexe);
			this.viderLesChamps();
			if(modelClient.ajouterClient(c)) {
				JOptionPane.showMessageDialog(null, "Enregistrement effectué ", "INFORMATION", JOptionPane.DEFAULT_OPTION);
			}
		});
		
		
		
	}
	
	public void viderLesChamps() {
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtContact.setText("");
		this.txtFonction.setText("");
		this.buttonGroup.clearSelection();
	}

}
