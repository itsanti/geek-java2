
package hw3.exmpls;

public class Dinosaur {

     private int mill_year_ago;
     private String type;
     private String name;
     
     public String get_name()
             {
                return this.name;
             }
     
     public Dinosaur(int mill_year_ago, String type, String name)
     {
        this.mill_year_ago = mill_year_ago;
        this.type = type;
        this.name = name;
     }
    
}
