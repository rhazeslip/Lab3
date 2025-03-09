import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends JPanel {
    private JTextArea detailsArea;

    public DetailsPanel() {
        setLayout(new BorderLayout());
        detailsArea = new JTextArea(10,30);
        detailsArea.setEditable(false);
        add(new JScrollPane(detailsArea), BorderLayout.CENTER);
    }

    public void setDetails(String details) {
        detailsArea.setText(details);
    }
}
