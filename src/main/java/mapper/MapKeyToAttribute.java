package mapper;

import java.util.HashMap;

public abstract class MapKeyToAttribute<T> {
    public HashMap<Integer,T> getMap () {
        return mapKeyToAttribute();
    }
    public abstract HashMap<Integer,T> mapKeyToAttribute ();
}
