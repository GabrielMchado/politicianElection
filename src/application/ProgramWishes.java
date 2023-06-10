package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramWishes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> mapWishes = new LinkedHashMap<String, Integer>();
		
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		try(BufferedReader bf = new BufferedReader(new FileReader(path))){
			
			String line = bf.readLine();
			while(line != null) {
				String[] vector = line.split(",");
				String politician = vector[0];
				Integer wishes = Integer.parseInt(vector[1]);
				
				if(mapWishes.containsKey(politician)) {
					mapWishes.put(politician, mapWishes.get(politician) + wishes);
				}else {
					mapWishes.put(politician, wishes);
				}
				
				line = bf.readLine();
			}
			
			for(String map : mapWishes.keySet()) {
				System.out.println(map + ": " + mapWishes.get(map));
			}
			
		}catch(IOException e) {
			System.out.print("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
