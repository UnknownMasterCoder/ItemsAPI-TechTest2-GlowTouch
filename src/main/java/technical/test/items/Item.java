package technical.test.items;

import lombok.Data;

/**
 * Object Item, according to the Model with id and name as attributes
 * @author Pedro Mayorga
 * @version 1.0
 */
@Data
public class Item {

    // Attributes
    private Long id;
    private String name;

    // Getters y Setters

    /**
     * Get the id of the object
     * @return Object id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the id for an object
     * @param id Object id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name of the object
     * @return Object name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name for an object
     * @param name Object name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method for printing Items object
     * @return String response of the object
     */
    @Override
    public String toString() {
        return "\nItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}