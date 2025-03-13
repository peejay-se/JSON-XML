package se.peejay.lab;

// ===================================================================
//  Konverterar JSON till XML 
// ===================================================================

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class Json2XML {

	public static void main(String[] args) throws IOException {

		// ====[ Kontrollera argumenten ]====
		if (args.length != 2) {
			System.out.println("Fel antal argument....");
			System.out.println("Json2XML [infil] [utfil]");
			System.exit(1);
		}

		System.out.println("Filnamn (in)=" + args[0]);
		System.out.println("Filnamn (ut)=" + args[1]);
		String content = "";

		try {
			content = new String(Files.readAllBytes(Paths.get(args[0])));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ObjectMapper jsonMapper = new ObjectMapper();
		JsonNode node = null;
		node = jsonMapper.readValue(content, JsonNode.class);

		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_1_1, true);

		StringWriter contentString = new StringWriter();
		xmlMapper.writeValue(contentString, node);

		System.out.println("Skriver filen " + args[1]);

		// ====[ Skriv ut filen till disk ]====
		BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
		writer.write(contentString.toString());
		writer.close();

	}
}
