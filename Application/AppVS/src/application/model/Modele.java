package application.model;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class Modele {

    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
