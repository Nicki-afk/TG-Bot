package bot.botodelkin.mainBot.clients;

public class ClientOrder {

    public String email;

    public String descriptionTheOrder;


    public ClientOrder(String email, String descriptionTheOrder) {
        this.email = email;
        this.descriptionTheOrder = descriptionTheOrder;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescriptionTheOrder() {
        return descriptionTheOrder;
    }

    public void setDescriptionTheOrder(String descriptionTheOrder) {
        this.descriptionTheOrder = descriptionTheOrder;
    }
}
