package interpreter.bytecode;
import java.util.ArrayList;
import interpreter.VirtualMachine;

/**
 * The GotoCode class sets the program counter to a new location
 */

public class GotoCode extends ByteCode {

    private int offset;
    private String ref;

    @Override
    public void init(ArrayList<String> arg){
        ref =  arg.get(0);
    }

    @Override
    public void execute(VirtualMachine vm){
        vm.setPC(offset - 1);
    }

    @Override
    public String toString(){
        return("GOTO " + ref) ;
    }

    public String getRef(){
        return ref;
    }

    public void setOffset(int index){
        this.offset = index;
    }
}