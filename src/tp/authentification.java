package tp;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;



public class authentification extends JFrame implements ActionListener {

    private  JPanel panel;//déclaration du panel 
    private  JLabel label;//déclaration du label
    private  JTextField uti;//déclaration du textfield
    private  JLabel mdep;//déclaration du label
    private  JPasswordField mdp;//déclaration du passwordfield
    private  JButton b1;//déclaration du boutton 
    
    
   public  authentification () {//constructeur
	   super("authentification");//le titre

       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // lorsqu'on ferme une fenêtre, cela ne termine pas l'application. On demande par cette instruction que l'application se termine quand on ferme la fenêtre.
       
       this.setSize(600,400);//le size du frame
       this.setLocationRelativeTo(null);//On centre la fenêtre sur l'écran
   	this.setResizable(false);//
       this.setVisible(true);//On la rend visible
       this.b1 = new JButton("login");//creation de button 
       this.mdp = new JPasswordField();//creation de passwordfield
       this.label = new JLabel ("Nom d'utilisateur");//creation de label
       this.panel = new JPanel();//creation de panel 
       this.mdep = new JLabel ("Mot de passe ");//creation de label
       this.uti = new JTextField();//creation textfield
       this.add(panel);//ajouter panel à jframe
       panel.setLayout(null);//libre 
       
       
      
       label.setBounds(80, 115, 200, 30);//saisir la position du label et la taille 
       panel.add(label);//ajouter label au panel
       
       uti.setBounds(190, 120, 200, 23);//saisir la position du textfield et la taille 
       panel.add(uti);//ajouter  textfield au panel
       
      
       mdep.setBounds(90,180,200,20);//saisir la position du label et la taille 
       panel.add(mdep);//ajouter label au panel
       
       mdp.setBounds(190,180,200,23);//saisir la position du passwordfield et la taille 
       panel.add(mdp);//ajouter passwordfield au panel
       
       b1.setBounds(240, 220, 100, 30);//saisir la position du boutton et ça taille 
     
       panel.add(b1);//ajouter boutton  au panel
       b1.addActionListener(this);//ajouter une action à b1
       
   }

	public static void main(String[] args) {
		
		 authentification authentification =new authentification ();
		 authentification.setVisible(true);
	    
		

	}
	@Override
	public void actionPerformed(ActionEvent event) {
		
	if( event.getSource() == b1 )//verifier si 
	{
	
		String user = uti.getText();//recupere les inputs (utilisateur)
		
		String pass = mdp.getText();//recupere les inputs (mot de passe )
	
		try {//permet de définir un bloc de code à tester pour les erreurs lors de son exécution.




			Scanner x = new Scanner(new File("comptes.txt"));//utiliser le scanner pour la recherche 
			x.useDelimiter("[,\n]");//la méthode de recherche
			
            while (x.hasNextLine()) // jusqu'a la fin du fichier 
            	 {
            	String tmpuser=x.next();//variable  temporaire
                String tmppass=x.next();//variable  temporaire
            
             
            	 
				if (tmpuser.trim().equals(user.trim())&&tmppass.trim().equals(pass.trim()))//verifier mot de passe et nom d'utilisateur
				  {
					
				//ouvrir l'espace enseignant
					enseignant t1= new enseignant();
					t1.show();
					
					dispose();
					
					
			      }else {
			    	  JOptionPane.showMessageDialog(null,"Mot de passe/Nom d'utilisateur incorrect ");//message d'erreur
			    	  
			      }
			
			
                 
				}
            	 x.close();//fermer le  scanner
      
            
            	 
            	 }
		
               
            catch (Exception  e) {//permet de définir un bloc de code à exécuter, si une erreur se produit dans le bloc try.
            	System.out.printf("error");//message d'erreur
               
           }
		}
		
		}
		
		
	 } 


  
  



