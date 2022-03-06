package manager;

import models.User;
import org.testng.annotations.DataProvider;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginValidData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"hatum.testing@gmail.com", "Hatum21$"});
        list.add(new Object[]{"hatum.testing@gmail.com", "Hatum21$"});
        list.add(new Object[]{"hatum.testing@gmail.com", "Hatum21$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginValidDataUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$")});
        list.add(new Object[]{new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$")});
        list.add(new Object[]{new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$")});


        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginValidDataBoard(){
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }
}
