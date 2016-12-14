package fr.unice.polytech.si3.miaou.brainfuck.instructions;

import java.util.function.Consumer;

import fr.unice.polytech.si3.miaou.brainfuck.virtualmachine.Machine;

/**
 * Superclass for all the instructions supported by the Brainfuck language.
 * All instructions have a name (keyword), a symbol and a color which must be unique.
 * An instruction can perform a single Consumer-like operation on the Machine.
 *
 * @author Pierre-Emmanuel Novac
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html">Consumer</a>
 * @see Machine
 */
public abstract class Instruction implements Consumer<Machine> {
	/**
	 * Instruction's name, ie. keyword for the long syntax.
	 */
	private String name;

	/**
	 * Instruction's symbol, ie. character for the short syntax.
	 */
	private char symbol;

	/**
	 * Instruction's color used in images.
	 * Saved as an int, which the hexadecimal form is the color's one.
	 */
	private int color;

	/**
	 * Instruction's code in C.
	 */
	private String code;

	/**
	 * Constructs an instruction with the given name, symbol and color.
	 *
	 * @param name		Instruction's keyword.
	 * @param symbol	Instruction's symbol.
	 * @param color		Instruction's color as an int.
	 * @param code		Instruction's code.
	 */
	public Instruction(String name, char symbol, int color, String code) {
		this.name = name;
		this.symbol = symbol;
		this.color = color;
		this.code = code;
	}

	/**
	 * @return Instruction's {@link Instruction#name}.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Instruction's {@link Instruction#symbol}.
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * @return Instruction's {@link Instruction#color}.
	 */
	public int getColor() {
		return color;
	}
	
	/**
	 * @return Instruction's {@link Instruction#code}.
	 */
	public String getCode() {
		return code;
	}
}
