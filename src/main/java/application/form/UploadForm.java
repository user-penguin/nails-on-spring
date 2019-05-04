package application.form;

public class UploadForm {
    private String Name;
    private String SecName;
    private String Email;
    private String Phone;
    private Integer Ranking;
    private Integer Price;
    private String Mission;
    private String MainText;

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

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
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
}
