# JSON-XML
Konvertering mellan JSON och XML och vice versa



```
mvn clean package

java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.XMLtoJSON
XMLtoJSON [infil] [utfil]

java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.JSONToXML
JSONToXML [infil] [utfil]

java -cp JSONXML-0.0.1-SNAPSHOT-jar-with-dependencies.jar se.peejay.lab.JSONSchemaValidation
Fel antal argument....

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

IN: personOK.json
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "age": 21
}
```

Ut: personOK.xml
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
Infil = personOK.xml
Util = Back2Json.json
```

In: personOK.xml
```xml
<?xml version='1.1' encoding='UTF-8'?>
<ObjectNode>
  <firstName>John</firstName>
  <lastName>Doe</lastName>
  <age>21</age>
</ObjectNode>
```

UT: Back2Json.json
```json
{"ObjectNode":{"firstName":"John","lastName":"Doe","age":21}}
```

___

