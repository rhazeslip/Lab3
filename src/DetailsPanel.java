import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends JPanel {
    private JTextArea detailsArea; //Text area to display country details

    public DetailsPanel() {
        setLayout(new BorderLayout());
        detailsArea = new JTextArea(10,30);
        detailsArea.setEditable(false); //Text area is read only, cannot edit
        add(new JScrollPane(detailsArea), BorderLayout.CENTER);
    }

    //Sets the details in the text area
    public void setDetails(String details) {
        if (details != null) {
            detailsArea.setText(details);
        }
        else {
            detailsArea.setText("No Data Available");
        }
    }
}
