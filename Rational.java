public class Rational{
    private int num;
    private int den;
    
    public int mdc(int num, int den){
        int resto;
        do{
            resto = num % den;
            num = den;
            den = resto;
        }while(resto != 0);
        return num;
    }
    public Rational(int num, int den){
        this.num = num / mdc(num, den);
        this.den = den / mdc(num, den);
    }
    
    public void ImprimirRational(){
        System.out.println(num+ "/" +den);
    }
    
    public void soma(Rational numero2, Rational resultado){
        resultado.num = num * numero2.den + numero2.num * den;
        resultado.den = den * numero2.den;
        
        int mdc = mdc(resultado.num, resultado.den);
        
        resultado.num /= mdc;
        resultado.num /= mdc;
        resultado.ImprimirRational();
    }
    
    public void subtrai(Rational numero2, Rational resultado){
        resultado.num = num * numero2.den - numero2.num * den;
        resultado.den = den * numero2.den;
        int mdc = mdc(resultado.num, resultado.den);
        resultado.num /= mdc;
        resultado.den /= mdc;
        resultado.ImprimirRational();
    }
    
    public void multiplica(Rational numero2, Rational resultado){
        resultado.num = num * numero2.num;
        resultado.den = den * numero2.den;
        int mdc = mdc(resultado.num, resultado.den);
        resultado.num /= mdc;
        resultado.den /= mdc;
        resultado.ImprimirRational();
    }
    
    public void divide(Rational numero2, Rational resultado){
        resultado.num = num * numero2.den;
        resultado.den = this.den * numero2.num;
        int mdc = mdc(resultado.num, resultado.den);
        resultado.num /= mdc;
        resultado.den /= mdc;
        resultado.ImprimirRational();
    }
    
    public void imprimeDecimal(int casas){
        float decimal = (float) num/den;
        System.out.printf("%."+casas+"f", decimal);
    }
    
}

import java.util.Scanner;

public class UsaRational{
    public static void main(String [] args){
        int casas;
        Scanner get = new Scanner(System.in);
        Rational numero1 = new Rational(1, 5);
        Rational numero2 = new Rational(1, 2);
        Rational resultado = new Rational(1, 7);
        
        System.out.println("Numero racional:");
        numero1.ImprimirRational();
        
        System.out.println("Numero racional:");
        numero2.ImprimirRational();
        
        System.out.println("Soma:");
        numero1.soma(numero2, resultado);
        
        System.out.println("Subtracao:");
        numero1.subtrai(numero2, resultado);
        
        System.out.println("Multiplicacao:");
        numero1.multiplica(numero2, resultado);
        
        System.out.println("Divisao:");
        numero1.divide(numero2, resultado);
        
        System.out.println("Casas decimais:");
        casas = get.nextInt();
        numero1.imprimeDecimal(casas);
    }
}