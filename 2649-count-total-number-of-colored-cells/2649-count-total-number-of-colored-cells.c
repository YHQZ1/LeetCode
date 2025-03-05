long long coloredCells(int n) {
  long long result=1;
  for(int i=0; i<n; i++){
    result=result+4*i;
  }
  return result;
}