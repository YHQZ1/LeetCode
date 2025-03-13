void swap(int* a, int* b) {
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

bool canMakeArithmeticProgression(int* arr, int arrSize) {
    if (arrSize < 2) return true;
    quickSort(arr, 0, arrSize - 1);
    int difference = arr[1] - arr[0];

    for (int i = 1; i < arrSize - 1; i++) {
        if (arr[i + 1] - arr[i] != difference) {
            return false;
        }
    }
    return true;
}
