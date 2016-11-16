package brainfuck.instructions;

import brainfuck.virtualmachine.Machine;
import static brainfuck.virtualmachine.Memory.OFFSET;
import brainfuck.Metrics;

/**
 * Print out the contents of the pointed memory cell on output.
 *
 * @author Nassim Bounouas
 * @see Instruction
 * @see Machine
 * @see brainfuck.virtualmachine.Memory
 */
public class Out extends ReadMemory {
	/**
	 * Constructs the Incr instruction.
	 */
	public Out() {
		super("OUT", '.', 0xFFFFFF00);
	}

	/**
	 * Action performed by the instruction: print out the contents of the current memory cell on output.
	 * Overrides <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html">Consumer</a>'s method.
	 *
	 * @param machine	Virtual Machine whose state will be altered
	 */
	@Override
	public void accept(Machine machine) {
		super.accept(machine);
		byte value = machine.readMemory();
		machine.output(value + OFFSET);
	}
}
