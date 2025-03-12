void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return i + 1;
}

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high); 

        quickSort(arr, low, pi - 1); 
        quickSort(arr, pi + 1, high); 
    }
}

double average(int* salary, int salarySize) {
    quickSort(salary, 0, salarySize-1);
    double sum=0;
    for(int i=1; i<salarySize-1; i++){
        sum = sum+salary[i];
    }

    double avg = sum/(salarySize-2);

    return avg;
}