package ninja.mpnguyen.chowders.nio;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Credentials {
    private String username;
    private String password;
    private String email;

    public Credentials() {
        // Default no arg constructor
    }

    public Credentials(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    private static Credentials credentials = null;

    private static void init() throws IOException {
        if (credentials == null) {
            Gson gson = new Gson();
            File file = new File("./credentials.json");
            Reader reader = new FileReader(file);
            credentials = gson.fromJson(reader, Credentials.class);
            reader.close();
        }
    }

    public static String username() throws IOException {
        init();
        return credentials.username;
    }

    public static String password() throws IOException {
        init();
        return credentials.password;
    }

    public static String email() throws IOException {
        init();
        return credentials.email;
    }
}
