import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.zip.CRC32;

/***
 * source:
 * https://github.com/flyway/flyway/blob/8678e82c335eb1f724b591ad205ca73ddac63dff/flyway-core/src/main/java/org/flywaydb/core/internal/util/scanner/AbstractLoadableResource.java
 */
public class Checksum {

    public static void main(String[] args) {
        System.out.println(Checksum.calculateChecksum());
    }

    public static int calculateChecksum() {
            final CRC32 crc32 = new CRC32();
            Path filePath = Paths.get("src/test/resources/V7.2__AlterReconciliationTable.sql");
            try (Stream<String> lines = Files.lines( filePath )){
                lines.forEach(s -> {
                    try {
                        crc32.update(trimLineBreak(s).getBytes("UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return (int) crc32.getValue();
    }

    public static String trimLineBreak(String str) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuilder buf = new StringBuilder(str);
        while (buf.length() > 0 && isLineBreakCharacter(buf.charAt(buf.length() - 1))) {
            buf.deleteCharAt(buf.length() - 1);
        }
        return buf.toString();
    }

    public static boolean hasLength(String str) {
        return str != null && str.length() > 0;
    }

    private static boolean isLineBreakCharacter(char ch) {
        return '\n' == ch || '\r' == ch;
    }
}
