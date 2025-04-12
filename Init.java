import java.io.*;
import java.util.Random;

public class Init {
    // === Configurable section ===

    private static final String JAVA_FILE_NAME = "Main";

    private static final String TEST_FOLDER = "./"; // Current folder

    public static final String ALPHANUMERICS_CHARACTER_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static final String LOWERCASE_CHARACTER_SET = "abcdefghijklmnopqrstuvwxyz";

    public static final String NUMBERS_ONLY_CHARACTER_SET = "1234567890";

    public enum STRING_REPRESENTATION_MODE {
        DEFAULT,
        CAPITALIZE,
        LOWERCASE,
    }

    // === End configuration

    public static void writeToTestFile(String fileName, String data) {
        try {
            FileWriter fileWriter = new FileWriter(TEST_FOLDER + fileName, true);
            BufferedWriter info = new BufferedWriter(fileWriter);
            info.write(data);
            info.newLine();
            info.close();
        } catch (IOException exception) {
            System.out.println("IO Exception" + exception.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void generateOutFile(int testCaseNumber) {
        try {
            if (Init.JAVA_FILE_NAME.length() == 0) {
                throw new Exception("Java file name should not be empty");
            }
            String[] args = new String[] { "/bin/bash", "-c",
                    "java " + Init.JAVA_FILE_NAME + " < " + testCaseNumber + ".in > " + testCaseNumber + ".out" };
            Process proc = new ProcessBuilder(args).start();
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static String generateRandomString(String charactersSet, int minLength, int maxLength) {
        Random rng = new Random();
        int maxCharLength = generateRandomNumber(minLength, maxLength);
        char[] text = new char[maxCharLength];
        for (int i = 0; i < maxCharLength; i++) {
            text[i] = charactersSet.charAt(rng.nextInt(charactersSet.length()));
        }
        return new String(text);
    }

    public static int generateRandomNumber(int min, int max) {
        int randomInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return randomInt;
    }

    public static String generateRandomSentence(String representationMode) {
        StringBuilder sb = new StringBuilder();
        try {
            String[] args = new String[] { "/bin/bash", "-c",
                    "java -jar RandomSentenceGenerator.jar --pattern 'The <JJ> <NNS> <BED> <JJ>.' --iterations 1" };
            Process proc = new ProcessBuilder(args).start();

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (representationMode == STRING_REPRESENTATION_MODE.CAPITALIZE.name()) {
                    sb.append(StringUtils.capitalizeWord(line));
                } else {
                    sb.append(line);
                }
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return sb.toString();
    }

    public static String generatePartOfInputString(String s, int min) {
        int lengthOfSplit = s.split(" ").length;
        String[] strAsArray = new String[lengthOfSplit];
        for (int i = 0; i < strAsArray.length; i++) {
            strAsArray[i] = s.split(" ")[i];
        }
        int randomInt = (int) Math.floor(Math.random() * (lengthOfSplit - 1) + min);
        return strAsArray[randomInt];
    }

    public static char generateCharItemsNotInString(String seedStringPattern, String s) {
        for (int i = 0; i < seedStringPattern.length(); i++) {
            char character = seedStringPattern.charAt(i);
            if (s.indexOf(character) < 0) {
                return character;
            }
        }

        return ' ';
    }
}
