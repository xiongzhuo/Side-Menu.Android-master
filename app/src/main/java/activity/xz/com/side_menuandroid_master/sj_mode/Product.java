package activity.xz.com.side_menuandroid_master.sj_mode;


import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {

    public int total;
    public List<User> user;

    public class User {
        public int id;
        public String userName;
        public String email;

    }
}