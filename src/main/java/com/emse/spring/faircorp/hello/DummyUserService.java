package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DummyUserService implements UserService {
    @Autowired
    GreetingService Gs;

    @Override
    public void greetAll() {
        String[] liste= new String[2];
        liste[0]="Elodie";
        liste[1]="Charles";
        for(int i=0;i<liste.length;i++){
            Gs.greet(liste[i]);
        }

    }



}
