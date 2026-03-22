package java.pesistences;

import org.eclipse.jetty.server.Authentication;

import java.entities.Coffee;
import java.entities.Users;
import java.util.ArrayList;
import java.util.List;

public class CoffeeMapper {

    public List<Coffee> favorites = new ArrayList<>();

    public boolean addToFavorites(Users user_id, Coffee coffename){
        return true;
    }

    public List<Coffee> getFavorites(Users user_id){
        return favorites;
    }
}
