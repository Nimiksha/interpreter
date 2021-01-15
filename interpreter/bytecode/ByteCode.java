package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

/**
 * The ByteCode class is the parent of all byte code classes.
 * It is an abstract class, and it extends the init, execute and print
 * methods to all byte code classes.
 */

public abstract class ByteCode {
    public abstract void init(ArrayList<String> args);
    public abstract void execute(VirtualMachine vm);
    public abstract String toString();
}