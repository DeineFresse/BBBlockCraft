package bb.mods.bbbc.world.gen.structure;

public class Structure {

	enum Structuren {
		HOLLOWRECTANGLE, FILLEDRECTANGLE, WALL, BLOCK
	}

	private Structuren type;
	private int xCoord;
	private int yCoord;
	private int zCoord;
	private int[] values;

	public Structure(Structuren a, int x, int y, int z, int... b) {
		type = a;
		values = b;
		xCoord = x;
		yCoord = y;
		zCoord = y;

	}

	public int getXCoord() {
		return xCoord;
	}

	public int getYCoord() {
		return yCoord;
	}

	public int getZCoord() {
		return zCoord;
	}

	public Object getStructure() throws Exception {
		switch (type) {
		case BLOCK:
			return new Structure(type, xCoord, yCoord, zCoord, values);
		case FILLEDRECTANGLE:
			return filledRectangle();
		case HOLLOWRECTANGLE:
			return hollowRectangle();
		case WALL:
			return wall();
		default:
			throw new Exception("Missing/Wrong Enum type!");
		}
	}

	public Enum<Structuren> getType() {
		return type;
	}

	private Structure[] hollowRectangle() throws Exception {
		if (values.length < 3) {
			throw new Exception(
					"Missing Arguments,not enought to make a Rectangle!/n Needed at least 3 got "
							+ values.length);
		}
		Structure[] a = new Structure[2 * (values[0] + values[1])];
		int m = 0;
		for (int i = 0; i < values[0]; i++, m++) {
			if (values.length > 3) {
				a[m] = new Structure(Structuren.BLOCK, xCoord + i, yCoord,
						zCoord, values[2], values[3]);
				a[m] = new Structure(Structuren.BLOCK, xCoord + i, yCoord,
						zCoord + values[1], values[2], values[3]);
			} else {
				a[m] = new Structure(Structuren.BLOCK, xCoord + i, yCoord,
						zCoord, values[2]);
				a[m] = new Structure(Structuren.BLOCK, xCoord + i, yCoord,
						zCoord + values[1], values[2]);
			}
		}
		for (int i = 0; i <values[1]; i++, m++) {
			if (values.length > 3) {
				a[m] = new Structure(Structuren.BLOCK, xCoord, yCoord,
						zCoord+i, values[2], values[3]);
				a[m] = new Structure(Structuren.BLOCK, xCoord + values[0], yCoord,
						zCoord + i, values[2], values[3]);
			} else {
				a[m] = new Structure(Structuren.BLOCK, xCoord, yCoord,
						zCoord + i, values[2]);
				a[m] = new Structure(Structuren.BLOCK, xCoord +values[0], yCoord,
						zCoord + i, values[2]);
			}
		}
		return a;
	}

	private Structure[] filledRectangle() throws Exception {
		if (values.length < 3) {
			throw new Exception(
					"Missing Arguments,not enought to make a Rectangle!/n Needed at least 3 got "
							+ values.length);
		}
		Structure[] a = new Structure[values[0] * values[1]];
		int m = 0;
		for (int i = 0; i < values[0]; i++, m++) {
			for (int ii = 0; ii < values[1]; ii++, m++) {
				if (values.length > 3) {
					a[m] = new Structure(Structuren.BLOCK, xCoord + i, yCoord,
							zCoord + ii, values[2], values[3]);
				} else {
					a[m] = new Structure(Structuren.BLOCK, xCoord + i, yCoord,
							zCoord + ii, values[2]);
				}
			}
		}

		return a;
	}

	private Structure[] wall() throws Exception {
		if (values.length < 4) {
			throw new Exception(
					"Missing Arguments,not enought to make a Wall!/n Needed at least 4 got "
							+ values.length);
		}	
		
		return null;
	}

}
