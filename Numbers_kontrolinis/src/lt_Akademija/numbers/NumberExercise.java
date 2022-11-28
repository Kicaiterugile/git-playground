package lt_Akademija.numbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

public class NumberExercise implements Exercises {

	@Override
	public List<Integer> computeNumbersUpTo(int number) {
		return IntStream.range(1, number).mapToObj(i->i).toList();
	}

	@Override
	public int computeSumOfNumbers(int number) {

		return IntStream.range(1, number + 1).reduce(0, Integer::sum);

	}

	@Override
	public int computeSumOfNumbers(int number, NumberFilter filter) {
		return IntStream.range(1, number + 1).filter(i -> filter.accept(i))
				.reduce(0, Integer::sum);
	}

	@Override
	public List<Integer> consume(Iterator<Integer> it) {
		List<Integer> list = new ArrayList<Integer>();

		while (it.hasNext()) {
			list.add(it.next());

		}

		return list;
	}

	@Override
	public Map<Integer, Integer> countOccurrences(List<Integer> numbers) {
		Map<Integer, Integer> mapNew = new HashMap();
		for (Integer number : numbers) {
			Integer occurences = mapNew.get(number);
			if (occurences == null) {
				mapNew.put(number, 1);
			} else {
				mapNew.put(number, occurences + 1);
			}
		}
		return mapNew;

//		Map<Integer, Integer> countOccurrence = numbers.stream()
//			.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e->1)));
//		return countOccurrence;
	}

	@Override
	public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator generator, NumberFilter filter) {

		return new FilteredIntegerGenerator(generator, filter);
	}

	@Override
	public IntegerGenerator createIntegerGenerator(int from, int to) {
		return new MyIntegerGenerator(from, to);
	}

	@Override
	public Integer findLargest(List<Integer> numbers) {
		Comparator<Integer> comp = Comparator.comparing(Integer::intValue);
		return numbers.stream().max(comp).get();

	}

	@Override
	public Integer findSmallest(List<Integer> numbers) {
		Comparator<Integer> comp = Comparator.comparing(Integer::intValue);
		return numbers.stream().min(comp).get();

	}

	@Override
	public boolean isEqual(Object lhs, Object rhs) {
		return lhs.equals(rhs);
	}

	@Override
	public boolean isSameObject(Object lhs, Object rhs) {

		return lhs == rhs;
	}

}
