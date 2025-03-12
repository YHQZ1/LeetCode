double average(int* salary, int salarySize) {
    int max = salary[0];
    int min = salary[0];
    int sum = 0;

    for (int i = 0; i < salarySize; i++) {
        sum += salary[i];
        if (salary[i] > max) max = salary[i];
        if (salary[i] < min) min = salary[i];
    }

    return (sum - max - min) / (double)(salarySize - 2);
}
