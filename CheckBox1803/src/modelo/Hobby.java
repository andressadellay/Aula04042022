
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Andressa
 */
public class Hobby {
    ArrayList <String> hobby = new ArrayList<>();
    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    
    public void adicionar(String h){
        this.hobby.add(h);
    }

    @Override
    public String toString() {
        return "Hobby: " + hobby;
    }
    
            
}
