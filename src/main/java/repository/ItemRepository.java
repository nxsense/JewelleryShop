package repository;

import entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author author
 * @version 1.0
 */
public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query(value = "SELECT * FROM items WHERE type = ?1", nativeQuery = true)
    List<Item> findItemsByType(String type);

    @Query(value = "SELECT * FROM items WHERE type = ?1 ORDER BY ?2", nativeQuery = true)
    List<Item> findItemsByTypeOrderBy(String type, String sortBy);

}
