package abo.pro;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

//import java.util.ArrayList;
import javax.swing.JFrame;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private static ArrayList<City> lols = new ArrayList<City>();



	public static void main(String[] args) throws IOException, ParseException {

		new Main();
		FileReader fr = new FileReader("C:\\Users\\Desktop\\BruteForce\\src\\main\\java\\abo\\pro\\waypoints.json");
		JSONParser jp = new JSONParser();
		JSONObject jo = (JSONObject) jp.parse(fr);
		JSONArray ja = (JSONArray) jo.get("waypoints");
		ArrayList<City> List = new ArrayList<City>();


		for(int i = 0; i < ja.size(); i++) {
			JSONObject jsonElement = (JSONObject) ja.get(i);
			String name = jsonElement.get("city").toString();
			Float x = Float.valueOf(jsonElement.get("latitude").toString());
			Float y = Float.valueOf(jsonElement.get("longitude").toString());

			City town = new City(name, x, y);
			List.add(town);

		}



		BruteForce brute = new BruteForce();


		System.out.println("The shortest path is: " + brute.Solution(List));
		System.out.println("The distance of the shortest path is  :" + brute.FinderDi(brute.PermSolver(List, 0)));
		lols = brute.Solution(List).get(0);
}

	
}