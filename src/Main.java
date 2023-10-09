import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        CepQuery cepQuery = new CepQuery();

        System.out.println("Enter the CEP to search for: ");
        String cep = sc.next();

        try{
            Adress adress = cepQuery.searchAdress(cep);
            System.out.println(adress);
            FileGenerator fileGenerator = new FileGenerator();
            fileGenerator.generateJson(adress);
        }
        catch(RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Exiting application...");
        }
        System.out.println("Application finished");
    }
}