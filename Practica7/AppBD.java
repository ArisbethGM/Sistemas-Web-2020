package mx.uv.basededatos;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;

public class AppBD {
    private static Gson gson = new Gson();
    private static Map<String, Usuarios> usuarios = new HashMap<>();

    
    public static void main( String[] args )
    {
        before((req, res) -> res.type("application/json"));
        get("/usuarios", (req, res) -> gson.toJson(DAO.dameUsuarios()));

        post("/usuarios", (req, res) -> {

                String query = req.body();
                System.out.println( "Peticion : "+ query );
                Usuarios u = gson.fromJson( query, Usuarios.class);
                String id  = UUID.randomUUID().toString();
                u.setId(id);
                usuarios.put(id, u);
                return "Se creo un usuario con id: "+ id;
        });

        
    }

    
}
