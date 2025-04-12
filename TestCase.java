public class TestCase {

    public static final int NUMBER_OF_IN_OUT_TEST_FILES = 10;

    public static final int SAMPLE_PER_TEST = 10;

    private static String[] generateTestCases() {
        String[] s = new String[TestCase.SAMPLE_PER_TEST];

        for (int i = 0; i < s.length; i++) {
            String randomStr = Init.generateRandomString(Init.ALPHANUMERICS_CHARACTER_SET, 10, 20);
            s[i] = randomStr;
        }

        return s;
    }

    // === Main class ===
    public static void main(String[] args) {
        for (int i = 1; i <= TestCase.NUMBER_OF_IN_OUT_TEST_FILES; i++) {
            Init.writeToTestFile(i + ".in", "" + TestCase.SAMPLE_PER_TEST);
            String[] testCases = generateTestCases();
            for (String testCase : testCases) {
                Init.writeToTestFile(i + ".in", testCase);
                Init.generateOutFile(i);
            }
        }
    }
}