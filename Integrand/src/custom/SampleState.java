package custom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import handlers.input.InputHandler;
import states.State;
import ui.components.Button;
import ui.components.Textbox;
import ui.graphics.Circle;
import ui.graphics.Polygon;
import ui.graphics.Style;
import ui.graphics.Text;
import ui.space.Point;

public class SampleState extends State {

	BufferedImage logo;

	Polygon profileBar;

	Circle displayImage;
	Text name;

	Polygon mathBox, answerBox;

	Circle[][] points;

	Text description;
	Text problem;
	BufferedImage formula;

	Text answerLabel;

	Textbox t;

	Button<?> btn1, btn2;

	public SampleState(String src, BufferedImage b, int width, int height) {
		super(src);

		this.formula = b;

		logo = this.getResourceHandler().getImage("logo");

		profileBar = new Polygon(
				new Point[] { new Point(0, 0), new Point(width, 0), new Point(width, 40), new Point(0, 40) },
				new Color(80, 80, 80), new Color(80, 80, 80));

		Font romanReg = getResourceHandler().getFont("roman-reg").deriveFont(12L);
		Font romanBold = getResourceHandler().getFont("roman-bold").deriveFont(12L);

		String nameString = "Chandra Gummaluru";

		name = new Text(nameString, new Point(width - 145, 24), romanReg, Color.WHITE);

		displayImage = new Circle(new Point(width - 175, 8), 24, new Color(240, 240, 240), new Color(230, 230, 230));

		problem = new Text("Problem 1", new Point(30, 80), romanBold, Color.BLACK);

		description = new Text("Determine the value of the following integral using a trigonometric substitution:",
				new Point(30, 94), romanReg, Color.BLACK);

		mathBox = new Polygon(new Point[] { new Point(20, 60), new Point(width - 20, 60), new Point(width - 20, 160),
				new Point(20, 160) }, new Color(250, 250, 250, 120), new Color(220, 220, 220));

		answerBox = new Polygon(new Point[] { new Point(20, 180), new Point((width / 2 - 10), 180),
				new Point((width / 2 - 10), 240), new Point(20, 240) }, new Color(250, 250, 250, 150),
				new Color(220, 220, 220));

		answerLabel = new Text("Answer", new Point(30, 200), romanBold, Color.BLACK);

		points = new Circle[27][21];

		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < 21; j++) {
				points[i][j] = new Circle(new Point(20 * i, 20 * j), 1, new Color(220, 220, 220),
						new Color(220, 220, 220));
			}
		}

		Polygon btnRect = new Polygon(
				new Point[] { new Point(20, 260), new Point(140, 260), new Point(140, 280), new Point(20, 280) },
				new Color(240, 240, 240), new Color(210, 210, 210));

		btn1 = new Button<>(btnRect,
				new Style[] { new Style(new Color(240, 240, 240), new Color(210, 210, 210)),
						new Style(new Color(230, 230, 230), new Color(210, 210, 210)),
						new Style(new Color(180, 180, 180), new Color(140, 140, 140)) });

		Polygon btnRect2 = new Polygon(
				new Point[] { new Point(140, 260), new Point(260, 260), new Point(260, 280), new Point(140, 280) },
				new Color(240, 240, 240), new Color(210, 210, 210));

		btn2 = new Button<Polygon>(btnRect2,
				new Style[] { new Style(new Color(240, 240, 240), new Color(210, 210, 210)),
						new Style(new Color(230, 230, 230), new Color(210, 210, 210)),
						new Style(new Color(180, 180, 180), new Color(140, 140, 140)) });

		t = new Textbox(new Point(50, 50), 100, 40,
				new Style[] { new Style(new Color(240, 240, 240), new Color(210, 210, 210)),
						new Style(new Color(180, 180, 180), new Color(140, 140, 140)) },
				new Style(Color.BLACK, romanReg));
	}

	@Override
	public void tick() {

	}

	@Override
	public void handleInput(InputHandler m) {
		btn1.handleInput(m);
		btn2.handleInput(m);

		t.handleInput(m);
	}

	@Override
	public void draw(Graphics2D g) {

		for (Circle[] row : points) {
			for (Circle point : row) {
				point.draw(g);
			}
		}

		mathBox.draw(g);
		answerBox.draw(g);

		problem.draw(g);
		description.draw(g);

		if (formula != null) {
			g.drawImage(formula, 50, 210, null);
		}

		answerLabel.draw(g);

		profileBar.draw(g);

		g.drawImage(logo, 20, 25, null);

		name.draw(g);
		displayImage.draw(g);

		btn1.draw(g);
		btn2.draw(g);
		
		t.draw(g);
	}
}
