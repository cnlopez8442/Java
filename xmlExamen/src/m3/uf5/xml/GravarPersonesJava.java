package m3.uf5.xml;

import java.io.*;

public class GravarPersonesJava {

    public static void main(String[] args) {

        
        FileOutputStream fo;
        ObjectOutputStream obo;
        Persona p1 = new Persona("Josep", 23);
        Persona p2 = new Persona("Joan", 18);
        Persona p3 = new Persona("Victor", 76);
        Persona p4 = new Persona("Maria", 24);
        Persona p5 = new Persona("Matias", 23);

        try {
            fo = new FileOutputStream("d:\\personesJava.dat", true);
            obo = new ObjectOutputStream(fo);
            obo.writeObject(p1);
            obo.writeObject(p2);
            obo.writeObject(p3);
            obo.writeObject(p4);
            obo.writeObject(p5);
            System.out.println("Persones gravades amb èxit....");
            obo.flush();
            obo.close();
            fo.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
}
