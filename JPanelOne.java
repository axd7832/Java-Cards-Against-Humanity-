import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class JPanelOne extends JPanel {

    public JPanelOne() {

        FlowLayout layoutPanel = new FlowLayout();
        JPanel panel = new JPanel(layoutPanel);
        JButton button = new JButton("test");
        panel.add(button);
        panel.setVisible(true);

    }

}