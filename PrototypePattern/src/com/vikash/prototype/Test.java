package com.vikash.prototype;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {

		PrototypeDesign design = new PrototypeDesign();
		design.setiPOfServer("192.44.44.11");
		design.setNameOfSever("vikash work server : 1");
		design.loadDataFromServer();

		System.out.println(design);

		PrototypeDesign design1 = (PrototypeDesign) design.clone();
		System.out.println(design1);

	}

}
