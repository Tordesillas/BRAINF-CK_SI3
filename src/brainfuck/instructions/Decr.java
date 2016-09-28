package brainfuck.instructions;

import brainfuck.Instruction;
import brainfuck.virtualmachine.Machine;
import brainfuck.virtualmachine.OverflowException;

public class Decr extends Instruction {
	public Decr() {
		super("DECR", '-', new int[] {0x4B, 0x00, 0x82});
	}

	@Override
	public void action(Machine machine) throws OverflowException {
		byte value = machine.readMemory();
		if (value <= Byte.MIN_VALUE) throw new OverflowException();
		value--;
		machine.writeMemory(value);
	}
}
