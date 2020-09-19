package Simbolos;
import java.util.Scanner;
import java.util.Stack;

public class Simbolos {
    public static void main(String[] args) {
        System.out.println("******** Validador de fechamento de parenteses ********");
        boolean ficar = false;
        do {
            try {
                System.out.println("Símbolos permitidos: { [ ( < > ) ] }");
                System.out.println("Digite a entrada de símbolos desejada: ");
                Scanner read = new Scanner(System.in);
                String escrita = read.nextLine();
                if (ehValido(escrita)) {
                    System.out.println("Válido! ");
                } else {
                    System.out.println("Inválido! ");
                }
                System.out.println("Deseja realizar outra entrada? \n Tecla 1: Sim \n Outra tecla: Sair");
                escrita = read.nextLine();
                ficar = escrita.equals("1");
            } catch (Exception e) {
                System.out.println(e);
            }
        }while (ficar);
    }
    static boolean ehValido(String entrada) throws Exception {
        Stack<Character> pilhaAbertura = new Stack();
        for (int i = 0; i < entrada.length(); i++) {
            if (!ehDoAlfabeto(entrada.charAt(i))) {
                throw new Exception("Símbolo(s) não correspondente(s) ao do alfabeto! ");
            }
            if (ehAberto(entrada.charAt(i))) {
                pilhaAbertura.push(entrada.charAt(i));
            } else {
                if (pilhaAbertura.isEmpty()) {
                    return false;
                }
                if (errouPar(entrada.charAt(i), pilhaAbertura.peek())) {
                    return false;
                }
                pilhaAbertura.pop();
            }
        }
        return pilhaAbertura.isEmpty();
    }
    static boolean errouPar(char simbol1, char simbol2) {
        return simbol1 == '}' && simbol2 != '{' || simbol1 == ']' && simbol2 != '['
            || simbol1 == ')' && simbol2 != '(' || simbol1 == '>' && simbol2 != '<';
    }
    static boolean ehAberto(char simbolo) {
        return simbolo == '{' || simbolo == '[' || simbolo == '(' || simbolo == '<';
    }
    static boolean ehDoAlfabeto(char simbolo) {
        return simbolo == '{' || simbolo == '[' || simbolo == '(' || simbolo == '<'
            || simbolo == '}' || simbolo == ']' || simbolo == ')' || simbolo == '>';
    }
}


