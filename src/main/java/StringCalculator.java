public class StringCalculator {
    private static final String DEFAULT_DELIMITERS = "[,\n]";
    private static final String CUSTOM_DELIMITER = "//.\n";
    private static final String NEGATIVE_MATCH_PATTERN = "-(.+)";
    private static final int MAX_AUTHORIZED_NUMBER = 1000;

    public static int Add(String input) throws Exception {
        int sum = 0;
        String[] values = input.replaceAll(CUSTOM_DELIMITER, "").split(DEFAULT_DELIMITERS);

        assertNegative(values);

        for(String value : values) {
            int number = Integer.parseInt(value);
            if(number < MAX_AUTHORIZED_NUMBER) {
                sum += Integer.parseInt(value);
            }
        }

        return sum;
    }

    private static void assertNegative(String[] values) throws Exception {
        String result = "Les nombres négatifs ne sont pas autorisés : ";
        boolean hasNegative = false;

        for(String value : values) {
            if(value.matches(NEGATIVE_MATCH_PATTERN)) {
                hasNegative = true;
                result += value + ",";
            }
        }

        if(hasNegative) {
            throw new Exception(result.substring(0, result.length() - 1));
        }
    }
}
