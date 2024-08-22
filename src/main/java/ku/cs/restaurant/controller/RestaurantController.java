package ku.cs.restaurant.controller;

import ku.cs.restaurant.entity.Restaurant;
import ku.cs.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author 6510450305 Chaiyapat
 */

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurant() {
        return service.getAll();
    }

    @PostMapping("/restaurant")
    public void create(@RequestBody List<Restaurant> restaurants) {
        for (Restaurant r : restaurants) {
            service.create(r);
        }
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurantById(@PathVariable UUID id) {
        System.out.println(id.toString());
        return service.getRestaurantById(id);
    }

    @PutMapping("/restaurant")
    public Restaurant update(@RequestBody Restaurant restaurant) {
        return service.update(restaurant);
    }

    @DeleteMapping("/restaurant/{id}")
    public Restaurant delete(@PathVariable UUID id) {
        return service.delete(id);
    }

    @GetMapping("/restaurant/name/{name}")
    public Restaurant getRestaurantByName(@PathVariable String name) {
        return service.getRestaurantByName(name);
    }

    @GetMapping("/restaurant/location/{location}")
    public List<Restaurant> getRestaurantByLocation(@PathVariable String location) {
        return service.getRestaurantByLocation(location);
    }
}
