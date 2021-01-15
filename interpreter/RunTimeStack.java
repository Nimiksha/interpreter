package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

/**
 * Records and processes the stack of active frames
 */

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    //got the list of methods needed, and the functions they'd perform from the pdf

    //dump() is responsible for dumping the RunTimeStack onto the console
    public void dump(){
        Iterator iterator = framePointer.iterator();
        int cur_value = (int) iterator.next();
        int next_value;

        //Iterate through the FramePointer stack to print the values
        //Prints out values between [current, next]
        for(int i = 0; i < framePointer.size(); i++) {
            if (iterator.hasNext()) {
                next_value = (int) iterator.next();
            } else {
                next_value = runTimeStack.size();
            }
            System.out.print("[");
            for (int j = cur_value; j < next_value; j++) {
                System.out.print(runTimeStack.get(j));
                if (j != next_value - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            cur_value = next_value;
        }
            System.out.println();
        }

    //returns the top of the runtime stack
    public int peek(){
        if(runTimeStack.size() == 0){
            throw new IndexOutOfBoundsException("RunTime Stack is Empty!");
        }
        else{
            return runTimeStack.get(runTimeStack.size() - 1);
        }
    }

    // removes to the top of the runtime stack
    public int pop(){
        int head = 0;
        if (!runTimeStack.isEmpty()) {
            head = runTimeStack.get(runTimeStack.size() - 1);
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        return head;
    }

    //push the value to the top of the stack
    public int push(int val){
        runTimeStack.add(val);
        return val;
    }

    //pop the current frame off the runtime stack
    //Also removes the frame pointer value from the FramePointer Stack
    public void popFrame(){
        int rtrn_value = runTimeStack.get(runTimeStack.size() - 1);

        //
        while(runTimeStack.size() != framePointer.peek()) {
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        framePointer.pop();
        runTimeStack.add(rtrn_value);
    }

    //from the top of the RunTimeStack, create a new frame pointer at the index offset slots down
    public void newFrameAt(int offset){
        int frame_value = runTimeStack.size() - offset;
        if(frame_value >= 0){
            framePointer.push(frame_value);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    //stores the top item of the RunTimeStack into an offset starting from the current frame
    public int store(int offset){
        int store_value;
        if(!runTimeStack.isEmpty()){
            store_value = runTimeStack.get(runTimeStack.size() - 1);
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        else{
            store_value = 0;
        }
        runTimeStack.set(framePointer.peek() + offset, store_value);
        return store_value;
    }

    //takes a value at offset from the current frame marker, from the RunTimeStack
    //and pushes it onto the top of the stack
    public int load(int offset){
        int load_value = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(load_value);
        return load_value;
    }
}