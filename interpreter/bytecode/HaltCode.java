package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 * The HaltCode class halts the execution of a program.
 * It stops  the VirtualMachine from running when the program is done
 */

public class HaltCode extends ByteCode {

    @Override
    public void init( ArrayList<String> arg ){}

    @Override
    public void execute(VirtualMachine vm){
        vm.halt();
    }

    @Override
    public String toString(){
        return("HALT ") ;
    }
}
