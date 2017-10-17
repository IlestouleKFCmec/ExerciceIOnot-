package std;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner;
        File myFile;

        scanner = new Scanner(System.in);
        System.out.println("Ecrivez ici, tout sera inscrit dans un fichier texte");
        System.out.println("Pour quitter tapez 'quit'.");
        while (executionLoop(scanner));         //boucle d'execution

    }

    static boolean executionLoop(Scanner scanner){      //fonction d'execution
        boolean theReturn = true;
        String myTextTyped = scanner.nextLine();
        if (myTextTyped != null && myTextTyped.compareTo("quit") == 0){
            theReturn = false;
        }else {
            try {

                FileWriter writer = new FileWriter("./test.txt",true);       //on crée un nouvel objet pour ecrire dans le fichier txt
                try {
                    writer.write(myTextTyped+'\n');      //on écrit le texte tapé dans le fichier
                } finally {
                    writer.close();             //on ferme le flux
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return theReturn;
    }
}
