package ro.ase.swing2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Produs> listaProd = new ArrayList<>();
    static List<Tranzactie> listaTranzactii = new ArrayList<>();

    public static void readProducts()
    {
        String linie = "";
        try {
            FileInputStream fluxIn = new FileInputStream("produse.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fluxIn);
            BufferedReader br = new BufferedReader(inputStreamReader);

            while ((linie = br.readLine())!=null)
            {
                String[] vs = linie.split(",");
                int cod = Integer.parseInt(vs[0]);
                String denumire = vs[1];
                float pret = Float.parseFloat(vs[2]);

                Produs p = new Produs(cod, denumire, pret);
                listaProd.add(p);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readTransactions()
    {
        String linie = "";
        String jsonStr = "";

        try {
            FileInputStream fluxIn = new FileInputStream("tranzactii.json");
            InputStreamReader inputStreamReader = new InputStreamReader(fluxIn);
            BufferedReader br = new BufferedReader(inputStreamReader);

            while ((linie=br.readLine())!=null)
            {
                jsonStr+=linie;
            }

            parsareJSON(jsonStr);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void parsareJSON(String jsonStr)
    {
        JSONArray array = new JSONArray(jsonStr);

        for(int i=0;i< array.length();i++)
        {
            JSONObject obj = array.getJSONObject(i);
            int codProd = obj.getInt("codProdus");
            int cantitate = obj.getInt("cantitate");
            String tip = obj.getString("tip");

            Tranzactie t = new Tranzactie(codProd, cantitate, tip);
            listaTranzactii.add(t);
        }
    }

    public static void main(String[] args) {

        readProducts();
        Collections.sort(listaProd);

        for(Produs p:listaProd)
            System.out.println(p);

        readTransactions();
        for(Tranzactie t:listaTranzactii)
            System.out.println(t);
    }
}
