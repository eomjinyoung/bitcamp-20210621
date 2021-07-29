#include <stdio.h>

int plusi(int a, int b) {
    return a + b;
}

float plusf(float a, float b) {
    return a + b;
}


int main() {
    int a = 100;
    int b = 200;

    float a2 = 3.14f;
    float b2 = 2.71f;

    printf("%d + %d = %d\n", a, b, plusi(a, b));
    printf("%f + %f = %f\n", a2, b2, plusf(a2, b2));
    return 0;
}