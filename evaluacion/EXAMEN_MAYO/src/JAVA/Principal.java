package JAVA;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

public class Principal {

    // PASO 1: CONEXION AL SERVIDOR MONGODB (HOST - PUERTO)
    static MongoClient cliente = new MongoClient("localhost", 27017);
    // PASO 2: CONEXION A LA BASE DE DATOS
    static MongoDatabase conexion = cliente.getDatabase("personasDB");
    // PASO 3: CONEXION CON LA COLECCION 
    static MongoCollection<Document> coleccion = conexion.getCollection("persona");

    public static void main(String[] args) {
        //mostrarHobbiesDistintos();
        /*
        System.out.println("OK");
        List<Persona> personas_al = obtenerListaPersonasFromMongodb();
        for(Persona persona: personas_al) {
            System.out.println(persona);
        }
         */
 /*
        Direccion direccion = new Direccion("Call Esperanza",123,"Trujill");
        String[] hobbies = {"Ludo","Ajedrez", "Tenis"};
        Persona persona = new Persona("P61","Gerson",23,1.72,true,"H",direccion,hobbies);
        insertarUnDocumento(persona);
         */
 /*
        Persona persona = buscarPersonaPorId("P10");
        if(persona != null) {
           System.out.println(persona);
        }else {
           System.out.println("PERSONA NO EXISTE");
        }
         */
 
        /*
        String idPersonaEliminar = "P1";
        int numero = eliminarPersonaPorId(idPersonaEliminar);
        if (numero != 0) {
            System.out.println("OK: ELIMINO CORRECTAMENTE");
        } else {
            System.out.println("ERROR: NO EXISTE PERSONA CON ESE ID");
        }
        */
        Persona persona = buscarPersonaPorId("P4");
        System.out.println(persona);
        persona.setNombre("LuisZZZ");
        persona.setEdad(288);
        actualizarPersonaPorId(persona);

    }

    public static List<Persona> obtenerListaPersonasFromMongodb() {
        FindIterable<Document> coleccion_personas = coleccion.find();
        List<Persona> personas_al = new ArrayList<>();

        for (Document documento : coleccion_personas) {
            String idPersona = documento.getString("idPersona");
            String nombre = documento.getString("nombre");
            int edad = documento.getInteger("edad");
            double estatura = documento.getDouble("estatura");
            boolean casado = documento.getBoolean("casado");
            String sexo = documento.getString("sexo");
            Document direccionDoc = (Document) documento.get("direccion");
            String calle = direccionDoc.getString("calle");
            int numero = direccionDoc.getInteger("numero");
            String ciudad = direccionDoc.getString("ciudad");
            Direccion direccion = new Direccion(calle, numero, ciudad);

            List<String> hobbies_al = (List<String>) documento.get("hobbies");

            String[] hobbies = hobbies_al.toArray(new String[0]);
            Persona persona = new Persona(idPersona,
                    nombre,
                    edad,
                    estatura,
                    casado,
                    sexo,
                    direccion,
                    hobbies);
            personas_al.add(persona);
        }

        return personas_al;
    }

    public static List<Persona> obtenerListaPersonasMongodbPorHobby(String hobby) {
        List<Persona> personasporhobby_al = new ArrayList<>();
        //db.persona.find({"hobbies": hobby });
        Document filtro = new Document("hobbies", hobby);
        FindIterable<Document> documentos = coleccion.find(filtro);
        for (Document documento : documentos) {
            String idPersona = documento.getString("idPersona");
            String nombre = documento.getString("nombre");
            int edad = documento.getInteger("edad");
            double estatura = documento.getDouble("estatura");
            boolean casado = documento.getBoolean("casado");
            String sexo = documento.getString("sexo");
            Document direccionDoc = (Document) documento.get("direccion");
            String calle = direccionDoc.getString("calle");
            int numero = direccionDoc.getInteger("numero");
            String ciudad = direccionDoc.getString("ciudad");
            Direccion direccion = new Direccion(calle, numero, ciudad);

            List<String> hobbies_al = (List<String>) documento.get("hobbies");

            String[] hobbies = hobbies_al.toArray(new String[0]);
            Persona persona = new Persona(idPersona,
                    nombre,
                    edad,
                    estatura,
                    casado,
                    sexo,
                    direccion,
                    hobbies);
            personasporhobby_al.add(persona);
        }
        return personasporhobby_al;
    }
    
