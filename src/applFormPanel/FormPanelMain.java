package applFormPanel;

import javax.swing.*;
import java.awt.*;

public class FormPanelMain  extends  JPanel{
    public FormPanelMain(){
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        setBorder(BorderFactory.createTitledBorder("Information"));
    }
}

