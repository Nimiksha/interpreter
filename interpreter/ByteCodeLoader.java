package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import interpreter.bytecode.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Loads ByteCodes from the source code file into an ArrayList stored inside a Program object
 */

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */

    public Program loadCodes()  {

        program = new Program();                                     //Program object
        String line;
        String value;
        ArrayList<String> arrayList = new ArrayList<>();             //create arrayList to store the arguments

        try {
            line = byteSource.readLine();                            //reading the current line

            while (line != null) {                                   //check that if the current line is not empty
                StringTokenizer tok = new StringTokenizer(line);     //process the line as token, if it is not empty
                arrayList.clear();                        //clear the arrayList when the new labels are initialized

                //from pdf
                value = CodeTable.getClassName(tok.nextToken());
                Class c = Class.forName("interpreter.bytecode." + value);
                ByteCode bc = (ByteCode) c.newInstance();            //creating the bytecode object

                while (tok.hasMoreTokens()) {
                    arrayList.add(tok.nextToken());       //if there are more tokens, add them to the arrayList
                }
                bc.init(arrayList);                       //activating/initializing the byte codes
                program.addCode(bc);                      //the byte codes are then added to the program object
                line = byteSource.readLine();             //next line
            }
        }
        catch (Exception e) {                             //try to catch any potential exceptions
            System.out.println("File Error " + e);
        }

        //Resolve Address
        try{
        program.resolveAddrs(program);
        }
        catch(Exception e){                              //try to catch any potential exceptions
            System.out.println("Error: Resolve Address");
        }
        return program;                                  //return the program object
    }
}