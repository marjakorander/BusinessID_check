package fi.academy;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        // asking user to give business identity code
        Scanner reader = new Scanner(System.in);
        System.out.println("Anna y-tunnus");
        String ytunnus = reader.nextLine();
        while (ytunnus.isEmpty()) {
            System.out.println("Anna y-tunnus");
            ytunnus = reader.nextLine();
        }
        if (checkYtunnus(ytunnus) && (checkLastNumber(ytunnus))) {
            System.out.println("Muodollisesti oikea Y-tunnus");
        } else {
            System.out.println("Epävalidi Y-tunnus");
        }
    }


    // checking that the first (yksilöivä osa) and the second part (tarkastusnumero) are formally correct
    public static boolean checkYtunnus(String ytunnus) {
        return ytunnus.matches("[0-9]{7}[-][0-9]");
    }

    // checking that the second part (tarkastusnumero) is correct
    public static boolean checkLastNumber(String ytunnus) {
        int one = Integer.parseInt(ytunnus.substring(0, 1));
        int two = Integer.parseInt(ytunnus.substring(1, 2));
        int three = Integer.parseInt(ytunnus.substring(2, 3));
        int four = Integer.parseInt(ytunnus.substring(3, 4));
        int five = Integer.parseInt(ytunnus.substring(4, 5));
        int six = Integer.parseInt(ytunnus.substring(5, 6));
        int seven = Integer.parseInt(ytunnus.substring(6, 7));
        int sum = (one * 7) + (two * 9) + (three * 10) + (four * 5) + (five * 8) + (six * 4) + (seven * 2);
        if (Integer.parseInt(ytunnus.substring(8, 9)) == 11 - (sum % 11)) {
            return true;
        } else {
            return false;
        }
    }
}
