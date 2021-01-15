package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 * The LabelCode class holds the position of any branches to the label
 */

public class LabelCode extends ByteCode {

    private String ref;

    @Override
    public void init(ArrayList<String> arg){
        ref = arg.get(0);
    }

    @Override
    public void execute(VirtualMachine vm){}

    @Override
    public String toString(){
        return("LABEL "+ ref) ;
    }

    public String getRef(){
        return ref;
    }
}