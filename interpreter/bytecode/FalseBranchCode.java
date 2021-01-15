package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 * The FalseBranchCode class pops the top of the stack;
 * it branches to the next bytecode if the top of the stack is 0
 */

public class FalseBranchCode extends ByteCode {

    private int offset;
    private String ref;

    @Override
    public void init(ArrayList<String> arg){
        ref = arg.get(0);
    }

    @Override
    public void execute(VirtualMachine vm){
        int value = vm.pop();

        if(value == 0){
            vm.setPC(offset - 1);
        }
    }

    @Override
    public String toString(){
        return("FALSEBRANCH " +  ref) ;
    }

    public String getRef(){
        return ref;
    }

    public void setOffset(int index){
        offset = index;
    }

}