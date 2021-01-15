package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

/**
 * The BopCode class pops  top 2 levels of the
 * runtime stack and performs the indicated
 * binary/logical operation (+, -, /, *, =, ==, !=,
 * <=, >, >=, <, |, &) on them.
 * The result of these operations is placed on the
 * stack, in place of the operands.
 */


public class BopCode extends ByteCode{

    private String operator;

    @Override
    public void init(ArrayList<String> arg){
        operator = arg.get(0);
    }

    @Override
    public void execute(VirtualMachine vm){
        //Popping 2 operators on which the operation will be performed from the RunTime Stack
        int Operand_two = vm.pop();
        int Operand_one = vm.pop();

        int answer = 0;

        //Switch case to evaluate the operator and perform the necessary actions
        //The answer after the operation is performed is pushed onto the RunTime Stack
        switch (operator){
            case "+":
                answer = Operand_one + Operand_two;
                break;
            case "-":
                answer = Operand_one - Operand_two;
                break;
            case "*":
                answer = Operand_one * Operand_two;
                break;
            case "/":
                answer = Operand_one / Operand_two;
                break;
            case "==":
                if(Operand_one == Operand_two){
                    answer = 1;
                }
                else {
                    answer = 0;
                }
                break;
            case "!=":
                if(Operand_one != Operand_two){
                    answer = 1;
                }
                else{
                    answer = 0;
                }
                break;
            case "<=":
                if(Operand_one <= Operand_two){
                    answer = 1;
                }
                else{
                    answer = 0;
                }
                break;
            case ">":
                if(Operand_one > Operand_two){
                    answer = 1;
                }
                else {
                    answer = 0;
                }
                break;
            case ">=":
                if(Operand_one >= Operand_two){
                    answer = 1;
                }
                else {
                    answer = 0;
                }
                break;
            case "<":
                if(Operand_one < Operand_two){
                    answer = 1;
                }
                else {
                    answer = 0;
                }
                break;
            case "|":
                if(Operand_one == 0 && Operand_two == 0){
                    answer = 0;
                }
                else {
                    answer = 1;
                }
                break;
            case "&":
                if(Operand_one == 1 && Operand_two == 1){
                    answer = 1;
                }
                else {
                    answer = 0;
                }
                break;
            default:
                break;
        }
        vm.push(answer);
    }

    @Override
    public String toString(){
        return("BOP " + operator) ;
    }
}
