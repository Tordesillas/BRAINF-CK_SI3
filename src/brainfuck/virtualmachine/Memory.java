package brainfuck.virtualmachine;

public class Memory {
	private static final int DEFAULT_SIZE = 30000;
	private static final int OFFSET = 128;
	private int size;
	private byte[] memory;

	public Memory(int size) {
		this.size = size;
		memory = new byte[size];
		for (int i = 0; i < size; i++) {
			memory[i] = Byte.MIN_VALUE;
		}
	}

	public Memory() {
		this(DEFAULT_SIZE);
	}

	private void checkBounds(int i) throws OutOfMemoryException {
		if (i < 0 || i >= size) throw new OutOfMemoryException(i, size);
	}

	public byte get(int i) throws OutOfMemoryException {
		checkBounds(i);
		return memory[i];
	}

	public void set(int i, byte value) throws OutOfMemoryException {
		checkBounds(i);
		memory[i] = value;
	}

	public String toString() {
		StringBuilder tmp = new StringBuilder(size+size/16);
		for (int i = 0; i < size; i++) {
			if (memory[i] != Byte.MIN_VALUE) {
				tmp.append(memory[i]+OFFSET);
				if ((i+1)%16 == 0) {
					tmp.append('\n');
				}
			}
		}
		return tmp.toString();
	}
}
