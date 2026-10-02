package ase.course4.seminar4;

import java.util.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        float[] preturi1 = {600.5f, 750.5f, 890.9f};

        Masina m1 = new Masina(4, 5, tipVehicul.MASINA,
                "Mercedes", 30000, 2020, "negru", "diesel", preturi1);
        System.out.println(m1.toString());

        Masina m2 = new Masina(8, 2, tipVehicul.CAMION, "Mercedes",
                50000, 2019, "rosu", "diesel", preturi1);
        System.out.println(m2.toString());

        Masina m3 = new Masina(4, 2, tipVehicul.TRACTOR, "New Holland",
                200000, 2021, "verde", "diesel", preturi1);
        System.out.println(m3.toString());

        m2.setPret(33000);
        System.out.println(m2.getPret());

        System.out.println("-----------------------");

        Masina[] vectMasini = {m1, m2, m3};
        for(int i=0;i<vectMasini.length;i++)
            System.out.println(vectMasini[i]);

        System.out.println("-----------------------");

        for(Masina m: vectMasini)
            System.out.println(m.toString());

        System.out.println("-----------------------");

        for(Masina m: vectMasini)
            System.out.println(m.calculPretVanzare());

        for(Masina m: vectMasini)
            System.out.println(m.spuneMarca());

        Masina m4 = m3.clone();
        m4.setPret(99000);

        System.out.println("---------------ArrayList-----------------");
        ArrayList<Masina> listaMasini = new ArrayList<>();
        for(int i=0;i<vectMasini.length;i++)
            listaMasini.add(vectMasini[i]);
        listaMasini.add(m4);

        Collections.sort(listaMasini);
        for(int i=0;i<listaMasini.size();i++)
            System.out.println(listaMasini.get(i));

        System.out.println("---------------List-----------------");
        List<Masina> masini = Arrays.asList(vectMasini);
        vectMasini[0] = m4;
        for(int i=0;i<masini.size();i++)
            System.out.println(masini.get(i));
        Masina[] vect2Masini = masini.toArray(new Masina[0]);
        for(int i=0;i<vect2Masini.length;i++)
            System.out.println(vect2Masini[i]);

        Collections.shuffle(masini);

        for(Iterator<Masina> i = masini.iterator(); i.hasNext();)
        {
            Masina m = i.next();
            System.out.println(m);
            /*String s = i.next().toString();
            System.out.println(s);*/
        }

        System.out.println("---------------Vector-----------------");
        Vector<Masina> masiniVector = new Vector<>();
        masiniVector.add(m1);
        masiniVector.add(m2);
        masiniVector.add(m3);
        masiniVector.remove(m1);
        masiniVector.add(0, m4);

        for(Masina m: masiniVector)
            System.out.println(m);

        System.out.println("---------------SortedSet-----------------");
        SortedSet<Masina> masinaSortedSet = new TreeSet<>();
        masinaSortedSet.addAll(masini);
        masinaSortedSet.add(m4);
        System.out.println(masinaSortedSet);

        System.out.println("---------------HashSet-----------------");
        HashSet<Masina> masiniSet = new HashSet<>();

        Masina m5 = new Masina(4, 5, tipVehicul.MASINA, "BMW", 30000, 2020, "albastru", "diesel", new float[]{600.5f});
        Masina m6 = new Masina(4, 5, tipVehicul.MASINA, "BMW", 30000, 2020, "albastru", "diesel", new float[]{600.5f});
        Masina m7 = new Masina(4, 5, tipVehicul.MASINA, "Audi", 25000, 2019, "rosu", "benzina", new float[]{500.5f});

        // Adăugăm mașini în HashSet
        masiniSet.add(m5);
        masiniSet.add(m6); // m2 este un duplicat, nu va fi adăugat
        masiniSet.add(m7);

        // Afișăm HashSet-ul
        for (Masina m : masiniSet) {
            System.out.println(m);
        }

        System.out.println("---------------HashTable-----------------");
        Hashtable<Integer, ArrayList<Masina>> ht = new Hashtable<>();
        ht.put(100, new ArrayList<>());
        ht.get(100).add(vectMasini[0]);
        ht.get(100).add(vectMasini[1]);
        ht.get(100).add(vectMasini[2]);

        ht.put(200, new ArrayList<>());
        ht.get(200).add(m4);

        System.out.println("La garajul cu nr. 100: "+ht.get(100));
        System.out.println("La garajul cu nr. 200: "+ht.get(200));

        Student[] vectStudenti = new Student[5];
        vectStudenti[0] = new Student(7.8);
        vectStudenti[1] = new Student(5.5);
        vectStudenti[2] = new Student(6.7);
        vectStudenti[3] = new Student(8.9);
        vectStudenti[4] = new Student(6.5);

        Arrays.sort(vectStudenti, new Student.StudentComparator());
        for(int i=0;i<vectStudenti.length;i++)
            System.out.println(vectStudenti[i]);


        System.out.println("---------------Queue-----------------");
        Queue<Masina> coadaService = new LinkedList<>();

        Masina m8 = new Masina(4, 5, tipVehicul.MASINA, "Dacia", 12000, 2022, "alb", "benzina", new float[]{300.5f});
        Masina m9 = new Masina(4, 5, tipVehicul.MASINA, "Ford", 18000, 2021, "negru", "benzina", new float[]{450.5f});
        Masina m10 = new Masina(4, 5, tipVehicul.MASINA, "Toyota", 25000, 2023, "gri", "hibrid", new float[]{750.5f});

        // Adăugăm mașini în coadă
        coadaService.offer(m8);
        coadaService.offer(m9);
        coadaService.offer(m10);

        // Prelucrăm fiecare mașină (FIFO)
        while (!coadaService.isEmpty()) {
            Masina masinaLaService = coadaService.poll(); // scoate primul element din coadă
            System.out.println("Prelucrez masina: " + masinaLaService);
        }

        System.out.println("---------------HashMap-----------------");
        HashMap<String, Masina> mapMasini = new HashMap<>();

        Masina m11 = new Masina(4, 5, tipVehicul.MASINA, "Renault", 17000, 2020, "verde", "diesel", new float[]{500.5f});
        Masina m12 = new Masina(4, 5, tipVehicul.MASINA, "Volkswagen", 22000, 2021, "albastru", "benzina", new float[]{600.5f});
        Masina m13 = new Masina(4, 5, tipVehicul.MASINA, "Tesla", 45000, 2022, "alb", "electric", new float[]{1000.5f});

        // Adăugăm mașini în HashMap, mapând după număr de înmatriculare
        mapMasini.put("B123ABC", m11);
        mapMasini.put("C456DEF", m12);
        mapMasini.put("D789GHI", m13);

        // Căutăm o mașină după numărul de înmatriculare
        Masina cautata = mapMasini.get("C456DEF");
        System.out.println("Masina cautata este: " + cautata);

        // Afișăm toate mașinile
        for (String numarInmatriculare : mapMasini.keySet()) {
            System.out.println(numarInmatriculare + ": " + mapMasini.get(numarInmatriculare));
        }

        System.out.println("---------------PriorityQueue-----------------");
        // Coada cu priorități bazată pe preț (cea mai scumpă mașină va fi la final)
        PriorityQueue<Masina> coadaPrioritati = new PriorityQueue<>((m14, m15) -> Float.compare(m14.getPret(), m15.getPret()));

        Masina m14 = new Masina(4, 5, tipVehicul.MASINA, "BMW", 35000, 2020, "negru", "diesel", new float[]{600.5f});
        Masina m15 = new Masina(4, 5, tipVehicul.MASINA, "Audi", 28000, 2019, "rosu", "benzina", new float[]{450.5f});
        Masina m16 = new Masina(4, 5, tipVehicul.MASINA, "Mercedes", 50000, 2021, "gri", "electric", new float[]{900.5f});

        // Adăugăm mașinile în coadă
        coadaPrioritati.offer(m14);
        coadaPrioritati.offer(m15);
        coadaPrioritati.offer(m16);

        // Scoatem mașinile din coadă (în ordinea prețului)
        while (!coadaPrioritati.isEmpty()) {
            Masina masinaPrioritara = coadaPrioritati.poll(); // Scoate cea mai ieftină mașină
            System.out.println("Masina prioritara: " + masinaPrioritara);
        }

        System.out.println("---------------Stack-----------------");
        Stack<Masina> stackMasini = new Stack<>();

        Masina m21 = new Masina(4, 5, tipVehicul.MASINA, "Honda", 20000, 2020, "verde", "benzina", new float[]{500.5f});
        Masina m22 = new Masina(4, 5, tipVehicul.MASINA, "Nissan", 23000, 2021, "albastru", "diesel", new float[]{600.5f});
        Masina m23 = new Masina(4, 5, tipVehicul.MASINA, "Toyota", 28000, 2022, "alb", "hibrid", new float[]{700.5f});

        // Adăugăm mașinile în stivă
        stackMasini.push(m21);
        stackMasini.push(m22);
        stackMasini.push(m23);

        // Scoatem mașinile din stivă
        while (!stackMasini.isEmpty()) {
            Masina masinaScoasa = stackMasini.pop(); // scoate ultima mașină adăugata
            System.out.println("Masina scoasa: " + masinaScoasa);
        }
    }
}
