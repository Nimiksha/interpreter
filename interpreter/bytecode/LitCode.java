package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 * The LitCode class is responsible for loading
 * integers on the RunTime Stack
 */

public class LitCode extends ByteCode {

    private int offset;
    private String ref = "";

    @Override
    public void init(ArrayList<String> arg){
        offset= Integer.parseInt(arg.get(0));

        if(arg.size() > 1){
            ref = arg.get(1);
        }
        else {
            ref = "";
        }
    }

    @Override
    public void execute(VirtualMachine vm){
        if(ref.equals("")){
            vm.push(offset);
        }
        else {
            vm.push(0);
        }
    }
    @Override
    public String toString(){

        if (ref != "")
            return("LIT " + offset + " " + ref + '\t' + '\t' +"int " + ref);
        else
            return ("LIT " + offset);
    }
}