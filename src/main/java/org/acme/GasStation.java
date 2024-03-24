package org.acme;

public class GasStation {
    private int id;
    private int xCoordinate;
    private int yCoordinate;
    private int pricePerLiter;

    // Constructors, getters and setters

    public GasStation(int id, int xCoordinate, int yCoordinate, int pricePerLiter) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.pricePerLiter = pricePerLiter;
    }

    public GasStation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

   public int getyCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(int pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }
}
