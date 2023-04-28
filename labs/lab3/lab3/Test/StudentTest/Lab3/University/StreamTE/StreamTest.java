package Lab3.University.StreamTE;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

public class StreamTest {
	@Test
	@DisplayName("Testing method readJson")
	public void readJson() {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\2k2s\\TPvI\\labs\\lab3\\lab3\\jsons\\Stream.json"));
				Stream stream = gson.fromJson(bufferedReader,Stream.class);
				assertNull(stream);
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			}
	}
}