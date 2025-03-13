/**
 * 
 */
package se.peejay.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

//===================================================================
//   JSON Schema validering
//===================================================================
public class JSONSchemaValidation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// ====[ Kontrollera argumenten ]====
		if (args.length != 2) {
			System.out.println("Fel antal argument....");
			System.out.println("JSONSchemaValidation [infil] [schemafil]");
			System.exit(1);
		}

		System.out.println("Filnamn (in)=" + args[0]);
		System.out.println("Filnamn (ut)=" + args[1]);

		try {

			JsonNode jsonNode;
			ObjectMapper mapper = new ObjectMapper();
			JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
			FileInputStream jsonSchemaFile = new FileInputStream(args[1]);

			JsonSchema jsonSchema = factory.getSchema(jsonSchemaFile);

			FileInputStream jsonFile = new FileInputStream(args[0]);
			jsonNode = mapper.readTree(jsonFile);

			Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

			if (!errors.isEmpty()) {
				System.out.println("Felmeddelande:");
				System.out.println(errors.toString());
			} else {
				System.out.println("Finns inga felmeddelanden!");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
