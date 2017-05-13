package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import custom.SampleState;
import objects.math.exp.Exponent;
import objects.math.exp.Root;
import objects.math.expression.ArithmeticOperation;
import objects.math.expression.Expression;
import objects.math.expression.Term;
import objects.math.fraction.Fraction;
import objects.math.sums.Integral;
import objects.math.sums.Sum;
import objects.math.var.Variable;
import ui.display.Application;
import ui.display.Window;
import values.CharValue;
import values.MathValue;
import values.MathValue.MathConstant;
import values.NumValue;

public class Main {

	public static void main(String[] args) {

		Application app = new Application("Integrand - Local", new Dimension(540, 420), Window.Scalability.MAXIMIZED,
				30);
		app.getWindow().setVisible(true);

		CharValue x = new CharValue('x');

		Expression fracDen = new Expression(new Term[] { new Term(x), new Term(new NumValue(2)) },
				new ArithmeticOperation[] { ArithmeticOperation.SUBTRACT });

		Fraction<Root<?, ?>, Expression> frac = new Fraction<>(new Root<>(x, new NumValue(3)), fracDen);

		Expression poly = new Expression(
				new Term[] { new Term(new Exponent<>(x, new NumValue(2))), new Term(new NumValue(4)) },
				new ArithmeticOperation[] { ArithmeticOperation.ADD });

		Expression integ = new Expression(
				new Term(new Integral<>(new Exponent<>(new Root<>(poly, new NumValue(2)), new NumValue(3)),
						new Variable(x), new NumValue(0), new MathValue(MathConstant.PI))));

		Expression sum = new Expression(new Term(new Sum<>(poly, new Variable(new CharValue('n')), new NumValue(0),
				new MathValue(MathConstant.INFINITY))));

		System.out.println(integ.getEquationText());

		TeXFormula tex = new TeXFormula(integ.getEquationText());
		TeXIcon icon = tex.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY).setSize(24).build();

		icon.setInsets(new Insets(0, 0, 0, 0));

		BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = image.createGraphics();
		JLabel jl = new JLabel();
		jl.setForeground(new Color(0, 0, 0));
		icon.paintIcon(jl, g2, 0, 0);

		app.getStateManager().setState(new SampleState("/def.res", image, 540, 420));

	}

}
