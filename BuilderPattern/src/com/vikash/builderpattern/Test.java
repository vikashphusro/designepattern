package com.vikash.builderpattern;

public class Test {

	public static void main(String[] args) {

		Computer computer1 = new Computer.ComputerBuilder(16, 1024)
				.setHasBluethoot(false).setHasInBuiltMonitor(true).build();
		System.out.println(computer1);
		
		Computer computer2 = new Computer.ComputerBuilder(32, 1024)
				.setHasBluethoot(false).setHasInBuiltMonitor(false).build();
		System.out.println(computer2);
		
	}

}
