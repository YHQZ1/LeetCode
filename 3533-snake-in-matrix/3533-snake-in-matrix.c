int finalPositionOfSnake(int n, char** commands, int commandsSize) {
    int i = 0;
    int j = 0;

    for (int k = 0; k < commandsSize; k++) {
        if (strcmp(commands[k], "UP") == 0) {
            if (i > 0) i--;  
        } else if (strcmp(commands[k], "RIGHT") == 0) {
            if (j < n - 1) j++; 
        } else if (strcmp(commands[k], "DOWN") == 0) {
            if (i < n - 1) i++; 
        } else if (strcmp(commands[k], "LEFT") == 0) {
            if (j > 0) j--;  
        } else {
            printf("Invalid command: %s\n", commands[k]);
        }
    }

    int finalPosition = (i * n) + j;
    return finalPosition;
}
