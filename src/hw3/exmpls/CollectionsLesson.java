
package hw3.exmpls;

import java.util.*;

public class CollectionsLesson {

    public static void main(String[] args) {

//////////////////////////////////////////ArrayList////////////////////////////////////////////
        /*
        //начальная ёмкость - 10 элементов
        ArrayList<String> dinosaurs = new ArrayList<>();
        
            dinosaurs.add("Compsognathus");
            dinosaurs.add("Amargasaurus");
            dinosaurs.add("Oviraptor");
            dinosaurs.add("Velociraptor");
            dinosaurs.add("Deinonychus");
            dinosaurs.add("Dilophosaurus");
            dinosaurs.add("Gallimimus");
            dinosaurs.add("Triceratops"); 
            dinosaurs.add("Triceratops");
            
            //удалить элемент по индексу или значению dinosaurs.remove(3) или dinosaurs.remove("Gallimimus")  
                    
        System.out.println("Size of dinosaurs list is " + dinosaurs.size());
        
        //вывод списка элементов
        for(String d: dinosaurs)
        {
           System.out.println(d);
        }
        
        dinosaurs.trimToSize();//укорочение до минимума
        
        //получить массив из ArrayList
        String[] dino = new String[dinosaurs.size()];
        
        Dinosaur[] dn = new Dinosaur[] {
                                            new Dinosaur(270 ,"Theropoda" ,"Velociraptor"),
                                            new Dinosaur(230 ,"Theropoda" ,"Compsognathus"),
                                            new Dinosaur(130 ,"Sauropoda" ,"Triceratops"),
                                       };
        
        ArrayList<Dinosaur> dinos = new ArrayList<>();//Обратите внимание на объявление new ArrayList<нет_типа_данных>()
        
        //добавить элементы массива dn в лист dinos
        dinos.addAll(Arrays.asList(dn));
        
        //найти индекс элемента; вернёт -1, если такого элемента нет
        int index = dinosaurs.indexOf("Triceratops");
            System.out.println(index);
        
        //упорядочить элементы в списке dinos по наименованию без учёта регистра в прямом порядке
        dinos.sort(Comparator.comparing(Dinosaur::get_name, String.CASE_INSENSITIVE_ORDER));
        
        //упорядочить элементы в списке dinos по наименованию без учёта регистра в обратном порядке
        //dinos.sort(Comparator.comparing(Dinosaur::get_name, String.CASE_INSENSITIVE_ORDER).reversed());
        for(Dinosaur din: dinos)
        {
           System.out.println(din.get_name());
        }
       */
////////////////////////////////////////LinkedList//////////////////////////////////////////
        /*
         LinkedList<String> auto = new LinkedList<>(); 
     
        //Добавить элементы в LinkedList. //
        auto.add("BMW"); 
        auto.add("Toyota"); 
        auto.add("Jeep"); 
        auto.add("UAZ"); 
        auto.add("Ferrari"); 
        auto.addLast("Lotus"); 
        auto.addFirst("Mazda"); 

        auto.add(2, "Alfa Romeo");//будет добавлен в конец списка, если не указать параметр 
        
        System.out.println("Contents of auto: " + auto); 
 
        //Удаление элементов  
        auto.remove(3); 
        auto.remove(2); 

        System.out.println("Contents of auto after deletion: " + auto); 

        //Удалить первый и последний элементы. 
        auto.removeFirst(); 
        auto.removeLast(); 
 
        System.out.println("Auto after deleting first and last: " + auto); 
 
        //Get и set. 
        String auto_name = auto.get(2); 
        auto.set(2, auto_name + " was changed"); 

        System.out.println("Auto after change: " + auto); 
        */
//////////////////////////////HashSet/////////////////////////////////
        /*
        HashSet<String> h_set = new HashSet<String>(); 
     
        // Add elements to the hash set. 
        h_set.add("Compsognathus"); 
        h_set.add("Amargasaurus"); 
        h_set.add("Oviraptor"); 
        h_set.add("Velociraptor"); 
        h_set.add("Deinonychus");
        h_set.add("Dilophosaurus");   
        
        //System.out.println(h_set); 
        
        Iterator<String> s_iterator = h_set.iterator();//получить итератор (перечислитель) для h_set  
        
        while(s_iterator.hasNext()) 
        {
            String h_set_element = s_iterator.next(); 
            System.out.print(h_set_element + " ");
        }
        
        //System.out.println(h_set);
        */
//////////////////////////////TreeSet/////////////////////////////////        
        /*
        TreeSet<String> t_set = new TreeSet<>(); 
     
        // Add elements to the tree set. 
        t_set.add("Compsognathus"); 
        t_set.add("Amargasaurus"); 
        t_set.add("Oviraptor"); 
        t_set.add("Velociraptor"); 
        t_set.add("Deinonychus");
        t_set.add("Dilophosaurus");   
        
        System.out.println(t_set);
        //System.out.println(t_set.lower("Velociraptor")); 
        */
//////////////////////////////////Компараторы для TreeSet и TreeMap////////////////////////////////// 
        /*
          TreeSet<String> t_set = new TreeSet<>(new DinosaurComparator()); 
        //TreeSet<String> t_set = new TreeSet<>((new DinosaurComparator()).reversed()); 
     
        // Add elements to the tree set. 
        t_set.add("Compsognathus"); 
        t_set.add("Amargasaurus"); 
        t_set.add("Oviraptor"); 
        t_set.add("Velociraptor"); 
        t_set.add("Deinonychus");
        t_set.add("Dilophosaurus");   
        
        System.out.println("TreeSet sorting: ");
        for(String din: t_set)
        {
           System.out.println(din);
        }
        */
/////////////////////////////////LinkedHashSet/////////////////////////////////
        /*
        LinkedHashSet<String> lh_set = new LinkedHashSet<>(); 
     
        // Add elements to the hash set. 
        lh_set.add("Compsognathus"); 
        lh_set.add("Amargasaurus"); 
        lh_set.add("Oviraptor"); 
        lh_set.add("Velociraptor"); 
        lh_set.add("Deinonychus");
        lh_set.add("Dilophosaurus");   

        System.out.println(lh_set); 
        */
/////////////////////////////////HashMap/////////////////////////////////
        
        HashMap<Integer, String> hm = new HashMap<>();
        
        hm.put(1 , "BMW");
        hm.put(2 , "UAZ");
        hm.put(3 , "Alfa Romeo");
        hm.put(4 , "Ferrari");
        
        Set<Map.Entry<Integer, String>> set = hm.entrySet();
        
        for (Map.Entry<Integer, String> o : set) 
        {
        System.out.print(o.getKey() + ": ");
        System.out.println(o.getValue());
        }
        
        }//main
}
