package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 * The WriteCode class writes the contents from
 * the top of the stack onto the standard output.
 */

public class WriteCode extends ByteCode {

    @Override
    public void init(ArrayList<String> arg){}

    @Override
    public void execute(VirtualMachine vm){
        System.out.println(vm.peek());
    }

    @Override
    public String toString(){
        return("WRITE");
    }
}
