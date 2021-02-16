public class DZ_2_4 {
    public static void main(String[] args) {
        String phone = "+79755551573";
        String[] mass = correctNumber(phone);
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
        }
    }

    public static String[] correctNumber(String number) {
        String[] array = new String[2];
        int length = number.length();
        boolean space_bracket = false;
        boolean seven = false;
        number = number.replace(" ", "");
        if (length != number.length()) {
            space_bracket = true;
        }

        length = number.length();
        number = number.replace("(", "");
        if (length != number.length()) {
            space_bracket = true;
        }

        length = number.length();
        number = number.replace(")", "");
        if (length != number.length()) {
            space_bracket = true;
        }


        if (number.indexOf("+") == 0 && number.indexOf("7") == 1 ){
            number = number.replace("+7", "8");
            seven = true;
        }

        if (number.length() != 11) {
            array[0] = "Введен некорректный номер";
            if (number.length() > 11) {
                array[1] = "Количество символов больше 11";
            } else
                array[1] = "Количество символов меньше 11";
        }

        if (array[0] == null) {
            array[0] = number;

            if (seven) {
                array[1] = "Замена +7 на 8";
            }
            if (seven && space_bracket) {
                array[1] += "; В номере есть пробелы и/или скобки";
            } else if (space_bracket && !seven) {
                array[1] = "В номере есть пробелы и/или скобки";
            }
            if (!seven && !space_bracket) {
                array[1] = "Не было изменений";
            }
        }


        return array;
    }
}
