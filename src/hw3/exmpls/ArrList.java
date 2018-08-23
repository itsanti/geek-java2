
package hw3.exmpls;

import java.util.*;

public class ArrList {

   
    public static void main(String[] args) {

        ArrayList<Box> boxes = new ArrayList<>();
        
        Box b1 = new Box(1,1,1);
        Box b2 = new Box(2,2,2);
        Box b3 = new Box(3,3,3);
        Box b4 = new Box(4,4,4);
        Box b5 = new Box(5,5,5);
        Box b6 = new Box(6,6,6);
        Box b7 = new Box(7,7,7);
        Box b8 = new Box(8,8,8);
        Box b9 = new Box(9,9,9);
        Box b10 = new Box(10,10,10);
        Box b11 = new Box(5,5,5);
        
        boxes.add(b1);
        boxes.add(b2);
        boxes.add(b3);
        boxes.add(b4);
        boxes.add(b5);
        boxes.add(b6);
        boxes.add(b7);
        boxes.add(b8);
        boxes.add(b9);
        boxes.add(b10);
        boxes.add(b11);

        //boxes.removeIf(Box -> Box.get_Width() > 4);
        //boxes.removeIf(Box -> Box.boxpredicate());
        
        //while(boxes.remove(new Box(5,5,5)));
          
        for(Box b: boxes)
        {
            System.out.println(b.get_Width());
        }
    }
    
    
    
}
