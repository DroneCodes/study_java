package exercises;

import java.util.HashMap;
import java.util.Map;

public class ZubsSimplePuzzle {

    public static void main(String[] args) {
        Map<String, Integer> Animals = new HashMap<>();
        Map<Integer, String> Letters = new HashMap<>();
        int[] values = {1, 3, 4, 7, 8, 10, 12, 13, 14, 15, 16, 18, 19, 20};
        int iterations = 0;

        // Define list of animals with initial known values
        Animals.put("Snail", 17);
        Animals.put("Spider", 0);
        Animals.put("Green", 0);
        Animals.put("Brown", 2);
        Animals.put("Bee", 0);
        Animals.put("Fly", 0);
        Animals.put("Ladybird", 0);
        Animals.put("Butterfly", 0);
        Animals.put("Hopper", 0);

        // Define list of letters
        Letters.put(1, "A");
        Letters.put(2, "B");
        Letters.put(3, "L");
        Letters.put(4, "T");
        Letters.put(7, "W");
        Letters.put(8, "X");
        Letters.put(10, "P");
        Letters.put(12, "G");
        Letters.put(13, "V");
        Letters.put(14, "R");
        Letters.put(15, "O");
        Letters.put(16, "S");
        Letters.put(17, "I");
        Letters.put(18, "E");
        Letters.put(19, "U");
        Letters.put(20, "Z");

        // Calculate the value of Ladybird
        Animals.put("Ladybird", 26 - (Animals.get("Snail") + Animals.get("Brown")));

        // Loop through possible values for Spider
        for (int spider_val : values) {
            Animals.put("Spider", spider_val);

            // Loop through possible values for Green
            for (int green_val : values) {
                Animals.put("Green", green_val);

                // Skip to the next iteration of Green if it doesn't satisfy the first equation
                if (Animals.get("Snail") + Animals.get("Spider") + Animals.get("Green") != 37) {
                    continue;
                }

                // Loop through possible values for Bee
                for (int bee_val : values) {
                    Animals.put("Bee", bee_val);

                    // Loop through possible values for Fly
                    for (int fly_val : values) {
                        Animals.put("Fly", fly_val);

                        // Skip to the next iteration of Fly if it doesn't work
                        if (Animals.get("Brown") + Animals.get("Bee") + Animals.get("Fly") != 19) {
                            continue;
                        }

                        // Loop through possible values for Butterfly
                        for (int butterfly_val : values) {
                            Animals.put("Butterfly", butterfly_val);

                            // Calculate the value for Hopper directly to satisfy the constraints
                            Animals.put("Hopper", 38 - (Animals.get("Ladybird") + Animals.get("Butterfly")));

                            // Count the steps
                            iterations++;

                            boolean hopperFound = false;
                            for (int value : values) {
                                if (value == Animals.get("Hopper")) {
                                    hopperFound = true;
                                    break;
                                }
                            }

                            if (!hopperFound) {
                                continue;
                            }


                            // Check if the totals are correct
                            if (
                                    Animals.get("Snail") + Animals.get("Spider") + Animals.get("Green") == 37 &&
                                            Animals.get("Brown") + Animals.get("Bee") + Animals.get("Fly") == 19 &&
                                            Animals.get("Ladybird") + Animals.get("Butterfly") + Animals.get("Hopper") == 38 &&
                                            Animals.get("Snail") + Animals.get("Brown") + Animals.get("Ladybird") == 26 &&
                                            Animals.get("Spider") + Animals.get("Bee") + Animals.get("Butterfly") == 41 &&
                                            Animals.get("Green") + Animals.get("Fly") + Animals.get("Hopper") == 27
                            ) {
                                // Set word
                                String word = Letters.get(Animals.get("Butterfly")) +
                                        Letters.get(Animals.get("Snail")) +
                                        Letters.get(Animals.get("Hopper")) +
                                        Letters.get(Animals.get("Ladybird")) +
                                        Letters.get(Animals.get("Bee"));

                                // Print word and values of each animal
                                System.out.println(word + " - Spider = " + Animals.get("Spider") +
                                        ", Green = " + Animals.get("Green") +
                                        ", Bee = " + Animals.get("Bee") +
                                        ", Fly = " + Animals.get("Fly") +
                                        ", Ladybird = " + Animals.get("Ladybird") +
                                        ", Butterfly = " + Animals.get("Butterfly") +
                                        ", Hopper = " + Animals.get("Hopper"));
                            }
                        }
                    }
                }
            }
        }
        System.out.println("The end...");
        System.out.println("Took " + iterations + " iterations");
    }
}
