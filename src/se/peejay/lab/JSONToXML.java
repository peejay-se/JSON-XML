package se.peejay.lab;

// ===================================================================
//   Konverterar JSON till XML 
// ===================================================================

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.json.XML;

public class JSONToXML {

	public static void main(String[] args) {

		String content = "";

		// ====[ Kontrollera så att det är rätt antal argument ]====
		if (args.length > 1) {
			System.out.println("Filnamn (in)=" + args[0]);
			System.out.println("Filnamn (ut)=" + args[1]);

			try {
				content = new String(Files.readAllBytes(Paths.get(args[0])));

				JSONObject obj = new JSONObject(content);

				String xml_data = XML.toString(obj);

				FileWriter myWriter = new FileWriter(args[1]);
				myWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				myWriter.write("<root>");
				myWriter.write(xml_data);
				myWriter.write("</root>");
				myWriter.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("JSONToXML [infil] [utfil]");
		}

	}

}