    public static List<Persona> obtenerListaPersonasMongodbPorNombre(String nombres) {
        List<Persona> personaspornombre_al = new ArrayList<>();
        //db.persona.find({"direccion.ciudad": "Zamora"});
        Document filtro = new Document("nombre", nombres);
        FindIterable<Document> documentos = coleccion.find(filtro);
        for (Document documento : documentos) {
            String idPersona = documento.getString("idPersona");
            String nombre = documento.getString("nombre");
            int edad = documento.getInteger("edad");
            double estatura = documento.getDouble("estatura");
            boolean casado = documento.getBoolean("casado");
            String sexo = documento.getString("sexo");
            Document direccionDoc = (Document) documento.get("direccion");
            String calle = direccionDoc.getString("calle");
            int numero = direccionDoc.getInteger("numero");
            String ciudad = direccionDoc.getString("ciudad");
            Direccion direccion = new Direccion(calle, numero, ciudad);

            List<String> hobbies_al = (List<String>) documento.get("hobbies");

            String[] hobbies = hobbies_al.toArray(new String[0]);
            Persona persona = new Persona(idPersona,
                    nombre,
                    edad,
                    estatura,
                    casado,
                    sexo,
                    direccion,
                    hobbies);
            personaspornombre_al.add(persona);
        }

        return personaspornombre_al;
    }
    
    

    public static List<Persona> obtenerListaPersonasMongodbPorCiudad(String ciudad1) {
        List<Persona> personasporciudad_al = new ArrayList<>();
        //db.persona.find({"direccion.ciudad": "Zamora"});
        Document filtro = new Document("direccion.ciudad", ciudad1);
        FindIterable<Document> documentos = coleccion.find(filtro);
        for (Document documento : documentos) {
            String idPersona = documento.getString("idPersona");
            String nombre = documento.getString("nombre");
            int edad = documento.getInteger("edad");
            double estatura = documento.getDouble("estatura");
            boolean casado = documento.getBoolean("casado");
            String sexo = documento.getString("sexo");
            Document direccionDoc = (Document) documento.get("direccion");
            String calle = direccionDoc.getString("calle");
            int numero = direccionDoc.getInteger("numero");
            String ciudad = direccionDoc.getString("ciudad");
            Direccion direccion = new Direccion(calle, numero, ciudad);

            List<String> hobbies_al = (List<String>) documento.get("hobbies");

            String[] hobbies = hobbies_al.toArray(new String[0]);
            Persona persona = new Persona(idPersona,
                    nombre,
                    edad,
                    estatura,
                    casado,
                    sexo,
                    direccion,
                    hobbies);
            personasporciudad_al.add(persona);
        }

        return personasporciudad_al;
    }

    public static void mostrarHobbiesDistintos() {
        MongoIterable<String> hobbiesDistintos = coleccion.distinct("hobbies", String.class);
        for (String s : hobbiesDistintos) {
            System.out.println(s);
        }
    }
    
    public static void mostrarNombresDistintos() {
        MongoIterable<String> nombreDistintos = coleccion.distinct("nombre", String.class);
        for (String s : nombreDistintos) {
            System.out.println(s);
        }
    }

    public static List<String> obtenerTodosHobbiesDistintos() {
        MongoIterable<String> hobbiesDistintos = coleccion.distinct("hobbies", String.class);
        List<String> listaHobbiesDistintos = new ArrayList<>();
        for (String s : hobbiesDistintos) {
            listaHobbiesDistintos.add(s);
        }
        return listaHobbiesDistintos;
    }
    
