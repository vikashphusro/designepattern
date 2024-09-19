package com.vikash.prototype;

public class PrototypeDesign implements Cloneable {

	private String nameOfSever;
	private String iPOfServer;

	public String getNameOfSever() {
		return nameOfSever;
	}

	public void setNameOfSever(String nameOfSever) {
		this.nameOfSever = nameOfSever;
	}

	public String getiPOfServer() {
		return iPOfServer;
	}

	public void setiPOfServer(String iPOfServer) {
		this.iPOfServer = iPOfServer;
	}

	public void loadDataFromServer() {
		System.out.println("Load huge data from server.");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			System.out.println(String.valueOf(e.toString()));
		}

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "PrototypeDesign [nameOfSever=" + nameOfSever + ", iPOfServer=" + iPOfServer + "]";
	}

}
