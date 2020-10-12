package Logica;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.LinkedList;

public class Api {
    OkHttpClient client = new OkHttpClient();
    public String respuesta = "{\"pokemons\":";
    Tienda tienda;
    LinkedList sufijo = new LinkedList();


    public Api(Tienda tienda) throws IOException {
        sufijo.add("'s tool");
        sufijo.add("'s boots");
        sufijo.add("'s shield");
        sufijo.add("'s heart");
        this.tienda = tienda;
        run("https://pokemon-go1.p.rapidapi.com/pokemon_stats.json");
    }


    public void run(String url){
        Request request = new Request.Builder()
                .url(url)
                .addHeader("x-rapidapi-host", "pokemon-go1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "c4c7332f78msh1f92af948c532fep13c75ejsnac2912aaf133")
                .build();

        try{
            Response response = client.newCall(request).execute();
            this.respuesta += response.body().string() + "}";
            //System.out.println(respuesta);
            fillShop(respuesta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillShop(String json){
        JSONObject test = new JSONObject(json);
        JSONArray pokemons = test.getJSONArray("pokemons");

        for(int i = 0; i < 200; i+=4){
            JSONObject pokemon = pokemons.getJSONObject(i);
            Item aux = creaItem(pokemon);
            this.tienda.inventario.add(aux);
        }
    }

    public Item creaItem(JSONObject pokemon){
        String nombre;
        int precio;
        int vida;
        int pagoTrabajo;
        int armadura;
        int velocidad;
        Item item = new Item();


        int indice = (int) (Math.random()*4);
        String nombreaux = (String) sufijo.get(indice);
        nombre = pokemon.getString("pokemon_name") + nombreaux;

        precio = pokemon.getInt("base_stamina");

        int divisor = (int) (Math.random()*6+3);

        switch (nombreaux) {
            case "'s boots" -> {
                vida = 0;
                pagoTrabajo = 0;
                armadura = (int) (Math.random() * 6 + 2);
                velocidad = (int) (pokemon.getInt("base_attack") / divisor);
                item = new Item(nombre, precio, velocidad, vida, pagoTrabajo, armadura);
            }
            case "'s tool" -> {
                vida = 0;
                pagoTrabajo = (int) (pokemon.getInt("base_attack") / divisor);
                armadura = 0;
                velocidad = 0;
                item = new Item(nombre, precio, velocidad, vida, pagoTrabajo, armadura);
            }
            case "'s shield" -> {
                vida = (int) (Math.random() * 10 + 2);
                pagoTrabajo = 0;
                armadura = (int) (pokemon.getInt("base_defense") / divisor);
                velocidad = (int) (Math.random() *(3-(-6)-1)+(-6));
                item = new Item(nombre, precio, velocidad, vida, pagoTrabajo, armadura);
            }
            case "'s heart" -> {
                vida = (int) (pokemon.getInt("base_defense") / divisor);
                pagoTrabajo = 0;
                armadura = 0;
                velocidad = 0;
                item = new Item(nombre, precio, velocidad, vida, pagoTrabajo, armadura);
            }
        }

        return item;

    }

}
