package exclude;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by serhii on 24.02.18.
 */
public class TestFireBase {

    public static void main(String[] args) throws IOException {
//        FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.create(new AccessToken(
                        "AIzaSyAoHm_mqCH3pcDOgyEmUy2hbPj_UUligGc", null)))
                .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);
        FirebaseDatabase defaultDatabase = FirebaseDatabase.getInstance();
        defaultDatabase.

    }
}
