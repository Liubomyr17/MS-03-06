package mvc.MUSIC_STORE.daoimpl;

import mvc.MUSIC_STORE.dao.CategoryDAO;
import mvc.MUSIC_STORE.dto.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

    private final SessionFactory sessionFactory;

    private static List<Category> categories = new ArrayList<Category>();

    static {
        Category category = new Category();

        // adding first category
        category.setId(1);
        category.setName("Television");
        category.setDescription("This is some description for television");
        category.setImageURL("CAT_1.png");

        categories.add(category);

        // adding second category
        category = new Category();
        category.setId(2);
        category.setName("Mobile");
        category.setDescription("This is some description for mobile");
        category.setImageURL("CAT_2.png");

        categories.add(category);

        // adding third category
        category = new Category();
        category.setId(3);
        category.setName("Laptop");
        category.setDescription("This is some description for laptop");
        category.setImageURL("CAT_3.png");

        categories.add(category);
    }

    public CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public boolean add(Category category) {

        try {
            sessionFactory.getCurrentSession().persist(category);
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Category> list() {
        return categories;
}

    @Override
    public Category get(int id) {
        // enchanced for loop
        for (Category category : categories) {

            if(category.getId() == id) return category;
        }
        return null;
    }
}
