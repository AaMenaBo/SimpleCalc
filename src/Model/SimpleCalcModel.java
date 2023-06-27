/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author menab
 */
public class SimpleCalcModel {

    private String base;
    private String operation;
    private double result;
    public final double FALSERETURN = -2147483648;
    /**
     * Comprueba que la operacion sea valida
     * @return 
     */
    private boolean isOperationValid() {
        //Creacion de variables
        String sub = "";
        boolean flag = false;
        
        
        

        //Determinar si es numero para cada caracter
        for (int i = 0; i < base.length(); i++) {
            sub = base.substring(i, i + 1);

            switch (sub) {
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9","." -> {
                    continue;
                }
                case "+", "-", "*", "/" -> {
                    if (!flag) {
                        flag = true;
                        continue;
                    } else {
                        return false;
                    }
                }
                default -> {
                    return false;
                }
            }
        }
        return flag;
    }
    /**
     * Determina que operacion se va llervar a cabo
     * @return Retorna si se pudo determinar con exito
     */
    private boolean determineOperation(){
        char op;
        if (!this.isOperationValid()) {
            return false;
        }
        
        for (int i = 0; i < base.length(); i++) {
            op = base.charAt(i);
            switch (op) {
                case '+' -> {
                    this.operation = "+";
                    return true;
                }
                case '*' -> {
                    operation = "*";
                    return true;
                }
                case '-' -> {
                    operation = "-";
                    return true;
                }
                case '/' -> {
                    operation = "/";
                    return true;
                }
                default -> {
                   continue;
                }
            }
            
        }
        return false;
    }
    
    /**
     * Ejecuta la operacion y devuelve el 
     * @return
     * @throws ArithmeticException 
     */
    public double executeOperation()throws ArithmeticException {
        if (!this.determineOperation()) {
            return FALSERETURN;
        }
        double num1 = 0;
        double num2 = 0;
        int flag = 0;
        
        String numTXT1 = "";
        String numTXT2 = "";
        
        String sub = "";
        for (int i = 0; i < base.length(); i++) {
            sub = base.substring(i,i+1);
            if (!sub.equals(operation)) {
                numTXT1 = numTXT1.concat(sub);
            }else{
                num1 = Double.parseDouble(numTXT1);
                flag = i+1;
                break;
            }
        }
        numTXT2 = base.substring(flag);
        num2 = Double.parseDouble(numTXT2);
        
        return calculate(num1,num2);
    }
    /**
     * Calcula y devuleve el resultado de una operacion
     * @param num1
     * @param num2
     * @return 
     */
    private double calculate(double num1, double num2){
        switch (operation) {
            case "+" -> {
                return num1 + num2;
            }
            case "-" -> {
                return num1 - num2;
            }
            case "*" -> {
                return num1 * num2;
            }
            case "/" -> {
                return num1 / num2;
            }
        }
        return 0;
    }

    //Metodos de Acceso y constructor
    public String getBase() {
        return base;
    }

    public void setBase(String Base) {
            this.base = Base;
            if (base.contains(",")) {
            base = base.replace(",",".");
        }
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public SimpleCalcModel() {
        base = "";
        operation = "";
        result = 0;
    }
}
