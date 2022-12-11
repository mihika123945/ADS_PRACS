#include <stdio.h>
#include<conio.h>
#include<stdlib.h>
#define Size 10
float cost= 0.0;
int TOS= -1, a[Size], energy= 0;
void push(){
    int x;
    if(TOS== Size-1){printf("\nStack Overflow!!\n");
}
else
{
    cost += 2;
    x = rand() % 100;
    TOS = TOS + 1;
    a[TOS] = x;
    printf("Pushed element in the stack:%d\n", a[TOS]);
    energy++;
}
}
void pop()
{
    if (TOS == -1)
    {
        printf("Stack Underflow!!\n");
    }
    else
    {
        printf("Popped element from the stack:%d\n", a[TOS]);
        TOS = TOS - 1;
        energy--;
    }
}
void multipop()
{
    if (TOS == -1)
    {
        printf("Stack Underflow!!\n");
    }
    else
    {
        int x, X, i;
        x = rand() % 5;
        X = (x < TOS) ? x : TOS;
        for (i = 1; i <= X; i++)
        {
            pop();
        }
    }
}
void main()
{
    int n, choice, i;
    float avg;
    printf("Enter the number of operations:");
    scanf("%d", &n);
    for (i = 1; i <= n; i++)
    {
        int choice = (rand() % 3);
        switch (choice)
        {
        case 0:
            push();
            break;
        case 1:
            pop();
            break;
        case 2:
            multipop();
            break;
        default:
            printf("Invalid Choice\n");
        }
    }
    printf("Total Cost:%f\n", cost);
    printf("Potential Energy:%d\n", energy);
    avg = cost / n;
    printf("Average Cost:%f", avg);
}