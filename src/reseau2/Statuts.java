package reseau2;

import java.io.Serializable;

/**
 *
 * @author Morgan
 */
public class Statuts implements Serializable{

    public Statuts(int counter, String message) {
        this.counter = counter;
        this.message = message;
    }
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    private String message;
   
}
