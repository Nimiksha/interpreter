package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 * The DumpCode class sets the state of dumping in the virtual machine.
 * When dump is on, the state of the runtime stack is dumped to the console.
 */

public class DumpCode extends ByteCode {

    private String ref;

    @Override
    public void init(ArrayList<String> arg) {
        ref = arg.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (ref.equals("ON")) {
            vm.setDump(true);
        }
        else if (ref.equals("OFF")) {
            vm.setDump(false);
        }
    }

    @Override
    public String toString() {
        return ("Dump " + ref);
    }
}
