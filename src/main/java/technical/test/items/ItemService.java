package technical.test.items;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Service Item, make all the operations of the controller
 * @author Pedro Mayorga
 * @version 1.0
 */
@Service
public class ItemService {

    // DB simulation as a Set (unique IDs)
    private Set<Long> itemDatabase = new HashSet<Long>();

    /**
     * Method for adding an Item if its ID isn't in the DB
     * @param item Item object
     * @return Boolean for adding item
     */
    public boolean addItem(Item item) {

        // If item is in the database
        if (itemExists(item.getId())) { //itemDatabase.contains(item.getId())
            return false; // Item with this ID already exists
        } else {
            itemDatabase.add(item.getId());
            return true; // Item succesfully added
        }
    }

    /**
     * Method for verifying if an ID is already in the DB
     * @param id Id for the Item Object
     * @return Boolean if item exists
     */
    public boolean itemExists(Long id) {
        return itemDatabase.contains(id); // If item is in the database
    }
}
