package std;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream theInput = null;
        FileOutputStream theOutput = null;
        Scanner scann;
        String extension;
        scann = new Scanner(System.in);

        try {

            System.out.println("entrez l'URL de l'image à copier");
            URL theURL = new URL(scann.nextLine());                 //Création de la connexion avec le serveur
            URLConnection urlConnect = theURL.openConnection();     //hébergeant l'image
            urlConnect.connect();
            theInput = urlConnect.getInputStream();
            String convertUrlToString = String.valueOf(theURL);
            //System.out.println("entrez l'extension voulue pour le fichier de destination");    //l'extension choisie par l'utilisateur
            extension = extractExtension(convertUrlToString);

            theOutput = new FileOutputStream(new File("destination."+extension));  //crée le fichier de destination en ajoutant l'extension choisie.
            byte[] buffer = new byte[1024];         //on crée un tableau de bytes
            int length;

            while ((length = theInput.read(buffer)) > 0) {      //on donne la valeur de length dans la boucle
                theOutput.write(buffer, 0, length);        //qui permet de réecrire bytes par bytes dans le second fichier.
            }
            theInput.close();           //On ferme les flux
            theOutput.close();
            System.out.println("Fichier copié avec succès");

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
    static String extractExtension(String file){        //fonction qui extrait l'extension du fichier (ici notre url)
        String fileExtension = "";
        int i = file.lastIndexOf(".");
        if (i != -1) {
            fileExtension = file.substring(i+1);
        }
        return fileExtension;
    }
}
