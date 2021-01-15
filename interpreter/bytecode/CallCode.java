package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 *The CallCode class saves the return location for the program counter
 * and transfers control to the indicated function.
 */

public class CallCode extends ByteCode {

    private int offset;
    private String ref;

    @Override
    public void init(ArrayList<String> arg){
        ref = arg.get(0);
    }

    @Override
    public void execute(VirtualMachine vm){
          vm.pushReturnAddrs();
          vm.setPC(offset - 1);
    }

    @Override
    public String toString(){
            return("CALL " + ref);
    }

    public String getRef(){
        return ref;
    }
    
    public void setOffset(int index){
        offset = index;
    }

}
