package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 * The ArgsCode class instructs the interpreter to
 * set up a new frame n down from the top of the
 * runtime stack. This will include the arguments
 * in the new frame for the function.
 */

public class ArgsCode extends ByteCode{

    private int arg;

    public void init(ArrayList<String> args){
        arg = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm){
        vm.newFrameAt(arg);
    }

    @Override
    public String toString(){
        return ("ARGS " + arg ) ;
    }
}