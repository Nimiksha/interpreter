package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 * The StoreCode class, based on the current frame pointer and the offset,
 * stores the value into the offset n from the start of the frame
 */

public class StoreCode extends ByteCode {

    private int offset;
    private String ref;

    @Override
    public void init(ArrayList<String> arg) {
        if (arg.size() != 1) {
            String temp = arg.get(0);
            offset = Integer.parseInt(temp);
            ref = (arg.get(arg.size() - 1));
        }
        else {
            offset = Integer.parseInt(arg.get(0));
        }
    }

    @Override
    public void execute(VirtualMachine vm){
        vm.store(offset);
    }

    @Override
    public String toString(){
        return("STORE "+ offset + '\t' + ref);
    }
}