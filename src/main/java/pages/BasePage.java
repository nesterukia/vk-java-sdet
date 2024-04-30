package pages;

abstract public class BasePage {
    public abstract void checkPage();
    public BasePage(){
        checkPage();
    }
}
