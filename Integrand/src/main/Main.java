package main;

import java.awt.Dimension;

import custom.SampleState;
import ui.display.ScalableApplication;
import ui.display.ScalableWindow;

public class Main {

	public static void main(String[] args) {

		ScalableApplication app = new ScalableApplication("Integrand - Local", new Dimension(540, 420), ScalableWindow.Scalability.MAXIMIZED,
				30);
		app.getWindow().setVisible(true);

		app.getStateManager().setState(new SampleState("/def.res", 540, 420, app.getScale()));

	}

}
