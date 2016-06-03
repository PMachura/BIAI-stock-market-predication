/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przemek.BIAI.projekt.neuroph;


class NoObject{
    int x;
    double y;

    public NoObject(){
  //      x=0;
  //      y=0;
    }
    @Override
    public String toString() {
        return "NoObject{" + "x=" + x + ", y=" + y + '}';
    }
    
    
}
/**
 *
 * @author Przemek
 */
public class Tests {
    public static void main(String [] args){
        System.out.println(new NoObject());
        
       int x =0;
       String y="cos" + x;
       System.out.println(y);
       
       
       double []w;
       double []z={1,2,3,4,5};
       
    //   w=new double[5];
       w=z.clone();
       w[0]=2;
       
       System.out.println(w[0]+"   "+z[0]);
       
       
       int [][] tab;
       tab=new int[3][2];
       tab[0][0]=2;
       tab[1][1]=3;
       int [][]tab2=tab.clone();
       System.out.println(tab[1].length);
       System.out.println(tab2[1][1]);
    }
}
