package std;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileInputStream theInput = null;
        FileOutputStream theOutput = null;
        Scanner scann;
        String inputFile;
        String extension;
        scann = new Scanner(System.in);
        System.out.println("entrez le chemin du fichier a copier");
        inputFile = scann.nextLine();                                   //le fichier à copier

        System.out.println("entrez l'extension voulue pour le fichier de destination");
        extension = scann.nextLine();                                   //l'extension choisie par l'utilisateur

        try {
            File sourceFile =new File(inputFile);          //on récupère le fichier source

            theInput = new FileInputStream(sourceFile);         //on ouvre le fichier en lecture
            theOutput = new FileOutputStream(new File("destination."+extension));  //on crée le fichier de destination en ajoutant l'extension choisie.
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
}
