import model.Dish;
import service.MenuService;

import java.util.List;

/**
 * Created by 33558 on 11.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        List<Dish> menuList;
        MenuService menu = new MenuService();
//        createFewDish(menu);
//        System.out.println("finished");
        System.out.println("get All method:");
        menuList = menu.getAll();
        System.out.println(menuList.toString());
        System.out.println("get All with discount method:");
        menuList = menu.getAllWithDiscount();
        System.out.println(menuList.toString());
        System.out.println("from to price method:");
        menuList = menu.getAllFromTo(10, 20);
        System.out.println(menuList.toString());
        System.out.println("get one kg weight method:");
        menuList = menu.getOneKgDishes();
        System.out.println(menuList.toString());
        menu.shutDownService();
    }

    private static void createFewDish(MenuService menu) {
        Dish dish = new Dish("Meat", 15, 0.3, true);
        Dish dish1 = new Dish("Fish", 10, 0.25, false);
        Dish dish2 = new Dish("Stake", 12, 0.25, true);
        Dish dish3 = new Dish("Soup", 5, 0.3, false);
        Dish dish4 = new Dish("Beer", 14, 0.5, true);
        Dish dish5 = new Dish("Omar", 85, 0.4, false);
        menu.add(dish);
        menu.add(dish1);
        menu.add(dish2);
        menu.add(dish3);
        menu.add(dish4);
        menu.add(dish5);
    }
}
