package nyc.c4q.yuliyakaleda;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Access Code 2.0
 * Yuliya Kaleda
 * First Game
 */
public class Geographer {
    public static void main(String[] args) {
        String[] countries;
        String userInput, longCountry, nextCountry, alphabet;
        char lastLetter, newLetter;
        int userScore, computerScore, userTotal, computerTotal, randomChar;
        countries = new String[]{"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "St. Kitts and Nevis", "St. Lucia", "St. Vincent and The Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> namedCountries = new ArrayList<String>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        //Rules explanation
        System.out.println("Welcome to Geographer, a game that will help us learn new countries! \nThe computer randomly chooses a country and your task is to"
                + " enter another country that starts with the same letter that previously mentioned country ends with."
                + " \nFor example, the computer gives you \"Belarus\", so you are to name a country that starts with \"s\"."
                + " Countries cannot be repeated and should start with an Upper Case letter."
                + " For each country you receive a certain number of points  "
                + " \nthat corresponds to the number of letters in the word."
                + " In our example Belarus is equal to 7 points. \nThe winner is the one who first"
                + " reaches a total of 100 points. If you do not know any country starting with a particular letter, press 'X'"
                + " to get a new letter.\nSo let's start!");

        //The computer randomly chooses a country
        int index = random.nextInt(countries.length);
        System.out.println(countries[index]);

        //Adding the country to the namedCountries list so that it should not be named again later
        namedCountries.add(countries[index]);
        lastLetter = countries[index].charAt(countries[index].length() - 1);
        userTotal = 0;
        computerTotal = 0;

        //The game continues till either of the players scores 100 points or more
        while (userTotal < 100 && computerTotal < 100) {
            System.out.println("Name the country that starts with \"" + lastLetter + "\": ");
            // The user types a country
            userInput = scanner.nextLine();
            //Checking whether the country exists in the world by looping through every entry in the array "countries"
            //If the country is in the "countries" array and was not named before/not in the "namedCountries" list, the user gets some points, the total score is calculated
            if (Arrays.asList(countries).contains(userInput) && !namedCountries.contains(userInput)) {
                namedCountries.add(userInput);
                lastLetter = Character.toLowerCase(userInput.charAt(userInput.length() - 1));
                userScore = userInput.length();
                userTotal += userScore;
                System.out.println("Great! You are getting " + userScore + " points. Your total is " + userTotal +
                        ". Now it is my turn to name the country that starts with \"" + lastLetter + "\":");
                //The computer chooses the longest word from the "countries" array to get max points
                longCountry = "";
                boolean hasBeenUsed = true;
                for (String country : countries)
                    if (Character.toLowerCase(country.charAt(0)) == lastLetter
                            && !namedCountries.contains(country)) {
                        hasBeenUsed = false;
                        nextCountry = country;
                        if (nextCountry.length() > longCountry.length()) {
                            longCountry = nextCountry;
                        }
                    }
                // If all the countries beginning with a certain letter were named, the computer chooses a random alphabet letter and let the user name a country
                if (hasBeenUsed) {
                    randomChar = random.nextInt(alphabet.length());
                    newLetter = alphabet.charAt(randomChar);
                    System.out.println("It seems like all the countries that start with \"" + lastLetter + "\" were mentioned."
                            + " Let's randomly choose a different letter.");
                    lastLetter = newLetter;
                    continue;
                }
                computerScore = longCountry.length();
                computerTotal += computerScore;
                lastLetter = longCountry.charAt(longCountry.length() - 1);
                System.out.println(longCountry + "\nI am getting " + computerScore + " points for naming " + longCountry +
                        ". My total is " + computerTotal + ".");
                namedCountries.add(longCountry);
            }
            //When the user types in the country that has already been named, the computer keeps asking for a new country
            else if (namedCountries.contains(userInput)) {
                System.out.println("Sorry, this country has already been mentioned. Try again.");
            }
            //When the user types "X" or "x", the computer chooses a new alphabet letter
            else if (userInput.equalsIgnoreCase("X")) {
                randomChar = random.nextInt(alphabet.length());
                newLetter = alphabet.charAt(randomChar);
                System.out.println("I know it is tough to name the country that starts with \"" + lastLetter + "\"."
                        + " Let's choose another letter.");
                lastLetter = newLetter;
            }
            //When the user gives the invalid country, the computer keeps asking for a valid entry
            else {
                System.out.println("Sorry, such a country does not exist. Remember about typing all the countries with a capital letter without any spaces!");
            }
        }
        //The game is over when anybody reaches 100 points or more
        if (userTotal >= 100) {
            System.out.println(" (╯︵╰,) Congratulations! You have gained 100 points or more. You won and the game is over");
        }
        else {
            System.out.println(" ＼（＾▽＾）／ Yayyyyyy! I have got 100 points. I won. Do not get upset. Learn the world's map better and "
                    + "you will win next time. The game is over!");
        }
    }
}









