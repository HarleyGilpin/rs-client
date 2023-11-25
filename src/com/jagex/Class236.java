package com.jagex;

import java.util.Calendar;

public class Class236
{
	static int anInt2887;
	protected int anInt2888;
	static int anInt2889;
	protected int anInt2890;
	protected int anInt2891 = -1;
	protected boolean aBoolean2892;
	private int anInt2893 = 0;
	protected int anInt2894;
	static int anInt2895;
	protected boolean aBoolean2896;
	protected int anInt2897;
	static Class94 aClass94_2898 = new Class94();
	static Widget[] aWidgetArray2899;
	static int anInt2900;
	protected int anInt2901;
	static int anInt2902;
	
	public static void method3011(boolean bool) {
		if (bool != false) {
			anInt2902 = -1;
		}
		aClass94_2898 = null;
		aWidgetArray2899 = null;
	}
	
	static final boolean method3012(int i, int i_0_, int i_1_) {
		anInt2887++;
		if (i_0_ != 0) {
			return false;
		}
		if (!CacheNode_Sub3.method2296(i_1_, (byte) 109, i) && !Class110.method1135(i, i_1_, false)) {
			return false;
		}
		return true;
	}
	
	private final void method3013(int i, Buffer buffer, int i_2_) {
		anInt2900++;
		if ((~i) == -2) {
			anInt2893 = buffer.method2220(1819759595);
			updateColorComponents(anInt2893, 127);
		} else if ((~i) == -3) {
			anInt2891 = buffer.method2219(-130546744);
			if (anInt2891 == 65535) {
				anInt2891 = -1;
			}
		} else if ((~i) == -4) {
			anInt2894 = buffer.method2219(-130546744) << 2;
		} else if (i != 4) {
			if (i == 5) {
				aBoolean2892 = false;
			}
		} else {
			aBoolean2896 = false;
		}
		int i_3_ = -113 / ((-32 - i_2_) / 58);
	}
	
	final void method3014(Buffer buffer, int i) {
		for (;;) {
			int i_4_ = buffer.method2233(255);
			if ((~i_4_) == -1) {
				break;
			}
			method3013(i_4_, buffer, 108);
		}
		if (i != -1) {
			aBoolean2892 = true;
		}
		anInt2895++;
	}
	
	public Class236() {
		aBoolean2892 = true;
		anInt2894 = 512;
		aBoolean2896 = true;
	}
	
	private void updateColorComponents(int color, int threshold) {
		anInt2889++;

		double redComponent = extractColorComponent(color, 16);
		double greenComponent = extractColorComponent(color, 8);
		double blueComponent = extractColorComponent(color, 0);

		double minComponent = Math.min(redComponent, Math.min(greenComponent, blueComponent));
		double maxComponent = Math.max(redComponent, Math.max(greenComponent, blueComponent));

		double hue = 0.0;
		double saturation = 0.0;
		double lightness = (minComponent + maxComponent) / 2.0;

		if (minComponent != maxComponent) {
			saturation = calculateSaturation(minComponent, maxComponent, lightness);
			hue = calculateHue(redComponent, greenComponent, blueComponent, minComponent, maxComponent);
		}

		anInt2897 = (int) (256.0 * saturation);
		anInt2901 = (int) (lightness * 256.0);
		anInt2890 = calculateAnInt2890(lightness, saturation);

		if (isWinter()) {
			anInt2901 = 255;
			anInt2897 = 255;
		}

		anInt2888 = (int) (hue * anInt2890);

	}

	private int calculateAnInt2890(double lightness, double saturation) {
		if (lightness <= 0.5) {
			return (int) (512.0 * (lightness * saturation));
		} else {
			return (int) (512.0 * ((1.0 - lightness) * saturation));
		}
	}

	private int clampTo255(int value) {
		if (value < 0) {
			return 0;
		} else if (value > 255) {
			return 255;
		} else {
			return value;
		}
	}

	private boolean isWinter() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH); // January = 0, December = 11
		return month == Calendar.NOVEMBER || month == Calendar.DECEMBER;
	}

	private double calculateHue(double redComponent, double greenComponent, double blueComponent, double minComponent, double maxComponent) {
		double hue = 0.0;
		double delta = maxComponent - minComponent;

		if (delta == 0) {
			hue = 0; // achromatic
		} else {
			if (maxComponent == redComponent) {
				hue = (greenComponent - blueComponent) / delta + (greenComponent < blueComponent ? 6 : 0);
			} else if (maxComponent == greenComponent) {
				hue = (blueComponent - redComponent) / delta + 2;
			} else if (maxComponent == blueComponent) {
				hue = (redComponent - greenComponent) / delta + 4;
			}
			hue /= 6;
		}
		return hue;
	}

	private double extractColorComponent(int color, int shift) {
		return ((color >> shift) & 0xff) / 256.0;
	}

	private double calculateSaturation(double minComponent, double maxComponent, double lightness) {
		if (lightness < 0.5) {
			return (maxComponent - minComponent) / (minComponent + maxComponent);
		} else {
			return (maxComponent - minComponent) / (2.0 - maxComponent - minComponent);
		}
	}
}


