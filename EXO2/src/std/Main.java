package std;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner;        //on initialise les variables.
        String scann;
        File directory;
        String fileList[];

        scanner = new Scanner(System.in);
        System.out.println("Donnez un chemin de répertoire :");
        scann = scanner.nextLine();
        directory = new File(scann);    //on crée un nouveau scanner récupérant le chemin du dossier
        fileList = directory.list();
        if (directory.exists() && directory.isDirectory()) {

            for (int i = 0;i < fileList.length;i++){        //on affiche la liste des fichiers présents dans le dossier.
                System.out.println(fileList[i]);
            }
        }else{
            System.out.println("Il n'y a pas de répertoire de ce nom, ou le chemin est incorrect.");
        }
    }
}
