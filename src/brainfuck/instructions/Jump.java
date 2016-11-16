package brainfuck.instructions;

import brainfuck.BracketCounter;
import brainfuck.virtualmachine.Machine;
import brainfuck.Metrics;

/**
 * Jump instruction: jump to the instruction right after the associated BACK if the pointed
 * memory cell is equal to zero.
 *
 * @author Pierre-Emmanuel Novac
 * @see Instruction
 * @see Machine
 * @see brainfuck.virtualmachine.Memory
 */
public class Jump extends ConditionalJump {
	/**
	 * Constructs the Jump instruction.
	 */
	public Jump() {
		super("JUMP", '[', 0xFFFF7F00);
	}


	/**
	 * Action performed by the instruction: conditional jump.
	 * Overrides <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html">Consumer</a>'s method.
	 *
	 * @param machine	Virtual Machine whose state will be altered
	 */
	@Override
	public void accept(Machine machine) {
		super.accept(machine);
		if (!machine.isJumping() && machine.readMemory() == Byte.MIN_VALUE) {
			machine.setJumping(true);
		} else {
			machine.setReversed(false);
			machine.setJumping(false);
		}
	}

	/**
	 * Increments the left bracket counter.
	 *
	 * @param bc	BracketCounter whose left bracket count is to be incremented.
	 */
	@Override
	public void incr(BracketCounter bc) {
		bc.incrLeft();
	}
}
