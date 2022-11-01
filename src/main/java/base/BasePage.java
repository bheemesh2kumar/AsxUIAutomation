package base;

public class BasePage extends Base {

    public <Tpage extends BasePage> Tpage as(Class<Tpage> page) {
        try {
            return (Tpage) this;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }
    }


}
