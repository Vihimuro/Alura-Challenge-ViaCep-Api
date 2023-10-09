import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public void generateJson(Adress adress) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter fileWriter = new FileWriter(adress.cep() + ".json");
        fileWriter.write(gson.toJson(adress));
        fileWriter.close();
    }
}
