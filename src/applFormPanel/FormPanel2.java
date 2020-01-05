package applFormPanel;

import javax.swing.*;
import java.awt.*;

public class FormPanel2 extends JPanel {
    public FormPanel2(){
        setLayout(new BorderLayout());

            Dimension dim = getPreferredSize();
            dim.width = 250;
            setPreferredSize(dim);

        setBorder(BorderFactory.createTitledBorder("Addition"));
    }
}
