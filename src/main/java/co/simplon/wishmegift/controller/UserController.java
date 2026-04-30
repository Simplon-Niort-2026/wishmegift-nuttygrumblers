package co.simplon.wishmegift.controller;


import co.simplon.wishmegift.entity.User;
import co.simplon.wishmegift.entity.Wishlist;
import co.simplon.wishmegift.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;

    //GETBYID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findUserById(@PathVariable Long id){
        return usersService.findUserById(id);
    }

    //GET WISHLIST OF USER BY ID
    @GetMapping("/{id}/wishlists")
    @ResponseStatus(HttpStatus.OK)
    public List<Wishlist> findAllWishlistByUserId(@PathVariable Long id){
        return usersService.findAllWishlistByUserId(id);
    }

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User newUser){
        usersService.saveUser(newUser);
    }

    //PUT
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void modifyUser(@PathVariable Long id, @RequestBody User userModified){
        usersService.modifyUserById(userModified,id);
    }

    //PATCH
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void modifyPartialyUser(@PathVariable Long id, @RequestBody User userModifiedPartialy){
        usersService.modifyPartialyUserById(userModifiedPartialy,id);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public void deleteUserById(@PathVariable Long id){
        usersService.deleteUser(id);
    }
}
