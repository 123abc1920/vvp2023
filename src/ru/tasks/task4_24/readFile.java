package ru.tasks.task4_24;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class readFile {
	private static Gson gson = new Gson();
	private static JsonReader reader;
	private static JsonObject jsonObject;

	private static void init() throws FileNotFoundException {
		reader = new JsonReader(new FileReader("InputFiles//Task4_24//input.json"));
		jsonObject = gson.fromJson(reader, JsonObject.class);
	}

	public static void write() throws JsonIOException, IOException {
		JsonWriter writer = new JsonWriter(new FileWriter("InputFiles//Task4_24//input.json"));
		writer.beginObject(); // {
		writer.name("name").value("mkyong"); // "name" : "mkyong"
		writer.name("age").value(29); // "age" : 29

		writer.name("messages"); // "messages" :
		writer.beginArray(); // [
		writer.value("msg 1"); // "msg 1"
		writer.value("msg 2"); // "msg 2"
		writer.value("msg 3"); // "msg 3"
		writer.endArray(); // ]

		writer.endObject(); // }
		writer.close();
	}

	public static int[] readInts() throws JsonIOException, IOException {
		init();

		JsonArray ja = jsonObject.getAsJsonArray("ints");
		int[] ints = new int[ja.size()];
		for (int i = 0; i < ja.size(); i++) {
			ints[i] = ja.get(i).getAsInt();
		}

		return ints;
	}

	public static List<String> readStrings() throws JsonIOException, IOException {
		init();

		List<String> string = new ArrayList<>();
		for (int i = 0; i < jsonObject.getAsJsonArray("string").size(); i++) {
			string.add(jsonObject.getAsJsonArray("string").get(i).getAsString());
		}

		return string;
	}

	public static List<Product> readProducts() throws JsonIOException, IOException {
		init();

		List<Product> product = new ArrayList<>();
		List<JsonElement> l = jsonObject.getAsJsonArray("products").asList();
		for (int i = 0; i < l.size(); i++) {
			String s = l.get(i).getAsJsonObject().keySet().stream().findFirst().get();
			product.add(new Product(s, l.get(i).getAsJsonObject().get(s).getAsInt()));
		}

		return product;
	}
}
