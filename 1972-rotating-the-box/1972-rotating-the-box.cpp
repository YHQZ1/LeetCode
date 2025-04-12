class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& boxGrid) {
        int row = boxGrid.size();
        int col = boxGrid[0].size();
        vector<vector<char>> box_rotated(col, vector<char>(row));

        for (int i = 0; i < row; i++){
            int cell = col - 1;
            for (int j = col - 1; j >= 0; j--){
                if (boxGrid[i][j] == '*'){
                    cell = j - 1;
                }
                else if (boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';
                    boxGrid[i][cell--] = '#';
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                box_rotated[j][row - i - 1] = boxGrid[i][j];
            }
        }
        return box_rotated;
        
    }
};