package brainfuck.instructions;

import brainfuck.Instruction;
import brainfuck.virtualmachine.Machine;
import brainfuck.virtualmachine.OverflowException;

public class Incr extends Instruction {
	public Incr() {
		super("INCR", '+', new int[] {0xFF, 0xFF, 0xFF});
	}

	@Override
	public void action(Machine machine) throws OverflowException {
		byte value = machine.readMemory();
		if (value >= Byte.MAX_VALUE) throw new OverflowException();
		value++;
		machine.writeMemory(value);
	}
}
