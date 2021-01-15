package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 * The LoadCode class pushes the value in the slot which
 * is offset n from the start of the frame onto the top
 * of the stack
 */

public class LoadCode extends ByteCode {

    private int offset;
    private String ref;

    @Override
    public void init(ArrayList<String> arg){

        if (arg.size() != 1) {
            offset = Integer.parseInt(arg.get(0));
            ref = arg.get(arg.size() - 1);
        }
        else
        {
            offset = Integer.parseInt(arg.get(0));
        }
    }

    @Override
    public void execute(VirtualMachine vm){
        vm.load(offset);
    }

    @Override
    public String toString(){
            return("LOAD " + offset + '\t' + ref);
    }
}