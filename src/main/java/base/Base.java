package base;

import org.openqa.selenium.support.PageFactory;

public class Base {

    public BasePage currentPage;


    public <Tpage extends BasePage> Tpage getInstance(Class<Tpage> page) {
        try {
            Object ob = PageFactory.initElements(DriverContext.driver, page);
            return page.cast(ob);
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return null;
    }


}
