package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 * The PopCode class removes the top element from the RunTime stack
 */

public class PopCode extends ByteCode {

    private int value;

    @Override
    public void init(ArrayList<String> arg){
        value = Integer.parseInt(arg.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
            for(int i = 0; i < value; i++){
                vm.pop();
            }
        }

    @Override
    public String toString(){
        return("POP " + value) ;
    }
}