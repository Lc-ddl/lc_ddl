import java.util.Date;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

interface picture {
    void display();
}
class User{
    private String name;
    boolean isVip;
    public User(String name,boolean isVip){
        this.name = name;
        this.isVip = isVip;
    }

    public String getName() {
        return name;
    }
}

class HighResolutionImage implements picture{
    private String filename;
    public HighResolutionImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }
    private void loadFromDisk() {
        System.out.println("Loading......");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public void display() {
        System.out.println("显示高清图片"+filename);
    }
}

class imageProxy implements image {
    private String filename;
    private HighResolutionImage realImage;
    private User user;

    public imageProxy(String filename,User user) {
        this.filename = filename;
        this.user = user;
    }

    @Override
    public void display() {
        System.out.println("\n[📋 日志] 用户 " + user.getName() + " 在 " + new Date() + " 查看了 " + filename);
        if(!user.isVip){
            System.out.println("权限不足，查看缩略图"+filename);
            return ;
        }
        else{
            try{
                realImage = new HighResolutionImage(filename);
                realImage.display();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}



interface image{
    void display();
}



class imageFactory {
    public static image getImage(String filename, User user) {
        if (user == null) {
            return new image() {
                @Override
                public void display() {
                    System.out.println("你的权限不足");
                }
            };
        }
        return new imageProxy(filename, user);
    }
}


public class main{
    public static void main(String[] args) {
        User user1 = new User("小丽",false);
        image proxy1 = imageFactory.getImage("image2.jpg", user1);
        proxy1.display();

        User user2 = new User("李华",true);
        image proxy2 = imageFactory.getImage("image.jpg",user2);
        proxy2.display();

        image proxy3 = imageFactory.getImage("image.jpg",(User) null);
        proxy3.display();
    }

}