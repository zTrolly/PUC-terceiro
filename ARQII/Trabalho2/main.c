#include <stdio.h> 
#include <stdlib.h> 
int main() 
{ 
    double a = 0.4*3.0 - 1.0;
    float b = a-0.2;
    float c = 0.2;
    float d = c - 0.2;

    printf("a -> %d\n",a); 
    printf("b -> %f\n",b); 
    printf("c -> %f\n",c); 
    printf("d -> %f\n",d); 
    if (a<=0.2) 
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