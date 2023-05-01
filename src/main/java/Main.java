import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // nie zmieniaj nic w main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.run(scanner);
    }

    void run(Scanner scanner) {
        // usupełnij metodę
        String fileName = "countries.csv";
        Map<String, Country> countries = new HashMap<>();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Brak pliku " + fileName + ".");
        } else {
            readFromFileToMap(fileName, countries);
            System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
            String code = scanner.nextLine();
            if (countries.containsKey(code)) {
                Country country = countries.get(code);
                System.out.println(country.getName() + " (" + country.getCode() + ") ma " + country.getPopulation() + " ludności.");
            } else {
                System.out.println("Kod kraju " + code + " nie został znaleziony.");
            }
        }
    }

    private void readFromFileToMap(String fileName, Map<String, Country> countries) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(";");
                countries.put(split[0], new Country(split[0], split[1], Long.parseLong(split[2])));
            }
        } catch (IOException e) {
            System.out.println("Nie udalo sie odczytac pliku " + fileName);
        }
    }
}
