package mapper;

import java.util.HashMap;

public abstract class MapProductToAttribute<T> {
    public HashMap<Integer,T> getMap () {
        return mapProductToAttribute();
    }
    public abstract HashMap<Integer,T> mapProductToAttribute ();
}
