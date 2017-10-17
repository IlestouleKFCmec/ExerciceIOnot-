package std;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner;    //on initialise les variables.
        String scann;
        File fileToScan;

        scanner = new Scanner(System.in);       //on crée un nouveau scanner
        System.out.println("Donnez un chemin :");
        scann = scanner.nextLine();
        fileToScan = new File(scann);

        if (fileToScan.exists() == true) {      //Si le fichier existe on entre dans le if
            System.out.println("Ce fichier/dossier existe.");
            if (fileToScan.isFile() == true) {
                System.out.println("Il s'agit d'un fichier");
            } else {
                System.out.println("Il s'agit d'un dossier");
            }
        }else{                                  //Si le fichier n'existe pas
            System.out.println("Votre fichier/dossier n'existe pas");
        }
    }
}
