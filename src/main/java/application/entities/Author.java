package application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String Name;
    private String SecName;
    private String Email;
    private String Phone;
    private Integer Ranking;
    private Integer Price;
    private String Mission;
    private String MainText;
    private Integer MainPhotoId;

    public Author(String name, String secName, String email, String phone, Integer ranking, Integer price,
                  String mission, String mainText) {
        Name = name;
        SecName = secName;
        Email = email;
        Phone = phone;
        Ranking = ranking;
        Price = price;
        Mission = mission;
        MainText = mainText;
    }

    public Author () {

    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSecName() {
        return SecName;
    }

    public void setSecName(String secName) {
        SecName = secName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Integer getRanking() {
        return Ranking;
    }

    public void setRanking(Integer ranking) {
        Ranking = ranking;
    }

    public String getMission() {
        return Mission;
    }

    public void setMission(String mission) {
        Mission = mission;
    }

    public String getMainText() {
        return MainText;
    }

    public void setMainText(String mainText) {
        MainText = mainText;
    }

    public Integer getMainPhotoId() {
        return MainPhotoId;
    }

    public void setMainPhotoId(Integer mainPhotoId) {
        MainPhotoId = mainPhotoId;
    }
}
