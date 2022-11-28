package lt_Akademija.numbers;

import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

public class FilteredIntegerGenerator implements IntegerGenerator {
	private IntegerGenerator generator;
	private NumberFilter filter;

	public FilteredIntegerGenerator(IntegerGenerator generator, NumberFilter filter) {
		this.generator = generator;
		this.filter = filter;
	}

	@Override
	public Integer getNext() {
		while (true) {
			Integer number = generator.getNext();
			if (number == null) {
				return null;
			}
			if (filter.accept(number)) {
				return number;
			}
		}

	}

}
