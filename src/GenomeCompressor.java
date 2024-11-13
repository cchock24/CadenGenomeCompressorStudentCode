/******************************************************************************
 *  Compilation:  javac GenomeCompressor.java
 *  Execution:    java GenomeCompressor - < input.txt   (compress)
 *  Execution:    java GenomeCompressor + < input.txt   (expand)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *  Data files:   genomeTest.txt
 *                virus.txt
 *
 *  Compress or expand a genomic sequence using a 2-bit code.
 ******************************************************************************/

/**
 *  The {@code GenomeCompressor} class provides static methods for compressing
 *  and expanding a genomic sequence using a 2-bit code.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *  @author Zach Blick
 */
public class GenomeCompressor {
    public static final int BITS_PER_CHAR = 2;
    final static int A = 0b00;
    final static int G = 0b01;
    final static int T = 0b10;
    final static int C = 0b11;
    /**
     * Reads a sequence of 8-bit extended ASCII characters over the alphabet
     * { A, C, T, G } from standard input; compresses and writes the results to standard output.
     */
    public static void compress() {
        // TODO: complete the compress() method
        String s = BinaryStdIn.readString();
        int n = s.length();
        // Number chars;
        BinaryStdOut.write(n);
        // Add in Chars
        for (int i = 0; i < n; i++) {
            switch(s.charAt(i)){
                case 'A':
                    BinaryStdOut.write(A, BITS_PER_CHAR);
                    break;
                case 'G':
                    BinaryStdOut.write(G, BITS_PER_CHAR);
                    break;
                case 'T':
                    BinaryStdOut.write(T, BITS_PER_CHAR);
                    break;
                case 'C':
                    BinaryStdOut.write(C, BITS_PER_CHAR);
                    break;
            }
        }
        BinaryStdOut.close();
    }

    /**
     * Reads a binary sequence from standard input; expands and writes the results to standard output.
     */
    public static void expand() {
        // TODO: complete the expand() method
        int buffer = BinaryStdIn.readInt();
        for(int i = 0; i < buffer; i++){
            int x = BinaryStdIn.readInt(BITS_PER_CHAR);
            // Gets binary converts back into char
            switch(x){
                case 0b00:
                    BinaryStdOut.write('A');
                    break;
                case 0b01:
                    BinaryStdOut.write('G');
                    break;
                case 0b10:
                    BinaryStdOut.write('T');
                    break;
                case 0b11:
                    BinaryStdOut.write('C');
                    break;
            }
        }
        BinaryStdOut.close();
    }


    /**
     * Main, when invoked at the command line, calls {@code compress()} if the command-line
     * argument is "-" an {@code expand()} if it is "+".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        if      (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}