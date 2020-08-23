package java8.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamCreate {
	@Test
	public void testStreamOf() {
		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);
	}
	
	@Test
	public void testArrayStream() {
		int[] numbers = {2, 3, 5, 7, 11, 13};
		int sum = Arrays.stream(numbers).sum();
		System.out.println(sum);
	}
	
	@Test
	public void testFileStream() {
		long uniqueWords = 0;
		try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(uniqueWords);
	}
	
	@Test
	public void testFuncStream() {
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
		
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
	} 

}
