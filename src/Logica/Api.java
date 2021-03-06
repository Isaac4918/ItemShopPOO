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

        LinkedList tmp = new LinkedList();

        for(int i = 0; i < 400; i+=4){
            JSONObject pokemon = pokemons.getJSONObject(i);
            Item aux = creaItem(pokemon);
            tmp.add(aux);
        }

        int a = 0;
        while (a<20){
            int indice = (int) Math.floor(Math.random()*(99-0+1)+0);
            Item aux = (Item) tmp.get(indice);
            this.tienda.inventario.add(aux);
            a++;
        }

        //
    }

    public Item creaItem(JSONObject pokemon){
        String nombre;
        int precio;
        int vida;
        int pagoIzquierda;
        int pagoDerecha;
        int armadura;
        int velocidad;
        Item item = new Item();


        int indice = (int) (Math.random()*4);
        String nombreaux = (String) sufijo.get(indice);
        nombre = pokemon.getString("pokemon_name") + nombreaux;

        precio = pokemon.getInt("base_stamina");

        int divisor = (int) (Math.random()*8+3);

        switch (nombreaux) {
            case "'s boots" -> {
                vida = 0;
                pagoIzquierda = 0;
                pagoDerecha = 0;

                armadura = (int) (Math.random() * 6 + 2);
                velocidad = (pokemon.getInt("base_attack") / divisor)/2;
                item = new Item(nombre, precio, velocidad, vida, pagoIzquierda, pagoDerecha, armadura);
                item.categoria= "Armadura";
            }
            case "'s tool" -> {
                vida = 0;
                pagoIzquierda = (pokemon.getInt("base_attack") / divisor)/2;
                pagoDerecha = 0;
                armadura = 0;
                velocidad = 0;
                item = new Item(nombre, precio, velocidad, vida, pagoIzquierda, pagoDerecha, armadura);
                item.categoria= "Herramienta";
            }
            case "'s shield" -> {
                vida = (int) (Math.random() * 10 + 2);
                pagoIzquierda = 0;
                pagoDerecha = 0;
                armadura = (int) (pokemon.getInt("base_defense") / divisor);
                velocidad = (int) (Math.random() *(3-(-6)-1)+(-6));
                item = new Item(nombre, precio, velocidad, vida, pagoIzquierda, pagoDerecha, armadura);
                item.categoria= "Herramienta";
            }
            case "'s heart" -> {
                vida = (pokemon.getInt("base_defense") / divisor*2);
                pagoIzquierda = 0;
                pagoDerecha = (int) Math.floor(Math.random()*(15-4+1)+4);
                armadura = 0;
                velocidad = 0;
                precio = precio / 3;
                item = new Item(nombre, precio, velocidad, vida, pagoIzquierda, pagoDerecha, armadura);
                item.categoria= "Consumible";
            }
        }

        return item;

    }

}
