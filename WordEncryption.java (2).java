import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLineLength = 0;

        for (String word : words) {
            
            if (currentLineLength + word.length() + currentLine.size() > maxWidth) {
           
                result.add(justifyLine(currentLine, currentLineLength, maxWidth, false));
                
                currentLine = new ArrayList<>();
                currentLineLength = 0;
            }
           
            currentLine.add(word);
            currentLineLength += word.length();
        }
     
        result.add(justifyLine(currentLine, currentLineLength, maxWidth, true));

        return result;
    }

    private static String justifyLine(List<String> line, int lineLength, int maxWidth, boolean isLastLine) {
        StringBuilder sb = new StringBuilder();
        int numWords = line.size();
        int spaces = maxWidth - lineLength;

        if (isLastLine || numWords == 1) {
            
            sb.append(String.join(" ", line));
            for (int i = 0; i < maxWidth - sb.length(); i++) {
                sb.append(' ');
            }
        } else {
          
            int spacesBetweenWords = spaces / (numWords - 1);
            int extraSpaces = spaces % (numWords - 1);

            for (int i = 0; i < numWords; i++) {
                sb.append(line.get(i));
                if (i < numWords - 1) {
                    int spaceToAdd = spacesBetweenWords + (i < extraSpaces ? 1 : 0);
                    for (int j = 0; j < spaceToAdd; j++) {
                        sb.append(' ');
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        List<String> justifiedText = fullJustify(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println("|" + line + "|");
        }
    }
}
