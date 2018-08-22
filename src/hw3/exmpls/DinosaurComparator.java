package hw3.exmpls;

import java.util.*;

public class DinosaurComparator implements Comparator<String> {
    
    @Override//указываем, как именно проводить сравнение
    public int compare(String s1, String s2)
    {
       return s2.compareToIgnoreCase(s1);
    }
    /*
    @Override
    public int compare(Dinosaur d1, Dinosaur d2)
    {
        return d1.get_name().compareTo(d2.get_name());
    }
    */
}
