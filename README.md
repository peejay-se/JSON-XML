# JSON-XML och vice versa 
Konvertering mellan JSON och XML och vice versa

```
mvn clean package

java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.XMLtoJSON
XMLtoJSON [infil] [utfil]

java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.JSONToXML
JSONToXML [infil] [utfil]

$ java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.JSONSchemaValidation
Fel antal argument....
JSONSchemaValidation [infil] [schemafil]

java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.Json2XML     
Fel antal argument....
Json2XML [infil] [utfil]

```

___

```
$ java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.Json2XML personOK.json personOK.xml
Filnamn(in)=personOK.json
Filnamn(ut)=personOK.xml
Skriver filen personOK.xml
```

_IN:_ personOK.json
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "age": 21
}
```

_Ut:_ personOK.xml
```xml
<?xml version='1.1' encoding='UTF-8'?>
<ObjectNode>
  <firstName>John</firstName>
  <lastName>Doe</lastName>
  <age>21</age>
</ObjectNode>
```

___

```
$ java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.XMLtoJSON personOK.xml Back2Json.json
Filnamn(in)=personOK.xml
Filnamn(ut)=Back2Json.json
```

_In:_ personOK.xml
```xml
<?xml version='1.1' encoding='UTF-8'?>
<ObjectNode>
  <firstName>John</firstName>
  <lastName>Doe</lastName>
  <age>21</age>
</ObjectNode>
```

_Ut:_ Back2Json.json
```json
{"ObjectNode":{"firstName":"John","lastName":"Doe","age":21}}
```

___

Validering som är ok

```
$ java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.JSONSchemaValidation personOK.json person.schema.json
Filnamn(in)=personOK.json
Filnamn(ut)=person.schema.json
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
Finns inga felmeddelanden!
```
___

Validering som går fel
```
$ java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.JSONSchemaValidation personFAIL.json person.schema.json
Filnamn (in)=personFAIL.json
Filnamn (ut)=person.schema.json
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
Felmeddelande:
[$.age: string found, integer expected]
```

_IN:_ personFAIL.json  
JSON-koden som genererar fel är "age":"21" skall vara "age":21 (skall vara en integer istället för en sträng)
```json
{
	"firstName" : "John",
	"lastName" : "Doe",
	"age" : "21"
}
```
___

```
$ java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.Json2XML personOK.json AndraXML.xml
Filnamn (in)=personOK.json
Filnamn (ut)=AndraXML.xml
Skriver filen AndraXML.xml
```

_Ut:_ AndraXML.xml
```xml
<?xml version='1.1' encoding='UTF-8'?>
<ObjectNode>
  <firstName>John</firstName>
  <lastName>Doe</lastName>
  <age>21</age>
</ObjectNode>
```