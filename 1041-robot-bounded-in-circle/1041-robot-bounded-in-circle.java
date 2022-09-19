class Solution {
    public static boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        instructions = instructions + instructions + instructions + instructions;
        String [] directions = new String[]{"north", "west", "south", "east"};

        int pointer = 0;

        for (int i = 0; i < instructions.length(); i++) {

            if (instructions.charAt(i) == 'L') {
                pointer = (pointer + 1) % 4;
            }
            else if (instructions.charAt(i) == 'R') {
                pointer = pointer == 0 ? 3 : (pointer - 1);
            } else {
                switch (directions[pointer]) {
                    case "north": {
                        y++;
                        break;
                    }
                    case "west": {
                        x--;
                        break;
                    }
                    case "south": {
                        y--;
                        break;
                    }
                    case "east": {
                        x++;
                        break;
                    }
                }
            }
        }
        return x == 0 && y == 0;
    }
}