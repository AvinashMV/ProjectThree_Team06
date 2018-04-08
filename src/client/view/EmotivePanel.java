package client.view;

import javax.swing.*;

import client.model.SingleTonData;

import java.awt.*;

/**
 * EmotivePanel class is a emotive tab on the GUI
 *
 * @author Abhishek
 */
public class EmotivePanel extends JPanel {
    public static final String TABNAME = "Emotive";
    JPanel facePart;
    ExpressionPlots graphPart;

    public EmotivePanel(){
        setLayout(new BorderLayout());
        Dimension df = this.getSize();
        facePart = new FaceExpressions("000000000000.png");
        graphPart = new ExpressionPlots();
        SingleTonData.getInstance().setExpressplot(graphPart);
        //facePart.setBackground(new Color(169, 204, 227));
        //graphPart.setBackground(Color.WHITE);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setResizeWeight(0.3);
        splitPane.setEnabled(false);
        splitPane.setDividerSize(0);
        splitPane.add(facePart);
        splitPane.add(graphPart);
        add(splitPane, BorderLayout.CENTER);
    }
}
