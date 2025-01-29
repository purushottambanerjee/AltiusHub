package com.example.demo.Service;


import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    UserInterface userInterface;

    @Autowired
    public UserService(UserInterface userInterface){
        this.userInterface = userInterface;
    }

    public String RegisterUser(User user){
            try {

                // Hash the password before passing
                user.setPassword(String.valueOf(user.getPassword().hashCode()));
                //before saving check whether ID and name is already exisiting
                Optional<User> user_saved = Optional.of(userInterface.save(user));

                if (user_saved.isPresent()) {
                    return "Created";
                } else {
                    return "Not Created";
                }
        }
            catch (Exception e){
                System.out.println(e.fillInStackTrace());
            }
        return "Something Unexpted Happened";
    }


    public String LoginUser(Integer id , String password){

        try {
                // Check User Id and fetch User Password
                Optional<User> user_found = userInterface.findById(id);
                if(user_found.isPresent()){
                    if( password.hashCode() == user_found.get().getPassword().hashCode())
                        return "Logged In";
                    else
                        return "incorrect Password for User"+user_found.get().getId();
                }
                else {
                    return "User is Not Present";
                }
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }

        return "Something Unexpected Happened";

    }


}
