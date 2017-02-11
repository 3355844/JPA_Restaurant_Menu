package service;

import model.Dish;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 33558 on 11.02.2017.
 */
public class MenuService {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAMenu");
    private EntityManager entityManager = factory.createEntityManager();

    public void add(Dish dish) {
        entityManager.getTransaction().begin();
        entityManager.merge(dish);
        entityManager.getTransaction().commit();
    }

    public Dish get(int id) {
        return entityManager.find(Dish.class, id);
    }

    public void delete(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(get(id));
        entityManager.getTransaction().commit();
    }

    public List<Dish> getAll() {
        TypedQuery<Dish> namedQuery = entityManager.createNamedQuery("menu.getAll", Dish.class);
        return namedQuery.getResultList();
    }

    public List<Dish> getAllWithDiscount() {
        TypedQuery<Dish> namedQuery = entityManager.createNamedQuery("menu.getAllWithDiscount", Dish.class);
        return namedQuery.getResultList();
    }

    public List<Dish> getAllFromTo(double from, double to) {
        Query query = entityManager.createNamedQuery("menu.getFromTo", Dish.class);
        query.setParameter("priceFrom", from);
        query.setParameter("priceTo", to);
        return query.getResultList();
    }

    public List<Dish> getOneKgDishes() {
        Random random = new Random();
        List<Dish> dishList = getAll();
        List<Dish> result = new ArrayList<>();
        int randomId;
        double i = 0;
        while (true) {
            randomId = random.nextInt(dishList.size() + 1);
            Dish dish = dishList.get(randomId);
            i += dish.getWeightDish();
            if (i >= 1) break;
            result.add(dish);
        }
        return result;
    }

    public void shutDownService() {
        if (entityManager != null) {
            entityManager.close();
            factory.close();
        }
    }
}
