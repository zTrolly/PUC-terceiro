#include <stdio.h> 
#include <stdlib.h> 
int main() 
{ 
    double a = 0.4*3.0 - 1.0;
    float b = a-0.2F;
    float c = 0.2;
    float d = c - 0.2F;

    if (a<=0.2F) 
    printf("menor ou igual"); 
    else 
    printf("Ups! maior ou diferente"); 
    printf("\n"); 
 
    if (b<=0) 
    printf("menor ou igual"); 
    else 
    printf("Ups! maior ou diferente"); 
    printf("\n"); 
 
    if (d<=0) 
    printf("menor ou igual"); 
    else 
    printf("Ups! maior ou diferente"); 
    return 0; 
} 