package brainfuck;

import brainfuck.virtualmachine.Machine;
import brainfuck.virtualmachine.OverflowException;

public abstract class Instruction {
	private String name;
	private char symbol;
	private int[] color;

	public Instruction(String name, char symbol, int[] color) {
		this.name = name;
		this.symbol = symbol;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public char getSymbol() {
		return symbol;
	}

	public int[] getColor() {
		return color;
	}

	abstract public void action(Machine machine) throws OverflowException;
}