    public static List<String> obtenerTodosNombresDistintos() {
        MongoIterable<String> nombreDistintos = coleccion.distinct("nombre", String.class);
        List<String> listaNombreDistintos = new ArrayList<>();
        for (String s : nombreDistintos) {
            listaNombreDistintos.add(s);
        }
        return listaNombreDistintos;
    }

    public static void insertarUnDocumento(Persona persona) {
        Document direccionDoc = new Document()
                .append("calle", persona.getDireccion().getCalle())
                .append("numero", persona.getDireccion().getNumero())
                .append("ciudad", persona.getDireccion().getCiudad());

        List<String> hobbiesLista = Arrays.asList(persona.getHobbies());

        Document personaDoc = new Document()
                .append("idPersona", persona.getIdPersona())
                .append("nombre", persona.getNombre())
                .append("edad", persona.getEdad())
                .append("estatura", persona.getEstatura())
                .append("casado", persona.getCasado())
                .append("sexo", persona.getSexo())
                .append("direccion", direccionDoc)
                .append("hobbies", hobbiesLista);

        coleccion.insertOne(personaDoc);
        System.out.println("PERSONA INSERTADA CORRECTAMENTE");
    }

    public static Persona buscarPersonaPorId(String idPersonaBuscar) {
        //db.persona.find({"idPersona": "P2"});
        Persona persona = null;
        Document filtro = new Document("idPersona", idPersonaBuscar);
        FindIterable<Document> documentos = coleccion.find(filtro);
        for (Document documento : documentos) {
            String idPersona = documento.getString("idPersona");
            String nombre = documento.getString("nombre");
            int edad = documento.getInteger("edad");
            double estatura = documento.getDouble("estatura");
            boolean casado = documento.getBoolean("casado");
            String sexo = documento.getString("sexo");
            Document direccionDoc = (Document) documento.get("direccion");
            String calle = direccionDoc.getString("calle");
            int numero = direccionDoc.getInteger("numero");
            String ciudad = direccionDoc.getString("ciudad");
            Direccion direccion = new Direccion(calle, numero, ciudad);

            List<String> hobbies_al = (List<String>) documento.get("hobbies");

            String[] hobbies = hobbies_al.toArray(new String[0]);
            persona = new Persona(idPersona,
                    nombre,
                    edad,
                    estatura,
                    casado,
                    sexo,
                    direccion,
                    hobbies);
        }
        return persona;
    }

    public static int eliminarPersonaPorId(String idPersaonEliminar) {

        //db.persona.deleteOne({"idPersona":"P61"});
        Document filtro = new Document("idPersona", idPersaonEliminar);
        DeleteResult objeto = coleccion.deleteOne(filtro);
        if (objeto.getDeletedCount() == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void actualizarPersonaPorId(Persona persona) {
        /*
        Buscar: {"idPersona": "P3"} --> DOCUMENTO
        Filtro: {"$set": {"nombre": "Isabel", "edad": 31}}
        db.persona.updateOne({"idPersona": "P3"},{"$set": {"nombre": "Isabel", "edad": 31}});
         */
        Document direccionDocumento = new Document()
                .append("calle", persona.getDireccion().getCalle())
                .append("numero", persona.getDireccion().getNumero())
                .append("ciudad", persona.getDireccion().getCiudad());

        //List<String> hobbiesLista = Arrays.asList(persona.getHobbies());

        Document personaDocumento = new Document()
                .append("idPersona", persona.getIdPersona())
                .append("nombre", persona.getNombre())
                .append("edad", persona.getEdad())
                .append("estatura", persona.getEstatura())
                .append("casado", persona.getCasado())
                .append("sexo", persona.getSexo())
                .append("direccion", direccionDocumento);
                //.append("hobbies", hobbiesLista);
        
        Document documentoActualizar = new Document("$set", personaDocumento);
        
        //{"idPersona": "P3"}
        Document documentoBuscar = new Document("idPersona", persona.getIdPersona());
        
        coleccion.updateOne(documentoBuscar,documentoActualizar);
    }

}
