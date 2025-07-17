import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GrepTool {

    public String grep(String pattern, List<String> flags, List<String> filenames) {
        StringBuilder result = new StringBuilder();

        boolean showLineNumber = flags.contains("-n");
        boolean listFilenamesOnly = flags.contains("-l");
        boolean caseInsensitive = flags.contains("-i");
        boolean invertMatch = flags.contains("-v");
        boolean matchEntireLine = flags.contains("-x");

        for (String filename : filenames) {
            List<String> lines;
            try {
                lines = Files.readAllLines(Paths.get(filename));
            } catch (IOException e) {
                continue;
            }

            boolean fileHasMatch = false;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String compareLine = caseInsensitive ? line.toLowerCase() : line;
                String comparePattern = caseInsensitive ? pattern.toLowerCase() : pattern;

                boolean isMatch = matchEntireLine
                    ? compareLine.equals(comparePattern)
                    : compareLine.contains(comparePattern);

                if (invertMatch) {
                    isMatch = !isMatch;
                }

                if (isMatch) {
                    fileHasMatch = true;

                    if (listFilenamesOnly) {
                        result.append(filename).append("\n");
                        break;
                    }

                    if (filenames.size() > 1) {
                        result.append(filename).append(":");
                    }
                    if (showLineNumber) {
                        result.append(i + 1).append(":");
                    }
                    result.append(line).append("\n");
                }
            }
        }

        return result.toString().trim(); 
    }
}
