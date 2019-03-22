import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Running with Java " + System.getProperty("java.version"));
        System.out.println();

        print(new URL("https://cloudflare.krejci.pw"));
        print(new URL("https://letsencrypt.krejci.pw"));
    }

    private static void print(URL url) {
        System.out.println("================================================================================");
        System.out.println("Trying to obtain " + url);
        System.out.println();

        try {
            URLConnection conn = url.openConnection();

            StringBuilder bld = new StringBuilder();
            try (InputStreamReader in = new InputStreamReader(conn.getInputStream())) {
                int c;
                while ((c = in.read()) != -1) {
                    bld.append((char) c);
                }
            }

            System.out.println(bld.toString());
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            e.printStackTrace(System.out);
        }
    }
}
