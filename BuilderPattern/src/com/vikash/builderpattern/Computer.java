package com.vikash.builderpattern;

/**
 * Computer class to define ram size and memory size.
 */
public class Computer {

	// Mandatory
	private int ramSizeInGb;
	private int memorySizeInGb;

	// Optional
	private boolean hasBluethoot;
	private boolean hasInBuiltMonitor;

	private Computer(ComputerBuilder computerBuilder) {
		this.ramSizeInGb = computerBuilder.ramSizeInGb;
		this.memorySizeInGb = computerBuilder.memorySizeInGb;
		this.hasBluethoot = computerBuilder.hasBluethoot;
		this.hasInBuiltMonitor = computerBuilder.hasInBuiltMonitor;

	}

	public int getRamSizeInGb() {
		return ramSizeInGb;
	}

	public void setRamSizeInGb(int ramSizeInGb) {
		this.ramSizeInGb = ramSizeInGb;
	}

	public int getMemorySizeInGb() {
		return memorySizeInGb;
	}

	public void setMemorySizeInGb(int memorySizeInGb) {
		this.memorySizeInGb = memorySizeInGb;
	}

	public boolean isHasBluethoot() {
		return hasBluethoot;
	}

	public void setHasBluethoot(boolean hasBluethoot) {
		this.hasBluethoot = hasBluethoot;
	}

	public boolean isHasInBuiltMonitor() {
		return hasInBuiltMonitor;
	}

	public void setHasInBuiltMonitor(boolean hasInBuiltMonitor) {
		this.hasInBuiltMonitor = hasInBuiltMonitor;
	}

	/**
	 * Builder class to set optional parameter to create a object of 
	 * Computer class.
	 */
	public static class ComputerBuilder {
		// Mandatory
		private int ramSizeInGb;
		private int memorySizeInGb;

		// Optional
		private boolean hasBluethoot;
		private boolean hasInBuiltMonitor;
		
		public ComputerBuilder(int ramSize, int memorySize) {
			this.ramSizeInGb = ramSize;
			this.memorySizeInGb = memorySize;
		}
		
		public ComputerBuilder setHasBluethoot(boolean hasBluethoot) {
			this.hasBluethoot = hasBluethoot;
			return this;
		}
		
		public ComputerBuilder setHasInBuiltMonitor(boolean hasInBuiltMonitor) {
			this.hasInBuiltMonitor = hasInBuiltMonitor;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}
	}

	@Override
	public String toString() {
		return "Computer [ramSizeInGb=" + ramSizeInGb + ", memorySizeInGb=" + memorySizeInGb + ", hasBluethoot="
				+ hasBluethoot + ", hasInBuiltMonitor=" + hasInBuiltMonitor + "]";
	}
	
	

}
