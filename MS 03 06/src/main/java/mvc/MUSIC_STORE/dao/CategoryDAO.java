package mvc.MUSIC_STORE.dao;

import mvc.MUSIC_STORE.dto.Category;

import java.util.List;

public interface CategoryDAO {

    boolean add(Category category);

    List<Category> list();
    Category get(int id);

}
