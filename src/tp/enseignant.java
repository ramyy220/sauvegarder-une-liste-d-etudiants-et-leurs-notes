package tp;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;





public class enseignant extends JFrame implements ActionListener {
	
	protected static final DefaultTableModel JTableExport = null;//model tableau 
	private JPanel panel=new JPanel();//déclaration du panel 
	private JTextField matrice = new JTextField();//creation textfield
	private JTextField nom = new JTextField();//creation textfield
	private JTextField prénom = new JTextField();//creation textfield
	private JTextField adresse = new JTextField();//creation textfield
	private JTextField note = new JTextField();//creation textfield
	private JLabel lab1 =new JLabel("Matrice");//creation de label
	private JLabel lab2 =new JLabel("Nom");//creation de label
	private JLabel lab3 =new JLabel("Prénom");//creation de label
	private JLabel lab4 =new JLabel("Adresse");//creation de label
	private JLabel lab5 =new JLabel("Note");//creation de label
	private JMenuBar menubar = new JMenuBar();//creation de menubar
	private JButton menu= new JButton("nouveau");//creation de boutton 
	private JButton menu1= new JButton("Enregistrer ");//creation de boutton 
	private JButton menu2= new JButton("Supprimer");//creation de bouton 
	private JTable table = new JTable();//creation de table 
	private DefaultTableModel model = new DefaultTableModel();//creation de modol du tableau 
	private JScrollPane scroll = new JScrollPane(table);//creation de scrollpane
	
	
	public enseignant () {//constructeur
		
		super("Espace enseignant");//le titre de la fenêtre 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// lorsqu'on ferme une fenêtre, cela ne termine pas l'application. On demande par cette instruction que l'application se termine quand on ferme la fenêtre.
		this.setSize(800,700);//le size du frame
		this.setLocationRelativeTo(null);//On centre la fenêtre sur l'écran
		this.setResizable(false);
		this.setVisible(true);//On la rend visible
		this.add(panel);//ajouter panel au frame
		panel.setLayout(null);// methode pour modifier le layout
		
        lab1.setBounds(250, 100, 200, 25);//saisir la position du label et la taille 
		matrice.setBounds(300, 100, 200, 25);//saisir la position du textfield et la taille 
		panel.add(matrice);//ajouter  textfield au panel
		panel.add(lab1);//ajouter label au panel
		
		lab2.setBounds(250, 170, 200, 25);//saisir la position du label et la taille 
		nom.setBounds(300, 170, 200, 25);//saisir la position du textfield et la taille 
		panel.add(nom);//ajouter  textfield au panel
		panel.add(lab2);//ajouter label au panel
		
		lab3.setBounds(250, 240, 200, 25);//saisir la position du label et la taille 
		prénom.setBounds(300, 240, 200, 25);//saisir la position du textfield et la taille 
		panel.add(prénom);//ajouter  textfield au panel
		panel.add(lab3);//ajouter label au panel
		
		
		
		lab4.setBounds(250, 310, 200, 25);//saisir la position du label et la taille 
	    adresse.setBounds(300, 310, 200, 25);//saisir la position du textfield et la taille 
		panel.add(adresse);//ajouter  textfield au panel
		panel.add(lab4);//ajouter label au panel
		
		
		lab5.setBounds(250, 380, 200, 25);//saisir la position du label et la taille 
		note.setBounds(300, 380, 200, 25);//saisir la position du textfield et la taille 
		panel.add(note);//ajouter  textfield au panel
		panel.add(lab5);//ajouter label au panel
		
		
		scroll.setBounds(0, 500, 800, 400);//saisir la position du label et la taille 
		panel.add(scroll);//ajouter  au panel
		scroll.setViewportView(table);//ajouter label au panel
		
		
		menubar.setBounds(0, 0, 800, 30);//saisir la position du label et la taille 
		panel.add(menubar);//ajouter menubar
		menubar.add(menu);//ajouter button menu au panel
		menubar.add(menu1);//ajouter button menu au panel
		menubar.add(menu2);//ajouter button menu au panel
		table.setBackground(new Color (0,191,255));//couleur pour le tableau 
		Object[] colum = {"matrice","nom","pénom","adresse","note"};// les colonnes 
		final Object [] row = new Object[5];
		model.setColumnIdentifiers(colum);//identifier les colonnes 
		table.setModel(model);//saisir le modele du tableau 
	
		scroll.setViewportView(table);//Fournit une vue déroulante d'un composant léger
		menu.addActionListener(new ActionListener() {//ajouter une action au boutton menu (nouveau)
			public void actionPerformed(ActionEvent arg0) {
				//condition pour rmplir tout les cas 
			if(matrice.getText().equals("") || nom.getText().equals("")||prénom.getText().equals("")||adresse.getText().equals("")||note.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null,"rempli tous les cas");
				}
			
			else { //remplisage des row 
				row[0]=matrice.getText();
				row[1]=nom.getText();
				row[2]=prénom.getText();
				row[3]=adresse.getText();
				row[4]=note.getText();
				model.addRow(row);

				//pour vider les textfield apres le remplisage 

				matrice.setText("");
				nom.setText("");
				prénom.setText("");
				adresse.setText("");
				note.setText("0.0");
				
			
			}}
		});
		
		menu2.addActionListener(new ActionListener() {//ajouter une action au boutton menu2 (supprimer)
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();//declaration 
				if(i>=0) {//condition si la ligne ou colonnes sont selectionner
					model.removeRow(i);//suppression 
					JOptionPane.showMessageDialog(null,"supprimer ");//message de suppression réussite 
				
				}
				else {
				
				JOptionPane.showMessageDialog(null,"Sélectionner une ligne ");//message d'erreur 
				
			}}
		});
		
		menu1.addActionListener(new ActionListener() {//ajouter une action au boutton menu1 (Enregistrer) dans un ficher text 
			
			@Override
			
				  public void actionPerformed(ActionEvent e){
				   try{//permet de définir un bloc de code à tester pour les erreurs lors de son exécution.
					   
					   String filePath = "Etudiants.txt";//le fichier 
		        File file = new File ( filePath);
		        if(!file.exists()){//si le fichier n'existe pas 
	                   file.createNewFile();
	               }
	               
	               FileWriter ma = new FileWriter(file.getAbsoluteFile(),true);
	               BufferedWriter la = new BufferedWriter(ma);
	               
	               //boucle pour jtable ligne
	               for(int i = 0; i < model.getRowCount(); i++){
	                   //boucle pour jtable column
	                   for(int j = 0; j < model.getColumnCount(); j++){
	                       la.write(table.getModel().getValueAt(i, j)+" ");
	                   }
	                 // séparation 
	                   la.write("\n_________\n");
	               }
	               //fermer BufferedWriter
	               la.close();
	               //fermer FileWriter 
	               ma.close();
	               
	              
	               JOptionPane.showMessageDialog(null, "Données sauvegardées  ");//message de réussite
				   }
			
			catch(Exception e1){//permet de définir un bloc de code à exécuter, si une erreur se produit dans le bloc try.
	                   e1.printStackTrace();
	               }
		      
		           
			}} );}
		
		
	
	
	

	public static void main(String[] args) {//main 
	
		enseignant enseignant = new enseignant ();//creation 
		enseignant.setVisible(true);//visibilité activer
	}
	
	


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}



}
