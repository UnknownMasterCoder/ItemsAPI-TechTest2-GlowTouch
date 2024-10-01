package technical.test.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Controller for Items, with all its endpoints
 * @author Pedro Mayorga
 * @version 1.0
 */
@RestController
@RequestMapping("/items") //endpoint
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * Method for adding items with POST, it receives a list of items
     * @param items List of Items to Post
     * @return Response Entity with a body of information
     */
    @PostMapping
    public ResponseEntity<?> addItems(@RequestBody List<Item> items) {

        // Check if the list is null or empty
        if (items == null || items.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("List can't be null or empty");
        }

        // Adding items
        List<Item> conflictItems = new ArrayList<>();
        for (Item item : items) {
            // Check if the ID already exists in the DB
            if (itemService.itemExists(item.getId())) {
                conflictItems.add(item); // Don't add the item to DB
            } else {
                itemService.addItem(item); // Add the item if it doesn't exist
            }
        }

        // Return response based on result if duplicate items were found
        if (!conflictItems.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflicts: Items with existing IDs were skipped\nConflicting IDs:\n" + conflictItems.toString());
        }

        // If duplicate items weren't found
        return ResponseEntity.status(HttpStatus.OK).body("Items added successfully");
    }
}
