import java.sql.SQLOutput;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String xml_value = "<bode>\n" +
                "<table>\n" +
                "    <tr>\n" +
                "    <td></td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "\n" +
                "</bode>";


        String value = solution.validate_xml(xml_value);
        System.out.println(value);
    }
}