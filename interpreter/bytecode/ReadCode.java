package interpreter.bytecode;

import java.util.*;
import interpreter.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The ReadCode class reads an integer.
 * It prompts the user to input a value and pushes the value to the stack.
 * It also makes sure that the input is validated.
 */

public class ReadCode extends ByteCode {

    @Override
    public void init(ArrayList<String> arg){}

    @Override
    public void execute(VirtualMachine vm){
        try{
            BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter an Integer value: ");
            String input = file.readLine();
            vm.push(Integer.parseInt(input));
        }
        catch (Exception e){
            System.out.println("Error! : "+ e);
        }
    }

    @Override
    public String toString(){
        return("READ");
    }
}