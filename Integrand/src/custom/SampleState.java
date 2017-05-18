package custom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import handlers.input.InputHandler;
import states.State;
import ui.components.ScalableButton;
import ui.components.ScalableTextbox;
import ui.graphics.ScalableCircle;
import ui.graphics.ScalablePolygon;
import ui.graphics.ScalableText;
import ui.space.Point2D;
import ui.style.ColorStyle;
import ui.style.TextStyle;

public class SampleState extends State {

	BufferedImage logo;

	ScalablePolygon profileBar;

	ScalableCircle displayPoly;
	BufferedImage displayPicture;
	ScalableText name;

	ScalablePolygon problemBox, answerBox, previewBox;
	ScalableText problemLabel, answerLabel, previewLabel;

	ScalableCircle[][] points;

	ScalableText problemText;
	BufferedImage expression;

	ScalableTextbox answerTextBox;

	BufferedImage ansPreview;
	boolean imageReady = false;

	ScalableButton submitAnswerBtn, btn2;
	
	BufferedImage bell, download;

	public SampleState(String src, int width, int height, int scale) {
		super(src, scale);

		logo = this.getResourceHandler().getImage("logo");

		profileBar = new ScalablePolygon(
				new Point2D[] { new Point2D(0, 0), new Point2D(width, 0), new Point2D(width, 40), new Point2D(0, 40) },
				new ColorStyle(new Color(80, 80, 80), new Color(120, 120, 120)), getScale());

		Font romanReg = getResourceHandler().getFont("roman-reg").deriveFont(12L);
		Font romanBold = getResourceHandler().getFont("roman-bold").deriveFont(12L);
		Font roboto = getResourceHandler().getFont("roboto").deriveFont(12L);

		String nameString = "Chandra Gummaluru";

		name = new ScalableText(nameString, new Point2D(width - 125, 24), new TextStyle(romanReg, Color.WHITE),
				getScale());

		displayPoly = new ScalableCircle(new Point2D(width - 155, 8), 24,
				new ColorStyle(new Color(240, 240, 240), new Color(230, 230, 230)), getScale());

		displayPicture = new BufferedImage(2 * displayPoly.getRadius() * getScale(),
				2 * displayPoly.getRadius() * getScale(), BufferedImage.TYPE_INT_ARGB);
		Graphics displayPictureGraphics = displayPicture.getGraphics();

		displayPictureGraphics.setClip(
				new Ellipse2D.Float(0, 0, displayPoly.getRadius() * getScale(), displayPoly.getRadius() * getScale()));

		displayPictureGraphics.drawImage(getResourceHandler().getImage("display_pic"), 0, 0, null);
		// displayPicture = getResourceHandler().getImage("display_pic");

		// problem information.

		problemLabel = new ScalableText("Problem 1", new Point2D(30, 80), new TextStyle(romanBold, Color.BLACK),
				getScale());

		problemText = new ScalableText(getResourceHandler().getText("problem"), new Point2D(30, 94),
				new TextStyle(romanReg, Color.BLACK), getScale());

		problemBox = new ScalablePolygon(
				new Point2D[] { new Point2D(20, 60), new Point2D(width - 20, 60), new Point2D(width - 20, 160),
						new Point2D(20, 160) },
				new ColorStyle(new Color(250, 250, 250, 120), new Color(220, 220, 220)), getScale());

		TeXIcon icon = new TeXFormula(getResourceHandler().getText("eq")).createTeXIcon(TeXConstants.STYLE_DISPLAY, 24);
		icon.setInsets(new Insets(0, 0, 0, 0));

		expression = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D expressionGraphics = expression.createGraphics();
		icon.paintIcon(null, expressionGraphics, 0, 0);

		answerBox = new ScalablePolygon(
				new Point2D[] { new Point2D(20, 180), new Point2D((width / 2 - 10), 180),
						new Point2D((width / 2 - 10), 240), new Point2D(20, 240) },
				new ColorStyle(new Color(250, 250, 250, 150), new Color(220, 220, 220)), getScale());

		answerLabel = new ScalableText("Answer", new Point2D(30, 200), new TextStyle(romanBold, Color.BLACK),
				getScale());

		previewBox = new ScalablePolygon(
				new Point2D[] { new Point2D(width / 2 - 10, 180), new Point2D((width - 120), 180),
						new Point2D((width - 120), 240), new Point2D(width / 2 - 10, 240) },
				new ColorStyle(new Color(250, 250, 250, 150), new Color(220, 220, 220)), getScale());

		previewLabel = new ScalableText("Answer Preview", new Point2D(width / 2, 200),
				new TextStyle(romanBold, Color.BLACK), getScale());

		points = new ScalableCircle[27][21];

		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < 21; j++) {
				points[i][j] = new ScalableCircle(new Point2D(20 * i, 20 * j), 1,
						new ColorStyle(new Color(220, 220, 220), new Color(220, 220, 220)), getScale());
			}
		}

		ScalablePolygon btnRect = new ScalablePolygon(
				new Point2D[] { new Point2D(20, 260), new Point2D(140, 260), new Point2D(140, 280),
						new Point2D(20, 280) },
				new ColorStyle(new Color(240, 240, 240), new Color(210, 210, 210)), getScale());

		submitAnswerBtn = new ScalableButton(btnRect,
				new ColorStyle(new Color(240, 240, 240), new Color(210, 210, 210)),
				new ColorStyle(new Color(230, 230, 230), new Color(210, 210, 210)),
				new ColorStyle(new Color(180, 180, 180), new Color(140, 140, 140)), "Submit Answer", new TextStyle(romanBold, Color.BLACK));

		ScalablePolygon btnRect2 = new ScalablePolygon(
				new Point2D[] { new Point2D(140, 260), new Point2D(260, 260), new Point2D(260, 280),
						new Point2D(140, 280) },
				new ColorStyle(new Color(240, 240, 240), new Color(210, 210, 210)), getScale());

		btn2 = new ScalableButton(btnRect2, new ColorStyle(new Color(240, 240, 240), new Color(210, 210, 210)),
				new ColorStyle(new Color(230, 230, 230), new Color(210, 210, 210)),
				new ColorStyle(new Color(180, 180, 180), new Color(140, 140, 140)), "Check Answer", new TextStyle(romanBold, Color.BLACK));

		answerTextBox = new ScalableTextbox(new Point2D(30, 210), 180, 20,
				new ColorStyle(new Color(240, 240, 240), new Color(210, 210, 210)),
				new ColorStyle(new Color(255, 255, 255), new Color(140, 140, 140)),
				new TextStyle(roboto, new Color(160, 160, 160)), new TextStyle(roboto, new Color(60, 60, 60)), 10,
				getScale());
		
		bell = getResourceHandler().getImage("bell");
		download = getResourceHandler().getImage("download");
	}

	@Override
	public void tick() {
		try {
			// create the formula and icon from the answer text.
			TeXIcon icon = new TeXFormula(answerTextBox.getText()).createTeXIcon(TeXConstants.STYLE_DISPLAY, 24);
			icon.setInsets(new Insets(0, 0, 0, 0));

			// create the image.
			ansPreview = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);

			// draw the image.
			Graphics2D ansGraphics = ansPreview.createGraphics();
			icon.paintIcon(null, ansGraphics, 0, 0);

			imageReady = true;
		} catch (Exception e) {
			// do nothing.
			imageReady = false;
		}

	}

	@Override
	public void handleInput(InputHandler m) {
		submitAnswerBtn.handleInput(m);
		btn2.handleInput(m);

		answerTextBox.handleInput(m);
	}

	@Override
	public void draw(Graphics2D g) {

		for (ScalableCircle[] row : points) {
			for (ScalableCircle point : row) {
				point.draw(g);
			}
		}

		problemBox.draw(g);
		answerBox.draw(g);
		previewBox.draw(g);

		problemLabel.draw(g);
		problemText.draw(g);

		if (expression != null) {
			g.drawImage(expression, 50, 210, null);
		}

		if (ansPreview != null && imageReady) {
			g.drawImage(ansPreview, 540, 410, null);
		}

		answerLabel.draw(g);
		previewLabel.draw(g);

		profileBar.draw(g);

		g.drawImage(logo, 20, 25, null);

		name.draw(g);
		displayPoly.draw(g);

		if (displayPicture != null) {
			g.drawImage(displayPicture, (int) displayPoly.getCentroid().getX() * getScale(),
					(int) displayPoly.getCentroid().getY() * getScale(), null);
		}

		submitAnswerBtn.draw(g);
		btn2.draw(g);
		
		if (bell != null) {
			g.drawImage(bell, 700, 18, null);
		}
		
		if (download != null) {
			g.drawImage(download, 970, 250, null);
		}

		answerTextBox.draw(g);
	}
}
