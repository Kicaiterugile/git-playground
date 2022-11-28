package lt_Akademija.numbers;

import lt.itakademija.exam.IntegerGenerator;

public class MyIntegerGenerator implements IntegerGenerator {
	private int value;
	private int to;

	public MyIntegerGenerator(int from, int to) {
		value=from;
		this.to=to;
	}

	@Override
	public Integer getNext() {
		if (value>to) {
			return null;
		}
		return value++;
		 
	}

}
