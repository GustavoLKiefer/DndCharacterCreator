import java.util.Scanner;

public class DndCharacterCreator {
    static int dex, con, str, wis, inte, chari;
    static String name, charClass, race;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        System.out.println("-------- Character Creator -----------");
        System.out.println("--------------------------------------");
        System.out.println();

        System.out.println("\nWhat's your character's name?");
        name = scanner.nextLine();

        System.out.println("\nWhat's your character's class?");
        charClass = scanner.nextLine();

        System.out.println("\nWhat's your character's race?");
        race = scanner.nextLine();

        clearScreen();
        createAbilities();
        clearScreen();
        characterSheet();
    }

    public static void createAbilities() {
        System.out.println("---------------------------------------");
        System.out.println("-------- Character Abilities ----------");
        System.out.println("---------------------------------------");
        System.out.println();

        dex = validateAbility("Dexterity", scanner);
        con = validateAbility("Constitution", scanner);
        str = validateAbility("Strength", scanner);
        wis = validateAbility("Wisdom", scanner);
        inte = validateAbility("Intelligence", scanner);
        chari = validateAbility("Charisma", scanner);

        System.out.println("\n--- Ability Modifiers ---");
        System.out.printf("Dexterity: %+d\n", calculateModifier(dex));
        System.out.printf("Constitution: %+d\n", calculateModifier(con));
        System.out.printf("Strength: %+d\n", calculateModifier(str));
        System.out.printf("Wisdom: %+d\n", calculateModifier(wis));
        System.out.printf("Intelligence: %+d\n", calculateModifier(inte));
        System.out.printf("Charisma: %+d\n", calculateModifier(chari));
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int calculateModifier(int abilityScore) {
        return (abilityScore - 10) / 2;
    }

    public static int validateAbility(String abilityName, Scanner scanner) {
        int score;
        do {
            System.out.println(abilityName + " score (8-20): ");
            score = scanner.nextInt();
            scanner.nextLine();

            if (score < 8 || score > 20) {
                System.out.println("Invalid value! Please enter a value between 8-20");
            }
        } while (score < 8 || score > 20);
        return score;
    }

    public static void characterSheet() {
        System.out.println();
        System.out.println("-----------------------");
        System.out.println("---- Character Sheet --");
        System.out.println("-----------------------");
        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Class: " + charClass);
        System.out.println("Race: " + race);
        System.out.println();
        System.out.println("Abilities");
        System.out.println();
        System.out.println("Dexterity: " + dex + " (" + (calculateModifier(dex) >= 0 ? "+" : "") + calculateModifier(dex) + ")");
        System.out.println("Constitution: " + con + " (" + (calculateModifier(con) >= 0 ? "+" : "") + calculateModifier(con) + ")");
        System.out.println("Strength: " + str + " (" + (calculateModifier(str) >= 0 ? "+" : "") + calculateModifier(str) + ")");
        System.out.println("Wisdom: " + wis + " (" + (calculateModifier(wis) >= 0 ? "+" : "") + calculateModifier(wis) + ")");
        System.out.println("Intelligence: " + inte + " (" + (calculateModifier(inte) >= 0 ? "+" : "") + calculateModifier(inte) + ")");
        System.out.println("Charisma: " + chari + " (" + (calculateModifier(chari) >= 0 ? "+" : "") + calculateModifier(chari) + ")");
    }
}