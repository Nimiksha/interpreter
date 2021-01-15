package interpreter;

import java.util.Stack;
import interpreter.bytecode.*;

/**
 * Executes the given program
 */

public class VirtualMachine {

    private RunTimeStack   runStack;
    private Stack<Integer> returnAddrs;
    private Program        program;
    private int            pc;
    private boolean        isRunning;
    private boolean        dump;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    // from the pdf
    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<> ();
        isRunning = true;
        dump = false;

        while(isRunning){
            ByteCode byte_code = program.getCode(pc);
            byte_code.execute(this);

            //to print out the contents that are dumped from the RunTimeStack onto the console
            if(dump) {
                System.out.println(byte_code.toString());
                this.dump(byte_code);
            }
            pc++;
        }
    }

    //Halts the execution
    public void halt(){
        isRunning=false;
    }

    //methods that work work with the RunTimeStack to return the desired result
    public void push(int val){
        runStack.push(val);
    }

    public int peek(){
        return this.runStack.peek();
    }

    public int pop(){
        return runStack.pop();
    }

    public void load(int offset){
        runStack.load(offset);
    }

    public void store(int offset){
        runStack.store(offset);
    }

    public int pushReturnAddrs(){
        return returnAddrs.push(pc);
    }

    public int popReturnAddrs(){
        return returnAddrs.pop();
    }

    public void popFrame(){
        runStack.popFrame();
    }

    public void newFrameAt(int offset){
        runStack.newFrameAt(offset);
    }

    public void setPC(int index){
        pc = index;
    }

    public void setDump(boolean bool) {
        this.dump = bool;
    }

    public void dump(ByteCode bytecode) {
        if (dump && !(bytecode instanceof DumpCode)) {
            runStack.dump();
        }
    }
}