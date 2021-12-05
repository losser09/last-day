import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
		if (args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = dup_Rfile();
				String str = bufferedReader.readLine();
				String line[] = str.split(",");
				for (String ch : line) {
					System.out.println(ch);
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = dup_Rfile();
				String str = bufferedReader.readLine();
				System.out.println(str);
				String line[] = str.split(",");
				Random random = new Random();
				int y = random.nextInt();
				System.out.println(line[y]);
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("+")) {
			System.out.println("Loading data ...");
			try {
				BufferedWriter bufferedWriter = dup_Wfile();
				String substr = args[0].substring(1);
				Date d = new Date();
				String df = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(df);
				String fd = dateFormat.format(d);
				bufferedWriter.write(", " + substr + "\nList last updated on " + fd);
				bufferedWriter.close();
			} catch (Exception e) {
			}

			System.out.println("Data Loaded.");
		} else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = dup_Rfile();
				String str = bufferedReader.readLine();
				String line[] = str.split(",");
				boolean done = false;
				String substr = args[0].substring(1);
				for (int idx = 0; idx < line.length && !done; idx++) {
					if (line[idx].equals(substr)) {
						System.out.println("We found it!");
						done = true;
					}
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = dup_Rfile();
				String D = bufferedReader.readLine();
				char charcter[] = D.toCharArray();
				boolean in_word = false;
				int count = 0;
				for (char ch : charcter) {
					if (ch == ' ') {
						if (!in_word) {
							count++;
							in_word = true;
						} else {
							in_word = false;
						}
					}
				}
				System.out.println(count + " word(s) found " + charcter.length);
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else alert();
	}
         static void alert(){
        	System.out.println("some error occur");}

        	static BufferedReader dup_Rfile()
			{
				BufferedReader tmp = null;

				try{
					tmp =  new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
				}
				catch (Exception e)
				{
					alert();
				}
				return tmp;
			}

			static BufferedWriter dup_Wfile(){
    		BufferedWriter tmp = null;

    		try{
    			tmp = new BufferedWriter(
						new FileWriter("students.txt", true));
			}
    		catch(Exception e){
    			alert();
			}
    		return tmp;
			}


}