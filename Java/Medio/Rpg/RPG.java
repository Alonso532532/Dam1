package Java.Medio.Rpg;

import java.util.Scanner;

public class RPG {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        StringBuilder texto = new StringBuilder("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                    """.split());
        for (int i = 0; i<4; i++) {
            System.out.println();
        }
        System.out.print("└─> ");
        sc.nextLine();

    }
}
