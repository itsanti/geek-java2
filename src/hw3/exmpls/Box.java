
package hw3.exmpls;

public class Box {

   static String b = "box"; 
    
   private int width;
   private int height;
   private int depth;

   //Конструктор класса Box
   public Box(int w, int h, int d)
   {
      this.width = w;
      this.height = h;
      this.depth = d;
   }

   //обеспечение безопасного доступа к полям класса 
   //get - получить
   public int get_Width()
   {
     return this.width;
   }
   //set - установить
   public void set_Width(int width)
   {
     this.width = width;
   }
   
   public int get_Height()
   {
     return this.height;
   }
   
   public void set_Height(int height)
   {
     this.height = height;
   }
   
   public int get_Depth()
   {
     return this.depth;
   }
   //set - установить
   public void set_Depth(int depth)
   {
     this.depth = depth;
   }
   
   public boolean boxpredicate()
    {
        if(this.width > 3) return true;
        else return false;
    }
   
   @Override
   public boolean equals(Object ob)
   {
     if(this == ob) return true;
     if(!(ob instanceof Box)) return false;
     
        Box auxbox = (Box)ob;
        
        return this.width == auxbox.width && this.height == auxbox.height && this.depth == auxbox.depth; 
        
   }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.width;
        hash = 67 * hash + this.height;
        hash = 67 * hash + this.depth;
        return hash;
    }
    
}

