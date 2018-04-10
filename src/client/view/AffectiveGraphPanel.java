package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import client.constants.ClientConstants;
import client.model.SingleTonData;
import client.services.AffectiveColorService;

/**
 * This is a part of AffectivePanel UI. This panel is for Graph plot.
 *
 * @author avinash
 */

class AffectiveGraphPanel extends JPanel {

	AffectivePlot affectiveGraphPlot;

	public AffectiveGraphPanel() {
		buildPanel();
	}

	/**
	 * This function constructs a JPanel at the center for graph plot.
	 * 
	 * @return
	 */
	public JPanel buildPanel() {
		setLayout(new BorderLayout());
		setBackground(ClientConstants.LIGHT_YELLOW);
		JLabel graphPlotLabel = new JLabel(ClientConstants.GRAPH_PLOT, JLabel.CENTER);
		graphPlotLabel.setFont(ClientConstants.TEXT_FONT);
		add(graphPlotLabel, BorderLayout.NORTH);
		setLayout(new BorderLayout());
		affectiveGraphPlot = new AffectivePlot();
		SingleTonData.getInstance().setAffectivePlot(affectiveGraphPlot);
		affectiveGraphPlot.setBackground(Color.WHITE);
		add(affectiveGraphPlot);
		return this;
	}

	public void setAffectiveListener(AffectiveColorService affectiveColorService) {
		affectiveGraphPlot.setAffectiveListener(affectiveColorService);
	}

	public void changedisplayLengthLabel() {
		affectiveGraphPlot.changedisplayLengthLabel();
	}
}