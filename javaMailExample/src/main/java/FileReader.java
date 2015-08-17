import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by varga on 17.08.2015.
 */
public class FileReader {

    final static Charset ENCODING = StandardCharsets.UTF_8;

    public static List<String> getRegisteredPlayerNames(String aFileName) throws IOException,URISyntaxException {
        Path path = Paths. get( FileReader.class.getResource(aFileName).toURI());
        return Files.readAllLines(path, ENCODING);
    }


}
