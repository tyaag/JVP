public class UserInputBuilder {

    // a. TextInputBuilder: accepts all characters
    public static class TextInputBuilder {
        protected StringBuilder value = new StringBuilder();

        public void add(char c) {
            value.append(c); // adds any character
        }

        public String getValue() {
            return value.toString(); // returns current value
        }
    }

    // b. NumericInputBuilder: accepts only digits
    public static class NumericInputBuilder extends TextInputBuilder {
        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                value.append(c);
            }
        }
    }

    // c. OddNumericInputBuilder: accepts only odd digits
    public static class OddNumericInputBuilder extends NumericInputBuilder {
        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (digit % 2 == 1) {
                    value.append(c);
                }
            }
        }
    }

    // d. EvenNumericInputBuilder: accepts only even digits
    public static class EvenNumericInputBuilder extends NumericInputBuilder {
        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (digit % 2 == 0) {
                    value.append(c);
                }
            }
        }
    }

    // e. main() to test all builder types
    public static void main(String[] args) {
        TextInputBuilder textBuilder = new TextInputBuilder();
        textBuilder.add('H');
        textBuilder.add('e');
        textBuilder.add('1');
        textBuilder.add('!');
        System.out.println("TextInputBuilder: " + textBuilder.getValue());

        TextInputBuilder numericBuilder = new NumericInputBuilder();
        numericBuilder.add('4');
        numericBuilder.add('a');
        numericBuilder.add('3');
        System.out.println("NumericInputBuilder: " + numericBuilder.getValue());

        TextInputBuilder oddBuilder = new OddNumericInputBuilder();
        oddBuilder.add('9');
        oddBuilder.add('2');
        oddBuilder.add('5');
        System.out.println("OddNumericInputBuilder: " + oddBuilder.getValue());

        TextInputBuilder evenBuilder = new EvenNumericInputBuilder();
        evenBuilder.add('8');
        evenBuilder.add('3');
        evenBuilder.add('6');
        System.out.println("EvenNumericInputBuilder: " + evenBuilder.getValue());
    }
}
