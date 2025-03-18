bool squareIsWhite(char* coordinates) {
    int column = coordinates[0] - 'a';
    int row = coordinates[1] - '1';  
    
    return (column + row) % 2 != 0; 
}