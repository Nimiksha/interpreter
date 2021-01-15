package interpreter.bytecode;

import java.util.*;
import interpreter.*;

/**
 * The ReturnCode class removes the current frame and
 * places the top element of that frame onto the frame that is being returned.
 */

public class ReturnCode extends ByteCode {

        protected String ret_val;

        @Override
        public void init(ArrayList<String> arg){
            if(!arg.isEmpty())
                ret_val = arg.get(0);
        }

        @Override
        public void execute(VirtualMachine vm){
            vm.setPC(vm.popReturnAddrs());
            vm.popFrame();
        }

        @Override
        public String toString(){
            if(ret_val == null)
                return ("RETURN ");
            else
                return("RETURN " + ret_val);
        }
}