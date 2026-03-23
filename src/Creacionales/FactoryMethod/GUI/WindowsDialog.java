package Creacionales.FactoryMethod.GUI;

public class WindowsDialog extends Dialog{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
