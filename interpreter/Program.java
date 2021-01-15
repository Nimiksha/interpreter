package interpreter;

import java.util.ArrayList;
import interpreter.bytecode.*;
import java.util.HashMap;

/**
 * Stores all the ByteCodes read from the source file
 */

public class Program {
    private ArrayList<ByteCode> program;
    //create a HashMap that stores the labels as the keys and the corresponding line number as the key
    private static HashMap<String, Integer> map = new HashMap<>();

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    //returns the size of the arrayList of type ByteCode
    public int getSize() {
        return this.program.size();
    }

    //addCode() which adds bytecode to the arrayList program
    public void addCode(ByteCode byteCode){
        if(byteCode instanceof LabelCode){           //checks if the byteCode is an instance of the LabelCode class
            LabelCode label = (LabelCode)byteCode;   //creates an instance of the LabelCode class
            map.put(label.getRef(), this.getSize()); //from the instance label, put the reference as
                                                     // the key and the size as the value in the HashMap
        }
        this.program.add(byteCode);                  //add bytecode to the program arrayList
    }
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LabelCode <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */

    //the resolveAddrs() resolves all symbolic addresses in the program
    public void resolveAddrs(Program program) {
        int address;
        int size = program.getSize();

        //the bytecodes are stored in the ArrayList.
        //the labels and the addresses are stored in the map.
        for(int i = 0; i < size; i++) {  //iterate through the arrayList of bytecodes and evaluate each element

            //The GotoCode, FalseBranchCode & CallCode need to jump to a certain label inorder to execute the next code

            if(program.getCode(i) instanceof GotoCode){
                GotoCode bytecode = (GotoCode) program.getCode(i);
                address = map.get(bytecode.getRef());
                bytecode.setOffset(address);
            }

            else if(program.getCode(i) instanceof FalseBranchCode){
                FalseBranchCode bytecode = (FalseBranchCode) program.getCode(i);
                address = map.get(bytecode.getRef());
                bytecode.setOffset(address);
            }

            else if(program.getCode(i) instanceof CallCode){
                CallCode bytecode = (CallCode) program.getCode(i);
                address = map.get(bytecode.getRef());
                bytecode.setOffset(address);
            }
        }
    }
}