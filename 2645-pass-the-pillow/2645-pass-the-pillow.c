int passThePillow(int n, int time) {
    int pos = 1, direction = 1;
    
    for (int i = 0; i < time; i++) {
        if (pos == 1) direction = 1;
        if (pos == n) direction = -1;
        pos += direction;
    }
    
    return pos;
}
