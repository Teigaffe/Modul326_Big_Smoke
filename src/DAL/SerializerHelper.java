package DAL;

import java.io.*;
import java.util.ArrayList;

import model.Film;


public class SerializerHelper {
    private final static String FILEPATH = "./Input/movies.ser";

    public void Serialize(ArrayList<Film> movies){
        try {
            FileOutputStream fileOut = new FileOutputStream(FILEPATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for(Film movie : movies) {
                out.writeObject(movie);
            }
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }
    }

    public ArrayList<Film> Deserialize(){
        ArrayList<Film> m = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(FILEPATH);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            for(int i = 0; i < 3; i++) {
               m.add((Film) in.readObject());
            }
            in.close();
            fileIn.close();
            return m;
        }catch(IOException i) {
            i.printStackTrace();
            return null;
        }catch(ClassNotFoundException c) {
            c.printStackTrace();
            return null;
        }
    }
}
