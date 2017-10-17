package std;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String scann;
        File f;

        System.out.println("Donnez un chemin de répertoire :");
        scann = scanner.nextLine();         //on crée le scanner.
        f = new File(scann);

        while(executionLoop(scanner,f));    //la boucle continue tant que theReturn est positif.

    }
    static boolean executionLoop(Scanner scanner, File f){  //fonction d'affichage
        boolean theReturn = true;
        boolean goodExtension = false;
        String fileList[];
        System.out.println("");
        System.out.println("Choisissez une extension : (exemple 'txt', 'zip')");
        String searchExtension = scanner.nextLine();        //on choisi une extension
        if (searchExtension != null && searchExtension.compareTo("quit") == 0){ //Si l'utilisateur tape 'quit' a la place de l'extension, arrête le programme.
            theReturn = false;
        }else{
            fileList = f.list();
            if (f.isDirectory() && f.exists()) {

                for (int i = 0;i < fileList.length;i++){
                    goodExtension = verifyExtension(searchExtension,fileList[i]);
                    if (goodExtension){
                        System.out.println(fileList[i]);        //on affiche la liste des fichiers avec la bonne extension.
                    }}
            }else{
                System.out.println("Il n'y a pas de répertoire de ce nom, ou le chemin est incorrect.");
            }}
        return theReturn;
    }

    static boolean verifyExtension(String theExtension, String theFile){    //fonction qui vérifie l'extension
        boolean theReturn = false;
        String theFileExtension = extractExtension(theFile);

        if(theExtension != null && theExtension.compareTo(theFileExtension) == 0){  //on compare l'extension choisie avec l'extension de la ligne.
            theReturn = true;
        }
        return theReturn;
    }

    static String extractExtension(String file){        //fonction qui extrait l'extension du fichier
        String fileExtension = "";
        int i = file.lastIndexOf(".");
        if (i != -1) {
            fileExtension = file.substring(i+1);
        }
        return fileExtension;
    }
}
